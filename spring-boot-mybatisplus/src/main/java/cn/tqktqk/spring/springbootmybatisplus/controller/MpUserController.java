package cn.tqktqk.spring.springbootmybatisplus.controller;


import cn.tqktqk.spring.springbootmybatisplus.service.IMpUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tuqikang
 * @since 2019-04-08
 */
@RestController
@RequestMapping("/mp-user")
public class MpUserController {

    @Autowired
    private IMpUserService userService;

    @GetMapping
    public void getUsers(){
        userService.list().stream().forEach(p->{
            System.out.println(p);
        });
    }
}
