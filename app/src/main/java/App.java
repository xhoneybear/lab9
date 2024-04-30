import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static ArrayList<Note> notes = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String opt;
            while (true) {
                System.out.println("1. Add new note");
                System.out.println("0. Exit");
                opt = scanner.nextLine();
                switch (opt) {
                    case "1" -> notes.add(new Note(scanner));
                    case "0" -> System.exit(0);
                    default -> System.out.println("Invalid option");
                }
            }
        }
    }
}
