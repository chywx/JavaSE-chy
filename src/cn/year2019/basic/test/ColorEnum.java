package cn.year2019.basic.test;

/**
 * 功能描述
 *
 * @author chy
 * @date 2019/7/27 0027
 */
public enum  ColorEnum {
    RED("红色",1),GREEN("绿色",2),WHITE("白色",3),YELLOW("黄色",4);
    //成员变量
    private String name;
    private int index;
    //构造方法
    private ColorEnum(String name,int index)
    {
        this.name=name;
        this.index=index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static Integer parse(String string){
        ColorEnum[] values = ColorEnum.values();
        for (ColorEnum value : values) {
            if(value.name.equals(string)){
                return value.index;
            }else{
                return 0;
            }
        }
        return null;
    }

    //覆盖方法
    @Override
    public String toString()
    {
        return this.index+"-"+this.name;
    }

    public static void main(String[] args) {
        String s = "红色";
        Integer parse = ColorEnum.parse(s);
        System.out.println(parse);

    }
}
