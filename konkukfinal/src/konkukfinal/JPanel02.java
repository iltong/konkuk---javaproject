package konkukfinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import konkukfinal.JPanel01.MyActionListener;
import konkukfinal.JPanel01.MyMouseListener;

public class JPanel02 extends JPanel {

	JButton button1;
	JPanelMain mainpanel;
	public VocManager vocmanager = null;
	String[] buf = new String[100];
	JTextField textfield;
	JTextArea textarea;

	public JPanel02(JPanelMain mainpanel, VocManager vocmanager) {
		this.mainpanel = mainpanel;
		this.vocmanager = vocmanager;
		setLayout(null);

		button1 = new JButton("메인으로");
		button1.setSize(100, 30);
		button1.setLocation(10, 10);
		button1.addMouseListener(new MyMouseListener());
		this.add(button1);

		textfield = new JTextField("검색할 단어 입력", 15);
		textfield.setSize(150, 30);
		textfield.setLocation(100, 120);
		textfield.addActionListener(new MyActionListener());
		this.add(textfield);

		textarea = new JTextArea(20, 15);
		textarea.setSize(300, 180);
		textarea.setLocation(100, 200);

		this.add(textarea);
	}

	class MyMouseListener extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

			if (e.getSource() == button1) {
				textarea.setText("");
				mainpanel.ChangePanel("jpanel00");
			}
		}

	}

	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			int tmp = 0;

			if (e.getSource() == textfield && vocmanager.state == true) {

				String str = textfield.getText().trim();

				
				textarea.setText("");

			
				vocmanager.searchVoc2(str, buf);

				for (String buf : buf) {

					
					
					if (buf != null) {
						textarea.append(buf + "\n");
						tmp++;
					}
					else if (buf == null)
						break;
					
					
				}


				if (tmp == 0)
					textarea.append("해당하는 단어가 없습니다.");
				
				
				textfield.setText("");
			} else if (e.getSource() == textfield && vocmanager.state == false)
				JOptionPane.showMessageDialog(null, "단어장을 먼저 생성하세요");
		}

	}
}
