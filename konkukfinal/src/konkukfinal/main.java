package konkukfinal;

import javax.swing.JFrame;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VocManager voc = new VocManager("단어장");
		JPanelMain main = new JPanelMain(voc);
		
		
		main.jpanel00 = new JPanel00(main);
		main.jpanel01 = new JPanel01(main, voc);
		main.jpanel02 = new JPanel02(main, voc);
		main.jpanel03 = new JPanel03(main, voc);
		main.jpanel04 = new JPanel04(main, voc);
		main.jpanel05 = new JPanel05(main, voc);
		main.jpanel06 = new JPanel06(main, voc);
		
		main.add(main.jpanel00);
		main.revalidate();
		main.repaint();

	}

}
