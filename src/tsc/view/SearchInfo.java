package tsc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;


import tsc.dao.GoodsTypeDao;
import tsc.dbutil.DbUtil;
import tsc.dbutil.StringUtil;
import tsc.model.GoodsType;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.ImageIcon;

public class SearchInfo extends JFrame {

	private JPanel contentPane;
	private JTable goodsInfoTable;
	private DbUtil dbUtil =new DbUtil();
	private GoodsTypeDao goodsTypeDao=new GoodsTypeDao();
	private JTextField s_GoodsTypeNameTxt;
	private JTextField goodsNameTxt;
	private JTextField goodsTypeTxt;
	private JTextField operateTxt;
	private JTextField goodsProduTxt;
	private JTextField idTxt;
	private JTextField goodsPriceTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchInfo frame = new SearchInfo();
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
	public SearchInfo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 760, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u8D27\u7269\u540D\u79F0\u67E5\u8BE2");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		
		s_GoodsTypeNameTxt = new JTextField();
		s_GoodsTypeNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5  \u8BE2");
		btnNewButton.setIcon(new ImageIcon(SearchInfo.class.getResource("/images/search_24px_28084_easyicon.net.png")));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goodsTypeSearchActionPerformed();
				
			}
		});
		
			
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnNewButton_1 = new JButton("\u5220  \u9664");
		btnNewButton_1.setIcon(new ImageIcon(SearchInfo.class.getResource("/images/delete_remove_24px_11088_easyicon.net.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoodsInfoDeleteActionPerform();
			}

			private void GoodsInfoDeleteActionPerform() {
				// TODO Auto-generated method stub
				DbUtil dbUtil=new DbUtil();
				
				java.sql.Connection connection=null;
				
				//String id=idTxt.getText();
				String bookTypename=goodsNameTxt.getText();
			
				if(StringUtil.isEmpty(bookTypename)){
					JOptionPane.showMessageDialog(null, "请选择记录");
					return;
				}
				int k=JOptionPane.showConfirmDialog(null, "确实要删除吗");
				if(k==0){
				try {
					connection=dbUtil.getConnection();
					int n=goodsTypeDao.delete(connection, bookTypename);
					if(n==1){
						JOptionPane.showMessageDialog(null,"删除成功");
						resetValue();
						fillTable(new GoodsType());
						
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
		
		JButton btnNewButton_2 = new JButton("\u4FEE  \u6539");
		btnNewButton_2.setIcon(new ImageIcon(SearchInfo.class.getResource("/images/modify_24px_26154_easyicon.net.png")));
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goodsInfoUpdateActionPerformed();
			}

			private void goodsInfoUpdateActionPerformed() {
				java.sql.Connection connection=null;
				// TODO Auto-generated method stub
				String id=idTxt.getText();
				String goodsTypeName=goodsNameTxt.getText();
				
				String goodsTypeDesc=goodsTypeTxt.getText();
				String goodsPrice= goodsPriceTxt.getText();
				String oprater = operateTxt.getText();
				String goodsProd =goodsProduTxt.getText();
				GoodsType goodsType1=new GoodsType(Integer.parseInt(id),goodsTypeName,goodsTypeDesc,goodsPrice,oprater,goodsProd);
				if(StringUtil.isEmpty(id)){
					JOptionPane.showMessageDialog(null, "请选择记录");
					return;
				}
				
				try {
					
					connection=dbUtil.getConnection();
					int n=GoodsTypeDao.update(connection, goodsType1);
					if(n==1){
						JOptionPane.showMessageDialog(null, "修改成功");
						fillTable(goodsType1);
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(60)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 590, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(72)
							.addComponent(label)
							.addGap(35)
							.addComponent(s_GoodsTypeNameTxt, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
							.addGap(42)
							.addComponent(btnNewButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(105)
							.addComponent(btnNewButton_1)
							.addGap(285)
							.addComponent(btnNewButton_2))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(75)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(84, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(s_GoodsTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("\u8D27\u7269\u540D\u79F0");
		
		JLabel label_1 = new JLabel("\u64CD\u4F5C\u5458");
		
		JLabel label_2 = new JLabel("\u8D27\u7269\u7C7B\u522B");
		
		JLabel label_3 = new JLabel("\u751F\u4EA7\u5546");
		
		goodsNameTxt = new JTextField();
		goodsNameTxt.setColumns(10);
		
		goodsTypeTxt = new JTextField();
		goodsTypeTxt.setColumns(10);
		
		operateTxt = new JTextField();
		operateTxt.setColumns(10);
		
		goodsProduTxt = new JTextField();
		goodsProduTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u8D27\u7269\u7F16\u53F7");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u8D27\u7269\u5355\u4EF7");
		
		goodsPriceTxt = new JTextField();
		goodsPriceTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel_1)
							.addComponent(label_1))
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(operateTxt, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
								.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED))
							.addComponent(goodsNameTxt)))
					.addGap(47)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_2)
						.addComponent(label_3)
						.addComponent(lblNewLabel_2))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(goodsTypeTxt, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
						.addComponent(goodsPriceTxt, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
						.addComponent(goodsProduTxt, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(goodsTypeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(goodsNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_2)
							.addComponent(goodsPriceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(goodsProduTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(operateTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(label_3))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		goodsInfoTable = new JTable();
		goodsInfoTable.addMouseListener(new MouseAdapter() {
			
		
			@Override
			public void mousePressed(MouseEvent e) {
				goodsInfoTableMousePressed();
			}

			private void goodsInfoTableMousePressed() {
				// TODO Auto-generated method stub
				int n=goodsInfoTable.getSelectedRow();
				idTxt.setText((String)goodsInfoTable.getValueAt(n, 0));
				goodsNameTxt.setText((String)goodsInfoTable.getValueAt(n, 1));
				goodsTypeTxt.setText((String)goodsInfoTable.getValueAt(n, 2));
				goodsPriceTxt.setText((String)goodsInfoTable.getValueAt(n, 3));
				operateTxt.setText((String)goodsInfoTable.getValueAt(n, 4));
				goodsProduTxt.setText((String)goodsInfoTable.getValueAt(n, 5));
				
				
			}}
			
				
			
			);
		goodsInfoTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8D27\u7269\u7F16\u53F7", "\u8D27\u7269\u540D\u79F0", "\u8D27\u7269\u7C7B\u522B", "\u8D27\u7269\u5355\u4EF7", "\u64CD\u4F5C\u5458", "\u751F\u4EA7\u5546"
			}
		));
		goodsInfoTable.getColumnModel().getColumn(0).setPreferredWidth(90);
		goodsInfoTable.getColumnModel().getColumn(0).setMinWidth(25);
		goodsInfoTable.getColumnModel().getColumn(1).setPreferredWidth(90);
		goodsInfoTable.getColumnModel().getColumn(1).setMinWidth(25);
		scrollPane.setViewportView(goodsInfoTable);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
		this.fillTable(new GoodsType());
	}
		private void goodsTypeSearchActionPerformed() {
				String s_goodsTypeName=s_GoodsTypeNameTxt.getText();
				GoodsType goodsType=new GoodsType();
				goodsType.setGoodsTypeName(s_goodsTypeName);;
				this.fillTable(goodsType);
		}
		
		private void resetValue() {
			idTxt.setText("");
			goodsNameTxt.setText("");
			goodsTypeTxt.setText("");
			goodsPriceTxt.setText("");
			operateTxt.setText("");
			goodsProduTxt.setText("");
			
			
			
			
		}
		
	private void fillTable(GoodsType goodsType ) {
		DefaultTableModel defaultTableModel=(DefaultTableModel)goodsInfoTable.getModel();
		defaultTableModel.setRowCount(0);
		java.sql.Connection connection =null;
		try {
			connection=dbUtil.getConnection();
			ResultSet rSet=goodsTypeDao.list((Connection) connection, goodsType);
			while(rSet.next()) {
				Vector vector=new Vector();
				vector.add(rSet.getString("id"));
				vector.add(rSet.getString("goodsName"));
				vector.add(rSet.getString("goodsType"));
				vector.add(rSet.getString("goodsPrice"));
				vector.add(rSet.getString("operater"));
				vector.add(rSet.getString("goodsProd"));
				
				
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
