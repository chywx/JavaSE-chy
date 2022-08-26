package cn.year2022.demo;

import java.util.UUID;

/**
 * @author: Dylan
 * @date: 2022/7/25 17:10
 */
public class Stock {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("if (redis.call('exists', KEYS[1]) == 1) then");
        sb.append("    local stock = tonumber(redis.call('get', KEYS[1]));");
        sb.append("    if (stock == -1) then");
        sb.append("        return 1;");
        sb.append("    end;");
        sb.append("    if (stock > 0) then");
        sb.append("        redis.call('incrby', KEYS[1], -1);");
        sb.append("        return stock;");
        sb.append("    end;");
        sb.append("    return 0;");
        sb.append("end;");
        sb.append("return -1;");

        System.out.println(sb.toString());

        System.out.println("992f34796633106ad0664613a9d1fc65f39ae5bae4302bd5d2343480");
        System.out.println("992f34796633106ad0664613a9d1fc65f39ae5bae4302bd5d2343480".length());
        System.out.println("7275124adf1d806919bbbb46ed5e1404d3002d27a3013eedacea62f33c5447ec");
        System.out.println("7275124adf1d806919bbbb46ed5e1404d3002d27a3013eedacea62f33c5447ec".length());
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
        System.out.println(UUID.randomUUID().toString().replace("-", "").length());
    }

}
