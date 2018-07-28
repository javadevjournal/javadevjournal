package com.javadevjournal;

import com.javadevjournal.car.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderAnnotationTest {

    @Autowired
    private List<Car> cars;

    @Test
    public void test_spring_order_annotation(){

        assertThat(cars.get(0).getCarRecommendation(),is(equalTo("Toyota")));
        assertThat(cars.get(1).getCarRecommendation(),is(equalTo("Honda")));
        assertThat(cars.get(2).getCarRecommendation(),is(equalTo("Certified Car")));
    }
}
