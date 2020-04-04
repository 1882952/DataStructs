package 二0年4月;
/*
* 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，
* 找出给定字符串的位置。
示例1:
 输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 输出：-1
 说明: 不存在返回-1。
示例2:
 输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 输出：4

 思路：使用二分查找,但是这里需要考虑空字符串的情况
* */
public class InterView1005 {
    public int findString(String[] words, String s) {
        if(words==null || words.length==0){
            return -1;
        }
        int left=0,right=words.length-1;
        while (left<=right){
            //如果left或right指针的当前位置为空，则left++或者right--；
            while (left<=right && words[left].length()==0){
                left++;
            }
            while (right>=left && words[right].length()==0){
                right--;
            }
            int mid=left+((right-left)>>>1);
            //如果mid的位置为空，则mid++；
            while (mid<right && words[mid].length()==0){
                mid++;
            }
            //二分查找模板
            if (words[mid].equals(s)){
                return mid;
            }else if(words[mid].compareTo(s)>0){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return -1;
    }
}
