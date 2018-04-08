package com.springboot.controller;

import com.springboot.domain.Car;
import com.springboot.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;


    @RequestMapping("car_list")
    public ResponseEntity<?> hello(){
        CustomType customType = new CustomType(400,"查无此数据");
        List<Car> cars = carService.list();
        if (cars!=null){
            customType.setCode(200);
            customType.setMessage("查询成功");
        }
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }


}
