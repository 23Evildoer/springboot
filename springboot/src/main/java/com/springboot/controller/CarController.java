package com.springboot.controller;

import com.springboot.domain.Car;
import com.springboot.domain.CustomType;
import com.springboot.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http//127.0.0.1:8080",maxAge = 3600)
public class CarController {

    @Autowired
    private CarService carService;

     /**
     *  查询所有  http://127.0.0.1:8086/ssm/api/cars
     *  条件查询 http://127.0.0.1:8086/ssm/api/cars?name=x&beginDate=x&endDate=x
     * @return
     */
    @RequestMapping(value = "/cars",method = RequestMethod.GET)
    public ResponseEntity<?> list(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "beginDate", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date beginDate,
            @RequestParam(value = "endDate", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate
    ){
        System.out.println("接受到的值："+username+" "+beginDate+" "+endDate);
        CustomType customType = new CustomType(400,"没有匹配的结果");
        List<Car> cars = carService.findByParam(username, beginDate, endDate);
        if (cars!=null){
            customType.setCode(200);
            customType.setMessage("查询成功");
        }
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    /**
     *  根据 id 查询 http://127.0.0.1:8086/ssm/api/cars/10
     * @param id
     * @return
     */
    @RequestMapping(value = "/cars/{id}",method = RequestMethod.GET)
    public  ResponseEntity<?> findById(
            @PathVariable("id")Integer id
    ){
        System.out.println("接受的ID："+id);
        Car car = carService.findById(id);
        if (car==null){
            return new ResponseEntity<>(new CustomType(400,id + "没有数据显示"), HttpStatus.OK);
        }
       return new ResponseEntity<>(car, HttpStatus.OK);
    }

    /**
     * 新增 http://127.0.0.1:8086/ssm/api/caradd
     *
     * @return
     */
    @RequestMapping(value = "/cars", method = RequestMethod.POST)
    public ResponseEntity<?> add(
            @RequestBody Car car) {
        System.out.println("接受的数据:"+car);
            int count = carService.add(car);
            if (count == 0) {
                return new ResponseEntity<>(new CustomType(400,"新增失败"), HttpStatus.OK);
            }

        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    /**
     *  修改  http://127.0.0.1:8086/ssm/api/cars
     * @param car
     * @return
     */
    @RequestMapping(value = "/cars",method = RequestMethod.PUT)
    public  ResponseEntity<?> modify(
            @RequestBody Car car
    ){
        System.out.println(car);
        int count = carService.modify(car);
        if (count==0){
            return new ResponseEntity<>(new CustomType(400,"修改失败"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new CustomType(200,"修改成功"), HttpStatus.OK);
    }

    /**
     *  删除 http://127.0.0.1:8086/ssm/api/cars/10
     * @param id
     * @return
     */
    @RequestMapping(value = "/cars/{id}",method = RequestMethod.DELETE)
    public  ResponseEntity<?> remove(
            @PathVariable("id")Integer id
    ){
        System.out.println("删除的id:"+id);
        int count = carService.remove(id);
        return new ResponseEntity<>(new CustomType(200,"删除成功"),HttpStatus.OK);
    }
}
