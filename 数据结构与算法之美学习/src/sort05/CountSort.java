package sort05;
/*
* 计数排序，一种特殊的桶排序，关键点在桶内不排序，
* 例如笔记中的0---5分问题，可以用C[6]保存，下标代表分数，对应元素代表小于或等于该分数的人数
* 并且计数排序中的元素得为非负数，如果遇到负数，要先想办法转为正数再进行计数排序
* */
public class CountSort {
    public static void countSort(int[] a,int n){
        if(n<=1){
            return;
        }
        //查找数组中的数据范围
        int max=a[0];
        for (int i = 0; i <a.length ; i++) {
            if(a[i]>max){
                max=a[i];
            }
        }
        //申请一个数组空间，比如创建0-5分对应的数组
        int [] c=new int[max];
        //计算每个元素的个数，放入c中,c保存的就是小于等于当前下标的个数
        for (int i = 0; i <n ; i++) {
            c[a[i]]++; //这里是先把对应的等于该下标的元素统计到
        }
        //依次累加，然后就是保存小于等于的情况，所以要累加
        for (int i = 0; i <max+1 ; i++) {
            c[i]=c[i-1]+c[i];
        }
        //临时数组，存储排序后的结果
        int [] r=new int[n];
        //然后就是关键步骤，从a【n】的末尾开始扫描，将元素放入r的对应位置，原理不好描述，但是笔记上已经很清楚了，画图就行
        for (int i = n-1; i >=0 ; i--) {
            int index=c[a[i]]-1;
            r[index]=a[i];
            c[a[i]]--;
        }
        //将结果拷贝到a数组
        for (int i = 0; i <n ; i++) {
            a[i]=r[i];
        }
    }
}
