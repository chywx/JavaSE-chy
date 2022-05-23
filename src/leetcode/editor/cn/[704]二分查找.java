package leetcode.editor.cn;//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。 
//
// 
//示例 1: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
// 
//
// 示例 2: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设 nums 中的所有元素是不重复的。 
// n 将在 [1, 10000]之间。 
// nums 的每个元素都将在 [-9999, 9999]之间。 
// 
// Related Topics 数组 二分查找 
// 👍 407 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution704 {

    public static void main(String[] args) {
        Solution704 solution704 = new Solution704();
//        int[] arr = {2, 5};
        int[] arr = {-1, 0, 5};
//        int[] arr = {2};
//        int[] arr = {-1, 0, 3, 5, 9, 12};

//        int search = solution.search2(arr, 5);
//        System.out.println(search);

        int search = solution704.search(arr, -1);
        System.out.println(search);
    }

    public int search(int[] nums, int target) {

        return aaa(nums, target, 0, nums.length - 1);
    }

    private int aaa(int[] nums, int target, int start, int end) {

        if (start > end) {
//            if (nums[start] == target) {
//                return start;
//            }
            return -1;
        }
        int middle = (start + end) / 2;
        if (nums[middle] < target) {
            return aaa(nums, target, middle + 1, end);
        } else if (nums[middle] > target) {
            return aaa(nums, target, start, middle - 1);
        } else {
            return middle;
        }

    }


    public int search2(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (true) {
            int middle = (start + end) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] < target) {
                start = middle + 1;
            }
            if (nums[middle] > target) {
                end = middle;
            }
            if (start == end) {
                if (nums[start] == target) {
                    return start;
                } else {
                    return -1;
                }
            }
            if (start > end) {
                return -1;
            }
        }
    }

//    public int binary(int[] nums,int target,int start,int end){
//        int middle = (start + end) /2 ;
//
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
