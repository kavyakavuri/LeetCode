class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry=0;
        carry = (digits[n-1]+1)/10;
        digits[n-1] = (digits[n-1]+1)%10;
        // System.out.println(digits[n-1]);
        
        for(int i=n-2;i>=0;i--){
            int temp = digits[i]+carry;
            digits[i] = (digits[i] + carry)%10;
            carry = temp/10;
            
            if(carry == 0)
                break;
        }
        
        if(carry == 1){
            int arr[] = new int[digits.length+1];
            arr[0]=1;
            for(int i=1;i<digits.length;i++){
                arr[i] = digits[i];
            }
            return arr;
        }
        return digits;
    }
}