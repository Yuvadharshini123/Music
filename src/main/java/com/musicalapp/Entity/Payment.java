package com.musicalapp.Entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;




@Entity
@Table(name = "Paymenttb")
public class Payment {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "purchaseCourseId")
	private int purchaseId;

	@JoinColumn(name = "user_id")
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
    
	@Column(name = "payment_info")
	private String paymentInfo;

	@Column(name = "paymentStatus")
	private String paymentStatus;


	@Column(name = "paymentDate")
	private LocalDate paymentDate;


	public int getPurchaseId() {
		return purchaseId;
	}


	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}


	public String getPaymentInfo() {
		return paymentInfo;
	}


	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}


	public String getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	public LocalDate getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
     
	
}
