package com.jools.designpattern.iterator;

/**
 * @author Jools He
 * @date 2025/7/13 14:48
 * @description: TODO
 */
public class BookShelfIterator implements Iterator {

    private BookShelf bookShelf;
    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if (index < bookShelf.getLength()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        return this.bookShelf.getBook(index++);
    }
}
