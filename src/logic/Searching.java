package logic;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;

/**
 * Created by roman on 11.08.16.
 */
public class Searching implements Runnable {
    private HashMap<String, String> information;
    private String fileName;
    private String directory;
    private boolean moreInformationSelected;

    public Searching(String fileName, String directory, boolean moreInformationSelected) {
        information = new HashMap<>();
        this.fileName = fileName;
        this.directory = directory;
        this.moreInformationSelected = moreInformationSelected;
    }

    public HashMap<String, String> getInformation() {
        return information;
    }

    @Override
    public void run() {
        try {
            File file = new File(directory);
            process(file);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void process(File file) throws InterruptedException, IOException {
        if (file.getName().equals(fileName)) {
            try {
                Path path = Paths.get(file.getAbsolutePath());
                BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
                String infoAboutFile;
                if (moreInformationSelected == true) {
                    infoAboutFile =
                                    "Is directory: " + attrs.isDirectory() + "\n" +
                                    "Absolute path: " + file.getAbsolutePath() + "\n" +
                                    "Size: " + attrs.size() + "\n" +
                                    "Created: " + attrs.creationTime() + "\n" +
                                    "Last modified: " + attrs.lastModifiedTime();
                } else {
                    infoAboutFile = "Is directory: " + attrs.isDirectory() + "\n" +
                                    "Absolute path: " + file.getAbsolutePath() + "\n";
                }
                information.put(file.getName() + file.hashCode(), infoAboutFile);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        File[] files = file.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                process(files[i]);
            }
        }

        if (Thread.interrupted()) {
            throw new InterruptedException();
        }

    }

}
