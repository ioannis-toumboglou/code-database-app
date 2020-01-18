import java.util.Scanner;

public class PrimeNumber {
	
	public static String isPrime(int number) {
		if (number == 0 || number == 1)
			return "Not prime";
		
		for (int i=2; i*i<=number; i++) {
	        if(number%i==0) {
	            return "Not prime";
	        }
	    }
	    return "Prime";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Please enter a number: ");
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		System.out.println("Your number is: " + isPrime(number));
		scan.close();
	}

}
