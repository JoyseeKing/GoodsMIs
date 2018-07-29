package tsc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tsc.dao.GoodNumsDao;
import tsc.dao.GoodsTypeDao;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTextPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import tsc.dbutil.DbUtil;

import java.awt.Color;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class MainFrm1 extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private DbUtil dbUtil =new DbUtil();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm1 frame = new MainFrm1();
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
	public MainFrm1() {
		setTitle("\u8D27 \u7269 \u7BA1 \u7406 \u7CFB \u7EDF\uFF08Make By \u91D1\u5146\u65ED\uFF09");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 663);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u57FA\u672C\u4FE1\u606F\u7BA1\u7406");
		menuBar.add(mnNewMenu);
		/**
		 * 安全退出
		 */
		
		JMenuItem menuItem_3 = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JMenu menu = new JMenu("\u8D27\u7269\u4FE1\u606F\u7BA1\u7406");
		mnNewMenu.add(menu);
		/**
		 * 链接货物信息添加内部窗体
		 */
		
		JMenuItem menuItem = new JMenuItem("\u4FE1\u606F\u6DFB\u52A0");
		menuItem.addActionListener(new ActionListener() {
			
		public void actionPerformed(ActionEvent e) {
		GoodsInfoAdd goodsInfoAdd =new GoodsInfoAdd();
		goodsInfoAdd.setVisible(true);		
		
		
			}
		});
		/**
		 * 链接货物信息查询修改内部窗体
		 */
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u4FE1\u606F\u4FEE\u6539");
		menuItem_1.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent e) {
					SearchInfo searchInfo =new SearchInfo();
					searchInfo.setVisible(true);		
			}
		});
		menu.add(menuItem_1);
		
		JMenu menu_1 = new JMenu("\u8D27\u7269\u5E93\u5B58\u7BA1\u7406");
		mnNewMenu.add(menu_1);
		
		JMenuItem menuItem_4 = new JMenuItem("\u8D27\u7269\u6570\u91CF\u6DFB\u52A0");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoodsNumAdd goodsNumAdd =new GoodsNumAdd();
				goodsNumAdd.setVisible(true);
			}
		});
		menu_1.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("\u8D27\u7269\u5165\u5E93\u53CA\u51FA\u5E93");
		/**
		 * 链接货物库存修改内部窗体
		 */
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoodsNum1 goodsNum1=new GoodsNum1();
				goodsNum1.setVisible(true);
			}
		});
		menu_1.add(menuItem_5);
		mnNewMenu.add(menuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("");
		menuBar.add(mnNewMenu_1);
		
		JMenu menu_2 = new JMenu("\u4FE1\u606F\u5BFC\u51FA");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_7 = new JMenuItem("\u5BFC\u51FA\u8D27\u7269\u4FE1\u606F");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionOutInfo();
			}

			private void ActionOutInfo() {
				// TODO Auto-generated method stub
				java.sql.Connection connection=null;
            try {
					
					connection=dbUtil.getConnection();
					int n=GoodsTypeDao.outinfo(connection);
					if(n==0){
						JOptionPane.showMessageDialog(null, "导出成功");
						
						
					}else
					{
						
						JOptionPane.showMessageDialog(null, "导出失败");
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
		menu_2.add(menuItem_7);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u5BFC\u51FA\u8D27\u7269\u6570\u91CF");
		/**
		 * 数据的导出1
		 */
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionOutNum();
			}

			private void ActionOutNum() {
				// TODO Auto-generated method stub
				java.sql.Connection connection=null;
            try {
					
					connection=dbUtil.getConnection();
					int n=GoodNumsDao.outinfo(connection);
					if(n==0){
						JOptionPane.showMessageDialog(null, "导出成功");
						
						
					}else
					{
						
						JOptionPane.showMessageDialog(null, "导出失败");
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
		menu_2.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		contentPane.add(desktopPane, BorderLayout.NORTH);
	}
}
