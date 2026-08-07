package com.thejoa703.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="POSTS")
@Getter @Setter
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="post_seq")
	@SequenceGenerator(name="post_seq",sequenceName="POST_SEQ",allocationSize=1)
	private Long id;
	
	
	
	
	@Column
	private boolean deleted = false;
	
	@Column(name="CREATE_AT",nullable=false)
	private LocalDateTime createdAt;
	@Column(name="UPDATE_AT",nullable=false)
	private LocalDateTime updatedAt;
	
	@Lob // 대용량 데이터 자바에서 처리 -clob,blob(이미지,파일,오디오,영상,,,)
	
	@Column(nullable=false)
	private String content;
	@PrePersist
	void onCreate() {
		this.createdAt=LocalDateTime.now();
		this.updatedAt=LocalDateTime.now();
	}
	
	@PreUpdate
	void onUpdate(){
		this.updatedAt=LocalDateTime.now();
	}
	
	//한 사람이 여러 글을 쓸 수 없다
	@ManyToOne
	@JoinColumn(name="APP_USER_ID",nullable=false)
	private AppUser user;
	
	
	
}
