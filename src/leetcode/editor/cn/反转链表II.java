package leetcode.editor.cn;

//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表 
// 👍 607 👎 0

import java.util.List;

public class 反转链表II {
    public static void main(String[] args) {
        Solution solution = new 反转链表II().new Solution();

        ListNode head1 =new 反转链表II().new ListNode(1);
        ListNode head2 = new 反转链表II().new ListNode(2);
        ListNode head3 = new 反转链表II().new ListNode(3);
        ListNode head4 = new 反转链表II().new ListNode(4);
        ListNode head5 =  new 反转链表II().new ListNode(5);
        head1.next=head2;
        head2.next=head3;
        head3.next=head4;
        head4.next=head5;
        ListNode revList = solution.reverseBetween(head1, 2, 4);
        System.out.println(revList);
    }



    /**
     * Definition for singly-linked list.
     */
     class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return  val +
                    "  " + next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            //region 自己的方法
//            if (head == null||head.next==null) {
//                return head;
//            }
        /*
        思路：1.遍历找到对应的节点，该位置之前全部复制到新的链表
             2.而后开始反转插入，一直到n，
         */
//            ListNode curNode = head;
//            ListNode reStart = null;
//            ListNode tempNode = null;
//            ListNode next = null;
//            while (curNode != null && curNode.next.val != m) {
//                curNode = curNode.next;
//            }
//            if (curNode == null) {
//                return head;
//            }
//            if (curNode.next.val == m) {
//                tempNode = curNode;
//                reStart = curNode.next;//保存
//                //开始反转
//                while (tempNode != null && tempNode.val != n) {
//                    next=tempNode.next;
//                    tempNode.next=curNode.next;
//                    curNode.next=tempNode;
//                    tempNode=next;
//                }
//                if (tempNode.val == n) {
//                    next=tempNode.next;
//                    tempNode.next=curNode.next;
//                    curNode.next=tempNode;
//                    tempNode=next;
//                }
//                //拼接结束
//                reStart.next = tempNode;
//            }
//            return head;
            //endregion

            //借鉴 双指针解决
            //currHead节点指向第一次节点m，tempHead节点一直往后
            //创建一个头结点，指向当前节点
            ListNode headNode = new ListNode(0);
            headNode.next=head;
            ListNode currHead = headNode;
            ListNode tempHead = headNode.next;
            int step = 0;//设置步长
            while (step<m-1){
                currHead=tempHead;
                tempHead=tempHead.next;
                step++;
            }
            //开始反转,先把要插入的节点摘出来，然后插入
            for (int i = 0; i < n - m; i++) {
                ListNode next = tempHead.next;
                tempHead.next=tempHead.next.next;
                next.next=currHead.next;
                currHead.next=next;

            }
            return headNode.next;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}