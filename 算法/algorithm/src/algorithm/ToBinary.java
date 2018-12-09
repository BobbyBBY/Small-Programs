package algorithm;

public class ToBinary {
	public static void toBinary(int n) {
		for(int i = 0 ;i <= n ;i ++) {
			String a = String.valueOf(Integer.toBinaryString(i));
			int x = a.length();
			switch(x) {
			case 1:{
				System.out.println("0000"+a);
				break;
			}
			case 2:{
				System.out.println("000"+a);
				break;
			}
			case 3:{
				System.out.println("00"+a);
				break;
			}
			case 4:{
				System.out.println("0"+a);
				break;
			}
			case 5:{
				System.out.println(a);
				break;
			}
			}
		}
		
	}
}
