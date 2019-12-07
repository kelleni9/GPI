package ch.zhaw.iwi.gpi.userservice;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 */
public interface UserRepository extends JpaRepository<User,Long>{

    
}