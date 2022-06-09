package com.practicalunittesting.chp06.collections;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;

public class UserListTest {

    @Test
    public void shouldAddUserToList() {
        UserList users = new UserList();

        User user1 = mock(User.class);
        User user2 = mock(User.class);

        List<User> list1 = Arrays.asList(user1, user2);
        List<User> list2 = Arrays.asList(user2, user1);

        users.addUser(user1);
        users.addUser(user2);
        assertEquals(users.getUsers(), list1);
        assertNotEquals(users.getUsers(), list2);
    }
}