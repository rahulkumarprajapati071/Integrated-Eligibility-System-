package in.glootech.admin.entity;

import java.time.LocalDate;

import javax.print.event.PrintJobAttributeEvent;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String fullName;
	private String email;
	private Long mobile;
	private String gender;
	private LocalDate dob;
	private long ssn;
	private Boolean activeStatus = false;
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate createDate;
	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDate updateDate;
}
