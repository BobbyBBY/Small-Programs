package algorithm;

//基数排序,10进制

public class ArraySorting {

	
	static class NumNode{
		public int value;
		public NumNode next;
		NumNode(){
			next=null;
		}
		public NumNode newNumNode(int a){
			next=new NumNode();
			next.value=a;
			return next;
		}
	}
	
	static class NumList{
		public NumNode head;
		public NumNode tail;
		NumList(){
			tail=head=null;
		}
		public void add(int a) {
			if(tail==null) {
				tail=head=new NumNode();
				tail.value=a;
			}
			else {
				tail=tail.newNumNode(a);
			}
		}
	}
	
	public static int[] arraySorting(int[] unSorted) {
		NumList[] bucket=new NumList[10];
		bucket=initbucket(bucket);
		boolean[] mark=new boolean[unSorted.length];
		mark=initmark(mark);
		int numRuler=10;
		int numSign=0;
		do{
			for(int i=0;i<unSorted.length;i++) {
				if((unSorted[i]/numRuler)==0) {
					mark[i]=true;
				}
				numSign=(int)(unSorted[i]%numRuler)/(numRuler/10);
				bucket[absol(numSign)].add(unSorted[i]);
			}
			unSorted=numLink(bucket,unSorted.length);
			numRuler*=10;
			bucket=initbucket(bucket);
		}while(!markJudge(mark)) ;
		unSorted=numLinkNegative(unSorted);
		return unSorted;
	}
	
	public static NumList[] initbucket(NumList[] bucket) {
		for(int i=0;i<10;i++) {
			bucket[i]=new NumList();
		}
		return bucket;
	}
	public static boolean[] initmark(boolean mark[]) {
		for(int i=0;i<mark.length;i++) {
			mark[i]=false;
		}
		return mark;
	}
	public static boolean markJudge(boolean mark[]) {
		boolean sign=true;
		for(int i=0;sign==true&&i<mark.length;i++) {
			sign=sign&&mark[i];
		}
		return sign;
	}

	public static int[] numLink(NumList[] bucket,int n) {
		int[] back=new int[n];
		NumNode temp=null;
		for(int i=0,j=0;i<10;i++) {
			temp=bucket[i].head;
			while(temp!=null) {
				back[j]=temp.value;
				j++;
				temp=temp.next;
			}
		}
		return back;
	}

	private static int[] numLinkNegative(int[] unSorted) {
		int[] sorted=new int[unSorted.length];
		for(int i=unSorted.length-1,q=0,p=unSorted.length-1;i>=0;i--) {
			if(unSorted[i]>=0) {
				sorted[p]=unSorted[i];
				p--;
			}
			else {
				sorted[q]=unSorted[i];
				q++;
			}
		}
		return sorted;
	}
	private static int absol(int a) {
		if(a<0)
			return -a;
		else return a;
	}
	
}
