package logic;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by roman on 11.08.16.
 */
public class Searching extends SimpleFileVisitor<Path> {
    private HashMap<String, String> information;
    private String searchingFile;
    private boolean moreInformationSelected;
    private Pattern pattern;
    private Matcher matcher;
    private int dirCount;
    private int fileCount;

    public int getDirCount() {
        return dirCount;
    }

    public int getFileCount() {
        return fileCount;
    }

    /**
     * Конструктор класса.
     * @param searchingFile название файла, который необходимо найти или же регулярное выражение
     * @param moreInformationSelected показывает нажата ли кнопка "Additional information"
     */
    public Searching(String searchingFile, boolean moreInformationSelected) {
        information = new HashMap<>();
        this.searchingFile = searchingFile;
        this.moreInformationSelected = moreInformationSelected;
        pattern = Pattern.compile(searchingFile);
    }


    public HashMap<String, String> getInformation() {
        return information;
    }

    /**
     * Этот метод вызывается после того как была найдена директория.
     * @param dir путь к директории
     * @param exc выбрасываемое исключение в случае ошибки
     * @return параметр дальнейшего действия
     * @throws IOException
     */
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        matcher = pattern.matcher(dir.getFileName().toString());
        if (matcher.matches()) {
            writeToMap(dir);
            dirCount++;
        }
        return FileVisitResult.CONTINUE;
    }

    /**
     * Метод вызывается, если атрибуты файла не могут быть прочитаны,
     * файл-каталог не может быть открыт, и другие причины.
     * @param file путь к файлу
     * @param exc выбрасываемое исключение в случае ошибки
     * @return параметр дальнейшего действия
     * @throws IOException
     */
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.err.println(exc);
       return FileVisitResult.CONTINUE;
    }

    /**
     * Метод вызывается после того, как найден был какой-либо файл.
     * @param file путь к файлу
     * @param attrs
     * @return параметр дальнейшего действияпараметр дальнейшего действия
     * @throws IOException
     */
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        matcher = pattern.matcher(file.getFileName().toString());
        if (matcher.matches()) {
            writeToMap(file);
            fileCount++;
        }
        return FileVisitResult.CONTINUE;
    }

    /**
     * Метод записывает информацию о найденом файле в HashMap.
     * @param path путь к файлу
     */
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
