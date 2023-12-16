package edu.Sim3LR5.controller;

import edu.Sim3LR5.model.*;
import edu.Sim3LR5.service.Interface.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
public class MyController {

    private final ResponseException responseException;

    @Autowired
    public MyController(ResponseException responseException){
        this.responseException=responseException;
    }

    @PostMapping(value = "/feedback")
    public void feedback(@Valid @RequestBody Request request, BindingResult bindingResult) {
        log.info("request:{}",request);
        responseException.ResponseExceptions(request,bindingResult);
    }
}