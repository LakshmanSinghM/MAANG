
public class FindNthRoot {
    static int mutiplyNTimes(int n, int k) {
        int ans = k;
        for (int i = 1; i<n; i++)
            ans *= k;
        System.out.println("Multip by time of the "+k+"    "+ans);    
        return ans;
    }

    static int findNthRoot(int num, int n) {
        int low = 1;
        int high = num;
        while (low <= high) {
            int mid = (high + low) / 2;
            int findNthSq = mutiplyNTimes(n, mid);

            System.out.println("The nth multiple times value " + findNthSq+"     "+mid +"     "+n);

            if (num == findNthSq)
                return mid;

            if (findNthSq > num)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findNthRoot(69, 4));
    }
}