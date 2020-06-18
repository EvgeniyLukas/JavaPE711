package com.company.Lesson1;


import java.io.*;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;


public class IOExample {
    private static void inStream() {
        try {
            InputStream stream = new FileInputStream("input.txt");
            byte[] bytes = new byte[256];
            //byte[] bytes = new byte[stream.available()];//не рекомендую!!
            int count;
            while ((count = stream.read(bytes)) != -1) {
                String text = new String(bytes, 0, count, "utf8");
                System.out.println("text = " + text + " count = " + count);
            }
            stream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void outStream() {
        // 1 запись через try/catch/finally
//        OutputStream out = null;
//        try {
//            out = new FileOutputStream("input.txt");
//            String txt = "Hello from code";
//            out.write(txt.getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            if(out != null){
//                try {
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }


        // 2 запись через try with resources
        try (OutputStream out = new FileOutputStream("input.txt");) {
            String txt = "Hello from code";
            out.write(txt.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void byteIn() {
        InputStream in = new ByteArrayInputStream(new byte[]{43, 56, 85, 89});
    }

    public static void streamFromUrl() {
        try (InputStream in = new URL("https://itstep.dp.ua/ru").openStream();
             OutputStream out = new FileOutputStream("itstep.html");) {

            byte[] bytes = new byte[1024];
            int count;
            while ((count = in.read(bytes)) != -1) {
                out.write(bytes, 0, count);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        inStream();
        //outStream();
        //streamFromUrl();
    }

}
