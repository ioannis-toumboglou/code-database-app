
public class ReverseNumber {

	public static void main(String[] args) {
		System.out.println(reverse(213));
	}
	
	public static int reverse(int number) {
		int reverse = 0;
		
		while (number != 0) {
			reverse *= 10;
			reverse = reverse + number%10;
			number /= 10;
	    }	
		return reverse;
	}
	
}