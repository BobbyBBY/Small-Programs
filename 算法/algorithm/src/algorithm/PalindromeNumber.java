package algorithm;

public class PalindromeNumber {
	public static void palindromeNumber() {//���˹���,����λ��////����ֻ��4λ
		int[] result = new int[90];
		for(int i=1;i<10;i++) {
			for(int j=0;j<10;j++) {
				result[(i-1)*10+j]=i*1000+j*100+j*10+i;
			}
		}
		for(int i=0;i<90;i++) {
			System.out.println(result[i]);
		}
	}
}
