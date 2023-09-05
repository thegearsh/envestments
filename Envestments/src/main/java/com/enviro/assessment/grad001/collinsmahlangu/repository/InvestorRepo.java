/**
 *
 * @author thegearsh
 * 
 */

package com.enviro.assessment.grad001.collinsmahlangu.repository;

import com.enviro.assessment.grad001.collinsmahlangu.model.Investor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestorRepo extends JpaRepository<Investor, Long> {
}