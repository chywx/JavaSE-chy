package cn.year2020.se;

/**
 * 二分查找
 *
 * @author chy
 * @date 2020/6/16 0016
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 7, 8};
        System.out.println(find(arr, 4));
    }

    public static int find(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }
        while (low <= high) {
            int middle = (low + high) / 2;
            int value = arr[middle];
            if (value == key) {
                return middle;
            } else if (middle > key) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

}
