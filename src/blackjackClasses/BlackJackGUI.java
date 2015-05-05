package blackjackClasses;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class BlackJackGUI extends JFrame {

	private JPanel contentPane, panel;
	JLabel lblDealerCard1, lblDealerCard2;
	private JLabel lblTotal, lblDealer;
	private JLabel textTotal;
	private JPanel panel_1;
	private JLabel lblPlayer1;
	private JLabel lbltotalPlayer1, textPlayer1Total;
	private JLabel lblPlayer1card1;
	public JLabel lblPlayer1card2, lblPlayer1card3;
	public Deck deck;
	public static int noofPlayers = 0;
	private JButton btnStayPlayer1, btnHitPlayer1, btnRefresh;
	private JLabel lblResultPlayer1;
	private JLabel lblDealerCard3;
	public static BlackJackGUI frame;
	public static String playerName;
	private JButton btnNext;
	private JLabel lblCredit;
	private JLabel lblAmount;
	private int creditAmount = 100, bet = 10, amountWon;

	public static void main(String args) {
		playerName = args;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					frame = new BlackJackGUI();
					frame.setTitle("BlackJack Game");
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BlackJackGUI() {
		deck = new Deck();
		deck.shuffle();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 644, 692);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setLayout(null);
		setPnlDealer();

		setPnlplayer1();
		setDealerCard();

		setPlayer1Card();
	}

	private void setPnlplayer1() {
		panel_1 = new JPanel();
		panel_1.setBounds(498, 0, 93, 653);
		panel_1.setBackground(new Color(0, 128, 0));
		contentPane.add(panel_1);

		lblPlayer1 = new JLabel(playerName);
		lbltotalPlayer1 = new JLabel("Total");
		lblPlayer1card1 = new JLabel("Player1Card1");
		lblPlayer1card2 = new JLabel("Player1Card2");
		lblPlayer1card3 = new JLabel("Player1Card3");

		textPlayer1Total = new JLabel("0");
		btnHitPlayer1 = new JButton("Hit");
		btnHitPlayer1.addActionListener(new HitButtonActionListener());

		btnStayPlayer1 = new JButton("Stay");
		btnStayPlayer1.addActionListener(new StayButtonActionListener());

		lblResultPlayer1 = new JLabel("ResultPlayer1");

		lblResultPlayer1.setVisible(false);

		lblCredit = new JLabel("Credit");

		lblAmount = new JLabel("Amount");
		creditAmount = creditAmount - bet;
		lblAmount.setText(Integer.toString(creditAmount));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addGap(19)
																		.addComponent(
																				lblPlayer1))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				lbltotalPlayer1)
																		.addGap(18)
																		.addComponent(
																				textPlayer1Total,
																				GroupLayout.PREFERRED_SIZE,
																				21,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																btnHitPlayer1,
																GroupLayout.PREFERRED_SIZE,
																87,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				btnStayPlayer1))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addGap(20)
																		.addComponent(
																				lblResultPlayer1,
																				GroupLayout.PREFERRED_SIZE,
																				57,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				lblPlayer1card3,
																				GroupLayout.PREFERRED_SIZE,
																				145,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				lblCredit)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				lblAmount))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				lblPlayer1card1))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				lblPlayer1card2)))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		gl_panel_1
				.setVerticalGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblPlayer1)
										.addGap(18)
										.addComponent(lblPlayer1card1)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(lblPlayer1card2)
										.addGap(15)
										.addComponent(lblPlayer1card3,
												GroupLayout.PREFERRED_SIZE,
												105, GroupLayout.PREFERRED_SIZE)
										.addGap(65)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lbltotalPlayer1)
														.addComponent(
																textPlayer1Total))
										.addGap(18)
										.addComponent(btnHitPlayer1)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(btnStayPlayer1)
										.addGap(18)
										.addComponent(lblResultPlayer1)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(lblCredit)
														.addComponent(lblAmount))
										.addContainerGap(78, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

	}

	private void setPnlDealer() {
		
		panel = new JPanel();
		panel.setBounds(20, 0, 98, 653);
		panel.setBackground(new Color(0, 128, 0));
		contentPane.add(panel);

		lblDealer = new JLabel("Dealer");

		lblDealerCard1 = new JLabel("Card1");
		lblDealerCard2 = new JLabel("Card2");

		lblTotal = new JLabel("Total");

		textTotal = new JLabel("0");

		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new RefreshButtonActionListener());

		lblDealerCard3 = new JLabel("Card3");

		lblDealerCard2.setVisible(false);
		lblDealerCard3.setVisible(false);
		textTotal.setVisible(false);

		btnNext = new JButton("Next");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(19)
																.addComponent(
																		lblDealer))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		lblDealerCard1))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		lblDealerCard2))
												.addComponent(btnRefresh)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		lblTotal)
																.addGap(8)
																.addComponent(
																		textTotal,
																		GroupLayout.DEFAULT_SIZE,
																		79,
																		Short.MAX_VALUE))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		lblDealerCard3,
																		GroupLayout.PREFERRED_SIZE,
																		110,
																		GroupLayout.PREFERRED_SIZE))
												.addComponent(btnNext))
								.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblDealer)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblDealerCard1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblDealerCard2)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblDealerCard3,
										GroupLayout.PREFERRED_SIZE, 108,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED,
										63, Short.MAX_VALUE)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblTotal)
												.addComponent(textTotal))
								.addGap(18).addComponent(btnRefresh)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnNext).addGap(123)));
		panel.setLayout(gl_panel);
	}

	private int calculateTotal(int i) {
		String str = Card.RANK_SYMBOLS[i];
		if (str.length() <= 2) {
			return Integer.parseInt(str);
		} else if (str.equals("ace")) {
			return 11;
		} else
			return 10;

	}
