import java.util.ArrayList;
import java.util.List;

/*
* 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L  | C  | I  | R
E T| O E| S I| I G     规则：向下，向右
E  | D  | H  | N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
请你实现这个将字符串进行指定行数变换的函数：
string convert(string s, int numRows);

题目理解：
字符串 s 是以 Z 字形为顺序存储的字符串，目标是按行打印。
    设 numRows 行字符串分别为 s1,s2,...,sN,
 则容易发现：按顺序遍历字符串 s 时，每个字符 c 在 同Z 字形中对应的 行索引 先从 s_1增大至 s_n
 ，再从 s_n 减小至 s_1
  …… 如此反复。
因此，解决方案为：模拟这个行索引的变化，在遍历 s 中把每个字符填到正确的行 res[i] 。

算法流程：按顺序遍历字符串s
    1》res[i]+=c; :把每个字符c填到对应行
    2》i+=flag;更新当前字符c对应的索引
    3》flag=-flag；  在达到Z字形转折点时，执行反向
* */
public class L_06 {
    public String convert(String s, int numRows) {
        if(numRows<2){return s;}
        List<StringBuilder> rows=new ArrayList<>();
        for (int i = 0; i <numRows ; i++) {  //创建每行的字符串
            rows.add(new StringBuilder());
        }
        int i=0,flag=-1;
        for (char c : s.toCharArray()) {  //考虑的是每次第几个的row拼接char
            rows.get(i).append(c);
            if(i==0 || i==numRows-1){   //当达到行数首位或者行数末尾时，执行反向操作
                flag=-flag;
            }
            i+=flag;
        }
        StringBuilder res=new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}
