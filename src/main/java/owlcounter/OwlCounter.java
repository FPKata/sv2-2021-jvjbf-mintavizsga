package owlcounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class OwlCounter {
    private List<String> fileContent;
    public void readFromFile(Path path){
        try {
            fileContent = Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    public int getNumberOfOwls(String county){
        String strValue = "";
        boolean success = false;
        for (int i = 0; !success && i < fileContent.size(); i++){
            String[] parts = fileContent.get(i).split("=");
            if (county.equalsIgnoreCase(parts[0])){
                strValue = parts[1];
                success = true;
            }
        }
        if (!success){
            throw new IllegalArgumentException("No such county in Hungary!");
        }
        return Integer.parseInt(strValue);
    }

    public int getNumberOfAllOwls(){
        int sum = 0;
        for (String line :fileContent){
            String[] parts = line.split("=");
            sum += Integer.parseInt(parts[1]);
        }
        return sum;
    }
}

