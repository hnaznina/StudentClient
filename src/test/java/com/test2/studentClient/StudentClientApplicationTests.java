package com.test2.studentClient;

import com.test2.studentClient.service.StudentService;
import com.test2.studentClient.vo.StudentVO;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class StudentClientApplicationTests {

	@Autowired
	private StudentService studentService;

	@Test
	public void testGetStudentById() throws IOException {

		StudentVO studentVO = studentService.getStudentById(3);
		log.info(studentVO);

	}

	@Test
	public void testSaveStudent() throws IOException {

		studentService.saveStudent(new StudentVO(3, "Ihti", 5));


	}

}
