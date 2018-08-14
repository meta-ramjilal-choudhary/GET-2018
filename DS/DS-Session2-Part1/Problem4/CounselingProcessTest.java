import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import java.io.File;

import org.junit.jupiter.api.Test;

class CounselingProcessTest {

	@Test
	void test() {
		CounselingProcess cp = new CounselingProcess(9);
		File programList = new File("C:\\Users\\User29\\eclipse-workspace\\DS-Session2-Q4\\bin\\programList.xls");
		File studentList = new File("C:\\Users\\User29\\eclipse-workspace\\DS-Session2-Q4\\bin\\studentList.xls");
		File counselingList = new File("C:\\Users\\User29\\eclipse-workspace\\DS-Session2-Q4\\bin\\counselingList.xls");
		try {
			cp.addProgramFromExcel(programList);
			cp.addStudentFromExcel(studentList);
			cp.allocatePrograms();
			cp.writeDataInFile(counselingList);
		}catch(IOException e) {
			System.out.println(e);
		}
		
	}

}
