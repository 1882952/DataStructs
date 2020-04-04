package 排序.冒泡排序09_30.基数排序10_14;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr={53,3,542,748,14,214};
        //radixSort(arr);
        radixSortE(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void radixSort(int[] arr){
        //第一轮排序：针对个位数排序，依次放入桶中
        //定义二维数组，表示十个桶,防止数据溢出，每个桶的大小定义为arr.length,空间换时间
        int[][] bucket=new int[10][arr.length];
        //为了记录每个桶实际存放了多少个数据，定义一个一维数组，记录各个桶的每轮排序放入的数据（开始下一轮时桶需要清空）
        int[] bucketElementCounts=new int[10];
        for (int j=0;j<arr.length;j++){
            //取出每个元素的个位
            int digitofElement=arr[j]%10;
            //放入到对应的桶中，bucketElementCounts[digitofElement]对应的桶中元素个数，初始为0，每放入一个数+1
            bucket[digitofElement][bucketElementCounts[digitofElement]]=arr[j];
            bucketElementCounts[digitofElement]++;
        }
        //按照这个桶的顺序（一维数组的下标依次取出数，放入原来的数组中）
        int index=0;
        //遍历每一个桶，并将桶中的元素放入原数组
        for (int k=0;k<bucketElementCounts.length;k++){
            if(bucketElementCounts[k]!=0){ //判断桶里有没有数据
                for (int l=0;l<bucketElementCounts[k];l++){  //bucketElementCounts[k]:对应的值代表桶里数据的长度
                    arr[index]=bucket[k][l];
                    index++;
                }
            }
            //第一轮处理完后，需要将bucketElementCounts数组中的对应元素清零,二维数组不需要清理，因为下一轮中值会覆盖，不影响
            bucketElementCounts[k]=0;
        }
        System.out.println(Arrays.toString(arr));
        //第二轮排序
        for (int j=0;j<arr.length;j++){
            //取出每个元素的十位
            int digitofElement=arr[j]/10%10;
            //放入到对应的桶中，bucketElementCounts[digitofElement]对应的桶中元素个数，初始为0，每放入一个数+1
            bucket[digitofElement][bucketElementCounts[digitofElement]]=arr[j];
            bucketElementCounts[digitofElement]++;
        }
        //按照这个桶的顺序（一维数组的下标依次取出数，放入原来的数组中）
         index=0;
        //遍历每一个桶，并将桶中的元素放入原数组
        for (int k=0;k<bucketElementCounts.length;k++){
            if(bucketElementCounts[k]!=0){ //判断桶里有没有数据
                for (int l=0;l<bucketElementCounts[k];l++){  //bucketElementCounts[k]:对应的值代表桶里数据的长度
                    arr[index]=bucket[k][l];
                    index++;
                }
            }
            //第二轮处理完后，需要将bucketElementCounts数组中的对应元素清零,二维数组不需要清理，因为下一轮中值会覆盖，不影响
            bucketElementCounts[k]=0;
        }
        System.out.println(Arrays.toString(arr));
        //第三轮同理，看百位即可
    }
    //归纳 ,每一轮的排序位数其实都是/10^i%10 ,个位i=0
    public static void radixSortE(int[] arr){
        //得到数组中最大的数的位数
        int max=arr[0];
        for (int i = 1; i <arr.length ; i++) {
            if(arr[i]>max){
                max=arr[i];
            }
        }
        int maxLength=(max+"").length();

        //定义二维数组，表示十个桶,防止数据溢出，每个桶的大小定义为arr.length,空间换时间
        int[][] bucket=new int[10][arr.length];
        //为了记录每个桶实际存放了多少个数据，定义一个一维数组，记录各个桶的每轮排序放入的数据（开始下一轮时桶需要清空）
        int[] bucketElementCounts=new int[10];
        for (int i = 0,n=1; i <maxLength ; i++,n*=10) {
            for (int j=0;j<arr.length;j++){
                //取出每个元素的个位
                int digitofElement=arr[j]/n%10;
                //放入到对应的桶中，bucketElementCounts[digitofElement]对应的桶中元素个数，初始为0，每放入一个数+1
                bucket[digitofElement][bucketElementCounts[digitofElement]]=arr[j];
                bucketElementCounts[digitofElement]++;
            }
            int index=0;
            //遍历每一个桶，并将桶中的元素放入原数组
            for (int k=0;k<bucketElementCounts.length;k++){
                if(bucketElementCounts[k]!=0){ //判断桶里有没有数据
                    for (int l=0;l<bucketElementCounts[k];l++){  //bucketElementCounts[k]:对应的值代表桶里数据的长度
                        arr[index]=bucket[k][l];
                        index++;
                    }
                }
                //第一轮处理完后，需要将bucketElementCounts数组中的对应元素清零,二维数组不需要清理，因为下一轮中值会覆盖，不影响
                bucketElementCounts[k]=0;
            }
        }
    }

}
