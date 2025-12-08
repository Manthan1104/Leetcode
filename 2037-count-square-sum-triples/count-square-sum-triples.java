// class Solution {
//     public int countTriples(int n) {

//         int count = 0;

//         for (int m = 2; m * m <= n; m++) {
//             for (int a = m - 1; a >= 1; a--) {

//                 int b = a;
//                 if ((m - b) % 2 == 0) continue; // parity condition
//                 if (gcd(m, b) != 1) continue;   // coprime condition

//                 int c = m * m + b * b;
//                 if (c > n) continue;

//                 int A = m * m - b * b;
//                 int B = 2 * m * b;

//                 // count multiples
//                 int k = 1;
//                 while (k * c <= n) {
//                     count += 2; // (A,B,c) and (B,A,c)
//                     k++;
//                 }
//             }
//         }

//         return count;
//     }

//     private int gcd(int x, int y) {
//         return y == 0 ? x : gcd(y, x % y);
//     }
// }




class Solution {
    public int countTriples(int n) {

        // Step 1: Precompute squares of all numbers from 1 to n
        int[] square = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            square[i] = i * i;
        }

        int count = 0;

        // Step 2: Check all pairs (a, b)
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {

                int sum = square[a] + square[b];

                // Step 3: Check if sum is a perfect square
                int c = (int) Math.sqrt(sum);

                // Step 4: Validate c
                if (c <= n && square[c] == sum) {
                    count++;
                }
            }
        }

        return count;
    }
}

