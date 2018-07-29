/* Problem Name is &&& Prime Factorization &&& PLEASE DO NOT REMOVE THIS LINE. */

import java.io.*;
import java.util.*;
import java.lang.*;

/**
 * Instructions to candidate.
 *  1) Run this code in the REPL to observe its behaviour. The
 *     execution entry point is main().
 *  2) Consider adding some additional tests in doTestsPass().
 *  3) Implement primeFactorization() correctly.
 *  4) If time permits, some possible follow-ups.
 */


public class Solution
{
  /**
   * Return an array containing prime numbers whose product is x
   * Examples:
   * primeFactorization( 6 ) == [2,3]
   * primeFactorization( 5 ) == [5]
   * primeFactorization( 12 ) == [2,2,3]
   */
  public static ArrayList<Integer> primeFactorization(int x)
  {
    ArrayList<Integer> factors = new ArrayList<Integer>();
    int temp = x;
   
    for(int i = 2; i <= temp; i++) {
      if(temp % i == 0 && isPrime(i)) {
        temp = temp/i;
        factors.add(i);
        i = 1;
      }
    }
    return factors;
  }
  
  
  public static boolean isPrime(int n) {
    if(n == 2 || n == 3) {
      return true;
    } else if(n % 2 == 0) {
      return false;
    }
    int sqrt = (int)Math.sqrt(n);
    for(int i = 3; i <= sqrt; i = i+2) {
      if(n%i != 0) {
        return false;
      }
    }
    return true;
  }
  /**
   * bool doTestsPass()
   * Runs various tests. Returns true if tests pass. Otherwise,
   * returns false.
   */
  public static boolean doTestsPass()
  {
  // todo: implement more tests, please
  // feel free to make testing more elegant
  ArrayList<ArrayList<Integer>> expected = new ArrayList<ArrayList<Integer>>();
  expected.add(new ArrayList<Integer>(Arrays.asList(2,3)));
  ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
  results.add(primeFactorization(6));
  
  expected.add(new ArrayList<Integer>(Arrays.asList(2,2,3)));
  results.add(primeFactorization(12));
  for( int i = 0; i<expected.size(); i++ )
  {
    if( !expected.get(i).equals(results.get(i)))
    {
        System.out.println("Test failed for index: " + i);
        return false;
    }
  }
  System.out.println("All tested passed");
  return true;
  };
  
  /**
   * Execution entry point.
   */
  public static void main(String args[])
  {
  doTestsPass();
  }
}