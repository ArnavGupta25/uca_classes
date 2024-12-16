// return all super primes between 2<=x<=n
// super prime x is  super prime number if x is a prime number and x/10 is a prime number
//in output add single digit prime numbers also dont check them for super prime

import java.util.*;

public class Superprimes 
{
    public static List<Integer> superPrimes(String num) 
    {
        int n=Integer.parseInt(num);
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i <= n; i++) 
        {
            if (isPrime(i)) 
            {
                if(i<10)
                {
                    result.add(i);
                }
                else if(isPrime(i/10))
                {
                    result.add(i);
                }
            }
        }
        return result;
    }

    private static boolean isPrime(int n) 
    {
        if (n < 2) 
        {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) 
        {
            if (n % i == 0) 
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) 
    {
        System.out.println(superPrimes("100"));
    }
}
