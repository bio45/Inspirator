package com.neek.tech.inspirator.model;

/**
 * Model class for quotes
 */
public class Quote {

    /**
     * Author name
     */
    private String mAuthor;

    /**
     * Message
     */
    private String message;

    /**
     * External link.
     */
    private String mAuthorLink;

    public Quote(String author, String message, String authorLink) {
        mAuthor = author;
        this.message = message;
        mAuthorLink = authorLink;
    }

    /**
     * Default constructor.
     */


    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthorLink() {
        return mAuthorLink;
    }

    public void setAuthorLink(String authorLink) {
        mAuthorLink = authorLink;
    }

    public static Quote getMockQuote() {
        return new Quote("Nelson Mandela", "Don't eat up your purpose on Purpose", null);
    }

}
