/**
 * 在考场里，有 n 个座位排成一行，编号为 0 到 n - 1。
 * <p>
 * 当学生进入考场后，他必须坐在离最近的人最远的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)
 * <p>
 * <p>
 * 设计一个模拟所述考场的类。
 * <p>
 * 实现 ExamRoom 类：
 * <p>
 * <p>
 * ExamRoom(int n) 用座位的数量 n 初始化考场对象。 int seat() 返回下一个学生将会入座的座位编号。 void leave(int p) 指定坐在座位 p 的学生将离开教室。保证座位 p 上会有一位学生。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入： ["ExamRoom", "seat", "seat", "seat", "seat", "leave", "seat"] [[10], [], [], [], [], [4], []] 输出： [null, 0, 9, 4,
 * 2, null, 5] 解释： ExamRoom examRoom = new ExamRoom(10); examRoom.seat(); // 返回 0，房间里没有人，学生坐在 0 号座位。 examRoom.seat(); //
 * 返回 9，学生最后坐在 9 号座位。 examRoom.seat(); // 返回 4，学生最后坐在 4 号座位。 examRoom.seat(); // 返回 2，学生最后坐在 2 号座位。 examRoom.leave(4);
 * examRoom.seat(); // 返回 5，学生最后坐在 5 号座位。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 10⁹ 保证有学生正坐在座位 p 上。 seat 和 leave 最多被调用 10⁴ 次。
 * <p>
 * <p>
 * Related Topics 设计 有序集合 堆（优先队列） 👍 292 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.PriorityQueue;
import java.util.TreeSet;

class ExamRoom {

    public static void main(String[] args) {
        //Solution solution = new ExamRoom().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class ExamRoom {

        int n;

        TreeSet<Integer> seats;

        PriorityQueue<int[]> pq;

        public ExamRoom(int n) {
            this.n = n;
            this.seats = new TreeSet<Integer>();
            this.pq = new PriorityQueue<int[]>((a, b) -> {
                int d1 = a[1] - a[0], d2 = b[1] - b[0];
                return d1 / 2 < d2 / 2 || (d1 / 2 == d2 / 2 && a[0] > b[0]) ? 1 : -1;
            });
        }

        public int seat() {
            if (seats.isEmpty()) {
                seats.add(0);
                return 0;
            }
            int left = seats.first(), right = n - 1 - seats.last();
            while (seats.size() >= 2) {
                int[] p = pq.peek();
                if (seats.contains(p[0]) && seats.contains(p[1]) && seats.higher(p[0]) == p[1]) { // 不属于延迟删除的区间
                    int d = p[1] - p[0];
                    if (d / 2 < right || d / 2 <= left) { // 最左或最右的座位更优
                        break;
                    }
                    pq.poll();
                    pq.offer(new int[] {p[0], p[0] + d / 2});
                    pq.offer(new int[] {p[0] + d / 2, p[1]});
                    seats.add(p[0] + d / 2);
                    return p[0] + d / 2;
                }
                pq.poll(); // leave 函数中延迟删除的区间在此时删除
            }
            if (right > left) { // 最右的位置更优
                pq.offer(new int[] {seats.last(), n - 1});
                seats.add(n - 1);
                return n - 1;
            } else {
                pq.offer(new int[] {0, seats.first()});
                seats.add(0);
                return 0;
            }
        }

        public void leave(int p) {
            if (p != seats.first() && p != seats.last()) {
                int prev = seats.lower(p), next = seats.higher(p);
                pq.offer(new int[] {prev, next});
            }
            seats.remove(p);
        }
    }

    /**
     * Your ExamRoom object will be instantiated and called as such:
     * ExamRoom obj = new ExamRoom(n);
     * int param_1 = obj.seat();
     * obj.leave(p);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}