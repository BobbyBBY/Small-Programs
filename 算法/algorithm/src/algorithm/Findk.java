package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Findk {
 
	public static int findk(List<Integer> p,int k,int left,int right) {
		int i=left;
		int j=right;
		while(i<j) {
			while(i<j&&p.get(j)>p.get(left)) {
				j--;
			}
			while(i<j&&p.get(i)<=p.get(left)) {
				i++;
			}
			if(i<j) {
				int temp=p.get(i);
				p.set(i, p.get(j));
				p.set(j, temp);
			}
			else if(i==j) {
				int temp=p.get(left);
				p.set(left, p.get(j));
				p.set(j, temp);
			}
		}
		int m=i;
		if(k==(m+1)) {
			return p.get(m);
		}
		else if(k>(m+1)) {
			return findk(p,k,m+1,right);
		}
		else if(k<(m+1)) {
			return findk(p,k,left,m-1);
		}
		
		
		return 0;
	}
//	public static void main(String[] args) {
//		// TODO 自动生成的方法存根
//		List<Integer> array=new ArrayList<Integer>();
//		array.add(8);
//		array.add(3);
//		array.add(9);
//		array.add(0);
//		array.add(6);
//		
//		array.add(2);
//		array.add(5);
//		array.add(7);
//		array.add(4);
//		array.add(1);
//		array.add(11);
//		System.out.println(findk(array,10,0,10));
//		
//	}

}
