package com.nuvora_business.backend.business.service;

import com.nuvora_business.backend.business.dto.BusinessRequest;
import com.nuvora_business.backend.business.dto.BusinessResponse;
import com.nuvora_business.backend.business.entity.Business;
import com.nuvora_business.backend.business.repository.BusinessRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BusinessService {

    private final BusinessRepository repository;

    public BusinessService(BusinessRepository repository) {
        this.repository = repository;
    }

    public BusinessResponse create(BusinessRequest request) {
        Business business = new Business();

        business.setName(request.name().trim());
        business.setBusinessType(request.businessType().trim());
        business.setEmail(request.email());
        business.setPhone(request.phone());

        Business saved = repository.save(business);

        return toResponse(saved);
    }

    public List<BusinessResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public BusinessResponse findById(Long id) {
        Business business = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Business not found"
                ));

        return toResponse(business);
    }

    private BusinessResponse toResponse(Business business) {
        return new BusinessResponse(
                business.getId(),
                business.getName(),
                business.getBusinessType(),
                business.getEmail(),
                business.getPhone(),
                business.getCreatedAt()
        );
    }
}