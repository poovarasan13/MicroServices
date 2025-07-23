package com.kce.order_service.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kce.order_service.response.CommonResponse;

@FeignClient(name = "ICECREAM-SERVICE")
public interface IceCreamFeign {
	 @GetMapping("/api/ice/{id}/{coupon}")
	    CommonResponse getFlavourWithCoupon(@PathVariable("id") String id, @PathVariable("coupon") String coupon);
}
