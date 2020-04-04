package 二零年3月;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
* 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
说明：解集不能包含重复的子集。
示例:
 输入： nums = [1,2,3]
 输出：
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

思路：利用回溯思路解决问题

求一个数组的所有子集，这个问题很经典，需要注意，思路是递归+回朔，
使用一个中间变量，每次循环添加新的字符后，就递归到下一层中添加到要保存的集合中，
在回朔时，就一步步地清除这个中间变量。
 比如 1，2，3，4，		那么就可以为1，1 2，1 2 3，1  2  3  4，
   2， 2 3， 2 3 4，就是这样，所以可以用遍历数组中的每个值，然后每次遍历使用递归。
* */
public class InterView0804 {

    public static void main(String[] args) {
        int[] nums={1,2,4,6,7,8};
        InterView0804 nnn=new InterView0804();
        nnn.subsets(nums);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        backtrank(list,new ArrayList<>(),nums,0);
        return list;
    }

    /**
     * @param list  需要返回的集合
     * @param tempList    //临时集合，保存一个具体的子集
     * @param nums       遍历的数组
     * @param start   //回朔的起点
     */
    public void backtrank(List<List<Integer>> list,List<Integer> tempList,int []nums,int start){
        //先添加子集
        list.add(new ArrayList<>(tempList));
        //具体思路是以数组中的每一位为起点，都向后回朔添加
        for (int i=start;i<nums.length;i++){
            tempList.add(nums[i]);
            backtrank(list,tempList,nums,i+1);  //回朔
            tempList.remove(tempList.size()-1);
            //当递归结束回朔时，每一次清除temp中的最后一位，当回朔完后，temp应为空， 执行下一位的中间变量的保存
        }
    }
}
