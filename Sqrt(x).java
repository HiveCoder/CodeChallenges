class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;  // sqrt(0)=0, sqrt(1)=1
        }

        int left = 1;
        int right = x / 2;
        int answer = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;  // prevent overflow

            if (square == x) {
                return mid;
            } else if (square < x) {
                answer = mid;  // store potential answer
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}
