package javafortester.chap019files.example;

import jdk.jfr.TransitionTo;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static java.nio.file.StandardCopyOption.*;

public class FilesTest {
    private File writeTheTestDataFile() throws IOException {
        File outputFile = File.createTempFile("forReading", ".text", new File(System.getProperty("user.dir")));
        PrintWriter print = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(outputFile)));
        for(int lineNumber = 1; lineNumber < 6; lineNumber++){
            print.println("line " + lineNumber);
        }
        print.close();
        return outputFile;
    }

    @Test
    public void outputFileToSystemOutWithBufferedReader() throws IOException {
        File inputFile = writeTheTestDataFile();
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        try{
            String line;
            while((line = reader.readLine())!=null){
                System.out.println(line);
            }
        }finally{
            reader.close();
        }
    }

    @Test
    public void createATempFileAndVaryTheParameter() throws IOException {
//    Write an @Test method which creates a temp file.
        File file1 = File.createTempFile("TempFile", null);

//    Find the file in your System’s temporary directory and make sure it was written.
        assertThat("File is not exit!", file1.exists(), is(true));

//    Vary the prefix, and the suffix to see the impact of the output file.
        System.out.println("File 1 name: " + file1.getName());

        file1.deleteOnExit();
    }

    @Test
    public void writeOutTheRoots(){
        File[] root = File.listRoots();
        assertThat(root.length > 0, is(true));

        for (File file: root){
            System.out.println( file.getPath());
        }
    }


    @Test
    public void createATemporaryFileWithCustomCode() throws IOException {
        File file = new File("D:/test"+ System.currentTimeMillis() +".txt");

        assertThat(file.exists(), is(false));

        file.createNewFile();
        assertThat(file.exists(), is(true));
        System.out.println("File name: " + file.getName());

        file.delete();
        assertThat(file.exists(), is(false));
    }

    @Test
    public void writeATestToCheckCanonicalConversion() throws IOException {
        File absolute1 = new File("C:/1/2/3/4/../../..");
        File absolute2 = new File("C:/1/2/../../1");
        File canonical = new File("C:/1");

        System.out.println("Get absolute path of absolute1: " + absolute1.getAbsolutePath());
        System.out.println("Get absolute path of absolute2: " + absolute2.getAbsolutePath());
        System.out.println("Get absolute path of canonical: " + canonical.getAbsolutePath() + "\n");

        System.out.println("Get canonical path of absolute1: " + absolute1.getCanonicalPath());
        System.out.println("Get canonical path of absolute2: " + absolute2.getCanonicalPath());
        System.out.println("Get canonical path of canonical: " + canonical.getCanonicalPath());

        assertThat(canonical.getAbsolutePath(), is(canonical.getCanonicalPath()));
        assertThat(canonical.getAbsolutePath(), is(absolute1.getCanonicalPath()));
        assertThat(canonical.getAbsolutePath(), is(absolute2.getCanonicalPath()));

        assertThat(absolute1.getAbsolutePath().contains(".."), is(true));
        assertThat(absolute2.getAbsolutePath().contains(".."), is(true));
    }

    @Test
    public void checkThatTheTempDirectoryIsADirectory() throws IOException {
        File file = new File(System.getProperty("java.io.tmpdir"));

        assertThat(file.isDirectory(), is(true));
        assertThat(file.isFile(), is(false));

        file.deleteOnExit();
    }

    @Test
    public void writeToAPrintWriterThenAppend() throws IOException {
        File file = File.createTempFile("test","txt");
        System.out.println("File path: " + file.getAbsolutePath());

        FileWriter filewriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(filewriter);
        PrintWriter print = new PrintWriter(bufferedWriter);

        print.println("Simple Print to Buffered Writer");
        print.close();

        filewriter = new FileWriter(file);
        bufferedWriter = new BufferedWriter(filewriter);
        print = new PrintWriter(bufferedWriter);

        print.println("===============================");
        print.close();

        String lineEnd = System.lineSeparator();
        assertEquals(2, lineEnd.length());
    }


    @Test
    public void createAFileAndCalculateTheLength() throws IOException {
        File temp = new File(System.getProperty("java.io.tmpdir"));
        long freeSpace = temp.getFreeSpace();
        long totalSpace = temp.getTotalSpace();
        long usableSpace = temp.getUsableSpace();

        File outputFile = writeTheTestDataFile(19);
        assertThat("Length is not the same! ",outputFile.length(), is(expectedFileSize(19)));

        System.out.println("Length \t" + outputFile.length() );
        System.out.println("Free \t\t" + freeSpace );
        System.out.println("Total \t" + totalSpace );
        System.out.println("Usable \t" + usableSpace);
    }

    private long expectedFileSize(int lines) throws IOException {
        String lineEnd = System.lineSeparator();
        return ((("line "+String.valueOf(lines)).length() + lineEnd.length())*lines);
    }

    private File writeTheTestDataFile(int lines) throws IOException {
        File outputFile = File.createTempFile(
            "forReading" + lines + "_", null);
        PrintWriter print = new PrintWriter(
                            new BufferedWriter(
                            new FileWriter(outputFile)));

        for(int line=0; line<lines; line++){
            print.println("line " + lines);
        }
        print.close();
        return outputFile;
    }

    @Test
    public void listTempDirectly() throws IOException {
        File file = new File(System.getProperty("java.io.tmpdir"));
        File[] listFile = file.listFiles();

        for (File index: listFile){

            if (index.isFile()){
                System.out.println("FIL: \t"+index);
            }else if (index.isDirectory()){
                System.out.println("DIR: \t"+index);
            }

            if (index.canRead()){
                System.out.println("\t- Can read!");
            }else{
                System.out.println("\t- Can not read!");
            }

            if (index.canWrite()){
                System.out.println("\t- Can write!");
            }else{
                System.out.println("\t- Can not write!");
            }

            if (index.canExecute()){
                System.out.println("\t- Can execute!");
            }else{
                System.out.println("\t- Can not execute!");
            }

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
            System.out.println("\t- Last updated date:" + simpleDateFormat.format(index.lastModified()));
        }
    }

    @Test
    public void copyAFile() throws IOException {
        File originalFile = File.createTempFile("originalfile",null);
        assertThat(originalFile.exists(), is(true));
        System.out.println("Original file name: "+ originalFile.getName());

        File copiedFile = new File(originalFile.getCanonicalFile() + ".copy");
        assertThat(copiedFile.exists(), is(false));
        System.out.println("Copied file name: "+ copiedFile.getName());

        Files.copy(originalFile.toPath(),copiedFile.toPath());

        assertThat(originalFile.exists(), is(true));
        assertThat(copiedFile.exists(), is(true));
    }

    @Test
    public void movedAFile() throws IOException {
        File originalFile = File.createTempFile("originalfile",null);
        assertThat(originalFile.exists(), is(true));
        System.out.println("Original file name: "+ originalFile.getName());

        File movedFile = new File(originalFile.getCanonicalFile() + ".moved");
        assertThat(movedFile.exists(), is(false));
        System.out.println("Moved file name: "+ movedFile.getName());

        Files.move(originalFile.toPath(),movedFile.toPath());

        assertThat(originalFile.exists(), is(false));
        assertThat(movedFile.exists(), is(true));
    }
}
