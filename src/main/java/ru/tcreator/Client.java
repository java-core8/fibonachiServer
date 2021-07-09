package ru.tcreator;

import java.io.*;
import java.net.Socket;

public class Client implements Runnable {
  protected final int PORT = 55353;
  protected final String HOST = "localhost";
  @Override
  public void run() {
    try(Socket socket = new Socket(HOST, PORT);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        PrintWriter terminal = new PrintWriter(new OutputStreamWriter(System.out));
        BufferedReader terminalReader = new BufferedReader(new InputStreamReader(System.in))
    ) {



      while (true) {
        String byServer = in.readLine();
        if(byServer != null) {
          terminal.write(byServer + "\n");
          terminal.flush();
          String byTerminal = terminalReader.readLine();
          out.write(byTerminal + "\n");
          out.flush();
        }

      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
