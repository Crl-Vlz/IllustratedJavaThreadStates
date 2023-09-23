import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class StateA extends Thread {

    private JPanel panel;
    private ImageIcon img;
    private JLabel imgLabel;

    private boolean isRunning;

    public StateA(Container sp) {

        isRunning = false;

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JButton btnStart = new JButton("Start");
        JButton btnWait = new JButton("Wait");
        JButton btnStop = new JButton("Stop");

        JTextArea text = new JTextArea("0");

        panel.add(btnStart);

        btnStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                start();
                SwingUtilities.invokeLater(() -> {
                    panel.add(text);
                    panel.add(btnWait);
                    panel.add(btnStop);
                    panel.remove(btnStart);
                    sp.revalidate();
                });
            }

        });

        btnStop.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    btnStop.setEnabled(false);
                    btnWait.setEnabled(false);
                    isRunning = false;
                    sp.revalidate();
                });
            }

        });

        btnWait.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int nTime = Integer.parseInt(text.getText());
                SwingUtilities.invokeLater(() -> {
                    btnStop.setEnabled(false);
                    btnWait.setEnabled(false);
                    sp.revalidate();
                });
                try {
                    Thread.sleep(nTime);
                } catch (InterruptedException err) {
                    System.err.println(err.getMessage());
                }
                SwingUtilities.invokeLater(() -> {
                    btnStop.setEnabled(true);
                    btnWait.setEnabled(true);
                    sp.revalidate();
                });
            }

        });

        panel.add(new JLabel("Inheritance"));

        panel.setVisible(true);
        SwingUtilities.invokeLater(() -> {
            sp.add(panel);
            sp.revalidate();
        });
        System.out.println("thread created");
    }

    @Override
    public void run() {
        isRunning = true;
        while (isRunning)
            System.out.println("thread running");
    }

}
