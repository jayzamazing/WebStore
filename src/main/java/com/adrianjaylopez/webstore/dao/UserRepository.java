package com.adrianjaylopez.webstore.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * @author Adrian J Lopez
 * @version 1.0
 * @since <pre>11/12/15</pre>
 */
@Component
public interface UserRepository extends CrudRepository<User, Long>{

    User findByUsername(String username);

}
