
public class Process {
	
	private long arrivalTime;
	private long burstTime;
	private long completionTime;
	private long turnAroundTime;
	private long waitingTime;
	
	Process(){}
	
	Process(long arrivalTime, long burstTime){
		this.arrivalTime = arrivalTime;
		this.burstTime = burstTime;
		this.completionTime = 0;
		this.turnAroundTime = 0;
		this.waitingTime = 0;
	}
	
	/*
	 * Compute Completion Time for Process
	 * @param   preProcessCT - Previous Process Completion Time
	 * @return  nothing
	 */
	public void setCompletionTime(long preProcessCT) {
		
		this.completionTime = (this.arrivalTime >= preProcessCT) ? (this.arrivalTime + this.burstTime) : (preProcessCT + this.burstTime);
		
	}
	
	/*
	 * @param   nothing
	 * @return  Present Process Completion Time
	 */
	public long getCompletionTime() {

		return this.completionTime;
		
	}
	
	/*
	 * Compute Turn Around Time
	 * @param   nothing
	 * @return  nothing
	 */
	public void setTurnAroundTime() {
		
		this.turnAroundTime = this.completionTime - this.arrivalTime ;
		
	}
	
	/*
	 * @param   nothing
	 * @return  Process Turn Around Time
	 */
	public long getTurnAroundTime() {
		
		return this.turnAroundTime;
		
	}
	
	/*
	 * Computer Waiting Time for a Process
	 * @param   nothing
	 * @return  nothing
	 */
	public void setWaitingTime() {
		
		this.waitingTime = this.turnAroundTime - this.burstTime;
		
	}
	
	/*
	 * @param   nothing
	 * @return  Waiting Time for a Process
	 */
	public long getWaitingTime() {
		
		return this.waitingTime;
		
	}
	
}
