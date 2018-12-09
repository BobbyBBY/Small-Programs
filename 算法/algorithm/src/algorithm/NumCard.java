package algorithm;

public class NumCard {
	public int[] fun(int[] a) {
		int totalNum=a.length;
		int remainNum=totalNum;
		int first=0;
		int nowNum=remainNum/2+remainNum%2;
		int nowCount = 0;
		int[] result = new int[totalNum];
		while(remainNum!=0) {
			int[] temp =new int[nowNum];
			for(int i=0;i<nowNum;i++) {
//				temp[i]=
			}
		}
return null;
	}
	private int[] sum(int[] a,int[] b,int n) {
		for(int i= a.length-n,j=0;i<b.length;i++,j++) {
			a[i] = b[j];
		}
		return a;
	}
	
	
}
