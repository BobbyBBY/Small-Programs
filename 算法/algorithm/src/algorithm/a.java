package algorithm;

public class a {

//	public static void main(String[] args) {
//		int[][] matrix= {{1,4,6},{3,7,4},{2,1,5}};
//		System.out.println(MinMax(matrix));
//	}
	public static int MinMax(int[][] matrix) {
		for(int i = 0;i<matrix.length;i++) {
			for(int j = 1;j<matrix.length;j++) {
				if(matrix[i][j-1]>matrix[i][j]) {
					matrix[i][j]+=matrix[i][j-1];
					matrix[i][j-1]=matrix[i][j]-matrix[i][j-1];
				}
			}
			if(i!=0) {
				if(matrix[i-1][matrix.length-1]<matrix[i][matrix.length-1]) {
					matrix[i][matrix.length-1]=matrix[i-1][matrix.length-1];
				}
			}
		}
		return matrix[matrix.length-1][matrix.length-1];
	}
}
