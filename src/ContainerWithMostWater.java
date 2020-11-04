/**
11. Container With Most Water
Given n non-negative integers a1, a2, ..., an ,
where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
Find two lines, which, together with the x-axis forms a container,
such that the container contains the most water.

Notice that you may not slant the container.

Constraints:

n = height.length
2 <= n <= 3 * 104
0 <= height[i] <= 3 * 104
 */

public class ContainerWithMostWater {

    //Mine:Brute Force
    public int maxArea(int[] height) {
        int maxDistance = height.length;
        int maxArea = 0;
        int area = 0;

        for(int i = 0;i < maxDistance;i++){
            for(int j=i+1; j< maxDistance;j++){
                area = Math.min(height[i],height[j])*(j-i);
                if(area>maxArea){
                    maxArea = area;
                }
            }

        }
        return maxArea;
    }

    //Two Pointer Approach
    //keep bigger move smaller
    public int maxArea2(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }


}
