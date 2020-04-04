package 树.二叉树10_26;

//定义节点
public class HeroNode{
    private int id;
    private String name;
    private HeroNode left;
    private HeroNode right;

    //说明：leftType和rightType用于线索二叉树
    //1:如果leftType==0表示指向左子树，则等于1表示指向前驱节点
    //2:如果rightType==0表示指向右子树，则等于1表示指向后继节点
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    //递归删除节点：要求：如果是叶子节点，则删除该节点；如果是非叶子节点，则删除该子树
    //考虑左右子树
    //注意，这里写的很有问题，如果要删除的左或右子树如果还有子节点，那么这些子节点就丢了。
    public void deleteNode(int id){
        if(this.left!=null&&this.left.id==id){   //这里已经把左子树的值判断了，如果递归到下一层，不用考虑该值
            this.left=null;
            return;
        }
        if(this.right!=null&&this.right.id==id){
            this.right=null;
            return;
        }
        //向左子树递归
        if (this.left!=null){
            this.left.deleteNode(id);
        }
        //向右子树递归
        if(this.right!=null){
            this.right.deleteNode(id);
        }
    }
    //编写前序遍历
    public void preOrder(){
        System.out.println(this.toString());
        //递归向左子树前序遍历
        if(this.left!=null){
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if(this.right!=null){
            this.right.preOrder();
        }
    }
    //编写中序遍历
    public void infiOrder(){
        if(this.left!=null){
            this.left.infiOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.infiOrder();
        }
    }
    //编写后序遍历
    public void postOrder(){
        if(this.left!=null){
            this.left.infiOrder();
        }
        if(this.right!=null){
            this.right.infiOrder();
        }
        System.out.println(this);
    }


    //编写前序查找
    public HeroNode perOrderFind(int id) {
        if(this.id==id){
            return this;
        }
        HeroNode temp=null; //使用递归的每一次方法调用的返回值都需要用temp中间变量保存
        if(this.left!=null){
            temp=this.left.perOrderFind(id);
        }
        if(temp!=null){   //说明左子树找到
            return temp;
        }
        if(this.right!=null){
            temp=this.right.perOrderFind(id);
        }
        return temp;
    }
    //编写中序查找
    public HeroNode infixFind(int id){
        HeroNode temp=null; //使用递归的每一次方法调用的返回值都需要用temp中间变量保存
        if(this.left!=null){
            temp=this.left.perOrderFind(id);
        }
        if(temp!=null){ //说明左子树找到
            return temp;
        }

        if(this.id==id){
            return this;
        }

        if(this.right!=null){
            temp=this.right.perOrderFind(id);
        }
        if(temp!=null){   //说明右子树找到
            return temp;
        }
        return null;
    }
    //编写后序查找
    public HeroNode postFind(int id) {
        HeroNode temp=null; //使用递归的每一次方法调用的返回值都需要用temp中间变量保存
        if(this.left!=null){
            temp=this.left.perOrderFind(id);
        }
        if(temp!=null){  //说明左子树找到
            return temp;
        }
        if(this.right!=null){
            temp=this.right.perOrderFind(id);
        }
        if(temp!=null){  //说明右子树找到
            return temp;
        }
        if(this.id==id){
            return this;
        }
        return null;
    }
}