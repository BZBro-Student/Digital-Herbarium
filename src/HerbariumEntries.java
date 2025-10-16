import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class HerbariumEntries {
    private List<HerbariumEntry> entries;
    private int currentIndex;

    public HerbariumEntries (String fileName){
        this.entries = new ArrayList<>();
        this.currentIndex = -1;
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))){
            String line;
                while ((line = fileReader.readLine()) != null){
                    if (line.equals("###############")){
                        String scientificName = fileReader.readLine();
                        String commonName = fileReader.readLine();
                        String observations = fileReader.readLine();
                        String filePath = fileReader.readLine();

                        if (scientificName != null && commonName != null && observations != null && filePath != null){
                            entries.add(new HerbariumEntry(scientificName, commonName, observations, filePath));
                        }
                    }
                }
                if (!entries.isEmpty()){
                    currentIndex = 0;
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public HerbariumEntry getCurrenEntries() {
        if (currentIndex >= 0 && currentIndex < entries.size()){
            return entries.get(currentIndex);
        }
        return null;
    }
}
