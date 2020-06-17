package leetcode.editor.cn;//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表


import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1 {

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int[] ints = twoSum(arr, 9);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

        newTwoSum(arr, 22);
    }


    public static int[] twoSum(int[] nums, int target) {
        int[] ints = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ints[0] = i;
                    ints[1] = j;
                }
            }
        }
        return ints;
    }

    public static int[] newTwoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            int value = target - nums[i];
            Integer integer = map.get(value);
            if (integer != null && integer != i) {
                System.out.println(integer + "---" + i);
            }
        }

        return nums;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
