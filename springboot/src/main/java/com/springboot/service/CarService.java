package com.springboot.service;

import com.springboot.domain.Car;
import com.springboot.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  业务逻辑层
 */
@Service
@Transactional(readOnly = true,propagation = Propagation.NOT_SUPPORTED)
public class CarService {
    @Autowired
    private CarMapper carMapper;
    /**
     *  查询所有
     * @return
     */
    public List<Car> list(){
       return  carMapper.find();
    }

    /**
     *  根据 ID 查询
     * @param id
     * @return
     */
    public  Car findById(Integer id){
        return carMapper.findById(id);
    }

    /**
     *  新增
     * @param car
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    public int add(Car car){
        return carMapper.add(car);
    }

    /**
     *  修改
     * @param car
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int modify(Car car){
        return carMapper.modify(car);
    }

    /**
     *  删除
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int remove(Integer id){
        return carMapper.remove(id);
    }
}
