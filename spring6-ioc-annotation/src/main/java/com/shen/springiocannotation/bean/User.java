package com.shen.springiocannotation.bean;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * 使用注解定义bean
 */

//四种注解作用相同，只不过使用场景不同
@Component(value = "user") //<bean id = "user" class=""/>
//@Service
//@Repository
//@Controller
public class User {
}
