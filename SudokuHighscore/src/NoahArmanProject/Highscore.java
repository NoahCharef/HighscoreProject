package NoahArmanProject;

public class Highscore {

    Highscore(String name, String dateTime, String level, Integer finishTime)
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
}
