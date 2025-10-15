import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class HerbariumGui extends JPanel {
    private JPanel mainPanel;
    private JPanel rightPanel;
    private JPanel leftImagePanel;
    private JLabel commonName;
    private JTextField commonNameField;
    private JLabel scientificName;
    private JTextField scientificNameField;
    private JLabel observations;
    private JTextField observationsField;
    private ImageIcon flowerImage;
    HerbariumGui() {
        
        mainPanel = new JPanel();
        //Panel that will be on the left side of the mainPanel
        rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.Y_AXIS ));
        commonName = new JLabel("Common Name:");
        commonNameField = new JTextField(20);
        scientificName = new JLabel("Scientific Name:");
        scientificNameField = new JTextField(20);
        observations = new JLabel("Observations:");
        observationsField = new JTextField(20);
        //Adds to right Panel
        rightPanel.add(commonName);
        rightPanel.add(commonNameField);
        rightPanel.add(scientificName);
        rightPanel.add(scientificNameField);
        rightPanel.add(observations);
        rightPanel.add(observationsField);
        //Panel that will contain plant image 
        leftImagePanel = new JPanel();
        //TO-DO make this so you can just pick a file
        flowerImage = new ImageIcon("img/yippee-creature.gif");
        //Add image to panel
        leftImagePanel.add(new JLabel(flowerImage));


        mainPanel.add(leftImagePanel);
        mainPanel.add(rightPanel);
        this.add(mainPanel);
    }
    
}
