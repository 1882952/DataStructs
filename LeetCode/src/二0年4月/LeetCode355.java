package 二0年4月;

import java.util.*;

/*
* 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，
* 能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：

postTweet(userId, tweetId): 创建一条新的推文
getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。
推文必须按照时间顺序由最近的开始排序。
follow(followerId, followeeId): 关注一个用户
unfollow(followerId, followeeId): 取消关注一个用户
示例:

Twitter twitter = new Twitter();

// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
twitter.postTweet(1, 5);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
twitter.getNewsFeed(1);

// 用户1关注了用户2.
twitter.follow(1, 2);

// 用户2发送了一个新推文 (推文id = 6).
twitter.postTweet(2, 6);

// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
// 推文id6应当在推文id5之前，因为它是在5之后发送的.
twitter.getNewsFeed(1);
// 用户1取消关注了用户2.
twitter.unfollow(1, 2);
// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
// 因为用户1已经不再关注用户2.
twitter.getNewsFeed(1);
* */
public class LeetCode355 {
    /**
     * 用户id和推文（单链表的关系）
     */
    private Map<Integer,Tweet> twitter;
    /**
     * 用户id和他关注的用户列表之间的对应关系
     */
    private Map<Integer, Set<Integer>> followings;

    /**
     * 全局使用的时间戳字段，用户每发布一条推文之前 + 1
     */
    private static int timestamp = 0;

    /**
     * 使用优先队列来完成k组推文的合并（优先队列默认小顶堆实现，但是可以更改比较方法，然后实现大顶堆）
     */
    private static PriorityQueue<Tweet> maxHeap;
    /** Initialize your data structure here. */
    public LeetCode355() {
        followings=new HashMap<>();
        twitter=new HashMap<>();
        maxHeap=new PriorityQueue<Tweet>((o1,o2)-> -o1.timestamp+o2.timestamp); //重写compare方法，利用优先队列实现大顶堆
    }


    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        timestamp++; //每发送一条，时间戳++
        if(twitter.containsKey(userId)){ //如果包含，则说明发布了新推特，需要新旧推特构成链表
            Tweet oldhead=twitter.get(userId);
            Tweet newHead=new Tweet(tweetId,timestamp);
            newHead.next=oldhead;
            twitter.put(userId,newHead);
        }else {
            twitter.put(userId,new Tweet(tweetId,timestamp));
        }
    }

    /**
     * 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。
     * 推文必须按照时间顺序由最近的开始排序。
     * 使用优先队列对多条链表进行排序
     * @param userId
     * @return
     */
    public List<Integer> getNewsFeed(int userId) {
        maxHeap.clear();
        //自己发了推文也要算上
        if(twitter.containsKey(userId)){
            maxHeap.offer(twitter.get(userId));
        }
        //获取该用户的关注列表
        Set<Integer> followList=followings.get(userId);
        //获取列表中的所有用户的推特信息
        if(followList!=null && followList.size()>0){
            for (Integer followid:followList) {
                Tweet tweet=twitter.get(followid);
                if(tweet!=null){
                    maxHeap.offer(tweet);
                }
            }
        }
        List<Integer> res=new ArrayList<>(10);
        int count=0;
        //弹出最新的十条
        while (!maxHeap.isEmpty()&& count<10){
            Tweet head=maxHeap.poll();
            res.add(head.id);
            if(head.next!=null){ //如果当前用户有多条推特，则继续添加进优先队列中
                maxHeap.offer(head.next);
            }
            count++;
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    //关注一个用户
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId){ //关注的是自己就返回
            return;
        }
        //获取自己的关注列表
        Set<Integer> followList=followings.get(followerId);
        if(followList==null){
            Set<Integer> init=new HashSet<>();
            init.add(followeeId);
            followings.put(followerId,init);
        }else {
            if(followList.contains(followeeId)){
                return;
            }
            followList.add(followeeId);
        }
    }
    //取消一个用户关注
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followeeId==followerId){
            return;
        }
        Set<Integer> followList=followings.get(followerId);
        if(followList==null){
            return;
        }
        followList.remove(followeeId);
    }

    /**
     * 推文类，是一个单链表（结点视角）
     */
    private class Tweet {
        /**
         * 推文 id
         */
        private int id;

        /**
         * 发推文的时间戳
         */
        private int timestamp;
        private Tweet next;

        public Tweet(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }
}
