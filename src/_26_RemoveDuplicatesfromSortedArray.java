/**
 * 26. Remove Duplicates from Sorted Array
 */
public class _26_RemoveDuplicatesfromSortedArray {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;

        if(len <= 1){
            return len;
        }

        int avaP = 1,pre = nums[0];

        for(int i=1;i<len;i++){

            if(nums[i] == pre){
                if(avaP == 0){
                    avaP = i;
                }
            }else{
                if(avaP > 0 && avaP <= i){
                    nums[avaP] = nums[i];
                    avaP++;
                }
            }

            pre = nums[i];
        }
        return avaP;
    }
}
