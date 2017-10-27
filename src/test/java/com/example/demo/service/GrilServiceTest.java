package com.example.demo.service;

import com.example.demo.model.Gril;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GrilServiceTest {
    @Autowired
    private GrilService grilService;

    @Test
    public void testFindOne(){
        Gril gril = grilService.findOne(1);
        Assert.assertEquals(new Integer(10), gril.getAge());
    }

}