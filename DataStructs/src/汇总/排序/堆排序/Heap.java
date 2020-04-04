package 汇总.排序.堆排序;
//堆，利用完全二叉树实现，因为二叉树的2n，2n+1为其左右子树，所以很容易用数组替代
//模拟一个大顶堆的所有操作

//总结一个规律：从左到右，上浮；  从右到左，下沉  ，画图明晰。
public class Heap<T extends Comparable<T>> {
    private T [] heap;  //保存数据的数组
    private int N=0;  //有效数据

    public Heap(int maxN) {
        this.heap =(T[]) new Comparable[maxN+1];
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }
    //判断小于(利用compareable接口提供的compareTo，小于即返回-1)
    private boolean less(int i,int j){
        return heap[i].compareTo(heap[j])<0;
    }

    private void swap(int i, int j) {
        T t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }

    //上浮操作，即当一个节点比其父节点大时，就需要交换，这个操作是层级的，所以被称之为上浮
    public void swim(int k){
        while (k>1 && less(k/2,k)){  //less方法，判断k/2即k的父节点比k小
            swap(k,k/2);
            k=k/2;
        }
    }
    //下沉;类似的，当一个节点的值比起子节点值小时，就需要向下交换，简称下沉
    public void sink(int k){
        while (2*k<=N){
            int j=2*k;
            if(j<N && less(j,j+1)){  //这里还要加上左右子节点的大小判断，取大值与该节点交换
                j++;
            }
            swap(k,j);
            k=j;  //层级判断，作为下层左右子节点的父节点
        }
    }
    //插入元素，将新元素放到数组末尾，然后上浮到合适的位置。
    public void insert(Comparable v){
        heap[++N]= (T) v;
        swim(N);   //相当于在堆的末尾加上新值，需要上浮
    }

    //删除堆顶的最大元素，将新元素放到数组末尾，然后下沉到合适的位置。
    public T delMax(){
        T max=heap[1];
        swap(1,N--);  //与末尾元素交换
        heap[N+1]=null;  //将末尾元素置为空
        sink(1);  //将堆顶元素下沉到合适的位置
        return max;
    }



}
