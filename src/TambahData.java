import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.*;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class TambahData extends JFrame {

	private JPanel contentPane;
	Connection connection = null;
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
	private JLabel lblLogo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TambahData frame = new TambahData();
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
	public TambahData() {
		setTitle("TAMBAH DATA");
		try {
			connection = config.configDB();
		} catch (ClassNotFoundException | SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 440, 588);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Tabel = new JPanel();
		Tabel.setBackground(Color.WHITE);
		
		lblLogo = new JLabel("");
		Image imgl = new ImageIcon(this.getClass().getResource("/k1.png")).getImage();
		lblLogo.setIcon(new ImageIcon(imgl));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(Tabel, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
							.addGap(133))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Tabel, GroupLayout.PREFERRED_SIZE, 489, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
		
		
		
		JButton btnTambah = new JButton("Tambah");
		btnTambah.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into stock (Code ,Merek, Type,Supplyer, Tanggal, `Stok Datang`, `Stok Akhir`,keterangan,Modal) values ('"+txtCode.getText()+"','"+txtMerek.getText()+"','"+txtType.getText()+"','"+txtSupply.getText()+"','"+txtMasuk.getText()+"','"+txtAwal.getText()+"','"+txtAkhir.getText()+"','"+txtKet.getText()+"','"+txtModal.getText()+"')";
					PreparedStatement ps=connection.prepareStatement(query);
					ps.execute();
					JOptionPane.showMessageDialog(null, "Data Berhasil Di Simpan...");
				}catch(SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);				}
			}
		});
		btnTambah.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblTambahData = new JLabel("Tambah Data");
		lblTambahData.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GroupLayout gl_Tabel = new GroupLayout(Tabel);
		gl_Tabel.setHorizontalGroup(
			gl_Tabel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_Tabel.createSequentialGroup()
					.addGap(75)
					.addGroup(gl_Tabel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Tabel.createSequentialGroup()
							.addComponent(lblCode, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(59)
							.addComponent(txtCode, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
						.addGroup(gl_Tabel.createSequentialGroup()
							.addGroup(gl_Tabel.createParallelGroup(Alignment.LEADING, false)
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
									.addComponent(btnTambah, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))))
					.addGap(69))
				.addGroup(gl_Tabel.createSequentialGroup()
					.addContainerGap(145, Short.MAX_VALUE)
					.addComponent(lblTambahData)
					.addGap(143))
		);
		gl_Tabel.setVerticalGroup(
			gl_Tabel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Tabel.createSequentialGroup()
					.addGap(19)
					.addComponent(lblTambahData)
					.addGap(29)
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
					.addComponent(btnTambah)
					.addContainerGap(266, Short.MAX_VALUE))
		);
		Tabel.setLayout(gl_Tabel);
		contentPane.setLayout(gl_contentPane);
	}
}
