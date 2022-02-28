class Solution {
    private int[] subSolutions = new int[38];
    
    public int tribonacci(int n) {
        subSolutions[1]=1;
        subSolutions[2]=1;
        for(int i=3;i<=n;i++){
            subSolutions[i] = subSolutions[i-1]+subSolutions[i-2]+subSolutions[i-3];
        }
        return subSolutions[n];
    }
}