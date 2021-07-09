package ru.tcreator;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
  protected final int PORT = 55353;
  @Override
  public void run() {
    try {
      ServerSocket serverSocket = new ServerSocket(PORT);
      Socket socket = serverSocket.accept();
      try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
      ) {
        Fib fib = new Fib();
        out.write("Привет. Введи число, а я тебе число в последовательности Фибоначчи\n");
        out.flush();
        while (true) {
          String byClientString = in.readLine();
          if (byClientString.endsWith("end")) {
            out.write("пока\n");
            out.flush();

            break;
          }
          try {
            int finInt = Integer.parseInt(byClientString);
            out.write("Я посчитал: " + fib.calculateFibIterate(finInt).toString() + "\n");
            out.flush();
          } catch (NumberFormatException numberFormatException) {
            out.write("Строка " + byClientString + " не может быть представлена числом\n");
            out.flush();
          }
        }

      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        socket.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
