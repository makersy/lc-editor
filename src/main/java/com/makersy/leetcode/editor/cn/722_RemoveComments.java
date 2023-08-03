package com.makersy.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class RemoveComments {
    public static void main(String[] args) {
        //Solution solution = new RemoveComments().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> removeComments(String[] source) {
            List<String> res = new ArrayList<String>();
            StringBuilder newLine = new StringBuilder();
            boolean inBlock = false;
            for (String line : source) {
                for (int i = 0; i < line.length(); i++) {
                    if (inBlock) {
                        if (i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                            inBlock = false;
                            i++;
                        }
                    } else {
                        if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                            inBlock = true;
                            i++;
                        } else if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                            break;
                        } else {
                            newLine.append(line.charAt(i));
                        }
                    }
                }
                if (!inBlock && newLine.length() > 0) {
                    res.add(newLine.toString());
                    newLine.setLength(0);
                }
            }
            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}