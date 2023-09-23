import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class StateB implements Runnable {

    private JPanel panel;

    public StateB(Container container) {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        panel.add(new JButton("Interface"));
        panel.add(new JLabel("interface"));

        SwingUtilities.invokeLater(() -> {
            container.add(panel);
            container.revalidate();
        });
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

}
