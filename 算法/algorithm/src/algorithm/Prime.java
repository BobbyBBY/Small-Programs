package algorithm;

import java.util.Vector;

public class Prime {
	public static int isPrime4(int n) {
		if(n==1){
			return -1;//不是质数
		}
		else if(n==2) {
			return 1;
		}
		int count = 1;
		int temp = 3;
		Vector v = new Vector();
		 v.addElement(new Integer(2));
		while(temp<=n) {
			for(int i = 0;i < count; i ++) {
				if(temp%(int)v.get(i)==0) {
					return -1;//不是质数
				}
			}
			v.addElement(new Integer(temp));
			count+=1;
		}
		 return count;
	}
	
	
	
	
}
