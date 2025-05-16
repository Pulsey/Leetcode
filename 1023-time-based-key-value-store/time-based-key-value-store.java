class TimeMap {
    class Pair{
        int timestamp;
        String value;
        public  Pair( int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }

    }
    private Map< String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add( new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(map.get(key) == null)
        return "";

        String result = "";
        List<Pair> list = map.get(key);
        int left = 0;
        int right = list.size() -1;


        while(left <= right){
            int mid = left + (right - left) / 2 ;
            if(list.get(mid).timestamp <= timestamp){
                result = list.get(mid).value;
                left = mid+1;
            }else
            right = mid - 1;

        }
        return result;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */