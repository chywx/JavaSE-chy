package com.equals;


import java.util.ArrayList;

/**
 * > https://www.cnblogs.com/smyhvae/p/3929585.html
 * > 基本类型 == 比较的是值
 * > 引用类型，== 比较的是地址值。
 * > equals 是object方法里面的，==默认比较的也是地址值==，但是一些库重写了equals方法，导致比较的是值。
 */
public class TestEquals {
    public static void main(String[] args) {
        Integer integer = 1;
        Integer integer2 = 1;
        System.out.println(integer == integer2);
        System.out.println(integer.equals(integer2));

        Integer integer3 = new Integer(2);
        Integer integer4 = new Integer(2);
        System.out.println(integer3 == integer4);

        System.out.println(integer3.equals(integer4));

        String string = "aa";
        String string2 = "aa";
        System.out.println(string == string2);
        System.out.println(string.equals(string2));

        String string3 = new String("bb");
        String string4 = new String("bb");
        System.out.println(string3 == string4);
        System.out.println(string3.equals(string4));

        AdviceJson adviceJson1 = new AdviceJson();
        AdviceJson adviceJson2 = new AdviceJson();
        System.out.println(adviceJson1 == adviceJson2);
        // 如果对象重写equals的话是相等的，hashcode方法写不写都行，但是对应到hashmap或者hashset就会有问题了，因为equals相等但是hashcode不相等
        // 可见一般重写了equals之后是需要重写hashcode的。
        System.out.println(adviceJson1.equals(adviceJson2));

        System.out.println("-----------");
        ArrayList<AdviceJson> list = new ArrayList<>();

        AdviceJson json = new AdviceJson();
        json.setEvaluateContent("123");
        list.add(json);
        System.out.println(list.contains(json));

        AdviceJson json2 = new AdviceJson();
        json2.setEvaluateContent("123");
        // 重写equals的话会返回true。
        System.out.println(list.contains(json2));

    }
}

class AdviceJson{
    private String evaluateContent;
    private String evaluateTags;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdviceJson that = (AdviceJson) o;

        if (evaluateContent != null ? !evaluateContent.equals(that.evaluateContent) : that.evaluateContent != null)
            return false;
        return evaluateTags != null ? evaluateTags.equals(that.evaluateTags) : that.evaluateTags == null;
    }

    @Override
    public int hashCode() {
        int result = evaluateContent != null ? evaluateContent.hashCode() : 0;
        result = 31 * result + (evaluateTags != null ? evaluateTags.hashCode() : 0);
        return result;
    }

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent;
    }

    public String getEvaluateTags() {
        return evaluateTags;
    }

    public void setEvaluateTags(String evaluateTags) {
        this.evaluateTags = evaluateTags;
    }
}