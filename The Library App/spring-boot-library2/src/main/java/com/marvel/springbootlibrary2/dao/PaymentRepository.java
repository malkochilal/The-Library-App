package com.marvel.springbootlibrary2.dao;

import com.marvel.springbootlibrary2.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    Payment findByUserEmail(String userEmail);
}
