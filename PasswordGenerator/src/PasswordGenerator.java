import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class PasswordGenerator
{
    private UserSettings settings;
    private String version = "0.1a";
    private String[] charList;

    public PasswordGenerator(UserSettings settings)
    {
        if (settings == null) this.settings = new UserSettings();
        else this.settings = settings;

        charList = new String[] { "0123456789", "abcdefghijklmnopqrstuvwxyz", "ABCDEFGHIJKLMNOPQRSTUVWXYZ", "!\"£$%&/()=?^'" };
    }

    public PasswordGenerator()
    {
        this(new UserSettings());
    }

    public String getVersion()
    {
        return version;
    }

    private String[] buildCharPool()
    {
        String[] pool;

        int count = 0;
        if (settings.isIncludeUppercaseLetters()) count++;
        if (settings.isIncludeLowercaseLetters()) count++;
        if (settings.isIncludeNumbers()) count++;
        if (settings.isIncludeSymbols()) count++;

        pool = new String[count];

        count--;

        if (settings.isIncludeUppercaseLetters()) { pool[count] = charList[2]; count--; }
        if (settings.isIncludeLowercaseLetters()) { pool[count] = charList[1]; count--; }
        if (settings.isIncludeNumbers()) { pool[count] = charList[0]; count--; }
        if (settings.isIncludeSymbols()) { pool[count] = charList[3]; count--; }

        return pool;
    }

    public String generatePassword() throws NoSuchAlgorithmException
    {
        int length = settings.getPasswordLength();
        Random random = SecureRandom.getInstanceStrong();
        StringBuilder sb = new StringBuilder(length);

        String[] usableCharPool = buildCharPool();

        int range = usableCharPool.length;

        for (int i = 0; i < length; i++)
        {
            int poolIndex = random.nextInt(range);
            int charIndex = random.nextInt(usableCharPool[poolIndex].length());
            sb.append(usableCharPool[poolIndex].charAt(charIndex));
        }

        return sb.toString();
    }
}
