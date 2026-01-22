package com.picpaysimplificado.repositories;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.domain.user.UserType;
import com.picpaysimplificado.dtos.UserDto;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("should get user by document")
    void findByDocumentSuccessCase1() {
        String document = "12345678901";
        UserDto data = new UserDto("john doe", "Test", "12345678901", document, new BigDecimal(10), "test@gmail.com", "4444", UserType.COMMON);
        this.createUser(data);

        Optional<User> result = this.userRepository.findByDocument(document);
        assertThat(result.isPresent()).isTrue();
    }

    @Test
    @DisplayName("should not get user from when document does not exist ")
    void findByDocumentSuccessCase2() {
        String document = "12345678901";
        Optional<User> result = this.userRepository.findByDocument(document);
        assertThat(result.isEmpty()).isTrue();
    }


    private User createUser(UserDto data) {
        User newUser = new User(data);
        this.entityManager.persist(newUser);
        return newUser;


    }
}