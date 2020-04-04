package 二零年3月;
/*
* 搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，
* 次数不详。请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。
* 若有多个相同元素，返回索引值最小的一个。

示例1:
 输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
 输出: 8（元素5在该数组中的索引）
示例2:
 输入：arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 11
 输出：-1 （没有找到）

 思路：利用二分查找，关键是利用二分， 这道题与力扣33题相似，
 采用非递归的思路，数组是有序的旋转数组。   因为是有重复值的，所以不能用mid值判断target，需要用left值判断target

 没有重复值的最优情况时间复杂度是O(log N)，全部或几乎全部是重复值的最差情况时间复杂度是O(N)。

                                    nums[left] <= target
                              ┌─  && target <= nums[mid]   ──>  right = mid
                              │   （目标在左边的升序区间中）         （右边界移动到mid）
  ┌─  nums[left] < nums[mid] ─┼
  │     （左边区间升序）         │
  │                           └─    否则目标在右半边          ──>  left = mid + 1
  │                                                             （左边界移动到mid+1）
  │
  │                                 nums[left] <= target
  │                           ┌─  || target <= nums[mid]   ──>  right = mid
  │                           │    （目标在左半边）                （右边界移动到mid）
 ─┼─  nums[left] > nums[mid] ─┼
  │     （左边不是升序）         │
  │                           └─    否则目标在右半边          ──>  left = mid + 1
  │                                                              （左边界移动到mid+1）
  │
  │
  │                           ┌─   nums[left] != target    ──>  left++
  │                           │     （左值不等于目标               （需要逐一清理重复值）
  └─ nums[left] == nums[mid] ─┼         说明还没找到）
      （可能是已经找到了目标      │
        也可能是遇到了重复值）    └─   nums[left] == target    ──>  right = left
                                    （左值等于目标                 （将右边界移动到left，循环结束）
                                      已经找到最左边的目标值）
 总之，使用左值和中值来判断。
* */
public class InterView1003 {
    public int search(int[] arr, int target) {
        if(arr==null || arr.length==0){
            return -1;
        }
        int start=0;
        int end=arr.length-1;
        int mid;
        while (start<end){
            mid=start+(end-start)/2;
            if(arr[start]<arr[mid]){ //左边的区间是升序
                if(arr[start]<=target && target<=arr[mid]){ //目标在左边的升序区间中
                    end=mid;
                }else { //否则目标在右半边
                    start=mid+1;
                }
            }else if(arr[start]>arr[mid]){ //左边区间不是升序
                if(arr[start]<=target || target<=arr[mid]){  //目标在左半边，仍将end设置为mid
                    end=mid;
                }else {  //在右半边
                    start=mid+1;
                }
            }else if(arr[start]==arr[mid]){ //用最左边的值判断target
                if (arr[start]!=target){
                    start++;
                }else {
                    end=start;  //停止循环
                }
            }
        }
        return (arr[start]==target) ? start : -1;
    }

    //使用递归，使用递归比较容易自己能写出来。
    public int search1(int[] arr, int target) {
        return bsf(arr, 0, arr.length - 1, target);
    }
    public int bsf(int[] arr, int l, int r, int target){
        if(l <= r){
            int mid = (l + r) / 2;
            if(arr[mid] == target){//找到后，继续向左，看是否有比他小的下标
                int left = bsf(arr, l, mid - 1, target);
                if(left > -1 && left < mid)return left;
                return mid;
            }else{
                int left = bsf(arr, l, mid - 1, target);
                int right = bsf(arr, mid + 1, r, target);
                if(left > -1)return left;
                if(right > -1)return right;
            }
        }
        return -1;
    }
}
