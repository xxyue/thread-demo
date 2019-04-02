package com.example.thread.demo.questions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

/**
 * @Description: ${description}
 * @ClassName: StringQuestuonsTest
 * @Author: yuexx
 * @Date: 2019/3/20 15:53
 * @Version: 1.0
 */
@RunWith(JUnit4.class)
public class StringQuestuonsTest {

    StringQuestuons stringQuestuons = new StringQuestuons();

    @Test
    public void getSubstringMaxLength0() {
        String str = "a bc defg ghi j k l mn op q";//纯字母
        int max = stringQuestuons.getSubstringMaxLength(str);
        assertEquals(4,max);
    }
    @Test
    public void getSubstringMaxLength1() {
        String str = "345678 05488691 82094879123 40981209";//纯数字
        int max = stringQuestuons.getSubstringMaxLength(str);
        assertEquals(11,max);
    }
    @Test
    public void getSubstringMaxLength2() {
        String str = "阿萨德飞 机离开教室里的房间 辣是京东 飞机啊 搜就佛 教网熊 ";//纯汉子
        int max = stringQuestuons.getSubstringMaxLength(str);
        assertEquals(9,max);
    }
    @Test
    public void getSubstringMaxLength3() {
        String str = "机离开教室里的房间 辣是京东 飞机啊 搜就佛 教网熊 05488691 82094879123  defg ghi";//混合 前后无空格
        int max = stringQuestuons.getSubstringMaxLength(str);
        assertEquals(11,max);
    }
    @Test
    public void getSubstringMaxLength4() {
        String str = " 机离开教室里的房间 辣是京东 飞机啊 搜就佛 教网熊 05488691 82094879123  defg ghi ";//混合 前后有空格
        int max = stringQuestuons.getSubstringMaxLength(str);
        assertEquals(11,max);
    }
    @Test
    public void getSubstringMaxLength5() {
        String str = "    ";//纯空格
        int max = stringQuestuons.getSubstringMaxLength(str);
        assertEquals(0,max);
    }
}