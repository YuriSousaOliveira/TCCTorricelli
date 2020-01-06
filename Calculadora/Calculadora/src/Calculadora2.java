import javax.swing.*;
import java.awt.event.*;

public class Calculadora2 extends JFrame {

	private JButton n1;
	private JButton n2;
	private JButton n3;
	private JButton n4;
	private JButton n5;
	private JButton n6;
	private JButton n7;
	private JButton n8;
	private JButton n9;
	private JButton n0;
	private JButton botaoMais;
	private JButton botaoMenos;
	private JButton botaoVezes;
	private JButton botaoDividi;
	private JButton botaoIgual;
	private JButton botaoC;
	private JButton botaoCE;
	private JButton botaoPonto;
	private char operacao;
	private int inteiro;
	private int decimal;
	private double memoria;
	private boolean ponto;
	private JTextField campo;

	public Calculadora2(){
	    this.setTitle("Calculadora do Ozzy");
	    this.setBounds(0,0,280,380);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    this.getContentPane().setLayout(null);

	    inteiro = 0;
	    decimal = 0;
	    memoria = 0;

	    n1 = new JButton ();
	    n1.setText("1");
	    n1.setBounds(25,115,45,45);
	    this.add(n1);

	    n2 = new JButton ();
	    n2.setText("2");
	    n2.setBounds(85,115,45,45);
	    this.add(n2);

	    n3 = new JButton();
	    n3.setText("3");
	    n3.setBounds(140,115,45,45);
	    this.add(n3);

	    n4 = new JButton();
	    n4.setText ("4");
	    n4.setBounds (25,170,45,45);
	    this.add(n4);

	    n5 = new JButton ();
	    n5.setText("5");
	    n5.setBounds(85,170,45,45);
	    this.add (n5);

	    n6 = new JButton();
	    n6.setText("6");
	    n6.setBounds(140,170,45,45);
	    this.add(n6);

	    n7 = new JButton ();
	    n7.setText("7");
	    n7.setBounds(25,225,45,45);
	    this.add(n7);

	    n8 = new JButton();
	    n8.setText("8");
	    n8.setBounds (85,225,45,45);
	    this.add (n8);

	    n9 = new JButton ();
	    n9.setText("9");
	    n9.setBounds (140,225,45,45);
	    this.add (n9);

	    n0 = new JButton();
	    n0.setText ("0");
	    n0.setBounds (140,280,45,45);
	    this.add (n0);

	    botaoMais = new JButton();
	    botaoMais.setText("+");
	    botaoMais.setBounds(195,115,45,45);
	    this.add(botaoMais);

	    botaoMenos = new JButton ();
	    botaoMenos.setText ("-");
	    botaoMenos.setBounds(195,170,45,45);
	    this.add (botaoMenos);

	    botaoVezes = new JButton();
	    botaoVezes.setText ("x");
	    botaoVezes.setBounds(195,225,45,45);
	    this.add(botaoVezes);

	    botaoDividi = new JButton();
	    botaoDividi.setText("÷");
	    botaoDividi.setBounds(195,280,45,45);
	    this.add(botaoDividi);

	    botaoIgual = new JButton();
	    botaoIgual.setText("=");
	    botaoIgual.setBounds(25,280,45,45);
	    this.add(botaoIgual);

	    botaoPonto = new JButton ();
	    botaoPonto.setText(".");
	    botaoPonto.setBounds(85,280,45,45);
	    this.add (botaoPonto);

	    botaoC = new JButton ();
	    botaoC.setText("C");
	    botaoC.setBounds(25,65,105,40);
	    this.add(botaoC);

	    botaoCE = new JButton ();
	    botaoCE.setText("CE");
	    botaoCE.setBounds(140,65,100,40);
	    this.add(botaoCE);

	    campo = new JTextField();
	    campo.setBounds(25,25,216,30);
	    this.add(campo);

	    n1.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent evt){
	            if(ponto){
	                decimal +=1;
	            }
	            inteiro *= 10;
	            inteiro +=1;
	            campo.setText(campo.getText()+ "1");

	        }
	    });
	    n2.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent evt){
	            if (ponto){
	                decimal +=2;
	            }
	            inteiro *=10;
	            inteiro+= 2;
	            campo.setText (campo.getText()+"2");
	        }
	    });
	    n3.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent event){
	            if (ponto){
	                decimal+=3;
	            }
	            inteiro *= 10;
	            inteiro += 3;
	            campo.setText(campo.getText()+"3");

	        }
	    });
	    n4.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent evt){
	            if (ponto){
	                decimal+=4;
	            }
	            inteiro *= 10;
	            inteiro +=4;
	            campo.setText (campo.getText ()+"4");

	        }
	    });
	    n5.addActionListener(new ActionListener(){
	        public void actionPerformed (ActionEvent evt){
	            if (ponto){
	                decimal +=5;
	            }
	            inteiro*= 10;
	            inteiro +=5;
	            campo.setText (campo.getText ()+ "5");
	        }
	    });
	    n6.addActionListener (new ActionListener (){
	        public void actionPerformed (ActionEvent evt){
	            if (ponto){
	                decimal +=6;
	            }
	            inteiro*= 10;
	            inteiro +=6;
	            campo.setText (campo.getText ()+ "6");
	        }
	    });
	    n7.addActionListener(new ActionListener(){
	        public void actionPerformed (ActionEvent evt){
	            if(ponto){
	                decimal +=7;
	            }
	            inteiro*= 10;
	            inteiro +=7;
	            campo.setText (campo.getText()+"7");
	        }
	    });
	    n8.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent evt){
	            if(ponto){
	                decimal +=8;
	            }
	            inteiro *=10;
	            inteiro +=8;
	            campo.setText(campo.getText()+"8");
	        }
	    });
	    n9.addActionListener (new ActionListener(){
	        public void actionPerformed(ActionEvent evt){
	            if (ponto){
	                decimal +=9;
	            }
	            inteiro *=10;
	            inteiro +=9;
	            campo.setText(campo.getText()+"9");

	        }
	    });
	    n0.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent evt){
	            if(ponto){
	                decimal +=0;
	            }
	            inteiro*=10;
	            inteiro +=0;
	            campo.setText(campo.getText()+"0");
	        }
	    });
	    botaoMais.addActionListener (new ActionListener(){
	        public void actionPerformed(ActionEvent evt){
	            double numero =Double.parseDouble(String.format("%s.%s",inteiro,decimal));
	            operacao = '+';
	            if (memoria > 0){
	                memoria += numero;
	            }else{
	                    memoria = numero;
	                }
	            inteiro = 0;
	            numero = 0;
	            decimal = 0;
	            ponto = false;
	            campo.setText("+ ");
	            }
	        });
	    botaoMenos.addActionListener (new ActionListener(){
	        public void actionPerformed(ActionEvent evt){
	            double numero = Double.parseDouble (String.format("%s.%s",inteiro,decimal));
	            operacao = '-';
	            if (memoria > 0){
	                memoria -= numero;
	            }else {
	                memoria = numero;
	            }
	            numero = 0;
	            inteiro = 0;
	            decimal = 0;
	            ponto = false;
	            campo.setText("- ");
	        }
	    });
	    botaoVezes.addActionListener (new ActionListener(){
	        public void actionPerformed(ActionEvent evt){
	            double numero = Double.parseDouble (String.format("%s.%s",inteiro,decimal));
	            operacao = '*';
	            if (memoria > 0){
	                memoria *= numero;
	            }else {
	                memoria = numero;
	            }
	            numero = 0;
	            inteiro =0;
	            decimal =0;
	            ponto = false;      
	            campo.setText("X ");
	        }
	    });
	    botaoDividi.addActionListener(new ActionListener(){
	        public void actionPerformed (ActionEvent evt){
	            double numero = Double.parseDouble(String.format("%s.%s",inteiro,decimal));
	            operacao = '/';
	            if(memoria >0){
	                memoria /=numero;
	            }else {
	                memoria = numero;
	            }
	            numero=0;
	            inteiro =0;
	            decimal = 0;
	            ponto = false;
	            campo.setText("/ ");
	        }
	    });
	    botaoC.addActionListener (new ActionListener(){
	        public void actionPerformed (ActionEvent evt){
	            inteiro = 0;
	            decimal = 0;
	            memoria = 0;
	            ponto = false;
	            campo.setText("");
	        }
	    });
	    botaoCE.addActionListener(new ActionListener(){
	        public void actionPerformed (ActionEvent evt){
	            inteiro = 0;
	            decimal = 0;
	            memoria = 0;
	            ponto = false;
	            campo.setText("");
	        }
	    });
	    botaoPonto.addActionListener(new ActionListener(){
	        public void actionPerformed (ActionEvent evt){
	            if (!ponto){
	                campo.setText(inteiro +".");
	                ponto = (true);
	            }
	        }
	    });
	    botaoIgual.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent evt){
	            double numero = Double.parseDouble(String.format("%s.%s", inteiro, decimal));
	            switch (operacao){
	            case '+':{
	                memoria += numero;
	                break;
	            }
	            case '-':{
	                memoria -=numero;
	                break;
	            }
	            case '*':{
	                memoria *=numero;
	                break;
	            }
	            case '/':{
	                memoria /=numero;
	                break;
	            }
	            }
	            numero = 0;
	            campo.setText(""+ memoria);
	        }
	    });

	}

	public static void main (String [] args){
	    Calculadora cCalculadora = new Calculadora();
	        cCalculadora.setVisible(true);
	}
}