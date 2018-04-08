package com.springboot.controller;

import com.springboot.domain.Car;
import com.springboot.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@SessionAttributes(types = {String.class},names = {"car"})
@Controller
public class CarsColler {
    @Autowired
    private CarService carService;

      @RequestMapping("hithymeleaf")
    public String hiThymeleaf(
            @RequestParam(value = "name",required = false,defaultValue = "world") String name,
            Model model
    ){
        // 模型数据
        model.addAttribute("name",name);
        // 视图 （resources 下的模版中的  html :hello.html）
        return "hello";
    }

    @GetMapping("carlist")
    public ModelAndView hello(){
        List<Car> cars = carService.list();
        ModelAndView mv = new ModelAndView("carlist");
        mv.addObject("cars", cars); //

        Car car = new Car(10,"奔驰",8888d,new Date());
        cars.add(car);
        mv.addObject("car", car);
        return mv;
    }
}
