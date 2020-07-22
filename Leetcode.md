# Leetcode

## TIP

### 双指针：

1.链表里面是否有环，两个指针快慢一起跑

2.求链表中倒数第k个元素，可以一个指针先走7步，然后两个指针在一起走，之和慢指针那里就指向倒数第k个元素。

3.数组双指针，可以是快慢指针的情况。也可以是双指针在数组左右两边夹逼的这种情况，通常数组是排序的，排好序后，这两个指针他所指向的数的值加在一起表示它的sum，如果sum过小-->左指针右移、右指针左移

---

## 一、数组

### 1.两数之和

[1两数之和 ](https://leetcode-cn.com/problems/two-sum/)

给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

```
示例: 给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
```

```java
//hash    时间复杂度:O(n)
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(target - nums[i])) {
            return new int[]{map.get(target - nums[i]), i};
        }
        map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
}
```

```java
//暴力双循环 空间复杂度:O(n^2)
public int[] twoSum(int[] nums, int target) {
    int[] arr = new int[2];
    int numsSize = nums.length;
    for (int i = 0; i < numsSize - 1; i++) {
        for (int j = i + 1; j < numsSize; j++) {
            if (nums[i] + nums[j] == target) {
                arr[0] = i;
                arr[1] = j;
                return arr;
            }
        }
    }
    return new int[0];
}
```

### 2.盛最多水的容器

[11盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)

给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。

![img](https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/07/25/question_11.jpg)

图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

```
示例：
输入：[1,8,6,2,5,4,8,3,7]
输出：49
```

```java
// O(n^2)  枚举 - left bar x, right bar y, (x-y)*hight_min
public int maxArea(int[] height) {
    int max = 0;
    //遍历有左右边界数组，且不重复
    for (int i = 0; i < height.length - 1 ; i++) {
        for (int j = i + 1; j < height.length; j++) {
            int area = Math.min(height[i], height[j]) * (j - i);
            max = Math.max(area, max);
        }
    }
    return max;
}
```

```java
//O(n) 左右边界i,j向中间收敛 左右夹逼
public int maxArea(int[] height) {
    if (height == null || height.length == 0) {
        return 0;
    }
    int max = 0;
    for (int i = 0, j = height.length - 1; i < j;) {
        int minHight = height[i] < height[j] ? height[i++] : height[j--];
        int area = minHight * (j - i + 1);
        max = Math.max(max, area);
    }
    return max;
}
```

### 3.移动零

[283移动零](https://leetcode-cn.com/problems/move-zeroes/)

给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

```
示例:
输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
```

说明：

​        必须在原数组上操作，不能拷贝额外的数组。
​        尽量减少操作次数。

时间复杂度:O(n)
空间复杂度:O(1)

```java
public void moveZeroes(int[] nums) {
    if (nums == null || nums.length == 0) {
        return;
    }
    //j记录非0元素位置
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) { //如果数组当前元素不等于0
            nums[j] = nums[i];
            if (i != j ){
                nums[i] = 0;
            }
            j++;
        }
    }
}
```

### 4.爬楼梯

[70爬楼梯](https://leetcode.com/problems/climbing-stairs/)

假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。

你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

```
示例 1：
    输入： 2
    输出： 2
    解释： 有两种方法可以爬到楼顶。
 1.  1 阶 + 1 阶
 2.  2 阶
```

```
示例 2：
    输入： 3
    输出： 3
    解释： 有三种方法可以爬到楼顶。
 1.  1 阶 + 1 阶 + 1 阶
 2.  1 阶 + 2 阶
 3.  2 阶 + 1 阶
```

斐波那契： *f*(*x*)=*f*(*x*−1)+*f*(*x*−2)

它意味着爬到第 x 级台阶的方案数是爬到第 x - 1级台阶的方案数和爬到第 x - 2级台阶的方案数的和。很好理解，因为每次只能爬1级或2级，所以f(x)只能从 f(x - 1)和 f(x - 2)转移过来，而这里要统计方案总数，我们就需要对这两项的贡献求和。

![Fn1sqrt5BigBigfrac1sqrt52BignBigfrac1sqrt52BignBig ](p__F_n_=_1_sqrt{5}Big_Big_frac{1+sqrt{5}}{2}Big_^n-Big_frac{1-sqrt{5}}{2}Big_^nBig__.png)

时间复杂度：O*(log*n*)，`pow` 方法将会用去 O*(log*n*) 的时间

空间复杂度：O(1)

```java
//通项公式
public class Solution {
    public int climbStairs(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - 
            Math.pow((1 - sqrt5) / 2, n + 1);
        return (int)(fibn / sqrt5);
    }
}
```

**思路和算法**

我们用 *f(x)* 表示爬到第 *x* 级台阶的方案数，考虑最后一步可能跨了一级台阶，也可能跨了两级台阶，所以我们可以列出如下式子：

                                                                         *f(x) = f(x - 1) + f(x - 2)*

它意味着爬到第 *x* 级台阶的方案数是爬到第 *x - 1* 级台阶的方案数和爬到第 *x - 2* 级台阶的方案数的和。

标签：动态规划 本问题其实常规解法可以分成多个子问题，爬第n阶楼梯的方法数量，等于 2 部分之和

1. 爬上 *n-1* 阶楼梯的方法数量。因为再爬1阶就能到第n阶
2. 爬上 *n-2* 阶楼梯的方法数量，因为再爬2阶就能到第n阶

我们不难通过转移方程和边界条件给出一个时间复杂度和空间复杂度都是 *O(n)* 的实现，但是由于这里的 *f(x)* 只和 *f(x - 1)* 与 *f(x - 2)* 有关，所以我们可以用「滚动数组思想」把空间复杂度优化成 *O(1)*。

```java
//动态规划
public int climbStairs(int n) {
    if (n <= 2) {
        return n < 0 ? 1 : n;
    }
    int f1 = 1, f2 = 2, f3 = 3;
    for (int i = 3; i < n + 1; i++) {
        f3 = f1 + f2;
        f1 = f2;
        f2 = f3;
    }
    return f3;
}
```

```java
public int climbStairs(int n) {
    if (n <= 2) {
        return n < 0 ? 1 : n;
    }
    int[] arr = new int[n + 1];
    arr[1] = 1;
    arr[2] = 2;
    for (int i = 3; i < arr.length; i++) {
        arr[i] = arr[i - 1] + arr[i - 2];
    }
    return arr[n];
}
```

### 5.三数之和

[15三数之和](https://leetcode-cn.com/problems/3sum/)

给你一个包含 *n* 个整数的数组 `nums`，判断 `nums` 中是否存在三个元素 *a，b，c ，*使得 *a + b + c =* 0 ？请你找出所有满足条件且不重复的三元组。

**注意：**答案中不可以包含重复的三元组。

```
示例：
给定数组 nums = [-1, 0, 1, 2, -1, -4]，
满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```

**思路**

- 暴力法搜索为 *O(N^3)* 时间复杂度，可通过双指针动态消去无效解来优化效率。
- **双指针法铺垫：** 先将给定 `nums` 排序，复杂度为 *O(NlogN)*。
- **双指针法思路：** 固定 *3* 个指针中最左（最小）数字的指针 `k`，双指针 `i`，`j` 分设在数组索引 *(k, len(nums))* 两端，通过双指针交替向中间移动，记录对于每个固定指针 `k` 的所有满足 `nums[k] + nums[i] + nums[j] == 0` 的 `i`,`j` 组合：
  1. 当 `nums[k] > 0` 时直接`break`跳出：因为 `nums[j] >= nums[i] >= nums[k] > 0`，即 *3* 个数字都大于 *0* ，在此固定指针 `k` 之后不可能再找到结果了。
  2. 当 `k > 0`且`nums[k] == nums[k - 1]`时即跳过此元素`nums[k]`：因为已经将 `nums[k - 1]` 的所有组合加入到结果中，本次双指针搜索只会得到重复组合。
  3. `i`,`j` 分设在数组索引 `(k, len(nums))` 两端，当`i < j`时循环计算`s = nums[k] + nums[i] + nums[j]`，并按照以下规则执行双指针移动：
     - 当`s < 0`时，`i += 1`并跳过所有重复的`nums[i]`；
     - 当`s > 0`时，`j -= 1`并跳过所有重复的`nums[j]`；
     - 当`s == 0`时，记录组合`[k, i, j]`至`res`，执行`i += 1`和`j -= 1`并跳过所有重复的`nums[i]`和`nums[j]`，防止记录到重复组合。
- **复杂度分析：**
  - 时间复杂度 *O(N^2)*：其中固定指针`k`循环复杂度 *O(N)*，双指针 `i`，`j` 复杂度 *O(N)*。
  - 空间复杂度 *O(1)*：指针使用常数大小的额外空间。

```java
//暴力法搜索为 O(N^3) 
public List<List<Integer>> threeSum(int[] nums) {
    if (nums == null || nums.length == 0) {
        return Collections.emptyList();
    }   
    Arrays.sort(nums); //n*logn
    Set<List<Integer>> result = new LinkedHashSet<>();//判重
    for (int i = 0; i < nums.length - 2; i++) {//三重循环
        for (int j = i + 1; j < nums.length - 1; j++) {
            for (int k = j + 1; k < nums.length; k++) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> value = Arrays.asList(nums[i], nums[j], nums[k]);
                    result.add(value);
                }
            }
        }
    }
    return new ArrayList<>(result);
}
```

```java
 public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> resList = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return resList;
        }
        Arrays.sort(nums); //排序
        for (int i = 0; i < nums.length; i++) {
            //如果最小的数大于0，则不可能三数之和>0
            if (nums[i] > 0) break; 
            //去重,因为已经将nums[k - 1]的所有组合加入到结果中，本次双指针搜索只会得到重复组合。
            if (i > 0 && nums[i] == nums[i - 1]) continue; 
            int l = i + 1, r = nums.length - 1; //左右指针
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    resList.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[++l]);//左边去重
                    while (l < r && nums[r] == nums[--r]);//右边去重
                } else if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                }
            }
        }
        return resList;
 }
```

### 6.加一

[加一](https://leetcode-cn.com/problems/plus-one/)（谷歌、字节跳动、Facebook 在半年内面试中考过）

### 7.合并两个有序数组

[合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)（Facebook 在半年内面试常考）

### 8.删除排序数组中的重复项

[删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)（Facebook、字节跳动、微软在半年内面试中考过）

### 9.旋转数组

[旋转数组](https://leetcode-cn.com/problems/rotate-array/)（微软、亚马逊、PayPal 在半年内面试中考过）

## 二、链表

### 1.反转链表

[206反转链表](https://leetcode.com/problems/reverse-linked-list/)

反转一个单链表。

**示例:**

```
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
```

**进阶:**
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

**双指针迭代**

我们可以申请两个指针，第一个指针叫 pre，最初是指向 null 的。
第二个指针 cur 指向 head，然后不断遍历 cur。
每次迭代到 cur，都将 cur 的 next 指向 pre，然后 pre 和 cur 前进一位。
都迭代完了(cur 变成 null 了)，pre 就是最后一个节点了。

```java
public ListNode reverseList(ListNode head) {
    //申请节点，pre和 cur，pre指向null
    ListNode pre = null;
    ListNode cur = head;
    ListNode tmp = null;
    while(cur!=null) {
        tmp = cur.next;  //记录当前节点的下一个节点
        cur.next = pre; //然后将当前节点指向pre
        pre = cur; //pre和cur节点都前进一位
        cur = tmp;
    }
    return pre;
}
```

**递归解法**

递归的两个条件：

1. 终止条件是当前节点或者下一个节点==null
2. 在函数内部，改变节点的指向，也就是 head 的下一个节点指向 head 递归函数那句

```
head.next.next = head
```

很不好理解，其实就是 head 的下一个节点指向head。
递归函数中每次返回的 cur 其实只最后一个节点，在递归函数内部，改变的是当前节点的指向。

```java
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
}
```

### 2.合并两个有序链表

[21合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/description/)

将两个升序链表合并为一个新的 **升序** 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

**示例：**

```
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
```

**思路**

- 标签：链表、递归
- 这道题可以使用递归实现，新链表也不需要构造新节点，我们下面列举递归三个要素
- 终止条件：两条链表分别名为 l1 和 l2，当 l1 为空或 l2 为空时结束
- 返回值：每一层调用都返回排序好的链表头
- 本级递归内容：如果 l1的 val 值更小，则将 l1.next 与排序好的链表头相接，l2 同理
- O(m+n)，m为l1的长度，n为 l2 的长度

```java
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 == null) {
        return l2;
    } else if (l2 == null) {
        return l1;
    }
    if(l1.val < l2.val) {
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    }else {
        l2.next = mergeTwoLists(l2.next, l1);
        return l2;
    }
}
```

### 3.两两交换链表中的节点

[24两两交换链表中的节点](https://leetcode.com/problems/swap-nodes-in-pairs)

给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

**你不能只是单纯的改变节点内部的值**，而是需要实际的进行节点交换。

**示例:**

```
给定 1->2->3->4, 你应该返回 2->1->4->3.
```

解答：双指针迭代

![迭代.gif](https://pic.leetcode-cn.com/7d8712af4fbb870537607b1dd95d66c248eb178db4319919c32d9304ee85b602-%E8%BF%AD%E4%BB%A3.gif)

```java
public ListNode swapPairs(ListNode head) {
    if(head == null || head.next == null) {
        return head;
    }
    ListNode firstNode = head;
    ListNode secondNode = head.next;
    firstNode.next =  swapPairs(secondNode.next);
    secondNode.next = firstNode;
    return secondNode;
}
```

### 4.环形链表

[141环形链表](https://leetcode.com/problems/linked-list-cycle)

给定一个链表，判断链表中是否有环。

为了表示给定链表中的环，我们使用整数 `pos` 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 `pos` 是 `-1`，则在该链表中没有环。

**示例 1：**

```
输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。
```

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist.png)

**示例 2：**

```
输入：head = [1,2], pos = 0
输出：true
解释：链表中有一个环，其尾部连接到第一个节点。
```

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test2.png)

**示例 3：**

```
输入：head = [1], pos = -1
输出：false
解释：链表中没有环。
```

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test3.png)

解法1：快慢指针

​    通过使用具有 不同速度 的快、慢两个指针遍历链表，空间复杂度可以被降低至 O(1)。慢指针每次移动一步，而快指针每次移动两步。如果列表中不存在环，最终快指针将会最先到达尾部，此时我们可以返回 false。

​    时间复杂度：O(n)

```java
public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
        return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (slow != fast) {
        if (fast == null || fast.next == null) {
            return false;
        }
        slow = slow.next;
        fast = fast.next.next;
    }
    return true;
}
```

解法2：哈希表

​    通过检查一个结点此前是否被访问过来判断链表是否为环形链表。常用的方法是使用哈希表

​    时间复杂度：O(n)

​    空间复杂度：O(n)

```java
public boolean hasCycle(ListNode head) {
    Set<ListNode> nodesSeen = new HashSet<>();
    while (head != null) {
        if (nodesSeen.contains(head)) {
            return true;
        } else {
            nodesSeen.add(head);
        }
        head = head.next;
    }
    return false;
}
```

### 5.环形链表II

[142环形链表 II](https://leetcode.com/problems/linked-list-cycle-ii)

给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 `null`。

为了表示给定链表中的环，我们使用整数 `pos` 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 `pos` 是 `-1`，则在该链表中没有环。

**说明：**不允许修改给定的链表。

**示例 1：**

```
输入：head = [3,2,0,-4], pos = 1
输出：tail connects to node index 1
解释：链表中有一个环，其尾部连接到第二个节点。
```

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist.png)

**示例 2：**

```
输入：head = [1,2], pos = 0
输出：tail connects to node index 0
解释：链表中有一个环，其尾部连接到第一个节点。
```

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test2.png)

**示例 3：**

```
输入：head = [1], pos = -1
输出：no cycle
解释：链表中没有环。
```

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test3.png)

解法1：哈希表

​    用一个 `Set` 保存已经访问过的节点，我们可以遍历整个列表并返回第一个出现重复的节点。

​    时间复杂度：O(n)

​    空间复杂度：O(n)

```java
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<ListNode>();

        ListNode node = head;
        while (node != null) {
            if (visited.contains(node)) {
                return node;
            }
            visited.add(node);
            node = node.next;
        }
        return null;
    }
}
```

解法2：Floyd 算法 快慢指针

![未命名文件.png](https://pic.leetcode-cn.com/2036dfe7e991f00dfb788a9b84a17bb6fac337e81c09bdf57e683d028a6952bc-%E6%9C%AA%E5%91%BD%E5%90%8D%E6%96%87%E4%BB%B6.png)

​    时间复杂度：O(n)

​    空间复杂度：O(1)

```java
public ListNode detectCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    //先判断有无环
    while(true) {
        if (fast == null || fast.next == null) return null;
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) break;
    }
    //找链表连接点
    fast = head;
    while (fast != slow) {
        slow = slow.next;
        fast = fast.next;
    }
    return fast;
}
```

### 6.K 个一组翻转链表

[25K 个一组翻转链表](https://leetcode.com/problems/reverse-nodes-in-k-group/)

| Category   | Difficulty    | Likes | Dislikes |
|:----------:|:-------------:|:-----:|:--------:|
| algorithms | Hard (61.91%) | 643   | -        |

给你一个链表，每 *k* 个节点一组进行翻转，请你返回翻转后的链表。

*k* 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 *k* 的整数倍，那么请将最后剩余的节点保持原有顺序。

**示例：**

给你这个链表：`1->2->3->4->5`

当 *k* = 2 时，应当返回: `2->1->4->3->5`

当 *k* = 3 时，应当返回: `3->2->1->4->5`

**说明：**

- 你的算法只能使用常数的额外空间。
- **你不能只是单纯的改变节点内部的值**，而是需要实际进行节点交换。

```java
public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || head.next == null){
        return head;
    }
    //定义一个假的节点。
    ListNode dummy = new ListNode(0);
    //假节点的next指向head。dummy->1->2->3->4->5
    dummy.next = head;
    //初始化pre和end都指向dummy。pre指每次要翻转的链表的头结点的上一个节点。end指每次要翻转的链表的尾节点
    ListNode pre = dummy;
    ListNode end = dummy;

    while(end.next != null){
        //循环k次，找到需要翻转的链表的结尾,这里每次循环要判断end是否等于空,因为如果为空，end.next会报空指针异常。
        //dummy->1->2->3->4->5 若k为2，循环2次，end指向2
        for(int i = 0;i < k && end != null;i++){
            end=end.next;
        }
        //如果end==null，即需要翻转的链表的节点数小于k，不执行翻转。
        if(end == null){
            break;
        }
        //先记录下end.next,方便后面链接链表
        ListNode next = end.next;
        //然后断开链表
        end.next = null;
        //记录下要翻转链表的头节点
        ListNode start = pre.next;
        //翻转链表,pre.next指向翻转后的链表。1->2 变成2->1。 dummy->2->1
        pre.next=reverse(start);
        //翻转后头节点变到最后。通过.next把断开的链表重新链接。
        start.next=next;
        //将pre换成下次要翻转的链表的头结点的上一个节点。即start
        pre=start;
        //翻转结束，将end置为下次要翻转的链表的头结点的上一个节点。即start
        end=start;
    }
    return dummy.next;


}
//链表翻转
// 例子：   head： 1->2->3->4
public ListNode reverse(ListNode head) {
    //单链表为空或只有一个节点，直接返回原单链表
    if (head == null || head.next == null){
        return head;
    }
    //前一个节点指针
    ListNode preNode = null;
    //当前节点指针
    ListNode curNode = head;
    //下一个节点指针
    ListNode nextNode = null;
    while (curNode != null){
        nextNode = curNode.next;//nextNode 指向下一个节点,保存当前节点后面的链表。
        curNode.next=preNode;//将当前节点next域指向前一个节点   null<-1<-2<-3<-4
        preNode = curNode;//preNode 指针向后移动。preNode指向当前节点。
        curNode = nextNode;//curNode指针向后移动。下一个节点变成当前节点
    }
    return preNode;

}
```

## 三、栈

### 1.有效的括号

[有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)

### 2.最小栈

[最小栈](https://leetcode-cn.com/problems/min-stack/)（亚马逊在半年内面试常考）

## 四、队列

### 1.用 add first 或 add last 这套新的 API 改写 Deque 的代码

### 2.分析 Queue 和 Priority Queue 的源码

### 3.设计循环双端队列

[设计循环双端队列](https://leetcode.com/problems/design-circular-deque)（Facebook 在 1 年内面试中考过）

## 实战题目

### 1.柱状图中最大的矩形

[柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram)（亚马逊、微软、字节跳动在半年内面试中考过）

### 2.滑动窗口最大值

[滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum)（亚马逊在半年内面试常考）

### 3.接雨水

[接雨水](https://leetcode.com/problems/trapping-rain-water/)（亚马逊、字节跳动、高盛集团、Facebook 在半年内面试常考）

## 下周预习

### 预习题目：

- [有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/description/)
- [二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)
- [最小的 k 个数](

---

---

## 参考链接

- [Java Set 文档](http://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Set.html)
- [Java Map 文档](http://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Map.html)

## 课后作业

写一个关于 HashMap 的小总结。
说明：对于不熟悉 Java 语言的同学，此项作业可选做。

## 实战题目 / 课后作业

- [有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/description/)（亚马逊、Facebook、谷歌在半年内面试中考过）
- [字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)（亚马逊在半年内面试中常考）
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