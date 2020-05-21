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

            int len = kb.nextInt();
            String upper = kb.next();
            String lower = kb.next();
            String numb = kb.next();
            String symb = kb.next();

            boolean up = false;
            boolean low = false;
            boolean n = false;
            boolean sy = false;

            if (checkSpelling(upper)) up = true;
            if (checkSpelling(lower)) low = true;
            if (checkSpelling(numb)) n = true;
            if (checkSpelling(symb)) sy = true;

            UserSettings set = new UserSettings(len, up, low, n, sy);
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
            System.out.println("Want to generate another password? Y / N");
            s = kb.nextLine();

        } while (s.equalsIgnoreCase("Y"));
    }

    private static boolean checkSpelling(String s)
    {
        if (s.equals("1") || s.equalsIgnoreCase("true") || s.equalsIgnoreCase("t") || s.equalsIgnoreCase("y") || s.equalsIgnoreCase("yes")) return true;

        return false;
    }
}
