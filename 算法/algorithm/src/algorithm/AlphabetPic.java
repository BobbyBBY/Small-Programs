package algorithm;

public class AlphabetPic {
	public static void alphabetPic(int p,int q) {
		String a = "ZYXWVUTSRQPONMLKJIHGFEDCBABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i=0;i<p;i++) {
			System.out.println(a.substring(25-i, 25-i+q));
		}
	}
	
}
