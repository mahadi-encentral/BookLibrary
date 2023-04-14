package library;

import models.BaseUser;

import java.util.*;

public class WaitingList {

    /**
     * Stores The WaitList for each Book
     * With bookId as key and Waiters as values
     */
    private final static HashMap<String, PriorityQue> waiters = new HashMap<>();

    public static ArrayList<BaseUser>  getBookWaitList(String bookId){
        if(!waiters.containsKey(bookId)) return new ArrayList<>();
        return waiters.get(bookId).asList();
    }

    public static void addToWaitlist(String bookId, BaseUser user){
        if(waiters.containsKey(bookId))
            waiters.get(bookId).enqueue(user);
        else
            waiters.put(bookId, new PriorityQue(user));
    }

    public static BaseUser getNextInLine(String bookId){
        return waiters.get(bookId).dequeue();
    }


}


class PriorityQue{
    private final Stack<BaseUser> que;

    public PriorityQue(){
        que = new Stack<>();
    }

    public PriorityQue(BaseUser user){
        this();
        enqueue(user);
    }

    /**
     * Add a User in the appropriate position in the que base on his priority
     * @param user User to add in the Que
     */
    public void enqueue(BaseUser user){
        Stack<BaseUser> temp = new Stack<>();
        int incomingPriority = user.getPriority();

//        Remove All Higher priority Users
        while (!que.isEmpty() && que.peek().getPriority() < incomingPriority)
            temp.push(que.pop());
//        Add The Incoming User at the Correct Position
        que.push(user);

//        Put Back Previously Removed Users
        while (!temp.isEmpty())
            que.push(temp.pop());

    }

    public BaseUser dequeue(){
        if(que.isEmpty()) return null;
        return que.pop();
    }

    public ArrayList<BaseUser> asList(){
        return new ArrayList<>(que);
    }

    public boolean isEmpty(){return que.isEmpty();}
    public int getSize(){return que.size();}
}
