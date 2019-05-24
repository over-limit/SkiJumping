import java.util.Scanner;

public class UserInterface {

    private Scanner reader;
    private Recorder recorder;

    public UserInterface(Scanner reader) {
        this.reader = reader;
        recorder = new Recorder();
    }

    public void start() {
        entry();
        jumpingPhase();
        end();
    }

    public void entry() {
        System.out.println("Kumpula ski jumping week\n");
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        while (true) {
            System.out.print("  Participant name: ");
            String name = reader.nextLine();
            if (name.isEmpty()) {
                break;
            }
            recorder.addPlayer(name);
        }
        System.out.println("");
    }

    public void jumpingPhase() {
        System.out.println("The tournament begins!\n");

        int round = 1;
        while (true) {
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            String jump = reader.nextLine();
            if (!jump.equals("jump")) {
                break;
            }
            System.out.println("");
            System.out.println("Round " + round);
            System.out.println("");
            recorder.jumpingOrder();
            System.out.println("Results of round " + round);
            recorder.jump();
            round++;
        }
        System.out.println("");
    }

    public void end() {
        System.out.println("Thanks!\n");
        recorder.results();
    }
}