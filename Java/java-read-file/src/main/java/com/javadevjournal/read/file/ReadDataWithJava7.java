package com.javadevjournal.read.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadDataWithJava7 {

    private static final String FILE_LOCATION = "src/main/resources/read_java_file.txt";

    public static void main(String[] args) {

        String output = readFileReadAllBytes(FILE_LOCATION);
        //System.out.println(output);

        output = readFileBufferReader(FILE_LOCATION);
        System.out.println(output);
    }

    /*
       Internal method to read the data from the file using readAllBytes method
     */
    private static String readFileReadAllBytes(final String path){

        // define a data holder to store the data read from the file
        String data="";
        try
        {
            data = new String ( Files.readAllBytes( Paths.get(path) ) );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return data;
    }

    /*
        Read files using the new Files class and BufferReader option
     */
    private static String readFileBufferReader(final String filePath){

        // define a data holder to store the data read from the file
       Path path = Paths.get(filePath);
        StringBuilder fileContent = new StringBuilder();
        try {

            BufferedReader br= Files.newBufferedReader(path);
            String line ;
            while ((line = br.readLine()) != null) {
                // perform your logic with the data
                fileContent.append(line);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return fileContent.toString();
    }
}
