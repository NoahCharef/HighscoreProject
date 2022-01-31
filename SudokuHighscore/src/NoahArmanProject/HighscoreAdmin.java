package NoahArmanProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class HighscoreAdmin{

    private Highscore selectedHighscore;
    private ArrayList<Highscore> highscoreList;

    public void submit(String name, String dateTime, String level, Integer finishTime)
    {
        this.selectedHighscore = new Highscore(name, dateTime, level, finishTime);
    }

    public void save()
    {
        try
        {
            PrintWriter writer = new PrintWriter(new File("highscores.csv"));

            writer.append(this.selectedHighscore.toString());

            writer.close();
        }
        catch (Exception ex)
        {
            System.out.println("Error while reading from highscore file: ");
            ex.printStackTrace();
        }
    }

    public void load()
    {
        this.highscoreList = new ArrayList<Highscore>();


        try {
            Scanner fileScanner = new Scanner(new File("highscores.csv"));
            while (fileScanner.hasNextLine()) {
                String[] content = fileScanner.nextLine().split(",");

                if (content.length != 4) {
                    System.out.println("Invalid line.");
                    continue;
                }

                String name = content[0];
                String dateTime = content[1];
                String level = content[2];
                Integer finishTime = Integer.parseInt(content[3]);

                this.highscoreList.add(new Highscore(name, dateTime, level, finishTime));
            }
        }
        catch (Exception ex)
        {
            System.out.println("Error while reading from highscore file: ");
            ex.printStackTrace();
        }
    }

    public ArrayList<Highscore> getHighscore(String level)
    {
        if(this.highscoreList != null)
        {
            return this.highscoreList;
        }
        return new ArrayList<Highscore>();
    }


}