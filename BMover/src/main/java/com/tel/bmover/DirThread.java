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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chiraran
 */
public class DirThread extends Thread {

    public File getSource() {
        return source;
    }

    public void setSource(File source) {
        this.source = source;
    }

    public File getTarget() {
        return target;
    }

    public void setTarget(File target) {
        this.target = target;
    }

    /**
     * @param source C:\test1
     * @param target D:\test1 When initialized, this class sets the paths as
     * above.
     */
    public DirThread(File source, File target) {
        this.source = source;
        this.target = target;
    }

    @Override
    public void run() {
        
        moveBakFiles(getBakFiles(source), source, target);
       
    }

    /**
     * @param dir - the directory to which the user wants to get a list of files
     * with specific extensions
     */
    private static List<File> getBakFiles(File dir) {
        List<File> files = new ArrayList<>();
        if (dir.isDirectory()) {
            files = Arrays.asList(dir.listFiles((d, name) -> name.endsWith(".mp4")));
        }
        return files;
    }

    /**
     * @param files - a list of files that need to be moved
     * @param sr - the source, in the form of C:\test1
     * @param ds - destination, in the form of D:test1
     */
    private static void moveBakFiles(List<File> files, File sr, File ds) {
        if (!files.isEmpty()) {
            for (File f : files) {
                String fName = f.getName();
                File source = new File(sr.toString() + "\\" + fName);
                File target = new File(ds.toString() + "\\" + fName);
                try {
                     System.out.println("Copying :"+source);
                    Files.copy(source.toPath(), target.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Completed copying: "+source);
                    //NEED TO LOG THE MESSAGE HERE
                } catch (IOException ex) {
                    Logger.getLogger(BMover.class.getName()).log(Level.SEVERE, null, ex);
                    //NEED TO LOG THE ERRORS HERE
                }

            }
        }

    }

    //Fields
    private File source;
    private File target;

}
