// Name: Pavan Pandya
// Net Id: pjpandya
// SU ID: 340197894

package edu.syr.hw5;

import java.util.List;
import java.util.ArrayList;
public class Rational {
    private int numer;
    private int denom;
    private int g;
    private List<Integer> gc;
    public static Rational[] cache;
    public static int counter;
    private static final int ONE_CONSTANT = 1;
    private static final int NEGATIVE_ONE_CONSTANT = -1;
    private static final int CACHE_SIZE = 2;

    static{
        counter = 0;
        cache = new Rational[CACHE_SIZE];
    }
    public Rational(int n, int d,int gc) {
        this.gc = new ArrayList<>();
        if (d == 0) {
            throw new IllegalArgumentException("Denominator can't be 0!");
        }
        this.gc.add(gc);
        g = gcd(n, d);
        numer = n/g;
        denom = d/g;
    }

    public Rational(int n) {
        this(n, 1, ONE_CONSTANT);
    }

    public void addGCDInList(int gc){
        this.gc.add(gc);
    }
    public static Rational getInstance(int n,int d){
        int gcd = 0;
        if(n<0 && d <0){
            n = (n * NEGATIVE_ONE_CONSTANT);
            d = (d * NEGATIVE_ONE_CONSTANT);
        }
        if (d == 0) {
            throw new IllegalArgumentException("Denominator can't be 0!");
        }
        gcd = Rational.gcd(n, d);
        n = n/gcd;
        d = d/gcd;
        for (int i=0;i<cache.length;i++){
            Rational rational = cache[i];
            if(rational != null){
                if(rational.numer == n && rational.denom == d){
                    if(!rational.gc.contains(gcd))
                        rational.addGCDInList(gcd);
                    return rational;
                }
            }
        }
        Rational r = new Rational(n,d,gcd);
        cache[(counter++)%CACHE_SIZE] = r;
        return r;
    }
    public static Rational getInstance(int n){
        return Rational.getInstance(n,ONE_CONSTANT);
    }

    private static int gcd(int n, int d) {
        return d==0 ? n : gcd(d, n%d);
    }

    private static void printCache(){
        for (Rational rational : cache) {
            System.out.println(rational + "--");
        }
    }
    @Override
    public String toString() {
        return denom==1 ? numer +"" : numer + "/" + denom;
    }

    public Rational add(Rational that) {
        return Rational.getInstance(numer * that.denom + denom * that.numer, denom * that.denom);
    }

    public Rational add(int that) {
        return add(new Rational(that));
    }

    public boolean lessThan(Rational that) {
        return this.numer * that.denom < that.numer * this.denom;
    }

    public boolean lessThan(int that) {
        return lessThan(new Rational(that));
    }

    public Rational max(Rational that) {
        return this.lessThan(that) ? that : this;
    }

    public Rational max(int that) {
        return max(new Rational(that));
    }

    public static void main(String[] args) {
        Rational half = Rational.getInstance(1, 2);
        Rational third = Rational.getInstance(1, 3);
        System.out.println(half.max(third)); // returns half; prints "1/2"
        System.out.println(third.max(half)); // returns half; prints "1/2"
        Rational result = half.add(third);
        Rational fiveSixths = Rational.getInstance(5, 6);
        System.out.println("are they the same object? " + (result == fiveSixths));
        System.out.println(fiveSixths.lessThan(result)); // false
        System.out.println(result.lessThan(fiveSixths)); // false
        Rational one = Rational.getInstance(1);
        Rational oneAndHalf = one.add(half);
        System.out.println(oneAndHalf); // prints "3/2";
        Rational fifteenOverTen = Rational.getInstance(15, 10);
        System.out.println(fifteenOverTen); // prints "3/2"
    }
}
