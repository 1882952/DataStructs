package src.分治思想;
/*
* 问题：如何求出一组数据逆序对的个数
* 利用分治思想：我们可以将数组分成前后两半 A1 和 A2，分别计算 A1 和 A2 的逆序对个数 K1 和 K2，然后再计算 A1 与 A2 之间的逆序对个数 K3。
* 那数组 A 的逆序对个数就等于 K1+K2+K3。
*
* 而这个过程可以借助归并，稍微改一下归并的代码就行，详细的就是添加统计逆序对的操作。
* */
public class DividDemo {

    private int num = 0; // 逆序对的个数。

    public int count(int[] a, int n) {
        num = 0;
        mergeSortCounting(a, 0, n-1);
        return num;
    }

    private void mergeSortCounting(int[] a, int p, int r) {
        if (p >= r) return;
        int q = (p+r)/2;
        mergeSortCounting(a, p, q);
        mergeSortCounting(a, q+1, r);
        merge(a, p, q, r);
    }

    private void merge(int[] a, int p, int q, int r) {
        int i = p, j = q+1, k = 0;
        int[] tmp = new int[r-p+1];
        while (i<=q && j<=r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                num += (q-i+1); // 统计p-q之间，比a[j]大的元素个数
                tmp[k++] = a[j++];
            }
        }
        while (i <= q) { // 处理剩下的
            tmp[k++] = a[i++];
        }
        while (j <= r) { // 处理剩下的
            tmp[k++] = a[j++];
        }
        for (i = 0; i <= r-p; ++i) { // 从tmp拷贝回a
            a[p+i] = tmp[i];
        }
    }
}
