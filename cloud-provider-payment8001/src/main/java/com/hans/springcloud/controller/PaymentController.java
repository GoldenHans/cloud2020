package com.hans.springcloud.controller;

import com.hans.springcloud.entities.CommonResult;
import com.hans.springcloud.entities.Payment;
import com.hans.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping(value="/payment/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        log.info("**********插入结果：" + result);

        if(result > 0){
            return new CommonResult(200,"插入成功", result);
        }else{
            return new CommonResult(444,"插入成功");
        }
    }

    @GetMapping(value="/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment != null){
            return new CommonResult(200,"查询成功", payment);
        }else{
            return new CommonResult(444,"没有对应记录,查询id："+id);
        }
    }
}