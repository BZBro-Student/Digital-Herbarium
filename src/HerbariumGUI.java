import java.awt.GridLayout;

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
    private JPanel rightPanel;
    private JPanel leftImagePanel;
    private JPanel leftButtonPanel;
    private JPanel subPanelOne;
    private JPanel subPanelTwo;
    private JPanel subPanelThree;
    private JLabel commonName;
    private JTextField commonNameField;
    private JLabel scientificName;
    private JTextField scientificNameField;
    private JLabel observations;
    private JTextArea observationsField;
    private JScrollPane observationFieldPane;
    private ImageIcon flowerImage;
    private JFileChooser pickFile;
    private JButton save;
    private JButton edit;

    HerbariumGui() {
        // Panel that will hold all other sub-panels
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        // Panel that will be on the left side of the mainPanel
        rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        subPanelOne = new JPanel();
        subPanelTwo = new JPanel();
        subPanelThree =  new JPanel();
        commonName = new JLabel("Common Name:");
        commonNameField = new JTextField(20);
        scientificName = new JLabel("Scientific Name:");
        scientificNameField = new JTextField(20);
        observations = new JLabel("Observations:");
        observationsField = new JTextArea();
        observationFieldPane = new JScrollPane();
        observationFieldPane.setViewportView(observationsField);
        // Adds to right Panel
        subPanelOne.add(commonName);
        subPanelOne.add(commonNameField);
        subPanelTwo.add(scientificName);
        subPanelTwo.add(scientificNameField);
        subPanelThree.add(observations);
        subPanelThree.add(observationFieldPane);
        subPanelThree.setLayout(new BoxLayout(subPanelThree, BoxLayout.Y_AXIS));
        rightPanel.add(subPanelOne);
        rightPanel.add(subPanelTwo);
        rightPanel.add(subPanelThree);

        // Panel that will contain plant image
        leftImagePanel = new JPanel();
        leftImagePanel.setLayout(new BoxLayout(leftImagePanel, BoxLayout.Y_AXIS));
        pickFile = new JFileChooser();
        int result = pickFile.showOpenDialog(null);
        // Pick image
        if (result == JFileChooser.APPROVE_OPTION) {
            flowerImage = new ImageIcon(pickFile.getSelectedFile().getAbsolutePath());
        } else {
            flowerImage = new ImageIcon("src/img/failedtoload.png");
        }
        // Add image to panel centered
        leftImagePanel.add(new JLabel(flowerImage));

        // Panel that will contain save and edit buttons
        leftButtonPanel = new JPanel();
        save = new JButton("Save");
        edit = new JButton("Edit");

        // Add buttons to panel
        leftButtonPanel.add(save);
        leftButtonPanel.add(edit);

        // Puts left button panel in correct place
        leftImagePanel.add(leftButtonPanel);
        // Puts left image panel in the right place
        mainPanel.add(leftImagePanel);
        // Puts right panel in the right place
        mainPanel.add(rightPanel);
        // puts panel into HerbariumGui
        this.add(mainPanel);
    }

}
