package src.trieTree13;
/*
* 字典树的构造：假设只有a--z 的26个字符
* 核心思想是利用字符串的公共前缀，将重复的前缀合并在一起，构成一棵树。
* */
public class TrieTree {

    private TrieNode root=new TrieNode('/'); //存储无意义的字符

    //往trie树种插入一个字符串
    public void insert(char[] text){
        TrieNode p=root;
        for (int i = 0; i <text.length ; i++) {
            int index=text[i]-'a'; //获取节点数组中对应下标
            if(p.children[index]==null){ //如果p的children节点数组中index下标对应的字符对应的value为null，就添加新的字符节点
                TrieNode newNode=new TrieNode(text[i]);
                p.children[index]=newNode;
            }
            p=p.children[index]; //然后继续，进行下一位字符的插入
        }
        p.isEndingChar=true; //代表这个字符串已经添加到该字典树中，设置叶子节点的p的判断值为true。
    }
    //在trie树种查找字符串
    public boolean select(char[] text){
        TrieNode p=root;
        for (int i = 0; i <text.length ; i++) {
            int index=text[i]-'a';
            if(p.children[index]==null){ //说明该字符串不存在
                return false;
            }
            p=p.children[index];
        }
        if(p.isEndingChar==false){ //说明该字符串只是公共前缀，不能完全匹配
            return false;
        }else {
            return true; //匹配到该字符串
        }
    }
 public class TrieNode{
     public char data;
     public TrieNode[] children=new TrieNode[26]; //假设只有a-z26个字母。
     public boolean isEndingChar=false;

     public TrieNode(char data) {
         this.data = data;
     }
 }
}
