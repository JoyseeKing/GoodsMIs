package tsc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tsc.dbutil.StringUtil;
import tsc.model.GoodsNum2;
import tsc.model.GoodsType;
import tsc.dbutil.DbUtil;
import tsc.dao.GoodNumsDao;
import tsc.dao.GoodsTypeDao;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.ImageIcon;

public class GoodsNumAdd extends JFrame {

	private JPanel contentPane;
	private JTextField goodsNameTxt;
	private JTextField goodsNumTxt;
	private JTextField goodsPriceTxt;
	private DbUtil dbUtil=new DbUtil();
	
	private JTextField in_NumTxt;
	private JTextField out_NumTxt;
	private JTextField ManagerTxt;
	private JTextField totalPriceTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GoodsNumAdd frame = new GoodsNumAdd();
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
	
	public GoodsNumAdd() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 856, 696);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u8D27\u7269\u540D\u79F0");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel label_1 = new JLabel("\u5E93\u5B58\u6570\u91CF");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel label_2 = new JLabel("\u8D27\u7269\u5355\u4EF7");
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel label_3 = new JLabel("");
		
		goodsNameTxt = new JTextField();
		goodsNameTxt.setColumns(10);
		
		goodsNumTxt = new JTextField();
		goodsNumTxt.setColumns(10);
		
		goodsPriceTxt = new JTextField();
		goodsPriceTxt.setColumns(10);
		
		JButton button = new JButton("\u91CD  \u7F6E");
		button.setIcon(new ImageIcon(GoodsNumAdd.class.getResource("/images/28025.png")));
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPerformed();
				
					
				}
			private void resetActionPerformed() {
				// TODO Auto-generated method stub
				
				goodsNameTxt.setText("");
				goodsNumTxt.setText("");
				goodsPriceTxt.setText("");
				ManagerTxt.setText("");
				totalPriceTxt.setText("");
				
			}
		
			
		});
		
		JButton button_1 = new JButton("\u6DFB  \u52A0");
		button_1.setIcon(new ImageIcon(GoodsNumAdd.class.getResource("/images/add_32px_30244_easyicon.net.png")));
		button_1.setFont(new Font("宋体", Font.PLAIN, 18));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goodsNumAddActionPerformed();
			}

			private void goodsNumAddActionPerformed() {
				java.sql.Connection connection=null;
				// TODO Auto-generated method stub
				String goodsName=goodsNameTxt.getText();
				String goodsNum =goodsNumTxt.getText();
				String goodsPrice=goodsPriceTxt.getText();
				String in_Num=in_NumTxt.getText();
				String out_Num=out_NumTxt.getText();
				String manager=ManagerTxt.getText();
				String totalPrice=totalPriceTxt.getText();
				GoodsNum2 goodsNum2=new GoodsNum2(goodsName,Integer.parseInt(goodsNum), Float.parseFloat(goodsPrice),Integer.parseInt(in_Num),Integer.parseInt(out_Num), manager
						,Float.parseFloat(totalPrice) );

				
				
				
				if(StringUtil.isEmpty(goodsName)) {
					JOptionPane.showMessageDialog(null,"货物名称不能为空");
					return;
				}
				if( StringUtil.isEmpty(goodsNum)){
					JOptionPane.showMessageDialog(null,"请输入正确的货物数量");
					return;
				}
				
	        	if(StringUtil.isEmpty(goodsPrice)){
					JOptionPane.showMessageDialog(null,"请输入正确的单价");
					return;
					}
	                
	        	
	        	
	    		
				try {
					//关键语句（2）
					
					connection=dbUtil.getConnection();
					int number=GoodNumsDao.add(connection,goodsNum2);
					if(number==1) {
						JOptionPane.showMessageDialog(null, "添加成功");
						resetActionPerformed();
					}else {
						JOptionPane.showMessageDialog(null, "添加失败");
						resetActionPerformed();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		
			private void resetActionPerformed() {
				// TODO Auto-generated method stub
				
				goodsNameTxt.setText("");
				goodsNumTxt.setText("");
				goodsPriceTxt.setText("");
				ManagerTxt.setText("");
				totalPriceTxt.setText("");
				
			}
			}
		);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u5165\u5E93\u6570\u91CF");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1 = new JLabel("\u51FA\u5E93\u6570\u91CF");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_2 = new JLabel("");
		
		JLabel lblNewLabel_3 = new JLabel("\u5546\u54C1\u603B\u503C");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		
		in_NumTxt = new JTextField();
		in_NumTxt.setColumns(10);
		
		out_NumTxt = new JTextField();
		out_NumTxt.setColumns(10);
		
		ManagerTxt = new JTextField();
		ManagerTxt.setColumns(10);
		
		totalPriceTxt = new JTextField();
		totalPriceTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u8BBE\u7F6E\u4E3A0");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setIn_nums();
			}

			private void setIn_nums() {
				// TODO Auto-generated method stub
				in_NumTxt.setText("0");
			
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u8BBE\u7F6E\u4E3A0");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOut_nums();
			}

			private void setOut_nums() {
				// TODO Auto-generated method stub
				out_NumTxt.setText("0");
			}
		});
		
		JLabel label_4 = new JLabel("");
		
		JLabel lblNewLabel_4 = new JLabel("\u7BA1\u7406\u5458");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JButton button_2 = new JButton("\u5FEB\u901F\u8BA1\u7B97");
		button_2.setIcon(new ImageIcon(GoodsNumAdd.class.getResource("/images/calculator_19.165467625899px_1210661_easyicon.net.png")));
		button_2.setFont(new Font("宋体", Font.PLAIN, 16));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SumFast();
			}

			private void SumFast() {
				// TODO Auto-generated method stub
				String goodsNum =goodsNumTxt.getText();
				String in_Num=in_NumTxt.getText();
				String out_Num=out_NumTxt.getText();
				String goodsPrice=goodsPriceTxt.getText();
			
				
				
			
			if( StringUtil.isEmpty(goodsNum)){
				JOptionPane.showMessageDialog(null,"请输入正确的货物数量");
				return;
			}
			
        	if(StringUtil.isEmpty(goodsPrice)){
				JOptionPane.showMessageDialog(null,"请输入正确的单价");
				return;
				}
			
        	if(StringUtil.isEmpty(in_Num)){
				JOptionPane.showMessageDialog(null,"请输入正确的入库数量");
				return;
				}
			
        	if(StringUtil.isEmpty(out_Num)){
				JOptionPane.showMessageDialog(null,"请输入正确的出库数量");
				return;
				}
						
				
				int num1=Integer.parseInt(goodsNum);
				int num2=Integer.parseInt(in_Num);
				int num3=Integer.parseInt(out_Num);
				float num4=Float.parseFloat(goodsPrice);
				float num5=(num1+num2-num3)*num4;
				
				
				totalPriceTxt.setText(String.valueOf(num5));
				
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(80)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(label_1)
									.addComponent(label_2))
								.addComponent(label))
							.addGap(44)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(goodsNameTxt)
								.addComponent(goodsNumTxt, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(label_4)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_4))
							.addGap(41)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(out_NumTxt, GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
									.addComponent(in_NumTxt)
									.addComponent(goodsPriceTxt))
								.addComponent(totalPriceTxt, 363, 363, 363)
								.addComponent(ManagerTxt))))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_3))
						.addComponent(btnNewButton_1)
						.addComponent(button_2)
						.addComponent(btnNewButton))
					.addContainerGap(131, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(189)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(104)
							.addComponent(button)))
					.addPreferredGap(ComponentPlacement.RELATED, 369, Short.MAX_VALUE)
					.addComponent(button_1)
					.addGap(183))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(goodsNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(46)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(goodsNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(113)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_2)
								.addComponent(goodsPriceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(in_NumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(btnNewButton))
					.addGap(51)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1)
							.addComponent(out_NumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnNewButton_1)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(13)
								.addComponent(label_3))))
					.addGap(55)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(label_4))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(ManagerTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(button_2)
						.addComponent(totalPriceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(49)
							.addComponent(button_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(41)
							.addComponent(button)))
					.addGap(39))
		);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
	}
}
