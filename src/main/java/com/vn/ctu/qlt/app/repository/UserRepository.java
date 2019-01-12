package com.vn.ctu.qlt.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vn.ctu.qlt.app.model.UserModel;

/**
 * @author NTDSIVAL
 * @Date Dec 27, 2018
 */
@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{

	@Query("select u from UserModel u where u.userName = :userName")
	public Optional<UserModel> findUserByUserName(@Param("userName") String userName);
	
	@Query("select u from UserModel u where u.userName = :userName")
	public Optional<UserModel> selectUserByUserName(@Param("userName") String userName);

}
