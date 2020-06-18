package com.company.Lesson2.readwrite;


import java.io.*;

public class PointEx {
    int x;
    int y;

    @Override
    public String toString() {
        return "PointEx{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Test {

    //этот обьект не сериализуется
    private transient PointEx pointEx;

    public static void dataOut(PointEx point) {
        try (OutputStream out = new FileOutputStream("point.dat")) {
            //сериализация состояния объекта
            DataOutput dataOutput = new DataOutputStream(out);
            dataOutput.writeInt(point.x);
            dataOutput.writeInt(point.y);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dataInput(PointEx point) {
        try (InputStream in = new FileInputStream("point.dat")) {
            //десериализация состояния объекта
            DataInput dataInput = new DataInputStream(in);
            point.x = dataInput.readInt();
            point.y = dataInput.readInt();
            System.out.println("Readed point = " + point);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        PointEx point = new PointEx();
        point.x = 10;
        point.y = 20;
        System.out.println("point1 = " + point);
        dataOut(point);//сохранияем состояние обьекта
        point.x = 1000;
        point.y = 2000;
        System.out.println("point2 = " + point);
        dataInput(point);
    }


}