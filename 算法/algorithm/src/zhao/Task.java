package zhao;

public class Task {
	  	  private final int arrival;
	  	  private final int duration;
	  	  
	  	  // constructs a task with arrival time a and duration d
	  	  public Task (int a, int d){
	  	    this.arrival = a;
	  	    this.duration = d;
	  	  }
	  	  
	  	  // returns the arrival time of this task
	  	  public int getArrival(){
	  	    return this.arrival; 
	  	  }
	  	  
	  	  // returns the duration of this task
	  	  public int getDuration(){
	  	    return this.duration; 
	  	  }
	  	  
}
