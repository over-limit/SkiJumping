import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {

    public int generateLength() {
        return (new Random().nextInt(61)) + 60;
    }

    public List<Integer> generateVotes() {
        Random randomizer = new Random();
        List<Integer> votes = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            votes.add(randomizer.nextInt(11) + 10);
        }
        return votes;
    }
}