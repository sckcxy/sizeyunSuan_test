package ui_test;

import java.awt.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import ui_test.DTimeFrame;  


public class MyExGUI extends JFrame{
	ArrayList<String> user_zongti = new ArrayList<String>();
	ArrayList<String> user_zonganswer = new ArrayList<String>();
	ArrayList<String> user_answer = new ArrayList<String>();
	ArrayList<String> true_answer = new ArrayList<String>();
	ArrayList<String> jta_timu = new ArrayList<String>();
	ArrayList<String> jta_zong = new ArrayList<String>();
	ArrayList<Integer> user_fenshu = new ArrayList<Integer>();
	JMenuBar jmb;   //�˵������  
    JMenu menu1;//�˵�  
    JMenuItem item1, item2;//�˵���  
    JMenu build;    //�����˵�  
    JMenuItem file, project; 
    TextArea answer_all = new TextArea();
    TextField jta = new TextField();
    TextField jta_answer = new TextField(); 
    JLabel num_answer = new JLabel();
    JLabel answer1;
    JToolBar jtb;//������  
    JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7,jb_next;  
    int answer_count;
    int answer_fenshu;
 //ʱ����ʾ�߳�%%%%%
    Thread thread1;//%%%%
    public MyExGUI()
    {  
        //�����˵�  
        jmb = new JMenuBar();  
        
        menu1 = new JMenu("�ļ�(F)");  
        menu1.setMnemonic('f'); //���Ƿ�    
        
        build = new JMenu("�½�");  
          
          
        project = new JMenuItem("����");  
        item1 = new JMenuItem("��");  
        item2 = new JMenuItem("����(S)");  
          
        
        answer1 = new JLabel("�� 1 ��");
               
            //��Ӳ˵������˵���  
          
        build.add(project);  
          
        menu1.add(build);  
        menu1.add(item1);  
        menu1.add(item2);  
        menu1.addSeparator(); 
        
            //���˵��������˵���  
        jmb.add(menu1);   
        
          
        
    	JPanel contentPanel = new JPanel();
    	contentPanel.setLayout(null);
    	JLabel daan = new JLabel("��");
    	JLabel dengyu = new JLabel("=");
        num_answer=answer1;
        num_answer.setFont(new Font("����",Font.BOLD, 22));
        jb_next = new JButton("��һ��");
        jta.setFont(new Font("����",Font.BOLD, 22));
        jta_answer.setFont(new Font("����",Font.BOLD, 22));
        jb_next.setFont(new Font("����",Font.BOLD, 22));
        daan.setFont(new Font("����",Font.BOLD, 22));
        dengyu.setFont(new Font("����",Font.BOLD, 22));
        
    	contentPanel.add(num_answer);
    	contentPanel.add(daan);
    	contentPanel.add(dengyu);
    	contentPanel.add(jta);

    	contentPanel.add(jta_answer);
    	contentPanel.add(answer_all);
    	contentPanel.add(jb_next);
    	
        num_answer.setBounds(90, 20, 130, 50);
        daan.setBounds(250, 20, 90, 50);
        jta.setBounds(50, 70, 150, 30);
        dengyu.setBounds(205, 70, 20, 20);
        jta_answer.setBounds(230, 70, 100, 30);
        jb_next.setBounds(350, 70, 110, 30);
        answer_all.setBounds(50, 120, 400, 300);
        
        this.setJMenuBar(jmb);  //��Ӳ˵����������趨λ�ã����Զ��������ϲ�  
        this.add(contentPanel);
        
        this.setTitle("���ߴ���ϵͳ");  
        this.setSize(600, 500);  
        this.setVisible(true);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        item1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFileChooser jfc=new JFileChooser();                        
			    jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
			    jfc.showDialog(new JLabel(), "ѡ��");  
			    File file=jfc.getSelectedFile();  
			    if(file.isDirectory()){  
			//  System.out.println("�ļ���:"+file.getAbsolutePath()); 
			    }else if(file.isFile()){  
			        String s=file.getAbsolutePath();  
			    }    
			}
		});
        item2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FileOutputStream outSTr = null;
			    BufferedOutputStream Buff = null;
				boolean flag = true;
				File file;
				//String test ;
				do{
					//test = "test"+count;
			    
					String inputValue = JOptionPane.showInputDialog("Please input file name"); 
					file = new File(inputValue+".txt");
					if (!file.exists()) {
			            // �����ļ�
			            try {
			            	
			            	flag=file.createNewFile();
							
						} catch (IOException e) {
							e.printStackTrace();
							
						}
			            flag=false;
			        }
					else{
						
						JOptionPane.showMessageDialog(null, "���ļ����Ѵ��ڣ�����������", "ERROR", JOptionPane.ERROR_MESSAGE);
						flag=true;
					}
				}while(flag);
				//д���ļ�
				String u_answer;
				try {
					outSTr = new FileOutputStream(file);
			        Buff = new BufferedOutputStream(outSTr);
			        System.out.println("ѡ���Ǻ�ִ�еĴ���"+user_zongti.size()+user_answer.size()); 
				        for (int i = 0; i < user_zongti.size(); i++) 
				        {
				            try {
								Buff.write(user_zongti.get(i).getBytes());
								Buff.write("    ".getBytes());
								u_answer = user_answer.get(i);
								if(u_answer.equals(""))
									u_answer ="û������";
								
								Buff.write(u_answer.getBytes());
								Buff.write("\r\n".getBytes());
							} catch (IOException e) {
								e.printStackTrace();
								i--;
							}
				        }
			        Buff.flush();
			        Buff.close();
			        
					} catch (IOException e) {
						e.printStackTrace();
					}
					//Buff.close();
			        try {
						outSTr.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			        user_zongti.clear();
			        user_answer.clear();
			}
		});
        
        project.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//��ʱ��׼��$$$$
				DTimeFrame df2=new DTimeFrame();
	    		 df2.setVisible(true);
	    		 thread1=new Thread(df2);
	    		 thread1.start();//$$$$
				arithmetic art = new arithmetic();
				true_answer=art.list_answer;
				jta_timu = art.list_timu;
				jta_zong = art.list;
				answer_count=1;
				answer_all.setText("");
				for (int i = 0; i < art.list_timu.size(); i++)
				{
					user_zongti.add(jta_zong.get(i));
					answer_all.append(jta_timu.get(i));
					answer_all.append("\r\n");
				}
				num_answer.setText("�� "+answer_count+" ��");	
				jta.setText(jta_timu.get(answer_count-1));
				answer_count++;
				
				
			}
		});
        jb_next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String temp;
				temp = jta_answer.getText();
				
				if(jta.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "����,�뵼�����", "����", JOptionPane.ERROR_MESSAGE);
					return;
				}
				jta_answer.setText("");
				if(answer_count<=20)
				{
					if(isInteger(temp))
					{
						  
						user_answer.add(temp);
						System.out.println("ѡ����ִ�еĴ���"+temp+"user_size"+user_answer.size());
						num_answer.setText("�� "+answer_count+" ��");	
						jta.setText(jta_timu.get(answer_count-1));
						answer_count++;
					}
					else{
						JOptionPane.showMessageDialog(null, "����", "����������", JOptionPane.ERROR_MESSAGE);
					}
				}
				else{
					user_answer.add(temp);
					System.out.println("ѡ����ִ�еĴ���"+temp+"user_size"+user_answer.size());
					answer_fenshu=0;
					for(int i=0;i<user_answer.size();i++)
					{
						if(user_answer.get(i).equals(true_answer.get(i)))
							answer_fenshu+=5;
					}
					user_fenshu.add(answer_fenshu);
					Object[] options = { "��", "ȡ��" }; 
					int res=JOptionPane.showOptionDialog(null,"����Լ��� �鿴�ɼ�", "�������", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.YES_NO_OPTION, 
					null, options, options[0]); 
					if(res==JOptionPane.YES_OPTION){
						chart ct =new chart(user_fenshu);
						ct.setVisible(true);
						
					}else{

						}
						
					} 
					
					
					
				}
				
				
				
		});
        
        
        
        
    }
    
    public static boolean isInteger(String str) {    
	    for (int i = str.length();--i>=0;){  
			        if (!Character.isDigit(str.charAt(i))){
			            return false;
			        }
			    }
			    return true;
	  } 
    
    
	
	
}
