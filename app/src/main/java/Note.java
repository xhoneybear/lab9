import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Note {
    public final String ID = hashID();
    private String title;
    private String content;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Note(Scanner scanner) {
        System.out.print("Title: ");
        this.title = scanner.nextLine();
        System.out.println("Content (END finishes input):");
        String line;
        while (!(line = scanner.nextLine()).equals("END")) {
            this.content += line + "\n";
        }
        System.out.println("Successfully added note (ID: %s)".formatted(this.ID));
    }

    private String hashID() {
        try {
            Date date = new Date();
            Random random = new Random();
            MessageDigest md = MessageDigest.getInstance("MD5");
            String hash = date.toString() + random.nextInt();
            System.out.println(hash);
            md.update(hash.getBytes());
            byte[] digest = md.digest();
            hash = String.format("%032x", new java.math.BigInteger(1, digest));
            System.out.println("New note (ID: %s)".formatted(hash));
            return hash;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "ID: %s\nTitle: %s\nContent: %s".formatted(this.ID, this.title, this.content);
    }
}