import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.LayoutStyle.ComponentPlacement;

import pokerClasses.pokerGUI;
import blackjackClasses.BlackJackGUI;


public class Menu extends JFrame{

	private JPanel contentPane;
	
	public static void main(String args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu(args);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Menu(String name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setBackground(Color.GRAY);
		
		JLabel lblWelcomeToCasino = new JLabel("Welcome to Casino Game!!");
		lblWelcomeToCasino.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToCasino.setFont(new Font("Verdana", Font.BOLD, 14));
		
		JButton btnPoker = new JButton("Poker");
		btnPoker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pokerGUI.main(name);
			}
		});
		
		JButton btnNewButton = new JButton("BlackJack");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BlackJackGUI.main(name);
			}
		});
		
		JButton btnSlots = new JButton("Slots");
		btnSlots.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GameOfSlots(name);
			}
		});
		
		JLabel lblPlayerName = new JLabel("Player name:");
		
		JLabel lblNewLabel = new JLabel(name);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(165)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSlots, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnPoker, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)))
					.addContainerGap(158, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(115, Short.MAX_VALUE)
					.addComponent(lblWelcomeToCasino)
					.addGap(111))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(lblPlayerName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(250, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblWelcomeToCasino)
					.addGap(18)
					.addComponent(btnPoker, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(btnSlots, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPlayerName)
						.addComponent(lblNewLabel))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
	}
	

}
