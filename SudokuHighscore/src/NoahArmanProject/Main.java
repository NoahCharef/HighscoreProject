package NoahArmanProject;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static HighscoreAdmin admin = new HighscoreAdmin();

    public static void main(String[] args)
    {
        String input = "";
        boolean isTrue = true;

        while(isTrue)
        {
            System.out.println();
            System.out.println("Add new Highscore: a");
            System.out.println("Get Highscores: g");
            System.out.println("Exit: e");

            Scanner sc = new Scanner(System.in);
            input = sc.nextLine();

            switch (input)
            {
                case "a":
                    addHighscore();
                    break;
                case "g":
                    var highscores = getHighscore();
                    for (Highscore highscore : highscores) {
                        System.out.println(highscore);
                    }
                    break;
                case "e":
                    isTrue = false;
                    break;
                default:
                    System.out.println("Invalid input");
            }

        }
    }

    private static ArrayList<Highscore> getHighscore() {
        System.out.println("Input a level if needed: ");

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        admin.load();

        return admin.getHighscore(input);
    }

    public static void addHighscore() {
        try {
            System.out.println("name: ");
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();

            System.out.println("date: ");
            Scanner sc2 = new Scanner(System.in);
            String date = sc2.nextLine();

            System.out.println("level: ");
            Scanner sc3 = new Scanner(System.in);
            String level = sc3.nextLine();

            System.out.println("finish time: ");
            Scanner sc4 = new Scanner(System.in);
            int time = Integer.parseInt(sc4.nextLine());

            admin.submit(name, date, level, time);

            admin.save();
        }
        catch (Exception ex)
        {
            System.out.println("Invalid input");
        }
    }
}
