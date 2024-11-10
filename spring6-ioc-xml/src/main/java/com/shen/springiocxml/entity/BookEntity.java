package com.shen.springiocxml.entity;

/**
 * 书的实体类
 */
public class BookEntity {
    private String name;
    private String author;

    public BookEntity() {
    }

    public BookEntity(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
