package com.kce.coupon_service.repository;

import com.kce.coupon_service.entity.Coupon;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CouponRepository extends MongoRepository<Coupon, String> {
    Coupon findByCouponCode(String couponCode);
}
