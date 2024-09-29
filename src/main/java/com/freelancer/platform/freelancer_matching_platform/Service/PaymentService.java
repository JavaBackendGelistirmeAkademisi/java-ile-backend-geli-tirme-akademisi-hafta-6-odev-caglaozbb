package com.freelancer.platform.freelancer_matching_platform.Service;

import com.freelancer.platform.freelancer_matching_platform.Entity.Payment;
import com.freelancer.platform.freelancer_matching_platform.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // Yeni ödeme ekleme
    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    // Tüm ödemeleri listeleme
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // ID ile ödeme bulma
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Ödeme bulunamadı"));
    }

    // Ödeme güncelleme
    public Payment updatePayment(Long id, Payment updatedPayment) {
        Payment existingPayment = getPaymentById(id);
        // Gerekli alanları güncelle...
        return paymentRepository.save(existingPayment);
    }

    // Ödeme silme
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}