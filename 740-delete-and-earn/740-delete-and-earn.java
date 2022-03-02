class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxKey = -1;
        
        //create frequency map
        Map<Integer,Integer> freq = new HashMap<Integer,Integer>();
        for(int a: nums){
            freq.put(a,freq.getOrDefault(a,0)+1);
            if(a>maxKey){
                maxKey = a;
            }
        }
        
        // System.out.println(maxKey);
        
        //print hashmap
        // for(int i=0;i<n;i++){
        //     int elem = sorted_keys.get(i);
        //     System.out.println(elem+" : "+freq.get(elem));
        // }
        
        //populating subproblem's answers in f
        int[] f  = new int[maxKey+2];
        
        //base cases
        f[maxKey+1]=0; //initializing for i+2 access in for loop below
        f[maxKey] = maxKey*freq.get(maxKey); // -> if there is only one element (example: [2,2,2]), then delete all of them
        
        //calculating sub problems
        //At some number i, you already know the max number of points that you get for the subproblems -> i+1 and i+2
        //so now you need to see whether to delete current i or not
        //option 1: delete i: sum(i)+subproblem(i+2)
        //option 2: don't delete i: subproblem(i+1)
        //So subproblem(i) = Max(sum(i)+subproblem(i+2),subproblem(i+1))
        for(int i=maxKey-1;i>=0;i--){
            if(freq.containsKey(i)){
                f[i] = Math.max(i*freq.get(i)+f[i+2],f[i+1] );
            }else{
                f[i] = Math.max(f[i+2],f[i+1]);
            } 
        }
        
        //return max points
        return f[0];
    }
}