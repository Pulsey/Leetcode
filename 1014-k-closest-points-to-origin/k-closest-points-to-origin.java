class Solution {
 
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>( (a, b) -> Integer.compare( b[0] * b[0] + b[1]*b[1],
                                                                                       a[0]*a[0] + a[1] * a[1]) );

        for( int[] point : points){
            minHeap.offer(point);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        int i = 0;

        for(int[] point : minHeap){
            result[i] = point;
            i++;
        }
        return result;
    }
}