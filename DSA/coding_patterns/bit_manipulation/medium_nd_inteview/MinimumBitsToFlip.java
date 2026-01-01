package coding_patterns.bit_manipulation.medium_nd_inteview;

public class MinimumBitsToFlip {

    int minimumBitsToFlip(int target, int goal) {

        int num = target ^ goal;
        int cnt = 0;

        for (int i = 0; i <= 31; i++) {
            if ((num & (1 << i)) != 0)
                cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        MinimumBitsToFlip minimumBitsToFlip = new MinimumBitsToFlip();
        System.out.println(minimumBitsToFlip.minimumBitsToFlip(7, 8));
        System.out.println(minimumBitsToFlip.minimumBitsToFlip(8, 0));
    }
}
