package 二0年4月;
/*
* 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
示例：
输入： arr = [1,3,5,7,2,4,6,8], k = 4
输出： [1,2,3,4]

思路，使用快排的思路，选择一个分区点，然后按照该分区点左右排序，然后获取下一个分区点，
如果获取的该点刚好是第k个元素，那么前面k个数就是要返回的值。
    否则就继续处理
* */
public class InterView1714 {
    public int[] smallestK(int[] arr, int k) {
        if (k >= arr.length) {
            return arr;
        }
       int low=0;
        int high=arr.length-1;
        while (low<high){
            int p=partition(arr,low,high);
            if(p==k-1){
                break;
            }else if(p<k-1){
                low=p+1;
            }else {
                high=p-1;
            }
        }

        int [] temp=new int[k];
        System.arraycopy(arr,0,temp,0,k);
        return temp;
    }
    //因为是取k个最小元素，所以选择第一个点作为分区点
    private int partition(int[] arr,int left,int right){
        int pivot=arr[left];  //选取第一个点作为分区点
        while (left<right){
            while (left<right && arr[right]>=pivot){
                right--;
            }
            arr[left]=arr[right];
            while (left<right && arr[left]<=pivot){
                left++;
            }
            arr[right]=arr[left];
        }
        arr[left]=pivot;
        return left;
    }
}
