package src.trieTree13;

import java.util.LinkedList;
import java.util.Queue;

/*
* AC自动机：基于字典树trie的多模式串匹配算法
* */
public class AC {
    private ACNode root=new ACNode('/'); //存储无意义的字符
    //构建trie树
    public void insert(char[] text){
        ACNode p=root;
        for (int i = 0; i <text.length ; i++) {
            int index=text[i]-'a';
            if(p.children[index]==null){
                ACNode newNode=new ACNode(text[i]);
                p.children[index]=newNode;
            }
            p=p.children[index];
        }
        p.isEndingchar=true; //表示字符串末尾已添加至trie中
    }
    //构建失败指针
    public void buildFailurePointer() {
        //按层遍历trie的过程，所以采用queue。
        Queue<ACNode> queue=new LinkedList<>();
        root.fail=null;
        queue.add(root);
        while (!queue.isEmpty()){
            ACNode p=queue.remove();
            for (int i = 0; i <26 ; i++) {
                ACNode pc=p.children[i];
                if(pc==null){continue;}
                if(p==root){
                    pc.fail=root;
                }else {
                    ACNode q=p.fail;
                    while (q!=null){
                        ACNode qc = q.children[pc.data - 'a'];
                        if(qc!=null){
                            pc.fail=qc;
                            break;
                        }
                        q=q.fail;
                    }
                    if(q==null){
                        pc.fail=root;
                    }
                }
                queue.add(pc);
            }
        }
    }

    //匹配过程
    public void match(char[] text) { // text是主串
        int n = text.length;
        ACNode p = root;
        for (int i = 0; i < n; ++i) {
            int idx = text[i] - 'a';
            while (p.children[idx] == null && p != root) {
                p = p.fail; // 失败指针发挥作用的地方
            }
            p = p.children[idx];
            if (p == null) p = root; // 如果没有匹配的，从root开始重新匹配
            ACNode tmp = p;
            while (tmp != root) { // 打印出可以匹配的模式串
                if (tmp.isEndingchar == true) {
                    int pos = i-tmp.length+1;
                    System.out.println("匹配起始下标" + pos + "; 长度" + tmp.length);
                }
                tmp = tmp.fail;
            }
        }
    }

    public class ACNode{
        public char data;
        public ACNode[] children=new ACNode[26]; // 字符集只包含a~z这26个字符
        public boolean isEndingchar=false; //判断添加至叶子节点时，即结尾节点为true
        public int length = -1; // 当isEndingChar=true时，记录模式串长度
        public ACNode fail; //失败指针，类似于kmp中的next数组值，但是这里是用tree组建

        public ACNode(char data) {
            this.data = data;
        }
    }
}
