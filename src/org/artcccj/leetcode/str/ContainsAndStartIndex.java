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

        for (int i = 0; i <= len - needleLen; i++) {
            int j = 0;
            for (; j < needleLen && i + j < len; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needleLen) {
                return i;
            }
        }

        return -1;
    }

    /**
     * KMP
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStrV2(String haystack, String needle) {
        assert haystack != null;
        assert needle != null;

        if (needle.trim().equals("")) {
            return 0;
        }

        int len = haystack.length();
        int needleLen = needle.length();

        char[] hc = haystack.toCharArray();
        char[] nc = needle.toCharArray();

        int nextStartIndex = -1;
        char needleStart = nc[0];

        for (int i = 0; i < len - needleLen; i++) {
            int j = 0;
            for (; j < needleLen && i + j < len; j++) {
                if (hc[i + j] != nc[j]) {
                    if (nextStartIndex != -1) {
                        i = nextStartIndex;
                        nextStartIndex = -1;
                    }
                    break;
                }

                if (nextStartIndex == -1 && hc[i + j] == needleStart) {
                    nextStartIndex = i + j;
                }
            }

            if (j == needleLen) {
                return i;
            }
        }

        return -1;
    }
}
