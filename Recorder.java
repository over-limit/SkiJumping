import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recorder {

    private List<Player> players;
    private Generator generator;

    public Recorder() {
        players = new ArrayList<Player>();
        generator = new Generator();
    }

    public void addPlayer(String playerName) {
        players.add(new Player(playerName));
    }

    public void sort() {
        Collections.sort(players);
    }

    public void jumpingOrder() {
        this.sort();
        System.out.println("Jumping order:");
        int i = 1;
        for (Player player : players) {
            System.out.print("  " + i + ". ");
            System.out.println(player);
            i++;
        }
        System.out.println("");
    }

    public void jump() {
        for (Player player : players) {
            System.out.println("  " + player.getName());
            int length = generator.generateLength();
            System.out.println("    length: " + length);
            player.addDistance(length);

            List<Integer> votes = generator.generateVotes();
            System.out.println("    judge votes: " + votes);
            player.addPoints(processScore(length, votes));
        }
        System.out.println("");
    }

    private int processScore(int length, List<Integer> votes) {
        int total = length;
        votes.remove(Collections.max(votes));
        votes.remove(Collections.min(votes));
        for (Integer i : votes) {
            total += i;
        }
        return total;
    }

    public void results() {
        sort();
        Collections.reverse(players);
        System.out.println("Tournament results:");
        System.out.println("Position    Name");
        int i = 1;
        for (Player player : players) {
            System.out.println(i + "           " + player);
            player.printJumpLengths();
            i++;
        }
    }

}