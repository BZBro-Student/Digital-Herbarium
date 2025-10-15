import javax.swing.JFrame;

class DigiHerbarium {
    public static void main(String[] args){
    
        JFrame herbFrame = new JFrame("DigiHerbarium");
        herbFrame.setSize(400, 300);
        herbFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        herbFrame.setVisible(true);

        HerbariumGui newGUI = new HerbariumGui();

        herbFrame.add(newGUI);
        herbFrame.pack();
    }
}