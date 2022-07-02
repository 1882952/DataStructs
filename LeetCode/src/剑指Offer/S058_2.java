package 剑指Offer;

/**
 *  左旋字符串
 *  定义一个实现左旋操作的功能，
 *
    思路：使用一个StringBuilder拼接就行
 */
public class S058_2 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i <s.length() ; i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < n ; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
