package com.jools.designpattern.iterator;

/**
 * @author Jools He
 * @date 2025/7/13 14:55
 * @description: TODO
 */
public class Main {

    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("Arount the World in 80 Days"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Cinderella"));
        bookShelf.appendBook(new Book("Daddy-Long-Legs"));
        Iterator iterator = bookShelf.iterator();
        while (iterator.hasNext()) {
            Book nextBook = (Book) iterator.next();
            System.out.println(nextBook.getName());
        }

        /*
         输出结果:
            Arount the World in 80 Days
            Bible
            Cinderella
            Daddy-Long-Legs
        */
    }
}
