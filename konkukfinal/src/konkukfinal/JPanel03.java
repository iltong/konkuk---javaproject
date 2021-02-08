package konkukfinal;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.InputMismatchException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import konkukfinal.JPanel01.MyMouseListener;

public class JPanel03 extends JPanel implements ItemListener{

	JButton button1;
	JButton button2;
	ButtonGroup group;
	JPanelMain mainpanel;
	public VocManager vocmanager = null;
	JRadioButton[] check = new JRadioButton[4];
	JLabel Question = new JLabel("퀴즈 시작을 누르세요");
	int[][] table = new int[10][4];
	String [] wronganswer = new String[50];
	int wrong = 0;
	
	int checkstate = 0;
	int questioncount = 0;
	int correct = 0;
	int answernumber;
	long time1,time2;
	
	public JPanel03(JPanelMain mainpanel, VocManager vocmanager) {
		this.mainpanel = mainpanel;
		this.vocmanager = vocmanager;
		setLayout(null);
		
		button1 = new JButton("메인으로");
		button1.setSize(100,30);
		button1.setLocation(10, 10);
		button1.addMouseListener(new MyMouseListener());
		this.add(button1);
		
		button2 = new JButton("퀴즈 시작");
		button2.setSize(100,30);
		button2.setLocation(350, 10);
		button2.addMouseListener(new MyMouseListener());
		this.add(button2);
		
		Question.setSize(300, 100);
		Question.setLocation(120,200);
		this.add(Question);
		
		group = new ButtonGroup();
		
		for(int i = 0; i < check.length; i++) {
			check[i] = new JRadioButton();
			check[i].setBorderPainted(true);
			check[i].setSize(200, 50);
			check[i].setLocation(120, 300 + i * 50);
			check[i].addItemListener(this);
			check[i].setEnabled(false);// 이 객체가 리스너 구현했으니
			group.add(check[i]);
			this.add(check[i]);
			
			
		
		}
		
		
		
	}
	
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == check[0]) {
			checkstate = 1;
		} else if (e.getSource() == check[1]) {
			checkstate = 2;
		}

		else if (e.getSource() == check[2]) {
			checkstate = 3;

		}

		else if (e.getSource() == check[3]) {
			checkstate = 4;

		}

		if (questioncount == 9 && e.getStateChange() == ItemEvent.SELECTED) {
			
			if (checkstate == answernumber)
				correct++;
			else   //오답 노트
			{
				if(wrong<100)
				wronganswer[wrong++] = vocmanager.voc[table[questioncount][0]].eng  + " " + vocmanager.voc[table[questioncount][0]].kor;
			}
			
			time2 = System.currentTimeMillis();
			JOptionPane.showMessageDialog(null, "총 " + correct + "문제 맞추셨습니다\n소요시간-> " + (time2-time1)/1000 +"초");
			questioncount = 0;
			Question.setText("퀴즈 시작을 누르세요");
			for(int i = 0; i < 4; i++) {
				check[i].setText("");
				check[i].setEnabled(false);
			}
		}

		else if (questioncount <= 8 && e.getStateChange() == ItemEvent.SELECTED) {

			if (checkstate == answernumber)
				correct++;
			else   //오답 노트
			{
				if(wrong<100)
				wronganswer[wrong++] = vocmanager.voc[table[questioncount][0]].eng  + " " + vocmanager.voc[table[questioncount][0]].kor;
			}

			questioncount += 1;
			answernumber = (int) (Math.random() * 4) + 1;

			Question.setText("객관식 퀴즈" + (questioncount + 1) +"번. "+vocmanager.voc[table[questioncount][0]].eng+"의 뜻은 무엇일까요?");

			if (answernumber == 1) {
				check[0].setText(vocmanager.voc[table[questioncount][0]].kor);
				check[1].setText(vocmanager.voc[table[questioncount][1]].kor);
				check[2].setText(vocmanager.voc[table[questioncount][2]].kor);
				check[3].setText(vocmanager.voc[table[questioncount][3]].kor);
			} else if (answernumber == 2) {
				check[0].setText(vocmanager.voc[table[questioncount][1]].kor);
				check[1].setText(vocmanager.voc[table[questioncount][0]].kor);
				check[2].setText(vocmanager.voc[table[questioncount][2]].kor);
				check[3].setText(vocmanager.voc[table[questioncount][3]].kor);
			}

			else if (answernumber == 3) {
				check[0].setText(vocmanager.voc[table[questioncount][2]].kor);
				check[1].setText(vocmanager.voc[table[questioncount][1]].kor);
				check[2].setText(vocmanager.voc[table[questioncount][0]].kor);
				check[3].setText(vocmanager.voc[table[questioncount][3]].kor);
			}

			else if (answernumber == 4) {
				check[0].setText(vocmanager.voc[table[questioncount][3]].kor);
				check[1].setText(vocmanager.voc[table[questioncount][1]].kor);
				check[2].setText(vocmanager.voc[table[questioncount][2]].kor);
				check[3].setText(vocmanager.voc[table[questioncount][0]].kor);
			}

		}

		group.clearSelection();
		checkstate = 0;
	}
		
	
	
	public void multipleChoiceQuiz(int inputlength, int[][] table, VocManager vocmanager)
	{
		int count = 0;
		
		int length = inputlength;
		
		
		
		
		
		
		
		while (count < 10)
		{
			int answer = (int)(Math.random() * length);
			
			vocmanager.voc[answer].searchnumber++;
			
			table[count][0] = answer;
			
			int[] other = new int[3];
			int tmp = 0;
		
			while(true)
			{
				if(tmp == 3) break;
				other[tmp] = (int)(Math.random() * length);
				int tmpnum = other[tmp];
				int sucesschecking = 1;
				
				for(int i = 0; i <tmp; i++)
				{
					if(vocmanager.voc[tmpnum].kor.equals(vocmanager.voc[other[i]].kor))
						sucesschecking--;
				}
				
				
				if(vocmanager.voc[tmpnum].kor.equals(vocmanager.voc[answer].kor))
					continue;
				
				
				
				if(sucesschecking == 1) {
					tmp++;
					table[count][tmp] = tmpnum;
				}
					
					
					
			}
				
			count++;
		}
		
		
			
		
	}
	

	
	class MyMouseListener extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource() == button1) {
				mainpanel.ChangePanel("jpanel00");
				Question.setText("퀴즈 시작을 누르세요");
				check[0].setText("");
				check[1].setText("");
				check[2].setText("");
				check[3].setText("");
				group.clearSelection();
				checkstate = 0;
				
			}
			else if(e.getSource() ==button2) {
				
				if(vocmanager.state == true && vocmanager.number < 10) {
					JOptionPane.showMessageDialog(null, "단어장에 등록된 단어가 충분하지 않습니다\n(최소10개필요)현재("+vocmanager.number+"개)");
					return ;
				}
					
				try{multipleChoiceQuiz(vocmanager.number, table, vocmanager);
				
				check[0].setEnabled(true);
				check[1].setEnabled(true);
				check[2].setEnabled(true);
				check[3].setEnabled(true);
				
				correct = 0;
				
				time1 = System.currentTimeMillis();
				
				answernumber = (int)(Math.random() * 4) + 1;
				
				Question.setText("객관식 퀴즈" + (questioncount + 1) +"번. "+vocmanager.voc[table[questioncount][0]].eng+"의 뜻은 무엇일까요?");
				
				if(answernumber == 1) {
				check[0].setText(vocmanager.voc[table[questioncount][0]].kor);
				check[1].setText(vocmanager.voc[table[questioncount][1]].kor);
				check[2].setText(vocmanager.voc[table[questioncount][2]].kor);
				check[3].setText(vocmanager.voc[table[questioncount][3]].kor);
				}
				else if(answernumber == 2) {
					check[0].setText(vocmanager.voc[table[questioncount][1]].kor);
					check[1].setText(vocmanager.voc[table[questioncount][0]].kor);
					check[2].setText(vocmanager.voc[table[questioncount][2]].kor);
					check[3].setText(vocmanager.voc[table[questioncount][3]].kor);
				}
				
				else if(answernumber == 3) {
					check[0].setText(vocmanager.voc[table[questioncount][2]].kor);
					check[1].setText(vocmanager.voc[table[questioncount][1]].kor);
					check[2].setText(vocmanager.voc[table[questioncount][0]].kor);
					check[3].setText(vocmanager.voc[table[questioncount][3]].kor);
				}
				
				else if(answernumber == 4) {
					check[0].setText(vocmanager.voc[table[questioncount][3]].kor);
					check[1].setText(vocmanager.voc[table[questioncount][1]].kor);
					check[2].setText(vocmanager.voc[table[questioncount][2]].kor);
					check[3].setText(vocmanager.voc[table[questioncount][0]].kor);
				}
			
				}
				catch(NullPointerException ee) {
					JOptionPane.showMessageDialog(null, "단어장을 먼저 생성하세요");
				}
				
			}
				
				
		}
		
		
		
	}
}
