package cli.sub;

import utils.FileHandler;
import utils.containers.ArrayContainer;
import utils.controller.MembershipController;
import utils.interfaces.IScannerInput;
import utils.interfaces.IViewer;

import java.util.ArrayList;
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
            case 1 -> {
                var dataFileName = "payments.csv";
                var fh = new FileHandler();
                var membersDataOutput = fh.load(dataFileName);

                if (membersDataOutput.isEmpty()){
                    System.out.println("\nIngen Data om betaling for registrerede medlemmer! - Registrer betaling af medlemmer i menuen for at se dem her!\n");
                    return;
                }

                System.out.println("\nNuværende betalende medlemmer! - Registrer betaling af medlemmer i menuen for at se dem her!\n");
                System.out.println("Medlems ID | Betalende");
                for(String[] data : membersDataOutput){
                    if (data.length > 1){
                        String hasPaid = "ja";
                        if (data[1].equals("2")){
                            hasPaid =  "nej";
                        }
                        System.out.println(data[0] + " " + hasPaid);
                        continue;
                    }
                    System.out.println(data[0]);
                }
                System.out.println();}
            //Check restance
            case 2 -> {
                var dataFileName = "payments.csv";
                var fh = new FileHandler();
                var paymentsDataOutput = fh.load(dataFileName);
//                mc.checkDebt(arrayContainer.getMemberList());
                for(String[] data : paymentsDataOutput){
                    if (data.length > 1){
                        if(data[1].equals("2")){
                            System.out.println(data[0] + " " + data[1]);
                        }
                        continue;
                    }
                    System.out.println(data[0]);

                }
            }
            //Betal regning
            case 3 -> {

                System.out.println("Hvilket medlems betaling skal registreres?\nSkriv medlems ID:");
                stringInput = stringInput();
                String memberId = stringInput;

//                mc.updateLastPaid(arrayContainer.getMemberList());
                var dataFileName = "payments.csv";
                var fh = new FileHandler();
                var paymentsDataOutput = fh.load(dataFileName);

                var isPaid = new ArrayList<String[]>();
                var isNotPaid = new ArrayList<String[]>();

//                mc.checkDebt(arrayContainer.getMemberList());
                for(String[] data : paymentsDataOutput){
                    if (data.length > 1){
                        if(data[1].equals("2")){
                            if(data[0].equals(memberId)){
                                data[1] = "1";
                                System.out.println(data[0] + " " + data[1]);
                                fh.save(data,"payments.csv",false);
                                continue;
                            }
                            isNotPaid.add(data);
                            continue;
                        }
                        isPaid.add(data);
                    }
                }

                isPaid.addAll(isNotPaid);
                for(String[] record : isPaid){
                    fh.save(record,"payments.csv",true);
                }


            }
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
