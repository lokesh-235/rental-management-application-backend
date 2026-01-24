package com.example.rentalManagement.dtos;

import com.example.rentalManagement.entities.User.Role;

public class SignupRequestDto {
	 private String fullName;
	    private String email;
	    private String phone;
	    private Role role;
	    private String passwordHash;
		public String getFullName() {
			return fullName;
		}
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public Role getRole() {
			return role;
		}
		public void setRole(Role role) {
			this.role = role;
		}
		public String getPasswordHash() {
			return passwordHash;
		}
		public void setPasswordHash(String passwordHash) {
			this.passwordHash = passwordHash;
		}
	    
		
	    
}
