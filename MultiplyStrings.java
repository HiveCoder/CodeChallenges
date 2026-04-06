class Solution {
    public String multiply(String num1, String num2) {
        // Edge case
        if (num1.equals("0") || num2.equals("0")) return "0";

        int m = num1.length();
        int n = num2.length();
        
        int[] result = new int[m + n];

        // Multiply digits from right to left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';

                int product = digit1 * digit2;

                int p1 = i + j;       // carry position
                int p2 = i + j + 1;   // current digit position

                int sum = product + result[p2];

                result[p2] = sum % 10;      // store last digit
                result[p1] += sum / 10;     // carry
            }
        }

        // Convert result array to string
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }

        return sb.toString();
    }
}
