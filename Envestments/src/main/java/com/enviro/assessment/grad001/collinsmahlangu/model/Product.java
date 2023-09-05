/**
 *
 * @author thegearsh
 */
package com.enviro.assessment.grad001.collinsmahlangu.model;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String name;
    private double balance;

    // Getters and setters

    public Object getType() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public double getBalance() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}