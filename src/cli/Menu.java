package cli;

import utils.input.ScannerInput;

public class Menu{
    static ScannerInput si = new ScannerInput();
    static int intInput = si.intInput();
    private static boolean isActive = true;

    public static void mainMenu(){
        while(isActive){
            mainMenuOptions();
            mainMenuSelection();
        }
    }

    public static void greetingText(){
        System.out.println("""
                ############################
                #  Svømmeklubben Delfinen  #
                ############################""");
    }

    public static void mainMenuOptions(){
        System.out.println("""
                ############################
                #        Hovedmenu         #
                ############################
                
                1. Registrering
                2. Betalingsoversigt
                3. Medlemsoversigt
                4. Konkurrencesvømning
                """);
    }

    public static void mainMenuSelection(){
        switch (intInput){
            case 1 -> {
               registerMenu();
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
        }
    }

    public static void registerMenu(){
        registerOptions();
        registerSelection();
    }

    public static void registerOptions(){
        System.out.println("""
                ############################
                #    Registreringsmenu     #
                ############################
                
                1. Registrer medlem
                2. Registrer træner
                3. Registrer bogholder
                4. Registrer hold
                """);
    }

    public static void registerSelection(){
        switch (intInput){
            case 1 -> {
                //Registrer medlem
            }
            case 2 -> {
                //Registrer træner
            }
            case 3 -> {
                //Registrer bogholder
            }
            case 4 -> {
                //Registrer hold
            }
        }
    }

    public static void paymentMenu(){
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
                """);
    }

    public static void paymentSelection(){
        switch (intInput){
            case 1 -> {
                //Betalingsoversigt
            }
            case 2 -> {
                //Restance oversigt
            }
        }
    }

    public static void competitiveMenu(){
        competitiveOptions();
        competitiveSelection();
    }

    public static void competitiveOptions(){
        System.out.println("""
                ############################
                #    Konkurrencesvømning   #
                ############################
                
                1. Registrer svømmer
                2. Registrer træning
                3. Registrer konkurrence
                4. Registrer holdtræner
                """);
    }

    public static void competitiveSelection(){
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
        }
    }

    //Ikke nødvendigt
    /*
    public static void memberMenu(){}
    public static void memberOptions(){}
    public static void memberSelection(){}
    */
}