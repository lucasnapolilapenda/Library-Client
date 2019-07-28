package com.library.client;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.persistence.jaxb.JAXBContext;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class DataTransformation {

    public void stringPresentation () {
        ArrayList<Book> bookArrayList = new ArrayList<Book>();
        try {
            bookArrayList = new Request().postRequestBook();
        } catch (MalformedURLException ex) {
            System.out.println("Error: "+ ex);
        }
        for (Book book: bookArrayList) {
            System.out.println(book.toString());
        }

    }

    public void jsonPresentation  () {
        ArrayList<Book> bookArrayList = new ArrayList<Book>();
        String jsonData = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            bookArrayList = new Request().postRequestBook();
        } catch (MalformedURLException ex) {
            System.out.println("Error: "+ ex);
        }
        try {
            jsonData = mapper.writeValueAsString(bookArrayList);
        } catch (JsonProcessingException e) {
            System.out.println("Error: "+ e);
        }
        System.out.println(jsonData);
    }

    public void xmlPresentation () {
        ArrayList<Book> bookArrayList = new ArrayList<Book>();
        Books books = new Books();
        books.setBooks(new ArrayList<Book>());

        try {
            bookArrayList = new Request().postRequestBook();
        } catch (MalformedURLException ex) {
            System.out.println("Error: "+ ex);
        }

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

    }


}
