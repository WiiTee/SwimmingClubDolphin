package cli.sub;

import utils.containers.ArrayContainer;
import utils.controller.PersonsController;
import utils.interfaces.IScannerInput;
import utils.interfaces.IViewer;

import java.util.Scanner;

public class RegistrationViewer implements IScannerInput, IViewer {
    private String stringInput;
    private int intInput;
    private boolean isActive = true;
    private ArrayContainer arrayContainer;

    PersonsController rc = new PersonsController();

    //MainViewer for registrering af medlemmer, trænere m.m
    //Indeholder options (som er UI) og selection som er controller
    //Tager ArrayContainer med som argument så det kan gemmes til senere save/load.
    public void menu(ArrayContainer arrayContainer){
        this.arrayContainer = arrayContainer;
        while(isActive) {
            options();
            selection();
        }
    }

    //UI delen af registrer menuen
    public void options(){
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

    //Controller delen af registrer menuen
    public void selection(){
        intInput = intInput();

        switch (intInput){
            //Registrer medlem
            case 1 -> rc.registerMember(arrayContainer.getMemberList());
            //Registrer træner
            case 2 -> rc.registerTrainer(arrayContainer.getTrainerList());
            //Registrer bogholder
            case 3 -> rc.registerAccountant(arrayContainer.getAccountantList());
            //Registrer hold
            case 4 -> {}
            //Tilbage
            case 5 -> isActive = false;
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
