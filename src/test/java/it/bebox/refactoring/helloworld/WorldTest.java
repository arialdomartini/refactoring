package it.bebox.refactoring.helloworld;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WorldTest {

    private World _sut;

    @Before
    public void BeforeClass()
    {
        _sut = new World();
    }

    @Test
    public void greetResultsInHello2() {

        assertEquals("Hello world!", _sut.greet()); }

}
