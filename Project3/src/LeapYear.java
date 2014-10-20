/**
 *
 * @author rutherford
 */
public class LeapYear
{

    /**
     * Private class variables
     */
    private int input, output;

    /**
     * Parameterized constructor, it takes a year value
     *
     * @param year input year
     */
    public LeapYear(int year)
    {
        this.input = year;
        this.output = 0;
    }

    /**
     * Method that checks if the input year is a leap year or not
     *
     * @return true if it is a leap year, false otherwise
     */
    public boolean isLeapYear()
    {
        int isdivisible = input % 4;
        switch (isdivisible)
        {
            case 0:
                isdivisible = input % 100;
                if (isdivisible == 0)
                {
                    isdivisible = input % 400;
                    if (isdivisible == 0)
                    {
                        output = input;
                        return true;
                    }
                    return false;
                }
                output = input;
                return true;
            default:
                return false;
        }
    }

    /**
     * Test if the year is a leap year or not
     */
    public void testLeapYear()
    {
        if (isLeapYear())
        {
            output = input;
        }
    }
} // End of class
