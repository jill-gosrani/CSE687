package edu.syr.hw4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AnyOf.*;
import static org.hamcrest.core.Is.*;

import java.lang.reflect.Field;

public class RationalTest {

    public static Integer getNumerator(Rational r) {
        Field f;
        try {
            f = Rational.class.getDeclaredField("numer");
            f.setAccessible(true);
            int value = (int) f.get(r);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Integer getDenominator(Rational r) {
        Field f;
        try {
            f = Rational.class.getDeclaredField("denom");
            f.setAccessible(true);
            int value = (int) f.get(r);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Integer getGCD(Rational r) {
        Field f;
        try {
            f = Rational.class.getDeclaredField("g");
            f.setAccessible(true);
            int value = (int) f.get(r);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static double helper(Rational r) {
        double num = getNumerator(r);
        double denom = getDenominator(r);
        return num / denom;
    }

    @Test
    void testConstructor() {
        Rational r = new Rational(1, 10);
        assertEquals(0.1, helper(r), "base case");

        r = new Rational(-3, 10);
        assertEquals(-3.0/10.0, helper(r));

        r = new Rational(-3, -10);
        assertEquals(3.0/10.0, helper(r));

        r = new Rational(-10, 3);
        assertEquals(-10.0/3.0, helper(r));

        r = new Rational(10);
        assertEquals(10.0, helper(r));

        r = new Rational(0, 1);
        assertEquals(0.0, helper(r));

        try {
            r = new Rational(1, 0);
            assertNull("Divide by zero, Should not be reached");
        } catch (Exception e) {
            System.out.println(e);
        }

        r = new Rational(2, 6);
        assertEquals(2.0/6.0, helper(r));

        r = new Rational(-4, -10);
        assertEquals(-4.0/-10.0, helper(r));

        r = new Rational(-2, 6);
        assertEquals(-2.0/6.0, helper(r));

        r = new Rational(2, -6);
        assertEquals(2.0/-6.0, helper(r));
    }

    @Test
    void testToString() {
        Rational r = new Rational(2, 3);
        assertEquals("2/3", r.toString(), "base case");

        r = new Rational(-2, -3);
        assertThat(r.toString(), anyOf(is("-2/-3"), is("2/3")));

        r = new Rational(2, -3);
        assertThat(r.toString(), anyOf(is("2/-3"), is("-2/3")));

        r = new Rational(-2, 3);
        assertThat(r.toString(), anyOf(is("-2/3"), is("2/-3")));

        r = new Rational(3);
        assertThat(r.toString(), anyOf(is("3/1"), is("3")));

        r = new Rational(0, 1);
        assertThat(r.toString(), anyOf(is("0/1"), is("0")));

        r = new Rational(2, 4);
        assertThat(r.toString(), anyOf(is("1/2"), is("2/4")));

        r = new Rational(-2, 4);
        assertThat(r.toString(), anyOf(is("-1/2"), is("-2/4"), is("1/-2"), is("2/-4")));

        r = new Rational(2, -4);
        assertThat(r.toString(), anyOf(is("-1/2"), is("-2/4"), is("1/-2"), is("2/-4")));

        r = new Rational(-2, -4);
        assertThat(r.toString(), anyOf(is("-1/-2"), is("-2/-4"), is("1/2"), is("2/4")));
    }

    @Test
    void testAdd() {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(1, 2);
        Rational res = r1.add(r2);
        assertEquals(1.0, helper(res), "base case");

        r1 = new Rational(1, 3);
        r2 = new Rational(1, 2);
        res = r1.add(r2);
        assertEquals(5.0/6.0, helper(res));

        r1 = new Rational(1);
        r2 = new Rational(1);
        res = r1.add(r2);
        assertEquals(2.0, helper(res));

        r1 = new Rational(0);
        r2 = new Rational(0);
        res = r1.add(r2);
        assertEquals(0.0, helper(res));

        r1 = new Rational(-1, 3);
        r2 = new Rational(1, 2);
        res = r1.add(r2);
        assertEquals(1.0/6.0, helper(res));

        r1 = new Rational(-1, 3);
        r2 = new Rational(-1, 2);
        res = r1.add(r2);
        assertEquals(-5.0/6.0, helper(res));

        r1 = new Rational(1, Integer.MAX_VALUE);
        r2 = new Rational(1, Integer.MAX_VALUE);
        res = r1.add(r2);
        assertEquals(2.0/(double) Integer.MAX_VALUE, helper(res));

        r1 = new Rational(1, Integer.MAX_VALUE);
        r2 = new Rational(-1, Integer.MAX_VALUE);
        res = r1.add(r2);
        assertEquals(0.0, helper(res));

        r1 = new Rational(10, Integer.MAX_VALUE);
        r2 = new Rational(-1, Integer.MAX_VALUE);
        res = r1.add(r2);
        assertEquals(9.0/(double) Integer.MAX_VALUE, helper(res));
    }

    @Test
    void testLessThan() {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(1, 3);
        assertEquals(true, r2.lessThan(r1), "base case");
        assertEquals(false, r1.lessThan(r2), "base case");

        r1 = new Rational(-1, 2);
        r2 = new Rational(0);
        assertEquals(true, r1.lessThan(0));
        assertEquals(false, r2.lessThan(r1));

        r1 = new Rational(-1, 2);
        r2 = new Rational(-1, 3);
        assertEquals(true, r1.lessThan(r2));
        assertEquals(false, r2.lessThan(r1));

        r1 = new Rational(-1, 2);
        r2 = new Rational(1, 2);
        assertEquals(true, r1.lessThan(r2));
        assertEquals(false, r2.lessThan(r1));

        r1 = new Rational(-1, 2);
        r2 = new Rational(-1, 2);
        assertEquals(false, r1.lessThan(r2));
        assertEquals(false, r2.lessThan(r1));
    }

    @Test
    void testMax() {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(1, 3);
        assertEquals(1.0/2.0, helper(r1.max(r2)), "base case");
        assertEquals(1.0/2.0, helper(r2.max(r1)), "base case");

        r1 = new Rational(1, 2);
        r2 = new Rational(1, 2);
        assertEquals(1.0/2.0, helper(r1.max(r2)));
        assertEquals(1.0/2.0, helper(r2.max(r1)));

        r1 = new Rational(-1, 2);
        r2 = new Rational(0);
        assertEquals(0.0, helper(r1.max(r2)));
        assertEquals(0.0, helper(r2.max(r1)));

        r1 = new Rational(-1, 2);
        r2 = new Rational(-1, Integer.MAX_VALUE);
        assertEquals(-1.0/(double) Integer.MAX_VALUE, helper(r1.max(r2)));
        assertEquals(-1.0/(double) Integer.MAX_VALUE, helper(r2.max(r1)));

        r1 = new Rational(-1, 2);
        r2 = new Rational(1, 10);
        assertEquals(1.0/10.0, helper(r1.max(r2)));
        assertEquals(1.0/10.0, helper(r2.max(r1)));
    }
}