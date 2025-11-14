import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ListIterator;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class HerbariumGui extends JPanel {
    private File file;
    private IUDoubleLinkedList<HerbEntry> entryList;
    private ListIterator<HerbEntry> listIterator;
    private HerbEntry currEntry;
    // Info Panel Content
    private JPanel infoPanel;
    private JLabel scientificName;
    private JTextField scientificNameField;
    private JLabel collectorName;
    private JTextField collectorNameField;
    private JLabel dateCollected;
    private JTextField dateCollectedField;
    private JLabel location;
    private JTextField locationField;
    private JLabel collectionNumber;
    private JTextField collectionNumberField;
    private JLabel additionalNotes;
    private JTextArea additionalNotesField;
    private String fileString;
    // Controls
    private JPanel controlPanel;
    private JButton next;
    // Image Panel
    private JPanel imagePanel;
    private ImageIcon imageIcon;
    private JLabel imageIconLabel;

    /**
     * constructor for HerbariumGui
     */
    HerbariumGui() {
        // Load initial list
        entryList = new IUDoubleLinkedList<HerbEntry>();
        try {
            String filePath = "src//myHerbarium.txt";
            file = new File(filePath);
            BufferedReader herbReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = herbReader.readLine()) != null) {
                if (line.equals("####")) {
                    HerbEntry newEntry = new HerbEntry();
                    newEntry.setScientificName(herbReader.readLine());
                    newEntry.setCollectorName(herbReader.readLine());
                    newEntry.setDateCollected(herbReader.readLine());
                    newEntry.setLocation(herbReader.readLine());
                    newEntry.setCollectionNumber(herbReader.readLine());
                    newEntry.setAdditionalNotes(herbReader.readLine());
                    newEntry.setFileString(herbReader.readLine());
                    entryList.add(newEntry);
                }
            }
            System.out.println(entryList.toString());
            herbReader.close();
        } catch (Exception e) {
            JLabel failedToLoadFile = new JLabel(new ImageIcon("src/img/failedtoload.png"));
            this.add(failedToLoadFile);
            e.printStackTrace();
        }
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        scientificName = new JLabel("Scientific Name:");
        scientificNameField = new JTextField(10);
        collectorName = new JLabel("Collector Name:");
        collectorNameField = new JTextField(10);
        dateCollected = new JLabel("Date Collected:");
        dateCollectedField = new JTextField(10);
        location = new JLabel("Location:");
        locationField = new JTextField(10);
        collectionNumber = new JLabel("Colleciton Number:");
        collectionNumberField = new JTextField(10);
        additionalNotes = new JLabel("Additional Notes:");
        additionalNotesField = new JTextArea(5, 10);
        // default image
        imageIcon = new ImageIcon("src//img//is-this-a-butterfly.jpg");
        imageIconLabel = new JLabel(imageIcon);
        imagePanel = new JPanel();
        imagePanel.add(imageIconLabel);
        // Info Panel
        infoPanel.add(scientificName);
        infoPanel.add(scientificNameField);
        infoPanel.add(collectorName);
        infoPanel.add(collectorNameField);
        infoPanel.add(dateCollected);
        infoPanel.add(dateCollectedField);
        infoPanel.add(location);
        infoPanel.add(locationField);
        infoPanel.add(collectionNumber);
        infoPanel.add(collectionNumberField);
        infoPanel.add(additionalNotes);
        infoPanel.add(additionalNotesField);
        // Create Next Button
        next = new JButton("Next");
        controlPanel = new JPanel();
        controlPanel.add(next);
        listIterator = entryList.listIterator();
        // Starts Next Button Functionality
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (listIterator.hasNext()) {
                currEntry = listIterator.next();
                } else {
                    listIterator = entryList.listIterator();
                }
                scientificNameField.setText(currEntry.getScientificName());
                collectorNameField.setText(currEntry.getCollectorName());
                dateCollectedField.setText(currEntry.getDateCollected());
                locationField.setText(currEntry.getLocation());
                collectionNumberField.setText(currEntry.getCollectionNumber());
                additionalNotesField.setText(currEntry.getAdditionalNotes());
                fileString = currEntry.getFileString();
                File file = new File(fileString);
                if (file.exists()) {
                    imageIcon = new ImageIcon(fileString);
                    imageIconLabel.setIcon(imageIcon);
                }
            }
        });

        // Add to the main panel
        this.add(imagePanel);
        this.add(infoPanel);
        this.add(controlPanel);

    };

}
