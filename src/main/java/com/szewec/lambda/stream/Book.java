package com.szewec.lambda.stream;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private String bookId;
    private String bookName;

    public Book(String bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}
