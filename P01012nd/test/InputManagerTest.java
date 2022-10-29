/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Strongest
 */
public class InputManagerTest {
    InputManager ip;
    
    public InputManagerTest() {
        ip = new InputManager();
    }

    @Test
    public void testGetInt() {
        int input = ip.getInt("input date", "error", 2, 5);
        int expected = 3;
        Assertions.assertEquals(expected, input);
    }

    @Test
    public void testGetString() {
    }

    @Test
    public void testGetDouble() {
    }

    @Test
    public void testGetDate() {
    }

    @Test
    public void testIsValidDate() {
    }

    @Test
    public void testCheckWantToUpdate() {
    }

    @Test
    public void testGetID() {
    }

    @Test
    public void testGetFirstName() {
    }

    @Test
    public void testGetLastName() {
    }

    @Test
    public void testGetPhone() {
    }

    @Test
    public void testGetEmail() {
    }

    @Test
    public void testGetAddress() {
    }

    @Test
    public void testGetDOB() {
    }

    @Test
    public void testGetSex() {
    }

    @Test
    public void testGetSalary() {
    }

    @Test
    public void testGetAgency() {
    }
    
}
