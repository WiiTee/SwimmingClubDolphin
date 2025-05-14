package utils.input;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class ScannerInput {
    public String stringInput(){
        Scanner sc = new Scanner(System.in);
        String stringInput;

        try {
            stringInput = sc.nextLine();
            return stringInput;

        } catch (Exception e) {
            return "Error: No input was found! " + e;
        }
    }

    public int intInput(){
        Scanner sc = new Scanner(System.in);
        int intInput;

        try {
            intInput = sc.nextInt();
            return intInput;

        } catch (Exception e) {
            System.out.println("Error: Not an int input! " + e);
            return -1;
        }
    }
}
