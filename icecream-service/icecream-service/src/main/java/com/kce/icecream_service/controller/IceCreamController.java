package com.kce.icecream_service.controller;

import com.kce.icecream_service.dto.Coupon;
import com.kce.icecream_service.dto.FlavourDTO;
import com.kce.icecream_service.entity.ErrorDetails;
import com.kce.icecream_service.enumeration.ResponseStatus;
import com.kce.icecream_service.feignClient.CouponFeign;
import com.kce.icecream_service.model.Flavour;
import com.kce.icecream_service.response.CommonResponse;
import com.kce.icecream_service.service.impl.IceCreamServiceImpl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/ice")
public class IceCreamController {

    @Autowired
    private IceCreamServiceImpl iceCreamService;

    @PostMapping
    public ResponseEntity<CommonResponse> addFlavour(@RequestBody  Flavour flavour) {
        CommonResponse commonResponse = new CommonResponse();
       Flavour newfalvour =iceCreamService.addFlavour(flavour);
        if(newfalvour != null){
            commonResponse.setMessage("Successfully added flavour");
            commonResponse.setData(newfalvour);
            commonResponse.setStatus(ResponseStatus.SUCCESS);
            commonResponse.setStatusCode(200);
            return ResponseEntity.ok(commonResponse);
        }
        else{
            commonResponse.setMessage("Flavour not added");
            commonResponse.setData(flavour);
            commonResponse.setStatus(ResponseStatus.FAILED);
            commonResponse.setStatusCode(400);
            return ResponseEntity.badRequest().body(commonResponse);
        }
    }

    @GetMapping("all")
    public ResponseEntity<CommonResponse> getFlavour() {
        CommonResponse commonResponse = new CommonResponse();
        List<Flavour> list=iceCreamService.getFlavours();
        if (list.size() > 0) {
            commonResponse.setMessage("Successfully retrieved flavours");
            commonResponse.setData(list);
            commonResponse.setStatus(ResponseStatus.SUCCESS);
            commonResponse.setStatusCode(200);
            return ResponseEntity.ok(commonResponse);
        }
        else{
            commonResponse.setMessage("No Flavour Available ,Please add Flavour ");
            commonResponse.setData(list);
            commonResponse.setStatus(ResponseStatus.FAILED);
            commonResponse.setStatusCode(400);
            return ResponseEntity.badRequest().body(commonResponse);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonResponse> updateFlavour(@RequestBody  Flavour flavour,@PathVariable String id) {
        CommonResponse commonResponse = new CommonResponse();
        Flavour updateFlavour=iceCreamService.updateFlavour(flavour,id);
        if(updateFlavour != null){
            commonResponse.setMessage("Successfully updated flavour");
            commonResponse.setData(updateFlavour);
            commonResponse.setStatus(ResponseStatus.SUCCESS);
            commonResponse.setStatusCode(200);
            return ResponseEntity.ok(commonResponse);
        }
        else{
            commonResponse.setMessage("Flavour not updated");
            commonResponse.setData(updateFlavour);
            commonResponse.setStatus(ResponseStatus.FAILED);
            commonResponse.setStatusCode(400);
            return ResponseEntity.badRequest().body(commonResponse);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> getFlavour(@PathVariable String id) {
        CommonResponse commonResponse = new CommonResponse();
        Optional<Flavour> flavour =iceCreamService.getFlavour(id);
        if (flavour.isPresent()) {
            commonResponse.setMessage("Successfully retrieved flavour");
            commonResponse.setData(flavour);
            commonResponse.setStatus(ResponseStatus.SUCCESS);
            commonResponse.setStatusCode(200);
            return ResponseEntity.ok(commonResponse);

        }
        else{
            commonResponse.setMessage("Flavour not Available");
            commonResponse.setData(flavour);
            commonResponse.setStatus(ResponseStatus.FAILED);
            commonResponse.setStatusCode(400);
            return ResponseEntity.badRequest().body(commonResponse);
        }
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse> deleteFlavour(@PathVariable String id) {
        CommonResponse commonResponse = new CommonResponse();
        Optional<Flavour> flavour =iceCreamService.getFlavour(id);
        System.out.print(flavour);
        if (flavour.isPresent()) {
            iceCreamService.deleteFlavour(id);
            commonResponse.setMessage("Successfully deleted flavour");
            commonResponse.setData(flavour);
            commonResponse.setStatus(ResponseStatus.SUCCESS);
            commonResponse.setStatusCode(200);
            return ResponseEntity.ok(commonResponse);
        }
        else{
            commonResponse.setMessage("Flavour not Available");
            commonResponse.setData(flavour);
            commonResponse.setStatus(ResponseStatus.FAILED);
            commonResponse.setStatusCode(400);
            return ResponseEntity.badRequest().body(commonResponse);
        }
    }
    
   

    
    @Autowired
    private CouponFeign couponFeing;
    
    @CircuitBreaker(name = "icecream-service", fallbackMethod = "handleError")
    @GetMapping("/{id}/{coupon}")
    public ResponseEntity<CommonResponse> getFlavourByCoupon(@PathVariable String id,@PathVariable String coupon) {
        CommonResponse commonResponse = new CommonResponse();
        Optional<Flavour> flavour =iceCreamService.getFlavour(id);
        Coupon _coupon=couponFeing.getCouponByCode(coupon).getBody();
        
        flavour.get().setPrice(flavour.get().getPrice() - _coupon.getDiscount());
        if (flavour.isPresent()) {
            commonResponse.setMessage("Successfully retrieved flavour");
            commonResponse.setData(flavour);
            commonResponse.setStatus(ResponseStatus.SUCCESS);
            commonResponse.setStatusCode(200);
            return ResponseEntity.ok(commonResponse);

        }
        else{
            commonResponse.setMessage("Flavour not Available");
            commonResponse.setData(flavour);
            commonResponse.setStatus(ResponseStatus.FAILED);
            commonResponse.setStatusCode(400);
            return ResponseEntity.badRequest().body(commonResponse);
        }
    }
    public ResponseEntity<ErrorDetails> handleError(Exception ex) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), ex.getMessage());
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
