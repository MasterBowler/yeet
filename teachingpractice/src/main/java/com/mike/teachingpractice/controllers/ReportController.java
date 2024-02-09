package com.mike.teachingpractice.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.mike.teachingpractice.dtos.StudentReportDTO;
import com.mike.teachingpractice.models.StudentReport;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/report")
public class ReportController {

    @PostMapping("/student")
    public void createNewStudentReport(@RequestBody StudentReportDTO studentReportDTO) {
        // check if user is student
        // chek if data is valid
        // save to db
    }

}
