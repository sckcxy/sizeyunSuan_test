package ui_test;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;


public class Login {

	public Login() 
	{
		JFrame f=new JFrame();
		f.setTitle("Сѧ�������������ϵͳ");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setVisible(true);
		
		//���ô��ڵĴ�С��λ��
		f.setSize(500,500);
		f.setLocation(200,200);
		
		Container con=f.getContentPane();//����һ������	
		con.setLayout(new GridLayout(7,1));
		
		JPanel pan1 =new JPanel();
		JLabel title=new JLabel("��ӭ��½Сѧ�������������ϵͳ");
		title.setFont(new Font("����",Font.BOLD, 20));
		pan1.add(title);
		con.add(pan1);
		//����һ���µİ�	  
		JPanel pan2 = new JPanel();
		JPanel pan3 = new JPanel();
		JPanel pan4 = new JPanel();
		JPanel pan5 = new JPanel();
		
		con.add(pan2);
		con.add(pan3);	
		con.add(pan4);
		con.add(pan5);
		
		JLabel name=new JLabel("�û���");
		pan2.add(name);
		TextField tf_name=new TextField(20);
		pan2.add(tf_name);
		
		JLabel pass = new JLabel("����");
		pan3.add(pass);
		TextField password=new TextField(20);
		password.setEchoChar('*');
		pan3.add(password);
		
		JButton b_log=new JButton("��½");  
		b_log.addActionListener(new ActionListener() {  
		    public void actionPerformed(ActionEvent e) {  
		        // TODO Auto-generated method stub  
		        //��ȡ�û��������룬����У��  
		        String myUsername=tf_name.getText(); 
				String myPassword=password.getText();  
		        if(myUsername.equals("admin")&& myPassword.equals("123456")){  
		            JOptionPane.showMessageDialog(null, "��½�ɹ�!");  
		            f.dispose();
		            new MyExGUI();
		            
		        }
		        else{  
		            JOptionPane.showMessageDialog(null, "�˺Ż��������!");  
		            name.setText( "");  
		            password.setText( "");  	
		        }  
		          
		    }  
		});  
		pan4.add(b_log); 
		
		JButton b_exit=new JButton("�˳�");  	 
		b_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 JOptionPane.showMessageDialog(null, "ллʹ�ã�");
				 f.setVisible(false);//���ش���
				 System.exit(0);//�˳�����
			}		
		});
		pan5.add(b_exit);  
		//��½���˳���������ť���ڵ��ĸ�������
		

	}

}