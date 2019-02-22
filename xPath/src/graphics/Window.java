package graphics;

import appearance.Theme;
import root.xPath;

import javax.swing.*;
import java.awt.*;

import static java.awt.GridBagConstraints.*;

public class Window extends JFrame {

    private JTextField tfInput;
    private JTextArea taOutput;
    private JButton btnConfirm;

    private xPath xPath;

    public Window() {
        super("Main Example");
        init();
        addContent();
        initFrame();
    }

    private void addContent() {
        this.add(new JPanel() {{
            setLayout(new GridBagLayout());
            add(taOutput, new GridBagConstraints(0, 0, WEST, BOTH, 0, 1, CENTER, BOTH, new Insets(5, 5, 0, 5), 0, 0));
            add(tfInput, new GridBagConstraints(0, 1, BOTH, BOTH, 1, 0, CENTER, BOTH, new Insets(5, 5, 5, 0), 0, 0));
            add(btnConfirm, new GridBagConstraints(1, 1, BOTH, BOTH, 0, 0, CENTER, BOTH, new Insets(5, 5, 5, 5), 0, 0));
        }});
    }

    private void init() {
        try {
            xPath = new xPath();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        tfInput = new JTextField();
        tfInput.setFont(Theme.font);
        tfInput.setBorder(BorderFactory.createLineBorder(Color.gray));

        taOutput = new JTextArea();
        taOutput.setFont(Theme.font);
        taOutput.setEditable(false);
        taOutput.setBorder(BorderFactory.createLineBorder(Color.gray));

        btnConfirm = new JButton("ok");
        btnConfirm.setFont(Theme.font);
        btnConfirm.addActionListener(event -> {
            try {
                taOutput.setText(xPath.getResult(tfInput.getText()));
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
                exception.printStackTrace();
            }
        });
    }

    private void initFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500, 350));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
//add(new JScrollPane (taOutput, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));