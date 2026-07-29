class Solution {
    public String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();

        StringBuilder sb = new StringBuilder();

        int sum = 0;
        int carry = 0;

        int i = n - 1;
        int j = m - 1;

        while(i >= 0 || j >= 0){
            sum = carry;

            if(i >= 0){
                sum += a.charAt(i) - '0';
                i--;
            }

            if(j >= 0){
                sum += b.charAt(j) - '0';
                j--;
            }

            if(sum % 2 == 0){
                sb.append('0');
            }else{
                sb.append('1');
            }

            carry = sum > 1 ? 1 : 0;
        }

        if(carry > 0){
            sb.append('1');
        }

        sb.reverse();

        return sb.toString();
    }
}