class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int weight : stones){
            maxHeap.offer(weight);
        }

        while(maxHeap.size() > 1){
            int y = maxHeap.poll();
            int x = maxHeap.poll();

            if( x == y){
                continue;
            }else{
                int k = y -x;
                maxHeap.offer(k);
            }
        }

        if(maxHeap.size() == 1){
            return maxHeap.peek();
        }
        return 0;
    }
}