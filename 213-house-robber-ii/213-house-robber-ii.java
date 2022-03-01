class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        // if(n==3){
        //     return Math.max(nums[0],Math.max(nums[1],nums[2]));
        // }
        return Math.max( this.rob_serial(Arrays.copyOfRange(nums,0,n-1)),this.rob_serial(Arrays.copyOfRange(nums,1,n)) );
    }

    private int rob_serial(int[] nums){
        // if(nums.length == 1) return nums[0];
        
        int n = nums.length;
        int f[] = new int[nums.length+1];
        f[n] = 0;
        f[n-1] = nums[n-1];
        // f[n-2] = nums[n-2];
        
        for(int i=n-2;i>=0;i--){
            f[i] = Math.max(f[i+1],f[i+2]+nums[i]);
        }
        
        return f[0];
    }
}

