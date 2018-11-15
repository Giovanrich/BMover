/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tel.bmover;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chiraran
 */
public class Test {

    public static void main(String[] args) {
        List<File> sr = new ArrayList<>();
        List<File> ds = new ArrayList<>();

        sr.add(new File("C:\\test1"));
        sr.add(new File("C:\\test2"));
        ds.add(new File("D:\\test1"));
        ds.add(new File("D:\\test2"));


        for (int i = 0; i < sr.size(); i++) {
            DirThread temp= new DirThread(sr.get(i), ds.get(i));
            temp.start();
        }
    }

}
