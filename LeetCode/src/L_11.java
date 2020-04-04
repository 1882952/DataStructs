/*
* 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
说明：你不能倾斜容器，且 n 的值至少为 2。
思路：我们计算n面积的时候，假如左侧的线段高度比右侧的高度低，那么我们通过左移右指针来
    将长度缩短为n-1的做法是没有意义的， 因为新的形成的面积变成了(n-1) * heightOfLeft 这个面积一定比刚才的长度为n的面积nn * heightOfLeft 小

也就是说最大面积一定是当前的面积或者通过移动短的线段得到。
* */
public class L_11 {
    public int maxArea(int[] height) {
        if(height==null || height.length<=1){
            return 0;
        }
        //双指针来优化，时间复杂度为o（n）
        int leftPos=0;
        int rightPos=height.length-1;
        int max=0;
        int cur=0;
        while (leftPos<rightPos){
            cur=Math.abs(leftPos-rightPos)*Math.min(height[leftPos],height[rightPos]);
            if(cur>max){
                max=cur;
            }
            //更新小的,因为是以短板为标准
            if(height[leftPos]<height[rightPos]){
                leftPos++;
            }else {
                rightPos--;
            }
        }
        return max;
    }
}
