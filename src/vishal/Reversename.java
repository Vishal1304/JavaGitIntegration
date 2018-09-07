package vishal;

public class Reversename {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String name="MOMe",reverse="";

int length=name.length();
for(int i=length-1;i>=0;i--) {
	
	reverse=reverse+name.charAt(i);
}
System.out.println(reverse);

if(reverse.equalsIgnoreCase(name)) {
	System.out.println("Palindrome program created");
}
else
	System.out.println("Not a palindrome word");
	}

}
