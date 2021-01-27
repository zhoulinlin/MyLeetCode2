import java.util.PriorityQueue;
import java.util.Queue;

/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 *
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 *
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 */
public class _973_K_ClosestPointstoOrigin {

    public int[][] kClosest(int[][] points, int K) {

        Queue<int[]> que = new PriorityQueue<>(K, (a, b) -> (b[0]*b[0]+b[1]*b[1]) - (a[0]*a[0]+a[1]*a[1]));
        int[] temp;

        for(int i=0; i<points.length; i++){

            if(que.size() < K){
                que.add(points[i]);
            }else{

                temp = que.peek();
                if(temp[0]*temp[0]+temp[1]*temp[1] > points[i][0]*points[i][0]+points[i][1]*points[i][1]){
                    que.poll();
                    que.add(points[i]);
                }
            }
        }

        int[][] result = new int[K][];
        for(int i=0;i<K;i++){
            result[i] = que.poll();
        }

        return result;

    }
}
