package P.Heaps.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {
	private static int timeStamp = 0;
	private Map<Integer,User> userMap;
	class User{
		int id;
		Set<Integer> followed;
		Tweet tweet_head;
		
		public User(int id) {
			this.id = id;
			followed = new HashSet<>();
			follow(id);
			tweet_head = null;
		}
		
		public void follow(int id) {
			followed.add(id);
		}
		
		public void unfollow(int id) {
			followed.remove(id);
		}
		
		public void post(int id) {
			Tweet t = new Tweet(id);
			t.next = tweet_head;
			tweet_head = t;
		}
	}
	
	class Tweet{
		int id;
		int time;
		Tweet next;
		
		public Tweet(int id) {
			this.id = id;
			this.time = timeStamp++;
			this.next = null;
		}
		
	}
	
	
	public Twitter() {
		userMap = new HashMap<Integer,User>();
	}
	
	public void postTweet(int userId, int tweetId) {
		if(!userMap.containsKey(userId)) {
			User newUser = new User(userId);
			userMap.put(userId, newUser);
		}
		userMap.get(userId).post(tweetId);
	}
	
	public List<Integer> getNewsFeed(int userId){
		List<Integer> feed = new ArrayList<>();
		
		if(!userMap.containsKey(userId)) return feed;
		
		Set<Integer> users = userMap.get(userId).followed;
		PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>((a,b)->(b.time-a.time));
		for(int user:users) {
			Tweet t = userMap.get(user).tweet_head;
			if(t!=null) {
				pq.add(t);
			}
		}
		
		int count = 0;
		
		while(!pq.isEmpty() && count<10) {
			Tweet t = pq.poll();
			feed.add(t.id);
			count++;
			if(t.next!=null) {
				pq.add(t.next);
			}
		}
		
		return feed;
	}
	
	public void follow(int followerId,int followeeId) {
		if(!userMap.containsKey(followerId)) {
			User newUser = new User(followerId);
			userMap.put(followerId, newUser);
		}
		if(!userMap.containsKey(followeeId)) {
			User newUser = new User(followeeId);
			userMap.put(followeeId, newUser);
		}
		userMap.get(followerId).follow(followeeId);
	}
	
	public void unfollow(int followerId,int followeeId) {
		if(!userMap.containsKey(followerId)|| followerId==followeeId) {
			return;
		}
		userMap.get(followerId).unfollow(followeeId);
	}
	
	public static void main(String[] args) {
		Twitter twit = new Twitter();
		twit.postTweet(1, 5);
		List<Integer> feed1 = twit.getNewsFeed(1);
		System.out.println(feed1.toString());
		twit.follow(1, 2);
		twit.postTweet(2, 6);
		List<Integer> feed2 = twit.getNewsFeed(1);
		System.out.println(feed2.toString());
		twit.unfollow(1, 2);
		List<Integer> feed3 = twit.getNewsFeed(1);
		System.out.println(feed3.toString());
	}

}
