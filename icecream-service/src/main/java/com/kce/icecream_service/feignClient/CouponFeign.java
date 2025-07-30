package com.kce.icecream_service.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kce.icecream_service.dto.Coupon;

@FeignClient("coupon-service")
public interface CouponFeign {
    @GetMapping("/api/coupons/{code}")
    ResponseEntity<Coupon> getCouponByCode(@PathVariable String code);
}
