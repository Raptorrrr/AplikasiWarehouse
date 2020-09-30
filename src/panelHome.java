import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class panelHome extends JPanel {
	Connection con = null;
	/**
	 * Create the panel.
	 */
	public panelHome() {
		try {
			con = config.configDB();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int lgn =Login.lgin1;
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel header = new JPanel();
		header.setBorder(null);
		header.setBackground(new Color(127, 255, 212));
		add(header, BorderLayout.NORTH);
		
		JLabel lblPengumamn = new JLabel("PENGUMUMAN");
		lblPengumamn.setHorizontalAlignment(SwingConstants.CENTER);
		lblPengumamn.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		
		JLabel lblLogo = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/k1.png")).getImage();
		lblLogo.setIcon(new ImageIcon(img));
		
		JLabel label = new JLabel("");
		Image imgr = new ImageIcon(this.getClass().getResource("/r.png")).getImage();
		label.setIcon(new ImageIcon(imgr));
		
		GroupLayout gl_header = new GroupLayout(header);
		gl_header.setHorizontalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addGap(187)
					.addComponent(lblPengumamn, GroupLayout.PREFERRED_SIZE, 218, Short.MAX_VALUE)
					.addGap(270)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
		);
		gl_header.setVerticalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_header.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_header.createParallelGroup(Alignment.LEADING)
							.addComponent(label)
							.addComponent(lblPengumamn)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		header.setLayout(gl_header);
		
		JPanel Main = new JPanel();
		Main.setBackground(Color.WHITE);
		add(Main, BorderLayout.CENTER);
		Main.setLayout(new BoxLayout(Main, BoxLayout.X_AXIS));
		
		JTextArea textPengumuman = new JTextArea();
		try {
			String fetch_row="select * from pengumuman";
			PreparedStatement st=con.prepareStatement(fetch_row);
			ResultSet set = st.executeQuery();
			while(set.next()) {
				textPengumuman.setText(set.getString("Note"));
			}
		}catch(Exception e1) {
			e1.printStackTrace();
		}

		
		
		
		textPengumuman.setEditable(false);
		textPengumuman.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		Main.add(textPengumuman);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(127, 255, 212));
		add(panel, BorderLayout.SOUTH);
		
		JButton btnBuatPengumuman = new JButton("Buat Pengumuman");
		btnBuatPengumuman.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EditNote note = new EditNote();
				note.setVisible(true);
			}
		});
		btnBuatPengumuman.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JButton Refresh = new JButton("Refresh");
		Refresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String fetch_row="select * from pengumuman";
					PreparedStatement st=con.prepareStatement(fetch_row);
					ResultSet set = st.executeQuery();
					while(set.next()) {
						textPengumuman.setText(set.getString("Note"));
					}
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		Refresh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBuatPengumuman, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 590, Short.MAX_VALUE)
					.addComponent(Refresh, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(18, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(Refresh, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuatPengumuman))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		this.setVisible(true);
		
		if(lgn==0) {
			panel.setVisible(false);
		}else {
			panel.setVisible(true);
		}
		

	}
}
