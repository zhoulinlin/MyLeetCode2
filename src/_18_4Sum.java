import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 18. 4Sum
 * Given an array nums of n integers and an integer target,
 * are there elements a, b, c, and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * Notice that the solution set must not contain duplicate quadruplets
 *
 * Example 1:
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * Example 2:
 * Input: nums = [], target = 0
 * Output: []
 *
 * Constraints:
 * 0 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 *
 */
public class _18_4Sum {

    List<List<Integer>> result = new ArrayList<>();
    int cur;

    public List<List<Integer>> fourSum(int[] nums, int target) {

        if(nums == null || nums.length <= 3){
            return result;
        }

        Arrays.sort(nums);
        for(int i=0;i < nums.length-1;i++){
            if( i > 0 && nums[i-1] == nums[i]){
                continue;
            }
            cur = nums[i];

            threeSum(i+1,nums,target-nums[i]);
        }

        return result;
    }


    public void threeSum(int left, int[] nums, int target) {

        System.out.println("threeSum target:" + target);
        for(int i = left; i < nums.length-1 ;i++){
            if( i > left && nums[i-1] == nums[i]){
                continue;
            }
            findsum(i+1,nums.length-1,target-nums[i],nums);
        }
    }


    private void findsum(int left,int right, int target,int[] nums){
        int p = nums[left-1];
        while (left < right){

            if(nums[left] + nums[right] < target){
                left++;
            }else if(nums[left] + nums[right] > target){
                right--;
            }else {
                result.add(Arrays.asList(cur,nums[left],nums[right],p));
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1])
                    left++;
            }
        }
    }

}

















