class Solution {
    public int removeDuplicates(int[] nums) {
        int unique =0,i=1,n = nums.length;
        while(i<n){
            if(nums[i] != nums[unique]){
                nums[unique+1] = nums[i];
                unique++;
            }
            i++;
        }
        return unique+1;
    }
}