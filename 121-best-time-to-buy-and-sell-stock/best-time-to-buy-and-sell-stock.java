class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        int minPrice = Integer.MAX_VALUE;

        for( int price : prices){
            if(price < minPrice){
                minPrice = price;
            }else{
                maxprofit = Math.max(maxprofit, price - minPrice);
            }
        }
return maxprofit;
        }
    }
