/**
 * 请你设计并实现一个能够对其中的值进行跟踪的数据结构，并支持对频率相关查询进行应答。
 * <p>
 * 实现 FrequencyTracker 类：
 * <p>
 * <p>
 * FrequencyTracker()：使用一个空数组初始化 FrequencyTracker 对象。 void add(int number)：添加一个 number 到数据结构中。 void deleteOne(int
 * number)：从数据结构中删除一个 number 。数据结构 可能不包含 number ，在这种情况下不删除任何内容。
 * <p>
 * bool hasFrequency(int frequency): 如果数据结构中存在出现 frequency 次的数字，则返回 true，否则返回 false。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入 ["FrequencyTracker", "add", "add", "hasFrequency"] [[], [3], [3], [2]] 输出 [null, null, null, true]
 * <p>
 * 解释 FrequencyTracker frequencyTracker = new FrequencyTracker(); frequencyTracker.add(3); // 数据结构现在包含 [3]
 * frequencyTracker.add(3); // 数据结构现在包含 [3, 3] frequencyTracker.hasFrequency(2); // 返回 true ，因为 3 出现 2 次
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入 ["FrequencyTracker", "add", "deleteOne", "hasFrequency"] [[], [1], [1], [1]] 输出 [null, null, null, false]
 * <p>
 * 解释 FrequencyTracker frequencyTracker = new FrequencyTracker(); frequencyTracker.add(1); // 数据结构现在包含 [1]
 * frequencyTracker.deleteOne(1); // 数据结构现在为空 [] frequencyTracker.hasFrequency(1); // 返回 false ，因为数据结构为空
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入 ["FrequencyTracker", "hasFrequency", "add", "hasFrequency"] [[], [2], [3], [1]] 输出 [null, false, null, true]
 * <p>
 * 解释 FrequencyTracker frequencyTracker = new FrequencyTracker(); frequencyTracker.hasFrequency(2); // 返回 false
 * ，因为数据结构为空 frequencyTracker.add(3); // 数据结构现在包含 [3] frequencyTracker.hasFrequency(1); // 返回 true ，因为 3 出现 1 次
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= number <= 10⁵ 1 <= frequency <= 10⁵ 最多调用 add、deleteOne 和 hasFrequency 共计 2 * 10⁵ 次
 * <p>
 * <p>
 * Related Topics 设计 哈希表 👍 41 👎 0
 */

package com.makersy.leetcode.editor.cn;

class FrequencyTracker {

    public static void main(String[] args) {
        //Solution solution = new FrequencyTracker().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class FrequencyTracker {

        private static final int N = 100001;

        private int[] freq;

        private int[] freqCnt;

        public FrequencyTracker() {
            freq = new int[N];
            freqCnt = new int[N];
        }

        public void add(int number) {
            --freqCnt[freq[number]];
            ++freq[number];
            ++freqCnt[freq[number]];
        }

        public void deleteOne(int number) {
            if (freq[number] == 0) {
                return;
            }
            --freqCnt[freq[number]];
            --freq[number];
            ++freqCnt[freq[number]];
        }

        public boolean hasFrequency(int frequency) {
            return freqCnt[frequency] > 0;
        }
    }

    /**
     * Your FrequencyTracker object will be instantiated and called as such:
     * FrequencyTracker obj = new FrequencyTracker();
     * obj.add(number);
     * obj.deleteOne(number);
     * boolean param_3 = obj.hasFrequency(frequency);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}