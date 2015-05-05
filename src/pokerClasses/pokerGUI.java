package pokerClasses;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import blackjackClasses.Deck;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class pokerGUI extends JFrame {

	private JPanel contentPane;
	private static final int BIG_BLIND = 10;
	private static final int SMALL_BLIND = 10;
	private int moneyOwnedPlayer1, moneyOwnedPlayer2;
	private int betRaise = 10;
	private int potMoney = 0;
	private enum Actions {
		Check, Raise, Fold
	};

	private static final List<Actions> VALUES = Collections
			.unmodifiableList(Arrays.asList(Actions.values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
	private static final int STARTING_CASH = 100;
	private static int count = 0;
	private static boolean turn = true;
	public Deck deck;
	public static String playerName;
	private HashSet<Icon> iconSet = new HashSet<Icon>();
	JLabel lblCard1, lblCard2, lblCard3, lblCard4, lblTableCard1,
			lblTableCard2, lblTableCard3, lblTableCard4, lblTableCard5,
			lblNewLabel, lblMoney, lblPlayer1money, lblTable, lblPot,
			lblPotmoney, lblPlayer2money, lblGameStatus;
	JButton btnCheck, btnRaise, btnFold, btnContinue;
	private JLabel lblPlayer1Selection;
	
	public static void main(String args) {
		playerName = args;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pokerGUI frame = new pokerGUI();
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
	public pokerGUI() {
		deck = new Deck();
		deck.shuffle();
		setTitle("Poker Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 498);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 51));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(10, 253, 184, 189);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel(playerName);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(64, 11, 46, 14);
		panel.add(lblNewLabel);

		lblCard1 = new JLabel("card1");
		lblCard1.setIcon(new ImageIcon(pokerGUI.class
				.getResource("/pokerClasses/images_poker/card_back.png")));
		lblCard1.setBounds(10, 70, 76, 105);
		panel.add(lblCard1);

		lblCard2 = new JLabel("card2");
		lblCard2.setIcon(new ImageIcon(pokerGUI.class
				.getResource("/pokerClasses/images_poker/card_back.png")));
		lblCard2.setBounds(92, 68, 82, 108);
		panel.add(lblCard2);

		lblMoney = new JLabel("Money");
		lblMoney.setBounds(10, 36, 46, 14);
		panel.add(lblMoney);

		lblPlayer1money = new JLabel("New label");
		lblPlayer1money.setBounds(82, 36, 46, 14);
		panel.add(lblPlayer1money);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 0, 0));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(10, 41, 626, 201);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		lblTable = new JLabel("Table");
		lblTable.setHorizontalAlignment(SwingConstants.CENTER);
		lblTable.setBounds(260, 11, 46, 14);
		panel_1.add(lblTable);

		lblTableCard1 = new JLabel("card1");
		lblTableCard1.setIcon(new ImageIcon(pokerGUI.class
				.getResource("/pokerClasses/images_poker/card_back.png")));
		lblTableCard1.setBounds(10, 40, 70, 99);
		panel_1.add(lblTableCard1);

		lblTableCard2 = new JLabel("card 2");
		lblTableCard2.setIcon(new ImageIcon(pokerGUI.class
				.getResource("/pokerClasses/images_poker/card_back.png")));
		lblTableCard2.setBounds(79, 40, 70, 99);
		panel_1.add(lblTableCard2);

		lblTableCard4 = new JLabel("card3");
		lblTableCard4.setIcon(new ImageIcon(pokerGUI.class
				.getResource("/pokerClasses/images_poker/card_back.png")));
		lblTableCard4.setBounds(217, 40, 70, 99);
		panel_1.add(lblTableCard4);

		lblTableCard3 = new JLabel("card4");
		lblTableCard3.setIcon(new ImageIcon(pokerGUI.class
				.getResource("/pokerClasses/images_poker/card_back.png")));
		lblTableCard3.setBounds(148, 40, 70, 99);
		panel_1.add(lblTableCard3);

		lblTableCard5 = new JLabel("card5");
		lblTableCard5.setIcon(new ImageIcon(pokerGUI.class
				.getResource("/pokerClasses/images_poker/card_back.png")));
		lblTableCard5.setBounds(286, 40, 70, 99);
		panel_1.add(lblTableCard5);

		btnCheck = new JButton("check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (count < 3) {
					lblPlayer1Selection.setText("<html>" + "You Checked!!! Opening next card !"
							+ "</html>");
					setTableCards();
					turn = false;
					play();
				}

			}
		});
		btnCheck.setEnabled(false);
		btnCheck.setBounds(387, 11, 97, 23);
		panel_1.add(btnCheck);

		btnRaise = new JButton("raise");
		btnRaise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count<3){
					lblPlayer1Selection.setText("<html>" + "You raised by $20!!! Opening next card !"
							+ "</html>");
					moneyOwnedPlayer1 -= 20;
					potMoney = potMoney+20;
					lblPotmoney.setText(Integer.toString(potMoney));
					lblPlayer1money.setText(Integer.toString(moneyOwnedPlayer1));
					setTableCards();
					turn = false;
					play();
				}
			}
		});
		btnRaise.setEnabled(false);
		btnRaise.setBounds(494, 11, 72, 23);
		panel_1.add(btnRaise);

		btnFold = new JButton("fold");
		btnFold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPlayer1Selection.setText("<html>" + "You Fold!!! Player 2 Wins !"
						+ "</html>");
				moneyOwnedPlayer2 += potMoney;
				potMoney= 0;
				lblPlayer2money.setText(Integer.toString(moneyOwnedPlayer2));
				lblPotmoney.setText(Integer.toString(potMoney));
				
			}
		});
		btnFold.setEnabled(false);
		btnFold.setBounds(387, 40, 97, 23);
		panel_1.add(btnFold);

		btnContinue = new JButton("continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPlayer1Selection.setText("<html>"
						+ "Player 1 pressed continue!"
						+ "</html>");
				setTableCards();
				// count++;
				turn = false;
				play();

			}
		});
		btnContinue.setBounds(387, 167, 97, 23);
		panel_1.add(btnContinue);

		lblPot = new JLabel("Pot");
		lblPot.setBounds(20, 150, 46, 14);
		panel_1.add(lblPot);

		lblPotmoney = new JLabel("New label");
		lblPotmoney.setText(Integer.toString(potMoney));
		lblPotmoney.setBounds(10, 171, 46, 14);
		panel_1.add(lblPotmoney);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 102, 51));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBounds(452, 253, 184, 189);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblPlayer = new JLabel("Player 2");
		lblPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer.setBounds(62, 11, 46, 14);
		panel_2.add(lblPlayer);

		lblCard4 = new JLabel("card2");
		lblCard4.setIcon(new ImageIcon(pokerGUI.class
				.getResource("/pokerClasses/images_poker/card_back.png")));
		lblCard4.setBounds(96, 61, 78, 109);
		panel_2.add(lblCard4);

		lblCard3 = new JLabel("card2");
		lblCard3.setIcon(new ImageIcon(pokerGUI.class
				.getResource("/pokerClasses/images_poker/card_back.png")));
		lblCard3.setBounds(10, 61, 76, 110);
		panel_2.add(lblCard3);

		JLabel lblMoney_1 = new JLabel("Money");
		lblMoney_1.setBounds(10, 36, 46, 14);
		panel_2.add(lblMoney_1);

		lblPlayer2money = new JLabel("New label");
		lblPlayer2money.setBounds(88, 36, 46, 14);
		panel_2.add(lblPlayer2money);

		JLabel lblDummyCard1 = new JLabel("New label");
		lblDummyCard1.setIcon(new ImageIcon(pokerGUI.class
				.getResource("/pokerClasses/images_poker/card_back.png")));
		lblDummyCard1.setBounds(10, 61, 76, 109);
		panel_2.add(lblDummyCard1);

		JLabel lblDummyCard2 = new JLabel("New label");
		lblDummyCard2.setIcon(new ImageIcon(pokerGUI.class
				.getResource("/pokerClasses/images_poker/card_back.png")));
		lblDummyCard2.setBounds(96, 61, 78, 109);
		panel_2.add(lblDummyCard2);

		lblGameStatus = new JLabel("New label");
		lblGameStatus.setVerticalAlignment(SwingConstants.TOP);
		lblGameStatus.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGameStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameStatus.setBounds(204, 359, 238, 83);
		contentPane.add(lblGameStatus);

		setPlayer1card();
		setPlayer2Card();
		lblGameStatus.setText("<html><b>"
				+ "Your Turn, please press continue to open three cards"
				+ "</b></html>");
		
		lblPlayer1Selection = new JLabel("");
		lblPlayer1Selection.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer1Selection.setVerticalAlignment(SwingConstants.TOP);
		lblPlayer1Selection.setBounds(204, 253, 238, 77);
		contentPane.add(lblPlayer1Selection);
		

		/*
		 * players = new LinkedHashMap<String, Player>(); humanPlayer = new
		 * Player("mini", STARTING_CASH, this); players.put("Player",
		 * humanPlayer); players.put("Joe", new Player("Joe", STARTING_CASH, new
		 * BasicBot(0, 75)));
		 */
	}

	private void setPlayer1card() {
		int i;
		i= randInt();
		while(!(iconSet.add(deck.cards[i].slotImage.get(0))))
		{
			i = randInt();
			
		}
		lblCard1.setIcon(deck.cards[i].slotImage.get(0));
		

		i = randInt();
		while(!(iconSet.add(deck.cards[i].slotImage.get(0))))
		{
			i = randInt();
			
		}
		lblCard2.setIcon(deck.cards[i].slotImage.get(0));
		lblPlayer1money.setText(Integer.toString(STARTING_CASH));

	}

	private void setPlayer2Card() {
		int i = randInt();
		while(!(iconSet.add(deck.cards[i].slotImage.get(0))))
		{
			i = randInt();
			
		}
		lblCard3.setIcon(deck.cards[i].slotImage.get(0));
		lblCard3.setVisible(false);

		i = randInt();
		while(!(iconSet.add(deck.cards[i].slotImage.get(0))))
		{
			i = randInt();
			
		}
		lblCard4.setIcon(deck.cards[i].slotImage.get(0));
		lblCard4.setVisible(false);
		lblPlayer2money.setText(Integer.toString(STARTING_CASH));
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

	private void setTableCards() {
		int i;
		if (count == 0) {
			i = randInt();
			while(!(iconSet.add(deck.cards[i].slotImage.get(0))))
			{
				i = randInt();
				
			}
			lblTableCard1.setIcon(deck.cards[i].slotImage.get(0));
			i = randInt();
			while(!(iconSet.add(deck.cards[i].slotImage.get(0))))
			{
				i = randInt();
				
			}
			lblTableCard2.setIcon(deck.cards[i].slotImage.get(0));
			i = randInt();
			while(!(iconSet.add(deck.cards[i].slotImage.get(0))))
			{
				i = randInt();
				
			}
			lblTableCard3.setIcon(deck.cards[i].slotImage.get(0));
			moneyOwnedPlayer1 = STARTING_CASH - SMALL_BLIND;
			moneyOwnedPlayer2 = STARTING_CASH - BIG_BLIND;
			potMoney = SMALL_BLIND+BIG_BLIND;
			lblPlayer1money.setText(Integer.toString(moneyOwnedPlayer1));
			lblPlayer2money.setText(Integer.toString(moneyOwnedPlayer2));
			lblPotmoney.setText(Integer.toString(potMoney));
		} else if (count == 1) {
			i = randInt();
			while(!(iconSet.add(deck.cards[i].slotImage.get(0))))
			{
				i = randInt();
				
			}
			lblTableCard4.setIcon(deck.cards[i].slotImage.get(0));
		} else if (count == 2) {
			i = randInt();
			while(!(iconSet.add(deck.cards[i].slotImage.get(0))))
			{
				i = randInt();
				
			}
			lblTableCard5.setIcon(deck.cards[i].slotImage.get(0));
		}
		count++;

	}

	public void play() {
		// true for me and 1 for computer player
		if (turn) {
			btnCheck.setEnabled(true);
			btnRaise.setEnabled(true);
			btnFold.setEnabled(true);
		} else {
			btnCheck.setEnabled(false);
			btnRaise.setEnabled(false);
			btnFold.setEnabled(false);
			btnContinue.setEnabled(false);

			switch (randomAction()) {
			case Check:
				lblGameStatus.setText("<html>"
						+ "Player 2 checks!!! Your Turn now !" + "</html>");
				turn = true;
				play();
				break;

			case Raise:
				lblGameStatus.setText("<html>"
						+ "Player 2 Raises by $20!!! Your Turn now !"
						+ "</html>");
				moneyOwnedPlayer2 -= 20;
				potMoney = potMoney+20;
				lblPotmoney.setText(Integer.toString(potMoney));
				lblPlayer2money.setText(Integer.toString(moneyOwnedPlayer2));
				turn = true;
				play();
				break;
			case Fold:
				lblGameStatus.setText("<html>" + "Player 2 Folds!!! You Win !"
						+ "</html>");
				moneyOwnedPlayer1 += potMoney;
				potMoney= 0;
				lblPlayer1money.setText(Integer.toString(moneyOwnedPlayer1));
				lblPotmoney.setText(Integer.toString(potMoney));
				break;
			}
		}
	}

	public int randInt() {
		int min = 0, max = 51;
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	public static Actions randomAction() {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
}
