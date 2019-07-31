package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

public class FormularioPOS extends JFrame {

	private JPanel contentPane;
	private JTextField textSexo;
	private JTextField textEdad;
	private JTextField textVivienda;
	private JTextField textCorreo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioPOS frame = new FormularioPOS();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormularioPOS() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 483);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JSeparator separator = new JSeparator();
		
		JPanel panelUsuario = new JPanel();
		panelUsuario.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JPanel panelProducto = new JPanel();
		panelProducto.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JPanel panelFactura = new JPanel();
		panelFactura.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JSeparator separator_1 = new JSeparator();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panelUsuario, GroupLayout.PREFERRED_SIZE, 854, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(panelFactura, GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
				.addComponent(panelProducto, GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelUsuario, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelProducto, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelFactura, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(133, Short.MAX_VALUE))
		);
		GroupLayout gl_panelFactura = new GroupLayout(panelFactura);
		gl_panelFactura.setHorizontalGroup(
			gl_panelFactura.createParallelGroup(Alignment.LEADING)
				.addGap(0, 746, Short.MAX_VALUE)
		);
		gl_panelFactura.setVerticalGroup(
			gl_panelFactura.createParallelGroup(Alignment.LEADING)
				.addGap(0, 150, Short.MAX_VALUE)
		);
		panelFactura.setLayout(gl_panelFactura);
		
		JLabel lblProductosRegistrados = new JLabel("Productos Registrados");
		
		JComboBox CBProductosRegistrados = new JComboBox();
		
		JLabel lblClasificaciontipoDe = new JLabel("Clasificacion (Tipo de producto)");
		
		JRadioButton rdbtnOral = new JRadioButton("Oral");
		
		JRadioButton rdbtnTopico = new JRadioButton("Topico");
		GroupLayout gl_panelProducto = new GroupLayout(panelProducto);
		gl_panelProducto.setHorizontalGroup(
			gl_panelProducto.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelProducto.createSequentialGroup()
					.addGroup(gl_panelProducto.createParallelGroup(Alignment.LEADING)
						.addComponent(lblProductosRegistrados)
						.addComponent(CBProductosRegistrados, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addGroup(gl_panelProducto.createParallelGroup(Alignment.LEADING)
						.addComponent(lblClasificaciontipoDe)
						.addGroup(gl_panelProducto.createSequentialGroup()
							.addComponent(rdbtnOral)
							.addGap(18)
							.addComponent(rdbtnTopico)))
					.addContainerGap(475, Short.MAX_VALUE))
		);
		gl_panelProducto.setVerticalGroup(
			gl_panelProducto.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelProducto.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelProducto.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProductosRegistrados)
						.addComponent(lblClasificaciontipoDe))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelProducto.createParallelGroup(Alignment.BASELINE)
						.addComponent(CBProductosRegistrados, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnOral)
						.addComponent(rdbtnTopico))
					.addContainerGap(91, Short.MAX_VALUE))
		);
		panelProducto.setLayout(gl_panelProducto);
		
		JLabel lblUsuariosRegistrados = new JLabel("Usuarios Registrados");
		
		JComboBox CBClientesRegistrados = new JComboBox();
		
		JLabel lblSexo = new JLabel("Sexo");
		
		JLabel lblEdad = new JLabel("Edad");
		
		JLabel lblCorreo = new JLabel("Correo");
		
		textSexo = new JTextField();
		textSexo.setColumns(10);
		
		textEdad = new JTextField();
		textEdad.setColumns(10);
		
		textVivienda = new JTextField();
		textVivienda.setColumns(10);
		
		JLabel lblAlergias = new JLabel("Alergias");
		
		JLabel lblVivienda1 = new JLabel("Vivienda");
		
		textCorreo = new JTextField();
		textCorreo.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		GroupLayout gl_panelUsuario = new GroupLayout(panelUsuario);
		gl_panelUsuario.setHorizontalGroup(
			gl_panelUsuario.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelUsuario.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelUsuario.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(CBClientesRegistrados, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblUsuariosRegistrados, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
					.addGap(58)
					.addGroup(gl_panelUsuario.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panelUsuario.createSequentialGroup()
							.addComponent(lblSexo, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelUsuario.createSequentialGroup()
							.addComponent(lblEdad)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_panelUsuario.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelUsuario.createSequentialGroup()
							.addComponent(lblCorreo, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textVivienda, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblAlergias, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelUsuario.createSequentialGroup()
							.addComponent(lblVivienda1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textCorreo, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addContainerGap(44, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelUsuario.setVerticalGroup(
			gl_panelUsuario.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelUsuario.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelUsuario.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelUsuario.createSequentialGroup()
							.addComponent(lblUsuariosRegistrados)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(CBClientesRegistrados, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelUsuario.createSequentialGroup()
							.addGroup(gl_panelUsuario.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelUsuario.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblSexo, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
									.addComponent(textSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblCorreo))
								.addGroup(gl_panelUsuario.createParallelGroup(Alignment.BASELINE)
									.addComponent(textVivienda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblAlergias)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelUsuario.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEdad)
								.addComponent(textEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textCorreo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblVivienda1, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		panelUsuario.setLayout(gl_panelUsuario);
		contentPane.setLayout(gl_contentPane);
	ButtonGroup GrupoDeBotones1 = new ButtonGroup();
	GrupoDeBotones1.add(rdbtnOral);
	GrupoDeBotones1.add(rdbtnTopico);
	}
}
