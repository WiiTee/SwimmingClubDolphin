package cli.main;

import cli.sub.CompetitiveViewer;
import utils.containers.ArrayContainer;
import utils.interfaces.IScannerInput;
import utils.interfaces.IViewer;
import cli.sub.PaymentViewer;
import cli.sub.RegistrationViewer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainViewer implements IScannerInput, IViewer {
    private boolean isActive = true;
    private int intInput;

    ArrayContainer arrayContainer = new ArrayContainer();
    PaymentViewer pc = new PaymentViewer();
    RegistrationViewer rc = new RegistrationViewer();
    CompetitiveViewer cv = new CompetitiveViewer();

    //Required for IViewer implementation
    public void menu(ArrayContainer arrayContainer){}

    //Overloaded method to allow change from IViewer
    public void menu(){
        while(isActive){
            options();
            selection();
        }
    }

    //Velkomst tekst
    public void greetingText(){
        System.out.println("""
                ############################
                #  Svømmeklubben Delfinen  #
                ############################
                """);

        System.out.println("Now loading files, please hang on!");
        arrayContainer.loadMember();
    }

    public void options(){
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

    public void selection(){
        intInput = intInput();
        switch (intInput){
            //Registreringsmenu
            case 1 -> rc.menu(arrayContainer);
            //Betalingsmenu
            case 2 -> pc.menu(arrayContainer);
            //Medlemsoversigt
            case 3 -> {}
            //Konkurrencesvømning menu
            case 4 -> cv.menu(arrayContainer);
            //Luk programmet
            case 5 -> {
                arrayContainer.createFiles("memberlist.csv");
                arrayContainer.createFiles("paymentlist.csv");
                arrayContainer.createFiles("membershiplist.csv");

                arrayContainer.save(arrayContainer.getMemberList());
            }
        }
    }

    public String stringInput(){
        Scanner sc = new Scanner(System.in);
        try {;
            return sc.nextLine();

        } catch (Exception e) {
            return "Error: No input was found! " + e;
        }
    }

    public int intInput(){
        Scanner sc = new Scanner(System.in);
        try {
            return sc.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("Error: Not an int input! " + e);
            return -1;
        }
    }
}