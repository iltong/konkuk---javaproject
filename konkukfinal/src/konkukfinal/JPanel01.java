package konkukfinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanel01 extends JPanel {
	
	JButton button1;
	JButton button2;
	JPanelMain mainpanel;
	JTextField textfield;
	JLabel result;
	public VocManager vocmanager = null;
	
	public JPanel01(JPanelMain mainpanel, VocManager vocmanager) {
		this.mainpanel = mainpanel;
		this.vocmanager = vocmanager;
		setLayout(null);
		
		button1 = new JButton("메인으로");
		button1.setSize(100,30);
		button1.setLocation(10, 10);
		button1.addMouseListener(new MyMouseListener());
		this.add(button1);
		
		textfield = new JTextField("검색할 단어 입력", 15);
		textfield.setSize(150, 30);
		textfield.setLocation(100,120);
		textfield.addActionListener(new MyActionListener());
		this.add(textfield);
		
		result  = new JLabel("");
		result.setSize(200, 30);
		result.setLocation(100, 170);
		this.add(result);
	}
	
	class MyMouseListener extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource() == button1) {
				textfield.setText("검색할 단어 입력");
				result.setText("");
				mainpanel.ChangePanel("jpanel00");
				}
//			if(e.getSource() == button2)
//			{
//				mainpanel.setTitle(vocmanager.voc[2].kor);
//			}
		}
		
		
		
	}
	
	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == textfield) {
				String str = textfield.getText();
				textfield.setText("");
				str = vocmanager.searchVoc(str);
				result.setText(str);
				
			}
		}

	
		
		
	}

}
