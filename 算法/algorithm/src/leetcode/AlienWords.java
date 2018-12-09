package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AlienWords {
	private String order;
	public boolean isAlienSorted(String[] words ,String order) {
		this.order = order;
		for(int i = 0;i<words.length-1;i++) {
			if(compareWord(words[i],words[i+1])==-1) {
				return false;
			}
		}
		return true;
		  
	}
	
	private int compareWord(String a ,String b) {
		int aLength = a.length();
		int bLength = b.length();
		//int temp = 0;
		if(aLength<=bLength) {
			for(int i = 0;i<aLength;i++) {
				switch(compareChar(a.charAt(i),b.charAt(i))) {
				case -1:{
					return -1;
				}
				case 0:{
					break;
				}
				case 1:{
					return 1;
				}
				}
			}
			return 0;
		}
		else {
			for(int i = 0;i<bLength;i++) {
				switch(compareChar(a.charAt(i),b.charAt(i))) {
				case -1:{
					return -1;
				}
				case 0:{
					break;
				}
				case 1:{
					return 1;
				}
				}
			}
			return -1;
		}
		
		
	}
	
	private int compareChar(char a , char b) {
		for(int i =0;i<26;i++) {
			char c = order.charAt(i);
			if(c==a&&c==b) {
				return 0;//相等
			}
			else if(c==b) {
				return -1;//ab逆序
			}
			else if(c==a){
				return 1;//ab正序
			}
		}
		return -1;//逻辑上不可达
	}
}
/**
 *  public boolean isAlienSorted(String[] words, String order) {
	        int n = words.length;
	        String[] to = Arrays.copyOf(words, n);
	        Arrays.sort(to, new Comparator<String>() {
				public int compare(String a, String b) {
					for(int i = 0;i < a.length() && i < b.length();i++){
						int pa = order.indexOf(a.charAt(i));
						int pb = order.indexOf(b.charAt(i));
						if(pa != pb)return pa - pb;
					}
					return a.length() - b.length();
				}
			});
	        return Arrays.equals(words, to);
	    }
 * 
 * 
 * 
 * 
 * 
 * **/


