class Solution {
    public int countCollisions(String directions) {
        int[] last = {-1, 0};
        int collisions = 0;

        for(char direction : directions.toCharArray()){
            if(last[0] != -1 && direction == 'L' && last[0] != 'L'){
                //collision
                collisions++;

                if(last[0] == 'R'){
                    collisions += last[1];
                }
                last = new int[]{'S', 1};
            }
            else if(direction == 'S' && last[0] == 'R'){
                collisions += last[1];
                last = new int[] {'S', 1};
            }
            else {
                if(last[0] == direction){
                    last[1]++;
                } else {
                    last = new int[] {direction, 1};
                }
            }
        }
        return collisions;

    }
}