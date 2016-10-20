package logic;

import helper.Constants;
import org.hamcrest.FeatureMatcher;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * Created by roman on 20.10.16.
 */
public class SearchingTest {
    private String directoryTest = "/Users/roman/Desktop/TestFileSearcher";
    private Searching searching;
    private Path pathTest;
    private int dirCount = 3;
    private int fileCount = 2;

    @Before
    public void setUp() throws Exception {
        searching = new Searching(Constants.ALL_SEARCHING, true);
        pathTest = Paths.get(directoryTest);
        Files.walkFileTree(pathTest, searching);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println(searching.getInformation());
        searching = null;
        pathTest = null;
    }

    @Test
    public void directoryCountTest() throws Exception {
        Assert.assertEquals(dirCount, searching.getDirCount());
    }

    @Test
    public void filesCountTest() throws Exception {
        Assert.assertEquals(fileCount, searching.getFileCount());
    }




}