package elementos_JFrame;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;

class WindowsFrame extends JFrame{
	
	private JLabel JlTex1;
	private JLabel JlTex2;
	private JLabel JlTex3;
	public WindowsFrame(){
		setTitle("El marco que usare todo el proyecto");
		setDefaultCloseOperation(EXIT_ON_CLOSE);//Termina la ejecucion cuando se cierra la ventana
		setBounds(100, 100, 500, 500);
		
//		setExtendedState(Frame.MAXIMIZED_BOTH);//Establece el tamaño de la ventana
		
		setLocationRelativeTo(getParent());//la posiciona en el centro
		JlTex1 = new JLabel("KAKADADFDFADFDAFAF");
		JlTex1.setText("Primera Etiqueta");
		JlTex1.setBounds(40, 40, 300, 300);
		JlTex1.setBackground(Color.BLACK);
		JlTex1.setVisible(true);
		add(JlTex1);
		JlTex2 = new JLabel("dsfljsdhfkldjfh");
//		JlTex2.setText("Segunda Etiqueta");
		JlTex2.setBounds(10, 40, 300, 30);
		add(JlTex2);
		JlTex3 = new JLabel("aslhaskhgsduyasdysgadigosad");
		JlTex3.setBounds(100, 60, 300, 30);
		//JlTex3.setText("Tercera Etiqueta");
		JlTex3.setVisible(true);
		add(JlTex3);
		
		setResizable(true);//permite ajustar el tamaño de la ventana
		//Hace que se haga visible la ventatan
		setVisible(true);//Esto siempre tiene que ir al final
	}
	//Reescribiendo el metodo paint()
	public void paint(Graphics g) {
		//El pintado debe comenzar desde 40,40
	//	g.drawString("Primer Mensaje dibujado", 40, 40);
	}
}


public class JFrame_Marco {
	
	public static void main(String[] args) {
		WindowsFrame MiVentana = new WindowsFrame();
		
	}

}
