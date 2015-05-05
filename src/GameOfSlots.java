
import java.awt.*;

import javax.swing.*;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.util.Random;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOfSlots {

	private JPanel slot1, slot2, slot3, slotsPanel;
	private JButton cashButton, spinButton;
	private JFrame frame;
	private JLabel creditsLabel, gamesLostLabel, allMatchLabel, twoMatchLabel,
			moneyLabel, slotLabel1, slotLabel2, slotLabel3, lblStatus, lblWon,
			lblPlayerName, lblName;

	private JSeparator sepStats, sepStats2, seperatorForStatus,
			seperatorBetweenSlots1, seperatorBetweenSlots2;
	private int credits = 100, boughtCredits = 100, bet = 15,
			numOfThreeMatches, numOfTwoMatches, numOfWins, numOfLosses;
	private double amount = 25.0, feeForCredits = 10.0, moneyOwned;
	private int firstSlot = 0, secondSlot = 1, thirdSlot = 2;
	private ArrayList<ImageIcon> listOfCards = new ArrayList<ImageIcon>();

	public GameOfSlots(String playerName) {
		initSlotGUI(playerName);

	}

	private void initSlotGUI(String playerName) {

		frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setTitle("Game of Slots");
		frame.setVisible(true);

		slotsPanel = new JPanel();
		slot1 = new JPanel();
		slot1.setBackground(new Color(0, 0, 0));
		slot2 = new JPanel();
		slot2.setBackground(new Color(0, 0, 0));
		slot3 = new JPanel();
		slot3.setBackground(new Color(0, 0, 0));

		initImageList();

		slotLabel1 = new JLabel();
		slotLabel2 = new JLabel();
		slotLabel3 = new JLabel();

		lblPlayerName = new JLabel("Player Name: ");

		lblName = new JLabel(playerName);

		sepStats = new JSeparator();
		twoMatchLabel = new JLabel();
		twoMatchLabel.setText("Two of a kind: ");
		allMatchLabel = new JLabel();
		allMatchLabel.setText("Perfect Match: ");
		lblWon = new JLabel();
		lblWon.setText("Games Won: ");

		sepStats2 = new JSeparator();
		sepStats2.setOrientation(SwingConstants.VERTICAL);
		creditsLabel = new JLabel();
		creditsLabel.setText("Credits Left: " + credits);
		moneyLabel = new JLabel();
		moneyLabel.setText("Money: $" + moneyOwned);
		gamesLostLabel = new JLabel();
		gamesLostLabel.setText("Games Lost: ");

		seperatorForStatus = new JSeparator();
		lblStatus = new JLabel();
		seperatorBetweenSlots1 = new JSeparator();
		seperatorBetweenSlots1.setOrientation(SwingConstants.VERTICAL);
		seperatorBetweenSlots2 = new JSeparator();
		seperatorBetweenSlots2.setOrientation(SwingConstants.VERTICAL);

		slotLabel1.setIcon(listOfCards.get(firstSlot));
		slotLabel2.setIcon(listOfCards.get(secondSlot));
		slotLabel3.setIcon(listOfCards.get(thirdSlot));

		spinButton = new JButton();
		spinButton.setBackground(Color.BLUE);
		spinButton.setText("Spin");
		spinButton.setToolTipText("Click to spin the reels!");
		spinButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		spinButton.setInheritsPopupMenu(true);
		spinButton.setMaximumSize(new Dimension(200, 50));
		spinButton.setMinimumSize(new Dimension(200, 50));
		spinButton.addActionListener(new SpinButtonListener());

		cashButton = new JButton();
		cashButton.setBackground(Color.GREEN);
		cashButton.setText("Buy Credits");
		cashButton.setToolTipText("$" + bet + " converts to " + boughtCredits
				+ " credits.");
		cashButton.setHorizontalTextPosition(SwingConstants.CENTER);
		cashButton.addActionListener(new CashButtonListener());

		createLayouts();

	}

	private void createLayouts() {

		GroupLayout frameLayout = new GroupLayout(frame.getContentPane());
		frame.getContentPane().setLayout(frameLayout);

		frameLayout.setHorizontalGroup(frameLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGap(0, 300, Short.MAX_VALUE));
		frameLayout.setVerticalGroup(frameLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGap(0, 300, Short.MAX_VALUE));

		GroupLayout pnlReelsLayout = new GroupLayout(slotsPanel);
		slotsPanel.setLayout(pnlReelsLayout);
		pnlReelsLayout.setHorizontalGroup(pnlReelsLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				pnlReelsLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(slot1, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(seperatorBetweenSlots1)
						.addGap(18, 18, 18)
						.addComponent(slot2, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(seperatorBetweenSlots2)
						.addGap(18, 18, 18)
						.addComponent(slot3, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		pnlReelsLayout.setVerticalGroup(pnlReelsLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				pnlReelsLayout
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								pnlReelsLayout
										.createParallelGroup(
												GroupLayout.Alignment.TRAILING,
												false)
										.addComponent(slot1,
												GroupLayout.Alignment.LEADING,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(seperatorBetweenSlots1)
										.addComponent(slot2,
												GroupLayout.Alignment.LEADING,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(seperatorBetweenSlots2)
										.addComponent(slot3,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		GroupLayout pnlReel1Layout = new GroupLayout(slot1);
		slot1.setLayout(pnlReel1Layout);
		pnlReel1Layout.setHorizontalGroup(pnlReel1Layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				pnlReel1Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(slotLabel1)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		pnlReel1Layout.setVerticalGroup(pnlReel1Layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				pnlReel1Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(slotLabel1)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		GroupLayout pnlReel2Layout = new GroupLayout(slot2);
		slot2.setLayout(pnlReel2Layout);
		pnlReel2Layout.setHorizontalGroup(pnlReel2Layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				pnlReel2Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(slotLabel2)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		pnlReel2Layout.setVerticalGroup(pnlReel2Layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				pnlReel2Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(slotLabel2)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		GroupLayout pnlReel3Layout = new GroupLayout(slot3);
		slot3.setLayout(pnlReel3Layout);
		pnlReel3Layout.setHorizontalGroup(pnlReel3Layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				pnlReel3Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(slotLabel3)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		pnlReel3Layout.setVerticalGroup(pnlReel3Layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				pnlReel3Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(slotLabel3)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		GroupLayout layout = new GroupLayout(frame.getContentPane());
		frame.getContentPane().setLayout(layout);

		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				GroupLayout.Alignment.LEADING,
																				false))
																.addGap(0,
																		0,
																		Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createParallelGroup(
																								GroupLayout.Alignment.LEADING,
																								false)
																								.addComponent(
																										spinButton,
																										GroupLayout.Alignment.TRAILING,
																										GroupLayout.DEFAULT_SIZE,
																										GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addComponent(
																										slotsPanel,
																										GroupLayout.Alignment.TRAILING,
																										GroupLayout.DEFAULT_SIZE,
																										GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addComponent(
																										sepStats,
																										GroupLayout.Alignment.TRAILING)
																								.addComponent(
																										lblStatus,
																										GroupLayout.DEFAULT_SIZE,
																										GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addGroup(
																										layout.createSequentialGroup()
																												.addGroup(
																														layout.createParallelGroup(
																																GroupLayout.Alignment.TRAILING,
																																false)
																																.addComponent(
																																		twoMatchLabel,
																																		GroupLayout.Alignment.LEADING,
																																		GroupLayout.DEFAULT_SIZE,
																																		GroupLayout.DEFAULT_SIZE,
																																		Short.MAX_VALUE)
																																.addComponent(
																																		lblWon,
																																		GroupLayout.Alignment.LEADING,
																																		GroupLayout.DEFAULT_SIZE,
																																		GroupLayout.DEFAULT_SIZE,
																																		Short.MAX_VALUE)
																																.addComponent(
																																		allMatchLabel,
																																		GroupLayout.DEFAULT_SIZE,
																																		149,
																																		Short.MAX_VALUE))
																												.addPreferredGap(
																														ComponentPlacement.UNRELATED)
																												.addComponent(
																														sepStats2,
																														GroupLayout.PREFERRED_SIZE,
																														GroupLayout.DEFAULT_SIZE,
																														GroupLayout.PREFERRED_SIZE)
																												.addPreferredGap(
																														ComponentPlacement.UNRELATED)
																												.addGroup(
																														layout.createParallelGroup(
																																GroupLayout.Alignment.LEADING,
																																false)
																																.addComponent(
																																		gamesLostLabel,
																																		GroupLayout.DEFAULT_SIZE,
																																		GroupLayout.DEFAULT_SIZE,
																																		Short.MAX_VALUE)
																																.addComponent(
																																		creditsLabel,
																																		GroupLayout.DEFAULT_SIZE,
																																		GroupLayout.DEFAULT_SIZE,
																																		Short.MAX_VALUE)
																																.addComponent(
																																		moneyLabel,
																																		GroupLayout.DEFAULT_SIZE,
																																		154,
																																		Short.MAX_VALUE))
																												.addGap(0,
																														0,
																														Short.MAX_VALUE)))
																				.addGroup(
																						layout.createParallelGroup(
																								GroupLayout.Alignment.LEADING)
																								.addComponent(
																										seperatorForStatus,
																										GroupLayout.PREFERRED_SIZE,
																										426,
																										GroupLayout.PREFERRED_SIZE)
																								.addComponent(
																										lblPlayerName)
																								.addComponent(
																										lblName)
																								.addComponent(
																										cashButton)))
																.addContainerGap()))));

		layout.setVerticalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(slotsPanel,
										GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(spinButton,
										GroupLayout.PREFERRED_SIZE, 56,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(sepStats,
										GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		lblWon,
																		GroupLayout.PREFERRED_SIZE,
																		19,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		allMatchLabel,
																		GroupLayout.DEFAULT_SIZE,
																		25,
																		Short.MAX_VALUE)
																.addComponent(
																		twoMatchLabel,
																		GroupLayout.PREFERRED_SIZE,
																		19,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		ComponentPlacement.RELATED))
												.addComponent(sepStats2)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		gamesLostLabel,
																		GroupLayout.PREFERRED_SIZE,
																		19,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		creditsLabel,
																		GroupLayout.PREFERRED_SIZE,
																		19,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		moneyLabel,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)))

								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(seperatorForStatus,
										GroupLayout.PREFERRED_SIZE, 2,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblPlayerName)
								.addComponent(lblName)
								.addComponent(lblStatus,
										GroupLayout.PREFERRED_SIZE, 30,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(cashButton)
								/*
								 * GroupLayout.DEFAULT_SIZE,
								 * GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								 */
								/*
								 * .addGroup(
								 * layout.createParallelGroup(GroupLayout
								 * .Alignment.BASELINE))
								 */
								.addContainerGap()));

		frame.pack();

	}

	class CashButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			cashButtonListenermethod();
		}
	}

	public void cashButtonListenermethod() {
		if (moneyOwned >= feeForCredits) {
			moneyOwned -= feeForCredits;
			moneyLabel.setText("Total Money: $" + moneyOwned);
			credits += boughtCredits;
			creditsLabel.setText("Credits: " + credits);
			lblStatus.setText("+" + boughtCredits + " credits purchased! -$"
					+ feeForCredits);
		} else {
			lblStatus
					.setText("Sorry! You do not have sufficient money to buy any more credits");
		}
		lblStatus.setHorizontalAlignment(JLabel.CENTER);
		lblStatus.setVerticalAlignment(JLabel.CENTER);
		changeButtonColor();
	}

	public void changeButtonColor() {
		if (moneyOwned < bet) {
			cashButton.setBackground(Color.RED);
		} else {
			cashButton.setBackground(Color.GREEN);
		}
	}

	/** Performs action when Spin button is clicked. */
	class SpinButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (moneyOwned < feeForCredits && credits < bet) {
				lblStatus.setText("Game Over !!");
			} else if ((credits - bet) >= 0) {
				slot1.setBackground(new java.awt.Color(255, 215, 0));
				slot2.setBackground(new java.awt.Color(255, 215, 0));
				slot3.setBackground(new java.awt.Color(255, 215, 0));
				genRandomSlotCards();
				checkMatch();
			} else {
				lblStatus.setText("Bet is " + bet
						+ " credits, purchase more with $!");
			}
			changeButtonColor();
		}
	}

	public void genRandomSlotCards() {
		Random rand = new Random();
		firstSlot = rand.nextInt(listOfCards.size());
		secondSlot = rand.nextInt(listOfCards.size());
		thirdSlot = rand.nextInt(listOfCards.size());
		assignImagestoSlots(firstSlot, secondSlot, thirdSlot);
	}

	public void assignImagestoSlots(int ico1, int ico2, int ico3) {
		slotLabel1.setIcon(listOfCards.get(ico1));
		slotLabel2.setIcon(listOfCards.get(ico2));
		slotLabel3.setIcon(listOfCards.get(ico3));
	}

	public void checkMatch() {
		if (firstSlot == secondSlot && secondSlot == thirdSlot) {
			lblStatus.setText("Perfect Match -  ("
					+ listOfCards.get(firstSlot).getDescription() + ")! +$"
					+ calculatePrizeMoney(amount) + "!");
			allMatchLabel.setText("Perfect Match: " + matchThree());
			slot1.setBackground(new java.awt.Color(255, 0, 0));
			slot2.setBackground(new java.awt.Color(255, 0, 0));
			slot3.setBackground(new java.awt.Color(255, 0, 0));
		} else if (firstSlot == secondSlot || firstSlot == thirdSlot) {
			lblStatus.setText("Its a 2 slot match ("
					+ listOfCards.get(firstSlot).getDescription() + ")! +$"
					+ calculatePrizeMoney(amount) + "!");
			twoMatchLabel.setText("Two of a kind Match: " + matchTwo());
			if (firstSlot == secondSlot) {
				slot1.setBackground(new java.awt.Color(255, 0, 0));
				slot2.setBackground(new java.awt.Color(255, 0, 0));
			} else if (firstSlot == thirdSlot) {
				slot1.setBackground(new java.awt.Color(255, 0, 0));
				slot3.setBackground(new java.awt.Color(255, 0, 0));
			}
		} else if (secondSlot == thirdSlot) {
			lblStatus.setText("Its a 2 slot match ("
					+ listOfCards.get(secondSlot).getDescription() + ")! +$"
					+ calculatePrizeMoney(amount) + "!");
			twoMatchLabel.setText("Two of a kind Match: " + matchTwo());
			slot2.setBackground(new java.awt.Color(255, 0, 0));
			slot3.setBackground(new java.awt.Color(255, 0, 0));
		} else {
			lblStatus.setText("Sorry, you didn't match any symbols. -" + bet
					+ " credits!");
			gamesLostLabel.setText("Lost: " + lose());
		}
		creditsLabel.setText("Credits: " + (credits -= bet));
		moneyLabel.setText("Money: $"
				+ (moneyOwned += calculatePrizeMoney(amount)));
		lblWon.setText("Wins: " + win());
	}

	public double calculatePrizeMoney(double prizeMoney) {
		if (firstSlot == secondSlot && secondSlot == thirdSlot) {
			prizeMoney = amount; // if all are matched return the full pay out.

		} else if (firstSlot == secondSlot || firstSlot == thirdSlot
				|| secondSlot == thirdSlot) {

			prizeMoney = amount / 5;
		} else {
			prizeMoney = 0;
		}
		return prizeMoney;
	}

	public void initImageList() {
		listOfCards.add(createImageIcon("images/ace_diamonds.png",
				"Ace of diamonds"));
		listOfCards
				.add(createImageIcon("images/ace_clubs.png", "Ace of clubs"));
		listOfCards.add(createImageIcon("images/ace_hearts.png",
				"Ace of hearts"));
		listOfCards.add(createImageIcon("images/ace_spades.png",
				"Ace of spades"));
		listOfCards.add(createImageIcon("images/joker.png", "Joker"));
		listOfCards.add(createImageIcon("images/queen_diamonds.png",
				"Queen of diamonds"));
		listOfCards.add(createImageIcon("images/queen_clubs.png",
				"Queen of clubs"));
		listOfCards.add(createImageIcon("images/queen_hearts.png",
				"Queen of hearts"));
		listOfCards.add(createImageIcon("images/queen_spades.png",
				"Queen of spades"));
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

	public int matchThree() {
		numOfThreeMatches++;
		return numOfThreeMatches;
	}

	public int matchTwo() {
		numOfTwoMatches++;
		return numOfTwoMatches;
	}

	public int lose() {
		numOfLosses++;
		return numOfLosses;
	}

	public int win() {
		numOfWins = numOfThreeMatches + numOfTwoMatches;
		return numOfWins;
	}

	public static void main(String[] args) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception ex) {
			java.util.logging.Logger.getLogger(GameOfSlots.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new GameOfSlots("mini");
			}
		});

	}

}
