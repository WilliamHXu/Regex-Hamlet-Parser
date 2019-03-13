import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public String change(String regex, String changeTo){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(hamletData);
        return matcher.replaceAll(changeTo);
    }

    public String changeHamletToLeon() {
        String regex = "(?i)\\bHamlet\\b";
        return change(regex, "Leon");
    }

    public String changeHoratioToTariq() {
        String regex = "(?i)\\bHoratio\\b";
        return change(regex, "Tariq");
    }
}
