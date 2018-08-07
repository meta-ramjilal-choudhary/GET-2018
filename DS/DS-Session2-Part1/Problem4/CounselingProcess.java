
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class CounselingProcess {

	private int totalPrograms;
	private Program programList[];
	private Queue<Student> studentList;
	
	CounselingProcess(int totalProgramsOfferd){
		this.totalPrograms = totalProgramsOfferd;
		this.programList = new Program[this.totalPrograms];
		this.studentList = new LinkedList<Student>();
	}
	
	/**
	 * Read student data from excel file
	 * @param studentListFile - student excel file
	 * @throws IOException
	 */
	public void addStudentFromExcel(File studentListFile) throws IOException{
		Workbook workbook;
		try {
			workbook = Workbook.getWorkbook(studentListFile);
			Sheet sheet = workbook.getSheet(0);
          
			for(int i=0; i < sheet.getRows(); i++) {
				Cell cell1 = sheet.getCell(0, i);
				Cell cell2 = sheet.getCell(1, i);
				Cell cell3 = sheet.getCell(2, i);
				String prefList[] = new String[5];
				for(int j=0; j<5; j++) {
					prefList[j] = sheet.getCell(j+3, i).getContents().toString();
				}
				Student student = new Student(cell3.getContents().toString(), Integer.parseInt(cell2.getContents().toString()),
					Integer.parseInt(cell1.getContents().toString()), prefList);
				this.studentList.add(student);
		}
		}catch(BiffException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * Read Program offer data from excel file
	 * @param programListFile - Program list excel file
	 * @throws IOException
	 */
	public void addProgramFromExcel(File programListFile) throws IOException{
		Workbook workbook;
		try {
			workbook = Workbook.getWorkbook(programListFile);
			Sheet sheet = workbook.getSheet(0);
          
			for(int i=0; i < sheet.getRows(); i++) {
				Cell cell1 = sheet.getCell(0, i);
				Cell cell2 = sheet.getCell(1, i);
				Cell cell3 = sheet.getCell(2, i);
				Program program = new Program(cell1.getContents().toString(), cell2.getContents().toString(), 
        		  Integer.parseInt(cell3.getContents().toString()));
				this.programList[i] = program;
          }
		}catch(BiffException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * Allocate program to student
	 */
	public void allocatePrograms() {
		while(!this.studentList.isEmpty()) {
			Student student = this.studentList.poll();
			String prefList[] = student.getPrefProgramList();
			boolean outerFlag = false;
			for(int i=0; i < prefList.length; i++) {
				for(int j=0; j<this.programList.length; j++) {
					if( prefList[i].equals( this.programList[j].getCode() )) {
						if(this.programList[j].getCapacity() != 0) {
							outerFlag = true;
							student.setProgram(this.programList[j]);
							this.programList[j].addStudentToProgram(student);
							this.programList[j].updateCapacity(this.programList[j].getCapacity() - 1);
							break;
						}	
						else {
							break;
						}
					}
				}
				if(outerFlag) {
					break;
				}
			}
		}
	}
	
	/**
	 * Write all allocated information to counselingList
	 * @param counselingList - output counseling excel file
	 */
	public void writeDataInFile(File counselingList) {
		WritableWorkbook counselingBook = null;
        	try {

        		counselingBook = Workbook.createWorkbook(counselingList);
            		WritableSheet excelSheet = counselingBook.createSheet("Sheet 1", 0);

            		int row=0;
            		for(Student student: this.studentAllocatePrograms) {
				Label label1= new Label(0, row, Integer.toString(student.getRank()));
				Label label2 = new Label(1, row, student.getName());
				Label label3 = new Label(2, row, student.getAllocatedProgram().getName());
				excelSheet.addCell(label1);
				excelSheet.addCell(label2);
				excelSheet.addCell(label3);
				row++;
			}
            		counselingBook.write();


        	} catch (IOException e) {
            		e.printStackTrace();
        	} catch (WriteException e) {
            		e.printStackTrace();
        	} finally {

            		if (counselingBook != null) {
                	try {
                		counselingBook.close();
                	} catch (IOException e) {
                   		e.printStackTrace();
                	} catch (WriteException e) {
                    		e.printStackTrace();
                	}
            	}


        	}
	}
	
}
