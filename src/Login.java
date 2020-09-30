import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.sql.*;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField Pass;
	Connection connection = null;
	static int lgin1,lgin2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	public Login() throws ClassNotFoundException {
		setTitle("LOGIN");
		lgin2=-1;
//		try {
//			connection=config.configDB();
//		}catch(SQLException e1) {
//			System.out.print(e1);
//		}
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 433);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		username = new JTextField();
		username.setColumns(10);
		
		Pass = new JPasswordField();
		
		JLabel user = new JLabel("Username");
		user.setForeground(Color.WHITE);
		user.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel Password = new JLabel("Password");
		Password.setForeground(Color.WHITE);
		Password.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					connection = config.configDB();
					String sql = "Select * from admin where Username='"+username.getText()+"' and Password = '"+Pass.getText()+"'";
					PreparedStatement ps=connection.prepareStatement(sql);
					ResultSet rs =ps.executeQuery();
					if(rs.next()) {
						lgin2 = rs.getInt("Akses");
						lgin1=1;
						JOptionPane.showMessageDialog(null, "login succesfully");
						Menu mnu = new Menu();
						mnu.setVisible(true);
						dispose();	
						
					}else {
						JOptionPane.showMessageDialog(null, "login fail");
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel imguser = new JLabel("");
		Image imgu = new ImageIcon(this.getClass().getResource("/user6.png")).getImage();
		imguser.setIcon(new ImageIcon(imgu));
		
		
		JLabel imgpass = new JLabel("");
		Image imgp = new ImageIcon(this.getClass().getResource("/password.png")).getImage();
		imgpass.setIcon(new ImageIcon(imgp));
		
		JLabel lblLogo = new JLabel("");
		Image imgl = new ImageIcon(this.getClass().getResource("/k1.png")).getImage();
		lblLogo.setIcon(new ImageIcon(imgl));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(86)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(imguser, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
								.addComponent(imgpass, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(Pass)
								.addComponent(user, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addComponent(username, 255, 255, Short.MAX_VALUE)
								.addComponent(Password, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(222)
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(215)
							.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(160, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(40)
							.addComponent(user, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(23)
							.addComponent(Password, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Pass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(90)
							.addComponent(imguser, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(imgpass, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
					.addGap(17)
					.addComponent(btnLogin)
					.addContainerGap(112, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
