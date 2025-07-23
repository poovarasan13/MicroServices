package com.kce.coupon_service.service;

import com.kce.coupon_service.entity.Coupon;

import java.util.List;

public interface CouponService {
    Coupon createCoupon(Coupon coupon);
    Coupon getCouponByCode(String couponCode);
    List<Coupon> getAllCoupons();
    Coupon updateCoupon(String id, Coupon coupon);
    void deleteCoupon(String id);
}

