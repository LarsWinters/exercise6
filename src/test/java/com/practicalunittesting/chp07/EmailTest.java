package com.practicalunittesting.chp07;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class EmailTest {
    /**
     * Practical Unit Testing with JUnit and Mockito - source code for exercises.
     * Visit http://practicalunittesting.com for more information.
     *
     * @author Tomek Kaczanowski
     */
    Email mail1;
    //EmailServer server1;
    MailClient client1;

    @Before
    public void init(){
        mail1 = new Email("abc@def.com","Some Random Title", "Dear All,.......");
        //server1 = new EmailServer();
        client1 = new MailClient();
    }

    @Test
    public void createEmailObject() {
        //mail1 = new Email("abc@def.com","Some Random Title", "Dear All,.......");
        assertNotNull(mail1);
        //assertFalse(null == mail1);
        assertEquals(Email.class,mail1.getClass());
    }

    @Test
    public void createClientObject() {
        assertNotNull(client1);
        assertEquals(MailClient.class,client1.getClass());
    }

    @Test
    public void clientSendEmail() {
        client1.sendEmail("ppp@uuu.de","TitleTitleTitle", "Hello reciever,...");
    }

}


