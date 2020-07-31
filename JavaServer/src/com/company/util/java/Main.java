package com.company.util.java;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{

        ServerSocket ss = new ServerSocket(8000);
        Socket socket = ss.accept();
        InputStream inputStream = socket.getInputStream();
        Scanner scanner = new Scanner(inputStream);
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(outputStream,true);
//        pw.println(new Date());
        while (true) {
            if (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println("server:  "+line);
                pw.println(line);
            }
        }

    }
}
