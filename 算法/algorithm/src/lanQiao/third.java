package lanQiao;

public class third {
	public static void fun(int n) {
		int temp = n;
		int sum = 0;
		while(n!=0) {
			sum += n;
			n = temp/3;
			temp = temp/3+temp%3;
		}
		System.out.println(sum);
	}
}
