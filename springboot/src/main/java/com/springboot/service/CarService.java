package com.springboot.service;

import com.springboot.domain.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  业务逻辑层
 */
@Service
public class CarService {
    /**
     *  查询所有
     * @return
     */
    public List<Car> list(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1,"兰博基尼",12345d,new Date()));
        return  cars;
    }
}
