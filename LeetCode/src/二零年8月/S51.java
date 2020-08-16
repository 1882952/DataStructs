package 二零年8月;


/** 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数
 *
 * 思路 ： （1） ： 暴力解法，双层循环遍历判断（超时）
 *        （2） ： 分治思想，利用归并排序来统计逆序对
 *     这里使用归并思路
 */
public class S51 {
    public int reversePairs(int[] nums) {
        return merge(nums,0,nums.length-1);
    }

    int merge(int[] arr,int start,int end){
        if(start>=end){
            return 0;
        }
        //分
        int mid=start+(end-start)/2;
        int count=merge(arr,start,mid)+merge(arr,mid+1,end);

        //并
        int []temp=new int[end-start+1];
        int i=start,j=mid+1,k=0;
        while (i<=mid && j<=end){
            count += arr[i] <= arr[j] ? j - (mid + 1) : 0; //统计逆序对的个数
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i<=mid){
            count+= j-(mid+1);
            temp[k++]=arr[i++];
        }
        while (j<=end){
            temp[k++]=arr[j++];
        }
        System.arraycopy(temp,0,arr,start,end-start+1);
        return count;
    }
}
