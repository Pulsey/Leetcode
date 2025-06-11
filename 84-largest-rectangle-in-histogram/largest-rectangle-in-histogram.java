class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
        int len = heights.length;
        int maxArea  =0 ;
        int currentHeight = 0;

        for(int i = 0; i <= len; i++){
            if( i == len)
            currentHeight = 0;
            else
            currentHeight = heights[i];            
            while(!stack.isEmpty() && currentHeight < heights[stack.peek()] ){
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}