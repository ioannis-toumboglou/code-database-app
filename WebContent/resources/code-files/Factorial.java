import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Factorial {
	
	public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //write your code here
    	BigInteger result = new BigInteger("1");
    	
    	if(n < 0) {
    		result = new BigInteger("0");
    		return String.valueOf(result);
    	} else if(n == 0) {
    		return String.valueOf(result);
    	}
    	
    	for (int i = 2; i <= n; i++) 
    		result = result.multiply(BigInteger.valueOf(i)); 
    	
        return String.valueOf(result);
    }
    
}
