import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.sql.*;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditNote extends JFrame {

	private JPanel contentPane;
	private JTextField txtNote;
	Connection connection = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					EditNote frame = new EditNote();
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
	public EditNote() {
		try {
			connection = config.configDB();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 613, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel btn = new JPanel();
		btn.setBackground(new Color(127, 255, 212));
		contentPane.add(btn, BorderLayout.SOUTH);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "update pengumuman set Note='"+txtNote.getText()+"'";
					PreparedStatement ps=connection.prepareStatement(query);
					ps.execute();
					JOptionPane.showMessageDialog(null, "Data Berhasil DI Edit");
				}catch(SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		GroupLayout gl_btn = new GroupLayout(btn);
		gl_btn.setHorizontalGroup(
			gl_btn.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_btn.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(509, Short.MAX_VALUE))
		);
		gl_btn.setVerticalGroup(
			gl_btn.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_btn.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnEdit, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
					.addContainerGap())
		);
		btn.setLayout(gl_btn);
		
		JPanel EditNote = new JPanel();
		contentPane.add(EditNote, BorderLayout.CENTER);
		EditNote.setLayout(new BoxLayout(EditNote, BoxLayout.X_AXIS));
		
		txtNote = new JTextField();
		txtNote.setHorizontalAlignment(SwingConstants.CENTER);
		txtNote.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		EditNote.add(txtNote);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(127, 255, 212));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblLogo = new JLabel("");
		panel.add(lblLogo);
		Image imgl = new ImageIcon(this.getClass().getResource("/k1.png")).getImage();
		lblLogo.setIcon(new ImageIcon(imgl));
		
		try {
			String query = "select Note from pengumuman";
			PreparedStatement ps=connection.prepareStatement(query);
			ResultSet set = ps.executeQuery();
			while(set.next()) {
				txtNote.setText(set.getString("Note"));
			}
		}catch(SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
		}
	}

}