package cli;

import cli.controllers.RegistrationController;
import utils.containers.ArrayContainer;
import utils.interfaces.IScannerInput;

import java.util.Scanner;

public class Menu implements IScannerInput{
    private boolean isActive = true;
    private String stringInput;
    private int intInput;
    private ArrayContainer arrayContainer;


    RegistrationController rc = new RegistrationController();


    public void mainMenu(){
        while(isActive){
            mainMenuOptions();
            mainMenuSelection();
        }
    }

    public void greetingText(){
        System.out.println("""
                ############################
                #  Svømmeklubben Delfinen  #
                ############################""");
    }

    public void mainMenuOptions(){
        System.out.println("""
                ############################
                #        Hovedmenu         #
                ############################
                
                1. Registrering
                2. Betalingsoversigt
                3. Medlemsoversigt
                4. Konkurrencesvømning
                5. Luk
                """);
    }

    public void mainMenuSelection(){
        intInput = intInput();
        switch (intInput){
            case 1 -> {
               rc.registerMenu(arrayContainer);
            }
            case 2 -> {
                //Betalingsoversigt Metode
            }
            case 3 -> {
                //Medlemsoversigt Metode
            }
            case 4 -> {
                //Konkurrencesvømning
            }
            case 5 -> {
                //Slut
            }
        }
    }

    public void paymentMenu(){
        paymentOptions();
        paymentSelection();
    }

    public static void paymentOptions(){
        System.out.println("""
                ############################
                #      Betalingsmenu       #
                ############################
                
                1. Betalingsoversigt
                2. Restance oversigt
                3. Tilbage
                """);
    }

    public void paymentSelection(){
        intInput = intInput();
        switch (intInput){
            case 1 -> {
                //Betalingsoversigt
            }
            case 2 -> {
                //Restance oversigt
            }
            case 3 -> {
                //Tilbage
            }
        }
    }

    public void competitiveMenu(){
        competitiveOptions();
        competitiveSelection();
    }

    public void competitiveOptions(){
        System.out.println("""
                ############################
                #    Konkurrencesvømning   #
                ############################
                
                1. Registrer svømmer
                2. Registrer træning
                3. Registrer konkurrence
                4. Registrer holdtræner
                5. Tilbage
                """);
    }

    public void competitiveSelection(){
        switch (intInput){
            case 1 -> {
                //Registrer svømmer
            }
            case 2 -> {
                //Registrer træning
            }
            case 3 -> {
                //Registrer konkurrence
            }
            case 4 -> {
                //Registrer træner
            }
            case 5 -> {
                //Tilbage
            }
        }
    }

    public String stringInput(){
        Scanner sc = new Scanner(System.in);
        try {
            stringInput = sc.nextLine();
            return stringInput;

        } catch (Exception e) {
            return "Error: No input was found! " + e;
        }
    }

    public int intInput(){
        Scanner sc = new Scanner(System.in);
        try {
            intInput = sc.nextInt();
            return intInput;

        } catch (Exception e) {
            System.out.println("Error: Not an int input! " + e);
            return -1;
        }
    }

    //Ikke nødvendigt
    /*
    public static void memberMenu(){}
    public static void memberOptions(){}
    public static void memberSelection(){}
    */
}