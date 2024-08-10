package com.sunbeam.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseEntity {

	// creation date
//	@Column(name = "created_on")
	@CreationTimestamp // adds creation date / time / time stamp for the entity
	private LocalDate createdOn;
	
	// updation time stamp
	@UpdateTimestamp // add last updated - date / time / time stamp for the entity
//	@Column(name = "updated_on")
	private LocalDateTime updatedOn;
	

}
