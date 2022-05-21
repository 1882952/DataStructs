package 树与图.字典树;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 好友推荐
 *
 */
public class FriendRecord {


    class Node{
        public int userId;      // 结点的名称，这里使用用户id
        public HashSet<Integer> friends = null;  // 使用哈希映射存放相连的朋友结点。哈希便于确认和某个用户是否相连。
        public int degree;  //用于存放和给定的用户结点，是几度好友

        // 初始化节点
        public  Node(int id){
            userId = id;
            friends = new HashSet<>();
            degree=0;
        }

    }

    public static void main(String[] args) {

    }

    public static void bfs(Node[] userNodes,int userId){
        if(userId>userNodes.length){
            return;
        }
        Queue<Integer> queue = new LinkedList<>();  //使用LinkendList作为队列来使用
        queue.offer(userId);
        HashSet<Integer> visited= new HashSet<>();  // 存放已经被放入的节点，防止回路
        visited.add(userId);
        while (!queue.isEmpty()){
            int current_userId = queue.poll();  // 拿出队列的头一个节点
            if(userNodes[current_userId] == null){
                continue;
            }
            // 遍历刚刚拿出的这个结点的所有直接连接结点，并加入队列尾部
            for (int i = 0; i <userNodes[current_userId].friends.size() ; i++) {
                if(userNodes[i] == null){
                    continue;
                }
                // 剪枝，避免重复调用
                if(visited.contains(i)){
                    continue;
                }
                // 压入下一列
                queue.offer(i);
                //保存已经添加过的
                visited.add(i);
                userNodes[i].degree = userNodes[current_userId].degree+1;
                System.out.println(String.format("\t%d度好友:%d",userNodes[i].degree,i));
            }
        }

    }
}
