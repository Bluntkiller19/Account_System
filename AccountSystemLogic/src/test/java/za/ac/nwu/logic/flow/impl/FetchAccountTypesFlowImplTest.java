package za.ac.nwu.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class FetchAccountTypesFlowImplTest {

    private FetchAccountTypesFlowImpl ClassToTest;

    @Before
    public void setUp() throws Exception {
        ClassToTest = new FetchAccountTypesFlowImpl(null);
    }

    @After
    public void tearDown() throws Exception {
        ClassToTest = null;
    }

    @Ignore
    @Test
    public void methodTest() {
        assertTrue(ClassToTest.methodTest());
    }
}