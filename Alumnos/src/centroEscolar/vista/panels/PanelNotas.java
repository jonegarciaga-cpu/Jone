package centroEscolar.vista.panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import centroEscolar.controlador.NotaController;
import centroEscolar.controlador.PersonaController;
import centroEscolar.modelo.entidad.Alumno;
import centroEscolar.modelo.entidad.Nota;

public class PanelNotas {

	PersonaController personaController;
	NotaController notaController;

	private JPanel panel = null;
	private JButton jButtonPanel = null;

	private JTable tabla = null;
	private JScrollPane scroll = null;

	public PanelNotas(ArrayList<JPanel> paneles, int ancho, int alto) {

		personaController = new PersonaController();
		notaController = new NotaController();
		datosPanle(ancho, alto);

		botonSalir(paneles);
		JComboBox<Alumno> combo = crearCombo();

		combo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Alumno seleccionado = (Alumno) combo.getSelectedItem();
				if (seleccionado != null) {
					crearTabla(seleccionado);
				} else {
					tabla.setModel(new DefaultTableModel());
					scroll.setVisible(false);
//					((DefaultTableModel) tabla.getModel()).setRowCount(1);
					scroll.revalidate();
					scroll.repaint();
				}
			}
		});

		combo.setBounds(160, 60, 89, 23);
		panel.add(combo);
	}

	private void datosPanle(int ancho, int alto) {
		panel = new JPanel();
		panel.setBounds(1, 1, ancho, alto);
		panel.setBackground(Color.blue);
		panel.setLayout(null);
	}

	private void botonSalir(ArrayList<JPanel> paneles) {
		jButtonPanel = new JButton("Salir");
		jButtonPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("GoTO -> Login");
				panel.setVisible(false);

				paneles.get(0).setVisible(true);
				paneles.get(1).setVisible(false);
			}
		});
		jButtonPanel.setBounds(60, 60, 89, 23);
		panel.add(jButtonPanel);
	}

	private JComboBox<Alumno> crearCombo() {
		JComboBox<Alumno> combo = new JComboBox<>();
		combo.addItem(null);

		List<Alumno> alumnos = personaController.getTodos();
		for (Alumno a : alumnos) {
			combo.addItem(a);
		}
		return combo;
	}

	private void crearTabla(Alumno alumno) {
		String[] columnas = { "Asignatura", "notas" };

		List<Nota> datosBD = notaController.getNotasAlumno(alumno);
		if (datosBD != null) {
			DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

			for (Nota n : datosBD) {
				Vector<String> fila = new Vector<String>();
				fila.add(n.getAsignatura());
				fila.add(n.getValor());
				modelo.addRow(fila);
			}

			tabla = new JTable(modelo);
			scroll = new JScrollPane(tabla);
			scroll.setBounds(100, 100, 200, 200);
			panel.add(scroll);
		}
	}

	public JPanel getPanel() {
		return panel;
	}
}
