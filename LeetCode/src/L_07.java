/*给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。*/
//思路：利用堆栈
public class L_07 {
    public int reverse(int x) {
        if(x==0){ //x=0
            return x;
        }
        int rev=0;
        while (x!=0){
            int pop=x%10;
            x/=10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev=rev*10+pop;
        }
        return rev;
    }
}
