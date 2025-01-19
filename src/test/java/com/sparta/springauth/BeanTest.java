package com.sparta.springauth;

import com.sparta.springauth.food.Food;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeanTest {

    // @Autowired Food food;
    // Food 구현체 두 개가 bean 등록되어 있어서 오류가 뜸

    // @Autowired Food pizza;
    // @Autowired Food chicken;
    // 기본적으로 빈 타입으로 지원하는데, 빈 타입이 없을 때는 이름으로 찾는다. chicken, pizza 등록하니까 오류 없음
    // 둘 다 빈으로 등록되어 있을 때, @Primary 어노테이션이 달린 구현체를 먼저 주입한다.
    // @Qualifier 찾아서 구현체를 주입할 수도 있다.
    // 우선 순위  @Qualifier > @Primary (Qualifier 호출할 때 무조건 지정해 줘야 함)
    @Autowired  @Qualifier("피자") Food food;

    @Test
    void 빈di테스트() {
        // pizza.eat();
        // chicken.eat();
        food.eat();
    }

}
