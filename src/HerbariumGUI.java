
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class HerbariumGui extends JPanel {
    private JPanel mainPanel;
    private JPanel infoPanel;
    private JPanel leftImagePanel;
    private JPanel controlPanel;
    private JPanel commonNamePanel;
    private JPanel scientificNamePanel;
    private JPanel observationPanel;
    private JPanel fileNamePanel;
    private JLabel commonName;
    private JTextField commonNameField;
    private JLabel scientificName;
    private JTextField scientificNameField;
    private JLabel fileName;
    private JTextField fileNameField;
    private JLabel observations;
    private JTextArea observationsField;
    private JScrollPane observationFieldPane;
    private ImageIcon flowerImage;
    private JFileChooser filePicker;
    private JLabel flowerImageLabel;
    private JButton save;
    private JButton pickFile;
    private ActionListener buttonListener;
    private StringBuilder saveData;
    private BufferedWriter fileWriter;

    HerbariumGui() {
        buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == save) {
                    saveData = new StringBuilder("###############\n");
                    saveData.append(scientificNameField.getText());
                    saveData.append("\n");
                    saveData.append(commonNameField.getText());
                    saveData.append("\n");
                    saveData.append(observationsField.getText());
                    saveData.append("\n");
                    saveData.append(flowerImage.getDescription());
                    saveData.append("\n");
                    try {
                        fileWriter = new BufferedWriter(new FileWriter(fileNameField.getText() + ".txt"));
                        fileWriter.write(saveData.toString());
                        fileWriter.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                } else if (e.getSource() == pickFile) {
                    filePicker = new JFileChooser();
                    int returnVal = filePicker.showOpenDialog(null);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        flowerImage = new ImageIcon(filePicker.getSelectedFile().getAbsolutePath());
                        flowerImageLabel.setIcon(flowerImage);
                    } else if (returnVal == JFileChooser.CANCEL_OPTION) {
                        flowerImage = new ImageIcon("src/img/failedtoload.png");
                        flowerImageLabel.setIcon(flowerImage);

                    }
                }

            }
        };
        // Panel that will hold all other sub-panels
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        // SubPanels
        infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        commonNamePanel = new JPanel(new GridLayout(1, 2));
        scientificNamePanel = new JPanel(new GridLayout(1, 2));
        observationPanel = new JPanel(new GridLayout(1, 2));
        fileNamePanel = new JPanel(new GridLayout(1, 2));
        controlPanel = new JPanel();
        leftImagePanel = new JPanel();
        leftImagePanel.setLayout(new BoxLayout(leftImagePanel, BoxLayout.Y_AXIS));
        // Images
        flowerImage = new ImageIcon("src/img/failedtoload.png");
        flowerImageLabel = new JLabel(flowerImage);
        // Buttons
        pickFile = new JButton("Change Image");
        save = new JButton("Save");
        // Labels
        commonName = new JLabel("Common Name:");
        scientificName = new JLabel("Scientific Name:");
        observations = new JLabel("Observations:");
        fileName = new JLabel("Save File Name");
        // TextInput
        commonNameField = new JTextField(20);
        scientificNameField = new JTextField(20);
        fileNameField = new JTextField(20);
        observationsField = new JTextArea(5, 20);
        observationsField.setLineWrap(true);
        observationsField.setWrapStyleWord(true);
        observationFieldPane = new JScrollPane();
        observationFieldPane.setViewportView(observationsField);
        // Adds sub panels of infoPanel
        commonNamePanel.add(commonName);
        commonNamePanel.add(commonNameField);
        scientificNamePanel.add(scientificName);
        scientificNamePanel.add(scientificNameField);
        observationPanel.add(observations);
        observationPanel.add(observationFieldPane);
        fileNamePanel.add(fileName);
        fileNamePanel.add(fileNameField);
        // Adds sub panels to infoPanel
        infoPanel.add(commonNamePanel);
        infoPanel.add(scientificNamePanel);
        infoPanel.add(observationPanel);
        infoPanel.add(fileNamePanel);
        // Add buttons to panel
        controlPanel.add(save);
        controlPanel.add(pickFile);
        save.addActionListener(buttonListener);
        pickFile.addActionListener(buttonListener);
        // Puts left button panel in correct place
        leftImagePanel.add(flowerImageLabel);
        leftImagePanel.add(controlPanel);
        // Puts left image panel in the right place
        mainPanel.add(leftImagePanel);
        // Puts right panel in the right place
        mainPanel.add(infoPanel);
        // puts panel into HerbariumGui
        this.add(mainPanel);
    }

}
