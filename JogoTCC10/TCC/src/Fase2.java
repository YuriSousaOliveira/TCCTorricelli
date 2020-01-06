import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionAdapter;

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
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import javax.swing.JTextField;


public class Fase2 extends JFrame {
	
	Boolean b1=false;
	int c1=0;
	int c2=0;
	int pontos= 0;
	int ponto= 0;
	int pontoss= 0;

	
	public JTextField txt2;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fase2 frame = new Fase2();
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
	public Fase2() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ranking.class.getResource("/Img/icone.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblerro = new JLabel("");
		lblerro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblerro.setBounds(322, 40, 409, 30);
		lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
		contentPane.add(lblerro);
		
		txt2 = new JTextField();
		txt2.setEditable(false);
		txt2.setBounds(57, 122, 86, 20);
		contentPane.add(txt2);
		txt2.setColumns(10);
		txt2.setVisible(false);
		
		final JLabel lblponto = new JLabel("");
		lblponto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblponto.setBounds(772, 40, 301, 30);
		lblponto.setText("Sua Pontuação:será atualizada ");
		contentPane.add(lblponto);
		
		final JLabel Tocantins4 = new JLabel("");
		Tocantins4.setBounds(458, 326, 30, 30);
		ImageIcon imagem129 =new ImageIcon (Jogo.class.getResource("/Siglasc/TO.png"));
		Image tocar= imagem129.getImage().getScaledInstance(Tocantins4.getWidth(),Tocantins4.getHeight() , Image.SCALE_SMOOTH);
		Tocantins4.setIcon(new ImageIcon(tocar));
		Tocantins4.setVisible(false);
		contentPane.add(Tocantins4);
		
		final JLabel Tocantins3 = new JLabel("");
		Tocantins3.setBounds(460, 324, 21, 15);
		ImageIcon imagem96 =new ImageIcon (Jogo.class.getResource("/Estados/Tocantins.png"));
		Image tocantinss= imagem96.getImage().getScaledInstance(Tocantins3.getWidth(),Tocantins3.getHeight() , Image.SCALE_SMOOTH);
		Tocantins3.setIcon(new ImageIcon(tocantinss));
		Tocantins3.setVisible(false);
		contentPane.add(Tocantins3);
		
		final JLabel Tocantins2 = new JLabel("");
		Tocantins2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);
				
				
			}
		});
		Tocantins2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Tocantins2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				 b1=false;
				Tocantins2.setEnabled(false);
				Validacao valid2=new Validacao();
				valid2.validatocantins(Tocantins2, Tocantins4);
				
				Rectangle ac1= Tocantins2.getBounds();
				Rectangle ac2= Tocantins4.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					Tocantins4.setVisible(true);
					Tocantins2.setVisible(false);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/7.wav");
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
				
				else{
					ponto+=1;
					pontoss-=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Tocantins2.setBounds(1065, 231, 100, 50);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/3.wav");
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
				if(pontos==10){
					proxima2 frame = new proxima2();
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					frame.txtpont.setText(String.valueOf(pontoss+p));
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/5.wav");
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
				if(ponto==10){
					Game frame = new Game();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					  try {
						   
					         URL url = this.getClass().getClassLoader().getResource("Audio/Erro.wav");
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
			}
		});
		Tocantins2.setEnabled(false);
		Tocantins2.setBounds(1065, 231,50, 50);
		ImageIcon imagem27 =new ImageIcon (Jogo.class.getResource("/Siglasc/TO.png"));
		Image Tocantins= imagem27.getImage().getScaledInstance(Tocantins2.getWidth(),Tocantins2.getHeight() , Image.SCALE_SMOOTH);
		Tocantins2.setIcon(new ImageIcon(Tocantins));
		contentPane.add(Tocantins2);
		
		final JLabel Sergipe4 = new JLabel("");
		Sergipe4.setBounds(623, 333, 30, 30);
		ImageIcon imagem1230 =new ImageIcon (Jogo.class.getResource("/Siglasc/SE.png"));
		Image sercars= imagem1230.getImage().getScaledInstance(Sergipe4.getWidth(),Sergipe4.getHeight() , Image.SCALE_SMOOTH);
		Sergipe4.setIcon(new ImageIcon(sercars));
		Sergipe4.setVisible(false);
		contentPane.add(Sergipe4);
		
		final JLabel Sergipe3 = new JLabel("");
		Sergipe3.setBounds(634, 338, 11, 9);
		ImageIcon imagem95 =new ImageIcon (Jogo.class.getResource("/Estados/Sergipe.png"));
		Image sergipes= imagem95.getImage().getScaledInstance(Sergipe3.getWidth(),Sergipe3.getHeight() , Image.SCALE_SMOOTH);
		Sergipe3.setIcon(new ImageIcon(sergipes));
		Sergipe3.setVisible(false);
		contentPane.add(Sergipe3);
		
		final JLabel Sergipe2 = new JLabel("");
		Sergipe2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);
				
				
			}
		});
		Sergipe2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Sergipe2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				 b1=false;
				Sergipe2.setEnabled(false);
				Validacao valid2=new Validacao();
				valid2.validasergipe(Sergipe2, Sergipe4);
				
				Rectangle ac1= Sergipe2.getBounds();
				Rectangle ac2= Sergipe4.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					Sergipe4.setVisible(true);
					Sergipe2.setVisible(false);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/7.wav");
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
				
				else{
					ponto+=1;
					pontoss-=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Sergipe2.setBounds(1235, 113, 100, 50);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/3.wav");
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
				if(pontos==270){
					Final frame = new Final();
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					frame.txtpont.setText(String.valueOf(pontoss+p));
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/5.wav");
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
				if(ponto==10){
					Game frame = new Game();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					  try {
						   
					         URL url = this.getClass().getClassLoader().getResource("Audio/Erro.wav");
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
			}
		});
		Sergipe2.setEnabled(false);
		Sergipe2.setBounds(1235, 113, 50, 50);
		ImageIcon imagem26 =new ImageIcon (Jogo.class.getResource("/Siglasc/SE.png"));
		Image Sergipe= imagem26.getImage().getScaledInstance(Sergipe2.getWidth(),Sergipe2.getHeight() , Image.SCALE_SMOOTH);
		Sergipe2.setIcon(new ImageIcon(Sergipe));
		contentPane.add(Sergipe2);
		
		final JLabel Paulo4 = new JLabel("");
		Paulo4.setBounds(451, 505, 30, 30);
		ImageIcon imagem123 =new ImageIcon (Jogo.class.getResource("/Siglasc/SP.png"));
		Image roraimn= imagem123.getImage().getScaledInstance(Paulo4.getWidth(),Paulo4.getHeight() , Image.SCALE_SMOOTH);
		Paulo4.setIcon(new ImageIcon(roraimn));
		Paulo4.setVisible(false);
		contentPane.add(Paulo4);
		
		final JLabel Paulo3 = new JLabel("");
		Paulo3.setBounds(459, 502, 15, 16);
		ImageIcon imagem40 =new ImageIcon (Jogo.class.getResource("/Estados/São Paulo.png"));
		Image Pauloso= imagem40.getImage().getScaledInstance(Paulo3.getWidth(),Paulo3.getHeight(),Image.SCALE_SMOOTH);
		Paulo3.setIcon(new ImageIcon(Pauloso));
		Paulo3.setVisible(false);
		contentPane.add(Paulo3);
		
		final JLabel Paulo2 = new JLabel("");
		Paulo2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);
				
				
			}
		});
		Paulo2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Paulo2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				 b1=false;
				Paulo2.setEnabled(false);
				Validacao valid2=new Validacao();
				valid2.validapaulo(Paulo2, Paulo4);
				
				Rectangle ac1= Paulo2.getBounds();
				Rectangle ac2= Paulo4.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					Paulo4.setVisible(true);
					Paulo2.setVisible(false);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/7.wav");
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
				
				else{
					ponto+=1;
					pontoss-=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Paulo2.setBounds(1065, 113, 100, 50);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/3.wav");
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
				if(pontos==270){
					proxima2 frame = new proxima2();
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					frame.txtpont.setText(String.valueOf(pontoss+p));
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/5.wav");
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
				if(ponto==10){
					Game frame = new Game();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					  try {
						   
					         URL url = this.getClass().getClassLoader().getResource("Audio/Erro.wav");
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
			}
		});
		Paulo2.setEnabled(false);
		Paulo2.setBounds(1065, 113, 50, 50);
		ImageIcon imagem25 =new ImageIcon (Jogo.class.getResource("/Siglasc/SP.png"));
		Image Paulo= imagem25.getImage().getScaledInstance(Paulo2.getWidth(),Paulo2.getHeight() , Image.SCALE_SMOOTH);
		Paulo2.setIcon(new ImageIcon(Paulo));
		contentPane.add(Paulo2);
		
		final JLabel Santa4 = new JLabel("");
		Santa4.setBounds(433, 581, 30, 30);
		ImageIcon imagem1201 =new ImageIcon (Jogo.class.getResource("/Siglasc/SC.png"));
		Image santasss= imagem1201.getImage().getScaledInstance(Santa4.getWidth(),Santa4.getHeight() , Image.SCALE_SMOOTH);
		Santa4.setIcon(new ImageIcon(santasss));
		Santa4.setVisible(false);
		contentPane.add(Santa4);
		
		final JLabel Santa3 = new JLabel("");
		Santa3.setBounds(446, 593, 12, 7);
		ImageIcon imagem94 =new ImageIcon (Jogo.class.getResource("/Estados/Santa Catarina.png"));
		Image santafss= imagem94.getImage().getScaledInstance(Santa3.getWidth(),Santa3.getHeight() , Image.SCALE_SMOOTH);
		Santa3.setIcon(new ImageIcon(santafss));
		Santa3.setVisible(false);
		contentPane.add(Santa3);
		
		final JLabel Santa2 = new JLabel("");
		Santa2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);
				
				
			}
		});
		Santa2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Santa2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				 b1=false;
				Santa2.setEnabled(false);
				Validacao valid2=new Validacao();
				valid2.validasanta(Santa2, Santa4);
				
				Rectangle ac1= Santa2.getBounds();
				Rectangle ac2= Santa4.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					Santa4.setVisible(true);
					Santa2.setVisible(false);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/7.wav");
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
				
				else{
					ponto+=1;
					pontoss-=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Santa2.setBounds(1235, 175, 100, 50);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/3.wav");
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
				if(pontos==270){
					proxima2 frame = new proxima2();
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					frame.txtpont.setText(String.valueOf(pontoss+p));
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/5.wav");
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
				if(ponto==10){
					Game frame = new Game();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					  try {
						   
					         URL url = this.getClass().getClassLoader().getResource("Audio/Erro.wav");
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
			}
		});
		Santa2.setEnabled(false);
		Santa2.setBounds(1235, 175, 50, 50);
		ImageIcon imagem24 =new ImageIcon (Jogo.class.getResource("/Siglasc/SC.png"));
		Image Santa= imagem24.getImage().getScaledInstance(Santa2.getWidth(),Santa2.getHeight() , Image.SCALE_SMOOTH);
		Santa2.setIcon(new ImageIcon(Santa));
		contentPane.add(Santa2);
		
		final JLabel Roraima4 = new JLabel("");
		Roraima4.setBounds(239, 334, 30, 30);
		ImageIcon imagem12223 =new ImageIcon (Jogo.class.getResource("/Siglasc/RR.png"));
		Image rorr= imagem12223.getImage().getScaledInstance(Roraima4.getWidth(),Roraima4.getHeight() , Image.SCALE_SMOOTH);
		Roraima4.setIcon(new ImageIcon(rorr));
		Roraima4.setVisible(false);
		contentPane.add(Roraima4);
		
		final JLabel Roraima3 = new JLabel("");
		Roraima3.setBounds(272, 143, 9, 15);
		ImageIcon imagem92 =new ImageIcon (Jogo.class.getResource("/Estados/Roraima.png"));
		Image roraimas= imagem92.getImage().getScaledInstance(Roraima3.getWidth(),Roraima3.getHeight() , Image.SCALE_SMOOTH);
		Roraima3.setIcon(new ImageIcon(roraimas));
		Roraima3.setVisible(false);
		contentPane.add(Roraima3);
		
		final JLabel Roraima2 = new JLabel("");
		Roraima2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);
				
				
			}
		});
		Roraima2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Roraima2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				 b1=false;
				Roraima2.setEnabled(false);
				Validacao valid2=new Validacao();
				valid2.validaroraima(Roraima2, Roraima4);
				
				Rectangle ac1= Roraima2.getBounds();
				Rectangle ac2= Roraima4.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					Roraima4.setVisible(true);
					Roraima2.setVisible(false);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/7.wav");
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
				
				else{
					ponto+=1;
					pontoss-=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Roraima2.setBounds(1065, 307, 100, 50);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/3.wav");
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
				if(pontos==270){
					proxima2 frame = new proxima2();
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					frame.txtpont.setText(String.valueOf(pontoss+p));
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/5.wav");
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
				if(ponto==10){
					Game frame = new Game();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					  try {
						   
					         URL url = this.getClass().getClassLoader().getResource("Audio/Erro.wav");
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
			}
		});
		Roraima2.setEnabled(false);
		Roraima2.setBounds(1065, 307, 50, 50);
		ImageIcon imagem23 =new ImageIcon (Jogo.class.getResource("/Siglasc/RR.png"));
		Image Roraima= imagem23.getImage().getScaledInstance(Roraima2.getWidth(),Roraima2.getHeight() , Image.SCALE_SMOOTH);
		Roraima2.setIcon(new ImageIcon(Roraima));
		contentPane.add(Roraima2);
		
		final JLabel Rondonia4 = new JLabel("");
		Rondonia4.setBounds(264, 132,30, 30);
		ImageIcon imagem121 =new ImageIcon (Jogo.class.getResource("/Siglasc/RO.png"));
		Image rondon= imagem121.getImage().getScaledInstance(Rondonia4.getWidth(),Rondonia4.getHeight() , Image.SCALE_SMOOTH);
		Rondonia4.setIcon(new ImageIcon(rondon));
		Rondonia4.setVisible(false);
		contentPane.add(Rondonia4);
		
		final JLabel Rondonia3 = new JLabel("");
		Rondonia3.setBounds(244, 334, 10, 17);
		ImageIcon imagem91 =new ImageIcon (Jogo.class.getResource("/Estados/Rondonia.png"));
		Image rondoniass= imagem91.getImage().getScaledInstance(Rondonia3.getWidth(),Rondonia3.getHeight() , Image.SCALE_SMOOTH);
		Rondonia3.setIcon(new ImageIcon(rondoniass));
		Rondonia3.setVisible(false);
		contentPane.add(Rondonia3);
		
		final JLabel Rondonia2 = new JLabel("");
		Rondonia2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);
				
				
			}
		});
		Rondonia2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Rondonia2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				 b1=false;
				Rondonia2.setEnabled(false);
				Validacao valid2=new Validacao();
				valid2.validarondonia(Rondonia2, Rondonia4);
				
				Rectangle ac1= Rondonia2.getBounds();
				Rectangle ac2= Rondonia4.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					Rondonia4.setVisible(true);
					Rondonia2.setVisible(false);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/7.wav");
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
				
				else{
					ponto+=1;
					pontoss-=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Rondonia2.setBounds(891, 113, 100, 50);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/3.wav");
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
				if(pontos==270){
					proxima2 frame = new proxima2();
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					frame.txtpont.setText(String.valueOf(pontoss+p));
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/5.wav");
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
				if(ponto==10){
					Game frame = new Game();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					  try {
						   
					         URL url = this.getClass().getClassLoader().getResource("Audio/Erro.wav");
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
			}
		});
		Rondonia2.setEnabled(false);
		Rondonia2.setBounds(891, 113, 50, 50);
		ImageIcon imagem22 =new ImageIcon (Jogo.class.getResource("/Siglasc/RO.png"));
		Image Rondonia= imagem22.getImage().getScaledInstance(Rondonia2.getWidth(),Rondonia2.getHeight() , Image.SCALE_SMOOTH);
		Rondonia2.setIcon(new ImageIcon(Rondonia));
		contentPane.add(Rondonia2);
		
		final JLabel RGSul4 = new JLabel("");
		RGSul4.setBounds(383, 620, 30, 30);
		ImageIcon imagem118 =new ImageIcon (Jogo.class.getResource("/Siglasc/RS.png"));
		Image riog= imagem118.getImage().getScaledInstance(RGSul4.getWidth(),RGSul4.getHeight() , Image.SCALE_SMOOTH);
		RGSul4.setIcon(new ImageIcon(riog));
		RGSul4.setVisible(false);
		contentPane.add(RGSul4);
		
		final JLabel RGSul3 = new JLabel("");
		RGSul3.setBounds(389, 628, 21, 17);
		ImageIcon imagem90 =new ImageIcon (Jogo.class.getResource("/Estados/Rio Grande do Sul.png"));
		Image rgsuls= imagem90.getImage().getScaledInstance(RGSul3.getWidth(),RGSul3.getHeight() , Image.SCALE_SMOOTH);
		RGSul3.setIcon(new ImageIcon(rgsuls));
		RGSul3.setVisible(false);
		contentPane.add(RGSul3);
		
		final JLabel RGSul2 = new JLabel("");
		RGSul2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);
				
				
			}
		});
		RGSul2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				RGSul2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				 b1=false;
				RGSul2.setEnabled(false);
				Validacao valid2=new Validacao();
				valid2.validargsul(RGSul2, RGSul4);
				
				Rectangle ac1= RGSul2.getBounds();
				Rectangle ac2= RGSul4.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					RGSul4.setVisible(true);
					RGSul2.setVisible(false);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/7.wav");
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
				
				else{
					ponto+=1;
					pontoss-=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					RGSul2.setBounds(891, 175, 100, 50);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/3.wav");
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
				if(pontos==270){
					proxima2 frame = new proxima2();
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					frame.txtpont.setText(String.valueOf(pontoss+p));
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/5.wav");
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
				if(ponto==10){
					Game frame = new Game();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					  try {
						   
					         URL url = this.getClass().getClassLoader().getResource("Audio/Erro.wav");
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
			}
		});
		RGSul2.setEnabled(false);
		RGSul2.setBounds(891, 175,50, 50);
		ImageIcon imagem21 =new ImageIcon (Jogo.class.getResource("/Siglasc/RS.png"));
		Image RGSul= imagem21.getImage().getScaledInstance(RGSul2.getWidth(),RGSul2.getHeight() , Image.SCALE_SMOOTH);
		RGSul2.setIcon(new ImageIcon(RGSul));
		contentPane.add(RGSul2);
		
		final JLabel RGNorte4 = new JLabel("");
		RGNorte4.setBounds(634, 251, 30, 30);
		ImageIcon imagem117 =new ImageIcon (Jogo.class.getResource("/Siglasc/RN.png"));
		Image noten= imagem117.getImage().getScaledInstance(RGNorte4.getWidth(),RGNorte4.getHeight() , Image.SCALE_SMOOTH);
		RGNorte4.setIcon(new ImageIcon(noten));
		RGNorte4.setVisible(false);
		contentPane.add(RGNorte4);
		
		final JLabel RGNorte3 = new JLabel("");
		RGNorte3.setBounds(637, 259, 5, 5);
		ImageIcon imagem88 =new ImageIcon (Jogo.class.getResource("/Estados/Rio Grande do Norte.png"));
		Image rgnortes= imagem88.getImage().getScaledInstance(RGNorte3.getWidth(),RGNorte3.getHeight() , Image.SCALE_SMOOTH);
		RGNorte3.setIcon(new ImageIcon(rgnortes));
		RGNorte3.setVisible(false);
		contentPane.add(RGNorte3);
		
		final JLabel RGNorte2 = new JLabel("");
		RGNorte2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);
				
				
			}
		});
		RGNorte2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				RGNorte2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				 b1=false;
				RGNorte2.setEnabled(false);
				Validacao valid2=new Validacao();
				valid2.validargnorte(RGNorte2, RGNorte4);
				
				Rectangle ac1= RGNorte2.getBounds();
				Rectangle ac2= RGNorte4.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					RGNorte4.setVisible(true);
					RGNorte2.setVisible(false);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/7.wav");
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
				
				else{
					ponto+=1;
					pontoss-=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					RGNorte2.setBounds(1235, 239, 100, 50);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/3.wav");
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
				
				if(pontos==270){
					proxima2 frame = new proxima2();
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					frame.txtpont.setText(String.valueOf(pontoss+p));
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/5.wav");
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
				if(ponto==10){
					Game frame = new Game();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					  try {
						   
					         URL url = this.getClass().getClassLoader().getResource("Audio/Erro.wav");
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
			}
		});
		RGNorte2.setEnabled(false);
		RGNorte2.setBounds(1235, 239, 50, 50);
		ImageIcon imagem20 =new ImageIcon (Jogo.class.getResource("/Siglasc/RN.png"));
		Image RGNorte= imagem20.getImage().getScaledInstance(RGNorte2.getWidth(),RGNorte2.getHeight() , Image.SCALE_SMOOTH);
		RGNorte2.setIcon(new ImageIcon(RGNorte));
		contentPane.add(RGNorte2);
		
		final JLabel Rio4 = new JLabel("");
		Rio4.setBounds(542, 505, 30, 30);
		ImageIcon imagem150 =new ImageIcon (Jogo.class.getResource("/Siglasc/RJ.png"));
		Image rion= imagem150.getImage().getScaledInstance(Rio4.getWidth(),Rio4.getHeight() , Image.SCALE_SMOOTH);
		Rio4.setIcon(new ImageIcon(rion));
		Rio4.setVisible(false);
		contentPane.add(Rio4);
		
		final JLabel Rio3 = new JLabel("");
		Rio3.setBounds(560, 513, 13, 1);
		ImageIcon imagem87 =new ImageIcon (Jogo.class.getResource("/Estados/Rio de Janeiro.png"));
		Image rioss= imagem87.getImage().getScaledInstance(Rio3.getWidth(),Rio3.getHeight() , Image.SCALE_SMOOTH);
		Rio3.setIcon(new ImageIcon(rioss));
		Rio3.setVisible(false);
		contentPane.add(Rio3);
		
		final JLabel Rio2 = new JLabel("");
		Rio2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);
				
				
			}
		});
		Rio2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Rio2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				 b1=false;
				Rio2.setEnabled(false);
				Validacao valid2=new Validacao();
				valid2.validario(Rio2, Rio4);
				
				Rectangle ac1= Rio2.getBounds();
				Rectangle ac2= Rio4.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					Rio4.setVisible(true);
					Rio2.setVisible(false);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/7.wav");
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
				
				else{
					ponto+=1;
					pontoss-=10;
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Rio2.setBounds(1235, 307, 100, 50);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/3.wav");
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
				
				if(pontos==270){
					proxima2 frame = new proxima2();
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					frame.txtpont.setText(String.valueOf(pontoss+p));
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/5.wav");
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
				if(ponto==10){
					Game frame = new Game();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					  try {
						   
					         URL url = this.getClass().getClassLoader().getResource("Audio/Erro.wav");
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
			}
		});
		Rio2.setEnabled(false);
		Rio2.setBounds(1235, 307, 50, 50);
		ImageIcon imagem19 =new ImageIcon (Jogo.class.getResource("/Siglasc/RJ.png"));
		Image Rio= imagem19.getImage().getScaledInstance(Rio2.getWidth(),Rio2.getHeight() , Image.SCALE_SMOOTH);
		Rio2.setIcon(new ImageIcon(Rio));
		contentPane.add(Rio2);
		
		final JLabel Piaui4 = new JLabel("");
		Piaui4.setBounds(547, 285, 30, 30);
		ImageIcon imagem89 =new ImageIcon (Jogo.class.getResource("/Siglasc/PI.png"));
		Image piauis= imagem89.getImage().getScaledInstance(Piaui4.getWidth(),Piaui4.getHeight() , Image.SCALE_SMOOTH);
		Piaui4.setIcon(new ImageIcon(piauis));
		Piaui4.setVisible(false);
		contentPane.add(Piaui4);
		
		final JLabel Piaui3 = new JLabel("");
		Piaui3.setBounds(560, 277, 9, 17);
		ImageIcon imagem8g9 =new ImageIcon (Jogo.class.getResource("/Estados/Piaui.png"));
		Image piauisss= imagem8g9.getImage().getScaledInstance(Piaui3.getWidth(),Piaui3.getHeight() , Image.SCALE_SMOOTH);
		Piaui3.setIcon(new ImageIcon(piauisss));
		Piaui3.setVisible(false);
		contentPane.add(Piaui3);
		
		
		final JLabel Piaui2 = new JLabel("");
		Piaui2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);
				
				
			}
		});
		Piaui2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Piaui2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				 b1=false;
				Piaui2.setEnabled(false);
				Validacao valid2=new Validacao();
				valid2.validapiaui(Piaui2, Piaui4);
				
				Rectangle ac1= Piaui2.getBounds();
				Rectangle ac2= Piaui4.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					Piaui4.setVisible(true);
					Piaui2.setVisible(false);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/7.wav");
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
				
				else{
					ponto+=1;
					pontoss-=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Piaui2.setBounds(1235, 439, 100, 50);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/3.wav");
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
				if(pontos==270){
					proxima2 frame = new proxima2();
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					frame.txtpont.setText(String.valueOf(pontoss+p));
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/5.wav");
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
				if(ponto==10){
					Game frame = new Game();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					  try {
						   
					         URL url = this.getClass().getClassLoader().getResource("Audio/Erro.wav");
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
			}
		});
		Piaui2.setEnabled(false);
		Piaui2.setBounds(1235, 439, 50, 50);
		ImageIcon imagem18 =new ImageIcon (Jogo.class.getResource("/Siglasc/PI.png"));
		Image Piaui= imagem18.getImage().getScaledInstance(Piaui2.getWidth(),Piaui2.getHeight() , Image.SCALE_SMOOTH);
		Piaui2.setIcon(new ImageIcon(Piaui));
		contentPane.add(Piaui2);
		
		final JLabel Pernambuco4 = new JLabel("");
		Pernambuco4.setBounds(612, 292, 30, 30);
		ImageIcon imagem116 =new ImageIcon (Jogo.class.getResource("/Siglasc/PE.png"));
		Image omelhornatal= imagem116.getImage().getScaledInstance(Pernambuco4.getWidth(),Pernambuco4.getHeight() , Image.SCALE_SMOOTH);
		Pernambuco4.setIcon(new ImageIcon(omelhornatal));
		Pernambuco4.setVisible(false);
		contentPane.add(Pernambuco4);
		
		final JLabel Pernambuco3 = new JLabel("");
		Pernambuco3.setBounds(626, 303, 24, 1);
		ImageIcon imagem86 =new ImageIcon (Jogo.class.getResource("/Estados/Pernambuco.png"));
		Image Pernambucoss= imagem86.getImage().getScaledInstance(Pernambuco3.getWidth(),Pernambuco3.getHeight() , Image.SCALE_SMOOTH);
		Pernambuco3.setIcon(new ImageIcon(Pernambucoss));
		Pernambuco3.setVisible(false);
		contentPane.add(Pernambuco3);
		
		final JLabel Pernambuco2 = new JLabel("");
		Pernambuco2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);
				
				
			}
		});
		Pernambuco2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Pernambuco2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				 b1=false;
				Pernambuco2.setEnabled(false);
				Validacao valid2=new Validacao();
				valid2.validapernambuco(Pernambuco2, Pernambuco4);
				
				Rectangle ac1= Pernambuco2.getBounds();
				Rectangle ac2= Pernambuco4.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					Pernambuco4.setVisible(true);
					Pernambuco2.setVisible(false);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/7.wav");
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
				
				else{
					ponto+=1;
					pontoss-=10;
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Pernambuco2.setBounds(1065, 174, 100, 50);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/3.wav");
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
				if(pontos==270){
					proxima2 frame = new proxima2();
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					frame.txtpont.setText(String.valueOf(pontoss+p));
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/5.wav");
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
				if(ponto==10){
					Game frame = new Game();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					  try {
						   
					         URL url = this.getClass().getClassLoader().getResource("Audio/Erro.wav");
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
			}
		});
		Pernambuco2.setEnabled(false);
		Pernambuco2.setBounds(1065, 174, 50, 50);
		ImageIcon imagem17 =new ImageIcon (Jogo.class.getResource("/Siglasc/PE.png"));
		Image Pernambuco= imagem17.getImage().getScaledInstance(Pernambuco2.getWidth(),Pernambuco2.getHeight() , Image.SCALE_SMOOTH);
		Pernambuco2.setIcon(new ImageIcon(Pernambuco));
		contentPane.add(Pernambuco2);
		
		final JLabel Parana4 = new JLabel("");
		Parana4.setBounds(406, 539, 30, 30);
		ImageIcon imagem1211 =new ImageIcon (Jogo.class.getResource("/Siglasc/PR.png"));
		Image paran= imagem1211.getImage().getScaledInstance(Parana4.getWidth(),Parana4.getHeight() , Image.SCALE_SMOOTH);
		Parana4.setIcon(new ImageIcon(paran));
		Parana4.setVisible(false);
		contentPane.add(Parana4);
		
		final JLabel Parana3 = new JLabel("");
		Parana3.setBounds(410, 553, 29, 3);
		ImageIcon imagem85 =new ImageIcon (Jogo.class.getResource("/Estados/Parana.png"));
		Image Paranass= imagem85.getImage().getScaledInstance(Parana3.getWidth(),Parana3.getHeight() , Image.SCALE_SMOOTH);
		Parana3.setIcon(new ImageIcon(Paranass));
		Parana3.setVisible(false);
		contentPane.add(Parana3);
		
		final JLabel Parana2 = new JLabel("");
		Parana2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);
				
				
			}
		});
		Parana2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Parana2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				 b1=false;
				Parana2.setEnabled(false);
				Validacao valid2=new Validacao();
				valid2.validaparana(Parana2, Parana4);
				
				Rectangle ac1= Parana2.getBounds();
				Rectangle ac2= Parana4.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					Parana4.setVisible(true);
					Parana2.setVisible(false);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/7.wav");
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
				
				else{
					ponto+=1;
					pontoss-=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Parana2.setBounds(891, 307, 100, 50);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/3.wav");
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
				if(pontos==270){
					proxima2 frame = new proxima2();
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					frame.txtpont.setText(String.valueOf(pontoss+p));
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/5.wav");
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
				if(ponto==10){
					Game frame = new Game();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					  try {
						   
					         URL url = this.getClass().getClassLoader().getResource("Audio/Erro.wav");
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
			}
		});
		Parana2.setEnabled(false);
		Parana2.setBounds(891, 307,50, 50);
		ImageIcon imagem16 =new ImageIcon (Jogo.class.getResource("/Siglasc/PR.png"));
		Image Parana= imagem16.getImage().getScaledInstance(Parana2.getWidth(),Parana2.getHeight() , Image.SCALE_SMOOTH);
		Parana2.setIcon(new ImageIcon(Parana));
		contentPane.add(Parana2);
		
		final JLabel Paraiba4 = new JLabel("");
		Paraiba4.setBounds(636, 275, 30, 30);
		ImageIcon imagem115 =new ImageIcon (Jogo.class.getResource("/Siglasc/PB.png"));
		Image paraibans= imagem115.getImage().getScaledInstance(Paraiba4.getWidth(),Paraiba4.getHeight() , Image.SCALE_SMOOTH);
		Paraiba4.setIcon(new ImageIcon(paraibans));
		Paraiba4.setVisible(false);
		contentPane.add(Paraiba4);
		
		final JLabel Paraiba3 = new JLabel("");
		Paraiba3.setBounds(627, 284, 9, 1);
		ImageIcon imagem84 =new ImageIcon (Jogo.class.getResource("/Estados/Paraiba.png"));
		Image Paraibass= imagem84.getImage().getScaledInstance(Paraiba3.getWidth(),Paraiba3.getHeight() , Image.SCALE_SMOOTH);
		Paraiba3.setIcon(new ImageIcon(Paraibass));
		Paraiba3.setVisible(false);
		contentPane.add(Paraiba3);
		
		final JLabel Paraiba2 = new JLabel("");
		Paraiba2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);
				
				
			}
		});
		Paraiba2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Paraiba2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				 b1=false;
				Paraiba2.setEnabled(false);
				Validacao valid2=new Validacao();
				valid2.validaparaiba(Paraiba2, Paraiba4);
				
				Rectangle ac1= Paraiba2.getBounds();
				Rectangle ac2= Paraiba4.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					Paraiba4.setVisible(true);
					Paraiba2.setVisible(false);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/7.wav");
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
				
				else{
					ponto+=1;
					pontoss-=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Paraiba2.setBounds(1235, 380, 100, 50);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/3.wav");
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
				if(pontos==270){
					proxima2 frame = new proxima2();
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					frame.txtpont.setText(String.valueOf(pontoss+p));
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/5.wav");
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
				if(ponto==10){
					Game frame = new Game();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					  try {
						   
					         URL url = this.getClass().getClassLoader().getResource("Audio/Erro.wav");
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
			}
		});
		Paraiba2.setEnabled(false);
		Paraiba2.setBounds(1235, 380, 50, 50);
		ImageIcon imagem15 =new ImageIcon (Jogo.class.getResource("/Siglasc/PB.png"));
		Image Paraiba= imagem15.getImage().getScaledInstance(Paraiba2.getWidth(),Paraiba2.getHeight() , Image.SCALE_SMOOTH);
		Paraiba2.setIcon(new ImageIcon(Paraiba));
		contentPane.add(Paraiba2);
		
		final JLabel Para4 = new JLabel("");
		Para4.setBounds(381, 234, 30, 30);
		ImageIcon imagem114 =new ImageIcon (Jogo.class.getResource("/Siglasc/PA.png"));
		Image parado= imagem114.getImage().getScaledInstance(Para4.getWidth(),Para4.getHeight() , Image.SCALE_SMOOTH);
		Para4.setIcon(new ImageIcon(parado));
		Para4.setVisible(false);
		contentPane.add(Para4);
		
		final JLabel Para3 = new JLabel("");
		Para3.setBounds(368, 229, 59, 25);
		ImageIcon imagem83 =new ImageIcon (Jogo.class.getResource("/Estados/Para.png"));
		Image Parass= imagem83.getImage().getScaledInstance(Para3.getWidth(),Para3.getHeight() , Image.SCALE_SMOOTH);
		Para3.setIcon(new ImageIcon(Parass));
		Para3.setVisible(false);
		contentPane.add(Para3);
		
		final JLabel Para2 = new JLabel("");
		Para2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);
				
				
			}
		});
		Para2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Para2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				 b1=false;
				Para2.setEnabled(false);
				Validacao valid2=new Validacao();
				valid2.validapara(Para2, Para4);
				
				Rectangle ac1= Para2.getBounds();
				Rectangle ac2= Para4.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					Para4.setVisible(true);
					Para2.setVisible(false);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/7.wav");
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
				
				else{
					ponto+=1;
					pontoss-=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Para2.setBounds(1065, 380, 100, 50);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/3.wav");
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
				if(pontos==270){
					proxima2 frame = new proxima2();
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					frame.txtpont.setText(String.valueOf(pontoss+p));
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/5.wav");
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
				if(ponto==10){
					Game frame = new Game();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					  try {
						   
					         URL url = this.getClass().getClassLoader().getResource("Audio/Erro.wav");
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
			}
		});
		Para2.setEnabled(false);
		Para2.setBounds(1065, 380, 50, 50);
		ImageIcon imagem14 =new ImageIcon (Jogo.class.getResource("/Siglasc/PA.png"));
		Image Para= imagem14.getImage().getScaledInstance(Para2.getWidth(),Para2.getHeight() , Image.SCALE_SMOOTH);
		Para2.setIcon(new ImageIcon(Para));
		contentPane.add(Para2);
		
		final JLabel Minas4 = new JLabel("");
		Minas4.setBounds(510, 452, 30, 30);
		ImageIcon imagem1113 =new ImageIcon (Jogo.class.getResource("/Siglasc/MG.png"));
		Image Minass= imagem1113.getImage().getScaledInstance(Minas4.getWidth(),Minas4.getHeight() , Image.SCALE_SMOOTH);
		Minas4.setIcon(new ImageIcon(Minass));
		Minas4.setVisible(false);
		contentPane.add(Minas4);
		
		final JLabel Minas3 = new JLabel("");
		Minas3.setBounds(511, 456, 39, 17);
		ImageIcon imagem82 =new ImageIcon (Jogo.class.getResource("/Estados/Minas Gerais.png"));
		Image Minasss= imagem82.getImage().getScaledInstance(Minas3.getWidth(),Minas3.getHeight() , Image.SCALE_SMOOTH);
		Minas3.setIcon(new ImageIcon(Minasss));
		Minas3.setVisible(false);
		contentPane.add(Minas3);
		
		final JLabel Minas2 = new JLabel("");
		Minas2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);
				
				
			}
		});
		Minas2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Minas2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				 b1=false;
				Minas2.setEnabled(false);
				Validacao valid2=new Validacao();
				valid2.validaminas(Minas2, Minas4);
				
				Rectangle ac1= Minas2.getBounds();
				Rectangle ac2= Minas4.getBounds();
				
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					Minas4.setVisible(true);
					Minas2.setVisible(false);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/7.wav");
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
				
				else{
					ponto+=1;
					pontoss-=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Minas2.setBounds(891, 380, 100, 50);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/3.wav");
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
				if(pontos==270){
					proxima2 frame = new proxima2();
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					frame.txtpont.setText(String.valueOf(pontoss+p));
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/5.wav");
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
				if(ponto==10){
					Game frame = new Game();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose(); 
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/Erro.wav");
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
			}
		});
		Minas2.setEnabled(false);
		Minas2.setBounds(891, 380,50, 50);
		ImageIcon imagem13 =new ImageIcon (Jogo.class.getResource("/Siglasc/MG.png"));
		Image Minas= imagem13.getImage().getScaledInstance(Minas2.getWidth(),Minas2.getHeight() , Image.SCALE_SMOOTH);
		Minas2.setIcon(new ImageIcon(Minas));
		contentPane.add(Minas2);
		
		final JLabel Mato4 = new JLabel("");
		Mato4.setBounds(349, 376, 30, 30);
		ImageIcon imagem113 =new ImageIcon (Jogo.class.getResource("/Siglasc/MT.png"));
		Image Matonha= imagem113.getImage().getScaledInstance(Mato4.getWidth(),Mato4.getHeight() , Image.SCALE_SMOOTH);
		Mato4.setIcon(new ImageIcon(Matonha));
		Mato4.setVisible(false);
		contentPane.add(Mato4);
		
		final JLabel Mato3 = new JLabel("");
		Mato3.setBounds(337, 372, 53, 28);
		ImageIcon imagem81 =new ImageIcon (Jogo.class.getResource("/Estados/Mato Grosso.png"));
		Image Matoss= imagem81.getImage().getScaledInstance(Mato3.getWidth(),Mato3.getHeight() , Image.SCALE_SMOOTH);
		Mato3.setIcon(new ImageIcon(Matoss));
		Mato3.setVisible(false);
		contentPane.add(Mato3);
		
		final JLabel Mato2 = new JLabel("");
		Mato2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);
				
				
			}
		});
		Mato2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Mato2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				 b1=false;
				Mato2.setEnabled(false);
				Validacao valid2=new Validacao();
				valid2.validamato(Mato2, Mato4);
				
				Rectangle ac1= Mato2.getBounds();
				Rectangle ac2= Mato4.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					Mato4.setVisible(true);
					Mato2.setVisible(false);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/7.wav");
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
				
				else{
					ponto+=1;
					pontoss-=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Mato2.setBounds(1235, 606, 100, 50);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/3.wav");
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
				if(pontos==270){
					proxima2 frame = new proxima2();
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					frame.txtpont.setText(String.valueOf(pontoss+p));
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/5.wav");
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
				if(ponto==10){
					Game frame = new Game();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					  try {
						   
					         URL url = this.getClass().getClassLoader().getResource("Audio/Erro.wav");
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
			}
		});
		Mato2.setEnabled(false);
		Mato2.setBounds(1235, 606, 50, 50);
		ImageIcon imagem12 =new ImageIcon (Jogo.class.getResource("/Siglasc/MT.png"));
		Image Mato= imagem12.getImage().getScaledInstance(Mato2.getWidth(),Mato2.getHeight() , Image.SCALE_SMOOTH);
		Mato2.setIcon(new ImageIcon(Mato));
		contentPane.add(Mato2);
		
		final JLabel Matosul4 = new JLabel("");
		Matosul4.setBounds(357, 478, 30, 30);
		ImageIcon imagem11113 =new ImageIcon (Jogo.class.getResource("/Siglasc/MS.png"));
		Image matom= imagem11113.getImage().getScaledInstance(Matosul4.getWidth(),Matosul4.getHeight() , Image.SCALE_SMOOTH);
		Matosul4.setIcon(new ImageIcon(matom));
		Matosul4.setVisible(false);
		contentPane.add(Matosul4);
		
		final JLabel Matosul3 = new JLabel("");
		Matosul3.setBounds(357, 485, 42, 7);
		ImageIcon imagem80 =new ImageIcon (Jogo.class.getResource("/Estados/Mato Grosso do Sul.png"));
		Image Matosulss= imagem80.getImage().getScaledInstance(Matosul3.getWidth(),Matosul3.getHeight() , Image.SCALE_SMOOTH);
		Matosul3.setIcon(new ImageIcon(Matosulss));
		Matosul3.setVisible(false);
		contentPane.add(Matosul3);
		
		final JLabel Matosul2 = new JLabel("");
		Matosul2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);
				
				
			}
		});
		Matosul2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Matosul2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				 b1=false;
				Matosul2.setEnabled(false);
				Validacao valid2=new Validacao();
				valid2.validamatosul(Matosul2, Matosul4);
				
				Rectangle ac1= Matosul2.getBounds();
				Rectangle ac2= Matosul4.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					Matosul4.setVisible(true);
					Matosul2.setVisible(false);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/7.wav");
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
				
				else{
					ponto+=1;
					pontoss-=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Matosul2.setBounds(1065, 442, 100, 50);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/3.wav");
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
				if(pontos==270){
					proxima2 frame = new proxima2();
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					frame.txtpont.setText(String.valueOf(pontoss+p));
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/5.wav");
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
				if(ponto==10){
					Game frame = new Game();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					  try {
						   
					         URL url = this.getClass().getClassLoader().getResource("Audio/Erro.wav");
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
			}
		});
		Matosul2.setEnabled(false);
		Matosul2.setBounds(1065, 442, 50, 50);
		ImageIcon imagem11 =new ImageIcon (Jogo.class.getResource("/Siglasc/MS.png"));
		Image Matosul= imagem11.getImage().getScaledInstance(Matosul2.getWidth(),Matosul2.getHeight() , Image.SCALE_SMOOTH);
		Matosul2.setIcon(new ImageIcon(Matosul));
		contentPane.add(Matosul2);
		
		final JLabel Maranhao4 = new JLabel("");
		Maranhao4.setBounds(500, 248, 30, 30);
		ImageIcon imagem112 =new ImageIcon (Jogo.class.getResource("/Siglasc/MA.png"));
		Image maranha= imagem112.getImage().getScaledInstance(Maranhao4.getWidth(),Maranhao4.getHeight() , Image.SCALE_SMOOTH);
		Maranhao4.setIcon(new ImageIcon(maranha));
		Maranhao4.setVisible(false);
		contentPane.add(Maranhao4);
		
		final JLabel Maranhao3 = new JLabel("");
		Maranhao3.setBounds(502, 249, 18, 17);
		ImageIcon imagem79 =new ImageIcon (Jogo.class.getResource("/Estados/Maranhão.png"));
		Image Maranhaoss= imagem79.getImage().getScaledInstance(Maranhao3.getWidth(),Maranhao3.getHeight() , Image.SCALE_SMOOTH);
		Maranhao3.setIcon(new ImageIcon(Maranhaoss));
		Maranhao3.setVisible(false);
		contentPane.add(Maranhao3);

		
		final JLabel Maranhao2 = new JLabel("");
		Maranhao2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);
				
				
			}
		});
		Maranhao2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Maranhao2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				 b1=false;
				Maranhao2.setEnabled(false);
				Validacao valid2=new Validacao();
				valid2.validamaranhao(Maranhao2, Maranhao4);
				
				Rectangle ac1= Maranhao2.getBounds();
				Rectangle ac2= Maranhao4.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					Maranhao4.setVisible(true);
					Maranhao2.setVisible(false);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/7.wav");
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
				
				else{
					ponto+=1;
					pontoss-=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Maranhao2.setBounds(891, 439, 100, 50);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/3.wav");
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
				if(pontos==270){
					proxima2 frame = new proxima2();
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					frame.txtpont.setText(String.valueOf(pontoss+p));
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/5.wav");
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
				if(ponto==10){
					Game frame = new Game();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					  try {
						   
					         URL url = this.getClass().getClassLoader().getResource("Audio/Erro.wav");
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
			}
		});
		Maranhao2.setEnabled(false);
		Maranhao2.setBounds(891, 439,50, 50);
		ImageIcon imagem10 =new ImageIcon (Jogo.class.getResource("/Siglasc/MA.png"));
		Image Maranhao= imagem10.getImage().getScaledInstance(Maranhao2.getWidth(),Maranhao2.getHeight() , Image.SCALE_SMOOTH);
		Maranhao2.setIcon(new ImageIcon(Maranhao));
		contentPane.add(Maranhao2);
		
		final JLabel goias4 = new JLabel("");
		goias4.setBounds(425, 427, 30, 30);
		ImageIcon imagem111 =new ImageIcon (Jogo.class.getResource("/Siglasc/GO.png"));
		Image goiassi= imagem111.getImage().getScaledInstance(goias4.getWidth(),goias4.getHeight() , Image.SCALE_SMOOTH);
		goias4.setIcon(new ImageIcon(goiassi));
		goias4.setVisible(false);
		contentPane.add(goias4);
		
		final JLabel Goias3 = new JLabel("");
		Goias3.setBounds(429, 423, 12, 13);
		ImageIcon imagem78 =new ImageIcon (Jogo.class.getResource("/Estados/Goiaas.png"));
		Image Goiass= imagem78.getImage().getScaledInstance(Goias3.getWidth(),Goias3.getHeight() , Image.SCALE_SMOOTH);
		Goias3.setIcon(new ImageIcon(Goiass));
		Goias3.setVisible(false);
		contentPane.add(Goias3);
		
		final JLabel goias2 = new JLabel("");
		goias2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);
				
				
			}
		});
		goias2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				goias2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				 b1=false;
				goias2.setEnabled(false);
				Validacao valid2=new Validacao();
				valid2.validagoias(goias2, goias4);
				
				Rectangle ac1= goias2.getBounds();
				Rectangle ac2= goias4.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					goias4.setVisible(true);
					goias2.setVisible(false);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/7.wav");
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
				
				else{
					ponto+=1;
					pontoss-=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					goias2.setBounds(1065, 606, 100, 50);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/3.wav");
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
				
				if(pontos==270){
					proxima2 frame = new proxima2();
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					frame.txtpont.setText(String.valueOf(pontoss+p));
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/5.wav");
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
				if(ponto==10){
					Game frame = new Game();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					  try {
						   
					         URL url = this.getClass().getClassLoader().getResource("Audio/Erro.wav");
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
			}
		});
		goias2.setEnabled(false);
		goias2.setBounds(1065, 606, 50, 50);
		ImageIcon imagem9 =new ImageIcon (Jogo.class.getResource("/Siglasc/GO.png"));
		Image goias= imagem9.getImage().getScaledInstance(goias2.getWidth(),goias2.getHeight() , Image.SCALE_SMOOTH);
		goias2.setIcon(new ImageIcon(goias));
		contentPane.add(goias2);
		
		final JLabel Espirito4 = new JLabel("");
		Espirito4.setBounds(572, 466, 30, 30);
		ImageIcon imagem10006 =new ImageIcon (Jogo.class.getResource("/Siglasc/ES.png"));
		Image espirita= imagem10006.getImage().getScaledInstance(Espirito4.getWidth(),Espirito4.getHeight() , Image.SCALE_SMOOTH);
		Espirito4.setIcon(new ImageIcon(espirita));
		Espirito4.setVisible(false);
		contentPane.add(Espirito4);
		
		final JLabel Espirito3 = new JLabel("");
		Espirito3.setBounds(587, 476, 5, 5);
		ImageIcon imagem76 =new ImageIcon (Jogo.class.getResource("/Estados/Espirito Santo.png"));
		Image Espiritos= imagem76.getImage().getScaledInstance(Espirito3.getWidth(),Espirito3.getHeight() , Image.SCALE_SMOOTH);
		Espirito3.setIcon(new ImageIcon(Espiritos));
		Espirito3.setVisible(false);
		contentPane.add(Espirito3);
		
		final JLabel Espirito2 = new JLabel("");
		Espirito2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);
				
				
			}
		});
		Espirito2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Espirito2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				 b1=false;
				Espirito2.setEnabled(false);
				Validacao valid2=new Validacao();
				valid2.validaespirito(Espirito2, Espirito4);
				
				Rectangle ac1= Espirito2.getBounds();
				Rectangle ac2= Espirito4.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					Espirito4.setVisible(true);
					Espirito2.setVisible(false);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/7.wav");
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
				
				else{
					ponto+=1;
					pontoss-=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Espirito2.setBounds(1235, 496, 100, 50);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/3.wav");
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
				
				if(pontos==270){
					proxima2 frame = new proxima2();
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					frame.txtpont.setText(String.valueOf(pontoss+p));
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/5.wav");
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
				if(ponto==10){
					Game frame = new Game();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					  try {
						   
					         URL url = this.getClass().getClassLoader().getResource("Audio/Erro.wav");
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
			}
		});
		Espirito2.setEnabled(false);
		Espirito2.setBounds(1235, 496,50, 50);
		ImageIcon imagem8 =new ImageIcon (Jogo.class.getResource("/Siglasc/ES.png"));
		Image Espirito= imagem8.getImage().getScaledInstance(Espirito2.getWidth(),Espirito2.getHeight() , Image.SCALE_SMOOTH);
		Espirito2.setIcon(new ImageIcon(Espirito));
		contentPane.add(Espirito2);
		
		final JLabel Destrito4 = new JLabel("");
		Destrito4.setBounds(460, 396, 30, 30);
		ImageIcon imagem106 =new ImageIcon (Jogo.class.getResource("/Siglasc/DF.png"));
		Image Disti= imagem106.getImage().getScaledInstance(Destrito4.getWidth(),Destrito4.getHeight() , Image.SCALE_SMOOTH);
		Destrito4.setIcon(new ImageIcon(Disti));
		Destrito4.setVisible(false);
		contentPane.add(Destrito4);
		
		final JLabel Destrito3 = new JLabel("");
		Destrito3.setBounds(479, 416, 1, 1);
		ImageIcon imagem75 =new ImageIcon (Jogo.class.getResource("/Estados/Destrito Federal.png"));
		Image Destritoss= imagem75.getImage().getScaledInstance(Destrito3.getWidth(),Destrito3.getHeight() , Image.SCALE_SMOOTH);
		Destrito3.setIcon(new ImageIcon(Destritoss));
		Destrito3.setVisible(false);
		contentPane.add(Destrito3);
		
		final JLabel Destrito2 = new JLabel("");
		Destrito2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);
				
				
			}
		});
		Destrito2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Destrito2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				 b1=false;
				Destrito2.setEnabled(false);
				Validacao valid2=new Validacao();
				valid2.validadestrito(Destrito2, Destrito4);
				
				Rectangle ac1= Destrito2.getBounds();
				Rectangle ac2= Destrito4.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					Destrito4.setVisible(true);
					Destrito2.setVisible(false);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/7.wav");
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
				
				else{
					ponto+=1;
					pontoss-=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Destrito2.setBounds(891, 239, 100, 50);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/3.wav");
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
				
				if(pontos==270){
					proxima2 frame = new proxima2();
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					frame.txtpont.setText(String.valueOf(pontoss+p));
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/5.wav");
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
				if(ponto==10){
					Game frame = new Game();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					  try {
						   
					         URL url = this.getClass().getClassLoader().getResource("Audio/Erro.wav");
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
			}
		});
		Destrito2.setEnabled(false);
		Destrito2.setBounds(891, 239,50, 50);
		ImageIcon imagem7 =new ImageIcon (Jogo.class.getResource("/Siglasc/DF.png"));
		Image Destrito= imagem7.getImage().getScaledInstance(Destrito2.getWidth(),Destrito2.getHeight() , Image.SCALE_SMOOTH);
		Destrito2.setIcon(new ImageIcon(Destrito));
		contentPane.add(Destrito2);
		
		final JLabel Ceara4 = new JLabel("");
		Ceara4.setBounds(589, 241, 30, 30);
		ImageIcon imagem105 =new ImageIcon (Jogo.class.getResource("/Siglasc/CE.png"));
		Image cearara= imagem105.getImage().getScaledInstance(Ceara4.getWidth(),Ceara4.getHeight() , Image.SCALE_SMOOTH);
		Ceara4.setIcon(new ImageIcon(cearara));
		Ceara4.setVisible(false);
		contentPane.add(Ceara4);
		
		final JLabel Ceara3 = new JLabel("");
		Ceara3.setBounds(599, 250, 9, 11);
		ImageIcon imagem73 =new ImageIcon (Jogo.class.getResource("/Estados/Ceara.png"));
		Image Cearas= imagem73.getImage().getScaledInstance(Ceara3.getWidth(),Ceara3.getHeight(),Image.SCALE_SMOOTH);
		Ceara3.setIcon(new ImageIcon(Cearas));
		Ceara3.setVisible(false);
		contentPane.add(Ceara3);
		
		final JLabel Ceara2 = new JLabel("");
		Ceara2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);
				
				
			}
		});
		Ceara2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Ceara2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				 b1=false;
				Ceara2.setEnabled(false);
				Validacao valid2=new Validacao();
				valid2.validaceara(Ceara2, Ceara4);
				
				Rectangle ac1= Ceara2.getBounds();
				Rectangle ac2= Ceara4.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					Ceara4.setVisible(true);
					Ceara2.setVisible(false);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/7.wav");
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
				
				else{
					ponto+=1;
					pontoss-=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Ceara2.setBounds(1065, 553, 100, 50);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/3.wav");
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
				if(pontos==270){
					proxima2 frame = new proxima2();
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					frame.txtpont.setText(String.valueOf(pontoss+p));
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/5.wav");
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
				if(ponto==10){
					Game frame = new Game();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					  try {
						   
					         URL url = this.getClass().getClassLoader().getResource("Audio/Erro.wav");
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
			}
		});
		Ceara2.setEnabled(false);
		Ceara2.setBounds(1065, 553, 50, 50);
		ImageIcon imagem6 =new ImageIcon (Jogo.class.getResource("/Siglasc/CE.png"));
		Image Ceara= imagem6.getImage().getScaledInstance(Ceara2.getWidth(),Ceara2.getHeight() , Image.SCALE_SMOOTH);
		Ceara2.setIcon(new ImageIcon(Ceara));
		contentPane.add(Ceara2);
		
		final JLabel Bahia4 = new JLabel("");
		Bahia4.setBounds(560, 356, 30, 30);
		ImageIcon imagem104 =new ImageIcon (Jogo.class.getResource("/Siglasc/BA.png"));
		Image mana= imagem104.getImage().getScaledInstance(Bahia4.getWidth(),Bahia4.getHeight() , Image.SCALE_SMOOTH);
		Bahia4.setIcon(new ImageIcon(mana));
		Bahia4.setVisible(false);
		contentPane.add(Bahia4);
		
		final JLabel Bahia3 = new JLabel("");
		Bahia3.setBounds(549, 354, 28, 14);
		ImageIcon imagem72 =new ImageIcon (Jogo.class.getResource("/Estados/Bahia.png"));
		Image Bahiass= imagem72.getImage().getScaledInstance(Bahia3.getWidth(),Bahia3.getHeight(),Image.SCALE_SMOOTH);
		Bahia3.setIcon(new ImageIcon(Bahiass));
		Bahia3.setVisible(false);
		contentPane.add(Bahia3);
		
		final JLabel Bahia2 = new JLabel("");
		Bahia2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);
				
				
			}
		});
		Bahia2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Bahia2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				 b1=false;
				Bahia2.setEnabled(false);
				Validacao valid2=new Validacao();
				valid2.validabahia(Bahia2, Bahia4);
				
				Rectangle ac1= Bahia2.getBounds();
				Rectangle ac2= Bahia4.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					Bahia4.setVisible(true);
					Bahia2.setVisible(false);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/7.wav");
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
				
				else{
					ponto+=1;
					pontoss-=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Bahia2.setBounds(891, 554, 100, 50);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/3.wav");
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
				
				if(pontos==270){
					proxima2 frame = new proxima2();
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					frame.txtpont.setText(String.valueOf(pontoss+p));
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/5.wav");
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
				if(ponto==10){
					Game frame = new Game();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					  try {
						   
					         URL url = this.getClass().getClassLoader().getResource("Audio/Erro.wav");
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
			}
		});
		Bahia2.setEnabled(false);
		Bahia2.setBounds(891, 554,50, 50);
		ImageIcon imagem5 =new ImageIcon (Jogo.class.getResource("/Siglasc/BA.png"));
		Image Bahia= imagem5.getImage().getScaledInstance(Bahia2.getWidth(),Bahia2.getHeight() , Image.SCALE_SMOOTH);
		Bahia2.setIcon(new ImageIcon(Bahia));
		contentPane.add(Bahia2);
		
		final JLabel Amazonas4 = new JLabel("");
		Amazonas4.setBounds(205, 232, 30, 30);
		ImageIcon imagem1001 =new ImageIcon (Jogo.class.getResource("/Siglasc/AM.png"));
		Image manas= imagem1001.getImage().getScaledInstance(Amazonas4.getWidth(),Amazonas4.getHeight() , Image.SCALE_SMOOTH);
		Amazonas4.setIcon(new ImageIcon(manas));
		Amazonas4.setVisible(false);
		contentPane.add(Amazonas4);
		
		final JLabel Amazonas3 = new JLabel("");
		Amazonas3.setBounds(185, 229, 71, 28);
		ImageIcon imagem71 =new ImageIcon (Jogo.class.getResource("/Estados/Amazonas.png"));
		Image Amazonass= imagem71.getImage().getScaledInstance(Amazonas3.getWidth(),Amazonas3.getHeight(),Image.SCALE_SMOOTH);
		Amazonas3.setIcon(new ImageIcon(Amazonass));
		Amazonas3.setVisible(false);
		contentPane.add(Amazonas3);
		
		final JLabel Amazonas2 = new JLabel("");
		Amazonas2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);
				
				
			}
		});
		Amazonas2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Amazonas2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				 b1=false;
				Amazonas2.setEnabled(false);
				Validacao valid2=new Validacao();
				valid2.validaamazonas(Amazonas2, Amazonas4);
				
				Rectangle ac1= Amazonas2.getBounds();
				Rectangle ac2= Amazonas4.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss));
					Amazonas4.setVisible(true);
					Amazonas2.setVisible(false);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/7.wav");
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
				
				else{
					ponto+=1;
					pontoss-=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Amazonas2.setBounds(1065, 491, 100, 50);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/3.wav");
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
				if(pontos==270){
					proxima2 frame = new proxima2();
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					frame.txtpont.setText(String.valueOf(pontoss+p));
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/5.wav");
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
				if(ponto==10){
					Game frame = new Game();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					  try {
						   
					         URL url = this.getClass().getClassLoader().getResource("Audio/Erro.wav");
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
			}
		});
		Amazonas2.setEnabled(false);
		Amazonas2.setBounds(1065, 491, 50, 50);
		ImageIcon imagem4 =new ImageIcon (Jogo.class.getResource("/Siglasc/AM.png"));
		Image Amazonas= imagem4.getImage().getScaledInstance(Amazonas2.getWidth(),Amazonas2.getHeight() , Image.SCALE_SMOOTH);
		Amazonas2.setIcon(new ImageIcon(Amazonas));
		contentPane.add(Amazonas2);
		
		final JLabel Amapa4 = new JLabel("");
		Amapa4.setBounds(404, 141, 30, 30);
		ImageIcon imagem103 =new ImageIcon (Jogo.class.getResource("/Siglasc/AP.png"));
		Image amaspa= imagem103.getImage().getScaledInstance(Amapa4.getWidth(),Amapa4.getHeight() , Image.SCALE_SMOOTH);
		Amapa4.setIcon(new ImageIcon(amaspa));
		Amapa4.setVisible(false);
		contentPane.add(Amapa4);
		
		final JLabel Amapa3 = new JLabel("");
		Amapa3.setBounds(411, 144, 21, 15);
		ImageIcon imagem41 =new ImageIcon (Jogo.class.getResource("/Estados/Amapa.png"));
		Image Amapas= imagem41.getImage().getScaledInstance(Amapa3.getWidth(),Amapa3.getHeight() , Image.SCALE_SMOOTH);
		Amapa3.setIcon(new ImageIcon(Amapas));
		Amapa3.setVisible(false);
		contentPane.add(Amapa3);
		
		final JLabel Amapa2 = new JLabel("");
		Amapa2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);
				
				
			}
		});
		Amapa2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Amapa2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				 b1=false;
				Amapa2.setEnabled(false);
				Validacao valid2=new Validacao();
				valid2.validaamapa(Amapa2, Amapa4);
				
				Rectangle ac1= Amapa2.getBounds();
				Rectangle ac2= Amapa4.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					Amapa4.setVisible(true);
					Amapa2.setVisible(false);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/7.wav");
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
				
				else{
					ponto+=1;
					pontoss-=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Amapa2.setBounds(891, 491, 100, 50);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/3.wav");
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
				if(pontos==270){
					proxima2 frame = new proxima2();
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					frame.txtpont.setText(String.valueOf(pontoss+p));
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/5.wav");
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
				if(ponto==10){
					Game frame = new Game();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					  try {
						   
					         URL url = this.getClass().getClassLoader().getResource("Audio/Erro.wav");
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
			}
		});
		Amapa2.setEnabled(false);
		Amapa2.setBounds(891, 491,50, 50);
		ImageIcon imagem3 =new ImageIcon (Jogo.class.getResource("/Siglasc/AP.png"));
		Image Amapa= imagem3.getImage().getScaledInstance(Amapa2.getWidth(),Amapa2.getHeight() , Image.SCALE_SMOOTH);
		Amapa2.setIcon(new ImageIcon(Amapa));
		contentPane.add(Amapa2);
		
		final JLabel Alagoas4 = new JLabel("");
		Alagoas4.setBounds(638, 312, 30, 30);
		ImageIcon imagem102 =new ImageIcon (Jogo.class.getResource("/Siglasc/AL.png"));
		Image alagoass= imagem102.getImage().getScaledInstance(Alagoas4.getWidth(),Alagoas4.getHeight() , Image.SCALE_SMOOTH);
		Alagoas4.setIcon(new ImageIcon(alagoass));
		Alagoas4.setVisible(false);
		contentPane.add(Alagoas4);
		
		final JLabel Alagoas3 = new JLabel("");
		Alagoas3.setBounds(653, 322, 2, 2);
		ImageIcon imagem70 =new ImageIcon (Jogo.class.getResource("/Estados/Alagoas.png"));
		Image Alagoass= imagem70.getImage().getScaledInstance(Alagoas3.getWidth(),Alagoas3.getHeight(),Image.SCALE_SMOOTH);
		Alagoas3.setIcon(new ImageIcon(Alagoass));
		Alagoas3.setVisible(false);
		contentPane.add(Alagoas3);
		
		final JLabel Alagoas2= new JLabel("");
		Alagoas2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);
				
				
			}
		});
		Alagoas2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Alagoas2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				 b1=false;
				Alagoas2.setEnabled(false);
				Validacao valid2=new Validacao();
				valid2.validaalagoas(Alagoas2, Alagoas4);
				
				Rectangle ac1= Alagoas2.getBounds();
				Rectangle ac2= Alagoas4.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					Alagoas4.setVisible(true);
					Alagoas2.setVisible(false);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/7.wav");
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
				
				else{
					ponto+=1;
					pontoss-=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Alagoas2.setBounds(1235, 549, 100, 50);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/3.wav");
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
				if(pontos==270){
					proxima2 frame = new proxima2();
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					frame.txtpont.setText(String.valueOf(pontoss+p));
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/5.wav");
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
				if(ponto==10){
					Game frame = new Game();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					  try {
						   
					         URL url = this.getClass().getClassLoader().getResource("Audio/Erro.wav");
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
			}
		});
		Alagoas2.setEnabled(false);
		Alagoas2.setBounds(1235, 549,50, 50);
		ImageIcon imagem2 =new ImageIcon (Jogo.class.getResource("/Siglasc/AL.png"));
		Image Alagoas= imagem2.getImage().getScaledInstance(Alagoas2.getWidth(),Alagoas2.getHeight() , Image.SCALE_SMOOTH);
		Alagoas2.setIcon(new ImageIcon(Alagoas));
		contentPane.add(Alagoas2);
		
		final JLabel Acre4 = new JLabel("");
		Acre4.setBounds(123, 308, 30, 30);
		ImageIcon imagem101 =new ImageIcon (Jogo.class.getResource("/Siglasc/AC.png"));
		Image acresi= imagem101.getImage().getScaledInstance(Acre4.getWidth(),Acre4.getHeight() , Image.SCALE_SMOOTH);
		Acre4.setIcon(new ImageIcon(acresi));
		Acre4.setVisible(false);
		contentPane.add(Acre4);
		
		final JLabel Acre3 = new JLabel("");
		Acre3.setBounds(119, 313, 32, 1);
		ImageIcon imagem97 =new ImageIcon (Jogo.class.getResource("/Estados/Acre.png"));
		Image acres= imagem97.getImage().getScaledInstance(Acre3.getWidth(),Acre3.getHeight() , Image.SCALE_SMOOTH);
		Acre3.setIcon(new ImageIcon(acres));
		Acre3.setVisible(false);
		contentPane.add(Acre3);
		
		final JLabel Acre2 = new JLabel("");
		Acre2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);
				
				
			}
		});
	Acre2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Acre2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				 b1=false;
				Acre2.setEnabled(false);
			
				
				Rectangle ac1= Acre2.getBounds();
				Rectangle ac2= Acre4.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					Acre4.setVisible(true);
					Acre2.setVisible(false);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/7.wav");
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
				
				else{
					ponto+=1;
					pontoss-=10;
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					lblponto.setText("Sua Pontuação é: "+String.valueOf(pontoss+p));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Acre2.setBounds(891, 606, 100, 50);
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/3.wav");
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
				
				if(pontos==270){
					proxima2 frame = new proxima2();
					String el= txt2.getText();
					Integer p= Integer.parseInt(el);
					frame.txtpont.setText(String.valueOf(pontoss+p));
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					try {
						   
				         URL url = this.getClass().getClassLoader().getResource("Audio/5.wav");
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
				if(ponto==10){
					Game frame = new Game();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
					  try {
						   
					         URL url = this.getClass().getClassLoader().getResource("Audio/Erro.wav");
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
			}
		
		});
		Acre2.setEnabled(false);
		Acre2.setBounds(891, 606,50, 50);
		ImageIcon imagem1 =new ImageIcon (Jogo.class.getResource("/Siglasc/AC.png"));
		Image Acre= imagem1.getImage().getScaledInstance(Acre2.getWidth(),Acre2.getHeight() , Image.SCALE_SMOOTH);
		Acre2.setIcon(new ImageIcon(Acre));
		contentPane.add(Acre2);
	
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
		btnajuda.setBounds(1120, 23, 205, 65);
		ImageIcon imagens3 =new ImageIcon (Jogo.class.getResource("/Img/btnmenu.png"));
		Image botao3= imagens3.getImage().getScaledInstance(btnajuda.getWidth(),btnajuda.getHeight() , Image.SCALE_SMOOTH);
		btnajuda.setIcon(new ImageIcon(botao3));
		contentPane.add(btnajuda);

		JLabel lblmapa3 = new JLabel("");
		lblmapa3.setBounds(26, 23, 262, 47);
		ImageIcon imagen =new ImageIcon (Jogo.class.getResource("/Img/logo2.png"));
		Image mapa3= imagen.getImage().getScaledInstance(lblmapa3.getWidth(),lblmapa3.getHeight() , Image.SCALE_SMOOTH);
		lblmapa3.setIcon(new ImageIcon(mapa3));
		contentPane.add(lblmapa3);
		
		JLabel lblMapa2 = new JLabel("");
		lblMapa2.setBounds(81, 97, 600, 600);
		ImageIcon image =new ImageIcon (Jogo.class.getResource("/Img/fase2.png"));
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
}
