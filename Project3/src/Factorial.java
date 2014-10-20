/**
 *
 * @author rutherford
 */
public class Factorial
{

    /**
     * Variables for private usage
     */
    private int input, output;

    /**
     * Factorial class constructor
     */
    public Factorial()
    {
        this.input = 0;
        this.output = 0;
    }

    /**
     * Parameterized constructor takes in a number of type integer
     *
     * @param number number to process as input
     */
    public Factorial(int number)
    {
        this();
        this.input = number;
    }

    /**
     * Method to calculate the factorial result
     */
    public void calculateFactorial()
    {
        // Call recursive function to do the calculation
        output = calculateFactorial(input);
    }

    /**
     * Method to calculate the factorial result with parameters
     *
     * @param input number to calculate
     * @return return calculated factorial
     */
    public int calculateFactorial(int input)
    {
        if (input < 1)
        {
            return 1;
        }
        else
        {
            return input * calculateFactorial(--input);
        }
    }

    /**
     * Returns the output for the class
     *
     * @return calculated factorial
     */
    public int getFactorial()
    {
        return output;
    }
} // End of class
