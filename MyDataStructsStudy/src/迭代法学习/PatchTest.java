package 迭代法学习;

/**
 * 通过迭代， 利用二分思想， 进行同义词匹配
 *
 * 但是利用二分，有一个基本原则，就是必须得排序，不排序，无法使用二分、
 *
 * 简单二分法回忆法
 */

public class PatchTest {

    /** * @Description: 查找某个单词是否在字典里出现 * @param dictionary-排序后的字典, wordToFind-待查的单词 * @return boolean-是否发现待查的单词 */
    public static boolean search(String[] dictionary, String wordToFind){
        if(dictionary.length==0 || dictionary== null){
            return false;
        }

        int left =0, right = dictionary.length-1;
        while (left<=right){
            int middle = (left+right)/2;
            if(dictionary[middle].equals(wordToFind)){
                return true;
            }else if(wordToFind.compareTo(dictionary[middle])<0){
                left++;
            }else {
                middle--;
            }
        }
        return false;
    }

}
