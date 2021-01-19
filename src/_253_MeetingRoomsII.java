import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class _253_MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        Queue<Integer> que = new PriorityQueue<Integer>(intervals.length, (a, b) -> a - b);
        que.add(intervals[0][1]);

        for(int i=1;i < intervals.length;i++){

            if(intervals[i][0] >= que.peek()){
                que.poll();
            }
            que.add(intervals[i][1]);
        }
        return que.size();
    }
}
