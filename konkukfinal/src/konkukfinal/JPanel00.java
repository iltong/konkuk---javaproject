package konkukfinal;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanel00 extends JPanel {

	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JButton button6;
	JPanelMain mainpanel;
	
	public JPanel00(JPanelMain mainpanel) {
		this.mainpanel = mainpanel;
		setLayout(null);
		
		JLabel labeltitle = new JLabel("단어장");
		labeltitle.setFont(new Font("궁서", 20, 20));
		labeltitle.setLocation(230, 100);
		labeltitle.setSize(100, 50);
		this.add(labeltitle);
		
		button1 = new JButton("단어 뜻 검색");
		button1.setSize(150,20);
		button1.setLocation(180, 200);
		button1.addMouseListener(new MyMouseListener());
		this.add(button1);
		button2 = new JButton("단어 검색");
		button2.setSize(150,20);
		button2.setLocation(180, 250);
		button2.addMouseListener(new MyMouseListener());
		this.add(button2);
		button3 = new JButton("객관식 퀴즈");
		button3.setSize(150,20);
		button3.setLocation(180, 300);
		button3.addMouseListener(new MyMouseListener());
		this.add(button3);
		button4 = new JButton("빈출 단어 리스트");
		button4.setSize(150,20);
		button4.setLocation(180, 350);
		button4.addMouseListener(new MyMouseListener());
		this.add(button4);
		button5 = new JButton("단어 등록");
		button5.setSize(150,20);
		button5.setLocation(180, 400);
		button5.addMouseListener(new MyMouseListener());
		this.add(button5);
		button6 = new JButton("오답 노트");
		button6.setSize(150,20);
		button6.setLocation(180, 450);
		button6.addMouseListener(new MyMouseListener());
		this.add(button6);
		
	}
	
	class MyMouseListener extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == button1)
			{
				mainpanel.ChangePanel("jpanel01");
			}
			
			else if(e.getSource() == button2)
			{
				mainpanel.ChangePanel("jpanel02");
			}
			
			else if(e.getSource() == button3)
			{
				mainpanel.ChangePanel("jpanel03");
			}
			
			else if(e.getSource() == button4)
			{
				
				mainpanel.ChangePanel("jpanel04");
			}
			
			else if(e.getSource() == button5)
			{
				mainpanel.ChangePanel("jpanel05");
			}
			
			else if(e.getSource() == button6)
			{
				mainpanel.ChangePanel("jpanel06");
			}
			
		}
		
		
		
	}
}
