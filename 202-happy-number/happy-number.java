class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<Integer>();
        
        while(!visited.contains(n)){
            visited.add(n);
            n = sumOfSquare(n);

            if(n == 1){
                return true;
            }
        }
        return false;

    }
    public int sumOfSquare(int n){
        int result = 0;

        while(n > 0){
            int temp = n % 10;
            temp = temp * temp;
            result += temp;
            n = n/10;
        }
        return result;
    }
}