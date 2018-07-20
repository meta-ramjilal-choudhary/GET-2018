import java.util.Scanner;

public class FCFSScheduling extends Process{
	
	private double averageWaitingTime;
	private long maximumWaitingTime;
	
	FCFSScheduling(){
		this.averageWaitingTime = 0;
		this.maximumWaitingTime = 0;
	}
	
	/*
	 * Computes Completion time, Turn Around time, Waiting time
	 * @param   numberOfProcess - Total number of Process
	 * @param   arrivalBurstTime - Two dimensional array with arrival time and burst time
	 * @return  nothing
	 */
	public void computationOFTimes(Process process[], long arrivalBurstTime[][]) {
		
		long preProcessCT = 0;
		long totalWaitingTime = 0;
		long maximumWaitingTime = 0;
		
		for(int i=0; i<process.length; i++) {
			
			process[i] = new Process( arrivalBurstTime[i][0], arrivalBurstTime[i][1] );
			process[i].setCompletionTime(preProcessCT);
			
			preProcessCT = process[i].getCompletionTime();
			
			process[i].setTurnAroundTime();
			
			process[i].setWaitingTime();
			
			totalWaitingTime += process[i].getWaitingTime();
			
			maximumWaitingTime = (maximumWaitingTime >= process[i].getWaitingTime()) ? maximumWaitingTime : process[i].getWaitingTime();
		}
		
		this.setAverageWaitingTime(process.length, totalWaitingTime);
		this.setMaximumWaitingTime(maximumWaitingTime);
	}
	
	/*
	 * Compute Average Waiting time
	 * @param  totalWaitingTime - Total of Waiting time
	 * @return nothing
	 */
	public void setAverageWaitingTime(int numberOfProcess, long totalWaitingTime) {
		this.averageWaitingTime = (double)totalWaitingTime / (double)numberOfProcess;
	}
	
	/*
	 * @param  nothing
	 * @return Average waiting time
	 */
	public double getAverageWaitingTime() {
		return this.averageWaitingTime;
	}
	
	/*
	 * Computer Maximum Waiting Time
	 * @param  maximum Waiting time 
	 * @return nothing
	 */
	public void setMaximumWaitingTime(long maximumWaitingTime) {
		this.maximumWaitingTime = maximumWaitingTime;
	}
	
	/*
	 * @param  nothing
	 * @return Maximum Waiting time
	 */
	public long getMaximumWaitingTime() {
		return this.maximumWaitingTime;
	}
	
	/*
	 * Print list of Process 
	 * @param process - Array of Process objects 
	 * @param numberOfProcess - Total number of Process
	 */
	public void listProcess(Process process[]) {
		System.out.println("Process\t  C.T.\tT.A.T\tW.T");
		for (int i=0; i<process.length; i++) {
			System.out.println("P-"+ (i+1) + "\t  " + process[i].getCompletionTime() + "  \t" + process[i].getTurnAroundTime() + "    \t" + process[i].getWaitingTime());
		}
	}
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Number of Process: ");
		int numberOfProcess = sc.nextInt();
		
		long arrivalBurstTime[][] = new long[numberOfProcess][2];
		
		for(int i=0; i<numberOfProcess; i++) {
			for(int j=0; j<2; j++) {
				arrivalBurstTime[i][j] = sc.nextInt();
			}
		}
		
		FCFSScheduling fcfs = new FCFSScheduling();
		
		Process process[] = new Process[numberOfProcess];
		
		fcfs.computationOFTimes(process, arrivalBurstTime);
	
		fcfs.listProcess(process);
		
		System.out.println("\nAverage Waiting Time: "+fcfs.getAverageWaitingTime());
		System.out.println("\nMaximum Waiting Time: "+fcfs.getMaximumWaitingTime());
		
	}
	
}
