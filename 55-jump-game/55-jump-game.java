class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] max_jump_length = new int[n];
        max_jump_length[n-1] = nums[n-1];
        
        for(int i = n-2;i>=0;i--){
            for(int j = i+1;j<=Math.min(i+nums[i],n-1);j++){
                max_jump_length[i] = Math.max(max_jump_length[i],max_jump_length[j]+j-i);
            }
        }
        // System.out.println(Arrays.toString(max_jump_length));
        if(max_jump_length[0]>=(n-1))
            return true;
        return false;
    }
}