# 学习笔记

## 做题四步骤
1. clarification 澄清 -- 与面试官把这道题过一遍
2. possible solutions --> optimal(time & space) 时间空间复杂度最优
3. code
4. test cases
---
## 文档
- [Java Set 文档](http://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Set.html)
- [Java Map 文档](http://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Map.html)

HashMap

---
## Hash
### 1.有效的字母异位词
[242有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/description/)（亚马逊、Facebook、谷歌在半年内面试中考过）
<p>给定两个字符串 <em>s</em> 和 <em>t</em> ，编写一个函数来判断 <em>t</em> 是否是 <em>s</em> 的字母异位词。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> <em>s</em> = &quot;anagram&quot;, <em>t</em> = &quot;nagaram&quot;
<strong>输出:</strong> true
</pre>
<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> <em>s</em> = &quot;rat&quot;, <em>t</em> = &quot;car&quot;
<strong>输出: </strong>false</pre>
<p><strong>说明:</strong><br>
你可以假设字符串只包含小写字母。</p>
<p><strong>进阶:</strong><br>如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？</p>

**解法1【排序】：**
通过将 *s* 的字母重新排列成 *t* 来生成变位词。因此，如果 *T* 是 *S* 的变位词，对两个字符串进行排序将产生两个相同的字符串。此外，如果 *s* 和 *t* 的长度不同，*t* 不能是 *s* 的变位词，我们可以提前返回。
```Java []
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    char[] str1 = s.toCharArray();
    char[] str2 = t.toCharArray();
    Arrays.sort(str1);
    Arrays.sort(str2);
    return Arrays.equals(str1, str2);
}
```
**复杂度分析**

* 时间复杂度：O(nlogn) ，假设 *n* 是 *s* 的长度，排序成本 O(nlogn) 和比较两个字符串的成本 *O(n)*。排序时间占主导地位，总体时间复杂度为 O(nlogn) 。
* 空间复杂度：*O(1)*，空间取决于排序实现，如果使用 `heapsort`，通常需要 *O(1)* 辅助空间。注意，在 Java 中，`toCharArray()` 制作了一个字符串的拷贝，所以它花费 *O(n)* 额外的空间，但是我们忽略了这一复杂性分析，因为：
	* 这依赖于语言的细节。              
	* 这取决于函数的设计方式。例如，可以将函数参数类型更改为 `char[]`。

**解法2 [哈希表]：**
1. 标签：哈希映射
2. 首先判断两个字符串长度是否相等，不相等则直接返回 false
3. 若相等，则初始化 26 个字母哈希表，遍历字符串 s 和 t
4. s 负责在对应位置增加，t 负责在对应位置减少
6. 如果哈希表的值都为 0，则二者是字母异位词

```Java []
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    int[] counter = new int[26];
    for (int i = 0; i < s.length(); i++) {
        counter[s.charAt(i) - 'a']++;
        counter[t.charAt(i) - 'a']--;
    }
    for (int count : counter) {
        if (count != 0) {
            return false;
        }
    }
    return true;
}
```

3. 或者我们可以先用计数器表计算 *s*，然后用 *t* 减少计数器表中的每个字母的计数器。如果在任何时候计数器低于零，我们知道 *t* 包含一个不在 *s* 中的额外字母，并立即返回 FALSE。
```Java []
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    int[] table = new int[26];
    for (int i = 0; i < s.length(); i++) {
        table[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < t.length(); i++) {
        table[t.charAt(i) - 'a']--;
        if (table[t.charAt(i) - 'a'] < 0) {
            return false;
        }
    }
    return true;
}
```

**复杂度分析**

* 时间复杂度：*O(n)*。时间复杂度为 *O(n)* 因为访问计数器表是一个固定的时间操作。 
* 空间复杂度：*O(1)*。尽管我们使用了额外的空间，但是空间的复杂性是 *O(1)*，因为无论 *N* 有多大，表的大小都保持不变。 

**进阶：**
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

**解答：**
使用哈希表而不是固定大小的计数器。想象一下，分配一个大的数组来适应整个 Unicode 字符范围，这个范围可能超过 100万。哈希表是一种更通用的解决方案，可以适应任何字符范围。



### 2.字母异位词分组
- [字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)（亚马逊在半年内面试中常考）




## 实战题目 / 课后作业

- 

- [两数之和](https://leetcode-cn.com/problems/two-sum/description/)（亚马逊、字节跳动、谷歌、Facebook、苹果、微软、腾讯在半年内面试中常考）

## 参考链接

- [养成收藏精选代码的习惯（示例）](http://shimo.im/docs/R6g9WJV89QkHrDhr)





## 参考链接

- [二叉搜索树 Demo](https://visualgo.net/zh/bst)

## 思考题

树的面试题解法一般都是递归，为什么？
说明：同学们可以将自己的思考写在课程下方的留言区一起讨论，也可以写在第 2 周的学习总结中。





## 参考链接

- [树的遍历 Demo](https://visualgo.net/zh/bst)

## 实战题目 / 课后作业

- [二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)（亚马逊、微软、字节跳动在半年内面试中考过）
- [二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)（谷歌、微软、字节跳动在半年内面试中考过）
- [N 叉树的后序遍历](https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/)（亚马逊在半年内面试中考过）
- [N 叉树的前序遍历](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/)（亚马逊在半年内面试中考过）
- [N 叉树的层序遍历](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/)