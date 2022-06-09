package com.practicalunittesting.chp06.retrytest;

import org.junit.Test;

import static org.junit.Assert.*;

public class AtomicIdGeneratorTest {

    @Test
    public void nextId() {
        AtomicIdGenerator idGenerator = new AtomicIdGenerator();

        Long Id1 = idGenerator.nextId();
        Long Id2 = idGenerator.nextId();
        Long Id3 = idGenerator.nextId();
        Long Id4 = idGenerator.nextId();

        assertEquals(Id2, (Id1++));
        assertEquals(Id3, (Id2++));
        assertEquals(Id4, (Id3++));

    }
}