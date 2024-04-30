import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static ArrayList<Note> notes = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String opt;
            while (true) {
                System.out.println("1. Add new note");
                System.out.println("2. View all notes");
                System.out.println("3. View note");
                System.out.println("4. Delete note");
                System.out.println("0. Exit");
                opt = scanner.nextLine();
                switch (opt) {
                    case "1" -> notes.add(new Note(scanner));
                    case "2" -> {
                        if (notes.isEmpty()) {
                            System.out.println("No notes found");
                        } else {
                            for (Note note : notes) {
                                System.out.println(note);
                            }
                        }
                    }
                    case "3" -> {
                        boolean found = false;
                        System.out.println("Enter note ID");
                        opt = scanner.nextLine();
                        for (Note note : notes) {
                            if (note.ID.equals(opt)) {
                                found = true;
                                System.out.println(note);
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Note not found");
                        }
                    }
                    case "4" -> {
                        System.out.println("Enter note ID");
                        final String id = scanner.nextLine();
                        boolean found = notes.removeIf(note -> note.ID.equals(id));
                        if (found) {
                            System.out.println("Note deleted");
                        } else {
                            System.out.println("Note not found");
                        }
                    }
                    case "0" -> System.exit(0);
                    default -> System.out.println("Invalid option");
                }
            }
        }
    }
}
