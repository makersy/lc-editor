/**
 * 你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。
 * <p>
 * 如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的 子文件夹 。
 * <p>
 * 文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：'/' 后跟一个或者多个小写英文字母。
 * <p>
 * <p>
 * 例如，"/leetcode" 和 "/leetcode/problems" 都是有效的路径，而空字符串和 "/" 不是。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
 * 输出：["/a","/c/d","/c/f"]
 * 解释："/a/b" 是 "/a" 的子文件夹，而 "/c/d/e" 是 "/c/d" 的子文件夹。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：folder = ["/a","/a/b/c","/a/b/d"]
 * 输出：["/a"]
 * 解释：文件夹 "/a/b/c" 和 "/a/b/d" 都会被删除，因为它们都是 "/a" 的子文件夹。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
 * 输出: ["/a/b/c","/a/b/ca","/a/b/d"]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= folder.length <= 4 * 10⁴
 * 2 <= folder[i].length <= 100
 * folder[i] 只包含小写字母和 '/'
 * folder[i] 总是以字符 '/' 起始
 * 每个文件夹名都是 唯一 的
 * <p>
 * <p>
 * Related Topics 字典树 数组 字符串 👍 120 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.*;

class RemoveSubFoldersFromTheFilesystem {
    public static void main(String[] args) {
        //Solution solution = new RemoveSubFoldersFromTheFilesystem().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Trie{
        Map<String, Trie> children;
        boolean end;

        public void insert(String folder) {
            String[] arr = folder.split("/");
            Trie cur = this;
            for(var item : arr){
                if(item == null || "".equals(item)) continue;
                if(cur.children == null) cur.children = new HashMap<>();
                if (!cur.children.containsKey(item)) {
                    Trie next = new Trie();
                    cur.children.put(item, next);
                    cur = next;
                }else{
                    cur = cur.children.get(item);
                }
            }

            if(cur != this){
                cur.end = true;
            }
        }
    }

    class Solution {
        List<String> res;
        public List<String> removeSubfolders(String[] folder) {
            res = new ArrayList<>();

            Trie head = new Trie();
            for(var item : folder){
                head.insert(item);
            }

            dfs(head, "");
            return res;
        }

        private void dfs(Trie node, String path){
            if(node.children == null) return;
            for(var e : node.children.entrySet()){
                if (e.getValue().end) {
                    res.add(path + "/" + e.getKey());
                }else{
                    dfs(e.getValue(), path + "/" + e.getKey());
                }
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}