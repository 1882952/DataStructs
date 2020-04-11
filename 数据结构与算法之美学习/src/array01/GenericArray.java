package array01;

import java.util.ArrayList;

//动态的数组
public class GenericArray<T> {
    //可以用ArrayList作为比较
    private ArrayList<Integer> a;

    private T [] data;
    private int size;  //实际数据的个数

    public GenericArray(int capacity) {
        this.size = 0;
        this.data=(T [])new Object[capacity];
    }
    //无参的构造方法，默认大小为10
    public GenericArray(){
        this(10);
    }
    //获取数组容量
    public int getCapacity(){
        return data.length;
    }
    //获取当前元素的个数
    public int getCount(){
        return size;
    }
    //判断数组是否为空
    public boolean isEmpty(){
        return size==0 ? true : false;
    }
    //修改index的位置元素
    public void set(int index,T e){
        checkIndex(index);
        data[index]=e;
    }

    //获取对应的index位置上的元素
    public T get(int index){
        checkIndex(index);
        return data[index];
    }

    //查看数组是否包含元素E ，这里直接暴力
    public boolean contains(T e){
        for (int i = 0; i <size ; i++) {
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }
    //获取对应下标的元素，未找到返回-1
    public int find(T e){
        for (int i = 0; i <size ; i++) {
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    //在index上，添加元素，时间复杂度：O（m+n）
    public boolean add(int index,T e){
        checkIndexForAdd(index);
        //需要考虑扩容问题，这里的策略是扩容两倍
        if(size==data.length){ //需要扩容  O(n)
            resize(2*data.length);
        }
        //先移动数组(以index位置为起点后的数组都要移动)，再将新值添加到index，
        for(int i=size;i>index;i--){  //O(m)
            data[i]=data[i-1];
        }
        data[index]=e;
        ++size;
        return true;
    }
    //向数组头添加元素
    public void addFirst(T e){add(0,e);}
    //向数组尾部添加元素
    public void addLast(T e){add(size,e);}

    //删除数组中index位置的元素 ，删除完了就要考虑缩容问题O（m+n）
    public T remove(int index){
        checkIndex(index);

        T ret=data[index];
        for (int i=index+1;i<size;i++){
            data[i-1]=data[i];
        }
        size--;
        data[size]=null; //最后一位置为空
        //考虑缩容，当size小于数组的四分之一时，缩容
        if(size==data.length/4 && data.length/2!=0){
            resize(data.length/2);
        }
        //缩容
        return ret;
    }

    //同理，删除头结点与尾节点并获取
    public T removeFirst(){
        return remove(0);
    }
    public T removeLast(){
        return remove(size-1);
    }

    //从数组中删除指针的元素，先查出index，再删除
    public void removeElement(T e){
        boolean flag=true;
        while (flag) {  //这里稍微改了一下，删除数组中所有该元素
            int index = find(e);
            if (index != -1) {
                remove(index);
            }else {
                flag=false;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("Array size = %d , capacity = %d  \n",size,data.length));
        sb.append('[');
        for (int i = 0; i <size ; i++) {
            sb.append(data[i]);
            if(i!=size-1){
                sb.append(',');
            }
        }
        sb.append(']');
        return sb.toString();
    }

    //扩容的方法,创建新的数组，将原数组复制过去,时间复杂度O（n）
    private void resize(int capacity){
        T[] temp=(T [])new Object[capacity];
        for (int i = 0; i <size ; i++) {
            temp[i]=data[i];
        }
        data=temp;
    }

    //判断下标是否是有效的下标 ，判断下标有效不有效是利用size属性的，因为要连续添加，不能留空位，所以不能用数组长度作为判断依据
    public void checkIndex(int index){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("Add failed! Require index >=0 and index < size.");
        }
    }

    private void checkIndexForAdd(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("remove failed! Require index >=0 and index <= size.");
        }
    }
}
