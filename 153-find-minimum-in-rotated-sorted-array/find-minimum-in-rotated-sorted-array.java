class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int nLen = nums.length;
        int right = nLen-1;

        int mid = (right + left) / 2;
        while(left < right){
            if(nums[mid] > nums[right]){
                left = mid+1;
            }else 
                right = mid;
            mid = (right+left)/2;
        }
        return nums[left];
    }
}