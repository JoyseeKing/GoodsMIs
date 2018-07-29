package tsc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import tsc.dao.UserDao;
import tsc.model.User;
import tsc.dbutil.DbUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private UserDao userdao=new UserDao();
	private DbUtil dbUtil=new DbUtil();
	private JPasswordField passwordTxt;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/group_people_user_users_32px_1406_easyicon.net.png")));
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6 \u7801");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/Change_Password_32px_529182_easyicon.net.png")));
		
		JButton btnNewButton = new JButton("\u91CD \u7F6E");
		/**
		 * 重置账号密码
		 */
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPerformed();
			}
			private void resetActionPerformed() {
				// TODO Auto-generated method stub
				userNameTxt.setText("");
				passwordTxt.setText("");
				
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/28025.png")));
		
		JButton btnNewButton_1 = new JButton("\u767B \u5F55");
		/**
		 * 登录具体操作 判定是否为空 用户名密码不正确时 登录失败
		 */
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed();
			}
			private void loginActionPerformed() {
			String userName=userNameTxt.getText();
			String passWord=passwordTxt.getText();
			User user=new User(userName,passWord);
			java.sql.Connection connection=null;
			if(userName.isEmpty()) {
				JOptionPane.showMessageDialog(null, "用户名不能为空");
				return;
			}
			if(passWord.isEmpty()) {
				JOptionPane.showMessageDialog(null, "密码不能为空");
				return;
			}
			try {
				connection=dbUtil.getConnection();
				User resultUser=UserDao.login(connection,user);
				if(resultUser!=null) {
					JOptionPane.showMessageDialog(null, "登录成功");
					dispose();
					MainFrm1 mainFrm=new MainFrm1();
					
					mainFrm.setVisible(true);
					//Desktop.add(mainFrm);
				}else {
					JOptionPane.showMessageDialog(null, "用户名或密码错误");
					resetActionPerformed();
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				// TODO: handle finally clause
			}
			
				
			}
		private void resetActionPerformed() {
			// TODO Auto-generated method stub
		}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/login_32px_515722_easyicon.net.png")));
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u8D27 \u7269 \u7BA1 \u7406 \u7CFB \u7EDF");
		lblNewLabel_2.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/cargo_25px_1073534_easyicon.net.png")));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 24));
		
		passwordTxt = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(93)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1))
							.addGap(81)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordTxt, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
								.addComponent(userNameTxt, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(203)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton)
							.addGap(129)
							.addComponent(btnNewButton_1)))
					.addGap(173))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(66)
					.addComponent(lblNewLabel_2)
					.addGap(65)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(106)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addGap(77))
		);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
	}
}
