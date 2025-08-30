package Btech.class_java.newwy;

import java.io.*;

public class add_2_files {

    public static void main(String[] args) {

        // File input and output streams
        FileInputStream f1 = null;
        FileInputStream f2 = null;
        FileOutputStream f3 = null;

        try {
            // Open the first text file
            f1 = new FileInputStream("file1.txt");

            // Open the second text file
            f2 = new FileInputStream("file2.txt");

            // Create a new file to write the output
            f3 = new FileOutputStream("output.txt");

            // Read bytes from the first file
            byte[] buffer1 = new byte[1024];
            int length1;
            while ((length1 = f1.read(buffer1)) != -1) {
                // Write the bytes to the output file
                f3.write(buffer1, 0, length1);
            }

            // Read bytes from the second file
            byte[] buffer2 = new byte[1024];
            int length2;
            while ((length2 = f2.read(buffer2)) != -1) {
                // Write the bytes to the output file
                f3.write(buffer2, 0, length2);
            }

            System.out.println("The output file has been created successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the file input and output streams
            try {
                if (f1 != null) {
                    f1.close();
                }
                if (f2 != null) {
                    f2.close();
                }
                if (f3 != null) {
                    f3.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}