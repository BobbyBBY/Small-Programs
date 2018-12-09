package algorithm;

public class FindInteger {
	private static int findInteger(int[] all,int num) {
		for(int i =0 ;i < all.length ;i ++) {
			if(all[i]==num) {
				return i+1;
			}
		}
		return -1;
	}
}
