package com.example.java1mysql.controller;

import com.example.java1mysql.dao.JpaPerson;
import com.example.java1mysql.domain.HomeAddress;
import com.example.java1mysql.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@RestController
public class Restful {
    @Resource
    private JpaPerson jpaPerson;

    @PutMapping("/person")
    public Person persist(@RequestBody Person person) {
        return jpaPerson.save(person);
    }

    @PostMapping("/person")
    public Person update(@RequestBody Person person) {
        /**
         *note:全部更新与新建本质相同，但是业务逻辑可能有多有少，所以最好留两个api
         */
        return jpaPerson.save(person);
    }
    @PatchMapping("/person/{personCode}")
    public Person updatePart(@RequestBody HomeAddress homeAddress
            ,@PathVariable String personCode){
        Person person = jpaPerson.findByPersonCode(personCode);
        if (person == null) throw new RuntimeException(" person not exits");
        person.setHomeAddress(homeAddress);
        return jpaPerson.save(person);
    }

    @Transactional
    @DeleteMapping("/person/{personCode}")
    public Boolean remove(@PathVariable String personCode) {
        jpaPerson.deleteByPersonCode(personCode);
        return true;
    }

    @Transactional
    @DeleteMapping("/persons")
    public Boolean cleanUp() {
        jpaPerson.deleteAll();
        return true;
    }

    @GetMapping("/person/{personCode}")
    public Person getOne(@PathVariable String personCode){
        return jpaPerson.findByPersonCode(personCode);
    }

    @GetMapping("/persons")
    public List<Person> findAll(){
        return jpaPerson.findAll();
    }
    @GetMapping("/persons/{pageNum}/{pageSize}")
    public Page<Person> findSome(@PathVariable int pageNum, @PathVariable int pageSize){
        return jpaPerson.findAll(PageRequest.of(pageNum,pageSize));
    }



}
