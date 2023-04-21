package leetcode.editor.cn;//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j !=
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请 
//
// 你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 双指针 排序 👍 5400 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution15 {

    public static void main(String[] args) {
//        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
//        System.out.println(new Solution().threeSum(new int[]{-2, 0, 1, 1, 2}));
        System.out.println(new Solution15().threeSum(new int[]{-4, -1, -1, 0, 1, 2}));
    }

    // 再次尝试
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        if (nums.length < 3) {
            return list;
        }

        // 提示说是让用双指针
        // 定义左右指针，当左大于或者等于右指针时结束
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // 去重
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int target = -nums[i];

                if (nums[left] + nums[right] < target) {
                    left++;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++; // 去重
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--; // 去重
                    }
                    left++;
                    right--;
                }
            }

        }
        return list;

    }

    // 超时了
    public List<List<Integer>> threeSum2(int[] nums) {

        Set<List<Integer>> list = new HashSet<>();


        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        boolean flat = false;

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                continue;
            }
//            b:
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> integers = new ArrayList<>();
                        integers.add(nums[i]);
                        integers.add(nums[j]);
                        integers.add(nums[k]);
                        list.add(integers);
//                        break b
                    }

                }
            }

        }
        return new ArrayList<>(list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
