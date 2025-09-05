package template_method;

public class CatPlayer {
    private String name;
    private int score;

    // Constructor: set the name and initialize score to 0
    public CatPlayer(String name) {
        this.name = name;
        this.score = 0;
    }

    public void addPoints(int points) {
        this.score += points;
    }


    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}
