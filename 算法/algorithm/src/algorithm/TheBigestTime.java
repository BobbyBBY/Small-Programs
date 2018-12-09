package algorithm;

public class TheBigestTime {
	public static void Time(int[] timeInt) {
		boolean sign=true;
		int i=0;
		while(sign) {
			sign = false;
			for(;i<3;i++) {
				int temp = 0;
				if(timeInt[i]<timeInt[i+1]) {
					temp = timeInt[i+1];
					timeInt[i+1] = timeInt[i];
					timeInt[i] = temp;
					sign =true;
				}
			}
			i=0;
		}
		StringBuilder result = hour(timeInt);
		if(result==null) {
			System.out.println("\"\"");
		}
		else {
			System.out.println("\""+result.toString()+"\"");
		}
		
	}
	
	private static StringBuilder hour(int[] timeInt) {
		int temp = -1;
		StringBuilder result = new StringBuilder();
		for(int i=0;i<4;i++) {
			if(timeInt[i]<=2) {
				temp=timeInt[i];
				result = remain(timeInt,i);
				if(result!=null) {
					return result;
				}
			}
		}
		return result;
	
	}
	private static StringBuilder remain(int[] timeInt,int n) {
		boolean sign = true;
		int[] timeInt2 = new int[3];
		StringBuilder result = new StringBuilder();
		if(timeInt[n]==2) {
			for(int i = 3,j=0;i>=0&&sign==true;i--) {
				if(i==n) {
					continue;
				}
				switch(j) {
				case 0:{
					if(timeInt[i]>3) {
						sign = false;
					}
					break;
				}
				case 1:{
					if(timeInt[i]>5) {
						sign = false;
					}
					break;
				}
				}
				timeInt2[j]=timeInt[i];
				j++;
			}
			if(sign==false) {
				return null;
			}
			result.append(timeInt[n]);
			if(timeInt2[2]<=3) {
				result.append(timeInt2[2]);
				result.append(":");
				result.append(timeInt2[1]);
				result.append(timeInt2[0]);
				return result;
			}
			else if(timeInt2[2]<=5) {
				if(timeInt2[1]<=3) {
					result.append(timeInt2[1]);
					result.append(":");
					result.append(timeInt2[2]);
					result.append(timeInt2[0]);
					return result;
				}
				else {
					result.append(timeInt2[0]);
					result.append(":");
					result.append(timeInt2[2]);
					result.append(timeInt2[1]);
					return result;
				}
				
			}
			else {
				if(timeInt2[1]<=3) {
					result.append(timeInt2[1]);
					result.append(":");
					result.append(timeInt2[0]);
					result.append(timeInt2[2]);
					return result;
				}
				if(timeInt2[1]<=5) {
					result.append(timeInt2[0]);
					result.append(":");
					result.append(timeInt2[1]);
					result.append(timeInt2[2]);
					return result;
				}
			}
			return null;
			
		}
		else {
			for(int i = 3,j=0;i>=0&&sign==true;i--) {
				if(i==n) {
					continue;
				}
				if(j==2) {
					if(timeInt[j]>5) {
						sign=false;
					}
				}
				timeInt2[j]=timeInt[i];
				j++;
			}
			if(sign==false) {
				return null;
			}
			result.append(timeInt[n]);
			if(timeInt2[1]<=5) {
				result.append(timeInt2[2]);
				result.append(":");
				result.append(timeInt2[1]);
				result.append(timeInt2[0]);
				return result;
			}
			else {
				result.append(timeInt2[2]);
				result.append(":");
				result.append(timeInt2[0]);
				result.append(timeInt2[1]);
				return result;
			}
			
			
		}
		
	}
}
