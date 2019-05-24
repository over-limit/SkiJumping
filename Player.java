import java.util.ArrayList;
import java.util.List;

public class Player implements Comparable<Player> {

    private String name;
    private int points;
    private List<Integer> distances;

    public Player(String name) {
        this.name = name;
        this.distances = new ArrayList<Integer>();
        this.points = 0;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public void addDistance(int distance) {
        distances.add(distance);
    }

    public int getPoints() {
        return points;
    }

    public List<Integer> getDistances() {
        return new ArrayList<Integer>(distances);
    }

    public String getName() {
        return name;
    }

    public void printJumpLengths() {
        System.out.print("            jump lengths: ");
        String length = "";
        for (int i = 0; i < distances.size(); i++) {
            length += distances.get(i) + " m";
            if (i != distances.size() - 1) {
                length += ", ";
            }
        }

        System.out.println(length);
    }

    @Override
    public String toString() {
        // Mikael (388 points)
        return name + " (" + points + " points)";
    }

    @Override
    public int compareTo(Player o) {
        return this.points - o.points;
    }

}