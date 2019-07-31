package com.library.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.Scanner;

public class PasswordInput {

    static String user;
    static String password;

    public String credentialsInput () {
        Scanner sc = new Scanner ( System.in );

        System.out.println ( "" );
        System.out.println ( "****** Welcome to Solo's Library ******" );
        System.out.println ( "" );
        System.out.println ( "Please enter your User" );
        user =  ( sc.nextLine () );
        System.out.println ( "Please enter your Password" );
        password =  ( sc.nextLine () );
        return  user+":"+password;
    }



    public void validationRequest() {
        credentialsInput();
        Client client = Client.create();
        String urlClient = "http://localhost:8080/library/search/auth";
        String url = urlClient;
        ClientResponse response = null;
        WebResource webResource = client.resource(url);

        String authString = user + ":" + password;
        String authStringEnc = new BASE64Encoder().encode(authString.getBytes());

        response = webResource.type("application/json").header("Authorization", "Basic " + authStringEnc)
                .post(ClientResponse.class);

        if (response.getStatus() != 200) {
            System.out.println("HTTP Error: " + response.getStatus());
        }
        Messages servAns = new Messages();
        ObjectMapper mapper = new ObjectMapper();
        try {

            servAns= mapper.readValue (response.getEntity ( String.class ),Messages.class);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

        String message = servAns.getAlert();
        String status = servAns.getStatus();
        if (status.equals("OK")) {
            System.out.println(message);
            ClientEntry.showMenu();
        } else {
            System.out.println(message);
            validationRequest();
        }
    }
}

