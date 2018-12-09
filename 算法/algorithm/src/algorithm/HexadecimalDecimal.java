package algorithm;

public class HexadecimalDecimal {
	public static long hexadecimalOctonary(String hexadecimalstr) {
		StringBuilder hexadecimal = new StringBuilder(hexadecimalstr);
		int n = hexadecimal.length();
		long decimalNum = 0;
		for(int i=n-1;i>=0;i-=1) {
			decimalNum = charDecimal(hexadecimal.charAt(i),decimalNum,n-1-i);
		}
		return decimalNum;
	}
	private static final long charDecimal(char c,long h,int n) {
		switch(c) {
		case '0':{
			h+=getHex(n)*0;
			return h;
		}
		case '1':{
			h+=getHex(n)*1;
			return h;
		}
		case '2':{
			h+=getHex(n)*2;
			return h;
		}
		case '3':{
			h+=getHex(n)*3;
			return h;
		}
		case '4':{
			h+=getHex(n)*4;
			return h;
		}
		case '5':{
			h+=getHex(n)*5;
			return h;
		}
		case '6':{
			h+=getHex(n)*6;
			return h;
		}
		case '7':{
			h+=getHex(n)*7;
			return h;
		}
		case '8':{
			h+=getHex(n)*8;
			return h;
		}
		case '9':{
			h+=getHex(n)*9;
			return h;
		}
		case 'A':{
			h+=getHex(n)*10;
			return h;
		}
		case 'B':{
			h+=getHex(n)*11;
			return h;
		}
		case 'C':{
			h+=getHex(n)*12;
			return h;
		}
		case 'D':{
			h+=getHex(n)*13;
			return h;
		}
		case 'E':{
			h+=getHex(n)*14;
			return h;
		}
		case 'F':{
			h+=getHex(n)*15;
			return h;
		}
	}
		return -1;
	}
	private static final long getHex(int n) {
		long result = 1;
		for(int i=0;i<n;i+=1) {
			result *= 16;
		}
		return result;
	}
}
