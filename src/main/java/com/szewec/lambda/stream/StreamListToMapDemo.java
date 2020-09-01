package com.szewec.lambda.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamListToMapDemo {
    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<Book>(
                Arrays.asList(
                        new Book("01", "harry porter"),
                        new Book("02", "Porter and Hero"),
                        new Book("01", "My life")
                ));


        // loop the list
        bookList.forEach(book->System.out.println(book.toString()));

        // List convert to Map
        /**
         * key: bookItem.getBookId()
         * value: bookItem.getBookName()
         *
         * (oldVal, currVal) -> currVal) // key相同时当前值替换原始值
         * (oldVal, currVal) -> oldVal + currVal //key相同时保留原始值和当前值
         */

        Map<String,String> bookMap = bookList.stream().collect(Collectors.toMap(bookItem ->bookItem.getBookId(), bookItem->bookItem.getBookName(),(oldVal, currVal)->currVal));

//        Map<String,String> bookMap = bookList.stream().collect(Collectors.toMap(bookItem ->bookItem.getBookId(), bookItem->bookItem.getBookName(),(oldVal, currVal)->oldVal + currVal));

        // loop the map
        bookMap.forEach((key,value)-> System.out.println("bookId:" + key + ",bookName:" + value));
    }
}
