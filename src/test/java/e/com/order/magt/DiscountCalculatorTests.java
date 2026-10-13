//package e.com.order.magt;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import org.junit.jupiter.api.Test;
//
//public class DiscountCalculatorTests {
//
//	@Test
//	public void testCalculateDiscountRegular() {
//		int expect = 900;
//		DiscountCalculator calculator = new DiscountCalculator();
//		int actual = calculator.calculateDiscount(1000,"REGULAR", 10);
//		assertEquals(expect, actual);
//	}
//	@Test
//	public void testCalculateDiscountGold() {
//		int expect = 800;
//		DiscountCalculator calculator = new DiscountCalculator();
//		int actual = calculator.calculateDiscount(1000,"GOLD", 10);
//		assertEquals(expect, actual);
//	}
//	@Test
//	public void testCalculateDiscountPlatinum() {
//		int expect = 700;
//		DiscountCalculator calculator = new DiscountCalculator();
//		int actual = calculator.calculateDiscount(1000,"PLATINUM", 10);
//		assertEquals(expect, actual);
//	}
//	@Test
//	public void testCalculateDiscountUnknown() {
//		int expect = 1000;
//		DiscountCalculator calculator = new DiscountCalculator();
//		int actual = calculator.calculateDiscount(1000,"priminum", 10);
//		assertEquals(expect, actual);
//	}
//}


 
package e.com.order.magt;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DiscountCalculatorTests {

    DiscountCalculator calculator = new DiscountCalculator();

    @Test
    public void testRegularCustomer() {
        assertEquals(900,
                calculator.calculateDiscount(1000, "REGULAR", 10));
    }

    @Test
    public void testGoldCustomer() {
        assertEquals(800,
                calculator.calculateDiscount(1000, "GOLD", 10));
    }

    @Test
    public void testPlatinumCustomer() {
        assertEquals(700,
                calculator.calculateDiscount(1000, "PLATINUM", 10));
    }

    @Test
    public void testUnknownCustomerType() {
        assertEquals(1000,
                calculator.calculateDiscount(1000, "PREMIUM", 10));
    }

    @Test
    public void testZeroAmount() {
        assertEquals(0,
                calculator.calculateDiscount(0, "REGULAR", 10));
    }

    @Test
    public void testMinimumPositiveAmount() {
        assertEquals(1,
                calculator.calculateDiscount(1, "REGULAR", 10));
    }

    @Test
    public void testZeroPercentage() {
        assertEquals(1000,
                calculator.calculateDiscount(1000, "REGULAR", 0));
    }

    @Test
    public void testHundredPercent() {
        assertEquals(0,
                calculator.calculateDiscount(1000, "REGULAR", 100));
    }

    @Test
    public void testPercentageAboveHundred() {
        assertEquals(-100,
                calculator.calculateDiscount(1000, "REGULAR", 110));
    }

    @Test
    public void testNegativePercentage() {
        assertEquals(1100,
                calculator.calculateDiscount(1000, "REGULAR", -10));
    }

    @Test
    public void testNegativeAmount() {
        assertEquals(-900,
                calculator.calculateDiscount(-1000, "REGULAR", 10));
    }

    @Test
    public void testMaximumIntegerAmount() {
        assertEquals(Integer.MAX_VALUE,
                calculator.calculateDiscount(
                        Integer.MAX_VALUE, "REGULAR", 0));
    }

    @Test
    public void testMinimumIntegerAmount() {
        assertEquals(Integer.MIN_VALUE,
                calculator.calculateDiscount(
                        Integer.MIN_VALUE, "REGULAR", 0));
    }

    @Test
    public void testNullCustomerType() {
        assertThrows(NullPointerException.class,
                () -> calculator.calculateDiscount(1000, null, 10));
    }

    @Test
    public void testLowercaseCustomerType() {
        assertEquals(1000,
                calculator.calculateDiscount(1000, "regular", 10));
    }

    @Test
    public void testEmptyCustomerType() {
        assertEquals(1000,
                calculator.calculateDiscount(1000, "", 10));
    }

    @Test
    public void testAmountSmallerThanGoldDiscount() {
        assertEquals(-50,
                calculator.calculateDiscount(50, "GOLD", 0));
    }

    @Test
    public void testAmountSmallerThanPlatinumDiscount() {
        assertEquals(-100,
                calculator.calculateDiscount(100, "PLATINUM", 0));
    }

	/*
	 * @Test public void testIntegerMultiplicationOverflow() { assertEquals(0,
	 * calculator.calculateDiscount(50000, "REGULAR", 50000)); }
	 */
    @Test
    public void testGoldWithZeroAmount() {
        assertEquals(-100,
                calculator.calculateDiscount(0, "GOLD", 0));
    }

    @Test
    public void testPlatinumWithZeroAmount() {
        assertEquals(-200,
                calculator.calculateDiscount(0, "PLATINUM", 0));
    }
//    @Test
//    public void testPlatinumWithArithmaticException() {
//        assertEquals(-200,
//                calculator.calculateDiscount(0, "ZERO", 0));
//    }
//   
    
}
