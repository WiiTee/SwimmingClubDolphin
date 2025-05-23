package cli.sub;

import lib.persons.Member;
import utils.FileHandler;
import utils.controller.CompetitiveController;
import utils.containers.ArrayContainer;
import utils.interfaces.IScannerInput;
import utils.interfaces.IViewer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CompetitiveViewer implements IViewer, IScannerInput {
    private String stringInput;
    private int intInput;
    private boolean isActive = true;
    private ArrayContainer arrayContainer;

    CompetitiveController cc = new CompetitiveController();

    //Competitive skal ind i sin egen viewer!
    public void menu(ArrayContainer arrayContainer){
        this.arrayContainer = arrayContainer;
        while(isActive) {
            options();
            selection();
        }
        isActive = true;
    }

    public void options(){
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

    public void selection(){
            intInput = intInput();
            switch (intInput) {
                //Registrer svømmer
                case 1 -> cc.addSwimmer(arrayContainer.getMemberList(), arrayContainer.getTeamList());
                //Registrer træning
                case 2 -> cc.registerTraining(arrayContainer.getMemberList(), arrayContainer.getTrainingList());
                //Registrer konkurrence
                case 3 -> {}
                //Registrer træner
                case 4 -> cc.addTrainer(arrayContainer.getTrainerList(), arrayContainer.getTeamList());
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

        } catch (InputMismatchException e) {
            System.out.println("Error: Not an int input! " + e);
            return -1;
        }
    }
}
