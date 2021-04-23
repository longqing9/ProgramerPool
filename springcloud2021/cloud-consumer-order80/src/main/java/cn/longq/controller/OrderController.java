package cn.longq.controller;

import cn.longq.entities.CommonResult;
import cn.longq.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

//    @Autowired
    @Resource
    private RestTemplate template;

    @PostMapping("/payment/create")
    public CommonResult<Integer> create(Payment payment){
        return template.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return template.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);

    }



}
