package com.kbtg.bootcamp.posttest.controller;

import com.kbtg.bootcamp.posttest.dto.AdminRequestDto;
import com.kbtg.bootcamp.posttest.dto.AdminResponseDto;
import com.kbtg.bootcamp.posttest.service.AdminsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminsController {
    @Autowired
    private AdminsService adminService;

    @PostMapping("/lotteries")
    public ResponseEntity<AdminResponseDto> checkAdminRoles(@Valid @RequestBody AdminRequestDto requestDto) throws Exception {
        AdminResponseDto responseDto;
            this.adminService.validateAdminReq(requestDto);
            responseDto = this.adminService.createLottery(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

}