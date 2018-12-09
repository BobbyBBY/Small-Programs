package zhao;

import java.util.LinkedList;
import java.util.Queue;



public class ServerSimulation {
	private final int numberOfServers;
	private final int numberOfTimePeriods;
	private final int numberOfTasks;
	private final int durationPerTask;

	public int finalQueueLength;
	public int totalQueueLength;
	public int totalWaitTime;
	public  int totalNumberOfTasks;
	public ServerSimulation(int numberS, int time, int numberT, int duration){	    
		this.numberOfServers = numberS;
		this.numberOfTimePeriods = time;
		this.numberOfTasks = numberT;
		this.durationPerTask = duration;
		    
		this.finalQueueLength = 0;;
		this.totalQueueLength = 0;
		this.totalWaitTime = 0;
		this.totalNumberOfTasks = 0;
	}
	public void run() {
		
		int[] Servers = new int[numberOfServers];
		for(int i = 0 ;i < numberOfServers ;i ++) {
			Servers[i]=0;
		}
		Queue<Task> taskWaitQueue = new LinkedList<Task>();
		//Queue<Task> taskWaitQueue = new Queue<Task>();queue�ǽӿڣ�����ʵ����
		for(int t=1; t<=numberOfTimePeriods; t++){
			for(int i = 0 ;i < numberOfServers ;i ++) {
				if(Servers[i]!=0) {
					Servers[i] -= 1;//���������һ�����ڵĹ���
				}
			}
			int numberTask = (int)(Math.random()*(this.numberOfTasks+1));//��ȡk
		    Queue<Task> taskQueue = new LinkedList<Task>();
		    for(int i=0; i< numberTask; i++){
		    	taskQueue.add(new Task(t,(int)(Math.random()*this.durationPerTask+1)));//��ȡ���t������task
		    }
		    totalNumberOfTasks += numberTask;
		    for(int i = 0 ;i < numberOfServers ;i ++) {
				if(Servers[i]==0) {
					if(!taskWaitQueue.isEmpty()) {//������������ڿ��У��Ͱ�wait���еĵ�һ��task�Ž�ȥ
						Task temp = taskWaitQueue.poll();
						Servers[i] = temp.getDuration();
						totalWaitTime += (t - temp.getArrival());
					}
					else if(!taskQueue.isEmpty()){//������������ڿ���,��wait���п��У��Ͱ�taskQueue���еĵ�һ��task�Ž�ȥ
						Task temp = taskQueue.poll();
						Servers[i] = temp.getDuration();
					}
				}
			}
		    //taskWaitQueue.addAll(taskQueue);
		    //totalQueueLength += taskQueue.size();
		    while(!taskQueue.isEmpty()) {
		    	taskWaitQueue.add(taskQueue.poll());
		    }
		    totalQueueLength += taskWaitQueue.size();
		   
		}
		finalQueueLength = taskWaitQueue.size();
	}
	  // returns the average wait time for tasks that are processed
	  public double getWaitTime(){
	    return (double)((double)this.totalWaitTime/(double)this.totalNumberOfTasks);
	  }
	  
	  // returns the average queue length over the time period
	  public double getQueueLength(){  
	    return (double)((double)this.totalQueueLength/(double)this.numberOfTimePeriods);
	  }
	  
	  // returns the queue length after time this.numberOfTimePeriods
	  public int getFinalQueueLength(){
	    return finalQueueLength;
	  }
	  // test the simulation usind command line parameters
//	  public static void main (String[] args){
//	    
//	    int M  = 10;
//	    int T  = 1000;
//	    int K  = 6;
//	    int D  = 4;
//	    ServerSimulation simulation = new ServerSimulation(M, T, K, D);
//	    simulation.run();
//	    
//	    System.out.println("Average wait time per task: " + simulation.getWaitTime());
//	    System.out.println("Average queue length: " + simulation.getQueueLength()); 
//	    System.out.println("Queue length at end: " + simulation.getFinalQueueLength());
//	  }
}
	       
