/**
 *
 * @author rutherford
 */
public class Prime
{

    /**
     * Private class variables
     */
    private int input, output;

    /**
     * Parameterized constructor
     *
     * @param number number to count for prime
     */
    public Prime(int number)
    {
        this.input = number;
        this.output = 0;
    }

    /**
     * Perform the prime count
     */
    public void countPrimes()
    {
        for (int i = 0; i <= input; i++)
        {
            if (isPrime(i))
            {
                output++;
            }
        }
    }

    /**
     * Gets the calculated prime output
     *
     * @return count of prime numbers found in input variable
     */
    public int getPrimeCount()
    {
        return output;
    }

    /**
     * Tests if the input value is a prime or not
     *
     * @param input number to test
     * @return true if prime, false otherwise
     */
    private boolean isPrime(int input)
    {
        if (input % 2 == 0 && input != 2)
        {
            return false;
        }
        else
        {
            if (input == 1)
            {
                return false;
            }
            for (int p = 3; p <= input / 2; p += 2)
            {
                if (input % p == 0)
                {
                    return false;
                }
            }
            return true;
        }
    }
}
