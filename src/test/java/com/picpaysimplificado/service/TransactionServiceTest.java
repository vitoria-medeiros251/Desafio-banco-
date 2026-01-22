package com.picpaysimplificado.service;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.domain.user.UserType;
import com.picpaysimplificado.dtos.TransactionDTO;
import com.picpaysimplificado.repositories.TransactionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TransactionServiceTest {
    @Mock
    private UserService userService;

    @Mock
    private TransactionRepository repository;

    @Mock
    private NotificationService notificationService;

    @Mock
    private AuthorizationService authorizationService;

    @InjectMocks
    private TransactionService transactionService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);

    }


    @Test
    @DisplayName("Should create a transaction successfully")
    void createTransactionCase1() throws Exception {
        User sender = new User(1L, "Maria", "Maria", "Souza", "12345678901", "maria@gmail.com", "123456", new BigDecimal(100), UserType.COMMON);
        User receiver = new User(2L, "João", "João", "Silva", "12345678902", "joao@gmail.com", "123456", new BigDecimal(100), UserType.COMMON);
        when(userService.findUserById(1L)).thenReturn(sender);
        when(userService.findUserById(2L)).thenReturn(receiver);

        when(authorizationService.authorizeTransaction(any(), any())).thenReturn(true);

        TransactionDTO request = new TransactionDTO(new BigDecimal(10), 1L, 2L);
        transactionService.createTransaction(request);

        verify(repository, times(1)).save(any());

        verify(userService, times(2)).saveUser(any());
        verify(notificationService, times(2)).sendNotification(any(), any());


    }

    @Test
    @DisplayName("Should throws exception when balance is insufficient")
    void createTransactionCase2() throws Exception{
        User sender = new User(1L, "Maria", "Maria", "Souza", "12345678901", "maria@gmail.com", "123456", new BigDecimal(100), UserType.COMMON);
        User receiver = new User(2L, "João", "João", "Silva", "12345678902", "joao@gmail.com", "123456", new BigDecimal(100), UserType.COMMON);
        when(userService.findUserById(1L)).thenReturn(sender);
        when(userService.findUserById(2L)).thenReturn(receiver);
        when(authorizationService.authorizeTransaction(any(), any())).thenReturn(false);

        Exception thrown = Assertions.assertThrows(Exception.class , () -> {
            TransactionDTO request = new TransactionDTO(new BigDecimal(19), 1l,2l);
            transactionService.createTransaction(request);

        });
        Assertions.assertEquals("transação nao autorizada",thrown.getMessage());

    }
}