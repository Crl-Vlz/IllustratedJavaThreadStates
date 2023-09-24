import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main { //mike_features

    private JFrame window;
    private Thread ths[];
    private static int nThreads = 0;

    private int sizeX = 800;    
    private int sizeY = 400;

    public Main() {

        ths = new Thread[100];

        window = new JFrame("Thread States");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        JPanel threadPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JScrollPane sp = new JScrollPane(threadPanel);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        JButton btnCreateInheritance = new JButton("Create new Inherited Thread");
        JButton btnCreateInterface = new JButton("Create new Interface Thread");

        btnCreateInheritance.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ths[Main.nThreads] = new StateA(threadPanel);
                Main.nThreads++;
            }

        });
        btnCreateInterface.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                StateB state = new StateB(threadPanel);
                ths[Main.nThreads] = new Thread(state);
                Main.nThreads++;
            }

        });

        mainPanel.add(sp);
        mainPanel.add(btnCreateInheritance);
        mainPanel.add(btnCreateInterface);

        window.getContentPane().add(mainPanel);
        window.setSize(sizeX, sizeY);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

}