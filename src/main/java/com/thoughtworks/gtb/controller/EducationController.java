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
