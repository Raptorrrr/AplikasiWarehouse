import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.WindowConstants;
import javax.swing.*;

import java.sql.*;
import java.awt.CardLayout;

public class Menu extends JFrame {
	Connection connection = null;
	private JPanel contentPane;
	private panelHome Panelhome;
	private panelData Paneldata;
	private panelAdmin Paneladmin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		
		try {
			connection = config.configDB();
		} catch (ClassNotFoundException | SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		int lgin=Login.lgin1;
		int lgin1=Login.lgin2;
		setTitle("Gudang");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 1065, 659);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		
		
		Panelhome = new panelHome();
		Paneldata = new panelData();
		Paneladmin	= new panelAdmin();
		
		JPanel sidebar = new JPanel();
		sidebar.setBorder(null);
		sidebar.setBackground(new Color(0, 102, 102));
		
		JPanel mainContent = new JPanel();
		mainContent.setBorder(null);
		mainContent.setBackground(Color.WHITE);
		
		JPanel login = new JPanel();
		login.setBorder(null);
		login.setBackground(new Color(0, 102, 102));
		
		JPanel signout = new JPanel();
		signout.setBorder(null);
		signout.setBackground(new Color(0, 102, 102));
		
		JPanel paneHome = new JPanel();
		paneHome.addMouseListener(new PanelButtonMouseAdapter(paneHome) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(Panelhome);
			}
		});
		paneHome.setBackground(new Color(0, 102, 102));
		
		JPanel paneData = new JPanel();
		paneData.addMouseListener(new PanelButtonMouseAdapter(paneData) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(Paneldata);
			}
		});
		paneData.setBackground(new Color(0, 102, 102));
		
		JPanel paneAdmin = new JPanel();
		paneAdmin.setLayout(null);
		paneAdmin.setBackground(new Color(0, 102, 102));
		paneAdmin.addMouseListener(new PanelButtonMouseAdapter(paneAdmin) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(Paneladmin);
			}
		});
		if(lgin==0 || lgin1==2) {
			paneAdmin.setVisible(false);
		}else{
			paneAdmin.setVisible(true);
		}
		
		JLabel imgAdm = new JLabel("");
		imgAdm.setBounds(10, 0, 41, 56);
		paneAdmin.add(imgAdm);
		
		Image imgAdm1= new ImageIcon(this.getClass().getResource("/Admin1.png")).getImage();
		imgAdm.setIcon(new ImageIcon(imgAdm1));
		
		JLabel adm = new JLabel("Admin");
		adm.setForeground(Color.WHITE);
		adm.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		adm.setBounds(61, 20, 80, 36);
		paneAdmin.add(adm);
		GroupLayout gl_sidebar = new GroupLayout(sidebar);
		gl_sidebar.setHorizontalGroup(
			gl_sidebar.createParallelGroup(Alignment.LEADING)
				.addComponent(login, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
				.addComponent(signout, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
				.addComponent(paneHome, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
				.addComponent(paneAdmin, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
				.addComponent(paneData, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
		);
		gl_sidebar.setVerticalGroup(
			gl_sidebar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_sidebar.createSequentialGroup()
					.addComponent(login, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(paneHome, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(paneData, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(paneAdmin, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 267, Short.MAX_VALUE)
					.addComponent(signout, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
		);
		signout.setLayout(null);
		JButton btnSignout = new JButton("SignOut");
		btnSignout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int sign = JOptionPane.showConfirmDialog(null, "Ingin Keluar ? ");
				if(sign == JOptionPane.YES_OPTION) {
					System.exit(0);
				}else if(sign == JOptionPane.NO_OPTION) {
					remove(sign);
				}else {
					remove(sign);
				}
				
			}
		});
		btnSignout.setForeground(Color.WHITE);
		btnSignout.setBackground(new Color(0, 102, 102));
		btnSignout.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSignout.setBounds(0, 0, 161, 55);
		signout.add(btnSignout);
		//JOptionPane.showMessageDialog(null, lgin);
		
		if(lgin==0) {
			btnSignout.setVisible(false);
		}else {
			btnSignout.setVisible(true);
		}
		paneData.setLayout(null);
		
		JLabel List = new JLabel("");
		List.setBounds(10, 0, 55, 56);
		paneData.add(List);
		paneHome.setLayout(null);
		Image imgData= new ImageIcon(this.getClass().getResource("/Data2.png")).getImage();
		List.setIcon(new ImageIcon(imgData));
		
		JLabel lblData = new JLabel("Data");
		lblData.setForeground(new Color(255, 255, 255));
		lblData.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblData.setBounds(61, 0, 80, 56);
		paneData.add(lblData);
		
		JLabel home = new JLabel("");
		home.setBounds(10, 0, 41, 56);
		paneHome.add(home);
		
		Image imghome= new ImageIcon(this.getClass().getResource("/list2.png")).getImage();
		home.setIcon(new ImageIcon(imghome));
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setForeground(new Color(255, 255, 255));
		lblHome.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblHome.setBounds(61, 10, 80, 36);
		paneHome.add(lblHome);
		login.setLayout(null);
		
		//Image img = new ImageIcon(this.getClass().getResource("/user5.png")).getImage();
		
		JButton btnLogin = new JButton("");
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Login lgn;
				setVisible(false);
				try {
					setVisible(false);
					lgn = new Login();
					lgn.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnLogin.setForeground(new Color(0, 102, 102));
		Image img = new ImageIcon(this.getClass().getResource("/user5.png")).getImage();
		btnLogin.setIcon(new ImageIcon(img));
		btnLogin.setBackground(new Color(0, 102, 102));
		btnLogin.setBounds(0, 0, 161, 110);
		login.add(btnLogin);
		sidebar.setLayout(gl_sidebar);
		mainContent.setLayout(new CardLayout(0, 0));
		
		mainContent.add(Panelhome);
		mainContent.add(Paneldata);
		mainContent.add(Paneladmin);
		
		menuClicked(Panelhome);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		contentPane.add(sidebar);
		contentPane.add(mainContent);
	}
	
	public void menuClicked(JPanel panel) {
		Panelhome.setVisible(false);
		Paneldata.setVisible(false);
		Paneladmin.setVisible(false);
		
		panel.setVisible(true);
	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter{
		
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel=panel;
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(112,128,144));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(0,102,102));
		}
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(60,179,113));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(112,128,144));
		}
}
}