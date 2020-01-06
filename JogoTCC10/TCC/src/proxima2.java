import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;


public class proxima2 extends JFrame {

	private JPanel contentPane;
	public JTextField txtpont;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					proxima2 frame = new proxima2();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public proxima2() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(proxima.class.getResource("/Img/icone.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtpont = new JTextField();
		txtpont.setHorizontalAlignment(JTextField.CENTER);
		txtpont.setEditable(false);
		txtpont.setVisible(true);
		txtpont.setFont(new Font("Arial", Font.BOLD, 22));
		txtpont.setBounds(562, 305, 234, 47);
		contentPane.add(txtpont);
		txtpont.setColumns(10);
		
		
		
		
		
		
		JButton btnajuda = new JButton("");
		btnajuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				Jogo pag3 = new Jogo();
				pag3.setVisible(true);
				pag3.setExtendedState(JFrame.MAXIMIZED_BOTH);
	            dispose(); 
	        	try {
					   
			         URL url = this.getClass().getClassLoader().getResource("Audio/9.wav");
			         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			      
			         Clip clip = AudioSystem.getClip();
			   
			         clip.open(audioIn);
			         clip.start();
			         } catch (UnsupportedAudioFileException e1) {
			         e1.printStackTrace();
			      } catch (IOException e1) {
			         e1.printStackTrace();
			      } catch (LineUnavailableException e1) {
			         e1.printStackTrace();
			      }
			}
		});
		btnajuda.setBounds(455, 502, 205, 65);
		ImageIcon imagens3 =new ImageIcon (Jogo.class.getResource("/Img/btnmenu.png"));
		Image botao3= imagens3.getImage().getScaledInstance(btnajuda.getWidth(),btnajuda.getHeight() , Image.SCALE_SMOOTH);
		btnajuda.setIcon(new ImageIcon(botao3));
		contentPane.add(btnajuda);
		
		JButton btnprxfase = new JButton("");
		btnprxfase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fase3 pag3 = new Fase3();
				pag3.setVisible(true);
				pag3.setExtendedState(JFrame.MAXIMIZED_BOTH);
				String g= txtpont.getText();
				Integer el=Integer.parseInt(g);
				pag3.txt2.setText(String.valueOf(el));
	            dispose(); 
	        	try {
					   
			         URL url = this.getClass().getClassLoader().getResource("Audio/9.wav");
			         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			      
			         Clip clip = AudioSystem.getClip();
			   
			         clip.open(audioIn);
			         clip.start();
			         } catch (UnsupportedAudioFileException e1) {
			         e1.printStackTrace();
			      } catch (IOException e1) {
			         e1.printStackTrace();
			      } catch (LineUnavailableException e1) {
			         e1.printStackTrace();
			      }
			}
		});
		btnprxfase.setBounds(711, 502, 205, 65);
		ImageIcon imagens4 =new ImageIcon (Jogo.class.getResource("/Img/btnprxfase.png"));
		Image botao7= imagens4.getImage().getScaledInstance(btnprxfase.getWidth(),btnprxfase.getHeight() , Image.SCALE_SMOOTH);
		btnprxfase.setIcon(new ImageIcon(botao7));
		contentPane.add(btnprxfase);
		ImageIcon imagens5 =new ImageIcon (Jogo.class.getResource("/Img/btnrepetir.png"));
		
		JLabel lblMapa = new JLabel("");
		lblMapa.setBounds(0, 0, 1372, 710);
		ImageIcon imagem =new ImageIcon (Jogo.class.getResource("/Img/Tela2.png"));
		Image mapa= imagem.getImage().getScaledInstance(lblMapa.getWidth(),lblMapa.getHeight() , Image.SCALE_SMOOTH);
		contentPane.setLayout(null);
		lblMapa.setIcon(new ImageIcon(mapa));
		contentPane.add(lblMapa);
		
		
	}
}
