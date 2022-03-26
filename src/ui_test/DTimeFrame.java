package ui_test;
import java.awt.Dimension;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DTimeFrame extends JFrame implements Runnable{
	private JPanel timePanel;
	private JLabel timeLabel;
	private JLabel displayArea;
	private String DEFAULT_TIME_FORMAT = "ss";
	 private int ONE_SECOND = 1000;

	 public DTimeFrame(){
		 timePanel = new JPanel();
		 timeLabel = new JLabel("��ʱ�� ");
		 displayArea = new JLabel();
	  
		 timePanel.add(timeLabel);
		 timePanel.add(displayArea);
		 this.add(timePanel);
		 this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		 this.setSize(new Dimension(200,100));
		 this.setBounds(900, 100, 200, 100);
		 /*��һ�������������JFrame�е�x����
		�ڶ��������������JFrame�е�y����
   	�����������������JFrame�е�������
		���ĸ������������JFrame�е�����߶�*/
	 }
	 public void run(){
		 int time=1;
		 while(true){
			 	SimpleDateFormat dateFormatter = new SimpleDateFormat(DEFAULT_TIME_FORMAT);/*�������ڸ�ʽ*/
			 	displayArea.setText(time+"s");
			 	try{
			 		time++;
			 		Thread.sleep(ONE_SECOND); 
			 	}catch(Exception e)
			 	{
			 		displayArea.setText("Error!!!");
			 	}
		 }  
	 } 
}
