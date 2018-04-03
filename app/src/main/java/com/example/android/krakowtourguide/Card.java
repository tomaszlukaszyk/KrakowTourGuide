package com.example.android.krakowtourguide;

/**
 * Stores all information associated with single card
 */

public class Card {

    // Holds the resource ID of image associated with card
    private final int image;
    // Holds the title of card
    private final String title;
    // Holds the text in body of card
    private final String body;

    /**
     * Create a new Card object
     */
    Card(int image, String title, String body) {
        this.image = image;
        this.title = title;
        this.body = body;
    }

    // Get the resource ID of the image associated with card
    int getImage() {
        return image;
    }

    // Get the title of card
    String getTitle() {
        return title;
    }

    // Get the text in body of card
    String getBody() {
        return body;
    }
}