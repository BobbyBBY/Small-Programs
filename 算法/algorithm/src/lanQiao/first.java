package lanQiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class first {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		sc.nextLine();
//		String[] numstr = new String[n];
//		for(int i= 0;i<n;i++) {
//			numstr[i]=sc.nextLine();
//		}
//		fun(fun2(numstr));
//	}
	
	public static Object[] fun2(String[] str) {
		ArrayList<String> numstr = new ArrayList<String>();
		for(int i = 0;i<str.length;i++) {
			String[] temp = str[i].trim().split(" ");
			for(int j = 0 ;j<temp.length;j++) {
				numstr.add(temp[j]);
			}
		}
		ArrayList<Integer> num = new ArrayList<Integer>();
		int n = numstr.size();
		for(int i = 0;i<n;i++) {
			num.add(Integer.valueOf(numstr.get(i)));
		}
		return num.toArray();
	}
	
	public static void fun(Object[] num) {
		int D = 0;
		int C = 0;
		boolean a = false;
		boolean b = false;
		Arrays.sort(num);
		for(int i = 0 ;i<num.length-1;i++) {
			if(!a&&(int)num[i]==(int)num[i+1]) {
				C = (int)num[i];
				a = true;
			}
			else if (!b&&(int)num[i+1]!=((int)num[i]+1)) {
				D = (int)num[i]+1;
				b = true;
			}
		}
		System.out.println(D + " " + C);
		
	}

}
