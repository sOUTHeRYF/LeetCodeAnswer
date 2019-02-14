package com.invoker;

import com.invoker.struct.*;
public class Main {

    public static void main(String[] args) {

        int longestValidParentheses_Result = longestValidParentheses(")()())");
        System.out.println("32.最长有效括号:" + longestValidParentheses_Result);
    }
    //01. 两数之和
    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for(int i = 0;i<length;i++)
        {
            for(int j = i+1;j<length;j++)
            {
                if(nums[i] + nums[j] == target)
                    return new int[]{i,j};
            }
        }
        return null;
    }
    //02. 两数相加
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode zero = new ListNode(0);
        ListNode result = new ListNode(0);
        ListNode head = result;
        ListNode pre = null;
        int step = 0;
        while(true)
        {
            int sum = l1.val + l2.val + step;
            result.val = sum % 10;
            step = sum>=10?1:0;
            result.next = new ListNode(0);
            l1 = l1.next!=null?l1.next:zero;
            l2 = l2.next!=null?l2.next:zero;
            pre = result;
            result = result.next;
            if(l1 == zero && l2 == zero)
            {
                pre.next = step==1?new ListNode(1):null;
                return head;
            }

        }

    }
    //32. 最长有效括号
    public static int longestValidParentheses(String s) {
        int length = s.length();

        int result = 0;
        int currentStart = 0;
        int currentIndex = 0;

        while(currentStart < length -1 )
        {
            int currentMaker = 0;
            currentIndex = currentStart;
            while(currentIndex < length)
            {
                int legalNum = (length - currentIndex - 1);
                char currentChar = s.charAt(currentIndex);
                switch(currentChar)
                {
                    case '(':currentMaker ++;break;
                    case ')':currentMaker --;break;
                    default:break;
                }
                if(currentMaker > 0 && currentMaker <= legalNum)
                {
                    currentIndex++;
                    continue;
                }
                if(currentMaker < 0 || currentMaker > legalNum)
                {
                    break;
                }
                if(currentMaker == 0)
                {
                    int currentLength = currentIndex - currentStart + 1;
                    result = currentLength > result ? currentLength : result;
                    currentIndex++;
                    continue;
                }
            }
            currentStart ++;
        }
        return result;

    }
    //560. 和为K的子数组
    public static int subarraySum(int[] nums, int k) {
        int result = 0;
        int length = nums.length;
        int arrays[] = new int[length];
        for(int i=0;i<length;i++)
        {
            arrays[i] = 0;
            for(int j = 0;j<i+1;j++)
            {
                arrays[j] += nums[i];
                if(arrays[j] == k)
                    result ++;
            }
        }
        return result;
    }
    //595. 大的国家
    public String SQL595 = "select e.name,e.population,e.area from World as e where e.population > 25000000 union select e.name,e.population,e.area from World as e where e.area > 3000000";
}
