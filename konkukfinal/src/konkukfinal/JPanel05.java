package konkukfinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import konkukfinal.JPanel02.MyActionListener;
import konkukfinal.JPanel02.MyMouseListener;

public class JPanel05 extends JPanel {

	JButton button1;
	JPanelMain mainpanel;
	public VocManager vocmanager = null;
	JTextField textfield1;
	JTextField textfield2;
	
	public JPanel05(JPanelMain mainpanel, VocManager vocmanager) {
		this.mainpanel = mainpanel;
		this.vocmanager = vocmanager;
		setLayout(null);
		
		

		button1 = new JButton("메인으로");
		button1.setSize(100, 30);
		button1.setLocation(10, 10);
		button1.addMouseListener(new MyMouseListener());
		this.add(button1);

		textfield1 = new JTextField("영어단어", 15);
		textfield1.setSize(150, 30);
		textfield1.setLocation(100, 120);
		textfield1.addActionListener(new MyActionListener());
		this.add(textfield1);
		
		textfield2 = new JTextField("한글 뜻", 15);
		textfield2.setSize(150, 30);
		textfield2.setLocation(250, 120);
		textfield2.addActionListener(new MyActionListener());
		this.add(textfield2);
	}
	
	class MyMouseListener extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

			if (e.getSource() == button1) {
				mainpanel.ChangePanel("jpanel00");
			}
		}

	}
	
	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == textfield1 || e.getSource() == textfield2) {
				String str1 = textfield1.getText().trim();
				String str2 = textfield2.getText().trim();
				textfield1.setText("영어단어");
				textfield2.setText("한글 뜻");
				if(str1.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*") || !str2.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*"))
				{
					JOptionPane.showMessageDialog(null, "올바른 형식으로 입력하세요");
					return;
				}
				
				if(vocmanager.number < vocmanager.voc.length) {
				vocmanager.addWord(new Word(str1, str2));
				JOptionPane.showMessageDialog(null, str1 + "/" + str2 + " 등록성공");
				if(vocmanager.state == false)
					vocmanager.state = true;
				
				}
				else
					JOptionPane.showMessageDialog(null, "단어장이 가득 찼습니다.");

			}
		}

	}
}
