import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JButton;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTable;


public class Ranking extends JFrame {

	private JPanel contentPane;
	private JTextField nomes;
	private JTextField pontoos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ranking frame = new Ranking();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
	public Ranking() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ranking.class.getResource("/Img/icone.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbltitulo = new JLabel("New label");
		lbltitulo.setBounds(598, 186, 234, 68);
		ImageIcon imagenss3 =new ImageIcon (Jogo.class.getResource("/Img/rank.png"));
		Image mapa9= imagenss3.getImage().getScaledInstance(lbltitulo.getWidth(),lbltitulo.getHeight() , Image.SCALE_SMOOTH);
		lbltitulo.setIcon(new ImageIcon(mapa9));
		contentPane.add(lbltitulo);
		
		
		
		
		
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
		btnajuda.setBounds(645, 547, 205, 65);
		ImageIcon imagens3 =new ImageIcon (Jogo.class.getResource("/Img/btnvoltar.png"));
		Image botao3= imagens3.getImage().getScaledInstance(btnajuda.getWidth(),btnajuda.getHeight() , Image.SCALE_SMOOTH);
		
		pontoos = new JTextField();
		pontoos.setEditable(false);
		pontoos.setBounds(701, 287, 86, 20);
		contentPane.add(pontoos);
		pontoos.setColumns(10);
		
		nomes = new JTextField();
		nomes.setEditable(false);
		nomes.setBounds(613, 287, 86, 20);
		contentPane.add(nomes);
		nomes.setColumns(10);
		btnajuda.setIcon(new ImageIcon(botao3));
		contentPane.add(btnajuda);
		
		JLabel lblmapa5 = new JLabel("");
		lblmapa5.setBounds(10, 430, 385, 369);
		ImageIcon imagenss =new ImageIcon (Jogo.class.getResource("/Img/LogoEmpresa.png"));
		Image mapa5= imagenss.getImage().getScaledInstance(lblmapa5.getWidth(),lblmapa5.getHeight() , Image.SCALE_SMOOTH);
		lblmapa5.setIcon(new ImageIcon(mapa5));
		contentPane.add(lblmapa5);
		
		
		JLabel lblmapa4 = new JLabel("");
		lblmapa4.setBounds(1046, 382, 234, 334);
		ImageIcon imagens =new ImageIcon (Jogo.class.getResource("/Img/Mascote colorido.png"));
		Image mapa4= imagens.getImage().getScaledInstance(lblmapa4.getWidth(),lblmapa4.getHeight() , Image.SCALE_SMOOTH);
		lblmapa4.setIcon(new ImageIcon(mapa4));
		contentPane.add(lblmapa4);
		
		
		JLabel lblmapa3 = new JLabel("");
		lblmapa3.setBounds(416, 25, 600, 150);
		ImageIcon imagen =new ImageIcon (Jogo.class.getResource("/Img/logo2.png"));
		Image mapa3= imagen.getImage().getScaledInstance(lblmapa3.getWidth(),lblmapa3.getHeight() , Image.SCALE_SMOOTH);
		lblmapa3.setIcon(new ImageIcon(mapa3));
		contentPane.add(lblmapa3);
		
		JLabel nnnn = new JLabel("");
		nnnn.setBounds(416, 90, 600, 600);
		ImageIcon image =new ImageIcon (Jogo.class.getResource("/Img/BrasilVetranscolo.png"));
		Image mapa2= image.getImage().getScaledInstance(nnnn.getWidth(),nnnn.getHeight() , Image.SCALE_SMOOTH);
		nnnn.setIcon(new ImageIcon(mapa2));
		contentPane.add(nnnn);
		
		JLabel lblMapa = new JLabel("");
		lblMapa.setBounds(0, 0, 1400, 1000);
		ImageIcon imagem =new ImageIcon (Jogo.class.getResource("/Img/fundooceano.png"));
		Image mapa= imagem.getImage().getScaledInstance(lblMapa.getWidth(),lblMapa.getHeight() , Image.SCALE_SMOOTH);
		lblMapa.setIcon(new ImageIcon(mapa));
		contentPane.add(lblMapa);
		
		
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String connectionurl= "jdbc:sqlserver://localhost:1433;"+"databaseName=bancoteste";
			Connection con = DriverManager.getConnection(connectionurl,"sa","123");
			
			java.sql.Statement stmt =con.createStatement();
				ResultSet rs=stmt.executeQuery("SELECT * FROM Rank ORDER BY pontos DESC;;");
				while(rs.next()){
					 String nome=rs.getString("nome");
					String pontos=rs.getString("pontos");
					System.out.println("Nome: "+nome+" Pontos: "+pontos);
					nomes.setText(nome);
					pontoos.setText(pontos);
                   	JOptionPane.showMessageDialog(null,"Nome: "+nome+"Pontos: "+pontos);
				}

				
				
			
		}catch(Exception eX){
					System.out.println("não conectou "+eX.getMessage());
		}
		
		
		
		
		
		
	}
}
