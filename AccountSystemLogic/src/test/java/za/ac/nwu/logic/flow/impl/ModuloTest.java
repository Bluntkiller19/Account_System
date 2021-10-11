package za.ac.nwu.logic.flow.impl;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class ModuloTest {

    private Modulo mod;

    @Before
    public void seUp() throws Exception{
        mod = new Modulo();
    }

    @Test
    public void testModBy0() {
        try {
            Integer result = mod.doMod(9, 0);
            fail("should throw an exception ");
        } catch (Exception e) {
            assertTrue("Error massage not as expected",e.getMessage().equalsIgnoreCase("Some reason for this?????"));
        }
    }

    @Test
    public void testMod(){
        Integer result = mod.doMod(9, 5);
        assertNotNull("Should not be null", result);
        assertEquals("should be value 4", 4, result.intValue());
    }


}
