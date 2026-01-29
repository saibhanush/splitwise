package com.scaler.splitwise;

import com.scaler.splitwise.dtos.CreateUserDto;
import com.scaler.splitwise.models.User;
import com.scaler.splitwise.repositories.UserRepository;
import com.scaler.splitwise.services.UserService;
import com.scaler.splitwise.services.interfaces.PasswordEncoder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository repository;

    @Mock
    private PasswordEncoder encoder;

    @InjectMocks
    private UserService userService;

    private CreateUserDto createUserDto;
    private User user;

    @BeforeEach
    void setUp() {
        createUserDto = new CreateUserDto();
        createUserDto.setHashedPassword("plainPassword");

        user = new User();
        user.setId(1L);
        user.setHashedPassword("hashedPassword");
    }

    @Test
    void createUser_shouldHashPasswordAndSaveUser() {
        // Arrange
        when(encoder.encode(anyString())).thenReturn("hashedPassword");
        when(repository.save(any(User.class))).thenReturn(user);

        // Act
        User result = userService.createUser(createUserDto);

        // Assert
        assertNotNull(result);
        assertEquals("hashedPassword", result.getHashedPassword());
        verify(encoder, times(1)).encode("plainPassword");
        verify(repository, times(1)).save(any(User.class));
    }


    @Test
    void createUser_shouldCallEncoderWithCorrectPassword() {
        // Arrange
        when(encoder.encode(anyString())).thenReturn("hashedPassword");
        when(repository.save(any(User.class))).thenReturn(user);

        // Act
        userService.createUser(createUserDto);

        // Assert
        verify(encoder).encode("plainPassword");
    }

    @Test
    void getUser_shouldReturnUserWhenExists() {
        // Arrange
        when(repository.findById(1L)).thenReturn(Optional.of(user));

        // Act
        User result = userService.getUser(1L);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void getUser_shouldReturnNullWhenUserDoesNotExist() {
        // Arrange
        when(repository.findById(1L)).thenReturn(Optional.empty());

        // Act
        User result = userService.getUser(1L);

        // Assert
        assertNull(result);
        verify(repository, times(1)).findById(1L);
    }
}
