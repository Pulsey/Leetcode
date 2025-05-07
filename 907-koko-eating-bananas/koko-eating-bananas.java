class Solution {
    public int minEatingSpeed(int[] piles, int h) {
         int left = 1;
         int max = 0;
         for(int i =0; i < piles.length; i++){
                max = Math.max(piles[i], max);
         }
         int right  = max;
        int mid =0;
        int result = 0;
         while(right >= left){
            mid = left + (right -left)/2;

            if(validRate(piles, mid, h)){
                result = mid;
                right = mid - 1;
            }else
            left = mid + 1;
         }
         return result;


    }

    public boolean validRate(int [] piles, int rate, int h){
        
        int totalTime = 0;
        for( int i = 0; i < piles.length; i++){
            totalTime += Math.ceil((double)piles[i] / rate);
        }
        if(totalTime <= h){
            return true;
        }else return false;
    }


}