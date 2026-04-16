package centroEscolar.vista;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import centroEscolar.vista.panels.PanelLogin;
import centroEscolar.vista.panels.PanelNotas;

/**
 * Ventana principal
 */
public class Ventana extends JFrame {

	private static final long serialVersionUID = -7177584187181556842L;

	private ArrayList<JPanel> paneles = null;

	public Ventana() {
		initialize();
	}

	private void initialize() {
		this.setBounds(100, 100, 800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setResizable(false);

		paneles = new ArrayList<JPanel>();

		PanelLogin gestorPanel1 = new PanelLogin(paneles, 800, 600);
		JPanel panel1 = gestorPanel1.getPanel();
		panel1.setVisible(true);
		paneles.add(panel1);
		this.getContentPane().add(panel1);

		PanelNotas gestorPanel2 = new PanelNotas(paneles, 800, 600);
		JPanel panel2 = gestorPanel2.getPanel();
		this.setVisible(false);
		paneles.add(panel2);
		this.getContentPane().add(panel2);

		panel1.setVisible(false);
		panel2.setVisible(false);
		panel1.setVisible(true);
	}
}
