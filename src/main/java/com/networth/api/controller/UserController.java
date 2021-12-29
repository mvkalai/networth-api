package com.networth.api.controller;

import com.networth.api.common.Constants;
import com.networth.api.domain.Response;
import com.networth.api.entity.User;
import com.networth.api.enums.EStatusCode;
import com.networth.api.exception.ActionFailureException;
import com.networth.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Response<User>> addUser(@RequestBody User user)
            throws ActionFailureException {
        Response<User> response = new Response<>();
        response.setData(Arrays.asList(userService.addUser(user)));
        response.setStatusCode(EStatusCode.RECORD_ADDED_SUCCESSFULLY.name());
        response.setSuccessMessage(Constants.RECORD_ADDED_SUCCESSFULLY);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Response<User>> login(@RequestBody User user) throws ActionFailureException {
        Response<User> response = new Response<>();
        response.setData(Arrays.asList(userService.login(user)));
        response.setStatusCode(EStatusCode.SUCCESS.name());
        response.setSuccessMessage(Constants.SUCCESS);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<Response<User>> resetPassword(@RequestBody User user) throws ActionFailureException {
        Response<User> response = new Response<>();
        response.setData(Arrays.asList(userService.resetPassword(user)));
        response.setStatusCode(EStatusCode.RECORD_UPDATED_SUCCESSFULLY.name());
        response.setSuccessMessage(Constants.RECORD_UPDATED_SUCCESSFULLY);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<Response<User>> forgotPassword(String username) throws ActionFailureException {
        Response<User> response = new Response<>();
        response.setData(Arrays.asList(userService.forgetPassword(username)));
        response.setStatusCode(EStatusCode.SUCCESS.name());
        response.setSuccessMessage(Constants.SUCCESS);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
