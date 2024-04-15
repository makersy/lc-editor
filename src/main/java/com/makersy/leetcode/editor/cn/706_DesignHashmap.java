/**
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 * <p>
 * 实现 MyHashMap 类：
 * <p>
 * <p>
 * MyHashMap() 用空映射初始化对象 void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更 新其对应的值 value 。
 * int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。 void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value
 * 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入： ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"] [[], [1, 1], [2, 2], [1], [3], [2, 1],
 * [2], [2], [2]] 输出： [null, null, null, 1, -1, null, 1, null, -1]
 * <p>
 * 解释： MyHashMap myHashMap = new MyHashMap(); myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]] myHashMap.put(2, 2); //
 * myHashMap 现在为 [[1,1], [2,2]] myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]] myHashMap.get(3);    // 返回
 * -1（未找到），myHashMap 现在为 [[1,1], [2,2]] myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值） myHashMap.get(2);
 *  // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]] myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]] myHashMap.get(2);
 * // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= key, value <= 10⁶ 最多调用 10⁴ 次 put、get 和 remove 方法
 * <p>
 * <p>
 * Related Topics 设计 数组 哈希表 链表 哈希函数 👍 419 👎 0
 */

package com.makersy.leetcode.editor.cn;

class DesignHashmap {

    public static void main(String[] args) {
        //Solution solution = new DesignHashmap().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyHashMap {

        class Node {
            int key;
            int val;
            Node next;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        Node[] arr;
        int len;

        public MyHashMap() {
            len = 1000;
            arr = new Node[len];
        }

        public void put(int key, int value) {
            int idx = key % len;
            Node n = arr[idx];
            while (n != null && n.key != key) {
                n = n.next;
            }
            if (n == null) {
                Node node = new Node(key, value);
                node.next = arr[idx];
                arr[idx] = node;
            } else {
                n.val = value;
            }
        }

        public int get(int key) {
            int idx = key % len;
            Node n = arr[idx];
            while (n != null && n.key != key) {
                n = n.next;
            }
            return n != null ? n.val : -1;
        }

        public void remove(int key) {
            int idx = key % len;
            Node pre = null;
            Node n = arr[idx];
            while (n != null && n.key != key) {
                pre = n;
                n = n.next;
            }
            if (n == null) {
                return;
            }
            if (n == arr[idx]) {
                arr[idx] = n.next;
                n.next = null;
            } else {
                pre.next = n.next;
            }
        }
    }

    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}