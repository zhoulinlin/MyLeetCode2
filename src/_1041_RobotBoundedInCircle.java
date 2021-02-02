public class _1041_RobotBoundedInCircle {

    public boolean isRobotBounded(String instructions) {

        int x=0,y=0,ang=90;//1up 2 right 3 down 4 left
        char cur;

        for(int j=0;j<4;j++){

            for(int i=0;i<instructions.length();i++){
                cur = instructions.charAt(i);

                if(cur == 'L'){
                    ang +=90;
                }else if(cur == 'R'){
                    ang -=90;
                }else if(cur == 'G'){
                    if(ang == 0){
                        x++;
                    }else if(ang == 90){
                        y++;
                    }else if(ang == 180){
                        x--;
                    }else if(ang == 270){
                        y--;
                    }

                }
                ang = ang<0?ang%360+360:ang%360;
            }

            if(x==0&&y==0){
                return true;
            }

        }
        return false;
    }
}

class Solution {
    public boolean isRobotBounded(String instructions) {
        // north = 0, east = 1, south = 2, west = 3
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // Initial position is in the center
        int x = 0, y = 0;
        // facing north
        int idx = 0;

        for (char i : instructions.toCharArray()) {
            if (i == 'L')
                idx = (idx + 3) % 4;
            else if (i == 'R')
                idx = (idx + 1) % 4;
            else {
                x += directions[idx][0];
                y += directions[idx][1];
            }
        }

        // after one cycle:
        // robot returns into initial position
        // or robot doesn't face north
        return (x == 0 && y == 0) || (idx != 0);
    }
}
