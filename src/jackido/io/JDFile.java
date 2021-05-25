package jackido.io;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class JDFile {
    // adapted from https://stackoverflow.com/questions/453018/number-of-lines-in-a-file-in-java/453067
    public static int countLines(String filename) throws IOException {
        InputStream is = new BufferedInputStream(new FileInputStream(filename));
        try {
            byte[] c = new byte[1024];

            int readChars = is.read(c);
            if (readChars == -1) {
                // bail out if nothing to read
                return 0;
            }

            // make it easy for the optimizer to tune this loop
            int count = 0;
            while (readChars == 1024) {
                for (int i = 0; i < 1024; ) {
                    if (c[i++] == '\n') {
                        ++count;
                    }
                }
                readChars = is.read(c);
            }

            // count remaining characters
            while (readChars != -1) {
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
                readChars = is.read(c);
            }

            return count == 0 ? 1 : count;
        } finally {
            is.close();
        }
    }

    public static int countLines(File folder) throws IOException {
        if (!folder.isDirectory()) {
            return 0;
        }

        int c = 0;
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            c += countLines(file.toString());
        }
        return c;
    }

    public static ArrayList<String> readLines(File file) {
        ArrayList<String> result = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            return null;
        }
        return result;
    }

    public static LinkedHashSet<String> readLinesToSet(File file) throws IOException {
        LinkedHashSet<String> result = new LinkedHashSet<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            return null;
        }
        return result;
    }
}