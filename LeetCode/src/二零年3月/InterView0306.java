package 二零年3月;

import java.util.*;

/*
* 动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。在收养该收容所的动物
* 时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，或者可以挑选猫
* 或狗（同时必须收养此类动物中“最老”的）。换言之，收养人不能自由挑选想收养的对象。
* 请创建适用于这个系统的数据结构，实现各种操作方法，比如enqueue、dequeueAny、dequeueDog
* 和dequeueCat。允许使用Java内置的LinkedList数据结构。
enqueue方法有一个animal参数，animal[0]代表动物编号，     animal[1]代表动物种类，其中 0 代表猫，
1 代表狗。
dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。

示例1:
 输入：
["AnimalShelf", "enqueue", "enqueue", "dequeueCat", "dequeueDog", "dequeueAny"]
[[], [[0, 0]], [[1, 0]], [], [], []]
 输出：
[null,null,null,[0,0],[-1,-1],[1,0]]
示例2:
 输入：
["AnimalShelf", "enqueue", "enqueue", "enqueue", "dequeueDog", "dequeueCat", "dequeueAny"]
[[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
 输出：
[null,null,null,null,[2,1],[0,0],[1,0]]

思路：利用两个队列解决问题
* */
public class InterView0306 {

    Queue<int []> dogQueue;
    Queue<int []> catQueue;

    public InterView0306() {
        dogQueue=new LinkedList<>();
        catQueue=new LinkedList<>();
    }

    public void enqueue(int[] animal) {
       if(animal[1]==0){  //添加为猫
           catQueue.offer(animal);
       }else {
           dogQueue.offer(animal);
       }
    }

    public int[] dequeueAny() {
        if(dogQueue.isEmpty()&&catQueue.isEmpty()){
            return new int[]{-1,-1};
        }
        if(dogQueue.isEmpty()||catQueue.isEmpty()){
            return dogQueue.isEmpty() ? catQueue.poll():dogQueue.poll();
        }
        int[] temp1=dogQueue.peek();
        int[] temp2=catQueue.peek();
        if(temp1[0]<temp2[0]){
            return dogQueue.poll();
        }else {
            return catQueue.poll();
        }
    }

    public int[] dequeueDog() {
        if(dogQueue.isEmpty()){
            return new int[]{-1,-1};
        }
        return dogQueue.poll();
    }

    public int[] dequeueCat() {
        if(catQueue.isEmpty()){
            return new int[]{-1,-1};
        }
        return catQueue.poll();
    }
}
