import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class MiVentana extends JFrame implements ActionListener{

	JPanel Contenedor;
	JTextField CampoCodigo;
	JTextField CampoCantidad;
	JTextField CampoPrecio;
	JTextField CampoNomProducto;
	JButton btnComprar;
	JButton btnMostrar;
	JButton btnLimpiar;
	JButton btnBuscar;
	JLabel lblNewLabel;
	JLabel lblNewLabel_1;
	JLabel lblNewLabel_2;
	JLabel lblNewLabel_3;
	JLabel lblNewLabel_4;
	JTextArea resultado;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiVentana frame = new MiVentana();
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
	
	Hashtable<String, Persona> clientes;
//	ArrayList<String> PrecioTotal;

	public MiVentana() {
		clientes =new Hashtable<String, Persona>();
//		PrecioTotal = new ArrayList<String>();
		setTitle("Sistema Compra");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 467);
		Contenedor = new JPanel();
		Contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(Contenedor);
		Contenedor.setLayout(null);
		

		btnComprar = new JButton("Comprar");
		btnComprar.setBounds(90, 143, 89, 23);
		btnComprar.addActionListener(this);
		Contenedor.add(btnComprar);
		
		btnMostrar = new JButton("Mostrar Compras");
		btnMostrar.setBounds(169, 178, 157, 23);
		btnMostrar.addActionListener(this);
		Contenedor.add(btnMostrar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(308, 143, 89, 23);
		btnLimpiar.addActionListener(this);
		Contenedor.add(btnLimpiar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(201, 143, 89, 23);
		btnBuscar.addActionListener(this);
		Contenedor.add(btnBuscar);
		
		CampoCodigo = new JTextField();
		CampoCodigo.setBounds(172, 84, 86, 20);
		Contenedor.add(CampoCodigo);
		CampoCodigo.setColumns(10);
		
		CampoCantidad = new JTextField();
		CampoCantidad.setBounds(283, 84, 86, 20);
		Contenedor.add(CampoCantidad);
		CampoCantidad.setColumns(10);
		
		CampoPrecio = new JTextField();
		CampoPrecio.setBounds(384, 84, 86, 20);
		Contenedor.add(CampoPrecio);
		CampoPrecio.setColumns(10);
		
		CampoNomProducto = new JTextField();
		CampoNomProducto.setBounds(23, 84, 133, 20);
		Contenedor.add(CampoNomProducto);
		CampoNomProducto.setColumns(10);
		
		lblNewLabel = new JLabel("Compra Productos");
		lblNewLabel.setBounds(173, 11, 140, 35);
		Contenedor.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Nombre Producto");
		lblNewLabel_1.setBounds(33, 69, 140, 14);
		Contenedor.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Codigo");
		lblNewLabel_2.setBounds(190, 69, 46, 14);
		Contenedor.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Cantidad");
		lblNewLabel_3.setBounds(287, 69, 74, 14);
		Contenedor.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Precio");
		lblNewLabel_4.setBounds(405, 69, 86, 14);
		Contenedor.add(lblNewLabel_4);
		
		resultado = new JTextArea();
		resultado.setEditable(false);
		resultado.setBounds(115, 264, 260, 129);
		Contenedor.add(resultado);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnComprar) {
			if (CampoNomProducto.getText().equals("") || CampoCodigo.getText().equals("")|| CampoCantidad.getText().equals("") ||CampoPrecio.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "¡Algun Campo Esta Vacío!");
			}else {
				Procesos miProcesos = new Procesos();
				miProcesos.comprar(CampoNomProducto, CampoCodigo , CampoCantidad, CampoPrecio, clientes, resultado);
			}
		}
		
		if (e.getSource() == btnMostrar) {
			Procesos miProcesos= new Procesos();
			miProcesos.mostrar(clientes, resultado);
		}
		
		if (e.getSource() == btnBuscar) {
			JOptionPane.showMessageDialog(null, "Hello");
		}
		
		if (e.getSource() == btnLimpiar) {
			vaciarCampos();
		}
		
	}

	private void vaciarCampos() {
		CampoCodigo.setText("");
		CampoCantidad.setText("");
		CampoPrecio.setText("");
		CampoNomProducto.setText("");
		JOptionPane.showMessageDialog(null, "Campos limpiados correctamente", "Limpiar", JOptionPane.INFORMATION_MESSAGE);
	}
}
