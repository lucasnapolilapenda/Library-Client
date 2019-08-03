package com.library.client;

/**
 *
 * @author Lucas Napoli
 * V1.0
 * Library Microservices
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Represents all the books
 */

@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book implements Cloneable {

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    private String isbn;
    private String title;
    private String author;
    private String description;
    private String summary;
    private String publisher;
    private String publishingdate;

    public Book() {}

    public Book(String title){
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * @return  summary publisher to set
     */

    public String getSummary() {
        return summary;
    }

    /**
     * @param summary the publisher to set
     * @return summary string
     */

    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * @return  summary publisherdate
     */

    public String getPublishingdate() {
        return publishingdate;
    }

    /**
     * @param publishingdate the publisher to set
     * @return publishing string
     */

    public void setPublishingDate(String publishingdate) {
        this.publishingdate = publishingdate;
    }

    /**
     * @return b as Book
     */

    public Book clone() {
        Book b = new Book();
        b.setIsbn(this.isbn);
        b.setTitle(this.title);
        b.setAuthor(this.author);
        b.setDescription(this.description);
        b.setSummary(this.summary);
        b.setPublisher(this.publisher);
        b.setPublishingDate(this.publishingdate);
        return b;
    }


    /**
     * @return Book as String
     */
    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", summary='" + summary + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishingdate='" + publishingdate + '\'' +
                '}';
    }
}