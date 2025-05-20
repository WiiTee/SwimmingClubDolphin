package cli.sub;

import utils.containers.ArrayContainer;
import utils.controller.MembershipController;
import utils.interfaces.IScannerInput;
import utils.interfaces.IViewer;

import java.util.Scanner;

public class PaymentViewer implements IScannerInput, IViewer {
    private String stringInput;
    private int intInput;
    private boolean isActive = true;
    private ArrayContainer arrayContainer;

    MembershipController mc = new MembershipController();

    //MainViewer for bogholderi menuen
    //Indeholder options (som er UI) og selection som er controller
    //Tager ArrayContainer med som argument så det kan gemmes til senere save/load.
    public void menu(ArrayContainer arrayContainer){
        this.arrayContainer = arrayContainer;
        while(isActive) {
            options();
            selection();
        }
    }

    //Payment UI
    public void options(){
        System.out.println("""
                ############################
                #      Betalingsmenu       #
                ############################
                
                1. Betalingsoversigt
                2. Restance oversigt
                3. Betal regning
                4. Opdatér betalingssum
                5. Tilbage
                """);
    }

    //Payment controller (switch)
    public void selection(){
        intInput = intInput();
        switch (intInput){
            //Betalingsoversigt
            case 1 -> {}
            //Check restance
            case 2 -> mc.checkDebt(arrayContainer.getMemberList());
            //Betal regning
            case 3 -> mc.updateLastPaid(arrayContainer.getMemberList());
            //Opdater betalingssum for alle medlemmer
            case 4 -> mc.updatePaymentAmount(arrayContainer.getMemberList());
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
