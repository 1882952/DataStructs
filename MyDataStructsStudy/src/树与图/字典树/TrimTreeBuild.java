package 树与图.字典树;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

/**
 * 字典树的构建
 *
 * 给一个字典， 其实就是字符串数组。
 */
public class TrimTreeBuild {

    /**
     * 使用 DFS 遍历出字典树
     * @param root
     */
    public static void dfs(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.sons.size()==0){  // 证明是叶子节点，输出
                System.out.println(node.prefix+node.label);
            }else {
                Iterator<Map.Entry<Character, TreeNode>> iterator = node.sons.entrySet().iterator();  // 或者非叶子节点，遍历它的每一个节点
                // 这里不要求一致， 如果要求一致的话，还需要做一次处理，可以利用一个栈，然后再倒一下
                /*while (iterator.hasNext()){
                    stack.push(iterator.next().getValue());
                }*/
                // 另一种写法 要求一致
                Stack<TreeNode> temp = new Stack<>();
                while (iterator.hasNext()){
                    temp.push(iterator.next().getValue());
                }
                while (!temp.isEmpty()){
                    stack.push(temp.pop());
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode= new TreeNode('0',"","");
        treeNode.build("Hello","你好");
        treeNode.build("Word","世界");
        dfs(treeNode);
    }

}

/**
 * 前缀树的节点定义  需要有结点与边的体现
 */
class TreeNode {

    public char label;  //节点名称，在前缀树中的单个字母
    public HashMap<Character,TreeNode> sons= null;  // 存放子节点，确认是否已经添加过某个字符对应的节点
    public String prefix; // 从树的根节点到现在，全部字母组成的前缀, 例如 b-o-y, 对于o，前缀是 b， 对于 y，前缀是bo
    public String explanation = null; // 词条的解释 , 在每一个单词的最后一个末尾添加

    public TreeNode(char l,String pre,String exp){
        label=l;
        prefix=pre;
        explanation=exp;
        sons =new HashMap<>();
    }

    /**
     *
     * @param str  当前节点时的剩余字符串
     * @param pre  当前节点的前缀字符串
     * @param exp   词条的解释，每当一个词典加完之后，存取一个词条
     * @param root 传入的根节点, 字典树的根
     * @return
     */
    public TreeNode build(String str,String pre,String exp,TreeNode root){
        if("".equals(str)){
            explanation=exp;
            return root;
        }
        // 处理当前字母的第一个字符
        char c = str.charAt(0);
        TreeNode found = null;
        // 如果当前节点的叶子节点中包含着当前字母的第一个字符，那么就找出这个叶子节点，否则，重新创建一个 , 注意，这里的逻辑只是构建，想想分析的条件，如果叶子节点没有，就构建出来;
        if(root.sons.containsKey(c)){
            found = this.sons.get(c);
        }else {
            TreeNode node = new TreeNode(c,pre,"");
            this.sons.put(c,node);
            found = node;
        }
        // 构建下一层叶子节点
        return found.build(str.substring(1,str.length()),pre+str.substring(0,1),exp,root);
    }

    public TreeNode build(String str,String exp){
        return this.build(str,"",exp,this);
    }

}
