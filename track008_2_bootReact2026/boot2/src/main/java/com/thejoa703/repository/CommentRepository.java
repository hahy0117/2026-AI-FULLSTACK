package com.thejoa703.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
	//findBy 조건1 AND 조건2 
	//SELECT c FROM Comment WHERE c.post.id=:postId AND c.deleted=false
	List<Comment> findByPostIdAndDeletedFalse(Long postId);
	
	//삭제되지 않은 댓글 수 집계
	long countByPostIdAndDeletedFalse(Long postId);
	
}
