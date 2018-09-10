package com.example.java1mysql;

import com.example.java1mysql.dao.JpaPerson;
import com.example.java1mysql.domain.HomeAddress;
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
    public void test01() {
        Person person = new Person();
        person.setName("zhangsanfeng");
        person.setPersonCode("31212");
        person.setSex(Person.Sex.female);
        person.getHomeAddress().setCity("ji_nan");
        person.getHomeAddress().setProvince(HomeAddress.Province.sichuan);
        jpaPerson.save(person);
    }

}
