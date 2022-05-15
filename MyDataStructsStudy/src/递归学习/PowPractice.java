package 递归学习;

/**
 * 利用数学归纳法，证明 国际象棋格放麦粒的归纳；
 *
 *  证明条件： n== 1时， 成立；
 *          假设 n== k-1时，成立，当 n==k时，也会成立
 *
 *  通过格子k与当总前麦粒数对比 , 重点是假设n=k-1成立， 直接按数学归纳法得到的规则去证明K就行，不需要再关注递归了多少次，循环了多少次。
 */
public class PowPractice {
    public static void main(String[] args) {

    }

    /** * @Description: 使用函数的递归（嵌套）调用，进行数学归纳法证明 * @param k-放到第几格，result-保存当前格子的麦粒数和麦粒总数 * @return boolean-放到第k格时是否成立 */
    public static boolean prove(int k, Result result){
        //证明n==1的时候成立
        if(k==1){
            if((Math.pow(2,1)-1)==1){
                result.wheatNum=1;
                result.wheatTotalNum=1;
                return true;
            }else {
                return false;
            }
        }
        //如果n==k-1，证明n==k成立
        else {
            boolean proveOfPreviousOne = prove(k - 1, result);
            //当前格子是前一个格子的2倍麦粒数
            result.wheatNum*=2;
            //总的麦粒数   n=k
            result.wheatTotalNum+=result.wheatNum;
            boolean proveOfCurrentOne = false;  //默认当前k条件不成立，下述证明
            if((Math.pow(2,k)-1) == result.wheatTotalNum ){
                proveOfCurrentOne = true;
            }

            if(proveOfCurrentOne && proveOfPreviousOne){
                return true;
            }else {
                return false;
            }
        }
    }
}

class  Result{

    public long wheatNum = 0; // 当前格的麦粒数
    public long wheatTotalNum = 0; // 目前为止麦粒的总数

}