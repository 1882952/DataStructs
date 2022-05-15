package LeetCode600_700;

/**
 * 633：平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 * 判断，双指针
 * 思路：因为是平方和，所以可以直接C/2,然后从0开始，左右平方加，有就有，没有就没有、
 *  注意点，数据类型，为long
 */
public class L_633 {
    public static void main(String[] args) {
        int c = 5;
        boolean b = judgeSquareSum1(c);
        System.out.println(b);
    }

//    public static boolean judgeSquareSum(int c) {
//        boolean flag = false;
//        if(c<0){
//            return flag;
//        }
//        int right = (int)Math.sqrt(c);
//        int i=0,j=right;
//        while (i<=j){
//            int sum=i*i+j*j;
//            // 2147483600 long，int型编译会报错
////            if(sum<c){
////                i++;
////            }else if(sum>c){
////                j--;
////            }else {
////                flag=true;
////                break;
////            }
//            if(sum==c){
//                flag=true;
//                break;
//            }else if(sum<c){
//                i++;
//            }else {
//                j++;
//            }
//        }
//        return flag;
//    }

    public static boolean judgeSquareSum1(int c) {
        boolean flag = false;
        if (c < 0) {
            return flag;
        }
        long right = (int) Math.sqrt(c);
        long i = 0, j = right;
        while (i <= j) {
            long sum = i * i + j * j;
            if (sum < c) {
                i++;
            } else if (sum > c) {
                j--;
            } else {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
