/**
 *
 * @author thegearsh
 */
package com.enviro.assessment.grad001.collinsmahlangu.model;

import javax.persistence.*;


@Entity
public class Investor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String email;

    // Getters and setters

    public int getAge() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
