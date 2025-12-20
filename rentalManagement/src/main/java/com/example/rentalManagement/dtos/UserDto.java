package com.example.rentalManagement.dtos;

import com.example.rentalManagement.entities.User.Role;

public class UserDto {
    private Long userId;
    private String fullName;
    private String email;
    private String phone;
    private Role role;
  
    
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
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
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;

	    UserDto userDto = (UserDto) o;

	    return userId != null && userId.equals(userDto.userId);
	}

	@Override
	public int hashCode() {
	    return userId != null ? userId.hashCode() : 0;
	}

    
}

