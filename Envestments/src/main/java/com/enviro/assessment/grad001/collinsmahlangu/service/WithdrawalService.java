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
    private final InvestorRepo investorRepository;
    private final ProductRepo productRepository;

    @Autowired
    public WithdrawalService(InvestorRepo investorRepository, ProductRepo productRepository) {
        this.investorRepository = investorRepository;
        this.productRepository = productRepository;
    }

    public void createWithdrawalNotice(Long investorId, Long productId, double withdrawalAmount) {
        // Retrieve the investor and product
        Investor investor = investorRepository.findById(investorId).orElseThrow(() -> new IllegalArgumentException("Investor not found"));
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

        // Perform withdrawal logic and update database
        investor.setBalance(newBalance);
        investorRepository.save(investor)
        // the withdrawal process
              double newBalance = investor.getBalance() - withdrawalAmount;
    }
}
