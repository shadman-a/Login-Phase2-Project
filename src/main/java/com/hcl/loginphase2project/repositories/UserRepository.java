package com.hcl.loginphase2project.repositories;

import com.hcl.loginphase2project.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}

