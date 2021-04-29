package cn.longq.code;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 *
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * @author: Liu Hualong
 * @created: 2021/04/27 15:24
 */
public class Code2 {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9)))))));
        ListNode l2 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9))));

        ListNode node = addTwoNumbers(l1, l2);
        while (node!= null){
            System.out.println(node.val);
            node=node.next;
        }
    }




    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return root.next;
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        add(l1, l2, node);
        if (node.val == 0){
            return node.next;
        }
        return node;
    }

    public static   ListNode add(ListNode l1,ListNode l2,ListNode node){
        int var1 =0 ;
        ListNode add = null;
        if (l1 != null && l2!=null){
            add = add(l1.next, l2.next, node);
            var1 = l1.val +l2.val;
        }else if (l1 == null && l2 != null){
            add = add(null, l2.next, node);
            var1 = l2.val;
        }else if (l1!= null && l2 ==null){
            add = add(l1.next, null, node);
            var1 = l1.val;
        }else {
            return node;
        }
        ListNode current = new ListNode();  //当前
        int var2 =  add.val;
        if (var2 > 9){
            add.val = var2 % 10;
            current.val = (1+var1);
        }else {
            current.val = var1;
        }
        add.next = current;
        return current;
    }

/*    public ListNode add(ListNode l1,ListNode l2,ListNode node){
        if (l1==null && l2 == null){
            return node;
        }
        int var1 =0 ;
        ListNode add = null;
        if (l1 != null && l2!=null){
            add = add(l1.next, l2.next, node);
            var1 = l1.val +l2.val;
        }else if (l1 == null && l2 != null){
            add = add(null, l2.next, node);
            var1 = l2.val;
        }else if (l1!= null && l2 ==null){
            add = add(l1.next, null, node);
            var1 = l1.val;
        }
        if (add == null){
            add = new ListNode();
        }
        var1 += add.val;
        add.val = var1 % 10;
        if (var1+ add.val > 9){
            ListNode n = new ListNode();
            n.val = var1/10;
            add.next = n;
        }
        return add.next;
    }*/












}














class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
