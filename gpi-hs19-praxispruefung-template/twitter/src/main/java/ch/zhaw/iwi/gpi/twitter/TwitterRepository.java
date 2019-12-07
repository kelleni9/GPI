package ch.zhaw.iwi.gpi.twitter;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TwitterRepository
 */
public interface TwitterRepository extends JpaRepository<Tweet,Long>{

    
}