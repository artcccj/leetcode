package org.artcccj.leetcode.str;

public class ContainsAndStartIndex {

    public int strStr(String haystack, String needle) {
        assert haystack != null;
        assert needle != null;

        if (needle.trim().equals("")) {
            return 0;
        }

        int len = haystack.length();
        int needleLen = needle.length();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < needleLen && i + j < len; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }

                if (j == needleLen - 1) {
                    return i;
                }
            }
        }

        return -1;
    }
}
