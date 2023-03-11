package vue;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel {

    protected JLabel titre = new JLabel("");

    public PanelPrincipal() {
        // les caractéristiques communes aux différents panels
        this.setBounds(50, 80, 815, 550);
        this.setBackground(new Color(43, 140, 82));
        this.setLayout(null);

        this.titre.setBounds(320, 10, 300, 20);
        this.add(this.titre);

        this.setVisible(false);
    }

}
