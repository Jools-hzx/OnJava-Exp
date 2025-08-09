package com.jools.designpattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jools He
 * @date 2025/7/13 14:44
 * @description: TODO
 */
public class BookShelf implements Aggregate {

    private List<Book> books;
    private int last = 0;
    private int maxSize;

    public BookShelf(int maxSize) {
        this.books = new ArrayList<>(maxSize);
        this.maxSize = maxSize;
    }

    private boolean isFull() {
        return this.last == this.maxSize;
    }

    public Book getBook(int index) {
        return books.get(index);
    }

    public void appendBook(Book book) {
        if (isFull()) {
            throw new RuntimeException("书架已满...");
        }
        this.books.add(last++, book);
    }

    public int getLength() {
        return last;
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
