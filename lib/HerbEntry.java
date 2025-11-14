public class HerbEntry {
    private String scientificName;
    private String collectorName;
    private String dateCollected;
    private String location;
    private String collectionNumber;
    private String additionalNotes;
    private String fileString;
    
    HerbEntry() {
        scientificName = null;
        collectorName = null;
        dateCollected = null;
        location = null;
        collectionNumber = null;
        additionalNotes = null;
        fileString = null;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getCollectorName() {
        return collectorName;
    }

    public void setCollectorName(String collectorName) {
        this.collectorName = collectorName;
    }

    public String getDateCollected() {
        return dateCollected;
    }

    public void setDateCollected(String dateCollected) {
        this.dateCollected = dateCollected;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCollectionNumber() {
        return collectionNumber;
    }

    public void setCollectionNumber(String collectionNumber) {
        this.collectionNumber = collectionNumber;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public String getFileString() {
        return fileString;
    }

    public void setFileString(String fileString) {
        this.fileString = fileString;
    }


}
