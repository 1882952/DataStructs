package 二0年4月;
//这个是标准答案，自己照着写的会报空指针异常，不建议采用，
public class InterView1010_1 {
    class Node{
        int val;
        int count;
        Node left;
        Node right;
        public Node(int val){
            this.val=val;
            this.count=1;
            this.left=null;
            this.right=null;
        }
    }
    public Node head=null;
    public InterView1010_1() {

    }

    public void track(int x) {
        if(head==null){
            Node node = new Node(x);
            head=node;
        }else{
            Node node = head;
            while(node!=null){
                if(node.val==x){
                    node.count++;break;
                }
                else if(node.val>x){
                    node.count++;
                    if(node.left!=null) {
                        node=node.left;
                    }else {
                        node.left=new Node(x);
                        break;
                    }
                }else{
                    if(node.right!=null) {
                        node=node.right;
                    }else {
                        node.right=new Node(x);
                        break;
                    }
                }
            }

        }
    }

    public int getRankOfNumber(int x) {
        if(head==null)return 0;
        Node node=head;
        int nums = 0;
        while(node!=null){
            if(x>node.val){
                nums+=node.count;
                node=node.right;
            }else if(x==node.val){
                nums+=node.count;break;
            }else {
                node=node.left;
            }
        }
        return nums;
    }
}
