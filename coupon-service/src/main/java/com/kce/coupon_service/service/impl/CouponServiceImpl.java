package com.kce.coupon_service.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kce.coupon_service.entity.Coupon;
import com.kce.coupon_service.repository.CouponRepository;
import com.kce.coupon_service.service.CouponService;

@Service
public class CouponServiceImpl implements  CouponService  {

	@Autowired
    private CouponRepository couponRepository;

    @Override
    public Coupon createCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    @Override
    public Coupon getCouponByCode(String couponCode) {
        return couponRepository.findByCouponCode(couponCode);
    }

    @Override
    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    @Override
    public Coupon updateCoupon(String id, Coupon coupon) {
        Optional<Coupon> existing = couponRepository.findById(id);
        if (existing.isPresent()) {
            Coupon updated = existing.get();
            updated.setCouponCode(coupon.getCouponCode());
            updated.setDiscount(coupon.getDiscount());
            return couponRepository.save(updated);
        }
        return null;
    }

    @Override
    public void deleteCoupon(String id) {
        couponRepository.deleteById(id);
    }
	

}
