/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tel.bmover;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chiraran
 */
public class BMover {

    public static void main(String[] args) {
//        File source = new File("\\\\192.1.1.47\\e\\SunSystemsSecurity\\test.txt");
//        File destination = new File("D:\\mv\\test.txt");
//        try {
//            Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException ex) {
//            Logger.getLogger(BMover.class.getName()).log(Level.SEVERE, null, ex);
//        }

//        String[] directories = {
//            "Test1",
//            "Test2"};
//        
//        File dir = new File("\\\\\\\\192.1.1.47\\\\e\\\\SunSystemsSecurity");
//        File[] files = dir.listFiles((d, name) -> name.endsWith(".bak"));
        List<File> dirs = getBakFiles(new File("C:\\test1"));
        for (File f : dirs) {
            System.out.println(f.getName());
        }
        
        moveBakFiles(getBakFiles(new File("C:\\test1")), new File("C:\\test1"),  new File("D:\\test1"));
    }

    private static List<File> getBakFiles(File dir) {
        List<File> files = Arrays.asList(dir.listFiles((d, name) -> name.endsWith(".txt")));
        return files;
    }

    private static void moveBakFiles(List<File> files, File sr, File ds) {
        if (!files.isEmpty()) {
            for (File f : files) {
                String fName = f.getName();
                File source=new File(sr.toString()+"\\"+fName);
                File target=new File(ds.toString()+"\\"+fName);
                System.out.println(source);
                System.out.println(target);
                try {
               Files.copy(source.toPath(), target.toPath(),StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException ex) {
                    Logger.getLogger(BMover.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

    }

}
