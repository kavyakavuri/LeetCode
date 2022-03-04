class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        
        float[][] status = new float[query_row+1][query_row+1];
        
        status[0][0] = poured;
        int row = 1;
        while(row<=query_row){
            for(int col=0;col<=row;col++){
                if(col-1>=0 && status[row-1][col-1]>1){
                    status[row][col] += (status[row-1][col-1]-1)/2;    
                }
                if(status[row-1][col]>1)
                    status[row][col] += (status[row-1][col]-1)/2; 
            }
            row +=1;
        }
        if(status[query_row][query_glass]<1)
            return status[query_row][query_glass];
        else
            return 1;
        
    }
}