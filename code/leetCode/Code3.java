package cn.longq.code;

/**
 * @description:
 * @author: Liu Hualong
 * @created: 2021/04/28 09:12
 */
public class Code3 {

    public static void main(String[] args) {

        int i = lengthOfLongestSubstring("abba");
        System.out.println(i);
    }

    // 桶方法 未正确
    public static int lengthOfLongestSubstring(String s) {
        int[] arr = new int[128];
        int max = 0;
        int var = 0;
        for (int i =0;i<s.length();i++){
            int a  = arr[s.charAt(i)];
            if (a == 0){
                arr[s.charAt(i)] = i+1;
                var ++;
            }else {
                var = i - a +1;
                arr[s.charAt(i)] = i+1;
            }
            max = max > var ? max : var;
        }
        return max;
    }

    // 窗口滑动  正确
    public static int lengthOfLongestSubstring1(String s) {
        int max = 0;
        int var = 0;
        for (int i = 0;i<s.length();i++){
            if (var == 0){
                var+=1;
                max = max > var ? max : var;
                continue;
            }
            int var1 = 0;
            for (int j =0;j<var;j++){
                if (s.charAt(i) == s.charAt(i + j - var)){
                    var -=j;
                    var1 = 1;
                    break;
                }
            }
            if (var1 == 0){
                var +=1;
            }
            max = max > var ? max : var;
        }
        return max;
    }

    public static int lengthOfLongestSubstring0(String s) {
        if (s.length() == 0) return 0;
        int max = 1;
        int var = 1;
        for (int i = 1;i<s.length();i++){
            int var1 = -1;
            for (int j = 1; j <= var ;j++){
                if (s.charAt(i-j) == s.charAt(i)){
                    var1 = j;
                }
            }
            if (var1 == -1){
                var +=1;
                max = var < max ? max:var;
            }else if (var !=1){
                var = var - var1;
            }
        }
        return max;
    }

}
