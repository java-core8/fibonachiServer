package ru.tcreator;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Fib fib = new Fib();
    System.out.println(fib.calculateFibIterate(200000));
  }
}
