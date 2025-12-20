public class FindSquareRoot {

    static int findSQ(int n) {
        int low = 1;
        int high = n / 2;
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            int sq = mid * mid;
            // if (sq == n)
            //     return mid;
            if (sq<=n) {
                ans = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findSQ(20));
    }
}
