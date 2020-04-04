package 树.赫夫曼编码;

import java.io.*;
import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) {
        String content="i like like like java do you like a java";
        byte[] contentBytes=content.getBytes();
        System.out.println("没压缩前的长度"+contentBytes.length);

        /*List<Node> nodes=getNodes(contentBytes);
       // System.out.println(nodes);
        Node huff=creatHuffmanTree(nodes);
       // huff.preOrder();

       //测试赫夫曼编码
       getCodes(huff);
       System.out.println("生成的赫夫曼编码表："+huffmanCodes);

       //测试压缩字符串
        byte[] huffcodeBytes=zip(contentBytes,huffmanCodes);
        System.out.println(Arrays.toString(huffcodeBytes));*/
       /* byte[] zipbytes=huffmanzip(contentBytes);
        System.out.println("压缩后的："+Arrays.toString(zipbytes));*/
        //测试解压字符串
        /*byte[] sourceBYtes=decode(zipbytes,huffmanCodes);
        System.out.println("解压后原来的字符串："+new String(sourceBYtes));*/

        //测试压缩文件
        String srcFile="e://p2.txt";
        String disFile="e://p2zip.dmp";
        zipFile(srcFile,disFile);
       //测试解压文件
        String zipFile="e://p2zip.dmp";
        String dstFile="e://p2unzip.txt";
        unZipFile(zipFile,dstFile);
    }
    //解压文件方法
    public static void unZipFile(String zipFile,String dstFile){
        InputStream is=null;
        ObjectInputStream ois=null;
        OutputStream os=null;
        try {
            //创建文件输入流
            is=new FileInputStream(zipFile);
            //创建一个和is对象关联的输入流
            ois=new ObjectInputStream(is);
            //读取
            byte[] huffmanBytes=(byte[]) ois.readObject();
            Map<Byte,String> codes=(Map<Byte,String>)ois.readObject();
            //解码
            byte[] sourceBytes=decode(huffmanBytes,huffmanCodes);
            //写数据
            os=new FileOutputStream(dstFile);
            os.write(sourceBytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                ois.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    //编写方法，将一个文件进行压缩
    public static void zipFile(String srcFile,String disFile){
        FileInputStream is=null;
        FileOutputStream os=null;
        ObjectOutputStream oos=null;
        try {
            //创建输入流：
            is=new FileInputStream(srcFile);
            //创建一个和源文件大小一样的byte数组
            byte[] b=new byte[is.available()];
            //读取文件
            is.read(b);
            //对源文件压缩
            byte[] huffmanzip=huffmanzip(b);
            //创建输出流
            os=new FileOutputStream(disFile);
            //创建一个和文件输出流相关的ObjectOutputStream
            oos=new ObjectOutputStream(os);
            //以对象流的方式写入赫夫曼编码后的字节数组，利于以后解压恢复
            oos.writeObject(huffmanzip);
            //也需要把赫夫曼编码表写入
            oos.writeObject(huffmanCodes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    //完成对压缩数据的解码
    private static byte[] decode(byte[] huffmanBytes,Map<Byte,String> huffmanCodes){
        //先得到huffmanbytes对应的二进制字符串
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i <huffmanBytes.length ; i++) {
            //判断是不是最后一个字节
            boolean flag=(i==huffmanBytes.length-1);
            stringBuilder.append(byteToBitString(!flag,huffmanBytes[i]));
        }
        //把二进制字符串按照指定的赫夫曼编码来解码
        //把赫夫曼编码表进行反转，然后反向查询 a->100 反向后 100-》a
        Map<String,Byte> map=new HashMap<>();
        for (Map.Entry<Byte,String> entry: huffmanCodes.entrySet()) {
            map.put(entry.getValue(),entry.getKey());
        }
        //创建要加入的结合，存放byte
        List<Byte> list=new ArrayList<>();
        for (int i = 0; i <stringBuilder.length();) {
            int count=1; //小的计数器
            boolean flag=true;
            Byte b=null;
            while (flag){
                String key=stringBuilder.toString().substring(i,i+count);
                b=map.get(key);
                if(b==null){ //说明没有匹配到
                    count++;
                }else {
                    flag=false;
                }
            }
            list.add(b);
            i+=count; //让i直接移动到count位置
        }
        //把list中的数据放入byte并返回
        byte[] b=new byte[list.size()];
        for (int i = 0; i <b.length ; i++) {
            b[i]=list.get(i);
        }
        return b;
    }
    //将一个byte转成一个二进制字符串（解压过程）
    //flag标志是否需要补高位，如果使false表示不补，如果是最后一个字节，不需要补高位
    private static String byteToBitString(boolean flag,byte b) {
        int temp = b; //将b转成int
        //如果是正数，还存在着补高位
        if (flag) {
            temp |= 256;
        }
        String s = Integer.toBinaryString(temp); //返回的是temp对应的二进制补码
        if (flag) {
            return s.substring(s.length()-8);
        }
            return s;
    }
    //封装方法，便于调用
    private static byte[] huffmanzip(byte[] contentBytes){
        //将字节数组转为node集合
        List<Node> nodes=getNodes(contentBytes);
        //创建赫夫曼树
        Node huff=creatHuffmanTree(nodes);
        //赫夫曼编码,huffmanCodes设置为了静态变量，所以没返回
        getCodes(huff);
        System.out.println("生成的赫夫曼编码表："+huffmanCodes);
        //测试压缩
        byte[] huffcodeBytes=zip(contentBytes,huffmanCodes);
        return huffcodeBytes;
    }
    //将字符串对应的byte数组，通过生成的赫夫曼编码表，返回赫夫曼编码压缩后的byte数组
    private static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes){
        //1;利用huffmanCodes将bytes转成赫夫曼编码对应的字符串
        StringBuilder stringBuilder=new StringBuilder();
        //遍历byte数组
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        //因为是编码后的字符串，占空间，将对应的字符串转为byte数组
        int len;
        if(stringBuilder.length()%8==0){
            len=stringBuilder.length()/8;
        }else {
            len=stringBuilder.length()/8+1;
        }
        //创建存储压缩后的byte数组
        byte[] by=new byte[len];
        int index=0;
        for(int i=0;i<stringBuilder.length();i+=8){ //因为每8位对应一个byte
            String strByte;
            if(i+8>stringBuilder.length()){ //不够8位
                strByte=stringBuilder.toString().substring(i);
            }else {
                strByte=stringBuilder.toString().substring(i,i+8);
            }
            //将strByte转为一个byte，放入byte数组
            by[index]=(byte)Integer.parseInt(strByte,2);
            index++;
        }
        return by;
    }
    //将字节数组变为到node集合中
    private static List<Node> getNodes(byte[] bytes){
        List<Node> nodes=new ArrayList<>();
        //遍历byte数组，统计存储的每个byte出现的次数。利用map来处理
        Map<Byte,Integer> counts=new HashMap<>();
        for (byte b: bytes) {
            Integer count=counts.get(b);
            if(count==null){ //map中还没有这个字符数据
                counts.put(b,1);
            }else {
                counts.put(b,count+1);
            }
        }
        //把每个键值对转成一个node对象，并加入到list中
        //遍历map
        for (Map.Entry<Byte,Integer> entry: counts.entrySet()) {
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }
    //创建赫夫曼树：
    private static Node creatHuffmanTree(List<Node> nodes){
        while (nodes.size()>1){
            //排序，从小到大排序
            Collections.sort(nodes);
            Node leftNode=nodes.get(0);
            Node rghtNode=nodes.get(1);
            Node parent=new Node(null,leftNode.weight+rghtNode.weight);
            parent.left=leftNode;
            parent.right=rghtNode;
            nodes.remove(leftNode);
            nodes.remove(rghtNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
    //重载生成赫夫曼编码的方法
    private static Map<Byte,String> getCodes(Node root){
        if(root==null){
            return null;
        }
        getCodes(root.left,"0",stringBuilder);
        getCodes(root.right,"1",stringBuilder);
        return huffmanCodes;
    }
    //生成赫夫曼树对应的赫夫曼编码
    /*
    * 思路：1：将赫夫曼编码表存放在Map<Byte,String>中，比如：32-》01,97->100,u->11011, 即利用赫夫曼树的路径进行编码规则
    * 2：在生成赫夫曼编码时，需要去拼接路径，定义一个StringBuilder存储某个叶子节点的路径
    * */
    static  Map<Byte,String> huffmanCodes=new HashMap<>();
    static  StringBuilder stringBuilder=new StringBuilder();
    //node;传入节点； code：路径，左子节点是0，右子节点是1；stringBuilder：用于拼接路径
    private static void getCodes(Node node,String code,StringBuilder stringBuilder){
      StringBuilder stringBuilder2=new StringBuilder(stringBuilder);
      //将code加入到stringBuilder2中
        stringBuilder2.append(code);
        if(node!=null){
            //判断当前的node是叶子节点还是非叶子节点
            if(node.data==null){  //非叶子节点
                //递归处理
                //向左递归
                getCodes(node.left,"0",stringBuilder2);
                //向右递归
                getCodes(node.right,"1",stringBuilder2);
            }else {  //说明是一个叶子节点
                //表示找到某个叶子节点的最后
                huffmanCodes.put(node.data,stringBuilder2.toString());
            }
        }
    }
}
//创建node，存数据和权值
class Node implements Comparable<Node>{
    Byte data; //存放数据（字符）本身， 比如：‘a’=》97   ' '=》32
    int  weight; //权值，表示字符出现的次数
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        //从小到大排序
        return this.weight-o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ";weight="+weight+
                '}';
    }
    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }
}
