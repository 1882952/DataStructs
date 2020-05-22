package src.回溯思想;
/*
* 正则表达式 的简单模拟 只模拟 * 与 ？ 的匹配
*
* 利用回溯思想判断通配符的语义
* */
public class Pattern {
    private boolean matched=false; //判断是否匹配
    private char[] pattern; //正则表达式
    private int plen; //正则表达式的长度

    public Pattern(char[] pattern, int plen) {
        this.pattern = pattern;
        this.plen = plen;
    }

    public boolean match(char[] text, int tlen){ //文本串及长度
        matched=false;
        rematch(0,0,text,tlen);
        return matched;
    }
    // ti:文本串的当前指针  pj：正则表达式中的当前指针
    private void rematch(int ti,int pj,char[] text,int tlen){
        if(matched){
            return; //如果已经匹配，就不需要再递归.
        }
        if(pj==plen){ //正则表达式到结尾了
            if(ti==tlen){
                matched=true; //文本串已经到结尾了,证明该文本串匹配字符表达式成功
            }
            return;
        }
        if(pattern[pj]=='*'){ //* :匹配任意字符串
            for(int k=0;k<=tlen-ti;k++){ //因为是匹配任意字符串，所以采用递归，当前字符匹配完，继续匹配下一个
                rematch(ti+k,pj+1,text,tlen);
            }
        }else if(pattern[pj]=='?'){// ?匹配0个或者1个字符
            rematch(ti,pj+1,text,tlen);
            rematch(ti+1,pj+1,text,tlen);
        }else if(ti<tlen && pattern[pj]==text[ti]){// 这里是纯字符匹配
            rematch(ti+1,pj+1,text,tlen);
        }
    }
}
