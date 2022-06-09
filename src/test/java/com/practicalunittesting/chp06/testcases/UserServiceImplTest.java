package com.practicalunittesting.chp06.testcases;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @Test
    public void assignPassword() {
        UserDAO userDAO = mock(UserDAO.class);
        SecurityService securityService = mock(SecurityService.class);
        when(securityService.md5("test")).thenReturn("098f6bcd4621d373cade4e832627b4f6");

        User user = mock(User.class);
        when(user.getPassword()).thenReturn("test");


        UserServiceImpl userService = new UserServiceImpl(userDAO, securityService);

        try {
            userService.assignPassword(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        verify(user).setPassword("098f6bcd4621d373cade4e832627b4f6");
        verify(userDAO).updateUser(user);
    }
}