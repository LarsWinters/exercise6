package com.practicalunittesting.chp05;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    private UserDAO userDao = mock(UserDAO.class);
    private SecurityService securityService = mock(SecurityService.class);
    private UserServiceImpl userService = new UserServiceImpl(userDao, securityService);

    @Test
    public void userShouldGetNewPassword() throws Exception {
        User user = mock(User.class);

        when(user.getPassword()).thenReturn("Password1234");

        userService.assignPassword(user);
        verify(user).setPassword(any());
        verify(userDao).updateUser(user);
    }
}
