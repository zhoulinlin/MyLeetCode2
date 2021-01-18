import java.util.Arrays;

public class _253_MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int min= intervals[0][1];
        int result = 1;

        for(int i=1;i < intervals.length;i++){

            if(intervals[i][0] < min){
                result++;
                min = Math.min(min,intervals[i][1]);
            }else{
                min=intervals[i][1];
            }

        }

        return result;
    }
}
