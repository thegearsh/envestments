/**
 *
 * @author thegearsh
 */
package com.enviro.assessment.grad001.collinsmahlangu.controller;

import com.enviro.assessment.grad001.collinsmahlangu.service.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/withdrawal")
public class WithdrawalController {
    private final WithdrawalService withdrawalService;

    @Autowired
    public WithdrawalController(WithdrawalService withdrawalService) {
        this.withdrawalService = withdrawalService;
    }

    @PostMapping("/create")
    public void createWithdrawalNotice(
            @RequestParam Long investorId,
            @RequestParam Long productId,
            @RequestParam double withdrawalAmount) {
        withdrawalService.createWithdrawalNotice(investorId, productId, withdrawalAmount);
    }
}
