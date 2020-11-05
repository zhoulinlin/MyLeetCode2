import java.util.Arrays;

/**
 * 16. 3Sum Closest
 *
 * Given an array nums of n integers and an integer target,
 * find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Example 1:
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * Constraints:
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 */
public class _16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int re = nums[0] + nums[nums.length-1] + nums[nums.length-2];
        int t,pre = nums[0];

        for(int i=0; i < nums.length-2 ;i++){
            if( i > 0 && pre == nums[i]){
                continue;
            }

            t = findsum(i+1,nums.length-1,target-nums[i],nums);
            if(t + nums[i] == target){
                return target;
            }

            if(Math.abs(t+nums[i]-target)<Math.abs(re-target)){
                re = t+nums[i];
            }

            pre = nums[i];
        }

        return re;
    }


    private int findsum(int left,int right, int sum,int[] nums){

        int min = nums[left] + nums[right];
        int temp;

        while (left < right){
            temp = nums[left] + nums[right];

            if(Math.abs(sum-temp) < Math.abs(sum-min)){
                min = temp;
            }

            if(nums[left] + nums[right] < sum){
                left++;
            }else if(nums[left] + nums[right] > sum){
                right--;
            }else {
                return sum;
            }
        }
        return min;
    }
}













