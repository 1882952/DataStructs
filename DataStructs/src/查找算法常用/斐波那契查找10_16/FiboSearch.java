package 查找算法常用.斐波那契查找10_16;

import java.util.Arrays;

//斐波那契查找，有序数组
public class FiboSearch {
    public static int maxSize=20; //斐波那契数组的大小
    public static void main(String[] args) {
        int[] arr={1,8,10,89,1000,1234};
        int index=fiboSearch(arr,1000);
        System.out.println("index:"+index);
    }
    //因为后面使用mid=low+fib（k-1）-1，所以需要获取一个斐波那契数列
    public static int[] fib(){
        //用非递归的方式
        int[] f=new int[maxSize];
        f[0]=1;
        f[1]=1;
        for (int i = 2; i <maxSize; i++) {
            f[i]=f[i-1]+f[i-2];
        }
        return f;
    }
    //key :需要查找的值
    public static int fiboSearch(int []arr,int key){
        int low=0;
        int high=arr.length-1;
        int k=0; //表示斐波那契分割数值的下标
        int mid=0;  //存放中间mid值
        int[] f=fib();  //获取斐波那契数列
        //获取斐波那契分割数值的下标（原因：斐波那契查找是用斐波那契数作下标,且f[k]这个值不一定和这个数组大小相同）
        while (high>f[k]-1){
            k++;
        }
        //因为f【K】可能大于a的长度，因此我们需要使用Arrays类，构造一个新的数组，并指向arr【】
        int[] temp= Arrays.copyOf(arr,f[k]);//不足的部分默认用0补充
        //不足的部分要用arr的最后一位补充
        for (int i = high+1; i <temp.length ; i++) {
                temp[i]=arr[high];
        }
        //使用while来循环处理，找到key
        while (low<=high){
            mid=low+f[k-1]-1;
            if(key<temp[mid]){ //说明应该继续向（斐波那契）数组的左边查找
                high=mid-1;
                //k--说明：因为全部元素=前面的元素+后面的元素，f[k]=f[k-1]+f[k-2],找前一个斐波那契数，即f【k-1】，
                // 因为前面有f【k-1】个元素，可以继续拆分:f[k-1]=f[k-2]+f[k-3]，所以需要k-=1;即下一次循环：mid=low+f[k-1-1]-1，向左
                k-=1;
            }else if(key>temp[mid]){ //向（斐波那契）右边查找
                low=mid+1;
                //k-2说明：同理，找后一个斐波那契数，f【k-2】，而f[k-2]=f[k-3]+f[k-4]可继续拆分,所以需要k-=2;即下一次循环中：mid=low+f[k-1-2]-1,向右
                k-=2;
            }else { //找到
                if(mid<=high){  //由于数组扩容复制high上元素的原因，需要加判断
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }
}
