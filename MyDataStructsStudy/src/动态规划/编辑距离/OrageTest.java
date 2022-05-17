package 动态规划.编辑距离;

/**
 * 编辑距离-- 动态规划的实现
 *
 *重要的是得到状态转移方程，  理清了状态转移方程，动态规划代码就写得出来
 */
public class OrageTest {

    /**
     * @Description:使用状态转移方程，计算两个字符串之间的编辑距离
     * @param a  第一个字符串，b-第二个字符串
     * @param b
     * @return  两者间的编辑距离
     */
    public static int getStrDistance(String a, String b) {
        if(a== null || b== null){
            return -1;
        }
        
        // 在定义二维数组时，需要比原数组长一位 , 因为循环从第0位开始，没有i-1
        int[][] dp = new int[a.length()+1][b.length()+1];
        
        // 先来实现特殊情况 , 第0列 的编辑距离为 i
        for (int i = 0; i <a.length() ; i++) {
            dp[i][0]=i;
        }

        for (int j = 0; j <b.length() ; j++) {
            dp[0][j]=j;
        }

        // 请注意由于Java语言实现的关系，代码里的状态转移是从d[i, j]到d[i+1, j+1]，而不是从d[i-1, j-1]到d[i, j]。本质上是一样的。
        for (int i = 0; i <a.length() ; i++) {
            for (int j = 0; j <b.length() ; j++) {
                // 替换函数实现，相同为0，不同为1
                int r=0;
                if(a.charAt(i)!=b.charAt(j)){
                    r=1;
                }
                // A串 插入
                int first_appened = dp[i][j+1];
                int second_appened = dp[i+1][j];
                int replace= dp[i][j]+r;
                int min = Math.min(first_appened,second_appened);
                min = Math.min(replace,min);
                dp[i+1][j+1] = min;
            }
        }
        return dp[a.length()][b.length()];
    }

    public static void main(String[] args) {
        System.out.println(getStrDistance("mouse", "mouuse"));
    }
}
