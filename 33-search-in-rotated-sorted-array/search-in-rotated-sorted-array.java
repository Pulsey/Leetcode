class Solution {
    public int search(int[] nums, int target) {
        int nLen = nums.length;
        int left = 0;
        int right  =  nLen - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;

            //checking if left is sorted
         if(nums[left] <= nums[mid]){
                        
            if(nums[left] <= target && target < nums[mid])
                right = mid - 1;
            else
                left = mid+1;
        // if right is sorted
         }else{
            if(nums[mid] < target && target <= nums[right])
                left = mid +1;
            else
                right = mid - 1;
        }}
        return -1;
    }
}