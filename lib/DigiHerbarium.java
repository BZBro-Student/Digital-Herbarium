import javax.swing.JFrame;

class DigiHerbarium {
    public static void main(String[] args){
    
        JFrame herbFrame = new JFrame("DigiHerbarium");
        herbFrame.setSize(800, 800);
        herbFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        herbFrame.setVisible(true);

        HerbariumGui herbGUI = new HerbariumGui();

        herbFrame.add(herbGUI);

        herbFrame.pack();
        herbFrame.repaint();

    }
}