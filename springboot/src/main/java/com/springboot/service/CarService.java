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
        cars.add(new Car(1,"兰博基尼",11111d,new Date()));
        cars.add(new Car(2,"玛萨拉蒂",22222d,new Date()));
        cars.add(new Car(3,"宾利",33333d,new Date()));
        cars.add(new Car(4,"林肯加长",44444d,new Date()));
        cars.add(new Car(5,"阿斯顿马丁",55555d,new Date()));
        return  cars;
    }
}
