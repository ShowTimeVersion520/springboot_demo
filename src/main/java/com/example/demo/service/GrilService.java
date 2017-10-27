package com.example.demo.service;

import com.example.demo.dao.GrilDao;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.GrilException;
import com.example.demo.model.Gril;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GrilService {

    @Autowired
    private GrilDao grilDao;

    @Transactional(rollbackOn = {Exception.class})
    public void insertTwo(){
        Gril a = new Gril();
        Gril b = new Gril();

        a.setAge(9);
        a.setCupSize("A");
        a.setId(1);

        a.setAge(9);
        a.setCupSize("BBBBBBBBBBB");
        a.setId(2);

        grilDao.save(a);
        grilDao.save(b);
    }

    public void getAge(Integer id) throws Exception{
        Gril gril = grilDao.findOne(id);
        if(gril.getAge() < 10){
            throw new GrilException(ResultEnum.PRIMARY_SCHOOL);
        }
    }

    /**
     * 通过ID查询女生信息
     * @param id
     * @return
     */
    public Gril findOne(Integer id){
        return grilDao.findOne(id);
    }
}
