package 哈希表10_20;

import java.util.Scanner;

public class HashTableDemo {
    public static void main(String[] args) {
       HashTable hashTable=new HashTable(7);
       String key="";
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println("添加雇员：add");
            System.out.println("显示雇员：list");
            System.out.println("查找雇员：find");
            System.out.println("退出系统；exit");
            key=scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id：");
                    int id=scanner.nextInt();
                    System.out.println("输入name：");
                    String name=scanner.next();
                    Emp emp=new Emp(id,name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("请输入要寻找的id");
                    int sysid=scanner.nextInt();
                    hashTable.findEmpById(sysid);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                 default:break;
            }
        }

    }
}
//创建哈希表
class HashTable{
    private EmpLinkedList[] linkedLists;
    private int size;  //表示有多少条链表
    public HashTable(int size){
        this.size=size;
        linkedLists=new EmpLinkedList[size];
        //需要初始化数组中的链表节点，不然数组元素为空造成空指针
        for (int i = 0; i <size ; i++) {
            linkedLists[i]=new EmpLinkedList();
        }
    }
    public void add(Emp emp){
        //得到对应的散列值
        int empListNo=hashfun(emp.id);
        linkedLists[empListNo].add(emp);
    }
    //编写散列函数，使用简单的取模法,主要目的是将id散列为数组上对应的位数
    public int hashfun(int id){
        return id % size;
    }
    //遍历
    public void list(){
        for (int i = 0; i <linkedLists.length ; i++) {
            linkedLists[i].list(i);
        }
    }
    //根据输入id查找雇员
    public void findEmpById(int id){
        int empListNo=hashfun(id);
        Emp emp=linkedLists[empListNo].findEmp(id);
        if(emp==null){
            System.out.println("该雇员不存在");
        }
        System.out.println("该雇员"+emp.name+"已找到");
    }
}
class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
//创建链表
class EmpLinkedList{
    //头指针
    private Emp head;
    //添加员工
    public void add(Emp emp){
        if(head==null){
            head=emp;
            return;
        }
        Emp curEmp=head;
        while (true){
            if(curEmp.next==null){
                break;
            }
            curEmp=curEmp.next;
        }
        curEmp.next=emp;
    }
    //遍历
    public void list(int no){
        if(head==null){
            System.out.println("当前第"+no+"链表为空");
            return;
        }
        System.out.println("当前第"+no+"链表的信息为：");
        Emp curEmp=head;
        while (true){
            System.out.print(curEmp.id+":"+curEmp.name+"\t");
            if(curEmp.next==null){
                break;
            }
            curEmp=curEmp.next;
        }
    }
    //根据id查找雇员
    public Emp findEmp(int id){
        if(head==null){
            System.out.println("当前链表为空");
            return null;
        }
        Emp curEmp=head;
        while (true){
            if(curEmp.id==id){
                break;
            }
            if(curEmp.next==null){
                curEmp=null;
                break;
            }
            curEmp=curEmp.next;
        }
        return curEmp;
    }
}