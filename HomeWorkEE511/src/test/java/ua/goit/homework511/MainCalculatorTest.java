package ua.goit.homework511;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.goit.homework51.Calculator;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

public class MainCalculatorTest {

    @Test
    public void testUserPlus() throws Exception{
        Calculator c = new Calculator();
        MainCalculator mc = new MainCalculator(c);
//        mc.execute();
        //System.out.println("2plus2");
        //assertEquals("test 2plus2", "2 plus 2 = 4",  System.out.toString());
    }


}