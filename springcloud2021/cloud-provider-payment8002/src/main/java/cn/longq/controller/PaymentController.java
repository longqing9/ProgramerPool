package cn.longq.controller;


import cn.longq.entities.CommonResult;
import cn.longq.entities.Payment;
import cn.longq.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;


    @PostMapping("/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        log.info("查询开始{}-------",port);
        try {
            return  new CommonResult<>(0,port,paymentService.create(payment));
        }catch (Exception e){
            return  new CommonResult<>(1,e.getLocalizedMessage());
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        log.info("查询开始{}-------",port);
        try {
            return new CommonResult<>(0,port,paymentService.getPaymentById(id));
        }catch (Exception e){
            return new CommonResult<>(1,e.getMessage());
        }
    }



}
