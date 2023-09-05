/**
 *
 * @author thegearsh
 */

package com.enviro.assessment.grad001.collinsmahlangu.repository;

import com.enviro.assessment.grad001.collinsmahlangu.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepo extends JpaRepository<Product, Long> {
}