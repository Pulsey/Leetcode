class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for(char task: tasks){
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.addAll(freqMap.values());
        int time = 0;

        while(!maxHeap.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int cycle = n+1;

            for(int i = 0; i < cycle && !maxHeap.isEmpty(); i++){
                temp.add(maxHeap.poll());
            }

            for(int f: temp){
                if( f > 1){
                    maxHeap.offer(f-1);
                }
            }
            if(maxHeap.isEmpty()){
                time += temp.size();
            }else
            time += cycle;
        }
        return time;

    }
}