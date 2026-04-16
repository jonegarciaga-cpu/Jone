package centroEscolar;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class Ejemplos {

	public static void main(String[] args) {

		// Crear ventana
		JFrame ventana = new JFrame("Ejemplo JTable - Eclipse");
		ventana.setSize(500, 300);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLayout(new BorderLayout());

		// Columnas
		String[] columnas = { "Nombre", "Edad", "Ciudad" };

		// Simulación de BBDD
		String[][] datosBD = { { "Ana", "20", "Madrid" }, { "Luis", "22", "Sevilla" }, { "Lucia", "19", "Valencia" } };

		// Modelo de tabla
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

		// Cargar datos en la tabla
		for (int i = 0; i < datosBD.length; i++) {
			modelo.addRow(datosBD[i]);
		}

		// Crear tabla
		JTable tabla = new JTable(modelo);
		JScrollPane scroll = new JScrollPane(tabla);

		// Panel inferior
		JPanel panel = new JPanel();

		// Campos de texto
		JTextField txtNombre = new JTextField(8);
		JTextField txtEdad = new JTextField(3);

		// ComboBox
		JComboBox<String> comboCiudad = new JComboBox<>();
		comboCiudad.addItem("Madrid");
		comboCiudad.addItem("Sevilla");
		comboCiudad.addItem("Valencia");

		// Botón
		JButton btnAgregar = new JButton("Agregar");

		// Acción del botón
		btnAgregar.addActionListener(e -> {
			String nombre = txtNombre.getText();
			String edad = txtEdad.getText();
			String ciudad = (String) comboCiudad.getSelectedItem();

			modelo.addRow(new Object[] { nombre, edad, ciudad });

			// Limpiar campos
			txtNombre.setText("");
			txtEdad.setText("");
		});

		// Añadir componentes al panel
		panel.add(new JLabel("Nombre:"));
		panel.add(txtNombre);
		panel.add(new JLabel("Edad:"));
		panel.add(txtEdad);
		panel.add(comboCiudad);
		panel.add(btnAgregar);

		// Añadir a la ventana
		ventana.add(scroll, BorderLayout.CENTER);
		ventana.add(panel, BorderLayout.SOUTH);

		// Mostrar ventana
		ventana.setVisible(true);
	}
}