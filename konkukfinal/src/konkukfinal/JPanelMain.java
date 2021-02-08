package konkukfinal;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JPanelMain extends JFrame{

	public JPanel00 jpanel00 = null;
	public JPanel01 jpanel01 = null;
	public JPanel02 jpanel02 = null;
	public JPanel03 jpanel03 = null;
	public JPanel04 jpanel04 = null;
	public JPanel05 jpanel05 = null;
	public JPanel06 jpanel06 = null;
	
	public VocManager vocmanager = null;
	

	
	public JPanelMain(VocManager vocmanager) throws HeadlessException {
		super();
		
		this.vocmanager = vocmanager;
		
		JMenuBar mb = new JMenuBar();
		
		JMenu fileMenu = new JMenu("설정");
		
		mb.add(fileMenu);
		
		JMenuItem wordmake = new JMenuItem("단어장 불러오기");
		wordmake.addActionListener(new MyActionListener());
		
		fileMenu.add(wordmake);
		
	
		
		this.setJMenuBar(mb);
		
		
		
		setTitle("201711256 전재구");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500,700);
		setVisible(true);
	}
	
	

	class MyActionListener implements ActionListener {
		String filePath;
		JFileChooser chooser;
		MyActionListener() {
			chooser = new JFileChooser();
			
		}
		

		@Override
		public void actionPerformed(ActionEvent e) {
			FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "txt");
			chooser.setFileFilter(filter);
			chooser.setMultiSelectionEnabled(false);
			
			
			String cmd = e.getActionCommand();
			// TODO Auto-generated method stub
			if(cmd.equals("단어장 불러오기")) {
				// 단어장 불러오는 과정
				int ret = chooser.showOpenDialog(null);
				if(ret != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "파일을 선택하지않음");
					return ;
				}
				try{
				if(vocmanager.number >= 100) {
					JOptionPane.showMessageDialog(null, "단어장이 가득찼습니다.");
					return;
				}
					
				filePath = chooser.getSelectedFile().getPath();
				vocmanager.makeVoc(filePath);
				
				}
				catch(NullPointerException eee) {
					
					JOptionPane.showMessageDialog(null, "올바른 양식의 txt파일을 선택하세요");
					
				} catch(ArrayIndexOutOfBoundsException eeee) {
					JOptionPane.showMessageDialog(null, "올바른 양식의 txt파일을 선택하세요");
				}
				
				
			}
			
			
		}
		
	}
	
	


	public void ChangePanel(String name) {
		if(name.equals("jpanel00")) {
			getContentPane().removeAll();
			getContentPane().add(jpanel00);
			revalidate();
			repaint();
		}
		
		else if(name.equals("jpanel01")) {
			getContentPane().removeAll();
			getContentPane().add(jpanel01);
			revalidate();
			repaint();
		}
		

		else if(name.equals("jpanel02")) {
			getContentPane().removeAll();
			getContentPane().add(jpanel02);
			revalidate();
			repaint();
		}
		
		

		else if(name.equals("jpanel03")) {
			getContentPane().removeAll();
			getContentPane().add(jpanel03);
			revalidate();
			repaint();
		}
		
		

		else if(name.equals("jpanel04")) {
			getContentPane().removeAll();
			getContentPane().add(jpanel04);
			revalidate();
			repaint();
		}
		
		else if(name.equals("jpanel05")) {
			getContentPane().removeAll();
			getContentPane().add(jpanel05);
			revalidate();
			repaint();
		}
		

		else if(name.equals("jpanel06")) {
			getContentPane().removeAll();
			getContentPane().add(jpanel06);
			revalidate();
			repaint();
		}
		
	}
}
