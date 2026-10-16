package com.nuvora_business.backend.business.controller;


import com.nuvora_business.backend.business.dto.BusinessRequest;
import com.nuvora_business.backend.business.dto.BusinessResponse;
import com.nuvora_business.backend.business.service.BusinessService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/businesses")
public class BusinessController {

    private final BusinessService service;

    public BusinessController(BusinessService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BusinessResponse create(
            @Valid @RequestBody BusinessRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<BusinessResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public BusinessResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }
}