import java.util.Scanner;

public class CaesarCipher 
{ 
    // Encrypts text using a shift od s 
    public static StringBuffer encrypt(String text, int s) {
        StringBuffer result= new StringBuffer();
  
        for(int i=0; i<text.length(); i++) {
            if(Character.isUpperCase(text.charAt(i))) {
                char ch = (char)(((int)text.charAt(i) + s - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char)(((int)text.charAt(i) + s - 97) % 26 + 97);
                result.append(ch); 
            }
        }
        return result; 
    } 
    
    public static StringBuffer decrypt(StringBuffer text, int s) {
    	StringBuffer result= new StringBuffer();
    	  
        for(int i=0; i<text.length(); i++) {
            if(Character.isUpperCase(text.charAt(i))) {
                char ch = (char)(((int)text.charAt(i) - s - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char)(((int)text.charAt(i) - s - 97) % 26 + 97);
                result.append(ch); 
            }
        }
        return result;
    }
  
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Text  : ");
    	String text = sc.nextLine();
    	System.out.print("Shift : "); 
        int s = sc.nextInt();
        StringBuffer encryptedText = encrypt(text, s);
        System.out.println("Cipher: " + encryptedText);
        StringBuffer decryptedText = decrypt(encryptedText, s);
        System.out.println("Decipher: " + decryptedText);
        sc.close();
    } 
} 