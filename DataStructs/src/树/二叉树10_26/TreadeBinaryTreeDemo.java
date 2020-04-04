package 树.二叉树10_26;
//线索化二叉树demo
public class TreadeBinaryTreeDemo {
    public static void main(String[] args) {
        TreadeBinaryTree tree=new TreadeBinaryTree();
        HeroNode root=new HeroNode(1,"a");
        HeroNode node2=new HeroNode(3,"bb");
        HeroNode node3=new HeroNode(6,"ccc");
        HeroNode node4=new HeroNode(8,"dddd");
        HeroNode node5=new HeroNode(10,"eeeeee");
        HeroNode node6=new HeroNode(14,"fffffff");
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        tree.setRoot(root);
        tree.threadNodes(root);
        //测试线索化
        HeroNode temp=node5.getLeft(); //得到的前驱节点应该为node3
        System.out.println(temp);

        //遍历线索化
        tree.threadList();
    }
}
class TreadeBinaryTree{
    private HeroNode root;
    //为了实现线索化，需要创建指向当前节点的前驱节点的引用
    //在递归线索化时，pre总是保留前一个节点
    private HeroNode pre=null;
    public void setRoot(HeroNode root) {
        this.root = root;
    }
    //遍历中序线索化二叉树的方法
    public void threadList(){
        HeroNode node=root;
        while (node!=null){
            //循环地找到leftTYpe==1的节点,由于是中序，向左找
            while (node.getLeftType()==0){
                node=node.getLeft();
            }
            System.out.println(node);
            //如果当前节点的右指针指向的是后继节点，就一直输出
            while (node.getRightType()==1){
                node=node.getRight();
                System.out.println(node);
            }
            //替换这个遍历的节点
            node=node.getRight();
        }
    }
    //编写对二叉树中序线索化的方法
    //node：当前需要线索化的节点
    public void threadNodes(HeroNode node){
        if(node==null){
            return;
        }
        //1：先线索化左子树，
        threadNodes(node.getLeft());
        //2：线索化当前节点；

        //处理当前节点的前驱节点
        if(node.getLeft()==null){
            //让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            //修改当前节点的左指针类型
            node.setLeftType(1);
        }
        //处理后继节点（在递归条件时在下次处理）
        if(pre!=null&&pre.getRight()==null){
            //让前驱节点的右指针指向当前节点
            pre.setRight(node);
            pre.setRightType(1);
        }
        //！！！！每处理一个节点后，让当前节点是下一个节点的前驱节点
        pre=node;

        //3：线索化右子树
        threadNodes(node.getRight());

    }
    //删除节点
    public void delNode(int id){
        if(root!=null){
            if(root.getId()==id){
                root=null;
                return;
            }else{
                root.deleteNode(id);
            }
        }else{
            System.out.println("空树，不能删除");
        }
    }
    //前序遍历
    public void preOrder(){
        if(this.root!=null){
            root.preOrder();
        }
    }
    //中序遍历
    public void infiOrder(){
        if(this.root!=null){
            root.infiOrder();
        }
    }
    //后序遍历
    public void postOrder(){
        if(this.root!=null){
            root.postOrder();
        }
    }
    //前序查找
    public HeroNode preOrderFind(int id){
        if(this.root!=null){
            return root.perOrderFind(id);
        }
        return null;
    }
    //中序查找
    public HeroNode infiOrderFind(int id){
        if(this.root!=null){
            return root.infixFind(id);
        }
        return null;
    }
    //后序查找
    public HeroNode postFind(int id){
        if(this.root!=null){
            return root.postFind(id);
        }
        return null;
    }
}