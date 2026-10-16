package com.nuvora_business.backend.business.repository;

import com.nuvora_business.backend.business.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository
        extends JpaRepository<Business, Long> {
}