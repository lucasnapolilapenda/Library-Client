package com.library.client;

/** Library Solos Rest.
 * @author Lucas Napoli
 * @author https://github.com/lucasnapolilapenda/SOAPClient
 * @version 1.1
 * @since 1.0
 */

import java.net.MalformedURLException;
import java.util.InputMismatchException;
import java.util.Scanner;


/**Starting Point
 */
public class ClientEntry {
    public static void main(String[] argv) {
        new PasswordInput().validationRequest();
    }

    /**Display the menu. This starts when the app load
     * @throws NumberFormatException manage Integer input
     * @throws InputMismatchException manage Integer input
     */

    public static void showMenu() {
        try {
            int exit = 0;
            do {
                System.out.println ( "Please, Select one Option - Int Required from 0 to 4" );
                System.out.println ( "1. Look for Book information in String Format" );
                System.out.println ( "2. Look for Book information in json Format" );
                System.out.println ( "3. Look for Book information in XML Format" );
                System.out.println ( "4. Help" );
                System.out.println ( "0. Quit" );
                System.out.println ( "" );

                Scanner sc = new Scanner ( System.in );
                int response = Integer.valueOf ( sc.nextLine ( ) );
                System.out.println ( response );
                switch (response) {
                    case 0:
                        //salir
                        exit = 0;
                        break;
                    case 1:
                        new DataTransformation().stringPresentation();
                        break;
                    case 2:
                        new DataTransformation().jsonPresentation();
                        break;
                    case 3:
                        new DataTransformation().xmlPresentation();
                        break;
                    case 4:
                        new Request().help();
                        break;

                    default:
                        System.out.println ( );
                        System.out.println ( "Please, Select one Option" );
                        System.out.println ( );
                        showMenu();
                        break;
                }

            } while (exit != 0);
        } catch (InputMismatchException | NumberFormatException ex) {
            System.out.println ( "Error: " + ex );
            showMenu ();
        }
    }

}
