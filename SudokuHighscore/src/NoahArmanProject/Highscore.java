package NoahArmanProject;

public class Highscore implements Comparable<Highscore> {

    Highscore(String name, String dateTime, String level, Integer finishTime) // gibt Position in entsprechender Liste zurück: "Your rank: 1!" oder "HighScore entries only better than 1354 seconds" wenn die erreichte Zeit grösser als das aktuelle Maximum für das jeweilige Level ist undbereits 10 Einträge existieren.
    {
        this.name = name;
        this.dateTime = dateTime;
        this.level = level;
        this.finishTime = finishTime;
    }

    private String name;
    private String dateTime;
    private String level;
    private Integer finishTime;

    @Override
    public String toString()
    {
        return name + "," + dateTime + "," + level + "," + finishTime;
    }

    @Override
    public int compareTo(Highscore o) {
        return Integer.compare(this.finishTime, o.finishTime);
    }

    public String getLevel() {
        return level;
    }
}
