/**
 *
 * @author thegearsh
 */
package com.enviro.assessment.grad001.collinsmahlangu.service;

import com.enviro.assessment.grad001.collinsmahlangu.model.Investor;
import com.enviro.assessment.grad001.collinsmahlangu.model.Product;
import com.enviro.assessment.grad001.collinsmahlangu.repository.InvestorRepo;
import com.enviro.assessment.grad001.collinsmahlangu.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class WithdrawalService  {
    private final InvestorRepo investorRepo;
    private final ProductRepo productRepo;

    @Autowired
    public WithdrawalService(InvestorRepo investorRepo, ProductRepo productRepo) {
        this.investorRepo = investorRepo;
        this.productRepo = productRepo;
    }

    public void createWithdrawalNotice(Long investorId, Long productId, double withdrawalAmount) {
        // Retrieve the investor and product
        Investor investor = investorRepo.findById(investorId).orElseThrow(() -> new IllegalArgumentException("Investor not found"));
        Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("Product not found"));

        // Validate withdrawal conditions
        if ("RETIREMENT".equals(product.getType()) && investor.getAge() <= 65) {
            throw new IllegalArgumentException("Investor does not meet withdrawal age requirement");
        }

        if (withdrawalAmount > product.getBalance()) {
            throw new IllegalArgumentException("Withdrawal amount exceeds product balance");
        }

        if (withdrawalAmount > (0.9 * product.getBalance())) {
            throw new IllegalArgumentException("Withdrawal amount exceeds 90% of product balance");
        }

        //update database
        investor.setBalance(newBalance);
        investorRepository.save(investor);
        
        double newBalance = investor.getBalance() - withdrawalAmount;
    }
}
