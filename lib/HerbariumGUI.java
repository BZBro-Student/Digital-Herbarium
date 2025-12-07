import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.util.ListIterator;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

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
    private JScrollPane additionalNotesPane;
    private JLabel fileStringLabel;
    private JTextField fileStringField;
    private String fileString;
    // Controls
    private JPanel controlPanel;
    private JButton next;
    private JButton previous;
    private JButton add;
    private JButton save;
    // Image Panel
    private JPanel imagePanel;
    private ImageIcon imageIcon;
    private Image resizedImage;
    private JLabel imageIconLabel;

    /**
     * constructor for HerbariumGui
     */
    HerbariumGui() {
        // Load initial list
        entryList = new IUDoubleLinkedList<HerbEntry>();
        try {
            String filePath = "src//myHerbarium.csv";
            file = new File(filePath);
            BufferedReader herbReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = herbReader.readLine()) != null) {
                String[] splitLine = line.split(",");
                currEntry = new HerbEntry(); 
                currEntry.setScientificName(splitLine[0]);
                currEntry.setCollectorName(splitLine[1]);
                currEntry.setDateCollected(splitLine[2]);
                currEntry.setLocation(splitLine[3]);
                currEntry.setCollectionNumber(splitLine[4]);
                currEntry.setAdditionalNotes(splitLine[5]);
                currEntry.setFileString(splitLine[6]);
                entryList.add(currEntry);
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
        infoPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
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
        additionalNotesPane = new JScrollPane(additionalNotesField);
        fileStringLabel = new JLabel("File:");
        fileStringField = new JTextField(10);
        // default image
        imageIcon = new ImageIcon("src//img//is-this-a-butterfly.jpg");
        resizedImage = imageIcon.getImage();
        resizedImage = resizedImage.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
        imageIconLabel = new JLabel(new ImageIcon(resizedImage));
        imagePanel = new JPanel();
        imageIconLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
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
        infoPanel.add(additionalNotesPane);
        infoPanel.add(fileStringLabel);
        infoPanel.add(fileStringField);
        // Create Next Button
        next = new JButton("Next");
        
        next.setContentAreaFilled(false);
        controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.add(next);
        listIterator = entryList.listIterator();
        // Starts Next Button Functionality
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent n) {
                if (!listIterator.hasNext()) {
                    listIterator = entryList.listIterator();
                }
                currEntry = listIterator.next();
                scientificNameField.setText(currEntry.getScientificName());
                collectorNameField.setText(currEntry.getCollectorName());
                dateCollectedField.setText(currEntry.getDateCollected());
                locationField.setText(currEntry.getLocation());
                collectionNumberField.setText(currEntry.getCollectionNumber());
                additionalNotesField.setText(currEntry.getAdditionalNotes());
                fileStringField.setText(currEntry.getFileString());
                fileString = currEntry.getFileString();
                File file = new File(fileString);
                if (file.exists()) {
                    imageIcon = new ImageIcon(fileString);
                    resizedImage = imageIcon.getImage();
                    resizedImage = resizedImage.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
                    imageIcon = new ImageIcon(resizedImage);
                    imageIconLabel.setIcon(imageIcon);
                }
            }
        });
        controlPanel.add(Box.createVerticalStrut(10));
        previous = new JButton("previous");
        
        previous.setContentAreaFilled(false);
        controlPanel.add(previous);
        previous.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent p) {
                if (!listIterator.hasPrevious()) {
                    listIterator = entryList.listIterator(entryList.size());
                }
                currEntry = listIterator.previous();
                scientificNameField.setText(currEntry.getScientificName());
                collectorNameField.setText(currEntry.getCollectorName());
                dateCollectedField.setText(currEntry.getDateCollected());
                locationField.setText(currEntry.getLocation());
                collectionNumberField.setText(currEntry.getCollectionNumber());
                additionalNotesField.setText(currEntry.getAdditionalNotes());
                fileStringField.setText(currEntry.getFileString());
                fileString = currEntry.getFileString();
                File file = new File(fileString);
                if (file.exists()) {
                    imageIcon = new ImageIcon(fileString);
                    resizedImage = imageIcon.getImage();
                    resizedImage = resizedImage.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
                    imageIcon = new ImageIcon(resizedImage);
                    imageIconLabel.setIcon(imageIcon);
                }
            }
        });
        controlPanel.add(Box.createVerticalStrut(10));
        add = new JButton("Add");
        
        add.setContentAreaFilled(false);
        controlPanel.add(add);
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                HerbEntry newEntry = new HerbEntry();
                newEntry.setScientificName(scientificNameField.getText());
                newEntry.setCollectorName(collectorNameField.getText());
                newEntry.setDateCollected(dateCollectedField.getText());
                newEntry.setLocation(locationField.getText());
                newEntry.setCollectionNumber(collectionNumberField.getText());
                newEntry.setAdditionalNotes(additionalNotesField.getText());
                newEntry.setFileString(fileStringField.getText());
                listIterator.add(newEntry);
            }
        });
        
        controlPanel.add(Box.createVerticalStrut(10));
        save = new JButton("Save");
    
        save.setContentAreaFilled(false);
        controlPanel.add(save);
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent s) {
                StringBuilder contentToWrite = new StringBuilder();
                for (HerbEntry listEntry : entryList) {
                    contentToWrite.append(listEntry.getScientificName());
                    contentToWrite.append(',');
                    contentToWrite.append(listEntry.getCollectorName());
                    contentToWrite.append(',');
                    contentToWrite.append(listEntry.getDateCollected());
                    contentToWrite.append(',');
                    contentToWrite.append(listEntry.getLocation());
                    contentToWrite.append(',');
                    contentToWrite.append(listEntry.getCollectionNumber());
                    contentToWrite.append(',');
                    contentToWrite.append(listEntry.getAdditionalNotes());
                    contentToWrite.append(',');
                    contentToWrite.append(listEntry.getFileString());
                    contentToWrite.append("\n");
                }
                try {
                    FileWriter fileOverwrite = new FileWriter(file, false);
                    fileOverwrite.write(contentToWrite.toString());
                    fileOverwrite.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        controlPanel.add(Box.createVerticalStrut(255));

        // Add to the main panel
        this.add(imagePanel);
        this.add(infoPanel);
        this.add(controlPanel);

    };

}
