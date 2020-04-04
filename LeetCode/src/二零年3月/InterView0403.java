package 二零年3月;

import java.util.LinkedList;
/*
* 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表
* （比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
示例：
输入：[1,2,3,4,5,null,7,8]
        1
       /  \
      2    3
     / \    \
    4   5    7
   /
  8

输出：[[1],[2,3],[4,5,7],[8]]

思路：首先想到的就是递归,但是递归想起来容易想到，实现就拉胯，
还是参照题解的BFS的层序遍历
* */
public class InterView0403 {
    public ListNode[] listOfDepth(TreeNode tree) {
        if(tree==null){
            return new ListNode[0];
        }
        //BFS,广度优先，所以需要队列
        LinkedList<TreeNode> queue=new LinkedList<>();
        //存储listnode的集合
        LinkedList<ListNode> res=new LinkedList<>();

        queue.addLast(tree);
        int size=1;   //队列中元素的大小

        //利用队列添加每一层元素，然后依次弹出，添加进res集合中
        while (true){
            TreeNode cur=queue.removeFirst();
            if(cur.left!=null){
                queue.addLast(cur.left);
            }
            if(cur.right!=null){
                queue.addLast(cur.right);
            }
            ListNode curL=new ListNode(cur.val);
            res.addLast(curL);
            //因为上面的removeFirst方法，所以要将size自减后再判断,准确的来说，size的作用是判断每层数据的大小
            while (--size>0){  //因为要每层都要生成链表，所以还得链起来，
                //自然要获得当层curL的后一个节点，即继续从队列中弹出一位
                cur=queue.removeFirst();
                //添加至队列，这么写的好处是可代替两指针。
                curL.next=(curL=new ListNode(cur.val));

                //将队列弹出的这个节点的左右节点继续加入至队列
                if(cur.left!=null){queue.addLast(cur.left);}
                if(cur.right!=null){queue.addLast(cur.right);}
            }

            //每次循环都要判断size，并重新赋值，每次循环不准确，应该是每层循环，每层循环重新给size赋值
            if((size=queue.size())==0){//如果队列为空，则构建完毕
                break;
            }
        }
        return res.stream().toArray(ListNode[]::new);
    }


}
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
