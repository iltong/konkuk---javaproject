package konkukfinal;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import konkukfinal.JPanel04.MyMouseListener;

public class JPanel06 extends JPanel{

	JButton button1;
	JButton button2;
	JPanelMain mainpanel;
	public VocManager vocmanager = null;
	JTextArea textarea = new JTextArea();
	JScrollPane pane = new JScrollPane(textarea);
	
	public JPanel06(JPanelMain mainpanel, VocManager vocmanager) {
		this.mainpanel = mainpanel;
		this.vocmanager = vocmanager;
		setLayout(null);
		
		button1 = new JButton("메인으로");
		button1.setSize(100,30);
		button1.setLocation(10, 10);
		button1.addMouseListener(new MyMouseListener());
		this.add(button1);
		
		button2 = new JButton("퀴즈 틀린 단어들");
		button2.setSize(150,30);
		button2.setLocation(100, 10);
		button2.addMouseListener(new MyMouseListener());
		this.add(button2);
		
		pane.setSize(300, 500);
		pane.setLocation(10, 100);
		add(pane);
		
	}
	
	class MyMouseListener extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource() == button1) {
				textarea.setText("");
				mainpanel.ChangePanel("jpanel00");
			}
			if(e.getSource() == button2)
			{
				textarea.setText("");
				for (String buf : mainpanel.jpanel03.wronganswer) {

					if (buf != null) {
						textarea.append(buf + "\n");
					} else if (buf == null)
						break;

				}
			}

		}

	}
	
	
}
