package NoahArmanProject;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class HighscoreAdmin{

    private Highscore selectedHighscore;
    private ArrayList<Highscore> highscoreList;

    public void submit(String name, String dateTime, String level, Integer finishTime) // gibt Position in entsprechender Liste zurück: "Your rank: 1!" oder "HighScore entries only better than 1354 seconds" wenn die erreichte Zeit grösser als das aktuelle Maximum für das jeweilige Level ist undbereits 10 Einträge existieren.
    {
        this.selectedHighscore = new Highscore(name, dateTime, level, finishTime);
    }

    public void save() //speichert alle HighScores in einer CSV Datei ab.
    {
        this.load();

        try
        {
            PrintWriter writer = new PrintWriter(new File("highscores.csv"));


            for(int i = 0; i < highscoreList.size(); i++)
            {
                writer.append(highscoreList.get(i).toString() + "\n");
            }

            writer.append(this.selectedHighscore.toString());

            writer.close();
        }
        catch (Exception ex)
        {
            System.out.println("Error while reading from highscore file: ");
            ex.printStackTrace();
        }
    }

    public void load() // lädt die HighScores aus der gleichen Datei wie save().
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
            fileScanner.close();
        }
        catch (Exception ex)
        {
            System.out.println("Error while reading from highscore file: ");
            ex.printStackTrace();
        }
    }

    public ArrayList<Highscore> getHighscore(String level) // liefert alle HighScores des entsprechenden Levels sortiert nach benötigter Zeit in einem Array zurück
    {
        var arrayListWithLevel = new ArrayList<Highscore>();

        if(level.equals("")) {
            Collections.sort(highscoreList);
            return highscoreList;
        }

        for (int i = 0; i < highscoreList.size(); i++) {
            if (highscoreList.get(i).getLevel().equals(level))
                arrayListWithLevel.add(highscoreList.get(i));
        }

        Collections.sort(arrayListWithLevel);
        return arrayListWithLevel;
    }


}