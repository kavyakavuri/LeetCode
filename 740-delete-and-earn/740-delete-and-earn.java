class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxKey = -1;
        
        //create frequency map
        Map<Integer,Integer> freq = new HashMap<Integer,Integer>();
        for(int a: nums){
            if(freq.containsKey(a)){
                freq.put(a,freq.get(a)+1);
            } else{
                freq.put(a,1);
            }
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
        f[maxKey+1]=0;
        f[maxKey] = maxKey*freq.get(maxKey);
        
        //calculating sub problems
        for(int i=maxKey-1;i>=0;i--){
            // int elem = sorted_keys.get(i);
            if(freq.containsKey(i)){
                f[i] = Math.max(i*freq.get(i)+f[i+2],f[i+1] );
            }else{
                f[i] = Math.max(f[i+2],f[i+1]);
            }
            
        }
        
        //returning final ans
        return f[0];
    }
}