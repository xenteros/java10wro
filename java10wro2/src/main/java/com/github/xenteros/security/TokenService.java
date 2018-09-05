package com.github.xenteros.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
@Transactional
class TokenService {

    private TokenRepository tokenRepository;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public TokenService(TokenRepository tokenRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.tokenRepository = tokenRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String createToken(String username) {
        User user = userRepository.findOneByUsername(username);
        if (user != null) {
            Token token = new Token(UUID.randomUUID().toString(), false, user);
            token = tokenRepository.save(token);
            return token.getToken();
        }
        return UUID.randomUUID().toString();
    }

    public void resetPassword(String tokenString, String password) {
        Token token = tokenRepository.findOneByToken(tokenString);
        if (token == null) {
            return;
        }
        token.getUser().setPassword(passwordEncoder.encode(password));
        token.setExpired(true);
        tokenRepository.save(token);
        Set<Token> tokens = tokenRepository.findAllByUserIdAndExpiredFalse(token.getUser().getId());
        tokens.forEach(t -> t.setExpired(true));
        tokenRepository.save(tokens);
    }
}
