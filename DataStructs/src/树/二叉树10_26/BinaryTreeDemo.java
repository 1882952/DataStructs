package 树.二叉树10_26;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
        HeroNode root=new HeroNode(1,"a");
        HeroNode node2=new HeroNode(2,"bb");
        HeroNode node3=new HeroNode(3,"ccc");
        HeroNode node4=new HeroNode(4,"dddd");
        HeroNode node5=new HeroNode(5,"eeeeee");
        //先手动创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        tree.setRoot(root);
        /*tree.preOrder();
        System.out.println("--------------");
        tree.infiOrder();
        System.out.println("----------------");
        tree.postOrder();*/

       /* HeroNode temp=null;
        temp=tree.postFind(5);
        System.out.println(temp+";");
        temp=tree.infiOrderFind(5);
        System.out.println(temp+";");
        temp=tree.preOrderFind(5);
        System.out.println(temp+";");*/
        System.out.println("删除前：");
        tree.preOrder();
        tree.delNode(5);
        System.out.println("删除后：");
        tree.preOrder();
    }
}
//定义一个二叉树
class BinaryTree{
    private HeroNode root;
    public void setRoot(HeroNode root) {
        this.root = root;
    }
    //删除节点，错误的，如果删除中间还有子节点的节点，肯定会错误
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
