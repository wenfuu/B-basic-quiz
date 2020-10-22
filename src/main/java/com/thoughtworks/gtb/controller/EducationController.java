package com.thoughtworks.gtb.controller;

import com.thoughtworks.gtb.model.Education;
import com.thoughtworks.gtb.service.EducationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users/{id}/educations")
public class EducationController {

    public final EducationService educationService;

    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }
//TODO GTB-完成度: - EducationController.java:20，Bug，给不存在的用户添加 education 也能成功，并且查找的时候也找不到
//TODO GTB-知识点: - EducationController.java:21 违反Restful实践，Post接口应返回创建成功的对象
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createEducation(@PathVariable Long id, @RequestBody @Valid Education education) {
        educationService.createEducation(id, education);
    }

    @GetMapping
    public List<Education>findEducationById(@PathVariable Long id) {
        return educationService.findEducation(id);
    }
}
