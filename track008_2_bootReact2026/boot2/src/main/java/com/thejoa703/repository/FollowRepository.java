package com.thejoa703.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.Follow;


@Repository

public interface FollowRepository extends JpaRepository<Follow,Long> {
	//팔로우 단건 조회 -팔로워/팔로위 fineBy Optional<Follow>
	Optional<Follow>  findByFollower_IdAndFollowee_Id(Long followerId,Long followeeId);	
	
	
	//팔로잉 목록 조회
	//1)쿼리 1개 :findByFollower_Id(1L) 팔로잉 목록 10명 1
	//2)추가쿼리10개 
	@EntityGraph(attributePaths= {"followee"})
	List<Follow> findByFollower_Id(Long followerId);
	
	
	//팔로워 목록 조회
	@EntityGraph(attributePaths= {"follower"})
	List<Follow> findByFollowee_Id(Long followeeId);
	
	//팔로잉 수 집계
	long countByFollower_Id(Long followerId);
	//팔로워 수 집계
	long countByFollowee_Id(Long followeeId);
}
