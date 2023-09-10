package com.fastcampus.projectboard.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

	@CreatedDate
	@Column(nullable = false)
	private LocalDateTime createdAt; // 생성일시

	@CreatedBy
	@Column(nullable = false, length = 100)
	private String createdBy; // 생성자

	@LastModifiedDate
	@Column(nullable = false)
	private LocalDateTime modifiedAt; // 수정일시

	@LastModifiedBy
	@Column(nullable = false, length = 100)
	private String modifiedBy; // 수정자
}
