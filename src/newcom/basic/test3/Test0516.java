package newcom.basic.test3;

public class Test0516 {
    public static void main(String[] args) {
        System.out.println(f(2));
    }

    public static int f(int i) {
        int sum = 0;
        switch (i) {
            case 1:
                sum = sum + 1;
            case 2:
                sum = sum + 1 * 2;
            default:
                sum = sum + 1 * 3;
        }
        return sum;
    }

}
