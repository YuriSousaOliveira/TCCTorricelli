import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.net.URL;
import java.awt.Font;


public class Fase1 extends JFrame {
	
	boolean b1= false;
	int c1=0;
	int c2=0;
	int pontos= 0;
	int ponto= 0;
	int pontoss= 0;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fase1 frame = new Fase1();
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
	public Fase1() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ranking.class.getResource("/Img/icone.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(689, 422, 88, 82));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblerro = new JLabel("");
		lblerro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblerro.setBounds(322, 40, 409, 30);
		lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
		contentPane.add(lblerro);
		
		final JLabel lblponto = new JLabel("");
		lblponto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblponto.setBounds(772, 40, 301, 30);
		lblponto.setText("Sua Pontua��o:ser� atualizada ");
		contentPane.add(lblponto);
		
		final JLabel Amapa4 = new JLabel("");
		Amapa4.setBounds(368, 108, 88, 88);
		ImageIcon imagem993 =new ImageIcon (Jogo.class.getResource("/Estados/Amapa.png"));
		Image img22= imagem993.getImage().getScaledInstance(Amapa4.getWidth(),Amapa4.getHeight() , Image.SCALE_SMOOTH);
		Amapa4.setIcon(new ImageIcon(img22));
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
		 		Amapa2.setEnabled(true);
		 		
		 		Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);  	
		 	}
		 	}
		 );
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
				valid2.validaamapa(Amapa2, Amapa3);
				
				Rectangle ac1= Amapa2.getBounds();
				Rectangle ac2= Amapa3.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
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
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Amapa2.setBounds(689, 422, 88, 88);
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
					proxima frame = new proxima();
					frame.txtpont.setText(String.valueOf(pontoss));
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
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 Cursor c1=new Cursor(Cursor.HAND_CURSOR);                                    
	              setCursor(c1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 Cursor c2=new Cursor(Cursor.DEFAULT_CURSOR);                                    
	              setCursor(c2);
			}
		});
		Amapa2.setEnabled(false);
		Amapa2.setBounds(689, 422, 88, 88);
		ImageIcon imagem3 =new ImageIcon (Jogo.class.getResource("/Estados/Amapa.png"));
		Image Amapa= imagem3.getImage().getScaledInstance(Amapa2.getWidth(),Amapa2.getHeight() , Image.SCALE_SMOOTH);
		Amapa2.setIcon(new ImageIcon(Amapa));
		contentPane.add(Amapa2);
		
		final JLabel Paulo4 = new JLabel("");
		Paulo4.setBounds(406, 468, 125, 100);
		ImageIcon imagem9933 =new ImageIcon (Jogo.class.getResource("/Estados/S�o Paulo.png"));
		Image img25= imagem9933.getImage().getScaledInstance(Paulo4.getWidth(),Paulo4.getHeight() , Image.SCALE_SMOOTH);
		Paulo4.setIcon(new ImageIcon(img25));
		Paulo4.setVisible(false);
		contentPane.add(Paulo4);
		
		final JLabel Paulo3 = new JLabel("");
		Paulo3.setBounds(459, 502, 15, 16);
		ImageIcon imagem40 =new ImageIcon (Jogo.class.getResource("/Estados/S�o Paulo.png"));
		Image Paulos= imagem40.getImage().getScaledInstance(Paulo3.getWidth(),Paulo3.getHeight(),Image.SCALE_SMOOTH);
		Paulo3.setIcon(new ImageIcon(Paulos));
		Paulo3.setVisible(false);
		contentPane.add(Paulo3);
		
		final JLabel Paulo2 = new JLabel("");
		Paulo2.addMouseMotionListener(new MouseMotionAdapter() {
		 	@Override
		 	public void mouseDragged(MouseEvent arg0) {
		 		Paulo2.setEnabled(true);
		 		
		 		Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);  
		 		
		 	}


		 	}
		 );
		Paulo2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Paulo2.setEnabled(true);
			}
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				b1=false;
				Paulo2.setEnabled(false);
			Validacao valid=new Validacao();
			valid.validapaulo(Paulo2, Paulo3);
			
			Rectangle ac1 = Paulo2.getBounds();
			Rectangle ac2= Paulo3.getBounds();
			
			if(ac1.intersects(ac2)){
				pontos+=10;
				pontoss+=10;
				lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
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
				lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
				lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
				Paulo2.setBounds(689, 229, 125, 100);
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
				proxima frame = new proxima();
				frame.txtpont.setText(String.valueOf(pontoss));
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
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 Cursor c1=new Cursor(Cursor.HAND_CURSOR);                                    
	              setCursor(c1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 Cursor c2=new Cursor(Cursor.DEFAULT_CURSOR);                                    
	              setCursor(c2);
			}
		});
		Paulo2.setEnabled(false);
		Paulo2.setBounds(689, 229, 125, 100);
		ImageIcon imagem25 =new ImageIcon (Jogo.class.getResource("/Estados/S�o Paulo.png"));
		Image Paulo= imagem25.getImage().getScaledInstance(Paulo2.getWidth(),Paulo2.getHeight() , Image.SCALE_SMOOTH);
		Paulo2.setIcon(new ImageIcon(Paulo));
		contentPane.add(Paulo2);
		
		final JLabel Alagoas4 = new JLabel("");
		Alagoas4.setBounds(627, 312, 43, 25);
		ImageIcon imagem994 =new ImageIcon (Jogo.class.getResource("/Estados/Alagoas.png"));
		Image img23= imagem994.getImage().getScaledInstance(Alagoas4.getWidth(),Alagoas4.getHeight() , Image.SCALE_SMOOTH);
		Alagoas4.setIcon(new ImageIcon(img23));
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
		 		Alagoas2.setEnabled(true);
		 		
		 		Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);  
		 		
		 	}


		 	}
		 );
		Alagoas2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Alagoas2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				b1=false;
				Alagoas2.setEnabled(false);
				Validacao valid3=new Validacao();
				valid3.validaalagoas(Alagoas2, Alagoas3);
				
				Rectangle ac1 = Alagoas2.getBounds();
				Rectangle ac2= Alagoas3.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
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
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Alagoas2.setBounds(690, 196, 43, 25);
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
					proxima frame = new proxima();
					frame.txtpont.setText(String.valueOf(pontoss));
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
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 Cursor c1=new Cursor(Cursor.HAND_CURSOR);                                    
	              setCursor(c1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 Cursor c2=new Cursor(Cursor.DEFAULT_CURSOR);                                    
	              setCursor(c2);
			}
		});
		Alagoas2.setEnabled(false);
		Alagoas2.setBounds(707, 160, 43, 25);
		ImageIcon imagem2 =new ImageIcon (Jogo.class.getResource("/Estados/Alagoas.png"));
		Image Alagoas= imagem2.getImage().getScaledInstance(Alagoas2.getWidth(),Alagoas2.getHeight() , Image.SCALE_SMOOTH);
		Alagoas2.setIcon(new ImageIcon(Alagoas));
		contentPane.add(Alagoas2);
		
		final JLabel Amazonas4 = new JLabel("");
		Amazonas4.setBounds(88, 143, 256, 185);
		ImageIcon imagem992 =new ImageIcon (Jogo.class.getResource("/Estados/Amazonas.png"));
		Image img21= imagem992.getImage().getScaledInstance(Amazonas4.getWidth(),Amazonas4.getHeight() , Image.SCALE_SMOOTH);
		Amazonas4.setIcon(new ImageIcon(img21));
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
		 		Amazonas2.setEnabled(true);
		 		
		 		
		 		Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);  
		 		
		 	}


		 	}
		 );
		Amazonas2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Amazonas2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				b1=false;
				Amazonas2.setEnabled(false);
				Validacao valid4=new Validacao();
				valid4.validaamazonas(Amazonas2, Amazonas3);
				
				Rectangle ac1 = Amazonas2.getBounds();
				Rectangle ac2= Amazonas3.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
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
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Amazonas2.setBounds(564, 515, 256, 185);
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
					proxima frame = new proxima();
					frame.txtpont.setText(String.valueOf(pontoss));
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
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 Cursor c1=new Cursor(Cursor.HAND_CURSOR);                                    
	              setCursor(c1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 Cursor c2=new Cursor(Cursor.DEFAULT_CURSOR);                                    
	              setCursor(c2);
			}
		});
		Amazonas2.setEnabled(false);
		Amazonas2.setBounds(565, 514, 256, 185);
		ImageIcon imagem4 =new ImageIcon (Jogo.class.getResource("/Estados/Amazonas.png"));
		Image Amazonas= imagem4.getImage().getScaledInstance(Amazonas2.getWidth(),Amazonas2.getHeight() , Image.SCALE_SMOOTH);
		Amazonas2.setIcon(new ImageIcon(Amazonas));
		contentPane.add(Amazonas2);
		
		final JLabel Bahia4 = new JLabel("");
		Bahia4.setBounds(497, 304, 135, 158);
		ImageIcon imagem991 =new ImageIcon (Jogo.class.getResource("/Estados/Bahia.png"));
		Image img20= imagem991.getImage().getScaledInstance(Bahia4.getWidth(),Bahia4.getHeight() , Image.SCALE_SMOOTH);
		Bahia4.setIcon(new ImageIcon(img20));
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
		 		Bahia2.setEnabled(true);
		 		
		 		Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);  
		 		
		 	}


		 	}
		 );
		Bahia2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Bahia2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				b1=false;
				Bahia2.setEnabled(false);
				Validacao valid5=new Validacao();
				valid5.validabahia(Bahia2, Bahia3);
				
				Rectangle ac1 = Bahia2.getBounds();
				Rectangle ac2= Bahia3.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
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
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Bahia2.setBounds(782, 99, 135, 158);
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
					proxima frame = new proxima();
					frame.txtpont.setText(String.valueOf(pontoss));
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
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 Cursor c1=new Cursor(Cursor.HAND_CURSOR);                                    
	              setCursor(c1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 Cursor c2=new Cursor(Cursor.DEFAULT_CURSOR);                                    
	              setCursor(c2);
			}
		});
		Bahia2.setEnabled(false);
		Bahia2.setBounds(782, 99, 135, 158);
		ImageIcon imagem5 =new ImageIcon (Jogo.class.getResource("/Estados/Bahia.png"));
		Image Bahia= imagem5.getImage().getScaledInstance(Bahia2.getWidth(),Bahia2.getHeight() , Image.SCALE_SMOOTH);
		Bahia2.setIcon(new ImageIcon(Bahia));
		contentPane.add(Bahia2);
		
		final JLabel Ceara4 = new JLabel("");
		Ceara4.setBounds(571, 220, 68, 75);
		ImageIcon imagem990 =new ImageIcon (Jogo.class.getResource("/Estados/Ceara.png"));
		Image img19= imagem990.getImage().getScaledInstance(Ceara4.getWidth(),Ceara4.getHeight() , Image.SCALE_SMOOTH);
		Ceara4.setIcon(new ImageIcon(img19));
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
		 		Ceara2.setEnabled(true);
		 		
		 		Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);  
		 		
		 	}


		 	}
		 );
		Ceara2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Ceara2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				b1=false;
				Ceara2.setEnabled(false);
				Validacao valid6=new Validacao();
				valid6.validaceara(Ceara2, Ceara3);
				
				Rectangle ac1 = Ceara2.getBounds();
				Rectangle ac2= Ceara3.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
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
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Ceara2.setBounds(833, 257, 68, 75);
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
					proxima frame = new proxima();
					frame.txtpont.setText(String.valueOf(pontoss));
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
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 Cursor c1=new Cursor(Cursor.HAND_CURSOR);                                    
	              setCursor(c1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 Cursor c2=new Cursor(Cursor.DEFAULT_CURSOR);                                    
	              setCursor(c2);
			}
		});
		Ceara2.setEnabled(false);
		Ceara2.setBounds(833, 257, 68, 75);
		ImageIcon imagem6 =new ImageIcon (Jogo.class.getResource("/Estados/Ceara.png"));
		Image Ceara= imagem6.getImage().getScaledInstance(Ceara2.getWidth(),Ceara2.getHeight() , Image.SCALE_SMOOTH);
		Ceara2.setIcon(new ImageIcon(Ceara));
		contentPane.add(Ceara2);
		
		final JLabel Destrito4 = new JLabel("");
		Destrito4.setBounds(466, 408, 29, 17);
		ImageIcon imagem0990 =new ImageIcon (Jogo.class.getResource("/Estados/Destrito Federal.png"));
		Image img019= imagem0990.getImage().getScaledInstance(Destrito4.getWidth(),Destrito4.getHeight() , Image.SCALE_SMOOTH);
		Destrito4.setIcon(new ImageIcon(img019));
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
		 		Destrito2.setEnabled(true);
		 		
		 		Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);  
		 		
		 	}


		 	}
		 );
		Destrito2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Destrito2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				b1=false;
				Destrito2.setEnabled(false);
				Validacao valid7=new Validacao();
				valid7.validadestrito(Destrito2, Destrito3);
				
				Rectangle ac1 = Destrito2.getBounds();
				Rectangle ac2= Destrito3.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
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
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Destrito2.setBounds(848, 347, 29, 17);
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
					proxima frame = new proxima();
					frame.txtpont.setText(String.valueOf(pontoss));
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
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 Cursor c1=new Cursor(Cursor.HAND_CURSOR);                                    
	              setCursor(c1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 Cursor c2=new Cursor(Cursor.DEFAULT_CURSOR);                                    
	              setCursor(c2);
			}
		});
		Destrito2.setEnabled(false);
		Destrito2.setBounds(848, 347, 29, 17);
		ImageIcon imagem7 =new ImageIcon (Jogo.class.getResource("/Estados/Destrito Federal.png"));
		Image Destrito= imagem7.getImage().getScaledInstance(Destrito2.getWidth(),Destrito2.getHeight() , Image.SCALE_SMOOTH);
		Destrito2.setIcon(new ImageIcon(Destrito));
		contentPane.add(Destrito2);
		
		final JLabel Espirito4 = new JLabel("");
		Espirito4.setBounds(564, 456, 40, 45);
		ImageIcon imagem989 =new ImageIcon (Jogo.class.getResource("/Estados/Espirito Santo.png"));
		Image img18= imagem989.getImage().getScaledInstance(Espirito4.getWidth(),Espirito4.getHeight() , Image.SCALE_SMOOTH);
		Espirito4.setIcon(new ImageIcon(img18));
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
		 		Espirito2.setEnabled(true);
		 		
		 		Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);  
		 		
		 	}


		 	}
		 );
		Espirito2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Espirito2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				b1=false;
				Espirito2.setEnabled(false);
				Validacao valid8=new Validacao();
				valid8.validaespirito(Espirito2, Espirito3);
				
				Rectangle ac1 = Espirito2.getBounds();
				Rectangle ac2= Espirito3.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
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
					pontoss=10;
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Espirito2.setBounds(833, 390, 40, 45);
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
					proxima frame = new proxima();
					frame.txtpont.setText(String.valueOf(pontoss));
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
		Espirito2.setBounds(833, 390, 40, 45);
		ImageIcon imagem8 =new ImageIcon (Jogo.class.getResource("/Estados/Espirito Santo.png"));
		Image Espirito= imagem8.getImage().getScaledInstance(Espirito2.getWidth(),Espirito2.getHeight() , Image.SCALE_SMOOTH);
		Espirito2.setIcon(new ImageIcon(Espirito));
		contentPane.add(Espirito2);
		
		final JLabel Goias4 = new JLabel("");
		Goias4.setBounds(400, 365, 108, 106);
		ImageIcon imagem988 =new ImageIcon (Jogo.class.getResource("/Estados/Goiaas.png"));
		Image img17= imagem988.getImage().getScaledInstance(Goias4.getWidth(),Goias4.getHeight() , Image.SCALE_SMOOTH);
		Goias4.setIcon(new ImageIcon(img17));
		Goias4.setVisible(false);
		contentPane.add(Goias4);
		
		final JLabel Goias3 = new JLabel("");
		Goias3.setBounds(429, 423, 12, 13);
		ImageIcon imagem78 =new ImageIcon (Jogo.class.getResource("/Estados/Goiaas.png"));
		Image Goiass= imagem78.getImage().getScaledInstance(Goias3.getWidth(),Goias3.getHeight() , Image.SCALE_SMOOTH);
		Goias3.setIcon(new ImageIcon(Goiass));
		Goias3.setVisible(false);
		contentPane.add(Goias3);
		
		final JLabel Goias2 = new JLabel("");
		Goias2.addMouseMotionListener(new MouseMotionAdapter() {
		 	@Override
		 	public void mouseDragged(MouseEvent arg0) {
		 		Goias2.setEnabled(true);
		 		
		 		Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);  
		 		
		 	}


		 	}
		 );
		Goias2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Goias2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				b1=false;
				Goias2.setEnabled(false);
				Validacao valid9=new Validacao();
				valid9.validagoias(Goias2, Goias3);
				
				Rectangle ac1 = Goias2.getBounds();
				Rectangle ac2= Goias3.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
					Goias4.setVisible(true);
					Goias2.setVisible(false);
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
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Goias2.setBounds(813, 468, 108, 106);
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
					proxima frame = new proxima();
					frame.txtpont.setText(String.valueOf(pontoss));
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
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 Cursor c1=new Cursor(Cursor.HAND_CURSOR);                                    
	              setCursor(c1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 Cursor c2=new Cursor(Cursor.DEFAULT_CURSOR);                                    
	              setCursor(c2);
			}
		});
		Goias2.setEnabled(false);
		Goias2.setBounds(813, 468, 108, 106);
		ImageIcon imagem9 =new ImageIcon (Jogo.class.getResource("/Estados/Goiaas.png"));
		Image goias= imagem9.getImage().getScaledInstance(Goias2.getWidth(),Goias2.getHeight() , Image.SCALE_SMOOTH);
		Goias2.setIcon(new ImageIcon(goias));
		contentPane.add(Goias2);
		
		final JLabel Maranhao4 = new JLabel("");
		Maranhao4.setBounds(467, 192, 101, 148);
		ImageIcon imagem987 =new ImageIcon (Jogo.class.getResource("/Estados/Maranh�o.png"));
		Image img16= imagem987.getImage().getScaledInstance(Maranhao4.getWidth(),Maranhao4.getHeight() , Image.SCALE_SMOOTH);
		Maranhao4.setIcon(new ImageIcon(img16));
		Maranhao4.setVisible(false);
		contentPane.add(Maranhao4);
		
		final JLabel Maranhao3 = new JLabel("");
		Maranhao3.setBounds(502, 249, 18, 17);
		ImageIcon imagem79 =new ImageIcon (Jogo.class.getResource("/Estados/Maranh�o.png"));
		Image Maranhaoss= imagem79.getImage().getScaledInstance(Maranhao3.getWidth(),Maranhao3.getHeight() , Image.SCALE_SMOOTH);
		Maranhao3.setIcon(new ImageIcon(Maranhaoss));
		Maranhao3.setVisible(false);
		contentPane.add(Maranhao3);
		
		final JLabel Maranhao2 = new JLabel("");
		Maranhao2.addMouseMotionListener(new MouseMotionAdapter() {
		 	@Override
		 	public void mouseDragged(MouseEvent arg0) {
		 		Maranhao2.setEnabled(true);
		 		
		 		Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);  
		 		
		 	}


		 	}
		 );
		Maranhao2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Maranhao2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				b1=false;
				Maranhao2.setEnabled(false);
				Validacao valid10=new Validacao();
				valid10.validamaranhao(Maranhao2, Maranhao3);
				
				Rectangle ac1 = Maranhao2.getBounds();
				Rectangle ac2= Maranhao3.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
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
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Maranhao2.setBounds(813, 585, 101, 148);
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
					proxima frame = new proxima();
					frame.txtpont.setText(String.valueOf(pontoss));
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
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 Cursor c1=new Cursor(Cursor.HAND_CURSOR);                                    
	              setCursor(c1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 Cursor c2=new Cursor(Cursor.DEFAULT_CURSOR);                                    
	              setCursor(c2);
			}
		});
		Maranhao2.setEnabled(false);
		Maranhao2.setBounds(813, 576, 101, 148);
		ImageIcon imagem10 =new ImageIcon (Jogo.class.getResource("/Estados/Maranh�o.png"));
		Image Maranhao= imagem10.getImage().getScaledInstance(Maranhao2.getWidth(),Maranhao2.getHeight() , Image.SCALE_SMOOTH);
		Maranhao2.setIcon(new ImageIcon(Maranhao));
		contentPane.add(Maranhao2);
		
		final JLabel Matosul4 = new JLabel("");
		Matosul4.setBounds(322, 433, 110, 117);
		ImageIcon imagem986 =new ImageIcon (Jogo.class.getResource("/Estados/Mato Grosso do Sul.png"));
		Image img15= imagem986.getImage().getScaledInstance(Matosul4.getWidth(),Matosul4.getHeight() , Image.SCALE_SMOOTH);
		Matosul4.setIcon(new ImageIcon(img15));
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
		 		Matosul2.setEnabled(true);
		 		
		 		Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);  
		 		
		 	}


		 	}
		 );
		Matosul2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Matosul2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				b1=false;
				Matosul2.setEnabled(false);
				Validacao valid11=new Validacao();
				valid11.validamatosul(Matosul2, Matosul3);
				
				Rectangle ac1 = Matosul2.getBounds();
				Rectangle ac2= Matosul3.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
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
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Matosul2.setBounds(915, 589, 110, 117);
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
					proxima frame = new proxima();
					frame.txtpont.setText(String.valueOf(pontoss));
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
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 Cursor c1=new Cursor(Cursor.HAND_CURSOR);                                    
	              setCursor(c1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 Cursor c2=new Cursor(Cursor.DEFAULT_CURSOR);                                    
	              setCursor(c2);
			}
		});
		Matosul2.setEnabled(false);
		Matosul2.setBounds(915, 589, 110, 117);
		ImageIcon imagem11 =new ImageIcon (Jogo.class.getResource("/Estados/Mato Grosso do Sul.png"));
		Image Matosul= imagem11.getImage().getScaledInstance(Matosul2.getWidth(),Matosul2.getHeight() , Image.SCALE_SMOOTH);
		Matosul2.setIcon(new ImageIcon(Matosul));
		contentPane.add(Matosul2);
		
		final JLabel Mato4 = new JLabel("");
		Mato4.setBounds(272, 284, 175, 175);
		ImageIcon imagem984 =new ImageIcon (Jogo.class.getResource("/Estados/Mato Grosso.png"));
		Image img14= imagem984.getImage().getScaledInstance(Mato4.getWidth(),Mato4.getHeight() , Image.SCALE_SMOOTH);
		Mato4.setIcon(new ImageIcon(img14));
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
		 		Mato2.setEnabled(true);
		 		
		 		Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);  
		 		
		 	}


		 	}
		 );
		Mato2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Mato2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				b1=false;
				Mato2.setEnabled(false);
				Validacao valid12=new Validacao();
				valid12.validamato(Mato2, Mato3);
				
				Rectangle ac1 = Mato2.getBounds();
				Rectangle ac2= Mato3.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
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
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Mato2.setBounds(932, 109, 175, 175);
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
					proxima frame = new proxima();
					frame.txtpont.setText(String.valueOf(pontoss));
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
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 Cursor c1=new Cursor(Cursor.HAND_CURSOR);                                    
	              setCursor(c1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 Cursor c2=new Cursor(Cursor.DEFAULT_CURSOR);                                    
	              setCursor(c2);
			}
		});
		Mato2.setEnabled(false);
		Mato2.setBounds(932, 109, 175, 175);
		ImageIcon imagem12 =new ImageIcon (Jogo.class.getResource("/Estados/Mato Grosso.png"));
		Image Mato= imagem12.getImage().getScaledInstance(Mato2.getWidth(),Mato2.getHeight() , Image.SCALE_SMOOTH);
		Mato2.setIcon(new ImageIcon(Mato));
		contentPane.add(Mato2);
		
		final JLabel Minas4 = new JLabel("");
		Minas4.setBounds(429, 390, 175, 140);
		ImageIcon imagem983 =new ImageIcon (Jogo.class.getResource("/Estados/Minas Gerais.png"));
		Image img13= imagem983.getImage().getScaledInstance(Minas4.getWidth(),Minas4.getHeight() , Image.SCALE_SMOOTH);
		Minas4.setIcon(new ImageIcon(img13));
		Minas4.setVisible(false);
		contentPane.add(Minas4);
		
		final JLabel Minas3 = new JLabel("");
		Minas3.setBounds(511, 456, 39, 17);
		ImageIcon imagem82 =new ImageIcon (Jogo.class.getResource("/Estados/Minas Gerais.png"));
		Image Minass= imagem82.getImage().getScaledInstance(Minas3.getWidth(),Minas3.getHeight() , Image.SCALE_SMOOTH);
		Minas3.setIcon(new ImageIcon(Minass));
		Minas3.setVisible(false);
		contentPane.add(Minas3);
		
		final JLabel Minas2 = new JLabel("");
		Minas2.addMouseMotionListener(new MouseMotionAdapter() {
		 	@Override
		 	public void mouseDragged(MouseEvent arg0) {
		 		Minas2.setEnabled(true);
		 		
		 		Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);  
		 		
		 	}


		 	}
		 );
		Minas2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Minas2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				b1=false;
				Minas2.setEnabled(false);
				Validacao valid13=new Validacao();
				valid13.validaminas(Minas2, Minas3);
				
				Rectangle ac1 = Minas2.getBounds();
				Rectangle ac2= Minas3.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
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
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Minas2.setBounds(932, 468, 175, 140);
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
					proxima frame = new proxima();
					frame.txtpont.setText(String.valueOf(pontoss));
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
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 Cursor c1=new Cursor(Cursor.HAND_CURSOR);                                    
	              setCursor(c1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 Cursor c2=new Cursor(Cursor.DEFAULT_CURSOR);                                    
	              setCursor(c2);
			}
		});

		Minas2.setEnabled(false);
		Minas2.setBounds(932, 468, 175, 140);
		ImageIcon imagem13 =new ImageIcon (Jogo.class.getResource("/Estados/Minas Gerais.png"));
		Image Minas= imagem13.getImage().getScaledInstance(Minas2.getWidth(),Minas2.getHeight() , Image.SCALE_SMOOTH);
		Minas2.setIcon(new ImageIcon(Minas));
		contentPane.add(Minas2);
		
		final JLabel Para4 = new JLabel("");
		Para4.setBounds(313, 134, 193, 195);
		ImageIcon imagem982 =new ImageIcon (Jogo.class.getResource("/Estados/Para.png"));
		Image img12= imagem982.getImage().getScaledInstance(Para4.getWidth(),Para4.getHeight() , Image.SCALE_SMOOTH);
		Para4.setIcon(new ImageIcon(img12));
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
		 		Para2.setEnabled(true);
		 		
		 		Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);  
		 		
		 	}


		 	}
		 );
		Para2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Para2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				b1=false;
				Para2.setEnabled(false);
				Validacao valid14=new Validacao();
				valid14.validapara(Para2, Para3);
				
				Rectangle ac1 = Para2.getBounds();
				Rectangle ac2= Para3.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
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
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Para2.setBounds(942, 284, 193, 195);
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
					proxima frame = new proxima();
					frame.txtpont.setText(String.valueOf(pontoss));
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
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 Cursor c1=new Cursor(Cursor.HAND_CURSOR);                                    
	              setCursor(c1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 Cursor c2=new Cursor(Cursor.DEFAULT_CURSOR);                                    
	              setCursor(c2);
			}
		});
		Para2.setEnabled(false);
		Para2.setBounds(925, 274, 193, 195);
		ImageIcon imagem14 =new ImageIcon (Jogo.class.getResource("/Estados/Para.png"));
		Image Para= imagem14.getImage().getScaledInstance(Para2.getWidth(),Para2.getHeight() , Image.SCALE_SMOOTH);
		Para2.setIcon(new ImageIcon(Para));
		contentPane.add(Para2);
		
		final JLabel Paraiba4 = new JLabel("");
		Paraiba4.setBounds(616, 270, 59, 26);
		ImageIcon imagem981 =new ImageIcon (Jogo.class.getResource("/Estados/Paraiba.png"));
		Image img11= imagem981.getImage().getScaledInstance(Paraiba4.getWidth(),Paraiba4.getHeight() , Image.SCALE_SMOOTH);
		Paraiba4.setIcon(new ImageIcon(img11));
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
		 		Paraiba2.setEnabled(true);
		 		
		 		Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);  
		 		
		 	}


		 	}
		 );
		Paraiba2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Paraiba2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				b1=false;
				Paraiba2.setEnabled(false);
				Validacao valid15=new Validacao();
				valid15.validaparaiba(Paraiba2, Paraiba3);
				
				Rectangle ac1 = Paraiba2.getBounds();
				Rectangle ac2= Paraiba3.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
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
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Paraiba2.setBounds(1237, 99, 59, 26);
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
					proxima frame = new proxima();
					frame.txtpont.setText(String.valueOf(pontoss));
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
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 Cursor c1=new Cursor(Cursor.HAND_CURSOR);                                    
	              setCursor(c1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 Cursor c2=new Cursor(Cursor.DEFAULT_CURSOR);                                    
	              setCursor(c2);
			}
		});
		Paraiba2.setEnabled(false);
		Paraiba2.setBounds(1237, 99, 59, 26);
		ImageIcon imagem15 =new ImageIcon (Jogo.class.getResource("/Estados/Paraiba.png"));
		Image Paraiba= imagem15.getImage().getScaledInstance(Paraiba2.getWidth(),Paraiba2.getHeight() , Image.SCALE_SMOOTH);
		Paraiba2.setIcon(new ImageIcon(Paraiba));
		contentPane.add(Paraiba2);
		
		final JLabel Parana4 = new JLabel("");
		Parana4.setBounds(377, 519, 95, 65);
		ImageIcon imagem980 =new ImageIcon (Jogo.class.getResource("/Estados/Parana.png"));
		Image img10= imagem980.getImage().getScaledInstance(Parana4.getWidth(),Parana4.getHeight() , Image.SCALE_SMOOTH);
		Parana4.setIcon(new ImageIcon(img10));
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
		 		Parana2.setEnabled(true);
		 		
		 		Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);  
		 		
		 	}


		 	}
		 );
		Parana2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Parana2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				b1=false;
				Parana2.setEnabled(false);
				Validacao valid16=new Validacao();
				valid16.validaparana(Parana2, Parana3);
				
				Rectangle ac1 = Parana2.getBounds();
				Rectangle ac2= Parana3.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
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
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Parana2.setBounds(1120, 138, 95, 65);
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
					proxima frame = new proxima();
					frame.txtpont.setText(String.valueOf(pontoss));
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
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 Cursor c1=new Cursor(Cursor.HAND_CURSOR);                                    
	              setCursor(c1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 Cursor c2=new Cursor(Cursor.DEFAULT_CURSOR);                                    
	              setCursor(c2);
			}
		});
		Parana2.setEnabled(false);
		Parana2.setBounds(1120, 138, 95, 65);
		ImageIcon imagem16 =new ImageIcon (Jogo.class.getResource("/Estados/Parana.png"));
		Image Parana= imagem16.getImage().getScaledInstance(Parana2.getWidth(),Parana2.getHeight() , Image.SCALE_SMOOTH);
		Parana2.setIcon(new ImageIcon(Parana));
		contentPane.add(Parana2);
		
		final JLabel Pernambuco4 = new JLabel("");
		Pernambuco4.setBounds(576, 284, 101, 37);
		ImageIcon imagem979 =new ImageIcon (Jogo.class.getResource("/Estados/Pernambuco.png"));
		Image img9= imagem979.getImage().getScaledInstance(Pernambuco4.getWidth(),Pernambuco4.getHeight() , Image.SCALE_SMOOTH);
		Pernambuco4.setIcon(new ImageIcon(img9));
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
		 		Pernambuco2.setEnabled(true);
		 		
		 		Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);  
		 		
		 	}


		 	}
		 );
		Pernambuco2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Pernambuco2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				b1=false;
				Pernambuco2.setEnabled(false);
				Validacao valid17=new Validacao();
				valid17.validapernambuco(Pernambuco2, Pernambuco3);
				
				Rectangle ac1 = Pernambuco2.getBounds();
				Rectangle ac2= Pernambuco3.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
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
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Pernambuco2.setBounds(1120, 229, 101, 37);
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
					proxima frame = new proxima();
					frame.txtpont.setText(String.valueOf(pontoss));
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
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 Cursor c1=new Cursor(Cursor.HAND_CURSOR);                                    
	              setCursor(c1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 Cursor c2=new Cursor(Cursor.DEFAULT_CURSOR);                                    
	              setCursor(c2);
			}
		});
		Pernambuco2.setEnabled(false);
		Pernambuco2.setBounds(1120, 229, 101, 37);
		ImageIcon imagem17 =new ImageIcon (Jogo.class.getResource("/Estados/Pernambuco.png"));
		Image Pernambuco= imagem17.getImage().getScaledInstance(Pernambuco2.getWidth(),Pernambuco2.getHeight() , Image.SCALE_SMOOTH);
		Pernambuco2.setIcon(new ImageIcon(Pernambuco));
		contentPane.add(Pernambuco2);
		
		final JLabel Rio4 = new JLabel("");
		Rio4.setBounds(527, 497, 55, 34);
		ImageIcon imagem978 =new ImageIcon (Jogo.class.getResource("/Estados/Rio de Janeiro.png"));
		Image img8= imagem978.getImage().getScaledInstance(Rio4.getWidth(),Rio4.getHeight() , Image.SCALE_SMOOTH);
		Rio4.setIcon(new ImageIcon(img8));
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
		 		Rio2.setEnabled(true);
		 		
		 		Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);  
		 		
		 	}


		 	}
		 );
		Rio2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Rio2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				b1=false;
				Rio2.setEnabled(false);
				Validacao valid18=new Validacao();
				valid18.validario(Rio2, Rio3);
				
				Rectangle ac1 = Rio2.getBounds();
				Rectangle ac2= Rio3.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
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
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Rio2.setBounds(1139, 284, 55, 34);
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
					proxima frame = new proxima();
					frame.txtpont.setText(String.valueOf(pontoss));
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
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 Cursor c1=new Cursor(Cursor.HAND_CURSOR);                                    
	              setCursor(c1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 Cursor c2=new Cursor(Cursor.DEFAULT_CURSOR);                                    
	              setCursor(c2);
			}
		});
		Rio2.setEnabled(false);
		Rio2.setBounds(1139, 284, 55, 34);
		ImageIcon imagem19 =new ImageIcon (Jogo.class.getResource("/Estados/Rio de Janeiro.png"));
		Image Rio= imagem19.getImage().getScaledInstance(Rio2.getWidth(),Rio2.getHeight() , Image.SCALE_SMOOTH);
		Rio2.setIcon(new ImageIcon(Rio));
		contentPane.add(Rio2);
		
		final JLabel RGNorte4 = new JLabel("");
		RGNorte4.setBounds(620, 252, 52, 30);
		ImageIcon imagem977 =new ImageIcon (Jogo.class.getResource("/Estados/Rio Grande do Norte.png"));
		Image img7= imagem977.getImage().getScaledInstance(RGNorte4.getWidth(),RGNorte4.getHeight() , Image.SCALE_SMOOTH);
		RGNorte4.setIcon(new ImageIcon(img7));
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
		 		RGNorte2.setEnabled(true);
		 		
		 		Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);  
		 		
		 	}


		 	}
		 );
		RGNorte2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				RGNorte2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				b1=false;
				RGNorte2.setEnabled(false);
				Validacao valid19=new Validacao();
				valid19.validargnorte(RGNorte2, RGNorte3);
				
				Rectangle ac1 = RGNorte2.getBounds();
				Rectangle ac2= RGNorte3.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
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
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					RGNorte2.setBounds(1061, 636, 52, 30);
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
				if(pontos==270){
					proxima frame = new proxima();
					frame.txtpont.setText(String.valueOf(pontoss));
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
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 Cursor c1=new Cursor(Cursor.HAND_CURSOR);                                    
	              setCursor(c1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 Cursor c2=new Cursor(Cursor.DEFAULT_CURSOR);                                    
	              setCursor(c2);
			}
		});
		RGNorte2.setEnabled(false);
		RGNorte2.setBounds(1061, 636, 52, 30);
		ImageIcon imagem20 =new ImageIcon (Jogo.class.getResource("/Estados/Rio Grande do Norte.png"));
		Image RGNorte= imagem20.getImage().getScaledInstance(RGNorte2.getWidth(),RGNorte2.getHeight() , Image.SCALE_SMOOTH);
		RGNorte2.setIcon(new ImageIcon(RGNorte));
		contentPane.add(RGNorte2);
		
		final JLabel Piaui4 = new JLabel("");
		Piaui4.setBounds(503, 217, 88, 128);
		ImageIcon imagem976 =new ImageIcon (Jogo.class.getResource("/Estados/Piaui.png"));
		Image img6= imagem976.getImage().getScaledInstance(Piaui4.getWidth(),Piaui4.getHeight() , Image.SCALE_SMOOTH);
		Piaui4.setIcon(new ImageIcon(img6));
		Piaui4.setVisible(false);
		contentPane.add(Piaui4);
		
		final JLabel Piaui3 = new JLabel("");
		Piaui3.setBounds(560, 277, 9, 17);
		ImageIcon imagem89 =new ImageIcon (Jogo.class.getResource("/Estados/Piaui.png"));
		Image piauis= imagem89.getImage().getScaledInstance(Piaui3.getWidth(),Piaui3.getHeight() , Image.SCALE_SMOOTH);
		Piaui3.setIcon(new ImageIcon(piauis));
		Piaui3.setVisible(false);
		contentPane.add(Piaui3);
		
		final JLabel Piaui2 = new JLabel("");
		Piaui2.addMouseMotionListener(new MouseMotionAdapter() {
		 	@Override
		 	public void mouseDragged(MouseEvent arg0) {
		 		Piaui2.setEnabled(true);
		 		
		 		Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);  
		 		
		 	}


		 	}
		 );
		Piaui2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Piaui2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				b1=false;
				Piaui2.setEnabled(false);
				Validacao valid20=new Validacao();
				valid20.validapiaui(Piaui2, Piaui3);
				
				Rectangle ac1 = Piaui2.getBounds();
				Rectangle ac2= Piaui3.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
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
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Piaui2.setBounds(1237, 173, 88, 128);
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
					proxima frame = new proxima();
					frame.txtpont.setText(String.valueOf(pontoss));
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
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 Cursor c1=new Cursor(Cursor.HAND_CURSOR);                                    
	              setCursor(c1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 Cursor c2=new Cursor(Cursor.DEFAULT_CURSOR);                                    
	              setCursor(c2);
			}
		});
		Piaui2.setEnabled(false);
		Piaui2.setBounds(1237, 173, 88, 128);
		ImageIcon imagem18 =new ImageIcon (Jogo.class.getResource("/Estados/Piaui.png"));
		Image Piaui= imagem18.getImage().getScaledInstance(Piaui2.getWidth(),Piaui2.getHeight() , Image.SCALE_SMOOTH);
		Piaui2.setIcon(new ImageIcon(Piaui));
		contentPane.add(Piaui2);
		
		final JLabel RGSul4 = new JLabel("");
		RGSul4.setBounds(334, 588, 117, 104);
		ImageIcon imagem975 =new ImageIcon (Jogo.class.getResource("/Estados/Rio Grande do Sul.png"));
		Image img5= imagem975.getImage().getScaledInstance(RGSul4.getWidth(),RGSul4.getHeight() , Image.SCALE_SMOOTH);
		RGSul4.setIcon(new ImageIcon(img5));
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
		 		RGSul2.setEnabled(true);
		 		
		 		Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);  
		 		
		 	}


		 	}
		 );
		RGSul2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				RGSul2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				b1=false;
				RGSul2.setEnabled(false);
				Validacao valid21=new Validacao();
				valid21.validargsul(RGSul2, RGSul3);
				
				Rectangle ac1 = RGSul2.getBounds();
				Rectangle ac2= RGSul3.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
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
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					RGSul2.setBounds(1237, 284, 117, 98);
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
					proxima frame = new proxima();
					frame.txtpont.setText(String.valueOf(pontoss));
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
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 Cursor c1=new Cursor(Cursor.HAND_CURSOR);                                    
	              setCursor(c1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 Cursor c2=new Cursor(Cursor.DEFAULT_CURSOR);                                    
	              setCursor(c2);
			}
		});
		RGSul2.setEnabled(false);
		RGSul2.setBounds(1237, 284, 117, 104);
		ImageIcon imagem21 =new ImageIcon (Jogo.class.getResource("/Estados/Rio Grande do Sul.png"));
		Image RGSul= imagem21.getImage().getScaledInstance(RGSul2.getWidth(),RGSul2.getHeight() , Image.SCALE_SMOOTH);
		RGSul2.setIcon(new ImageIcon(RGSul));
		contentPane.add(RGSul2);
		
		final JLabel Rondonia4 = new JLabel("");
		Rondonia4.setBounds(195, 295, 105, 92);
		ImageIcon imagem974 =new ImageIcon (Jogo.class.getResource("/Estados/Rondonia.png"));
		Image img4= imagem974.getImage().getScaledInstance(Rondonia4.getWidth(),Rondonia4.getHeight() , Image.SCALE_SMOOTH);
		Rondonia4.setIcon(new ImageIcon(img4));
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
		 		Rondonia2.setEnabled(true);
		 		
		 		Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);  
		 		
		 	}


		 	}
		 );
		Rondonia2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Rondonia2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				b1=false;
				Rondonia2.setEnabled(false);
				Validacao valid22=new Validacao();
				valid22.validarondonia(Rondonia2, Rondonia3);
				
				Rectangle ac1 = Rondonia2.getBounds();
				Rectangle ac2= Rondonia3.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
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
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Rondonia2.setBounds(1120, 390, 89, 82);
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
					if(pontos==270){
						proxima frame = new proxima();
						frame.txtpont.setText(String.valueOf(pontoss));
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
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 Cursor c1=new Cursor(Cursor.HAND_CURSOR);                                    
	              setCursor(c1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 Cursor c2=new Cursor(Cursor.DEFAULT_CURSOR);                                    
	              setCursor(c2);
			}
		});
		Rondonia2.setEnabled(false);
		Rondonia2.setBounds(1120, 390, 105, 92);
		ImageIcon imagem22 =new ImageIcon (Jogo.class.getResource("/Estados/Rondonia.png"));
		Image Rondonia= imagem22.getImage().getScaledInstance(Rondonia2.getWidth(),Rondonia2.getHeight() , Image.SCALE_SMOOTH);
		Rondonia2.setIcon(new ImageIcon(Rondonia));
		contentPane.add(Rondonia2);
		
		final JLabel Roraima4 = new JLabel("");
		Roraima4.setBounds(228, 95, 88, 101);
		ImageIcon imagem9200 =new ImageIcon (Jogo.class.getResource("/Estados/Roraima.png"));
		Image roraimass= imagem9200.getImage().getScaledInstance(Roraima4.getWidth(),Roraima4.getHeight() , Image.SCALE_SMOOTH);
		Roraima4.setIcon(new ImageIcon(roraimass));
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
		 		Roraima2.setEnabled(true);
		 		
		 		Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);  
		 		
		 	}


		 	}
		 );
		Roraima2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Roraima2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				b1=false;
				Roraima2.setEnabled(false);
				Validacao valid23=new Validacao();
				valid23.validaroraima(Roraima2, Roraima3);
				
				Rectangle ac1 = Roraima2.getBounds();
				Rectangle ac2= Roraima3.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
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
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Roraima2.setBounds(1237, 390, 88, 101);
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
					proxima frame = new proxima();
					frame.txtpont.setText(String.valueOf(pontoss));
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
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 Cursor c1=new Cursor(Cursor.HAND_CURSOR);                                    
	              setCursor(c1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 Cursor c2=new Cursor(Cursor.DEFAULT_CURSOR);                                    
	              setCursor(c2);
			}
		});
		Roraima2.setEnabled(false);
		Roraima2.setBounds(1237, 390, 88, 101);
		ImageIcon imagem23 =new ImageIcon (Jogo.class.getResource("/Estados/Roraima.png"));
		Image Roraima= imagem23.getImage().getScaledInstance(Roraima2.getWidth(),Roraima2.getHeight() , Image.SCALE_SMOOTH);
		Roraima2.setIcon(new ImageIcon(Roraima));
		contentPane.add(Roraima2);
		
		final JLabel Santa4 = new JLabel("");
		Santa4.setBounds(389, 572, 79, 53);
		ImageIcon imagem973 =new ImageIcon (Jogo.class.getResource("/Estados/Santa Catarina.png"));
		Image img3= imagem973.getImage().getScaledInstance(Santa4.getWidth(),Santa4.getHeight() , Image.SCALE_SMOOTH);
		Santa4.setIcon(new ImageIcon(img3));
		Santa4.setVisible(false);
		contentPane.add(Santa4);
		
		final JLabel Santa3 = new JLabel("");
		Santa3.setBounds(446, 593, 12, 7);
		ImageIcon imagem94 =new ImageIcon (Jogo.class.getResource("/Estados/Santa Catarina.png"));
		Image santas= imagem94.getImage().getScaledInstance(Santa3.getWidth(),Santa3.getHeight() , Image.SCALE_SMOOTH);
		Santa3.setIcon(new ImageIcon(santas));
		Santa3.setVisible(false);
		contentPane.add(Santa3);
		
		final JLabel Santa2 = new JLabel("");
		Santa2.addMouseMotionListener(new MouseMotionAdapter() {
		 	@Override
		 	public void mouseDragged(MouseEvent arg0) {
		 		Santa2.setEnabled(true);
		 		
		 		Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);  
		 		
		 	}


		 	}
		 );
		Santa2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Santa2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				b1=false;
				Santa2.setEnabled(false);
				Validacao valid24=new Validacao();
				valid24.validasanta(Santa2, Santa3);
				
				 Rectangle ac1 = Santa2.getBounds();
					Rectangle ac2= Santa3.getBounds();
					
					if(ac1.intersects(ac2)){
						pontos+=10;
						pontoss+=10;
						lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
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
						lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
						lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
						Santa2.setBounds(1095, 536, 79, 53);
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
						proxima frame = new proxima();
						frame.txtpont.setText(String.valueOf(pontoss));
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
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 Cursor c1=new Cursor(Cursor.HAND_CURSOR);                                    
	              setCursor(c1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 Cursor c2=new Cursor(Cursor.DEFAULT_CURSOR);                                    
	              setCursor(c2);
			}
		});
		Santa2.setEnabled(false);
		Santa2.setBounds(1095, 536, 79, 53);
		ImageIcon imagem24 =new ImageIcon (Jogo.class.getResource("/Estados/Santa Catarina.png"));
		Image Santa= imagem24.getImage().getScaledInstance(Santa2.getWidth(),Santa2.getHeight() , Image.SCALE_SMOOTH);
		Santa2.setIcon(new ImageIcon(Santa));
		contentPane.add(Santa2);
		
		final JLabel Sergipe4 = new JLabel("");
		Sergipe4.setBounds(623, 323, 34, 31);
		ImageIcon imagem972 =new ImageIcon (Jogo.class.getResource("/Estados/Sergipe.png"));
		Image img2= imagem972.getImage().getScaledInstance(Sergipe4.getWidth(),Sergipe4.getHeight() , Image.SCALE_SMOOTH);
		Sergipe4.setIcon(new ImageIcon(img2));
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
		 		Sergipe2.setEnabled(true);
		 		
		 		Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);  
		 		
		 	}


		 	}
		 );
		Sergipe2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Sergipe2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				b1=false;

				Sergipe2.setEnabled(false);
				
				Validacao valid25=new Validacao();
				valid25.validasergipe(Sergipe2, Sergipe3);
				
				 Rectangle ac1 = Sergipe2.getBounds();
					Rectangle ac2= Sergipe3.getBounds();
					
					if(ac1.intersects(ac2)){
						pontos+=10;
						pontoss+=10;
						lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
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
						lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
						lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
						Sergipe2.setBounds(1163, 648, 34, 31);
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
						proxima frame = new proxima();
						frame.txtpont.setText(String.valueOf(pontoss));
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
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 Cursor c1=new Cursor(Cursor.HAND_CURSOR);                                    
	              setCursor(c1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 Cursor c2=new Cursor(Cursor.DEFAULT_CURSOR);                                    
	              setCursor(c2);
			}
		});
		Sergipe2.setEnabled(false);
		Sergipe2.setBounds(1163, 648, 34, 31);
		ImageIcon imagem26 =new ImageIcon (Jogo.class.getResource("/Estados/Sergipe.png"));
		Image Sergipe= imagem26.getImage().getScaledInstance(Sergipe2.getWidth(),Sergipe2.getHeight() , Image.SCALE_SMOOTH);
		Sergipe2.setIcon(new ImageIcon(Sergipe));
		contentPane.add(Sergipe2);
		
		final JLabel Tocantins4 = new JLabel("");
		Tocantins4.setBounds(432, 251, 80, 128);
		ImageIcon imagem971 =new ImageIcon (Jogo.class.getResource("/Estados/Tocantins.png"));
		Image img1= imagem971.getImage().getScaledInstance(Tocantins4.getWidth(),Tocantins4.getHeight() , Image.SCALE_SMOOTH);
		Tocantins4.setIcon(new ImageIcon(img1));
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
		 		Tocantins2.setEnabled(true);
		 		
		 		Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z1=new Point(arg0.getPoint());
	             Point q1=new Point(C.getLocation());  
	             
	             C.setBounds(q1.x+(z1.x-c1),q1.y+(z1.y-c2),C.getSize().  
	                                     width,C.getSize().height);  
		 		
		 	}


		 	}
		 );
		Tocantins2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Tocantins2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				b1=false;
				Tocantins2.setEnabled(false);
				Validacao valid26=new Validacao();
				valid26.validatocantins(Tocantins2, Tocantins3);
				
				Rectangle ac1 = Tocantins2.getBounds();
				Rectangle ac2= Tocantins3.getBounds();
				
				if(ac1.intersects(ac2)){
					pontos+=10;
					pontoss+=10;
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
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
					lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
					lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
					Tocantins2.setBounds(1237, 497, 80, 122);
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
					proxima frame = new proxima();
					frame.txtpont.setText(String.valueOf(pontoss));
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
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 Cursor c1=new Cursor(Cursor.HAND_CURSOR);                                    
	              setCursor(c1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 Cursor c2=new Cursor(Cursor.DEFAULT_CURSOR);                                    
	              setCursor(c2);
			}
		});
		Tocantins2.setEnabled(false);
		Tocantins2.setBounds(1237, 497, 80, 128);
		ImageIcon imagem27 =new ImageIcon (Jogo.class.getResource("/Estados/Tocantins.png"));
		Image Tocantins= imagem27.getImage().getScaledInstance(Tocantins2.getWidth(),Tocantins2.getHeight() , Image.SCALE_SMOOTH);
		Tocantins2.setIcon(new ImageIcon(Tocantins));
		contentPane.add(Tocantins2);
		
		final JLabel Acre4 = new JLabel("");
		Acre4.setBounds(86, 284, 107, 65);
		ImageIcon imagem970 =new ImageIcon (Jogo.class.getResource("/Estados/Acre.png"));
		Image acress= imagem970.getImage().getScaledInstance(Acre4.getWidth(),Acre4.getHeight() , Image.SCALE_SMOOTH);
		Acre4.setIcon(new ImageIcon(acress));
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
		 		Acre2.setEnabled(true);
		 		
		 		Component C=arg0.getComponent();
		 		
		 		if(b1==false){b1=true;Point p=new  
                        Point(arg0.getPoint());c1=p.x;c2=p.y;}
		 		 Point z=new Point(arg0.getPoint());
	             Point q=new Point(C.getLocation());  
	             
	             C.setBounds(q.x+(z.x-c1),q.y+(z.y-c2),C.getSize().  
	                                     width,C.getSize().height);  
		 		
		 	}


		 	}
		 );
		Acre2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				Acre2.setEnabled(true);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				b1=false;
				Acre2.setEnabled(false);
				
				 Rectangle ac1 = Acre2.getBounds();
					Rectangle ac2= Acre3.getBounds();
					
					if(ac1.intersects(ac2)){
						pontos+=10;
						pontoss+=10;
						lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
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
							lblponto.setText("Sua Pontua��o �: "+String.valueOf(pontoss));
							lblerro.setText("Numeros de Erros: "+String.valueOf(ponto)+" Limite de Erros 10");
							Acre2.setBounds(1237, 636, 110, 65);
						
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
					proxima frame = new proxima();
					frame.txtpont.setText(String.valueOf(pontoss));
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
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 Cursor c1=new Cursor(Cursor.HAND_CURSOR);                                    
	              setCursor(c1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 Cursor c2=new Cursor(Cursor.DEFAULT_CURSOR);                                    
	              setCursor(c2);
			}
			
			
		});
		Acre2.setEnabled(false);
		Acre2.setBounds(1237, 636, 107, 65);
		ImageIcon imagem1 =new ImageIcon (Jogo.class.getResource("/Estados/Acre.png"));
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
		lblMapa2.setBounds(80, 95, 600, 600);
		ImageIcon image =new ImageIcon (Jogo.class.getResource("/Img/fase1.png"));
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
