package com.github.xenteros.security;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
interface TokenRepository  extends CrudRepository<Token, Long> {

    Set<Token> findAllByUserIdAndExpiredFalse(Long userId);
    Token findOneByToken(String token);
}
