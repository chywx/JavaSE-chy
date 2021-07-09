package cn.year2021.interview;

/**
 * @author chy
 * @date 2021年07月09日 下午 16:26
 * 2. 5，3，-7，2，-1，6，8 连续子串相加最大的和
 */
public class 连续子串相加最大的和 {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 3, -7, 2, -1, 6, 8};

        int length = arr.length;

        for (int i = 0; i < length; i++) {
            exec(i, arr);
            System.out.println("============");
        }

    }

    public static void exec(int index, int[] arr) {
        for (int i = index; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                System.out.print(arr[j] + "\t");
            }
            System.out.println();
        }
    }

}
