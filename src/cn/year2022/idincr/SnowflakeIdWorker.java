package cn.year2022.idincr;

public class SnowflakeIdWorker {

    /**
     * 起始的时间戳,2020-01-01 00:00:00
     */
    private final static long START_TIMESTAMP = 1577808000000L;

    /**
     * 数据中心占用的位数
     */
    private final static long DATACENTER_ID_BIT = 5;

    /**
     * 工作机器标识占用的位数
     */
    private final static long WORKER_ID_BIT = 5;

    /**
     * 序列号占用的位数
     */
    private final static long SEQUENCE_BIT = 12;

    /**
     * 支持的数据中心最大值
     */
    private final static long MAX_DATACENTER_ID = ~(-1L << DATACENTER_ID_BIT);

    /**
     * 支持的工作机器标识最大值
     */
    private final static long MAX_WORKER_ID = ~(-1L << WORKER_ID_BIT);

    /**
     * 支持的序列号最大值
     */
    private final static long MAX_SEQUENCE = ~(-1L << SEQUENCE_BIT);

    /**
     * 工作机器标识向左移12位
     */
    private final static long WORKER_ID_LEFT = SEQUENCE_BIT;

    /**
     * 数据中心向左移(12+5)位
     */
    private final static long DATACENTER_ID_LEFT = SEQUENCE_BIT + WORKER_ID_BIT;

    /**
     * 时间戳向左移(12+5+5)位
     */
    private final static long TIMESTAMP_LEFT = DATACENTER_ID_LEFT + DATACENTER_ID_BIT;

    /**
     * 数据中心
     */
    private final long datacenterId;

    /**
     * 工作机器标识
     */
    private final long workerId;

    /**
     * 序列号
     */
    private long sequence = 0L;

    /**
     * 上一次时间戳
     */
    private long lastTimestamp = -1L;

    /**
     * 构造函数
     *
     * @param datacenterId 数据中心 (0~31)
     * @param workerId 工作机器标识 (0~31)
     */
    public SnowflakeIdWorker(long datacenterId, long workerId) {
        if (datacenterId > MAX_DATACENTER_ID || datacenterId < 0) {
            throw new IllegalArgumentException("datacenterId can't be greater than MAX_DATACENTER_ID or less than 0");
        }
        if (workerId > MAX_WORKER_ID || workerId < 0) {
            throw new IllegalArgumentException("workerId can't be greater than MAX_WORKER_ID or less than 0");
        }
        this.datacenterId = datacenterId;
        this.workerId = workerId;
    }

    /**
     * 获取下一个ID (该方法是线程安全的)
     *
     * @return long SnowflakeId
     */
    public synchronized long nextId() {
        long currentTimestamp = currentTimeMillis();
        //如果当前时间小于上一次ID生成的时间戳，说明系统时钟回退过这个时候应当抛出异常
        if (currentTimestamp < lastTimestamp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        }

        //如果是同一时间生成的，则进行毫秒内序列
        if (currentTimestamp == lastTimestamp) {
            //相同毫秒内，序列号自增
            sequence = (sequence + 1) & MAX_SEQUENCE;
            //同一毫秒的序列数已经达到最大
            if (sequence == 0L) {
                currentTimestamp = nextTimeMillis();
            }
        } else {
            //不同毫秒内，序列号置为0
            sequence = 0L;
        }

        //上次生成ID的时间戳
        lastTimestamp = currentTimestamp;

        //移位并通过或运算拼到一起组成64位的ID
        //时间戳部分
        return (currentTimestamp - START_TIMESTAMP) << TIMESTAMP_LEFT
            //数据中心部分
            | datacenterId << DATACENTER_ID_LEFT
            //工作机器标识部分
            | workerId << WORKER_ID_LEFT
            //序列号部分
            | sequence;
    }

    /**
     * 阻塞到下一个毫秒，直到获得新的时间戳
     *
     * @return 当前时间戳
     */
    private long nextTimeMillis() {
        long mill = currentTimeMillis();
        while (mill <= lastTimestamp) {
            mill = currentTimeMillis();
        }
        return mill;
    }

    /**
     * 返回以毫秒为单位的当前时间
     *
     * @return 当前时间(毫秒)
     */
    private long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        SnowflakeIdWorker snowflake = new SnowflakeIdWorker(2, 3);

        for (int i = 0; i < (1 << 10); i++) {
            System.out.println(snowflake.nextId());
        }
    }

}
