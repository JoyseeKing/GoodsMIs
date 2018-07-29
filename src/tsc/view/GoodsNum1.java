package tsc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.management.loading.PrivateClassLoader;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import tsc.dao.GoodNumsDao;
import tsc.dao.GoodsTypeDao;
import tsc.dbutil.DbUtil;
import tsc.dbutil.StringUtil;
import tsc.model.Getid;
import tsc.model.GoodsNum2;
import tsc.model.GoodsType;
import tsc.model.Goodsin_Num;
import tsc.model.Goodsout_Num;
import tsc.model.InAndOutset0;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class GoodsNum1 extends JFrame {

	private JPanel contentPane;
	private JTable goodsNumTable;
	private JTextField in_NumTxt;
	private JTextField out_NumTxt;
	private DbUtil dbUtil=new DbUtil();
	private GoodsNum2 goodsNum2=new GoodsNum2();
	private JTextField s_GoodsNameTxt;
	private JTextField idTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GoodsNum1 frame = new GoodsNum1();
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
	public GoodsNum1() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1154, 624);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u8D27\u7269\u540D\u79F0\u67E5\u8BE2");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JButton btnNewButton = new JButton("\u8D27\u7269\u6E05\u4ED3");
		btnNewButton.setIcon(new ImageIcon(GoodsNum1.class.getResource("/images/delete_remove_24px_11088_easyicon.net.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inventorydelete();
			}
               private void resetValue() {
				idTxt.setText("");
				in_NumTxt.setText("");
				out_NumTxt.setText("");
				}
	
			private void Inventorydelete() {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				DbUtil dbUtil=new DbUtil();
				
				java.sql.Connection connection=null;
				
				String id=idTxt.getText();
				
			
				if(StringUtil.isEmpty(id)){
					JOptionPane.showMessageDialog(null, "请选择记录");
					return;
				}
				int k=JOptionPane.showConfirmDialog(null, "确定要删除吗");
				if(k==0){
				try {
					connection=dbUtil.getConnection();
					int n=GoodNumsDao.deleteInventory(connection, id);
					if(n==1){
						JOptionPane.showMessageDialog(null,"删除成功");
						resetValue();
						fillTable(new GoodsNum2());
						
					}else{
						JOptionPane.showMessageDialog(null, "删除不成功");
					}
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
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
			}
			
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1 = new JLabel("\u5165\u5E93\u6570\u91CF");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		in_NumTxt = new JTextField();
		in_NumTxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u5165  \u5E93");
		btnNewButton_1.setIcon(new ImageIcon(GoodsNum1.class.getResource("/images/In_24px_1191687_easyicon.net.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				in_Numreset();
			}
			private void resetValue() {
				
				in_NumTxt.setText("");
				}
	
			private void in_Numreset() {
				// TODO Auto-generated method stubString goodsNum =goodsNumTxt.getText();
				java.sql.Connection connection=null;
				String in_Num=in_NumTxt.getText();
				String id=idTxt.getText();
				String s_GoodsName=s_GoodsNameTxt.getText();
				GoodsNum2 goodsNum2=new GoodsNum2();
				goodsNum2.setGoodsName(s_GoodsName);;
				
				
				Goodsin_Num goodsin_Num=new Goodsin_Num(Integer.parseInt(in_Num),Integer.parseInt(id));
				
			
					if(StringUtil.isEmpty(id)){
						JOptionPane.showMessageDialog(null, "请选择记录");
						return;
					}
					try {
						
						connection=dbUtil.getConnection();
						int n=GoodNumsDao.update(connection, goodsin_Num);
						if(n==1){
							JOptionPane.showMessageDialog(null, "修改成功");
							 fillTable(goodsNum2);
							resetValue();
							
						}else
						{
							
							JOptionPane.showMessageDialog(null, "修改失败");
						}
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						try {
							connection.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					}}}	);
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_2 = new JLabel("\u51FA\u5E93\u6570\u91CF");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		out_NumTxt = new JTextField();
		out_NumTxt.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("\u51FA  \u5E93");
		btnNewButton_2.setIcon(new ImageIcon(GoodsNum1.class.getResource("/images/Out_24px_1191700_easyicon.net.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				out_Numreset();
			}
                  private void resetValue() {
				
				out_NumTxt.setText("");
				}
			private void out_Numreset() {
				// TODO Auto-generated method stub
				java.sql.Connection connection=null;
				String out_Num=out_NumTxt.getText();
				String id=idTxt.getText();
				String s_GoodsName=s_GoodsNameTxt.getText();
				GoodsNum2 goodsNum2=new GoodsNum2();
				goodsNum2.setGoodsName(s_GoodsName);;
				
				
				Goodsout_Num goodsout_Num=new Goodsout_Num(Integer.parseInt(out_Num),Integer.parseInt(id));
				
			
					if(StringUtil.isEmpty(id)){
						JOptionPane.showMessageDialog(null, "请选择记录");
						return;
					}
					try {
						
						connection=dbUtil.getConnection();
						int n=GoodNumsDao.update2(connection, goodsout_Num);
						if(n==1){
							JOptionPane.showMessageDialog(null, "修改成功");
							 fillTable(goodsNum2);
							resetValue();
							
						}else
						{
							
							JOptionPane.showMessageDialog(null, "修改失败");
						}
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
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
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JButton btnNewButton_3 = new JButton("\u5E93\u5B58\u5237\u65B0");
		btnNewButton_3.setIcon(new ImageIcon(GoodsNum1.class.getResource("/images/refresh_reload_24px_516580_easyicon.net.png")));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RefreshNum();
				RefreshInAndOut();
				
			}
               
			private void RefreshInAndOut() {
				// TODO Auto-generated method stub
				in_NumTxt.setText("0");
				out_NumTxt.setText("0");
				java.sql.Connection connection=null;
				String in_Num=in_NumTxt.getText();
				String out_Num=out_NumTxt.getText();
				String id=idTxt.getText();
				String s_GoodsName=s_GoodsNameTxt.getText();
				GoodsNum2 goodsNum2=new GoodsNum2();
				goodsNum2.setGoodsName(s_GoodsName);;
				
				
				InAndOutset0 inAndOutset0=new InAndOutset0(Integer.parseInt(in_Num),Integer.parseInt(out_Num),Integer.parseInt(id));
				
			
				
					try {
						
						connection=dbUtil.getConnection();
						int n=GoodNumsDao.set0(connection, inAndOutset0);
						if(n==1){
							JOptionPane.showMessageDialog(null, "库存数量计算成功，入库及出库数量已清零");
							 fillTable(goodsNum2);
							
						}else
						{
							
							JOptionPane.showMessageDialog(null, "入库及出库数量清零失败");
						}
						
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
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

			private void RefreshNum() {
				String id=idTxt.getText();
				// TODO Auto-generated method stub
				java.sql.Connection connection=null;
				Getid getid=new Getid(Integer.parseInt(id));
	            try {
						
						connection=dbUtil.getConnection();
						int n=GoodNumsDao.refresh(connection,getid);
						if(n==1){
							JOptionPane.showMessageDialog(null, "刷新成功");
							
							
						}else
						{
							
							JOptionPane.showMessageDialog(null, "刷新失败");
						}
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
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
		});
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JButton btnNewButton_4 = new JButton("\u603B\u503C\u5237\u65B0");
		btnNewButton_4.setIcon(new ImageIcon(GoodsNum1.class.getResource("/images/money_24px_517458_easyicon.net.png")));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TotalPriceRefresh();
			}
			private void TotalPriceRefresh(){
				String id=idTxt.getText();
				// TODO Auto-generated method stub
				java.sql.Connection connection=null;
				String s_GoodsName=s_GoodsNameTxt.getText();
				GoodsNum2 goodsNum2=new GoodsNum2();
				goodsNum2.setGoodsName(s_GoodsName);;
				Getid getid=new Getid(Integer.parseInt(id));
	            try {
						
						connection=dbUtil.getConnection();
						int n=GoodNumsDao.totalpricerefresh(connection,getid);
						if(n==1){
							JOptionPane.showMessageDialog(null, "总值重新计算成功");
							fillTable(goodsNum2);
							
						}else
						{
							
							JOptionPane.showMessageDialog(null, "刷新失败");
						}
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
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
		});
		btnNewButton_4.setFont(new Font("宋体", Font.PLAIN, 18));
		
		s_GoodsNameTxt = new JTextField();
		s_GoodsNameTxt.setColumns(10);
		
		JButton button = new JButton("\u67E5  \u8BE2");
		button.setIcon(new ImageIcon(GoodsNum1.class.getResource("/images/search_24px_28084_easyicon.net.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s_GoodsName=s_GoodsNameTxt.getText();
				GoodsNum2 goodsNum2=new GoodsNum2();
				goodsNum2.setGoodsName(s_GoodsName);;
				
				this.fillTable(goodsNum2);
			}
			/**
			 * 将信息录入表格
			 */
			private void fillTable(GoodsNum2 goodsNum2 ) {
				DefaultTableModel defaultTableModel=(DefaultTableModel)goodsNumTable.getModel();
				defaultTableModel.setRowCount(0);
				java.sql.Connection connection =null;
				try {
					connection=dbUtil.getConnection();
					ResultSet rSet=GoodNumsDao.list((Connection) connection, goodsNum2);
					while(rSet.next()) {
						Vector vector=new Vector();
						vector.add(rSet.getString("id"));
						vector.add(rSet.getString("goodsName"));
						vector.add(rSet.getString("goodsNum"));
						vector.add(rSet.getString("goodsPrice"));
						vector.add(rSet.getString("in_Num"));
						vector.add(rSet.getString("out_num"));
						vector.add(rSet.getString("manager"));
						vector.add(rSet.getString("totalPrice"));
						
						defaultTableModel.addRow(vector);
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
		
			
		});
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_3 = new JLabel("\u8D27\u7269\u7F16\u53F7");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 18));
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(415)
					.addComponent(lblNewLabel_3)
					.addGap(27)
					.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(500, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(62)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(20)
									.addComponent(btnNewButton_3))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(34)
									.addComponent(in_NumTxt, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(55)
									.addComponent(btnNewButton_1)
									.addGap(162)
									.addComponent(lblNewLabel_2)
									.addGap(42)
									.addComponent(out_NumTxt, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
									.addGap(26)
									.addComponent(btnNewButton_2)
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton_4)
									.addGap(213)
									.addComponent(btnNewButton)
									.addGap(161))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(s_GoodsNameTxt, GroupLayout.PREFERRED_SIZE, 672, GroupLayout.PREFERRED_SIZE)
							.addGap(66)
							.addComponent(button)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 993, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_GoodsNameTxt, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(34)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(out_NumTxt, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2)
						.addComponent(lblNewLabel_1)
						.addComponent(in_NumTxt, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1))
					.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_4)
						.addComponent(btnNewButton_3))
					.addGap(41))
		);
		
		goodsNumTable = new JTable();
		goodsNumTable.addMouseListener(new MouseAdapter() {
			//将信息录入表格
			@Override
			public void mousePressed(MouseEvent e) {
				
				goodsNumTableMousePressed();
			}

			private void goodsNumTableMousePressed() {
				// TODO Auto-generated method stub
				int n=goodsNumTable.getSelectedRow();
				idTxt.setText((String)goodsNumTable.getValueAt(n, 0));
				in_NumTxt.setText((String)goodsNumTable.getValueAt(n, 4));
				out_NumTxt.setText((String)goodsNumTable.getValueAt(n, 5));
				
				
			}
		});
		goodsNumTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8D27\u7269\u7F16\u53F7", "\u8D27\u7269\u540D\u79F0", "\u8D27\u7269\u5E93\u5B58", "\u8D27\u7269\u4EF7\u683C", "\u5165\u5E93\u6570\u91CF", "\u51FA\u5E93\u6570\u91CF", "\u7BA1\u7406\u5458", "\u5E93\u5B58\u603B\u4EF7\u503C"
			}
		));
		goodsNumTable.getColumnModel().getColumn(0).setPreferredWidth(85);
		goodsNumTable.getColumnModel().getColumn(0).setMinWidth(25);
		goodsNumTable.getColumnModel().getColumn(1).setPreferredWidth(85);
		goodsNumTable.getColumnModel().getColumn(1).setMinWidth(25);
		goodsNumTable.getColumnModel().getColumn(2).setPreferredWidth(85);
		goodsNumTable.getColumnModel().getColumn(2).setMinWidth(25);
		goodsNumTable.getColumnModel().getColumn(3).setPreferredWidth(85);
		goodsNumTable.getColumnModel().getColumn(3).setMinWidth(25);
		goodsNumTable.getColumnModel().getColumn(4).setPreferredWidth(85);
		goodsNumTable.getColumnModel().getColumn(4).setMinWidth(25);
		goodsNumTable.getColumnModel().getColumn(5).setPreferredWidth(85);
		goodsNumTable.getColumnModel().getColumn(5).setMinWidth(25);
		goodsNumTable.getColumnModel().getColumn(6).setPreferredWidth(85);
		goodsNumTable.getColumnModel().getColumn(6).setMinWidth(25);
		goodsNumTable.getColumnModel().getColumn(7).setPreferredWidth(85);
		goodsNumTable.getColumnModel().getColumn(7).setMinWidth(25);
		scrollPane.setViewportView(goodsNumTable);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
		this.fillTable(new GoodsNum2());
	}
	

	/**
	 * 将信息录入表格
	 */
	private void fillTable(GoodsNum2 goodsNum2 ) {
		DefaultTableModel defaultTableModel=(DefaultTableModel)goodsNumTable.getModel();
		defaultTableModel.setRowCount(0);
		java.sql.Connection connection =null;
		try {
			connection=dbUtil.getConnection();
			ResultSet rSet=GoodNumsDao.list((Connection) connection, goodsNum2);
			while(rSet.next()) {
				Vector vector=new Vector();
				vector.add(rSet.getString("id"));
				vector.add(rSet.getString("goodsName"));
				vector.add(rSet.getString("goodsNum"));
				vector.add(rSet.getString("goodsPrice"));
				vector.add(rSet.getString("in_Num"));
				vector.add(rSet.getString("out_num"));
				vector.add(rSet.getString("manager"));
				vector.add(rSet.getString("totalPrice"));
				
				defaultTableModel.addRow(vector);
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
}
