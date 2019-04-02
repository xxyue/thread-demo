package com.example.thread.demo.questions;

/**
 * @Description: ${description}
 * @ClassName: StringQuestuons
 * @Author: yuexx
 * @Date: 2019/3/20 15:46
 * @Version: 1.0
 */
public class StringQuestuons {

    /**
     * 在一个以空格分隔的字符串中，求最长子串长度，
     * 时间和空间复杂度尽可能最优。
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param str
     * @return
     */
    public int getSubstringMaxLength(String str){
        //为空时 直接返回 -1
        if(str == null){
            return -1;
        }
        //去掉前后空格 字符长度为空
        str = str.trim();
        if( "".equals(str)){
            return 0;
        }
        int max = 0;//最大长度
        int i = 0;//累计长度
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if(c == ' '){
                if (i > max) {
                    max = i;
                }
                i = 0;
            }else{
                i++;
            }
        }
        return max;
    }
}
