/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;

/**
 *
 * @author Strongest
 */
public class convertManagerTest {
    
    convertManager cv;
    
    public convertManagerTest() {
        cv = new convertManager();
    }

    @Test
    public void testConvertToDecimal() {
        String result = cv.convertToDecimal("1011011", 2);      
        String expected = "91";
        assertEquals(expected, result);
    }

    @Test
    public void testConvertDecimalToOther() {
        String result = cv.convertDecimalToOther("23", 2);
        String expected = "10111";
        assertEquals(expected, result);
    }
    
}
