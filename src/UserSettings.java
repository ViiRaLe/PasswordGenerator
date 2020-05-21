import java.util.Random;

public class UserSettings
{
    private int passwordLength;
    private boolean includeUppercaseLetters;
    private boolean includeLowercaseLetters;
    private boolean includeNumbers;
    private boolean includeSymbols;

    public UserSettings(int passwordLength, boolean includeUppercaseLetters, boolean includeLowercaseLetters, boolean includeNumbers, boolean includeSymbols)
    {
        if (passwordLength < 6) { System.out.println("Minimum length is 6. Automatically setted."); this.passwordLength = 6; }
        else this.passwordLength = passwordLength;

        if (!includeUppercaseLetters && !includeLowercaseLetters && !includeNumbers && !includeSymbols)
        {
            System.out.println("You need to abilitate at least one option! Auto-abilitating a random one.");
            Random rand = new Random();
            switch (rand.nextInt(4))
            {
                case 0:
                    includeUppercaseLetters = true;
                    break;
                case 1:
                    includeLowercaseLetters = true;
                    break;
                case 2:
                    includeNumbers = true;
                    break;
                case 3:
                    includeSymbols = true;
                    break;

                default:
                    break;
            }
        }

        this.includeUppercaseLetters = includeUppercaseLetters;
        this.includeLowercaseLetters = includeLowercaseLetters;
        this.includeNumbers = includeNumbers;
        this.includeSymbols = includeSymbols;
    }

    public UserSettings()
    {
        this(16, true, true, true, true);
    }

    public int getPasswordLength() {
        return passwordLength;
    }

    public boolean isIncludeUppercaseLetters() {
        return includeUppercaseLetters;
    }

    public boolean isIncludeLowercaseLetters() {
        return includeLowercaseLetters;
    }

    public boolean isIncludeNumbers() {
        return includeNumbers;
    }

    public boolean isIncludeSymbols() {
        return includeSymbols;
    }
}
