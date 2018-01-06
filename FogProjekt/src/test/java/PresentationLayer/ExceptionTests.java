/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DataLayer.UserMapper;
import FunctionLayer.MessageException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Oliver
 */
public class ExceptionTests {

    public ExceptionTests() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test(expected = MessageException.class)
    public void checkIfUserDoesNotExist() throws MessageException {
        UserMapper.login("Afdsfdsf", "dsafadsf");
    }

    @Test
    public void checkIfUserExists() throws MessageException {
        UserMapper.login("AsgerSH@hotmail.com", "user");
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void checkForExceptionMessage() throws MessageException {
        expectedEx.expect(MessageException.class);
        expectedEx.expectMessage("Could not validate user");
        UserMapper.login("Afdsfdsf", "dsafadsf");
    }

}
