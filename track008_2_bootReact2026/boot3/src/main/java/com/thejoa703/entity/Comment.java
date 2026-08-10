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
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table( name="comments")
public class Comment {
	
	
	
	@Id // 기본키 primary 키 붙히기
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_seq")
	@SequenceGenerator(name="comment_seq", sequenceName = "COMMENT_SEQ", allocationSize = 1)
	private Long id;
	
	@Lob
	@Column(nullable=false)
	private String content; //게시글 내용(간텍스트)
	
	@Column
	boolean deleted=false;
	
	
	@Column(name="CREATED_AT",nullable=false)
	LocalDateTime createdAt; 
	
	@Column(name="UPDATE_AT",nullable=false)
	LocalDateTime updatedAt; 
	
	@PrePersist
	void onCreate() {
		this.createdAt=LocalDateTime.now();
		this.updatedAt=LocalDateTime.now();
	}
	
	
	@PreUpdate
	void onupdate() {
		this.updatedAt=LocalDateTime.now();
	}
	
	@ManyToOne
	@JoinColumn(name="APP_USER_ID",nullable=false)
	AppUser user;
	
	
	
	@ManyToOne
	@JoinColumn(name="POST_ID",nullable=false)
	 Post post;
	

	
}
