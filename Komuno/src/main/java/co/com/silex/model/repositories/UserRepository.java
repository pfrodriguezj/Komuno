package co.com.silex.model.repositories;

import org.springframework.data.repository.CrudRepository;

import co.com.silex.model.entity.User;


public interface UserRepository extends CrudRepository<User, Long>{

	User findOneByUsername(String username);
}

