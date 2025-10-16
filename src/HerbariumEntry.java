
public class HerbariumEntry {
    private String scientificName;
    private String commonName;
    private String observations;
    private String imagePath;

    /**
     * parses files contained in a text file
     * 
     * @param fileName text file that needs to be read.
     */
    public HerbariumEntry(String scientificName, String commonName, String observations, String imagePath) {
        this.scientificName = scientificName;
        this.commonName = commonName;
        this.observations = observations;
        this.imagePath = imagePath;
    }

    public String getScientificName() {
        return scientificName;
    }

    public String getCommonName() {
        return commonName;
    }

    public String getObservations() {
        return observations;
    }

    public String getImagePath() {
        return imagePath;
    }
}
