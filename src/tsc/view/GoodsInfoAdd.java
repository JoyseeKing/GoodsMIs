package tsc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tsc.dao.GoodsTypeDao;
import tsc.dbutil.DbUtil;
import tsc.dbutil.StringUtil;
import tsc.model.GoodsType;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class GoodsInfoAdd extends JFrame {

	private JPanel contentPane;
	private JTextField goodsNameTxt;
	private DbUtil dbUtil=new DbUtil();
	private GoodsTypeDao goodsTypeDao=new GoodsTypeDao();
	private JTextField goodsTypeTxt;
	private JTextField goodsPriceTxt;
	private JTextField goodsProdTxt;
	private JTextField OperatorTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GoodsInfoAdd frame = new GoodsInfoAdd();
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
	public GoodsInfoAdd() {
		setTitle("\u5546\u54C1\u4FE1\u606F\u6DFB\u52A0");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 513, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u8D27\u7269\u540D\u79F0");
		
		JLabel lblNewLabel_1 = new JLabel("\u8D27\u7269\u7C7B\u522B");
		
		goodsNameTxt = new JTextField();
		goodsNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6DFB  \u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goodsTypeAddActionPerformed();
			}
		});
		btnNewButton.setIcon(new ImageIcon(GoodsInfoAdd.class.getResource("/images/add_32px_30244_easyicon.net.png")));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JButton button = new JButton("\u91CD  \u7F6E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPerformed();
			}
		});
		button.setIcon(new ImageIcon(GoodsInfoAdd.class.getResource("/images/28025.png")));
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		
		goodsTypeTxt = new JTextField();
		goodsTypeTxt.setColumns(10);
		
		JLabel label = new JLabel("");
		
		JLabel label_1 = new JLabel("\u8D27\u7269\u5355\u4EF7");
		
		JLabel label_2 = new JLabel("\u8D27\u7269\u751F\u4EA7\u5546");
		
		JLabel label_3 = new JLabel("\u64CD\u4F5C\u7BA1\u7406\u5458");
		
		JLabel label_4 = new JLabel("");
		
		goodsPriceTxt = new JTextField();
		goodsPriceTxt.setColumns(10);
		
		goodsProdTxt = new JTextField();
		goodsProdTxt.setColumns(10);
		
		OperatorTxt = new JTextField();
		OperatorTxt.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addComponent(button)
					.addPreferredGap(ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(73))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(54)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_2)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(label_4)
										.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
										.addComponent(lblNewLabel_1)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(label)
											.addGap(92))
										.addComponent(label_1))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(goodsTypeTxt, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
										.addComponent(goodsNameTxt, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
										.addComponent(goodsPriceTxt, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_3)
									.addGap(36)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(goodsProdTxt, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
										.addComponent(OperatorTxt, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))))
							.addGap(100))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(50, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(goodsNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1)
							.addComponent(goodsTypeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(goodsPriceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(78)
							.addComponent(label_4)
							.addGap(30))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_2)
								.addComponent(goodsProdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(39)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(OperatorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(btnNewButton))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);         //	窗口居中
	}
	/**
	 * 链接货物信息添加具体功能的实现
	 */
	

	private void goodsTypeAddActionPerformed() {
		
		
		// TODO Auto-generated method stub
		String goodsTypeName=goodsNameTxt.getText();
		String goodsTypeDesc=goodsTypeTxt.getText();
		String goodsPrice=goodsPriceTxt.getText();
		String goodsProd=goodsProdTxt.getText();
		String operator=OperatorTxt.getText();
		
		
		
		
		GoodsType goodsType=new GoodsType(goodsTypeName,goodsTypeDesc,goodsPrice,goodsProd,operator);
		java.sql.Connection connection=null;
		
		if(StringUtil.isEmpty(goodsTypeName)) {
			JOptionPane.showMessageDialog(null,"货物名称不能为空");
			return;
		}
		if(StringUtil.isEmpty(goodsTypeDesc)) {
			JOptionPane.showMessageDialog(null,"货物类别不能为空");
			return;
		}
		
		if(StringUtil.isEmpty(goodsPrice)) {
			JOptionPane.showMessageDialog(null,"货物单价不能为空");
			return;
		}
		if(StringUtil.isEmpty(goodsProd)) {
			JOptionPane.showMessageDialog(null,"货物生产商不能为空");
			return;
		}
		if(StringUtil.isEmpty(operator)) {
			JOptionPane.showMessageDialog(null,"管理员不能为空");
			return;
		}
		try {
			//关键语句（2）
			connection=dbUtil.getConnection();
			int number=goodsTypeDao.add(connection,goodsType);
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
	/**
	 * 所有文本框信息重置
	 */
	

	private void resetActionPerformed() {
		// TODO Auto-generated method stub
		goodsNameTxt.setText("");
		goodsTypeTxt.setText("");
		goodsPriceTxt.setText("");
		goodsProdTxt.setText("");
		OperatorTxt.setText("");
	}
}
