package library;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Borrowings {

    //    private final static String FILE_PATH = "path_to_file";
    private static Borrowings instance;
    private final ArrayList<BorrowingInstance> borrowings;


    public Borrowings() {
        borrowings = new ArrayList<>();
    }

    public static Borrowings getInstance() {
        if (instance == null) instance = new Borrowings();
        return instance;
    }

    public List<BorrowingInstance> getUserBorrowings(String userId) {
        return borrowings.stream().filter(
                b -> b.getUserId().equals(userId)
        ).collect(Collectors.toList());
    }

    public List<String> getBookBorrowers(String bookId) {
        return borrowings.stream().filter(
                b -> b.getBookId().equals(bookId)
        ).map(BorrowingInstance::getUserId).collect(Collectors.toList());
    }

    public void recordBorrowing(BorrowingInstance borrowingInstance) {
        borrowings.add(borrowingInstance);
    }

    public void recordBorrowing(String userId, String bookId) {
        recordBorrowing(new BorrowingInstance(userId, bookId));
    }


    public boolean removeFromBorrowers(BorrowingInstance borrowingInstance) {
        return borrowings.remove(borrowingInstance);
    }

    public void removeFromBorrowers(String userId, String bookId) {
        removeFromBorrowers(new BorrowingInstance(userId, bookId));
    }

    public void saveRecords() {
//        Not Yet implemented
//        Serializes Borrrowings and Save In a File
//
    }

    public void loadRecords() {
//        Not Yet Implemented
//        De-Serializes Borrowings and Save in Run time
    }

    public ArrayList<BorrowingInstance> getAllBorrowings() {
        return borrowings;
    }


}
