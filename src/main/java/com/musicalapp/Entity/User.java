package com.musicalapp.Entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;



@Entity
@Table(name = "User_table")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
	    
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="userId")
		  private Long id;
		
		 @Column(name="fname", length=255)
		  private String firstName;
		  
		  @Column(name="lname")
		  private String lastName;
		  
		  @Column(name="emailid",length=255)
		  private String emailId;
		
		  @Column(name="uname",length=255)
		  private String userName;
		  
		  @NonNull
			@Column(name = "userPassword")
			private String userPassword;
			
			
			 @ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
			  
			  @JoinTable(name="USER_ROLE", 
			         joinColumns= {
			        		 @JoinColumn(name="User_Id")
			        		 },
			         inverseJoinColumns= {
			        		 @JoinColumn(name="Role_Id")
			         }
					  )
			private Set<Role> role;

			
			
			public Set<Role> getRole() {
				return role;
			}

			public void setRole(Set<Role> role) {
				this.role = role;
			}

			public Long getId() {
				return id;
			}

			public void setId(Long id) {
				this.id = id;
			}

			public String getFirstName() {
				return firstName;
			}

			public void setFirstName(String firstName) {
				this.firstName = firstName;
			}

			public String getLastName() {
				return lastName;
			}

			public void setLastName(String lastName) {
				this.lastName = lastName;
			}

			public String getEmailId() {
				return emailId;
			}

			public void setEmailId(String emailId) {
				this.emailId = emailId;
			}

			public String getUserName() {
				return userName;
			}

			public void setUserName(String userName) {
				this.userName = userName;
			}

			public String getUserPassword() {
				return userPassword;
			}

			public void setUserPassword(String userPassword) {
				this.userPassword = userPassword;
			}
			
		
		  
}
