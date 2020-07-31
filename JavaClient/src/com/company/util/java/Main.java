package com.company.util.java;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost",8000);
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(outputStream,true);

        Scanner io = new Scanner(socket.getInputStream());

        Scanner scanner = new Scanner(System.in);
        while (true)
            if(scanner.hasNext()){
                String cons = scanner.nextLine();
                System.out.println("client : "+ cons);
                pw.println( cons);
                System.out.println("server:  "+io.nextLine());
            }

    }
}
