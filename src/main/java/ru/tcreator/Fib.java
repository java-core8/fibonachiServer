package ru.tcreator;
import java.math.BigInteger;

public class Fib {

  public BigInteger calculateFibIterate(int fib) {
    if(fib == 0) return BigInteger.valueOf(0);
    BigInteger a1 = BigInteger.valueOf(0);
    BigInteger a2 = BigInteger.valueOf(1);
    for (int i = 0; i < fib - 1; i++) {
      BigInteger a3 = a1.add(a2);
      a1 = a2;
      a2 = a3;
    }
    return a2;
  }
}
