package algorithm;

public class DecimalHexadecimal {
	private static final String decimalHexadecimalChar(int s) {
		switch(s) {
		case 0:{
			return "0";
		}
		case 1:{
			return "1";
		}
		case 2:{
			return "2";
		}
		case 3:{
			return "3";
		}
		case 4:{
			return "4";
		}
		case 5:{
			return "5";
		}
		case 6:{
			return "6";
		}
		case 7:{
			return "7";
		}
		case 8:{
			return "8";
		}
		case 9:{
			return "9";
		}
		case 10:{
			return "A";
		}
		case 11:{
			return "B";
		}
		case 12:{
			return "C";
		}
		case 13:{
			return "D";
		}
		case 14:{
			return "E";
		}
		case 15:{
			return "F";
		}
		}
		return null;
	}

	public static String decimalHexadecimal(long decimal) {
		long tempRemain = decimal;
		long tempDecimal = 0;
		StringBuilder hexadecimal = new StringBuilder();
		while(tempRemain>=16) {
			tempDecimal = tempRemain%16;
			hexadecimal.append(decimalHexadecimalChar((int)tempDecimal));
			tempRemain /= 16;
		}
		hexadecimal.append(decimalHexadecimalChar((int)tempDecimal));
		return hexadecimal.toString();
	}
	
	
	
	
	
	
}
