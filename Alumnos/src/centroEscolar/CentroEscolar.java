package centroEscolar;

import centroEscolar.vista.Ventana;
import java.awt.EventQueue;

/**
 * Clase principal del proyecto
 */
public class CentroEscolar {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Ventana().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
