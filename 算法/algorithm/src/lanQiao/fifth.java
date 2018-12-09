package lanQiao;

import java.util.Scanner;

public class fifth {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		int[][] matrix = new int[n][m];
//		for(int i= 0;i<n;i++) {
//			for(int j =0;j<m;j++) {
//			matrix[i][j]=sc.nextInt();	
//			}
//		}
//		fun(matrix,n,m);
//	}
	public static void fun(int[][] matrix,int N,int M) {
		int sum = 0;
		int[][][] numMatrix = new int[N][M][4];
		//计算参数
		for(int i = 0;i<N;i++) {
			for(int j =0;j<M;j++) {
				if(i<N-2&&j<M-2) {
					numMatrix[i][j][0] = matrix[i][j] + matrix[i][j+1] + matrix[i][j+2];
					numMatrix[i][j][1] = matrix[i][j] + matrix[i+1][j] + matrix[i+2][j];
					numMatrix[i][j][2] = matrix[i][j] + matrix[i+1][j+1] + matrix[i+2][j+2];
				}
				else if(i<N-2) {
					numMatrix[i][j][1] = matrix[i][j] + matrix[i+1][j] + matrix[i+2][j];
					numMatrix[i][j][2] = -1;
					numMatrix[i][j][0] = -1;
							
				}
				else if(j<M-2) {
					numMatrix[i][j][0] = matrix[i][j] + matrix[i][j+1] + matrix[i][j+2];
					numMatrix[i][j][1] = -1;
					numMatrix[i][j][2] = -1;
				}
				if(i<N-2&&(j-2)>=0) {
					numMatrix[i][j][3] = matrix[i][j] + matrix[i+1][j-1] + matrix[i+2][j-2];
				}
				else {
					numMatrix[i][j][3] = -1;
				}
			}
		}
		//判断
		for(int i = 0;i<N-2;i++) {
			for(int j =0;j<M-2;j++) {
				int temp = numMatrix[i][j][0];
				if(temp==numMatrix[i][j][1]
						&&temp==numMatrix[i][j][2]
						&&temp==numMatrix[i][j+1][1]
						&&temp==numMatrix[i][j+2][3]
						&&temp==numMatrix[i][j+2][1]
						&&temp==numMatrix[i+1][j][0]
						&&temp==numMatrix[i+2][j][0]
						) {
				sum++;	
				}
			}
		}
		//输出
		System.out.println(sum);
	}
}
