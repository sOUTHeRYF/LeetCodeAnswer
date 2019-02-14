package com.invoker;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        int longestValidParentheses_Result = longestValidParentheses(")()())");
        System.out.println("32.最长有效括号:" + longestValidParentheses_Result);
    }
    //32.最长有效括号
    public static int longestValidParentheses(String s) {
        int length = s.length();

        int subNum = 0;
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
}
