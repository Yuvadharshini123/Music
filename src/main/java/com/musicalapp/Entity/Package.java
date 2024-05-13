package com.musicalapp.Entity;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.Table;


@Entity
@Table(name="package_tb")
public class Package {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	
    @Column(name = "packageName")
	private int packageName;
    
	 @Column(name = "coins")
	 private int coins;
    
	@Column(name = "pDetails")
	private String packageDetails;

	@Column(name = "amount")
	private String amount;

	@Column(name = "validity")
	private LocalDate validity;
	
	
}
