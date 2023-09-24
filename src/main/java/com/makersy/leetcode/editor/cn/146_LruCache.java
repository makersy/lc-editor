/**

 请你设计并实现一个满足 
 LRU (最近最少使用) 缓存 约束的数据结构。
 

 
 实现 
 LRUCache 类：
 

 
 
 
 LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
 int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
 void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-
value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
 
 
 

 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 

 

 示例： 

 
输入
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
输出
[null, null, null, 1, null, -1, null, -1, 3, 4]

解释
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // 缓存是 {1=1}
lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
lRUCache.get(1);    // 返回 1
lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
lRUCache.get(2);    // 返回 -1 (未找到)
lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
lRUCache.get(1);    // 返回 -1 (未找到)
lRUCache.get(3);    // 返回 3
lRUCache.get(4);    // 返回 4
 

 

 提示： 

 
 1 <= capacity <= 3000 
 0 <= key <= 10000 
 0 <= value <= 10⁵ 
 最多调用 2 * 10⁵ 次 get 和 put 
 

 Related Topics 设计 哈希表 链表 双向链表 👍 2895 👎 0

*/

package com.makersy.leetcode.editor.cn;

import java.util.HashMap;

class LruCache{
    public static void main(String[] args) {
        //Solution solution = new LruCache().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        // HashMap + 链表
        // 最近使用的放链表尾部
        class Node{
            Node pre;
            Node next;
            int key;
            int value;

            public Node(int key, int value){
                this.key = key;
                this.value = value;
            }
        }

        private HashMap<Integer, Node> map;
        private int capacity;
        private int size;
        private Node head;
        private Node tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>(capacity);
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if(map.containsKey(key)){
                Node node = remove(key);
                add(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            Node node = null;

            if(map.containsKey(key)){
                node = remove(key);
                node.value = value;
                add(node);
            }else{
                node = new Node(key, value);
                if(size == capacity){
                    // 超出容量。这里capacity >= 1，链表内一定有值，所以不用担心删除掉tail
                    remove(head.next.key);
                    add(node);
                }else{
                    // 未超出容量
                    add(node);
                }
            }
        }

        private Node remove(int key){
            if(!map.containsKey(key)) return null;
            Node node = map.remove(key);
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
            return node;
        }

        private void add(Node node){
            // map
            map.put(node.key, node);
            // 链表
            tail.pre.next = node;
            node.pre = tail.pre;
            tail.pre = node;
            node.next = tail;
            size++;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//runtime:56 ms
//memory:115 MB


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}