import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.sql.*;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;

import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class EditForm extends JFrame {

	private JPanel contentPane;
	Connection connection = null;
	private JTextField txtSearch;
	private JPanel Tabel;
	private JLabel lblCode;
	private JLabel lblType;
	private JLabel lblMerek;
	private JLabel lblSupplyer;
	private JLabel lblMasuk;
	private JLabel lblStokAwal;
	private JLabel lblStokAkhir;
	private JLabel lblKeterangan;
	private JLabel lblModal;
	private JTextField txtAkhir;
	private JTextField txtAwal;
	private JTextField txtMasuk;
	private JTextField txtKet;
	private JTextField txtModal;
	private JTextField txtSupply;
	private JTextField txtMerek;
	private JTextField txtType;
	private JTextField txtCode;
	private JTable table;
	private JLabel lblEditData;
	private JLabel lblLogo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					EditForm frame = new EditForm();
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
	public EditForm() {
		setTitle("EDIT\r\n");
		try {
			connection = config.configDB();
		} catch (ClassNotFoundException | SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 440, 724);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel header = new JPanel();
		header.setBackground(new Color(0, 128, 128));
		header.setBorder(null);
		
		txtSearch = new JTextField();
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("search");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String query ="select Code,Merek from stock where Code = '"+txtSearch.getText()+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		lblLogo = new JLabel("");
		Image imgl = new ImageIcon(this.getClass().getResource("/k1.png")).getImage();
		lblLogo.setIcon(new ImageIcon(imgl));
		
		GroupLayout gl_header = new GroupLayout(header);
		gl_header.setHorizontalGroup(
			gl_header.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_header.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
					.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(21))
		);
		gl_header.setVerticalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_header.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_header.createSequentialGroup()
							.addGroup(gl_header.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSearch))
							.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)))
					.addContainerGap())
		);
		header.setLayout(gl_header);
		
		Tabel = new JPanel();
		Tabel.setBackground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(header, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(Tabel, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
					.addGap(10))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(header, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Tabel, GroupLayout.PREFERRED_SIZE, 608, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(141, Short.MAX_VALUE))
		);
		
		lblCode = new JLabel("Code");
		lblCode.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		lblType = new JLabel("Type");
		lblType.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		lblMerek = new JLabel("Merek");
		lblMerek.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		lblSupplyer = new JLabel("Supplyer");
		lblSupplyer.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		lblMasuk = new JLabel("Masuk");
		lblMasuk.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		lblStokAwal = new JLabel("Stok Awal");
		lblStokAwal.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		lblStokAkhir = new JLabel("Stok Akhir");
		lblStokAkhir.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		lblKeterangan = new JLabel("Keterangan");
		lblKeterangan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		lblModal = new JLabel("Modal");
		lblModal.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		txtAkhir = new JTextField();
		txtAkhir.setColumns(10);
		
		txtAwal = new JTextField();
		txtAwal.setColumns(10);
		
		txtMasuk = new JTextField();
		txtMasuk.setColumns(10);
		
		txtKet = new JTextField();
		txtKet.setColumns(10);
		
		txtModal = new JTextField();
		txtModal.setColumns(10);
		
		txtSupply = new JTextField();
		txtSupply.setColumns(10);
		
		txtMerek = new JTextField();
		txtMerek.setColumns(10);
		
		txtType = new JTextField();
		txtType.setColumns(10);
		
		txtCode = new JTextField();
		txtCode.setColumns(10);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "update stock set Code='"+txtCode.getText()+"', Merek='"+txtMerek.getText()+"',Type='"+txtType.getText()+"', `Stok Datang` ='"+txtAwal.getText()+"', Supplyer ='"+txtSupply.getText()+"', Tanggal = '"+txtMasuk.getText()+"', `Stok Akhir` = '"+txtAkhir.getText()+"', keterangan = '"+txtKet.getText()+"', Modal = '"+txtModal.getText()+"'  where Code = '"+txtSearch.getText()+"'";
					PreparedStatement ps=connection.prepareStatement(query);
					ps.execute();
					JOptionPane.showMessageDialog(null, "Data Berhasil DI Edit");
				}catch(SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnEdit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JButton btnHapus = new JButton("Hapus");
		btnHapus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "delete from stock where Code = '"+txtCode.getText()+"'";
					PreparedStatement ps=connection.prepareStatement(query);
					ps.execute();
					JOptionPane.showMessageDialog(null, "Data Telah Di Hapus...");
				}catch(SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnHapus.setBackground(SystemColor.desktop);
		btnHapus.setForeground(Color.WHITE);
		btnHapus.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		lblEditData = new JLabel("EDIT DATA");
		lblEditData.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GroupLayout gl_Tabel = new GroupLayout(Tabel);
		gl_Tabel.setHorizontalGroup(
			gl_Tabel.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
				.addGroup(gl_Tabel.createSequentialGroup()
					.addContainerGap(162, Short.MAX_VALUE)
					.addComponent(lblEditData)
					.addGap(152))
				.addGroup(gl_Tabel.createSequentialGroup()
					.addGap(80)
					.addGroup(gl_Tabel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Tabel.createSequentialGroup()
							.addGroup(gl_Tabel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnHapus, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblStokAwal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblSupplyer)
								.addGroup(gl_Tabel.createSequentialGroup()
									.addComponent(lblStokAkhir, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addGap(18))
								.addComponent(lblMasuk, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblModal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblKeterangan)
								.addComponent(lblMerek, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_Tabel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_Tabel.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_Tabel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtMerek, 148, 148, Short.MAX_VALUE)
										.addComponent(txtSupply, 148, 148, Short.MAX_VALUE)
										.addComponent(txtMasuk, 148, 148, Short.MAX_VALUE)
										.addComponent(txtAwal, 148, 148, Short.MAX_VALUE)
										.addComponent(txtAkhir, 148, 148, Short.MAX_VALUE)
										.addComponent(txtKet, 148, 148, Short.MAX_VALUE)
										.addComponent(txtModal, 148, 148, Short.MAX_VALUE)
										.addComponent(txtType, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)))
								.addGroup(gl_Tabel.createSequentialGroup()
									.addGap(73)
									.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_Tabel.createSequentialGroup()
							.addComponent(lblCode, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(59)
							.addComponent(txtCode, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)))
					.addGap(64))
		);
		gl_Tabel.setVerticalGroup(
			gl_Tabel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Tabel.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblEditData)
					.addGap(18)
					.addGroup(gl_Tabel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCode)
						.addComponent(txtCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_Tabel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblType)
						.addComponent(txtType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_Tabel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMerek)
						.addComponent(txtMerek, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_Tabel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSupplyer)
						.addComponent(txtSupply, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_Tabel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMasuk)
						.addComponent(txtMasuk, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_Tabel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStokAwal)
						.addComponent(txtAwal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_Tabel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStokAkhir)
						.addComponent(txtAkhir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_Tabel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKeterangan)
						.addComponent(txtKet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_Tabel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblModal)
						.addComponent(txtModal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_Tabel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnHapus)
						.addComponent(btnEdit))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int baris1 = table.rowAtPoint(e.getPoint());
				String kode = table.getValueAt(baris1, 0).toString();
				try {
					String fetch_row="select * from stock where Code = '"+kode+"'";
					PreparedStatement st=connection.prepareStatement(fetch_row);
					ResultSet set = st.executeQuery();
					while(set.next()) {
						txtCode.setText(set.getString("Code"));
						txtMerek.setText(set.getString("Merek"));
						txtType.setText(set.getString("Type"));
						txtMasuk.setText(set.getString("Tanggal"));
						txtSupply.setText(set.getString("Supplyer"));
						txtAwal.setText(set.getString("Stok Datang"));
						txtAkhir.setText(set.getString("Stok Akhir"));
						txtKet.setText(set.getString("Keterangan"));
						txtModal.setText(set.getString("Modal"));
					}
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		table.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		Tabel.setLayout(gl_Tabel);
		contentPane.setLayout(gl_contentPane);
	}
}
