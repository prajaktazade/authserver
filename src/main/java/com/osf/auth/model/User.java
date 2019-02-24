package com.osf.auth.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Collection;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the CUSTOMER database table.
 * 
 */
@Entity(name="customer")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="customer_id")
	private long id;

	@Column(name="account_expired")
	private byte accountExpired;

	@Column(name="account_locked")
	private byte accountLocked;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Column(name="created_by")
	private String createdBy;

	private String email;

	private byte enabled;

	@Column(name="fb_customer")
	private int fbCustomer;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	private String password;

	@Column(name="password_expired")
	private byte passwordExpired;

	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="provider_id")
    @Enumerated(EnumType.STRING)
    
    private AuthProvider provider;

	private String role;

	@Column(name="system_password")
	private String systemPassword;

	@Column(name="tenant_id")
	private String tenantId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	@Column(name="updated_by")
	private String updatedBy;

	private String username;

	public User() {
	}

	public long getCustomerId() {
		return this.id;
	}

	public void setCustomerId(int customerId) {
		this.id = customerId;
	}

	public byte getAccountExpired() {
		return this.accountExpired;
	}

	public void setAccountExpired(byte accountExpired) {
		this.accountExpired = accountExpired;
	}

	public byte getAccountLocked() {
		return this.accountLocked;
	}

	public void setAccountLocked(byte accountLocked) {
		this.accountLocked = accountLocked;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getEnabled() {
		return this.enabled;
	}

	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}

	public int getFbCustomer() {
		return this.fbCustomer;
	}

	public void setFbCustomer(int fbCustomer) {
		this.fbCustomer = fbCustomer;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte getPasswordExpired() {
		return this.passwordExpired;
	}

	public void setPasswordExpired(byte passwordExpired) {
		this.passwordExpired = passwordExpired;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSystemPassword() {
		return this.systemPassword;
	}

	public void setSystemPassword(String systemPassword) {
		this.systemPassword = systemPassword;
	}

	public String getTenantId() {
		return this.tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public AuthProvider getProvider() {
		return provider;
	}

	public void setProvider(AuthProvider provider) {
		this.provider = provider;
	}
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "role_customer", joinColumns = {
			@JoinColumn(name = "customer_id", referencedColumnName = "customer_id") }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", referencedColumnName = "id") })
	private List<Role> roles;
	

	public List<Role> getRoles() {
		return roles;
	}

}