public void calculateResult() {
		

		lblDealerCard2.setVisible(true);
		lblDealerCard3.setVisible(true);
		textTotal.setVisible(true);
		int sum = Integer.parseInt(textPlayer1Total.getText());
		lblResultPlayer1.setVisible(true);
		if (sum == 21) {
			amountWon = bet * 2;
			creditAmount = creditAmount + amountWon;
			lblAmount.setText(Integer.toString(creditAmount));
			lblResultPlayer1.setText("You Win");
			btnHitPlayer1.setEnabled(false);
			btnStayPlayer1.setEnabled(false);
		} else if (sum <= 21 && Integer.parseInt(textTotal.getText()) < 21
				&& Integer.parseInt(textTotal.getText()) > sum) {
			creditAmount = creditAmount - bet;
			lblAmount.setText(Integer.toString(creditAmount));
			lblResultPlayer1.setText("You Lose");
			btnHitPlayer1.setEnabled(false);
			btnStayPlayer1.setEnabled(false);
		} else if (sum <= 21 && Integer.parseInt(textTotal.getText()) < 21
				&& Integer.parseInt(textTotal.getText()) < sum) {
			amountWon = bet * 2;
			creditAmount = creditAmount + amountWon;
			lblAmount.setText(Integer.toString(creditAmount));
			lblResultPlayer1.setText("You Win");
			btnHitPlayer1.setEnabled(false);
			btnStayPlayer1.setEnabled(false);
		} else if (sum <= 21 && Integer.parseInt(textTotal.getText()) > 21) {
			amountWon = bet * 2;
			creditAmount = creditAmount + amountWon;
			lblAmount.setText(Integer.toString(creditAmount));
			lblResultPlayer1.setText("You Win");
			btnHitPlayer1.setEnabled(false);
			btnStayPlayer1.setEnabled(false);
		} else if (sum <= 21 && Integer.parseInt(textTotal.getText()) == sum) {
			amountWon = bet * 2;
			creditAmount += amountWon;
			lblAmount.setText(Integer.toString(creditAmount));
			lblResultPlayer1.setText("You Win");
			btnHitPlayer1.setEnabled(false);
			btnStayPlayer1.setEnabled(false);
		} else if (sum <= 21 && Integer.parseInt(textTotal.getText()) == 21) {
			creditAmount = creditAmount - bet;
			lblAmount.setText(Integer.toString(creditAmount));
			lblResultPlayer1.setText("You Lose");
			btnHitPlayer1.setEnabled(false);
			btnStayPlayer1.setEnabled(false);
		} else if (sum > 21) {
			creditAmount = creditAmount - bet;
			lblAmount.setText(Integer.toString(creditAmount));
			lblResultPlayer1.setText("You Lose");
			btnHitPlayer1.setEnabled(false);
			btnStayPlayer1.setEnabled(false);
		}

	}

	private void setDealerCard() {

		int sum = 0;
		int i = randInt();
		lblDealerCard1.setIcon(deck.cards[i].slotImage.get(0));
		sum += calculateTotal(deck.cards[i].getRank());

		i = randInt();
		lblDealerCard2.setIcon(deck.cards[i].slotImage.get(0));
		sum += calculateTotal(deck.cards[i].getRank());

		textTotal.setText(sum + "");
	}

	private void setPlayer1Card() {

		int sum = 0;
		int i = randInt();
		lblPlayer1card1.setIcon(deck.cards[i].slotImage.get(0));
		sum += calculateTotal(deck.cards[i].getRank());

		i = randInt();
		lblPlayer1card2.setIcon(deck.cards[i].slotImage.get(0));
		sum += calculateTotal(deck.cards[i].getRank());

		textPlayer1Total.setText(sum + "");
	}

	public ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	class StayButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			onHit();
		}
	}

	class HitButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			onHit();
			int i = randInt();
			lblPlayer1card3.setIcon(deck.cards[i].slotImage.get(0));
			int sum = Integer.parseInt(textPlayer1Total.getText());
			sum += calculateTotal(deck.cards[i].getRank());
			textPlayer1Total.setText(sum + "");
			calculateResult();

		}
	}

	class RefreshButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			frame.setVisible(false);
			BlackJackGUI.main(playerName);

		}
	}

	public int randInt() {
		int min = 0, max = 51;
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	public void onHit() {
		
		int i = randInt();
		lblDealerCard3.setIcon(deck.cards[i].slotImage.get(0));
		int sum = Integer.parseInt(textTotal.getText());
		sum += calculateTotal(deck.cards[i].getRank());
		textTotal.setText(sum + "");
		calculateResult();
	}

	

}
