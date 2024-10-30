import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class body{
	static window w;
	 tpanel t;
	 bpanel b;
	body(){
		w = new window();
		t = new tpanel();
		b = new bpanel();
		w.add(t);
		w.add(b);
		w.setVisible(true);
	}
}
class window extends JFrame{	
	window(){
	
	this.setTitle("Calculator");
	this.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("m.png"))).getImage());
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(450,670);
	this.setResizable(false);
	this.getContentPane().setBackground(Color.black);
	this.setLayout(null);
	}
}
class bpanel extends JPanel implements ActionListener{
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bclear, bdel, bequals, badd, bsubt, bmult, bdiv, bdec, bsqrt, bpow, bprcnt, bb;
	JPanel emp1, emp2;
	bpanel(){
		b1=new JButton("1");b2=new JButton("2");b3=new JButton("3");
		b4=new JButton("4");b5=new JButton("5");b6=new JButton("6");
		b7=new JButton("7");b8=new JButton("8");b9=new JButton("9");
		b0=new JButton("0");bdec=new JButton(".");
		bclear=new JButton("C");bdel=new JButton();
		bsubt=new JButton("-");badd=new JButton("+");
		bmult=new JButton("×");bdiv=new JButton("÷");
		bsqrt=new JButton("√");bpow=new JButton("x²");
		bprcnt=new JButton("%");bequals=new JButton("=");
		bb=new JButton("±");
		emp1 = new JPanel();
		emp2 = new JPanel();
		emp1.setBackground(Color.black);
		emp2.setBackground(Color.black);
		bdel.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("ico.png"))));
		JButton[] f = {bclear,bdel, bequals, badd, bsubt, bmult, bdiv, bdec, bsqrt, bpow, bprcnt, bb};
		JButton[] n = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b0};
		this.setBounds(20,215,393,395);
		this.setBackground(Color.black);
		this.setLayout(new GridLayout(6,4,9,9));		
		for (JButton x:n) {
			x.addActionListener(e -> {
                if (ao || (tpanel.textfield.getText().equals("0") || tpanel.textfield.getText().equals("-0"))) {
                    tpanel.textfield.setText("");
                    ao=false;
                    dec=false;
                }
                tpanel.textfield.setText(tpanel.textfield.getText()+x.getText());
                num2=Double.parseDouble(tpanel.textfield.getText());
                operator();
            });
			x.setFont(new Font("Arial",Font.BOLD,20));
			x.setBorder(BorderFactory.createLineBorder(Color.white, 3, true));
			x.setBackground(Color.darkGray);
			x.setForeground(Color.white);
			x.setFocusable(false);
		}
		for(JButton x:f) {
			x.addActionListener(this);
			x.setFont(new Font("Arial",Font.BOLD,20));
			x.setBorder(BorderFactory.createLineBorder(Color.white, 3, true));
			x.setBackground(Color.lightGray);
			x.setForeground(Color.black);
			x.setFocusable(false);
		}		
		bmult.setBackground(new Color(230,100,30));
		bsubt.setBackground(new Color(230,100,30));
		badd.setBackground(new Color(230,100,30));
		bdiv.setBackground(new Color(230,100,30));
		bequals.setBackground(new Color(230,100,30));
		bdel.setBorder(null);
		bdel.setOpaque(false);
		this.add(bclear);
		this.add(emp1);
		this.add(emp2);
		this.add(bdel);
		this.add(bsqrt);
		this.add(bpow);
		this.add(bprcnt);
		this.add(bdiv);
		this.add(b7);
		this.add(b8);
		this.add(b9);
		this.add(bmult);
		this.add(b4);
		this.add(b5);
		this.add(b6);
		this.add(bsubt);
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(badd);
		this.add(b0);
		this.add(bb);
		this.add(bdec);
		this.add(bequals);
	}
	double num1,num2, finale;
	char op='n';
	boolean ao,dec;	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==badd) {
			ao=true;
			num1=finale;
			op='a';
			tpanel.textfield.setText(Double.toString(num1));
		}
		else if(e.getSource()==bsubt) {
			ao=true;
			num1=finale;
			op='s';
			tpanel.textfield.setText(Double.toString(num1));
		}
		else if(e.getSource()==bmult) {
			ao=true;
			num1=finale;
			op='m';
			tpanel.textfield.setText(Double.toString(num1));
		}
		else if(e.getSource()==bdiv) {
			ao=true;
			num1=finale;
			op='d';
			tpanel.textfield.setText(Double.toString(num1));
		}
		else if(e.getSource()==bprcnt) {
			ao=true;	
			if (op=='n') {
				tpanel.textfield.setText(Double.toString(Double.parseDouble(tpanel.textfield.getText())/100));
			}
			else {
				tpanel.textfield.setText(Double.toString((num1/100)*Double.parseDouble(tpanel.textfield.getText())));
			}
			num2=Double.parseDouble(tpanel.textfield.getText());
			operator();
		}
		else if(e.getSource()==bsqrt) {
			ao=true;
			tpanel.textfield.setText(Double.toString(Math.sqrt(Double.parseDouble(tpanel.textfield.getText()))));
			num2=Double.parseDouble(tpanel.textfield.getText());
			operator();	
		}
		else if (e.getSource()==bpow) {
			ao=true;
			tpanel.textfield.setText(Double.toString(Math.pow(Double.parseDouble(tpanel.textfield.getText()),2)));
			num2=Double.parseDouble(tpanel.textfield.getText());
			operator();
		}
		else if(e.getSource()==bequals) {
			operator();	
			tpanel.textfield.setText(Double.toString(finale));
			ao=true;
			dec=false;
			num1=finale;
		}
		else if (e.getSource()==bdec) {
			if(!ao) {
				if (!dec) {
					tpanel.textfield.setText(tpanel.textfield.getText()+".");
					dec=true;
				}
			}
			else {
				tpanel.textfield.setText("0.");
				dec=true;
			}
			ao=false;
		}
		else if(e.getSource()==bdel) {
			if( tpanel.textfield.getText().length()>1 && !ao) {
			tpanel.textfield.setText(tpanel.textfield.getText().substring(0, tpanel.textfield.getText().length()-1));
			}
			else {
				tpanel.textfield.setText("0");
				finale=0;
				num2=0;
				op='n';
				dec=false;
				ao=true;
			}
			if (! tpanel.textfield.getText().contains(".")){
				dec=false;
			}
			operator();
		}
		else if(e.getSource()==bclear) {
			dec=false;
			ao=true;
			op='n';
			tpanel.textfield.setText("0");
			finale=0;
			num2=0;
		}
		else if (e.getSource()==bb) {
			if (!ao) {
				if (tpanel.textfield.getText().contains("-")){
					tpanel.textfield.setText(tpanel.textfield.getText().replace("-", ""));
				}
				else {
					tpanel.textfield.setText("-"+tpanel.textfield.getText());
				}
			}
			num2=Double.parseDouble(tpanel.textfield.getText());
			operator();
		}
		tpanel.corrector();
	}	
	private void operator() {		
		if(op=='n') {
			num1=Double.parseDouble(tpanel.textfield.getText());		
			finale=num1;			
		}
		else {		
			if(op=='a') {
				finale=num1+num2;
			}
			else if(op=='s') {
				finale=num1-num2;
			}
			else if(op=='m') {
				finale=num1*num2;
			}
			else if(op=='d') {
				finale=num1/num2;
			}
		}
	}
}
 class tpanel extends JPanel{
	static JTextField textfield;
	tpanel(){	
		this.setBackground(Color.black);
		this.setBounds(20, 20, 400, 170);
		this.setLayout(new BorderLayout());
		textfield = new JTextField("0");
		textfield.setEditable(false);
		textfield.setCaretColor(Color.black);
		textfield.setBackground(Color.black);
		textfield.setFont(new Font("Arial",Font.BOLD,30));
		textfield.setForeground(Color.white);
		textfield.setBorder(null);
		textfield.setHorizontalAlignment(JTextField.RIGHT);
		this.add(textfield,BorderLayout.SOUTH);
	}
	static void corrector() {
		if(textfield.getText().endsWith(".0")) {
			textfield.setText(textfield.getText().replace(".0", ""));
		}
	}
}