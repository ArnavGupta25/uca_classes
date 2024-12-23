import java.util.*;

class BadRequestException extends Exception {
    public BadRequestException(String message) {
        super(message);
    }
}

class BadRequest {
    public static List<Integer> superPrimes(String num) 
    {
        try{
            if (num == null) {
                throw new IllegalArgumentException("Input cannot be null");
            }
            if(!onlyDigits(num)){
                throw new BadRequestException("Contains non-digit characters");
            }
            int n=Integer.parseInt(num);
            if(n>1000){
                throw new BadRequestException("Number should be less than equal to 1000");
            }
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
        catch(BadRequestException e){
            System.out.println("BadRequestException " + e.getMessage());
        }
        catch(IllegalArgumentException e){
            System.out.println("IllegalArgumentException " + e.getMessage());
        }

        return null;

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

    private static boolean onlyDigits(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws Exception 
    {
        System.out.println(superPrimes(null));
        System.out.println(superPrimes("100"));
        System.out.println(superPrimes("1001"));
        System.out.println(superPrimes("100abc"));

    }    
        
}
