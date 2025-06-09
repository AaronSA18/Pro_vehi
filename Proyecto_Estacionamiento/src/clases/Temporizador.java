package clases;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class Temporizador extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Temporizador dialog = new Temporizador();
			dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Temporizador() {
		setModal(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 650, 280);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
        int time =30;
        contentPanel.setLayout(null);
        JLabel label = new JLabel("Tiempo restante: " + time + " segundos", JLabel.CENTER);
        label.setBounds(219, 106, 178, 14);
        contentPanel.add(label);
        // Crear un temporizador
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int countdown = time;

            @Override
            public void run() {
                if (countdown > 0) {
                    label.setText("Tiempo restante: " + countdown + " segundos");
                    countdown--;
                } else {
                    label.setText("�Tiempo terminado!");
                    timer.cancel();
                    dispose();
                }
            }
        };

        // Programar la tarea para que se ejecute cada segundo
        timer.scheduleAtFixedRate(task, 0, 1000);
	}

}
