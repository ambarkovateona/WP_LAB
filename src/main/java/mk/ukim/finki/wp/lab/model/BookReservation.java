package mk.ukim.finki.wp.lab.model;

import lombok.Data;

@Data
public class BookReservation {

    private String bookTitle;
    private String readerName;
    private String readerAddress;
    private Long numberOfCopies;

    public BookReservation(String bookTitle, Long numberOfCopies, String readerAddress, String readerName) {
        this.bookTitle = bookTitle;
        this.numberOfCopies = numberOfCopies;
        this.readerAddress = readerAddress;
        this.readerName = readerName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Long getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(Long numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public String getReaderAddress() {
        return readerAddress;
    }

    public void setReaderAddress(String readerAddress) {
        this.readerAddress = readerAddress;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }
}
