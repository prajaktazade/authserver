package com.osf.auth.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = -8561591765573087707L;

	public BaseEntity() {
	}

	@Column(name = "created_at", updatable = false)
	//@Audited
	private Date createdAt;

	@Column(name = "updated_at")
	//@Audited
	private Date updatedAt;

	@Column(name = "created_by")
	//@Audited
	private String createdBy;

	@Column(name = "updated_by")
	//@Audited
	private String updatedBy;

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@PrePersist
	public void onCreate() {
		String cretaedBy = this.getCreatedBy();
		if(cretaedBy == null || cretaedBy.equals("")){
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        String username = authentication.getName();
			this.setCreatedBy(username);
		}
		this.setCreatedAt(Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTime());
		this.setUpdatedAt(Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTime());			
	}

	@PreUpdate
	public void onUpdate() {		
		String updatedBy = this.getUpdatedBy();
		if(updatedBy == null || updatedBy.equals("")){
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        String username = authentication.getName();
			this.setUpdatedBy(username);
		}	
		this.setUpdatedAt(Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTime());
	}


}
