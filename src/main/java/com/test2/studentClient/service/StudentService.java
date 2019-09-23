package com.test2.studentClient.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test2.studentClient.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Arrays;


@Component
public class StudentService {

    RestTemplate restTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @PostConstruct
    public void init(){
        restTemplate = new RestTemplate();
    }


    public StudentVO getStudentById(Integer id) throws IOException {

      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity <String> entity = new HttpEntity<String>(headers);

      String response = restTemplate.exchange("http://localhost:8080/student/" + id, HttpMethod.GET, entity, String.class).getBody();

      return objectMapper.readValue(response, StudentVO.class);

    }

    public void saveStudent(StudentVO studentVO) throws IOException {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity <StudentVO> entity = new HttpEntity<StudentVO>(studentVO, headers);

        restTemplate.exchange("http://localhost:8080/student/addstudent", HttpMethod.POST, entity, String.class);


    }



}
