/**
 * 在一排多米诺骨牌中，tops[i] 和 bottoms[i] 分别代表第 i 个多米诺骨牌的上半部分和下半部分。（一个多米诺是两个从 1 到 6 的数字同列平铺 形成的 —— 该平铺的每一半上都有一个数字。）
 * <p>
 * 我们可以旋转第 i 张多米诺，使得 tops[i] 和 bottoms[i] 的值交换。
 * <p>
 * 返回能使 tops 中所有值或者 bottoms 中所有值都相同的最小旋转次数。
 * <p>
 * 如果无法做到，返回 -1.
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2] 输出：2 解释： 图一表示：在我们旋转之前， tops 和 bottoms 给出的多米诺牌。
 * 如果我们旋转第二个和第四个多米诺骨牌，我们可以使上面一行中的每个值都等于 2，如图二所示。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：tops = [3,5,1,2,3], bottoms = [3,6,3,3,4] 输出：-1 解释： 在这种情况下，不可能旋转多米诺牌使一行的值相等。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= tops.length <= 2 * 10⁴ bottoms.length == tops.length 1 <= tops[i], bottoms[i] <= 6
 * <p>
 * <p>
 * Related Topics 贪心 数组 👍 155 👎 0
 */

package com.makersy.leetcode.editor.cn;

class MinimumDominoRotationsForEqualRow {

    public static void main(String[] args) {
        //Solution solution = new MinimumDominoRotationsForEqualRow().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /*
        Return min number of rotations
        if one could make all elements in A or B equal to x.
        Else return -1.
        */
        public int check(int x, int[] A, int[] B, int n) {
            // how many rotations should be done
            // to have all elements in A equal to x
            // and to have all elements in B equal to x
            int rotations_a = 0, rotations_b = 0;
            for (int i = 0; i < n; i++) {
                // rotations coudn't be done
                if (A[i] != x && B[i] != x) {
                    return -1;
                }
                // A[i] != x and B[i] == x
                else if (A[i] != x) {
                    rotations_a++;
                }
                // A[i] == x and B[i] != x
                else if (B[i] != x) {
                    rotations_b++;
                }
            }
            // min number of rotations to have all
            // elements equal to x in A or B
            return Math.min(rotations_a, rotations_b);
        }

        public int minDominoRotations(int[] A, int[] B) {
            int n = A.length;
            int rotations = check(A[0], B, A, n);
            // If one could make all elements in A or B equal to A[0]
            if (rotations != -1 || A[0] == B[0]) {
                return rotations;
            }
            // If one could make all elements in A or B equal to B[0]
            else {
                return check(B[0], B, A, n);
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}