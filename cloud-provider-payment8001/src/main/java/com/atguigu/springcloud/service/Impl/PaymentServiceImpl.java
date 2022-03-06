package com.atguigu.springcloud.service.Impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class PaymentServiceImpl implements PaymentService {


    @Resource
    private PaymentDao paymentDao;


    @Override
    public int save(Payment payment) {
        return paymentDao.save(payment);
    }

    @Override
    public List<Payment> selectPaymentBYId(Long id) {
        return paymentDao.selectPaymentBYId(id);
    }
}
