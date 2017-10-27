package com.example.demo.controller;

import com.example.demo.dao.GrilDao;
import com.example.demo.model.Gril;
import com.example.demo.model.Result;
import com.example.demo.service.GrilService;
import com.example.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/grils")
public class GrilController {

    private final static Logger logger = LoggerFactory.getLogger(GrilController.class);

    @Autowired
    private GrilDao grilDao;

    @Autowired
    private GrilService grilService;

    /**
     * 查询所有
     * @return
     */
    @GetMapping(value = "")
    public Result getGrilList(){
        return ResultUtil.success(grilDao.findAll());
    }

    /**
     * 单个查询
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getGrilById(@PathVariable("id") Integer id){
        return new ResponseEntity<Object>(grilDao.findOne(id), HttpStatus.OK);
    }

    /**
     * 添加
     * @param gril
     * @return
     */
    @PostMapping(value = "")
    public Result<Gril> addGril(@Valid Gril gril, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(grilDao.save(gril));
    }

    /**
     * 修改
     * @return
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateGril(@PathVariable("id") Integer id,
                                        @RequestBody Gril gril){
        return new ResponseEntity<Object>(grilDao.save(gril), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteGril(@PathVariable("id") Integer id){
        grilDao.delete(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/getAge/{id}")
    public Result<Gril> getAge(@PathVariable("id") Integer id) throws Exception{
        grilService.getAge(id);
        return ResultUtil.success(null);
    }
}
