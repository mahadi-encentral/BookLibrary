package library;

import models.BaseUser;

import java.util.*;

public class WaitingList {

    /**
     * A singleton instance of the class to be used across the project
     */
    private static WaitingList instance;

    /**
     * Stores The WaitList for each Book
     * With bookId as key and Waiters as values
     */
    private final HashMap<String, PriorityQue> waiters = new HashMap<>();


    public static  WaitingList getInstance(){
        if(instance == null) instance = new WaitingList();
        return instance;
    }

    public ArrayList<BaseUser>  getBookWaitList(String bookId){
        if(!waiters.containsKey(bookId)) return new ArrayList<>();
        return waiters.get(bookId).asList();
    }

    public void addToWaitlist(String bookId, BaseUser user){
        if(waiters.containsKey(bookId))
            waiters.get(bookId).enqueue(user);
        else
            waiters.put(bookId, new PriorityQue(user));
    }

    public BaseUser getNextInLine(String bookId){
        final PriorityQue bookQue =  waiters.get(bookId);
        if(bookQue == null) return null;
        return bookQue.dequeue();
    }

    public void printBooksWaitingQue(String bookId){
        final var list = waiters.get(bookId).toArray();

//        Print The Array In reverse To get The Appropriate Order of the Que
       for (int i=list.length - 1; i > -1; i--)
       {
           System.out.print(((BaseUser)list[i]).getName());
           if(i != 0)
               System.out.print(" => ");
       }
       System.out.println();
    }


}
