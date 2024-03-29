package com.library.client;

/**
 *
 * @author Lucas Napoli
 * V1.0
 * Library Microservices
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.sun.jersey.api.client.*;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Manage request to the server
 */

public class Request {


    Client client = Client.create();
    String urlClient = "http://localhost:8080/library/search/search";

    /**
     * request and return Array to be formatted
     * @return ArrayList with the info to be formatted
     */


    public ArrayList<Book> postRequestBook() {

        System.out.println ( ":::::: Module Search Engine Book ::::::" );
        String url = urlClient;
        WebResource webResource = client.resource ( url );
        Book book = new Request().preparationBook ();
        return mapperBook ( webResource, book, false);

    }

    /**
     * Display help to the user
     */


    public void help() {
        System.out.println ( "***** Welcome to Solo's Library System Latest Version  *****" );
        System.out.println (    "\n In this System you can search, books with microservices. " +
                "\n Additionally, you can work remotely with SOAP and REST, you " +
                "\n It has been a hard work, but we are sure, you will enjoy it " +
                "\n Thanks for using Lucas Software and enjoy it" );

        System.out.println ( "Please, type any KEY to come back to the Menu" );
        Scanner sc = new Scanner ( System.in );
        sc.next ( );
        ClientEntry.showMenu ( );
    }

    /**
     * To map Book Object
     * @param webResource to create the String
     * @param book Object
     * @param put if a put or post
     * @throws RuntimeException heritage Malformed
     * @return ArrayBook
     */

    public ArrayList<Book> mapperBook(WebResource webResource, Book book, Boolean put) {

        ObjectMapper mapper = new ObjectMapper();
        String inputData = null;
        ClientResponse response = null;
        String authString = PasswordInput.user+":"+PasswordInput.password;
        String authStringEnc = new BASE64Encoder().encode(authString.getBytes());



        try {
            inputData = mapper.writeValueAsString(book);
        } catch (JsonProcessingException e) {
            e.printStackTrace ( );
        }
        if (put){
            response = webResource.type ( "application/json" ).put ( ClientResponse.class, inputData );
            if (response.getStatus ( ) != 200) {
                System.out.println ( "HTTP Error: " + response.getStatus ( ) );
            }
        }
        else {
            response = webResource.type ( "application/json" )
                    .header("Authorization", "Basic " + authStringEnc)
                    .post ( ClientResponse.class, inputData );

            if (response.getStatus ( ) != 200) {
                System.out.println ( "HTTP Error: " + response.getStatus ( ) );
            }
        }
        return mapperList(response);
    }

    /**
     * To map Book List
     * @param response to create String
     * @throws RuntimeException heritage Malformed
     * @return ArrayList
     */

    public ArrayList<Book> mapperList(ClientResponse response) {

        ArrayList<Book> bookArrayList = new ArrayList<>();

        if(response.getStatus()!=200){
            System.out.println("HTTP Error: "+ response.getStatus());
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper ( );
            Book [] arrayBook = objectMapper.readValue (response.getEntity ( String.class ),Book[].class);

            for (Book jBook : arrayBook ) {
                Book b = new Book ();
                b.setIsbn(jBook.getIsbn());
                b.setTitle(jBook.getTitle());
                b.setAuthor(jBook.getAuthor());
                b.setDescription(jBook.getDescription());
                b.setIsbn(jBook.getIsbn());
                b.setPublishingDate(jBook.getPublishingdate());
                b.setSummary(jBook.getSummary());
                b.setPublisher(jBook.getPublisher());
                bookArrayList.add(b);
            }
        } catch (IOException | UniformInterfaceException e) {
            System.out.println("Perhaps you should reenter your credentials or some service down, contact your administrator");
            System.out.println("HTTP Error: "+ e);
            new PasswordInput().credentialsInput();
        }
        return bookArrayList;
    }



    /**
     * Create Book Object
     * @return Book class
     */

    public Book preparationBook () {

        Scanner sc = new Scanner ( System.in );
        Book book = new Book ();
        System.out.println ( "Please enter the Title" );
        book.setTitle ( sc.nextLine () );
        System.out.println ( "Please enter the Description" );
        book.setDescription ( sc.nextLine () );
        System.out.println ( "Please enter the Publisher" );
        book.setPublisher ( sc.nextLine () );
        return book;
    }

}
