package algorithm;

import java.util.Scanner;

public class PointBoxes {

	private static String pointsBox[][]=null;
	private static int stepPointsBox[][]=null;
	private static int matrixLength=0;
	private static int horizontal=0;
	private static int vertical=0;
	private static int pointsMax=0;
	private static int pointsTemp=0;
	
	
//	public static void main(String[] args) {
//		
//		
//		Scanner sc = new Scanner(System.in);
//		matrixLength = sc.nextInt();
//		sc.nextLine();
//		pointsBox=new String[matrixLength][matrixLength];
//		for(int i=matrixLength-1;i>=0;i--) {
//			for(int j=0;j<matrixLength;j++) {
//				pointsBox[i][j]=sc.next();
//			}
//		}
//		stepPointsBox=new int[matrixLength][matrixLength];
//		for(int i=0;i<matrixLength;i++) {
//			for(int j=0;j<matrixLength;j++) {
//				stepPointsBox[i][j]=0;
//			}
//		}
//		traceback(0);
//		System.out.println(pointsMax);
//		
//		
//		
//		
//	}
	
	
	
	public static void traceback(int direction) {
		
		if(!boundaryJudge()) {
			return;
		}
		if(!thisStep()) {
			return;
		}
		stepPointsBox[horizontal][vertical]=1;
		calculatPoints();
		int temp=pointsTemp;
		for(int i=1;i<9;i++) {
			changeLocation(i);
			if(direction!=0&&direction!=i)
				pointsTemp--;
			traceback(i);
			pointsTemp=temp;
			changeLocationBack(i);
		}
		thisStepBack();
	}
	
	
	private static void changeLocation(int x) {
		switch (x) {
		case 1:{
			vertical++;
			break;
		}
		case 2:{
			vertical++;
			horizontal++;
			break;
		}
		case 3:{
			horizontal++;
			break;
		}
		case 4:{
			vertical--;
			horizontal++;
			break;
		}
		case 5:{
			vertical--;
			break;
		}
		case 6:{
			vertical--;
			horizontal--;
			break;
		}
		case 7:{
			horizontal--;
			break;
		}
		case 8:{
			vertical++;
			horizontal--;
			break;
		}
		}
	}
	
	private static void changeLocationBack(int x) {
		switch (x) {
		case 5:{
			vertical++;
			break;
		}
		case 6:{
			vertical++;
			horizontal++;
			break;
		}
		case 7:{
			horizontal++;
			break;
		}
		case 8:{
			vertical--;
			horizontal++;
			break;
		}
		case 1:{
			vertical--;
			break;
		}
		case 2:{
			vertical--;
			horizontal--;
			break;
		}
		case 3:{
			horizontal--;
			break;
		}
		case 4:{
			vertical++;
			horizontal--;
			break;
		}
		}
	}
	
	private static boolean boundaryJudge() {
		if(horizontal<0||vertical<0||vertical>=matrixLength||horizontal>=matrixLength) {
			System.out.println("boundaryJudgefalse  "+"horizontal  "+horizontal+"  vertical  "+vertical);
			return false;
		}
		else {
			System.out.println("boundaryJudgetrue  "+"horizontal  "+horizontal+"  vertical  "+vertical);
			return true;
		}
	}

	private static void calculatPoints() {
		switch(pointsBox[horizontal][vertical]) {
		case "0":{
			break;
		}
		case "1":{
			pointsTemp++;
			if(pointsTemp>pointsMax) {
				pointsMax=pointsTemp;
			}
			break;
		}
		case "#":{
			pointsTemp=pointsTemp*2;
			if(pointsTemp>pointsMax) {
				pointsMax=pointsTemp;
			}
			break;
		}
		case "*":{
			pointsTemp=0;
			break;
		}
		case "-1":{
			pointsTemp--;
			break;
		}
		}
	}
	
	private static boolean thisStep() {
		if(stepPointsBox[horizontal][vertical]==1) {
			System.out.println("thisStepfalse  "+"horizontal  "+horizontal+"  vertical  "+vertical);
			return false;
		}
		else {
			
			System.out.println("thisSteptrue  "+"horizontal  "+horizontal+"  vertical  "+vertical);
			return true;
		}
	}
	
	private static void thisStepBack() {
//		if(!boundaryJudge()) {
//			return;
//		}
		stepPointsBox[horizontal][vertical]=0;
	}
	
}
