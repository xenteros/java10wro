package com.github.xenteros.security;

import org.springframework.data.repository.CrudRepository;

interface UserRepository extends CrudRepository<User, Long> {
    User findOneByUsername(String username);
    boolean existsByUsername(String username);
}
