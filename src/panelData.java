import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.BorderLayout;

public class panelData extends JPanel {
	JButton btnEdit = new JButton("Edit");
	JButton btnTambah = new JButton("Tambah");
	Connection connection = null;
	private JTable table;
	private JTextField search;
	/**
	 * Create the panel.
	 */
	public panelData() {
		try {
			connection = config.configDB();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			System.out.print(e1);
		}
		
		int lgn =Login.lgin1;
		this.setVisible(true);
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		JPanel header = new JPanel();
		header.setBackground(new Color(127, 255, 212));
		add(header, BorderLayout.NORTH);
		
		search = new JTextField();
		search.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String query ="select * from stock where No like '%"+search.getText()+"%' or Tanggal like '%"+search.getText()+"%' or Merek like '%"+search.getText()+"%' or Type like '%"+search.getText()+"%' or Supplyer like '%"+search.getText()+"%' or Code like '%"+search.getText()+"%' order by Merek";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblLogo = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/k1.png")).getImage();
		lblLogo.setIcon(new ImageIcon(img));
		
		GroupLayout gl_header = new GroupLayout(header);
		gl_header.setHorizontalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(search, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(19))
		);
		gl_header.setVerticalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_header.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_header.createParallelGroup(Alignment.BASELINE)
							.addComponent(search, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnSearch)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		header.setLayout(gl_header);
		
		JPanel Table = new JPanel();
		Table.setBorder(null);
		Table.setBackground(new Color(255, 255, 255));
		add(Table, BorderLayout.CENTER);
		Table.setLayout(new BoxLayout(Table, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		Table.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		JPanel footer = new JPanel();
		footer.setBackground(new Color(127, 255, 212));
		add(footer, BorderLayout.SOUTH);
		if(lgn==0) {
			btnEdit.setVisible(false);
			btnTambah.setVisible(false);
		}else {
			footer.setVisible(true);
		}
		
		
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EditForm ed = new EditForm();
				ed.setVisible(true);
			}
		});
		btnEdit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		
		btnTambah.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TambahData tmbh = new TambahData();
				tmbh.setVisible(true);
			}
		});
		btnTambah.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JButton Refresh = new JButton("Refresh");
		Refresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String query ="select * from stock order by Merek";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		Refresh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GroupLayout gl_footer = new GroupLayout(footer);
		gl_footer.setHorizontalGroup(
			gl_footer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_footer.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnTambah, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 472, Short.MAX_VALUE)
					.addComponent(Refresh)
					.addContainerGap())
		);
		gl_footer.setVerticalGroup(
			gl_footer.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_footer.createSequentialGroup()
					.addContainerGap(19, Short.MAX_VALUE)
					.addGroup(gl_footer.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEdit)
						.addComponent(btnTambah, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(Refresh))
					.addContainerGap())
		);
		footer.setLayout(gl_footer);

	}
}
