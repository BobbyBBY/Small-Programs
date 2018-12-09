package algorithm;

public class Leapyear {
	public static void leapyear(int n) {
		if(((n%4==0)&&(n%100!=0))||(n%400==0)) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
	}
}
