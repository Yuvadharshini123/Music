package com.musicalapp.Dto;



public class UserDto {
	
			  private Long id;
			
			  private String firstName;
			  
			  private String lastName;
			  
			  private String emailId;
			
			  private String userName;
			  
			  private String userPassword;

			public UserDto(Long id, String firstName, String lastName, String emailId, String userName,
					String userPassword) {
				super();
				this.id = id;
				this.firstName = firstName;
				this.lastName = lastName;
				this.emailId = emailId;
				this.userName = userName;
				this.userPassword = userPassword;
			}

			public UserDto() {
				super();
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

			@Override
			public String toString() {
				return "UserDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
						+ emailId + ", userName=" + userName + ", userPassword=" + userPassword + "]";
			}
			
             
}
