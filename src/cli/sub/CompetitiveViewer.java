package cli.sub;

import lib.persons.Member;
import utils.FileHandler;
import utils.controller.CompetitiveController;
import utils.containers.ArrayContainer;
import utils.interfaces.IScannerInput;
import utils.interfaces.IViewer;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
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
                
                1. Registrer svømmers træningstid
                2. Vis top fem
                3. Registrer konkurrencetid
                5. Tilbage
                """);
    }

    public void selection(){
            intInput = intInput();
            switch (intInput) {
                //Registrer svømmers træningstid
                case 1 -> {
                    var fh = new FileHandler();

                    System.out.println("Hvilket medlems træningstid skal registreres?\nSkriv medlems ID:");
                    stringInput = stringInput();
                    String memberId = stringInput;

                    System.out.println("Hvilken disciplin deltog svømmeren i?");
                    System.out.println("Butterfly - skriv 1\nCrawl - skriv 2\nRygcrawl - skriv 3\nBrystsvømning - skriv 4");
                    stringInput = stringInput();
                    String disciplin = stringInput;

                    System.out.println("Hvilken tid havde svømmeren i træning? - skriv tid i SEKUNDER");
                    stringInput = stringInput();
                    String raceTime = stringInput;

                    var dataRecord = new String[]{memberId, disciplin, raceTime};
                    fh.save(dataRecord, "trainingStats.csv",true);
                }
                //Vis top fem pr disciplin
                case 2 -> {
                    var fh = new FileHandler();
                    var dataOutput = fh.load("competitionStats.csv");

                    var butterfly = new ArrayList<String[]>();
                    var crawl = new ArrayList<String[]>();
                    var backCrawl = new ArrayList<String[]>();
                    var breastStroke = new ArrayList<String[]>();

                    for (String[] record : dataOutput) {
                        if (record.length > 1) {
                            if(record[1].equals("1")) {
                                butterfly.add(record);
                            }
                            if(record[1].equals("2")) {
                                crawl.add(record);
                            }
                            if(record[1].equals("3")) {
                                backCrawl.add(record);
                            }
                            if(record[1].equals("4")) {
                                breastStroke.add(record);
                            }
                        }
                    }

                    butterfly.sort(Comparator.comparingInt(a -> Integer.parseInt(a[3])));
                    System.out.println("Butterfly");
                    System.out.println("Medlems ID | Disciplin |  Placering | Konkurrence tid | Turnering");
                    for (int i = 0; i < 5 && i < butterfly.size(); i++) {
                        String[] arr = butterfly.get(i);
                        System.out.println(java.util.Arrays.toString(arr));
                    }
                    System.out.println("\nCrawl");
                    System.out.println("Medlems ID | Disciplin |  Placering | Konkurrence tid | Turnering");
                    crawl.sort(Comparator.comparingInt(a -> Integer.parseInt(a[3])));
                    for (int i = 0; i < 5 && i < crawl.size(); i++) {
                        String[] arr = crawl.get(i);
                        System.out.println(java.util.Arrays.toString(arr));
                    }
                    System.out.println("\nRygcrawl");
                    System.out.println("Medlems ID | Disciplin |  Placering | Konkurrence tid | Turnering");
                    backCrawl.sort(Comparator.comparingInt(a -> Integer.parseInt(a[3])));
                    for (int i = 0; i < 5 && i < backCrawl.size(); i++) {
                        String[] arr = backCrawl.get(i);
                        System.out.println(java.util.Arrays.toString(arr));
                    }
                    System.out.println("\nBrystsvømning");
                    System.out.println("Medlems ID | Disciplin |  Placering | Konkurrence tid | Turnering");
                    breastStroke.sort(Comparator.comparingInt(a -> Integer.parseInt(a[3])));
                    for (int i = 0; i < 5 && i < breastStroke.size(); i++) {
                        String[] arr = breastStroke.get(i);
                        System.out.println(java.util.Arrays.toString(arr));
                    }
                }
                //Registrer konkurrence statistik
                case 3 -> {
                    var fh = new FileHandler();

                    System.out.println("Hvilket medlems konkurrencetid skal registreres?\nSkriv medlems ID:");
                    stringInput = stringInput();
                    String memberId = stringInput;

                    System.out.println("Hvilken disciplin deltog svømmeren i?");
                    System.out.println("Butterfly - skriv 1\nCrawl - skriv 2\nRygcrawl - skriv 3\nBrystsvømning - skriv 4");
                    stringInput = stringInput();
                    String disciplin = stringInput;

                    System.out.println("Hvilken placering fik svømmeren - skriv placering som tal");
                    stringInput = stringInput();
                    String placement = stringInput;

                    System.out.println("Hvilken tid havde svømmeren i konkurrencen? - skriv tid i SEKUNDER");
                    stringInput = stringInput();
                    String raceTime = stringInput;

                    System.out.println("Hvilken turnering deltog svømmeren i?");
                    stringInput = stringInput();
                    String tournamentName = stringInput;

                    var dataRecord = new String[]{memberId, disciplin, placement, raceTime, tournamentName};
                    fh.save(dataRecord, "competitionStats.csv",true);

                }
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
