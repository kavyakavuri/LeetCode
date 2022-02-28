class Solution {
    public static Map<Integer,Integer> subProblems;
    static{
        subProblems = new HashMap<Integer, Integer>();
        subProblems.put(0,0);
        subProblems.put(1,1);
    }
    public int fib(int n) {
        if(subProblems.containsKey(n)){
            return subProblems.get(n);
        }
        return fib(n-1)+fib(n-2);
        // return 2;
    }
}