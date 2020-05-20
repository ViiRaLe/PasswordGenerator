import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MainClass
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);

        String s = "N";

        do {
            System.out.println("Insert password length (min. 6), Include Uppercase letters, Include Lowercase letter, Include Numbers, Include Symbols (at least one active).");

            UserSettings set = new UserSettings(kb.nextInt(), kb.nextBoolean(), kb.nextBoolean(), kb.nextBoolean(), kb.nextBoolean());
            PasswordGenerator pg = new PasswordGenerator(set);

            System.out.println("Version " + pg.getVersion());

            try
            {
                System.out.println(pg.generatePassword());
            } catch (NoSuchAlgorithmException e)
            {
                return;
            }

            kb.nextLine();
            System.out.println("Want to generate another one? Y / N");
            s = kb.nextLine();

        } while (s.equalsIgnoreCase("Y"));
    }
}
