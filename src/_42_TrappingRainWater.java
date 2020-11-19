/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 * Example 1:
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 *
 */
public class _42_TrappingRainWater {

    public int trap(int[] height) {

        int result=0,cur = 0,subArea,tempMax;
        boolean hasFind;

        while(cur < height.length-1){

            if(height[cur] == 0){
                cur++;
                continue;
            }

            tempMax = -1;
            hasFind = false;

            for(int i = cur + 1;i<height.length;i++){
                if(height[cur] > height[i]){
                    if(tempMax  == -1 || height[i] > height[tempMax]){
                        tempMax = i;
                    }
                }else{
                    result += calculateArea(cur,i,height);
                    System.out.println("begin:" + cur +" end:" + i  +" result:" + result);
                    hasFind = true;
                    cur = i-1;
                    break;
                }
            }

            if(!hasFind){
                result += calculateArea(cur,tempMax,height);
                System.out.println("begin:" + cur +" tempMax:" + tempMax + " result:" + result);
                cur = tempMax-1;
            }

            cur++;
        }
        return result;
    }

    int calculateArea(int begin,int end,int[] height){

        int subArea = 0;
        for(int i=begin+1;i<end;i++){
            subArea += height[i];
        }

        return (end - begin - 1) * Math.min(height[begin],height[end]) - subArea;
    }

}
