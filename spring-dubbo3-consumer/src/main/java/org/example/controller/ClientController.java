package org.example.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.example.entities.UserEntity;
import org.example.model.CommonResult;
import org.example.model.UserRequest;
import org.example.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/client/user")
public class ClientController {

    @DubboReference
    private UserService userService;

    @GetMapping("/{id}")
    public CommonResult getById(@PathVariable("id") Long id) {
        return new CommonResult(200, "success", userService.getById(id));
    }

    @GetMapping("/")
    public CommonResult getByCondition(@RequestParam(name = "search", required = false) String search) {
        return new CommonResult(200, "success", userService.getByCondition(search));
    }

    @PostMapping("/")
    public CommonResult save(@Validated @RequestBody UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userRequest, userEntity);
        Date date = new Date();
        userEntity.setCreateTime(date);
        userEntity.setUpdateTime(date);
        userService.save(userEntity);
        return new CommonResult(200, "success");
    }

    @DeleteMapping("/{id}")
    public CommonResult deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return new CommonResult(200, "success");
    }

}
