package com.example.java1mysql;

import com.example.java1mysql.dao.JpaPerson;
import com.example.java1mysql.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Java1mysqlApplicationTests {
    @Resource
    private JpaPerson jpaPerson;

    @Test
    public void contextLoads() {
        Person person = new Person();
        person.setName("zhangsanfeng");
        person.setAge(23);
        jpaPerson.save(person);
    }

}
