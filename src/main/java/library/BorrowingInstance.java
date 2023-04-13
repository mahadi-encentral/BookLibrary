package library;

import java.util.Date;

public class BorrowingInstance {

    private String userId;
    private String bookId;
    private Date dateBorrowed;

    public static BorrowingInstance stringToBorrowingInstance(String stringrepresentation){
        String segments[] = stringrepresentation.split("#");
        return new BorrowingInstance(segments[0], segments[1], new Date(Long.parseLong(segments[2])));
    }
    public BorrowingInstance(String userId, String bookId, Date dateBorrowed) {
        this.userId = userId;
        this.bookId = bookId;
        this.dateBorrowed = dateBorrowed;
    }

    public BorrowingInstance(String userId, String bookId) {
       this(userId,bookId, new Date());
    }

    @Override
    public String toString() {
        return String.format("%s#%s#%s", userId, bookId, String.valueOf(dateBorrowed.getTime()));
    }
}
