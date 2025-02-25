/**
 * 给你一个整数 n ，表示下标从 0 开始的内存数组的大小。所有内存单元开始都是空闲的。
 * <p>
 * 请你设计一个具备以下功能的内存分配器：
 * <p>
 * <p>
 * 分配 一块大小为 size 的连续空闲内存单元并赋 id mID 。 释放 给定 id mID 对应的所有内存单元。
 * <p>
 * <p>
 * 注意：
 * <p>
 * <p>
 * 多个块可以被分配到同一个 mID 。 你必须释放 mID 对应的所有内存单元，即便这些内存单元被分配在不同的块中。
 * <p>
 * <p>
 * 实现 Allocator 类：
 * <p>
 * <p>
 * Allocator(int n) 使用一个大小为 n 的内存数组初始化 Allocator 对象。 int allocate(int size, int mID) 找出大小为 size 个连续空闲内存单元且位于 最左侧 的块，分配并赋
 * id mID 。返回块 的第一个下标。如果不存在这样的块，返回 -1 。 int freeMemory(int mID) 释放 id mID 对应的所有内存单元。返回释放的内存单元数目。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入 ["Allocator", "allocate", "allocate", "allocate", "freeMemory", "allocate", "allocate", "allocate", "freeMemory",
 * "allocate", "freeMemory"] [[10], [1, 1], [1, 2], [1, 3], [2], [3, 4], [1, 1], [1, 1], [1], [10, 2], [7]] 输出 [null, 0,
 * 1, 2, 1, 3, 1, 6, 3, -1, 0]
 * <p>
 * 解释 Allocator loc = new Allocator(10); // 初始化一个大小为 10 的内存数组，所有内存单元都是空闲的。 loc.allocate(1, 1); // 最左侧的块的第一个下标是 0 。内存数组变为
 * [1, , , , , , , , , ]。返回 0 。 loc.allocate(1, 2); // 最左侧的块的第一个下标是 1 。内存数组变为 [1,2, , , , , , , , ]。返回 1 。
 * loc.allocate(1, 3); // 最左侧的块的第一个下标是 2 。内存数组变为 [1,2,3, , , , , , , ]。返回 2 。 loc.freeMemory(2); // 释放 mID 为 2
 * 的所有内存单元。内存数组变为 [1, ,3, , , , , , , ] 。返回 1 ，因为只 有 1 个 mID 为 2 的内存单元。 loc.allocate(3, 4); // 最左侧的块的第一个下标是 3 。内存数组变为
 * [1, ,3,4,4,4, , , , ]。返回 3 。 loc.allocate(1, 1); // 最左侧的块的第一个下标是 1 。内存数组变为 [1,1,3,4,4,4, , , , ]。返回 1 。
 * loc.allocate(1, 1); // 最左侧的块的第一个下标是 6 。内存数组变为 [1,1,3,4,4,4,1, , , ]。返回 6 。 loc.freeMemory(1); // 释放 mID 为 1
 * 的所有内存单元。内存数组变为 [ , ,3,4,4,4, , , , ] 。返回 3 ，因为有 3 个 mID 为 1 的内存单元。 loc.allocate(10, 2); // 无法找出长度为 10
 * 个连续空闲内存单元的空闲块，所有返回 -1 。 loc.freeMemory(7); // 释放 mID 为 7 的所有内存单元。内存数组保持原状，因为不存在 mID 为 7 的内存单元。返回 0 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n, size, mID <= 1000 最多调用 allocate 和 free 方法 1000 次
 * <p>
 * <p>
 * Related Topics 设计 数组 哈希表 模拟 👍 29 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;

class DesignMemoryAllocator {

    public static void main(String[] args) {
        //Solution solution = new DesignMemoryAllocator().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Allocator {

        int[] m;
        int len;

        public Allocator(int n) {
            m = new int[n];
            len = n;
        }

        public int allocate(int size, int mID) {
            int e = 0;
            int free = 0;
            for (int i = 0; i < len; i++) {
                if (m[i] > 0) {
                    free = 0;
                } else {
                    e = i;
                    free++;
                }
                if (free >= size) {
                    Arrays.fill(m, e - size + 1, e+1, mID);
                    return e - size + 1;
                }
            }
            return -1;
        }

        public int freeMemory(int mID) {
            int cnt = 0;
            for (int i = 0; i < len; i++) {
                if (m[i] == mID) {
                    m[i] = 0;
                    cnt++;
                }
            }
            return cnt;
        }
    }

    /**
     * Your Allocator object will be instantiated and called as such:
     * Allocator obj = new Allocator(n);
     * int param_1 = obj.allocate(size,mID);
     * int param_2 = obj.freeMemory(mID);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}