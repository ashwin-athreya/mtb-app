package com.cg.mts.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.cg.mts.entity.User;
import com.cg.mts.exception.UserCreationError;
import com.cg.mts.exception.UserNotFoundException;
import com.cg.mts.repository.IAdminRepository;
import com.cg.mts.validator.InputValidator;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class IAdminServiceImplTest {

    @Mock
    private IAdminRepository adminRepository;

    @Mock
    private InputValidator inputValidator;

    @InjectMocks
    private IAdminServiceImpl adminService;

    @Test
    void testRegisterAdmin() throws Exception {
        when(inputValidator.usernameValidator(Mockito.any())).thenReturn(true);
        when(inputValidator.passwordValidator(Mockito.any())).thenReturn(true);
        adminService.registerAdmin("username", "password");
        verify(adminRepository, times(1)).save(any(User.class));
    }

    @Test
    void testRegisterAdminInvalidUsername() throws Exception {
        when(inputValidator.usernameValidator(Mockito.any())).thenReturn(false);
        assertThrows(UserCreationError.class, () -> adminService.registerAdmin("username", "password"));
    }

    @Test
    void testRegisterAdminInvalidPassword() throws Exception {
        when(inputValidator.usernameValidator(Mockito.any())).thenReturn(true);
        when(inputValidator.passwordValidator(Mockito.any())).thenReturn(false);

        assertThrows(UserCreationError.class, () -> adminService.registerAdmin("username", "password"));
    }

    @Test
    void testRemoveAdmin() throws UserNotFoundException {
        when(adminRepository.findById(Mockito.any())).thenReturn(Optional.of(createDummyUser()));
        adminService.removeAdmin(123);
    }

    public static User createDummyUser() {
        User dummyUser = new User();
        dummyUser.setUsername("dummyUsername");
        dummyUser.setPassword("dummyPassword");
        dummyUser.setRole("USER");
        dummyUser.setCustomer(null);
        return dummyUser;
    }


    @Test
    void testRemoveAdminNotFound() {
        when(adminRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> adminService.removeAdmin(123));
    }
}
