package com.test.Inoteqia.Reposotories;

import com.test.Inoteqia.DTO.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository

public interface OTPRepository extends JpaRepository<OTP, Long> {
    Optional<OTP> findByIdentificationAndExpiredDateAfter(String identification, Date now);
}
