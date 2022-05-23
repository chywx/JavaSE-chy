package cn.year2022.demo;

public class HeChaXY {

    public static void main(String[] args) {
        calc(5, 1);
    }

    public static void calc(Integer sum, Integer diff) {
        int x = 0;
        int y = sum;

        while (x < y) {
            if (y - x == diff) {
                System.out.println("x: " + x);
                System.out.println("y: " + y);
                break;
            }
            x++;
            y--;
        }

    }

}
