package ru.tcreator;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    new Thread(new Server()).start();
    new Thread(new Client()).start();
  }
}
