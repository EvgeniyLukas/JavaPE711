package com.company.Lesson2.readwrite;

import java.io.*;
import java.util.Scanner;

public class ReaderWriter {
    public static void bufferedIO() {
        try (BufferedInputStream in =
                     new BufferedInputStream(new FileInputStream("input.txt"), 1024);) {
            byte[] buff = new byte[6];
            in.read(buff);
            System.out.println("string = " + new String(buff));
            in.mark(100);
            in.read(buff);
            System.out.println("string = " + new String(buff));
            in.reset();
            in.read(buff);
            System.out.println("string = " + new String(buff));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void charIO() {
        try (Reader reader = new FileReader("input.txt");
             BufferedReader br = new BufferedReader(reader, 256)) {
            //char[] buff = new char[256];
            //int count = reader.read(buff);
            //System.out.println("new String = " + new String(buff, 0, count));
            String str = br.readLine();
            System.out.println("str = " + str);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try (Writer writer = new FileWriter("output.txt")){
//            writer.write("Hello from writer");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }


    public static void scannerIO() throws FileNotFoundException {
        Scanner scanner = new Scanner("input.txt");
        System.out.println(scanner.nextLine());
        scanner.close();

        //System.out
        PrintStream printStream = new PrintStream("file.txt");
        printStream.println("It is println");
        printStream.close();

    }

    public static void main(String[] args) throws FileNotFoundException {
        //charIO();
        //bufferedIO();
        scannerIO();


    }
}
