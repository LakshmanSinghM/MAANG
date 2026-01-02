// https://takeuforward.org/plus/dsa/problems/xor-of-numbers-in-a-given-range

package coding_patterns.bit_manipulation.medium_nd_inteview;

public class FindXOROFLeftToRightRange {

    // 1-1
    // 2-3
    // 3-0
    // 4-4
    // 5-1
    // 6-7
    // 7-0
    // 8-8

    int findXORof1ToN(int n) {

        if (n % 4 == 1) {
            return 1;
        } else if (n % 4 == 2)
            return n + 1;
        else if (n % 4 == 3) {
            return 0;
        } else
            return n;
    }

    int findXOROFLeftToRightRange(int l, int r) {

        int tillLeft = findXORof1ToN(l - 1);
        int rightPartXOR = findXORof1ToN(r);
        return tillLeft ^ rightPartXOR;

    }

    public static void main(String[] args) {
        FindXOROFLeftToRightRange findXOROFLeftToRightRange = new FindXOROFLeftToRightRange();
        System.out.println(findXOROFLeftToRightRange.findXORof1ToN(8));
        System.out.println(findXOROFLeftToRightRange.findXOROFLeftToRightRange(4, 6));
    }
}



// N = 1          1

// N = 2          3
// 1 ^ 2

// N = 3          0
// 1 ^ 2 ^ 3

// N = 4          4
// 1 ^ 2 ^ 3 ^ 4

// N = 5          1
// 1 ^ 2 ^ 3 ^ 4 ^ 5

// N = 6          7
// 1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 6

// N = 7          0
// 1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 6 ^ 7

// N = 8          8
// 1 ^ 2 ^ 3 ^ ... ^ 8

// N = 9          1
