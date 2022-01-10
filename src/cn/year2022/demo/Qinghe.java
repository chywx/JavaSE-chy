package cn.year2022.demo;

public class Qinghe {

    public static void main(String[] args) {
        Qinghe qinghe = new Qinghe();
        qinghe.numberReverse1(1234);
    }

    public void numberReverse1(int num) {
        while (num != 0) {
            int a = num % 10;
            System.out.print(a);
            num = num / 10;
        }
    }

}
