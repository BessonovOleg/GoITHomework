package ua.goit.homework511;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class MainCalculatorTest {

    @Test
    public void testUserPlus() throws Exception{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        MainCalculator mainCalculator = applicationContext.getBean("maincalculator",MainCalculator.class);
        mainCalculator.checkAndSetType("u");
        assertEquals("test 2plus2", "2 plus 2 = 4", mainCalculator.calculate("2plus2"));
    }

}