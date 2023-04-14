package library;

import models.BaseUser;

import java.util.ArrayList;
import java.util.Stack;

public class PriorityQue{
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
        while (!que.isEmpty() && que.peek().getPriority() <= incomingPriority)
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