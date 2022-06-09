package com.practicalunittesting.chp06.time;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class HelpDeskTest {

    @Test
    public void testHandleIssue() {
        // used a reference implementation to test since this implementation is time dependent
        Issue issue1 = mock(Issue.class);
        HelpDesk helpDesk = new HelpDesk();
        assertEquals(helpDesk.willHandleIssue(issue1), getReferenceValueOfOfficeIssueHandling());
    }

    private boolean getReferenceValueOfOfficeIssueHandling() {
        Calendar cal = Calendar.getInstance();
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (Calendar.SUNDAY == dayOfWeek || Calendar.SATURDAY == dayOfWeek) {
            return false;
        }
        if (Calendar.FRIDAY == dayOfWeek) {
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            return hour <= 17;
        }
        return true;
    }
}