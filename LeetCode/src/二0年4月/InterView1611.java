package 二0年4月;
/*
* 你正在使用一堆木板建造跳水板。有两种类型的木板，
* 其中长度较短的木板长度为shorter，长度较长的木板长度为longer。
* 你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。

返回的长度需要从小到大排列。
示例：

输入：
shorter = 1
longer = 2
k = 3
输出： {3,4,5,6}

思路：若两类板长度相同，则形成一个固定的长度 k*len;

当两类板的长度不同时，短板越多则长度越短；

* */
public class InterView1611 {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k==0){
            return new int[0];
        }

        //两类板相同,只有固定长度,这里是用短板作为一个结果的返回值
        if (shorter==longer){
            return new int[]{k*shorter};
        }
        //两类板不同，则遍历k分情况就行
        int[] res=new int[k+1];
        for (int i = 0; i <k+1 ; i++) {
            res[i]=(k-i)*shorter+i*longer;
        }
        return res;
    }
}
