package konkukfinal;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import konkukfinal.JPanel01.MyMouseListener;

public class JPanel04 extends JPanel {

	JButton button1;
	JButton button2;
	JPanelMain mainpanel;
	public VocManager vocmanager = null;
	JList finallist =  new JList();
	JScrollPane pane = new JScrollPane(finallist);
	
	public JPanel04(JPanelMain mainpanel, VocManager vocmanager) {
		this.mainpanel = mainpanel;
		this.vocmanager = vocmanager;
		setLayout(null);
		
		button1 = new JButton("메인으로");
		button1.setSize(100,30);
		button1.setLocation(10, 10);
		button1.addMouseListener(new MyMouseListener());
		this.add(button1);
		
		button2 = new JButton("빈도수보기");
		button2.setSize(100,30);
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
			
			if(e.getSource() == button1)
				mainpanel.ChangePanel("jpanel00");
			if(e.getSource() == button2)
				calculate(vocmanager);
		}
		
		
	}
	
	void calculate(VocManager vocmanager) {
		int num = vocmanager.number;
		
		int[] tmp1 = new int[num];
		String[] tmp2 = new String[num];
		int tmp3;
		String tmp4;
		
		for(int i = 0; i < num; i++)
		{
			tmp1[i] = vocmanager.voc[i].searchnumber;
			tmp2[i] = vocmanager.voc[i].eng + " " + vocmanager.voc[i].kor;
		}
		
		for(int i = 1; i < num - 1; i++) {
			for(int j = 1; j < num - i + 1; j++)
			{
				if(tmp1[j - 1] > tmp1[j]) {
					tmp3 = tmp1[j-1];
					tmp1[j-1] = tmp1[j];
					tmp1[j] = tmp3;
					
					tmp4 = tmp2[j-1];
					tmp2[j-1] = tmp2[j];
					tmp2[j] = tmp4;
				}
					
			}
		}
		
		String [] result = new String[num];
		
		for(int i = 0; i < num; i++)
		{
			result[num - i - 1] = tmp1[i] + "번 출제   " + tmp2[i];
		}
		
		finallist.setListData(result);
		
		
		
		
	}
}
