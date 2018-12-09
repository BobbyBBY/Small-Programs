package algorithm;

import java.util.Scanner;

public class MinimumPoles {

	private static int polesNum=0;
	private static int a[]=null;//灯开关
	private static float b[]=null;//灯覆盖范围
	private static int c[]=null;//当前可行灯记录
	private static float polesLength=0;
	private static int lightOn;
	
//	public static void main(String[] args) {
//		@SuppressWarnings("resource")
//		Scanner sc = new Scanner(System.in);
//		polesNum = sc.nextInt();
//		a=new int[polesNum];
//		b=new float[polesNum];
//		polesLength = sc.nextFloat();
//		for(int i=0;i<polesNum;i++) {
//			b[i]=sc.nextFloat();
//		}
//		for(int i=0;i<polesNum;i++) {
//			a[i]=0;
//		}
//		lightOn=polesNum;
//		
//		traceback(0);
//
//		if(c==null) {
//			System.out.println("INSUFFICIENT LAMPS");
//		}
//		else {
//			System.out.println(lightOn);
//			int k=0;
//			for(int i=0;i<polesNum;i++) {
//				if(c[i]==1) {
//					if(k!=0) {
//						System.out.print(" ");
//					}
//					k++;
//					System.out.print(i+1);
//				}
//			}
//			System.out.println("");
//			k=0;
//			for(int i=0;i<polesNum;i++) {
//				if(c[i]==0) {
//					if(k!=0) {
//						System.out.print(" ");
//					}
//					k++;
//					System.out.print(i+1);
//				}
//			}
//		}
//		
//	}
	
	public static void traceback(int i) {
		if(i>=polesNum)
			return;
		a[i]=0;
		judge(i);
		traceback(i+1);
		a[i]=1;
		judge(i);
		traceback(i+1);
		a[i]=0;//保险
	}
	
	public static int judge(int i) {
		float p[][]=new float[polesNum][2];
		for(int j=0;j<polesNum;j++) {
			if(a[j]==1) {
				p[j][0]=j*polesLength-b[j]/(float)2;
				p[j][1]=j*polesLength+b[j]/(float)2;
			}
		}
		int j=0;
		while(j<polesNum&&a[j]!=1) {
			j++;
		}
		if(j>=polesNum)
			return 0;
		for(int k=j;k<polesNum;k++) {
			if(a[k]==1) {
				if(p[j][1]>p[k][0]) {
					if(p[j][1]<p[k][1]) {
						p[j][1]=p[k][1];
					}
					if(p[j][0]>p[k][0]) {
						p[j][0]=p[k][0];
					}
				}
			}
			
		}
		if(p[j][0]<=0&&p[j][1]>=((polesNum-1)*polesLength)) {
			int lightOnTemp=0;
			for(int k=0;k<polesNum;k++) {
				if(a[k]==1) {
					lightOnTemp++;
				}
			}
			if(lightOnTemp<lightOn) {
				c=new int[polesNum];
				for(int k=0;k<polesNum;k++) {
					c[k]=a[k];
				}
				lightOn=lightOnTemp;
			}
			return 1;
		}
		return 0;
	}
}
