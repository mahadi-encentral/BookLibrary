package library;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Borrowings {

    private final static String FILE_PATH = "path_to_file";

    private static ArrayList<BorrowingInstance> borrowings;

    public Borrowings(){
        borrowings = new ArrayList<>();
    }

    static List<String> getUserBorrowings(String userId){
        return borrowings.stream().filter(
                b-> b.getUserId().equals(userId)
        ).map(BorrowingInstance::getBookId).collect(Collectors.toList());
    }

    static List<String> getBookBorrowers(String bookId){
        return borrowings.stream().filter(
                b->b.getBookId().equals(bookId)
        ).map(BorrowingInstance::getUserId).collect(Collectors.toList());
    }

    static void recordBorrowing(BorrowingInstance borrowingInstance){
        borrowings.add(borrowingInstance);
    }

    static void saveRecords(){
//        Not Yet implemented
//        Serializes Borrrowings and Save In a File
//
    }

    public static void loadRecords(){
//        Not Yet Implemented
//        De-Serializes Borrowings and Save in Run time
    }

    public static ArrayList<BorrowingInstance> getAllBorrowings(){
        return borrowings;
    }


}
