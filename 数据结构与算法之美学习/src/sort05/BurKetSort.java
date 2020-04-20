package sort05;
/*
* 桶排序
* */
public class BurKetSort {

    public static void bucketsort(int[] arr,int bucketSize){
        if(arr.length<2){
            return;
        }
        //利用数组的最大值与最小值，确定桶的数量
        int min=arr[0];
        int max=arr[1];
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]<min){
                min=arr[i];
            }else if(arr[i]>max){
                max=arr[i];
            }
        }
        //桶数量
        int bucketCount=(max-min)/bucketSize+1;
        int[][] buckets=new int[bucketCount][bucketSize];

        int[] indexArr=new int[bucketCount]; //每个桶中的实际容量
        //将数组中的数据分配到桶中
        for (int i = 0; i <arr.length ; i++) {
            int bucketIndex=(arr[i]-min)/bucketSize; //找出该元素对应的桶的下标
            if(indexArr[bucketIndex]==buckets[bucketIndex].length){
                ensureCapacity(buckets,bucketIndex);
            }
            buckets[bucketIndex][indexArr[bucketIndex]++]=arr[i];
        }
        //然后利用快排对每个桶数组进行排序
        int k=0;
        for (int i = 0; i <buckets.length ; i++) {
            if(indexArr[i]==0){
                continue;
            }
            quick_c(buckets[i],0,indexArr[i]-1);
            //然后将排序好的桶依次添加到原数组中
            for (int j = 0; j <indexArr[i] ; j++) {
                arr[k++]=buckets[i][j];
            }
        }
    }
    /**
     * 数组扩容
     *
     * @param buckets
     * @param bucketIndex
     */
    private static void ensureCapacity(int[][] buckets, int bucketIndex) {
        int[] tempArr = buckets[bucketIndex];
        int[] newArr = new int[tempArr.length * 2];
        for (int j = 0; j < tempArr.length; j++) {
            newArr[j] = tempArr[j];
        }
        buckets[bucketIndex] = newArr;
    }

    private static void quick_c(int []a,int p,int r){
        if(p>=r){
            return;
        }
        //先利用分区点分区
        int q=partition(a,p,r);
        //然后再递归分成子问题分区
        quick_c(a,p,q-1);
        quick_c(a,q+1,r);
    }
    //分区的方法，并返回分区点，这里是利用了末位元素作为分区点
    private static int partition(int[] a,int p,int r){
        int privot=a[r];
        int i=p;  //i为分区点位置，从当前数组头部开始
        for (int j=p;j<r;j++){
            if(a[j]<privot){  //如果当前元素小于分区点元素，那么就将该元素添加到i处，不懂了看笔记
                if(i==j){
                    i++;
                }else {
                    swap(a, i, j);
                    i++;
                }
            }
        }
        swap(a,i,r);
        return i;
    }
    private static void swap(int[] a,int x,int y){
        int tmp=a[x];
        a[x]=a[y];
        a[y]=tmp;
    }
}
