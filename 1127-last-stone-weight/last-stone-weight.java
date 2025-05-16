class Solution {
    public int lastStoneWeight(int[] stones) {
          Arrays.sort(stones);  //initial sorting
        for(int i=stones.length-1;i>=1;i--){
            int dif=stones[i]-stones[i-1];
            stones[i-1]=dif; // store at the last before index
            Arrays.sort(stones,0,i);   // sort each loop to get next two largest elements
        }
        return stones[0];    // final merge answer
    }
}