import java.util.Arrays;

/**
 * ClassName:_242IsAngram
 * Package:PACKAGE_NAME
 * Description:
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 异位词:字母出现的次数都是一样的，但是顺序不一样。
 *  示例 1:
 *  输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 *  示例 2:
 *  输入: s = "rat", t = "car"
 * 输出: false
 *
 *  说明: 你可以假设字符串只包含小写字母。
 *  进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * @author:YellowRQ
 * @data:2020/7/21 0:47
 */
public class _242IsAngram {

    /**
     * 1.暴力 sort, sorted_str 相等 ？O(nlogn)
     * 2.hash,map -->统计每个字符的频次
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] charArr1 = s.toCharArray();
        char[] charArr2 = t.toCharArray();
        Arrays.sort(charArr1);
        Arrays.sort(charArr2);
        return Arrays.equals(charArr1, charArr2);
    }

    public boolean isAnagram2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'b']--;
        }
        for (int i : counter) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
