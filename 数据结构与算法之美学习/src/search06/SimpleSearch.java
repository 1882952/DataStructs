package search06;
/*
* 简单二分查找
* */
public class SimpleSearch {
    //非递归的方法（循环）
    public static int bianrySearch(int[] a,int k){
        int low=0,high=a.length-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            if(a[mid]==k){
                return mid;
            }else if(a[mid]<k){
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        return -1;
    }
    //递归的方法
    public static int bsearch(int[] a,int k){
        return bsearchinder(a,0,a.length-1,k);
    }
    private static int bsearchinder(int[] a,int low,int high,int k){
        if(low>high){
            return -1;
        }
        int mid=low+(high-low)/2;
        if(a[mid]==k){
            return mid;
        }else if(a[mid]<k){
            return bsearchinder(a,mid+1,high,k);
        }else {
            return bsearchinder(a,low,mid-1,k);
        }
    }
}
