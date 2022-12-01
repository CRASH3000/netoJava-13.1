package ru.netology.domain;

public class Book extends Product {
    private String author;
    private int pages;
    private int publishedYear;

    public Book() {
    }

    public Book(int id, String name, int cost, String author, int pages, int publishedYear) {
        super(id, name, cost);
        this.author = author;
        this.pages = pages;
        this.publishedYear = publishedYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }
}
