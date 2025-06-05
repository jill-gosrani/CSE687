//Name : Pavan Pandya
//NEtId : pjpandya@syr.edu
//SU ID : 340197894

package edu.syr.hw4;

/* Adapted from Programming in Scala, Odersky */

public class Rational {
    private int numer;
    private int denom;
    private int g;
    private static final int ONE_CONSTANT = 1;
    private static final int NEG_ONE_CONSTANT = -1;
    public Rational(int n, int d) {
        if(d == 0) {
            throw new ArithmeticException("The Denominator cannot be 0");
        }
        g = gcd(n,d);
        if(n > 0 || d > 0 ) {
            this.numer = n / g;
            this.denom = d / g;

        } else {
            this.numer = (n * NEG_ONE_CONSTANT)/g;
            this.denom = (d * NEG_ONE_CONSTANT)/g;
        }

//        int sign = ((n < 0 ) ^ (d < 0)) ? -1 : 1;
//        n = Math.abs(n);
//        d = Math.abs(d);
//
//        this.g = gcd(n,d);
//        this.numer = (sign * n)/this.g;
//        this.denom = (sign * d)/this.g;
    }

    public Rational(int n) {
        this(n,ONE_CONSTANT);
    }

    @Override
    public String toString() {
        return this.numer + "/" + this.denom;
    }

    private int gcd(int n1, int n2) {
        if(n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }

    private int calculateNumberWithLCM(int numer, int lcm, int denom){
        return (numer * (lcm/denom));
    }
    public Rational add(Rational that) {
        if(this.denom == that.denom){
            return new Rational((this.numer + that.numer),this.denom);
        }
        int lcm = (this.denom * that.denom)/gcd(this.denom,that.denom);
        return new Rational((calculateNumberWithLCM(this.numer,lcm,this.denom) + calculateNumberWithLCM(that.numer,lcm,that.denom)), lcm);
    }

    public Rational add(int that) {
        return add(new Rational(that));
    }

    public boolean lessThan(Rational that) {
        if(this.denom == that.denom) {
            return (this.numer < that.numer);
        }
        int lcm = (this.denom * that.denom)/gcd(this.denom,that.denom);
        return (calculateNumberWithLCM(this.numer,lcm,this.denom) < calculateNumberWithLCM(that.numer,lcm,that.denom));
    }

    public boolean lessThan(int that) {
        return lessThan(new Rational(that));
    }

    public Rational max(Rational that) {
        return (this.lessThan(that)) ? that : this;
    }

    public Rational max(int that) {
        return new Rational(that);
    }

    public static void main(String[] args) {
        Rational half = new Rational(1, 2);
        Rational third = new Rational(1, 3);
        System.out.println(half.max(third)); // returns half; prints "1/2"
        System.out.println(third.max(half)); // returns half; prints "1/2"
        Rational result = half.add(third);
        Rational fiveSixths = new Rational(5, 6);
        System.out.println("are they the same object? " + (result == fiveSixths));
        System.out.println(fiveSixths.lessThan(result)); // false
        System.out.println(result.lessThan(fiveSixths)); // false
        Rational one = new Rational(1);
        Rational oneAndHalf = one.add(half);
        System.out.println(oneAndHalf); // prints "3/2";
        Rational fifteenOverTen = new Rational(15, 10);
        System.out.println(fifteenOverTen); // prints "3/2"

        Rational r = new Rational(6,-6); //prints "-1/1"
        System.out.println(r); //prints "-1/1"
        System.out.println(r.add(1));  //prints "0/1"
    }
}