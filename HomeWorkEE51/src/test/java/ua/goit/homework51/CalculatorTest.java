package ua.goit.homework51;



import org.junit.Ignore;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void testIntegerAdd() throws Exception {
        Calculator c = new Calculator();
        assertEquals("test 2+2", "2 + 2 = 4", c.getIntegerResult("2+2"));
    }

    @Test
    public void testIntegerSub() throws Exception {
        Calculator c = new Calculator();
        assertEquals("test 7-2", "7 - 2 = 5", c.getIntegerResult("7-2"));
    }

    @Test
    public void testLongAdd() throws Exception {
        Calculator c = new Calculator();
        assertEquals("test 7000000000+2000000000", "7000000000 + 2000000000 = 9000000000", c.getLongResult("7000000000+2000000000"));
    }

    @Test
    public void testLongSub() throws Exception {
        Calculator c = new Calculator();
        assertEquals("test 7000000000-2000000000", "7000000000 - 2000000000 = 5000000000", c.getLongResult("7000000000-2000000000"));
    }

    @Test
    public void testFloatAdd() throws Exception {
        Calculator c = new Calculator();
        assertEquals("test 7.2+2.2", "7.2 + 2.2 = 9.4", c.getFloatResult("7.2+2.2"));
    }

    @Test
    public void testFloatSub() throws Exception {
        Calculator c = new Calculator();
        assertEquals("test 7.2-2.2", "7.2 - 2.2 = 5.0", c.getFloatResult("7.2-2.2"));
    }

    @Test
    public void testDoubleAdd() throws Exception {
        Calculator c = new Calculator();
        assertEquals("test 7.22222222222222+2.22222222222222", "7.22222222222222 + 2.22222222222222 = 9.44444444444444", c.getDoubleResult("7.22222222222222+2.22222222222222"));
    }

    @Test
    public void testDoubleSub() throws Exception {
        Calculator c = new Calculator();
        assertEquals("test 7.22222222222222-2.11111111111111", "7.22222222222222 - 2.11111111111111 = 5.11111111111111", c.getDoubleResult("7.22222222222222-2.11111111111111"));
    }


    @Test
    @Ignore
    public void testUserType() throws Exception {
        Calculator c = new Calculator();
        IOperation OpDateAdd = new IOperation() {
            public String calc(Object var1, Object var2) {
                String res = String.valueOf(java.sql.Date.valueOf(var1.toString()).getTime() + java.sql.Date.valueOf(var2.toString()).getTime());
                return null;
            }
        };

        c.addOperation(Calculator.ADD_USER_TYPE,"dat+",OpDateAdd);

       assertEquals("user type test","20160501 dat+ 20160601 = 20170101",c.getUserTypeResult("20160501 dat+ 20160601"));
    }


}

