import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.sql.*;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;

public class panelAdmin extends JPanel {
	Connection connection = null;
	private JTable table;
	private JTextField txtNama;
	private JTextField txtUsername;
	private JTextField txtPass;
	private JLayeredPane layeredPane;
	private JPanel panelAdd;
	private JPanel panelEdit;
	private JComboBox hak;
	int baris;
	
	public panelAdmin() {
		
		try {
			connection = config.configDB();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel Edit = new JPanel();
		Edit.setBorder(new LineBorder(Color.BLACK));
		Edit.setBackground(Color.LIGHT_GRAY);
		add(Edit, BorderLayout.SOUTH);
		
		JPanel kelolaAdm = new JPanel();
		kelolaAdm.setBackground(new Color(255, 255, 255));
		GroupLayout gl_Edit = new GroupLayout(Edit);
		gl_Edit.setHorizontalGroup(
			gl_Edit.createParallelGroup(Alignment.LEADING)
				.addComponent(kelolaAdm, GroupLayout.PREFERRED_SIZE, 670, Short.MAX_VALUE)
		);
		gl_Edit.setVerticalGroup(
			gl_Edit.createParallelGroup(Alignment.LEADING)
				.addComponent(kelolaAdm, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		kelolaAdm.setLayout(new BorderLayout(0, 0));
		
		JPanel Head = new JPanel();
		Head.setBackground(new Color(127, 255, 212));
		kelolaAdm.add(Head, BorderLayout.NORTH);
		
		JLabel lblKelolaAdmin = new JLabel("Kelola Admin");
		lblKelolaAdmin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Head.add(lblKelolaAdmin);
		
		
		
		JLayeredPane layeredPane = new JLayeredPane();
		kelolaAdm.add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panelAdd = new JPanel();
		layeredPane.add(panelAdd, "name_1577544916349700");
		
		JLabel lblNama = new JLabel("Nama");
		lblNama.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		txtNama = new JTextField();
		txtNama.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		
		JLabel lblHakAkses = new JLabel("Hak Akses");
		lblHakAkses.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		
		JComboBox hak = new JComboBox();

		hak.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		hak.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "1. SuperAdmin", "2. Admin "}));
		
		GroupLayout gl_panelAdd = new GroupLayout(panelAdd);
		gl_panelAdd.setHorizontalGroup(
			gl_panelAdd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAdd.createSequentialGroup()
					.addGap(93)
					.addGroup(gl_panelAdd.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAdd.createSequentialGroup()
							.addGroup(gl_panelAdd.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelAdd.createSequentialGroup()
									.addComponent(lblHakAkses, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
									.addGap(107))
								.addComponent(hak, 0, 193, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addComponent(txtNama, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
						.addGroup(gl_panelAdd.createSequentialGroup()
							.addComponent(lblNama, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
							.addGap(145)))
					.addGroup(gl_panelAdd.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelAdd.createSequentialGroup()
							.addGap(94)
							.addGroup(gl_panelAdd.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelAdd.createSequentialGroup()
									.addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
									.addGap(112))
								.addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)))
						.addGroup(gl_panelAdd.createSequentialGroup()
							.addGap(94)
							.addGroup(gl_panelAdd.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPassword, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtPass, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))))
					.addGap(97))
		);
		gl_panelAdd.setVerticalGroup(
			gl_panelAdd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAdd.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_panelAdd.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAdd.createSequentialGroup()
							.addGap(23)
							.addComponent(txtNama, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNama, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelAdd.createSequentialGroup()
							.addGap(23)
							.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(35)
					.addGroup(gl_panelAdd.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAdd.createSequentialGroup()
							.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelAdd.createSequentialGroup()
							.addComponent(lblHakAkses, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(hak, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(46, Short.MAX_VALUE))
		);
		panelAdd.setLayout(gl_panelAdd);
		
		JPanel Footer = new JPanel();
		Footer.setBackground(new Color(127, 255, 212));
		kelolaAdm.add(Footer, BorderLayout.SOUTH);
		
		JButton btnHapusSemua = new JButton("Clear");
		btnHapusSemua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hapusKolom();
			}
		});
		btnHapusSemua.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Footer.add(btnHapusSemua);
		
		JButton btnTambah_1 = new JButton("Tambah");
		btnTambah_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into admin (Nama, Username, Password, Akses) values ('"+txtNama.getText()+"', '"+txtUsername.getText()+"', '"+txtPass.getText()+"', '"+hak.getSelectedIndex()+"')";
					PreparedStatement ps=connection.prepareStatement(query);
					ps.execute();
					String sql = "Select * from admin";
					PreparedStatement pst = connection.prepareStatement(sql);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnTambah_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Footer.add(btnTambah_1);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "update admin set Nama='"+txtNama.getText()+"', Username='"+txtUsername.getText()+"',Password='"+txtPass.getText()+"', Akses='"+hak.getSelectedIndex()+"' where Id = '"+baris+"'";
					PreparedStatement ps=connection.prepareStatement(query);
					ps.execute();
					String sql = "Select * from admin";
					PreparedStatement pst = connection.prepareStatement(sql);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnEdit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Footer.add(btnEdit);
		
		JButton btnHapus_1 = new JButton("Hapus");
		btnHapus_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "delete from admin where Username = '"+txtUsername.getText()+"'";
					PreparedStatement ps=connection.prepareStatement(query);
					ps.execute();
					String sql = "Select * from admin";
					PreparedStatement pst = connection.prepareStatement(sql);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnHapus_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Footer.add(btnHapus_1);
		
		
		Edit.setLayout(gl_Edit);
		
		JPanel Listadm = new JPanel();
		add(Listadm, BorderLayout.CENTER);
		Listadm.setLayout(new BorderLayout(0, 0));
		
		JPanel Title = new JPanel();
		Title.setBackground(new Color(127, 255, 212));
		Listadm.add(Title, BorderLayout.NORTH);
		Title.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblLogo = new JLabel("");
		Title.add(lblLogo);
		Image img = new ImageIcon(this.getClass().getResource("/k1.png")).getImage();
		lblLogo.setIcon(new ImageIcon(img));
		
		JPanel TableAdm = new JPanel();
		Listadm.add(TableAdm, BorderLayout.CENTER);
		TableAdm.setLayout(new BoxLayout(TableAdm, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		TableAdm.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int baris1 = table.rowAtPoint(e.getPoint());
				
				int no=(int) table.getValueAt(baris1, 0);
				baris=no;
								
				String nama = table.getValueAt(baris1, 1).toString();
				txtNama.setText(nama);
				
				String user = table.getValueAt(baris1, 2).toString();
				txtUsername.setText(user);
				
				String pass = table.getValueAt(baris1, 3).toString();
				txtPass.setText(pass);
				
				int hakk = (int) table.getValueAt(baris1, 4);
				hak.setSelectedIndex(hakk);
			}
		});
		table.setFillsViewportHeight(true);
		scrollPane.setColumnHeaderView(table);
		
		try {
			String sql = "Select * from admin";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}
	public void hapusKolom() {
		txtNama.setText(null);
		txtPass.setText(null);
		txtUsername.setText(null);
		hak.setSelectedIndex(-1);
	}
}
