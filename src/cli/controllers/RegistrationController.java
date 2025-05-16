package cli.controllers;

import lib.competitive.Team;
import utils.containers.ArrayContainer;
import utils.handlers.RegistrationHandler;
import utils.interfaces.IScannerInput;

import java.util.ArrayList;
import java.util.Scanner;

public class RegistrationController implements IScannerInput {
    private String stringInput;
    private int intInput;
    private ArrayContainer arrayContainer;

    RegistrationHandler rh = new RegistrationHandler();

    public void registerMenu(ArrayContainer arrayContainer){
        this.arrayContainer = arrayContainer;
        registerOptions();
        registerSelection();
    }

    public void registerOptions(){
        System.out.println("""
                ############################
                #    Registreringsmenu     #
                ############################
                
                1. Registrer medlem
                2. Registrer træner
                3. Registrer bogholder
                4. Registrer hold
                5. Tilbage
                """);
    }

    public void registerSelection(){
        intInput = intInput();

        switch (intInput){
            case 1 -> {
                //Registrer medlem
            }
            case 2 -> {
                //Registrer træner
            }
            case 3 -> {
                rh.registerAccountant(arrayContainer.getAccountantList());
            }
            case 4 -> {
                //Registrer hold
            }
            case 5 -> {
                //Tilbage
            }
        }
    }

    @Override
    public String stringInput(){
        Scanner sc = new Scanner(System.in);
        try {
            stringInput = sc.nextLine();
            return stringInput;

        } catch (Exception e) {
            return "Error: No input was found! " + e;
        }
    }

    @Override
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
}
