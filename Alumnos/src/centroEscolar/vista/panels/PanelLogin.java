package centroEscolar.vista.panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import centroEscolar.controlador.CredencialController;

public class PanelLogin {

	private JPanel panel = null;
	private JButton jButtonPanel = null;
	private JTextField textField = null;
	private JPasswordField passwordField = null;

	public PanelLogin(ArrayList<JPanel> paneles, int ancho, int alto) {

		passwordField = new JPasswordField(15);

		panel = new JPanel();
		panel.setBounds(1, 1, ancho - 2, alto - 2);
		panel.setBackground(Color.red);
		panel.setLayout(null);

		textField = new JTextField(20);
		textField.setBounds(60, 20, 150, 25);
		panel.add(textField);

		passwordField = new JPasswordField(15);
		passwordField.setBounds(60, 50, 150, 25);
		panel.add(passwordField);

		jButtonPanel = new JButton("Login");
		jButtonPanel.setEnabled(false);
		jButtonPanel.setBounds(80, 80, 89, 23);

		jButtonPanel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				CredencialController credencialController = new CredencialController();

				try {
					String usuario = introducirUsuario();

					char[] password = passwordField.getPassword();
					String pass = new String(password);

					if ((usuario == null || usuario.trim().isEmpty()) || (pass == null || pass.trim().isEmpty())) {
						jButtonPanel.setEnabled(false);
					} else {
						jButtonPanel.setEnabled(true);
					}

					boolean ifOk = credencialController.comprobarLoginProfesor(usuario, pass);

					logeado(ifOk, paneles);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Se ha producido un error de base de datos", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}

			private String introducirUsuario() {
				String usuario;
				usuario = textField.getText();
				return usuario;
			}

			private void logeado(boolean ifOk, ArrayList<JPanel> paneles) {
				if (!ifOk) {
					JOptionPane.showMessageDialog(null, "Usuario o clave incorrecta", "Error",
							JOptionPane.ERROR_MESSAGE);

					paneles.get(0).setVisible(true);
					paneles.get(1).setVisible(false);

				} else {
					paneles.get(0).setVisible(false);
					paneles.get(1).setVisible(true);
				}
			}
		});

		panel.add(jButtonPanel);

		panel.revalidate();
		panel.repaint();
	}

	public JPanel getPanel() {
		return panel;
	}
}