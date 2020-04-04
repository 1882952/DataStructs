package 查找算法常用.插值查找10_16;
//插值查找算法是对二分查找的改进，也需要有序数组
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr=new int[100];
        for (int i = 0; i <100 ; i++) {
            arr[i]=i+1;
        }
        int index=insertValSearch(arr,0,arr.length-1,99);
        System.out.println("index:"+index);
    }
    public static int insertValSearch(int[] arr,int left,int right,int findVal){
        System.out.println("-----------------------");
        if(left>right || findVal<arr[0] || findVal>arr[arr.length-1]){
            return -1;
        }
        //这是插值查找与二分查找的的区别，mid的这个公式需要记住
        int midIndex=left+(right-left)*(findVal-arr[left])/(arr[right]-arr[left]);
        int midVal=arr[midIndex];
        if(findVal>midVal){ //向右边递归
            return insertValSearch(arr,midIndex+1,right,findVal);
        }else if(findVal<midVal){
            return insertValSearch(arr,left,midIndex-1,findVal);
        }
        return midIndex;
    }
}
