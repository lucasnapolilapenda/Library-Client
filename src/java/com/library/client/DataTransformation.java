package com.library.client;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.persistence.jaxb.JAXBContext;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.ArrayList;
import java.util.Scanner;

public class DataTransformation {



    public void stringPresentation () {
        System.out.println ( "****** String Data Module ******" );
        ArrayList<Book> bookArrayList = new ArrayList<Book>();
        bookArrayList = new Request().postRequestBook();
        for (Book book: bookArrayList) {
            System.out.println(book.toString());
        }
        ClientEntry.showMenu ( );

    }

    public void jsonPresentation  ()  {
        System.out.println ( "****** Json Data Module ******" );
        ArrayList<Book> bookArrayList = new ArrayList<Book>();
        String jsonData = "";
        ObjectMapper mapper = new ObjectMapper();
        bookArrayList = new Request().postRequestBook();
        try {
            jsonData = mapper.writeValueAsString(bookArrayList);
        } catch (JsonProcessingException e) {
            System.out.println("Error: "+ e);
        }
        System.out.println(jsonData);
        ClientEntry.showMenu ( );
    }

    public void xmlPresentation ()  {
        System.out.println ( "****** XML Data Module ******" );
        ArrayList<Book> bookArrayList = new ArrayList<Book>();
        Books books = new Books();
        books.setBooks(new ArrayList<Book>());

        bookArrayList = new Request().postRequestBook();

        for (Book aux: bookArrayList) {
            books.getBooks().add(aux);
        }

        try {
            javax.xml.bind.JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(books, System.out);
        } catch (JAXBException e) {
            System.out.println("Error: "+ e);
        }
        ClientEntry.showMenu ( );
    }



}
