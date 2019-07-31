package com.library.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import sun.misc.BASE64Encoder;

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

}

