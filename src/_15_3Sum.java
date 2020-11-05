import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 *
 * Example 2:
 * Input: nums = []
 * Output: []
 *
 * Example 3:
 * Input: nums = [0]
 * Output: []
 */
public class _15_3Sum {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {

        if(nums == null || nums.length <= 2){
            return result;
        }

        Arrays.sort(nums);
        int pre = nums[0];
        for(int i=0;i<nums.length && nums[i]<= 0;i++){
            System.out.println("_15_3SumTest find sum:" +(-nums[i]));
            if( i > 0 && pre == nums[i]){
                continue;
            }
            findsum(0,nums.length-2,-nums[i],arrayRemove(nums,i));
            pre = nums[i];
        }
        return result;
    }

    private int[] arrayRemove(int[]arr,int index){

        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }

        int[] anotherArray = new int[arr.length - 1];

        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }

        return anotherArray;
    }

    private void findsum(int left,int right, int sum,int[] nums){

        if(nums[left] >= nums[right]){
            return;
        }

        if(nums[left] + nums[right] < sum){
            left++;
        }else if(nums[left] + nums[right] > sum){
            right--;
        }else {
            left++;
            right--;
            putResult(nums[left],nums[right],-sum);
        }
        findsum(left,right,sum,nums);
    }

    private void putResult(int num1,int num2,int num3){

        List<Integer> temp = new ArrayList<>();
        temp.add(num1);
        temp.add(num2);
        temp.add(num3);
        result.add(temp);
    }


}




























