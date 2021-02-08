package konkukfinal;


	import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.InputMismatchException;
	import java.util.Scanner;

class RangeCheckException extends Exception {

		public RangeCheckException() {
			super();
			// TODO Auto-generated constructor stub
		}

		public RangeCheckException(String message) {
			super(message);
			// TODO Auto-generated constructor stub
		}
		
	}


public class VocManager {

		public String userName;
		public Word[] voc = new Word[100];
		public int number = 0;
		boolean state = false;
		
		static Scanner scan = new Scanner(System.in);

		public VocManager(String userName) {
			super();
			this.userName = userName;
		}

		void addWord(Word word) {
			if (number < voc.length) {
				voc[number++] = word;
				}
//			else
//				return 0;
		}

void makeVoc(String fileName) {
			try(Scanner scan = new Scanner(new File(fileName))) {
				while(scan.hasNextLine()) {
					String str = scan.nextLine();
					String[] temp = str.split("\t");
					this.addWord(new Word(temp[0].trim(), temp[1].trim()));
				}
				state = true;
				
				
			} catch(FileNotFoundException e) {
				
			};
			
			
		             }

//		
		
		public String searchVoc(String text) {
			
			text = text.trim();
			
			if(state == false) return "단어장이 생성되지 않았습니다.";
			
			for(Word word:voc) {
				if(word!=null) {
					if(word.eng.equals(text)) {
						return word.kor;
					}
				}else {
					return "단어장에 없는 단어입니다.";
				}
			}
			//System.out.println("----------");
			return "단어장에 없는 단어입니다.";
		}
		
		public void searchVoc2(String text, String []buf) {
			
			int tmp = 0;
			
			text = text.trim();
			for(Word word:voc) {
				if(word!=null) {
					if(word.eng.contains(text)) {
						
						String str = word.eng + " " + word.kor;
						buf[tmp] = str;
						tmp++;
						
					}
				}else {
				
					break;
				}
			}
			buf[tmp] = null;
			
		}
		
		
		
		
	}

