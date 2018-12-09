package algorithm;

import java.util.Scanner;

public class HexadecimalOctonary {
	public static void hexadecimalOctonaryinit() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] num = new String[n];
		for(int i=0;i<n;i++) {
			num[i]=sc.next();
		}
//		int n=2;
//		String[] num = {"39","123ab34655437475adfdc"};
//		
		
		
		for(int i=0;i<n;i++) {
			System.out.println(hexadecimalOctonary(num[i]));
		}
	}
	
	
	
	public static String hexadecimalOctonary(String hexadecimalstr) {
		StringBuilder hexadecimal = new StringBuilder(hexadecimalstr);
		int n = hexadecimal.length();
		hexadecimal=hexadecimalBinary(hexadecimal,n);
		StringBuilder octonary = new StringBuilder();
		int n2 = hexadecimal.length();
		for(int i=0;i<n2;i+=3) {
			octonary.append(binaryOctonary(hexadecimal.substring(i,i+3)));
		}
		if(octonary.charAt(0)=='0') {
			octonary.deleteCharAt(0);
		}
		return octonary.toString();
	}
	private static StringBuilder hexadecimalBinary(StringBuilder hexadecimal,int n) {
		StringBuilder binary = new StringBuilder();
		switch((4*n)%3) {
		case 0:{
			break;
		}
		case 1:{
			binary.append("00");
			break;
		}
		case 2:{
			binary.append("0");
			break;
		}
		}
		for(int i=0;i<n;i++) {
			binary.append(charBinary(hexadecimal.charAt(i)));
		}
		return binary;
	}
	
	private static final String charBinary(char c) {
		switch(c) {
		case '0':{
			return "0000";
		}
		case '1':{
			return "0001";
		}
		case '2':{
			return "0010";
		}
		case '3':{
			return "0011";
		}
		case '4':{
			return "0100";
		}
		case '5':{
			return "0101";
		}
		case '6':{
			return "0110";
		}
		case '7':{
			return "0111";
		}
		case '8':{
			return "1000";
		}
		case '9':{
			return "1001";
		}
		case 'A':{
			return "1010";
		}
		case 'B':{
			return "1011";
		}
		case 'C':{
			return "1100";
		}
		case 'D':{
			return "1101";
		}
		case 'E':{
			return "1110";
		}
		case 'F':{
			return "1111";
		}
		case 'a':{
			return "1010";
		}
		case 'b':{
			return "1011";
		}
		case 'c':{
			return "1100";
		}
		case 'd':{
			return "1101";
		}
		case 'e':{
			return "1110";
		}
		case 'f':{
			return "1111";
		}
		}
		return null;
	}

	private static final String binaryOctonary(String s) {
		switch(s) {
		case "000":{
			return "0";
		}
		case "001":{
			return "1";
		}
		case "010":{
			return "2";
		}
		case "011":{
			return "3";
		}
		case "100":{
			return "4";
		}
		case "101":{
			return "5";
		}
		case "110":{
			return "6";
		}
		case "111":{
			return "7";
		}
		}
		return null;
	}
}
