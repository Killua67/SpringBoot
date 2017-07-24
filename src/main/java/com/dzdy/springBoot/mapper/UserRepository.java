package com.dzdy.springBoot.mapper;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.dzdy.springBoot.domain.User;

/**
 * Hibernate 方式  JpaRepository
 * @author wangzhiyong
 *
 */
public interface UserRepository extends JpaRepository<User, Long>{
	//简单查询根据命名就可以实现
	 User findByUserName(String userName);
     User findByUserNameOrEmail(String username, String email);
     Long deleteById(Long id);
     Long countByUserName(String userName);
     List<User> findByEmailLike(String email);
     User findByUserNameIgnoreCase(String userName);
     List<User> findByUserNameOrderByEmailDesc(String email);
     //Pageable 中传入 页数、每页条数和排序规则
     Page<User> findByUserName(String userName,Pageable pageable);
//     User findFirstByOrderByLastnameAsc();
//     User findTopByOrderByAgeDesc();
//     Page<User> queryFirst10ByLastname(String lastname, Pageable pageable);
//     List<User> findFirst10ByLastname(String lastname, Sort sort);
//     List<User> findTop10ByLastname(String lastname, Pageable pageable);
     
     @Modifying
     @Query("update User u set u.userName = ?1 where u.id = ?2")
     int modifyByIdAndUserId(String  userName, Long id);
     	
     @Transactional
     @Modifying
     @Query("delete from User where id = :id")
     void deleteByUserId(@Param("id")Long id);
       
     @Transactional(timeout = 10)
     @Query("select u from User u where u.email = ?1")
     User findByEmailAddress(String emailAddress);
     
}
