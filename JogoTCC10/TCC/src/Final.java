import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Font;
import javax.swing.JTextField;




public class Final extends JFrame {

	private JPanel contentPane;
	public JTextField txtpont;
	public JTextField txtnome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Final frame = new Final();
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
	public Final() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(proxima.class.getResource("/Img/icone.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		txtpont = new JTextField();
		txtpont.setEditable(false);
		txtpont.setHorizontalAlignment(JTextField.CENTER);
		txtpont.setVisible(true);
		txtpont.setFont(new Font("Arial", Font.BOLD, 22));
		txtpont.setBounds(580, 245, 234, 47);
		contentPane.add(txtpont);
		txtpont.setColumns(10);
		txtpont.setText("");
		
		
		
		
		txtnome = new JTextField();
		txtnome.setHorizontalAlignment(JTextField.CENTER);
		txtnome.setVisible(true);
		txtnome.setFont(new Font("Arial", Font.BOLD, 22));
		txtnome.setBounds(580, 336, 234, 47);
		contentPane.add(txtnome);
		txtnome.setColumns(10);
		ImageIcon imagens3 =new ImageIcon (Jogo.class.getResource("/Img/btnsalvar.png"));
		
		JLabel lblSuaPontuaoFoi = new JLabel("Sua Pontuação Foi : ");
		lblSuaPontuaoFoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSuaPontuaoFoi.setBounds(389, 243, 183, 51);
		contentPane.add(lblSuaPontuaoFoi);
		
		JLabel lblNewLabel_1 = new JLabel("Digite seu Nome: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(389, 334, 183, 51);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblObrigadoPorJogar = new JLabel("Obrigado por Jogar !");
		lblObrigadoPorJogar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblObrigadoPorJogar.setBounds(596, 422, 188, 37);
		contentPane.add(lblObrigadoPorJogar);
		
	
		
		JButton btnsalvar = new JButton("");
		btnsalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String connectionurl= "jdbc:sqlserver://127.0.0.1:1433;"+"databaseName=bancoteste";
				
				try{
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection con = DriverManager.getConnection(connectionurl,"sa","123");
							System.out.println("conectado");
							
							String g="INSERT INTO Rank (nome,pontos) VALUES(?,?)";
							java.sql.PreparedStatement stmt=con.prepareStatement(g);
							stmt.setString(1,txtnome.getText());
							stmt.setString(2,txtpont.getText());
							
							stmt.executeUpdate();
							stmt.close();
							con.close();
							
							
				}catch(SQLException ex){
					System.out.println(ex.getMessage());
				}catch(Exception e){
					System.out.println("não conectou"+e.getMessage());
				}
				
				
				
				
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
				 
				 Ranking el=new Ranking();
				 el.setVisible(true);
				 el.setExtendedState(JFrame.MAXIMIZED_BOTH);
		            dispose(); 
				 
			}});
		
		
		JButton btnrepetir = new JButton("");
		btnrepetir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fase1 pag3 = new Fase1();
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
		btnrepetir.setBounds(862, 497, 205, 65);
		ImageIcon imagens5 =new ImageIcon (Jogo.class.getResource("/Img/btnrepetir.png"));
		Image botao4= imagens5.getImage().getScaledInstance(btnrepetir.getWidth(),btnrepetir.getHeight() , Image.SCALE_SMOOTH);
		btnrepetir.setIcon(new ImageIcon(botao4));
		contentPane.add(btnrepetir);
		
		btnsalvar.setBounds(580, 497, 205, 65);
		ImageIcon imagens50 =new ImageIcon (Jogo.class.getResource("/Img/btnsalvar.png"));
		Image botao40= imagens50.getImage().getScaledInstance(btnrepetir.getWidth(),btnrepetir.getHeight() , Image.SCALE_SMOOTH);
		btnsalvar.setIcon(new ImageIcon(botao40));
		contentPane.add(btnsalvar);
		
		JButton btnmenu = new JButton("");
		btnmenu.addActionListener(new ActionListener() {
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
		btnmenu.setBounds(298, 497, 205, 65);
		ImageIcon imagens7 =new ImageIcon (Jogo.class.getResource("/Img/btnmenu.png"));
		Image botao7= imagens7.getImage().getScaledInstance(btnmenu.getWidth(),btnmenu.getHeight() , Image.SCALE_SMOOTH);
		btnmenu.setIcon(new ImageIcon(botao7));
		contentPane.add(btnmenu);
		
		JLabel lblMapa = new JLabel("");
		lblMapa.setBounds(0, 0, 1372, 710);
		ImageIcon imagem =new ImageIcon (Jogo.class.getResource("/Img/tela3.png"));
		Image mapa= imagem.getImage().getScaledInstance(lblMapa.getWidth(),lblMapa.getHeight() , Image.SCALE_SMOOTH);
		contentPane.setLayout(null);
		lblMapa.setIcon(new ImageIcon(mapa));
		contentPane.add(lblMapa);
		
		
		
		
		
	}
}
