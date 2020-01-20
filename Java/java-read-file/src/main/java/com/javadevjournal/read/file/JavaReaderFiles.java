package com.javadevjournal.read.file;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class JavaReaderFiles {

    private final String FILE_LOCATION = "src/main/resources/read_java_file.txt";
    private final String STREAMTOKENIZER_FILE_LOCATION = "src/main/resources/stream_tokenizer_read_java_file.txt";
    private final String UTF8_FILE_LOCATION = "src/main/resources/special_char_data.txt";

    public void readFileUsingBufferReader() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_LOCATION));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            // perform your logic with the data
            System.out.println(line);
        }
    }

    public void readFileUsingFileChannel() throws IOException {
        RandomAccessFile file = new RandomAccessFile(FILE_LOCATION, "r");
        FileChannel channel = file.getChannel();
        int bufferSize = 1024;
        ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
        while (channel.read(buffer) != -1) {
            System.out.println(new String(buffer.array()));
        }
        channel.close();
        file.close();
    }

    public void readFileUsingDataInputStream() throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(FILE_LOCATION));
        while (dataInputStream.available() > 0) {
            System.out.println(dataInputStream.readUTF());
        }
    }

    public void readFileUsingScanner() throws IOException {
        Scanner scanner = new Scanner(new File(FILE_LOCATION), StandardCharsets.UTF_8.name());
        scanner.useDelimiter("\\n");
        while (scanner.hasNext()) {
            // perform your logic with the data
            System.out.println(scanner.next());
        }
    }

    public void readFileStreamTokenizer() throws IOException {

        // init the file and StreamTokenizer
        FileReader reader = new FileReader(STREAMTOKENIZER_FILE_LOCATION);
        StreamTokenizer tokenizer = new StreamTokenizer(reader);

        // we will iterate through the output until end of file
        while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {

            // we will work on the data based on the data type
            if(tokenizer.ttype == StreamTokenizer.TT_WORD) {
                System.out.println(tokenizer.sval);
            } else if(tokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                System.out.println(tokenizer.nval);
            } else if(tokenizer.ttype == StreamTokenizer.TT_EOL) {
                System.out.println();
            }
        }
    }


    public void readUTF8FileData() throws IOException {

        // create a Buffer reader without encoding and pass encoding information
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(UTF8_FILE_LOCATION)));
        String line;

        // we iterate until EOF
        while ((line = bufferedReader.readLine()) != null) {
            // perform your logic with the data
            System.out.println(line);
        }

        // close the buffer
        bufferedReader.close();
    }
}
