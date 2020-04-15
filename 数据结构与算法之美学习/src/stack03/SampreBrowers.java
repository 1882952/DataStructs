package stack03;
/*
*使用前后栈来实现浏览器的前进和后退功能
* */
public class SampreBrowers {

    public static void main(String[] args) {
        SampreBrowers browser = new SampreBrowers();
        browser.open("http://www.baidu.com");
        browser.open("http://news.baidu.com/");
        browser.open("http://news.baidu.com/ent");
        browser.goBack();
        browser.goBack();
        browser.goforWard();
        browser.open("http://www.qq.com");
        browser.goforWard();
        browser.goBack();
        browser.goforWard();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.checkCurrentPage();
    }

    private String currentPage;
    private LinkedListBasedStack backStack;
    private LinkedListBasedStack forwardStack;

    public void open(String url){
        if(this.currentPage!=null){ //按照分析写的，在前进后退是点入其他链接，那么就清空前进栈中的链接
            this.backStack.push(this.currentPage);
            this.forwardStack.clear();
        }
        showUrl(url,"open");
    }

    public SampreBrowers() {
        this.backStack = new LinkedListBasedStack();
        this.forwardStack = new LinkedListBasedStack();
    }

    public boolean canGoBack(){return backStack.size>0;}
    public boolean canGoFordWard(){return forwardStack.size>0;}

    /*
    * 回退页面，即把当前页面压入到前进栈中，然后再从回退栈中弹出节点作为当前页面
    * */
    public String goBack(){
        if(this.canGoBack()){
            this.forwardStack.push(this.currentPage);
            String backUrl=this.backStack.pop();
            showUrl(backUrl,"Back");
            return backUrl;
        }
        System.out.println("* Cannot go back, no pages behind.");
        return null;
    }
    /*
    * 前进页面，即把当前页面压入到后退栈中，然后从前进栈中弹出节点作为当前页面
    * */
    public String goforWard(){
        if(this.canGoFordWard()){
            this.backStack.push(this.currentPage);
            String forwardUrl=this.forwardStack.pop();
            showUrl(forwardUrl,"foward");
            return forwardUrl;
        }
        System.out.println("** Cannot go forward, no pages ahead.");
        return null;
    }

    public void showUrl(String url, String prefix) {
        this.currentPage = url; //设置传入的页面为当前页面
        System.out.println(prefix + " page == " + url);
    }

    public void checkCurrentPage() {
        System.out.println("Current page is: " + this.currentPage);
    }

    public static class LinkedListBasedStack{

        private int size;
        private Node top;

        static Node creatData(String data,Node next){
            return new Node(data,next);
        }

        public void clear(){
            this.top=null;
            this.size=0;
        }

        public void push(String data){
            Node newnode=creatData(data,null);
            newnode.next=top;
            top=newnode;
            size++;
        }
        public String pop(){
            Node popNode=this.top;
            if(popNode==null){
                System.out.println("Stack is empty.");
                return null;
            }
            this.top=top.next;
            if(this.size>0){
                size--;
            }
            return popNode.data;
        }

        public String getTopData() {
            if (this.top == null) {
                return null;
            }
            return this.top.data;
        }

        public int size() {
            return this.size;
        }

        public void print() {
            System.out.println("Print stack:");
            Node currentNode = this.top;
            while (currentNode != null) {
                String data = currentNode.getData();
                System.out.print(data + "\t");
                currentNode = currentNode.next;
            }
            System.out.println();
        }

        public static class Node {
            private String data;
            private Node next;

            public Node(String data) {
                this(data, null);
            }

            public Node(String data, Node next) {
                this.data = data;
                this.next = next;
            }

            public void setData(String data) {
                this.data = data;
            }

            public String getData() {
                return this.data;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public Node getNext() {
                return this.next;
            }
        }
    }
}
