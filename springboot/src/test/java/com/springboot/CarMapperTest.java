package com.springboot;

import com.springboot.domain.Car;
import com.springboot.mapper.CarMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarMapperTest {

    @Autowired
    private CarMapper carMapper;

    @Test
    public  void find(){
        for (Car car : carMapper.find()){
            System.out.println(car.getName()+" "+car.getPrice());
        }
    }

    @Test
    public  void findById(){
        Car car = carMapper.findById(3);
        System.out.println(car.getName() + " " + car.getPrice());
    }

    @Test
    public  void findByParam(){
        String name = null;
        Date beginDate = null;
        Date endDate = null;
        for (Car car:carMapper.findByParam(name,beginDate,endDate)) {
            System.out.println(car.getName() + " " + car.getPrice());
        }
    }
}
