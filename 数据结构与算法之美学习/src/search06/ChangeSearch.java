package search06;
/*
* 四种变种的二分查找search,思路比较清晰的写法，
* 一定要掌握二分查找的这种核心思想，取中值，小了往右边找，大了往左边找。
* 对于重复元素的判断。 具体的看笔记复习。
* */
public class ChangeSearch {
    //查找第一个值等于给定值元素的位置
    public static int searchfirst(int []a,int value){
        int low=0;
        int high=a.length-1;
        int mid=0;
        while (low<=high){
            mid=low+((high-low)>>1);
            if(a[mid]>value){
                high=mid-1;
            }else if(a[mid]<value){
                low=mid+1;
            }else { //如果等于，还需要判断是不是第一个该元素的位置
                if(mid==0 || a[mid-1]!=value) return mid; //这是判断第一个的条件
                else {
                    high=mid-1;  //继续向前查找
                }
            }
        }
        return -1;
    }
    //查找最后一个值等于给定值元素的位置
    public static int lastSearch(int []a,int value){
        int low=0,high=a.length-1,mid=0;
        while (low<=high){
            mid=low+((high-low)>>1);
            if(a[mid]<value){
                low=mid+1;
            }else if(a[mid]>value){
                high=mid-1;
            }else {
                if(mid==a.length-1 || a[mid+1]!=value){
                    return mid;
                }else {
                    low=mid+1; //继续向右边找
                }
            }
        }
        return -1;
    }
    //查找第一个大于等于给定值的元素
    public static int gteqSearch(int[] a,int value){
        int low=0,high=a.length-1,mid=0;
        while (low<=high) {
            mid = low + (high - low) / 2;
            if (a[mid] >= value) {
                if (mid == 0 || a[mid - 1] < value) {
                    return mid;
                } else {
                    high = mid - 1; //向左查找第一个
                }
            }else {
                low=mid+1;
            }
        }
        return -1;
    }
    //查找最后一个小于等于给定元素的位置
    public static int smeqSearch(int []a,int value){
        int low=0,high=a.length-1,mid=0;
        while (low<=high){
            mid=low+((high-low)>>1);
            if(a[mid]<=value){
                if(mid==a.length-1 || a[mid+1]>value){
                    return mid; //向右查找最后一个
                }else {
                    low=mid+1;
                }
            }else {
                high=mid-1;
            }
        }
        return -1;
    }
}
