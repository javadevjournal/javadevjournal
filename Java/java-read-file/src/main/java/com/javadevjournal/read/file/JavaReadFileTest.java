package com.javadevjournal.read.file;

import java.io.IOException;

public class JavaReadFileTest {

    public static void main(String[] args) throws IOException {

        JavaReaderFiles readFile = new JavaReaderFiles();

        // read using buffer reader
        readFile.readFileUsingBufferReader();

        //read using FileChannel
        readFile.readFileUsingFileChannel();

        //read using DataInputStream
       readFile.readFileUsingDataInputStream();

        // using scanner
        readFile.readFileUsingScanner();

        // read file using tokenizer
        readFile.readFileStreamTokenizer();

        // read file with UTF-8 data
        readFile.readUTF8FileData();
    }
}
