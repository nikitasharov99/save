package com.company.nikita;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void saveGame(String adress, GameProgress name) {
        try (FileOutputStream fos = new FileOutputStream(adress);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(name);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void zipFiles(String wayInFile, ArrayList<String> nameFiles) {
        //  for (String name : nameFiles) {
        try
                (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(wayInFile))) {

            for (String name : nameFiles) {

                FileInputStream fis = new FileInputStream(name);


                ZipEntry entry = new ZipEntry(name);
                zout.putNextEntry(entry);

                byte[] bytes = new byte[fis.available()];
                fis.read(bytes);
                fis.close();
                zout.write(bytes);
                zout.closeEntry();

                File fileDelete = new File(name);
                fileDelete.delete();

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        GameProgress save1 = new GameProgress(8, 3, 1, 10.9);
        GameProgress save2 = new GameProgress(2, 1, 6, 7.3);
        GameProgress save3 = new GameProgress(4, 8, 3, 156.5);

        File dir = new File ("");


    }
}
