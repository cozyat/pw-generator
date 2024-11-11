import java.util.*;

public class passwordGenerator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] phrase = input.nextLine().trim().toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();

        // example list contents: [I, like, pizza]
        for (int i = 0; i < phrase.length; i++) {
            for (int j = 0; j < phrase[i].length(); j++) {
                sb.append(phrase[i].charAt(j));
            }
        }

        String basePassword = sb.toString();
        int rand = (int) (Math.random() * basePassword.length());
        char modifiedChar = basePassword.charAt(rand);

        if (Character.isLowerCase(modifiedChar)) {
            modifiedChar = Character.toUpperCase(modifiedChar);
        } else {
            modifiedChar = Character.toLowerCase(modifiedChar);
        }
        StringBuilder modifiedPassword = new StringBuilder(basePassword);
        modifiedPassword.setCharAt(rand, modifiedChar);
        basePassword = modifiedPassword.toString();

        StringBuilder complexPassword = new StringBuilder(basePassword);

        System.out.print("Enter your favorite character: ");
        char favCharacter = input.next().charAt(0);
        complexPassword.insert(rand, favCharacter);

        System.out.println("Generated secure password: " + complexPassword.toString());
        input.close();
    }
}
