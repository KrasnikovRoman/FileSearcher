package logic;

import helper.Constants;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;

/**
 * Created by roman on 11.08.16.
 */
public class Searching extends SimpleFileVisitor<Path> {
    private HashMap<String, String> information;
    private String searchingFile;
    private boolean moreInformationSelected;

    public Searching(String searchingFile, boolean moreInformationSelected) {
        information = new HashMap<>();
        this.searchingFile = searchingFile;
        this.moreInformationSelected = moreInformationSelected;
    }

    public HashMap<String, String> getInformation() {
        return information;
    }


    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        if (dir.getFileName().toString().equals(searchingFile)) {
            writeToMap(dir);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.err.println(exc);
       return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.getFileName().toString().equals(searchingFile)) {
            writeToMap(file);
        }
        return FileVisitResult.CONTINUE;
    }

    private void writeToMap(Path path) {
        try {
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            String infoAboutPath;
            if (moreInformationSelected) {
                infoAboutPath = "Is directory: " + attributes.isDirectory() + "\n" +
                        "Absolute path: " + path.toString() + "\n" +
                        "Size: " + attributes.size() + "\n" +
                        "Created: " + attributes.creationTime() + "\n" +
                        "Last modified: " + attributes.lastModifiedTime();
            } else {
                infoAboutPath = "Is directory: " + attributes.isDirectory() + "\n" +
                        "Absolute path: " + path.toString() + "\n";
            }
            information.put(infoAboutPath, path.getFileName().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
