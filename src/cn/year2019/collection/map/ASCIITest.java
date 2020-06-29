package cn.year2019.collection.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ASCIITest {
    public static void main(String[] args) {

        // 方式一：TreeMap可以自动排序
        TreeMap<String, Object> params = new TreeMap<String, Object>();
        setData(params);

        StringBuilder s1 = new StringBuilder();
        for (String key : params.keySet()) {
            s1.append(key).append("=").append(params.get(key)).append("&");
        }
        s1.deleteCharAt(s1.length() - 1);
        System.out.println(s1);

        //方式二：使用HashMap，并使用Arrays.sort排序
        HashMap<String, Object> params2 = new HashMap<String, Object>();
        setData(params2);
        String[] sortedKeys = params2.keySet().toArray(new String[]{});
        Arrays.sort(sortedKeys);// 排序请求参数
        StringBuilder s2 = new StringBuilder();
        for (String key : sortedKeys) {
            s2.append(key).append("=").append(params2.get(key)).append("&");
        }
        s2.deleteCharAt(s2.length() - 1);
        System.out.println(s2);

        System.out.println(s1.toString().equals(s2.toString()));


    }

    private static void setData(Map<String, Object> params) {
        params.put("Nonce", 11886);
        params.put("Timestamp", 1465185768);
        params.put("SecretId", "AKIDz8krbsJ5yKBZQpn74WFkmLPx3EXAMPLE");
        params.put("Action", "DescribeInstances");
        params.put("Version", "2019-05-15");
        params.put("Region", "ap-guangzhou");
        params.put("Limit", 20);
        params.put("Offset", 0);
        params.put("测试", "测试");
    }
}
