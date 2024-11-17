package com.asher;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.util.List;

@RequestMapping("/")
@RestController
public class Controller {
    @Resource
    private UserMapper userMapper;

    @GetMapping("/hi")
    public Object hello(){
        return "hi spring";
    }

    @PostMapping("addUser")
    public Object addUser(@RequestBody User user){
        int insertRes = userMapper.insert(user);
        if (insertRes == 1) {
            return true;

        }

        return false;
    }

    @GetMapping("/getAllUsers")
    public Object listUsers(){
        List<User> users = userMapper.selectList(null);
        return users;
    }
}
