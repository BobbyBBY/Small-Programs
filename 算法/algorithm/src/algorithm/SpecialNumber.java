package algorithm;

import java.util.ArrayList;

public class SpecialNumber {
	public static void specialNumberInit() {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int[] L = new int[10];
		for(int i = 0;i<10;i++) {
			L[i] = i*i*i;
		}
		for(int i = 0 ;i < 10 ;i ++) {
			for(int j = 0 ;j < 10 ;j++) {
				for(int k = 0 ;k < 10 ;k ++) {
					if((i*100+j*10+k)==(L[i]+L[j]+L[k])) {
						result.add((i*100+j*10+k));
					}
				}
			}
		}
		for(int i=0;i<result.size();i++) {
			System.out.println(result.get(i));
		}
		
	}
}
