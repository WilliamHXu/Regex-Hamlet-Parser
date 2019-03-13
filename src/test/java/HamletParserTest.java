import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        Integer expectedCount = 472;
        String changed = hamletParser.changeHamletToLeon();
        String expected = readFileAsString("/Users/williamxu/Dev/Regex-Hamlet-Parser/src/main/resources/leonishamlet.txt");
        Assert.assertEquals(expected, changed);
    }

    @Test
    public void testChangeHoratioToTariq() {
        Integer expectedCount = 158;
        String changed = hamletParser.changeHoratioToTariq();
        System.out.println(changed);
        String expected = readFileAsString("/Users/williamxu/Dev/Regex-Hamlet-Parser/src/main/resources/tariqishoratio.txt");
        Assert.assertEquals(expected, changed);
    }

    @Test
    public void testGetHamletData() {
        String actual = hamletParser.getHamletData();
        Assert.assertEquals(hamletText, actual);
    }

    public static String readFileAsString(String fileName) {
        try {
            String data = "";
            data = new String(Files.readAllBytes(Paths.get(fileName)));
            return data;
        }
        catch (IOException e){
            return null;
        }
    }
}