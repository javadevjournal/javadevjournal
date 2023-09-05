package com.javadevjournal;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JavaInputAndOutput {

    public class KeyboardInputExample {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            System.out.println("Hello, " + name + "!");
        }
    }

    public class ConsoleOutputExample {
        public static void main(String[] args) {
            System.out.println("This is a message to the console.");
        }
    }

    public class FileReadExample {
        public static void main(String[] args) {
            try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class ByteStreamExample {
        public static void main(String[] args) {
            try (FileInputStream in = new FileInputStream("input.bin");
                FileOutputStream out = new FileOutputStream("output.bin")) {
                int byteData;
                while ((byteData = in.read()) != -1) {
                    out.write(byteData);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class CharacterStreamExample {
        public static void main(String[] args) {
            try (FileReader reader = new FileReader("input.txt");
                FileWriter writer = new FileWriter("output.txt")) {
                int charData;
                while ((charData = reader.read()) != -1) {
                    writer.write(charData);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class DirectoryExample {
        public static void main(String[] args) {
            File directory = new File("my_directory");

            // Create a directory
            boolean created = directory.mkdir();
            if (created) {
                System.out.println("Directory created successfully.");
            }

            // List files in the directory
            String[] files = directory.list();
            for (String file : files) {
                System.out.println(file);
            }

            // Delete the directory
            boolean deleted = directory.delete();
            if (deleted) {
                System.out.println("Directory deleted successfully.");
            }
        }
    }

    public class SerializationExample {
        public static void main(String[] args) {
            try {
                // Serialization
                FileOutputStream fileOut = new FileOutputStream("object.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                MyClass obj = new MyClass("Hello, Serialization!");
                out.writeObject(obj);
                out.close();
                fileOut.close();

                // Deserialization
                FileInputStream fileIn = new FileInputStream("object.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                MyClass newObj = (MyClass) in.readObject();
                in.close();
                fileIn.close();

                System.out.println("Deserialized: " + newObj.getMessage());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public class FileReadWriteExample {
        public static void main(String[] args) {
            try (Scanner scanner = new Scanner(new FileReader("input.txt"));
                BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // Modify the line if needed
                    writer.write(line);
                    writer.newLine(); // Add a newline character
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class FileCopyExample {
        public static void main(String[] args) {
            try (FileInputStream in = new FileInputStream("source.txt");
                FileOutputStream out = new FileOutputStream("destination.txt")) {
                int byteData;
                while ((byteData = in.read()) != -1) {
                    out.write(byteData);
                }
                System.out.println("File copied successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
