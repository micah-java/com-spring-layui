package com.spring.layer;

import com.spring.layer.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.*;

@SpringBootTest
class ComSpringLayerApplicationTests {

    @Test
    void contextLoads() {
        Map<String,User> map = new HashMap<>();
        User user1 = new User(18,"1",18);
        User user2 = new User(18,"2",19);
        User user3 = new User(19,"3",22);
        User user4 = new User(20,"3",23);
        User user5 = new User(19,"3",21);
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);

        //mapping(User::new, toList())
        Map<Integer, List<User>> collect = list.stream().collect(groupingBy(User::getId));
        System.out.println(collect);
    }


    @Test
    void contextTest() {
        Pattern pattern = Pattern.compile("([a-z]{1,60})(\\.)?([a-z]{0,3})");
        String d = "baiducom";
        Matcher matcher = pattern.matcher(d);
        if (matcher.find()){
            String group1 = matcher.group(1);
            String group2 = matcher.group(2);
            String group3 = matcher.group(3);
            System.out.println(group1 + " " + group2 + " " + group3 );
        }
    }

}
