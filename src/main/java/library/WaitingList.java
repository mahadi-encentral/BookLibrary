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
