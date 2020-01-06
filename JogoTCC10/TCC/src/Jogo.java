import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;


public class Jogo extends JFrame {
	
	private JPanel contentPane;
	
	 public void Sounds() {
	     
	      try {
	   
	         URL url = this.getClass().getClassLoader().getResource("Audio/1.wav");
	         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
	      
	         Clip clip = AudioSystem.getClip();
	   
	         clip.open(audioIn);
	         clip.start();
	         clip.loop(Clip.LOOP_CONTINUOUSLY); 
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
	   }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		 EventQueue.invokeLater(new Runnable() {
			public void run() {
			try {
					Jogo frame = new Jogo();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			new Sounds();
			
			}
			
			
		});
			
	}
	

	/**
	 * Create the frame.
	 */
	public Jogo() {
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Jogo.class.getResource("/Img/icone.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnjogar = new JButton("");
		btnjogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Fase1 pag2 = new Fase1();  
	             pag2.setVisible(true);
	             pag2.setExtendedState(JFrame.MAXIMIZED_BOTH);
	             dispose();
	             try {
					   
			         URL url = this.getClass().getClassLoader().getResource("Audio/9.wav");
			         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			      
			         Clip clip = AudioSystem.getClip();
			   
			         clip.open(audioIn);
			         clip.start();
			         } catch (UnsupportedAudioFileException e) {
			         e.printStackTrace();
			      } catch (IOException e) {
			         e.printStackTrace();
			      } catch (LineUnavailableException e) {
			         e.printStackTrace();
			      }
			}
		});
		btnjogar.setBounds(613, 201, 205, 65);
		ImageIcon imagens1 =new ImageIcon (Jogo.class.getResource("/Img/Bot1.png"));
		Image botao= imagens1.getImage().getScaledInstance(btnjogar.getWidth(),btnjogar.getHeight() , Image.SCALE_SMOOTH);
		btnjogar.setIcon(new ImageIcon(botao));
		contentPane.add(btnjogar);
		
		JButton btnraking = new JButton("");
		btnraking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Ranking pag2 = new Ranking();  
	             pag2.setVisible(true);
	             pag2.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
		btnraking.setBounds(613, 277, 205, 65);
		ImageIcon imagens2 =new ImageIcon (Jogo.class.getResource("/Img/Bot2.png"));
		Image botao2= imagens2.getImage().getScaledInstance(btnraking.getWidth(),btnraking.getHeight() , Image.SCALE_SMOOTH);
		btnraking.setIcon(new ImageIcon(botao2));
		contentPane.add(btnraking);
		
		JButton btnajuda = new JButton("");
		btnajuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ajuda pag3 = new Ajuda();
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
		btnajuda.setBounds(613, 353, 205, 65);
		ImageIcon imagens3 =new ImageIcon (Jogo.class.getResource("/Img/Bot4.png"));
		Image botao3= imagens3.getImage().getScaledInstance(btnajuda.getWidth(),btnajuda.getHeight() , Image.SCALE_SMOOTH);
		btnajuda.setIcon(new ImageIcon(botao3));
		contentPane.add(btnajuda);
		
		JButton btnsair = new JButton("");
		btnsair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		btnsair.setBounds(613, 429, 205, 65);
		ImageIcon imagens4 =new ImageIcon (Jogo.class.getResource("/Img/Bot3.png"));
		Image botao4= imagens4.getImage().getScaledInstance(btnsair .getWidth(),btnsair .getHeight() , Image.SCALE_SMOOTH);
		btnsair .setIcon(new ImageIcon(botao4));
		contentPane.add(btnsair);
		
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
		lblmapa3.setBounds(382, 24, 600, 150);
		ImageIcon imagen =new ImageIcon (Jogo.class.getResource("/Img/logo2.png"));
		Image mapa3= imagen.getImage().getScaledInstance(lblmapa3.getWidth(),lblmapa3.getHeight() , Image.SCALE_SMOOTH);
		lblmapa3.setIcon(new ImageIcon(mapa3));
		contentPane.add(lblmapa3);
		
		JLabel lblMapa2 = new JLabel("");
		lblMapa2.setBounds(382, 86, 600, 600);
		ImageIcon image =new ImageIcon (Jogo.class.getResource("/Img/BrasilVetranscolo.png"));
		Image mapa2= image.getImage().getScaledInstance(lblMapa2.getWidth(),lblMapa2.getHeight() , Image.SCALE_SMOOTH);
		lblMapa2.setIcon(new ImageIcon(mapa2));
		contentPane.add(lblMapa2);
		
		JLabel lblMapa = new JLabel("");
		lblMapa.setBounds(0, 0, 1400, 1000);
		ImageIcon imagem =new ImageIcon (Jogo.class.getResource("/Img/fundooceano.png"));
		Image mapa= imagem.getImage().getScaledInstance(lblMapa.getWidth(),lblMapa.getHeight() , Image.SCALE_SMOOTH);
		lblMapa.setIcon(new ImageIcon(mapa));
		contentPane.add(lblMapa);

	}

	protected static void DISPOSE_ON_CLOSE() {
		// TODO Auto-generated method stub
		
	}
}
