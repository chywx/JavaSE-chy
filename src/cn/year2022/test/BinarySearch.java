package cn.year2022.test;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(new BinarySearch().search1(new int[]{1, 2, 3, 4, 5, 6}, 4));
        System.out.println(new BinarySearch().search2(new int[]{1, 2, 3, 4, 5, 6}, 4));
    }

    public int search1(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            int middleValue = arr[middle];
            if (target == middleValue) {
                return middle;
            }
            if (target > middleValue) {
                left = middle + 1;
            }
            if (target < middleValue) {
                right = middle;
            }
        }
        return -1;
    }

    public int search2(int[] arr, int target) {
        return re(arr, target, 0, arr.length - 1);
    }

    public int re(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        int middleValue = arr[middle];
        if (target == middleValue) {
            return middle;
        } else if (target > middleValue) {
            return re(arr, target, middle + 1, right);
        } else {
            return re(arr, target, left, middle);
        }
    }

}
