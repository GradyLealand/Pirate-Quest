/*Programming assignment: #3
 *
 * Name: Booty quest
 * Author: Grady Williams
 * Date: March 20, 2017
 * 
 * images sourced from http://www.clipartlord.com
 */

import java.awt.EventQueue;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.*;

public class Game {
	
	//--- global variables ---
	//to keep track of ship displayed in build ship
	private int buildClass = 1;
	// to keep track of items displayed in shop
	private int cannonClass = 1;
	private int sailClass = 1;
	private int hullClass = 1;
	private int totalCost = 0;
	//keep track of monster to select and fight
	private int monsterClass = 1;
	
	private JFrame frame;
	private JPanel shipBuilder; 
	private JPanel launch;
	private JPanel main;
	private JPanel shop;
	private JPanel monsterSelect;
	private JPanel battle;
	private JPanel panelShopCannonCard; 
	private JPanel panelShopSailCard; 
	private JPanel panelShopHullCard;
	private JPanel panelSelectMonset;
	private JButton btnPlayGame;
	private JButton btnCreateShip;
	private JButton btnBuilderCancel;
	private JButton btnMainShop;
	private JButton btnMainBattle;
	private JButton btnCancelPurches;
	private JButton btnBuy;
	private JButton btnStartBattle;
	private JButton btnCancelSelect;
	private JButton btnBattleRunAway;
	private JButton btnBuildForward;
	private JButton btnBuildBack;
	private JButton btnMainRepair;
	private JButton btnShopCannonBack;
	private JButton btnShopSailBack;
	private JButton btnShopHullBack;
	private JButton btnShopCannonForward;
	private JButton btnShopSailForward;
	private JButton btnShopHullForward;
	private JButton btnSelectMonsterBack;
	private JButton btnSelectMonsterForward;
	private JButton btnBattleVictory;
	private JLabel lblBuildGImage;
	private JLabel lblBuildGClass;
	private JLabel lblBuildGHP;
	private JLabel lblBuildGAtk;
	private JLabel lblBuildGDef;
	private JLabel lblBuildGSpd;
	private JLabel lblBuildFImage;
	private JLabel lblBuildFClass;
	private JLabel lblBuildFHP;
	private JLabel lblBuildFAtk;
	private JLabel lblBuildFDef;
	private JLabel lblBuildFSpd;
	private JLabel lblBuildShipName;
	private JLabel lblBuildYourShip;
	private JLabel lblBuildSImage;
	private JLabel lblBuildSClass;
	private JLabel lblBuildSHP;
	private JLabel lblBuildSAtk;
	private JLabel lblBuildSDef;
	private JLabel lblBuildSSpd;
	private JLabel lblMainHP;
	private JLabel lblMainImage;
	private JLabel lblMainName;
	private JLabel lblMainClass;
	private JLabel lblMainMaxHP;
	private JLabel lblMainAttack;
	private JLabel lblMainDefence;
	private JLabel lblMainStats;
	private JLabel lblMainEquipment;
	private JLabel lblMainCannonName;
	private JLabel lblMainCannonAtk;
	private JLabel lblMainSailSpd;
	private JLabel lblMainSailName;
	private JLabel lblMainHullDef;
	private JLabel lblMainHullName;
	private JLabel lblMainTitle;
	private JLabel lblShopCannonName;
	private JLabel lblShopCannonMod;
	private JLabel lblShopCannonCost;
	private JLabel lblShopSailName;
	private JLabel lblShopSailMod;
	private JLabel lblShopSailCost;
	private JLabel lblShopHullName;
	private JLabel lblShopHullMod;
	private JLabel lblShopHullCost;
	private JLabel lblShopCost; 
	private JLabel lblShopPlayerBooty;
	private JLabel lblShopRemainingBooty;
	private JLabel lblShopTitle;
	private JLabel lblShopSubTitle;
	private JLabel lblSelectABeast;
	private JLabel lblMainBooty;
	private JLabel lblSelectMonsterImage; 
	private JLabel lblSelectName;
	private JLabel lblSelectAttack;
	private JLabel lblSelectDefence;
	private JLabel lblSelectSpeed;
	private JLabel lblSelectHp;
	private JLabel lblSelectBooty;
	private JLabel lblBattlePlayerImage;
	private JLabel lblBattleMonsterName;
	private JLabel lblBattleMonsterImage;
	private Panel panelBuildDis;
	private Panel panelBuildSkiff;
	private Panel panelBuildFrigate;
	private Panel panelBuildGally;
	private JTextArea battleReport;
	private JScrollPane scrollPaneBattleReport;
	
	//---- Image Arrays ----
	private final String[] shipNames = {
			"skiff.JPG",
			"galley.JPG",
			"friget.JPG"
	};//end runName Array
	
	private final String[] monsterNames = {
			"angryCrab.jpg",
			"giantClam.jpg",
			"giantSquid.jpg",
			"kraken.jpg",
			"splashArt.jpg"
	};//end  monsterNames array
	
	private Icon[] monsterIcons = {
			new ImageIcon(getClass().getResource("Images/" + monsterNames[0])),
			new ImageIcon(getClass().getResource("Images/" + monsterNames[1])),
			new ImageIcon(getClass().getResource("Images/" + monsterNames[2])),
			new ImageIcon(getClass().getResource("Images/" + monsterNames[3])),
			new ImageIcon(getClass().getResource("Images/" + monsterNames[4]))
	};//end monsterIcons  Array
	
	private Icon[] shipIcons = {
			new ImageIcon(getClass().getResource("Images/" + shipNames[0])),
			new ImageIcon(getClass().getResource("Images/" + shipNames[1])),
			new ImageIcon(getClass().getResource("Images/" + shipNames[2]))
	};//end runIcons array
	
	//---- Create a blank ship ----
	private Ship playerShip = new Ship();
	
	//---- Create items to display in shop ----
	private Ship shopShip = new Ship();
	
	//---- Create enemy to fight ----
	private Monster enemy = new Monster();
	private JLabel lblBattlePlayerName;
	
	//timer elements
	ActionListener timerHandler = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
			actionTick();
		}
	};
	private final int ATK_SPEED = 500;//1/2second
	private Timer timer = new Timer(ATK_SPEED, timerHandler);
	private int monsterAtk = 0;
	private int playerAtk = 0;
	private JLabel lblMainSpeed;
	private JLabel lblBattlePlayerHP;
	private JLabel lblBattleMonsterHP;
	private JTextField textBuildName;
	
	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game window = new Game();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Game() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 667, 577);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		//----Launcher page----
		launch = new JPanel();
		frame.getContentPane().add(launch, "name_65073763753399");
		launch.setLayout(null);
		
		btnPlayGame = new JButton("Play Game");
		btnPlayGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblBuildSImage.setIcon(shipIcons[0]);
				lblBuildGImage.setIcon(shipIcons[1]);
				lblBuildFImage.setIcon(shipIcons[2]);
				shipBuilder.setVisible(true);
				launch.setVisible(false);
			}
		});
		btnPlayGame.setBounds(251, 434, 144, 62);
		launch.add(btnPlayGame);
		
		JLabel lblBootyQuest = new JLabel("BOOTY  QUEST");
		lblBootyQuest.setFont(new Font("Felix Titling", Font.BOLD, 30));
		lblBootyQuest.setBounds(194, 11, 250, 62);
		launch.add(lblBootyQuest);
		
		JLabel lblSplashArt = new JLabel("");
		lblSplashArt.setBounds(83, 84, 476, 327);
		launch.add(lblSplashArt);
		lblSplashArt.setIcon(monsterIcons[4]);
		
		//----Ship Builder page----
		shipBuilder = new JPanel();
		frame.getContentPane().add(shipBuilder, "name_65073795855932");
		shipBuilder.setLayout(null);
		
		btnCreateShip = new JButton("Build Ship");
		btnCreateShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//make sure the user inputs a name for the ship
				String text = textBuildName.getText();
				boolean emptyName = true;
				emptyName = nameValidate(text);
				if (emptyName){
					JOptionPane.showMessageDialog(null, "Must enter a name to continue");
				}else{
					//if a name was entered build the ship
					shipBuilder.setVisible(false);
					main.setVisible(true);
					buildShip(buildClass, textBuildName.getText(), playerShip);
					buildShip(buildClass, textBuildName.getText(), shopShip);
					populateMain(playerShip);
				}
			}

			
		});
		btnCreateShip.setBounds(398, 457, 126, 54);
		shipBuilder.add(btnCreateShip);
		
		btnBuilderCancel = new JButton("Cancel");
		btnBuilderCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipBuilder.setVisible(false);
				launch.setVisible(true);
			}
		});
		btnBuilderCancel.setBounds(110, 457, 126, 54);
		shipBuilder.add(btnBuilderCancel);
		
		lblBuildShipName = new JLabel("Ship Name:");
		lblBuildShipName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildShipName.setBounds(110, 91, 81, 22);
		shipBuilder.add(lblBuildShipName);
		
		
		
		lblBuildYourShip = new JLabel("Build Your Ship");
		lblBuildYourShip.setBounds(182, 11, 294, 47);
		shipBuilder.add(lblBuildYourShip);
		lblBuildYourShip.setFont(new Font("Felix Titling", Font.PLAIN, 30));
		
		panelBuildDis = new Panel();
		panelBuildDis.setBounds(110, 182, 414, 240);
		shipBuilder.add(panelBuildDis);
		panelBuildDis.setBackground(Color.WHITE);
		panelBuildDis.setLayout(new CardLayout(0, 0));
		
		panelBuildSkiff = new Panel();
		panelBuildDis.add(panelBuildSkiff, "name_527228960782570");
		panelBuildSkiff.setBackground(Color.GRAY);
		panelBuildSkiff.setLayout(null);
		
		lblBuildSImage = new JLabel("");
		lblBuildSImage.setIcon(null);
		lblBuildSImage.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblBuildSImage.setBounds(10, 11, 166, 221);
		panelBuildSkiff.add(lblBuildSImage);
		
		lblBuildSClass = new JLabel("Class: Skiff");
		lblBuildSClass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildSClass.setBounds(190, 11, 120, 22);
		panelBuildSkiff.add(lblBuildSClass);
		
		lblBuildSHP = new JLabel(" HP: 50");
		lblBuildSHP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildSHP.setBounds(188, 77, 122, 18);
		panelBuildSkiff.add(lblBuildSHP);
		
		lblBuildSAtk = new JLabel("Attack: 3 - 5");
		lblBuildSAtk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildSAtk.setBounds(190, 106, 94, 23);
		panelBuildSkiff.add(lblBuildSAtk);
		
		lblBuildSDef = new JLabel("Defence: 2");
		lblBuildSDef.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildSDef.setBounds(190, 140, 147, 24);
		panelBuildSkiff.add(lblBuildSDef);
		
		lblBuildSSpd = new JLabel("Speed: 7");
		lblBuildSSpd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildSSpd.setBounds(190, 175, 120, 24);
		panelBuildSkiff.add(lblBuildSSpd);
		
		panelBuildGally = new Panel();
		panelBuildDis.add(panelBuildGally, "name_527291210513969");
		panelBuildGally.setLayout(null);
		panelBuildGally.setBackground(Color.GRAY);
		
		lblBuildGImage = new JLabel("");
		lblBuildGImage.setIcon(null);
		lblBuildGImage.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblBuildGImage.setBounds(10, 11, 166, 221);
		panelBuildGally.add(lblBuildGImage);
		
		lblBuildGClass = new JLabel("Class: Gally");
		lblBuildGClass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildGClass.setBounds(193, 11, 120, 22);
		panelBuildGally.add(lblBuildGClass);
		
		lblBuildGHP = new JLabel(" HP: 70");
		lblBuildGHP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildGHP.setBounds(191, 77, 122, 18);
		panelBuildGally.add(lblBuildGHP);
		
		lblBuildGAtk = new JLabel("Attack: 4 - 7");
		lblBuildGAtk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildGAtk.setBounds(193, 106, 94, 23);
		panelBuildGally.add(lblBuildGAtk);
		
		lblBuildGDef = new JLabel("Defence: 4");
		lblBuildGDef.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildGDef.setBounds(193, 140, 147, 24);
		panelBuildGally.add(lblBuildGDef);
		
		lblBuildGSpd = new JLabel("Speed: 5");
		lblBuildGSpd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildGSpd.setBounds(193, 175, 120, 24);
		panelBuildGally.add(lblBuildGSpd);
		
		panelBuildFrigate = new Panel();
		panelBuildFrigate.setLayout(null);
		panelBuildFrigate.setBackground(Color.GRAY);
		panelBuildDis.add(panelBuildFrigate, "name_527704337273040");
		
		lblBuildFImage = new JLabel("");
		lblBuildFImage.setIcon(null);
		lblBuildFImage.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblBuildFImage.setBounds(10, 11, 166, 221);
		panelBuildFrigate.add(lblBuildFImage);
		
		lblBuildFClass = new JLabel("Class: Frigate");
		lblBuildFClass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildFClass.setBounds(194, 11, 120, 22);
		panelBuildFrigate.add(lblBuildFClass);
		
		lblBuildFHP = new JLabel(" HP: 100");
		lblBuildFHP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildFHP.setBounds(192, 77, 122, 18);
		panelBuildFrigate.add(lblBuildFHP);
		
		lblBuildFAtk = new JLabel("Attack: 1 - 10");
		lblBuildFAtk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildFAtk.setBounds(194, 106, 94, 23);
		panelBuildFrigate.add(lblBuildFAtk);
		
		lblBuildFDef = new JLabel("Defence: 3");
		lblBuildFDef.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildFDef.setBounds(194, 140, 147, 24);
		panelBuildFrigate.add(lblBuildFDef);
		
		lblBuildFSpd = new JLabel("Speed: 4");
		lblBuildFSpd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildFSpd.setBounds(194, 175, 120, 24);
		panelBuildFrigate.add(lblBuildFSpd);
		
		btnBuildBack = new JButton("<");
		btnBuildBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (buildClass != 1){
					buildClass--;
				}
				buildDisplay(buildClass);
			}
		});
		btnBuildBack.setBounds(15, 284, 89, 23);
		shipBuilder.add(btnBuildBack);
		
		btnBuildForward = new JButton(">");
		btnBuildForward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (buildClass != 3){
					buildClass++;
				}
				buildDisplay(buildClass);
			}
		});
		btnBuildForward.setBounds(530, 284, 89, 23);
		shipBuilder.add(btnBuildForward);
		
		textBuildName = new JTextField();
		textBuildName.setBounds(182, 94, 197, 20);
		shipBuilder.add(textBuildName);
		textBuildName.setColumns(10);
		
		//----Main page----
		main = new JPanel();
		frame.getContentPane().add(main, "name_65073807570321");
		main.setLayout(null);
		
		btnMainShop = new JButton("Shop");
		btnMainShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shop.setVisible(true);
				main.setVisible(false);
				cannonClass = playerShip.getCannon().getCannonType();
				replaceCannon(cannonClass, shopShip);
				sailClass = playerShip.getSail().getSailType();
				replaceSail(sailClass, shopShip);
				hullClass = playerShip.getHull().getHullType();
				replaceHull(hullClass, shopShip);
				populateShop(shopShip);
			}
		});
		btnMainShop.setBounds(467, 472, 134, 56);
		main.add(btnMainShop);
		
		btnMainBattle = new JButton("Battle");
		btnMainBattle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				monsterSelect.setVisible(true);
				main.setVisible(false);
				monsterClass = 1;
				populateSelect(monsterClass);
			}
		});
		btnMainBattle.setBounds(51, 472, 134, 56);
		main.add(btnMainBattle);
		
		lblMainImage = new JLabel("");
		lblMainImage.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblMainImage.setBounds(51, 112, 166, 221);
		main.add(lblMainImage);
		
		lblMainHP = new JLabel("HP:");
		lblMainHP.setBounds(51, 344, 117, 14);
		main.add(lblMainHP);
		
		lblMainName = new JLabel("NAME");
		lblMainName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMainName.setBounds(51, 87, 180, 28);
		main.add(lblMainName);
		
		lblMainClass = new JLabel("Class:");
		lblMainClass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMainClass.setBounds(241, 151, 111, 16);
		main.add(lblMainClass);
		
		lblMainMaxHP = new JLabel("Max HP:");
		lblMainMaxHP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMainMaxHP.setBounds(241, 176, 111, 17);
		main.add(lblMainMaxHP);
		
		lblMainAttack = new JLabel("Attack:");
		lblMainAttack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMainAttack.setBounds(241, 201, 111, 17);
		main.add(lblMainAttack);
		
		lblMainDefence = new JLabel("Defence:");
		lblMainDefence.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMainDefence.setBounds(241, 226, 111, 16);
		main.add(lblMainDefence);
		
		lblMainStats = new JLabel("BASE STATS");
		lblMainStats.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMainStats.setBounds(241, 112, 111, 28);
		main.add(lblMainStats);
		
		lblMainEquipment = new JLabel("EQUIPMENT");
		lblMainEquipment.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMainEquipment.setBounds(426, 112, 175, 27);
		main.add(lblMainEquipment);
		
		lblMainCannonName = new JLabel("Cannon:");
		lblMainCannonName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMainCannonName.setBounds(426, 153, 175, 16);
		main.add(lblMainCannonName);
		
		lblMainCannonAtk = new JLabel("Attack:");
		lblMainCannonAtk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMainCannonAtk.setBounds(426, 176, 175, 16);
		main.add(lblMainCannonAtk);
		
		lblMainSailSpd = new JLabel("Speed:");
		lblMainSailSpd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMainSailSpd.setBounds(426, 246, 175, 16);
		main.add(lblMainSailSpd);
		
		lblMainSailName = new JLabel("Sail:");
		lblMainSailName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMainSailName.setBounds(426, 226, 175, 17);
		main.add(lblMainSailName);
		
		lblMainHullDef = new JLabel("Deffence:");
		lblMainHullDef.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMainHullDef.setBounds(426, 305, 175, 16);
		main.add(lblMainHullDef);
		
		lblMainHullName = new JLabel("Hull:");
		lblMainHullName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMainHullName.setBounds(426, 288, 175, 17);
		main.add(lblMainHullName);
		
		lblMainTitle = new JLabel("Your Dock");
		lblMainTitle.setFont(new Font("Felix Titling", Font.PLAIN, 30));
		lblMainTitle.setBounds(208, 11, 202, 28);
		main.add(lblMainTitle);
		
		btnMainRepair = new JButton("Repair (10 Booty)");
		btnMainRepair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//if the player dose not have enough gold don't let them repair
				if (playerShip.getBooty() > 9){
					playerShip.setHp(playerShip.getHpMax());
					playerShip.setBooty(playerShip.getBooty() - 10);
					populateMain(playerShip);
				}else{
					JOptionPane.showMessageDialog(null, "Not enough booty");
				}
			}
		});
		btnMainRepair.setBounds(262, 472, 134, 56);
		main.add(btnMainRepair);
		
		lblMainBooty = new JLabel("Total Booty: ");
		lblMainBooty.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMainBooty.setBounds(241, 305, 145, 17);
		main.add(lblMainBooty);
		
		lblMainSpeed = new JLabel("Speed:");
		lblMainSpeed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMainSpeed.setBounds(241, 249, 111, 16);
		main.add(lblMainSpeed);
		
		//----Shop page----
		shop = new JPanel();
		frame.getContentPane().add(shop, "name_65073819825013");
		shop.setLayout(null);
		
		btnBuy = new JButton("Buy & Equip");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if the player has enough booty to afford items but and equip them
				if(totalCost <= playerShip.getBooty()){
					playerShip.setBooty(playerShip.getBooty() - totalCost);
					//equip items
					replaceCannon(cannonClass, playerShip);
					replaceSail(sailClass, playerShip);
					replaceHull(hullClass, playerShip);
					//go back to main
					shop.setVisible(false);
					main.setVisible(true);
					populateMain(playerShip);
				}else{
					JOptionPane.showMessageDialog(null, "Not enough booty");
				}
			}
		});
		btnBuy.setBounds(484, 472, 117, 53);
		shop.add(btnBuy);
		
		btnCancelPurches = new JButton("Back");
		btnCancelPurches.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shop.setVisible(false);
				main.setVisible(true);
			}
		});
		btnCancelPurches.setBounds(47, 469, 117, 59);
		shop.add(btnCancelPurches);
		
		panelShopCannonCard = new JPanel();
		panelShopCannonCard.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelShopCannonCard.setBounds(254, 130, 138, 65);
		shop.add(panelShopCannonCard);
		panelShopCannonCard.setLayout(null);
		
		lblShopCannonName = new JLabel("Name");
		lblShopCannonName.setBounds(10, 11, 118, 14);
		panelShopCannonCard.add(lblShopCannonName);
		
		lblShopCannonMod = new JLabel("Mod");
		lblShopCannonMod.setBounds(10, 25, 118, 14);
		panelShopCannonCard.add(lblShopCannonMod);
		
		lblShopCannonCost = new JLabel("Cost");
		lblShopCannonCost.setBounds(10, 40, 118, 14);
		panelShopCannonCard.add(lblShopCannonCost);
		
		panelShopSailCard = new JPanel();
		panelShopSailCard.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelShopSailCard.setLayout(null);
		panelShopSailCard.setBounds(254, 229, 138, 65);
		shop.add(panelShopSailCard);
		
		lblShopSailName = new JLabel("Name");
		lblShopSailName.setBounds(10, 11, 118, 14);
		panelShopSailCard.add(lblShopSailName);
		
		lblShopSailMod = new JLabel("Mod");
		lblShopSailMod.setBounds(10, 26, 118, 14);
		panelShopSailCard.add(lblShopSailMod);
		
		lblShopSailCost = new JLabel("Cost");
		lblShopSailCost.setBounds(10, 40, 118, 14);
		panelShopSailCard.add(lblShopSailCost);
		
		panelShopHullCard = new JPanel();
		panelShopHullCard.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelShopHullCard.setLayout(null);
		panelShopHullCard.setBounds(254, 331, 138, 65);
		shop.add(panelShopHullCard);
		
		lblShopHullName = new JLabel("Name");
		lblShopHullName.setBounds(10, 11, 118, 14);
		panelShopHullCard.add(lblShopHullName);
		
		lblShopHullMod = new JLabel("Mod");
		lblShopHullMod.setBounds(10, 25, 118, 14);
		panelShopHullCard.add(lblShopHullMod);
		
		lblShopHullCost = new JLabel("Cost");
		lblShopHullCost.setBounds(10, 40, 118, 14);
		panelShopHullCard.add(lblShopHullCost);
		
		btnShopCannonBack = new JButton("<");
		btnShopCannonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cannonClass > 1){
					cannonClass--;
					replaceCannon(cannonClass, shopShip);
					populateShop(shopShip);
				}
			}
		});
		btnShopCannonBack.setBounds(190, 152, 54, 23);
		shop.add(btnShopCannonBack);
		
		btnShopSailBack = new JButton("<");
		btnShopSailBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sailClass > 1){
					sailClass--;
					replaceSail(sailClass, shopShip);
					populateShop(shopShip);
				}
			}
		});
		btnShopSailBack.setBounds(190, 253, 54, 23);
		shop.add(btnShopSailBack);
		
		btnShopHullBack = new JButton("<");
		btnShopHullBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hullClass > 1){
					hullClass--;
					replaceHull(hullClass, shopShip);
					populateShop(shopShip);
				}
			}
		});
		btnShopHullBack.setBounds(190, 344, 54, 23);
		shop.add(btnShopHullBack);
		
		btnShopCannonForward = new JButton(">");
		btnShopCannonForward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cannonClass < 4){
					cannonClass++;
					replaceCannon(cannonClass, shopShip);
					populateShop(shopShip);
				}
				
			}
		});
		btnShopCannonForward.setBounds(402, 152, 54, 23);
		shop.add(btnShopCannonForward);
		
		btnShopSailForward = new JButton(">");
		btnShopSailForward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (sailClass < 3){
					sailClass++;
					replaceSail(sailClass, shopShip);
					populateShop(shopShip);
				}
			}
		});
		btnShopSailForward.setBounds(402, 253, 54, 23);
		shop.add(btnShopSailForward);
		
		btnShopHullForward = new JButton(">");
		btnShopHullForward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hullClass < 3){
					hullClass++;
					replaceHull(hullClass, shopShip);
					populateShop(shopShip);
				}
			}
		});
		btnShopHullForward.setBounds(402, 344, 54, 23);
		shop.add(btnShopHullForward);
		
		lblShopCost = new JLabel("Total Cost:");
		lblShopCost.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblShopCost.setBounds(254, 468, 202, 29);
		shop.add(lblShopCost);
		
		lblShopPlayerBooty = new JLabel("Your booty:");
		lblShopPlayerBooty.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblShopPlayerBooty.setBounds(246, 449, 210, 29);
		shop.add(lblShopPlayerBooty);
		
		lblShopRemainingBooty = new JLabel("Remaining Booty:");
		lblShopRemainingBooty.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblShopRemainingBooty.setBounds(212, 485, 244, 29);
		shop.add(lblShopRemainingBooty);
		
		lblShopTitle = new JLabel("Ye  `Ol Ship Yard");
		lblShopTitle.setFont(new Font("Felix Titling", Font.BOLD, 26));
		lblShopTitle.setBounds(190, 30, 272, 44);
		shop.add(lblShopTitle);
		
		lblShopSubTitle = new JLabel("Buy sum thin yha scalywag");
		lblShopSubTitle.setFont(new Font("Felix Titling", Font.PLAIN, 11));
		lblShopSubTitle.setBounds(234, 73, 172, 14);
		shop.add(lblShopSubTitle);
		
		//----Monster Select page----
		monsterSelect = new JPanel();
		monsterSelect.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		frame.getContentPane().add(monsterSelect, "name_65073832027300");
		monsterSelect.setLayout(null);
		
		btnStartBattle = new JButton("Fight");
		btnStartBattle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populateBattle();
				monsterSelect.setVisible(false);
				battle.setVisible(true);
				lblBattleMonsterHP.setText("HP: " + enemy.getHp() + "/" + enemy.getHpMax());
				lblBattlePlayerHP.setText("HP: " + playerShip.getHp() + "/" + playerShip.getHpMax());
				lblBattlePlayerName.setText(playerShip.getName());
				lblBattleMonsterName.setText(enemy.getName());
				if (btnBattleRunAway.isEnabled() == false){
					btnBattleRunAway.setEnabled(true);
				}
				timer.start();
			}
		});
		btnStartBattle.setBounds(437, 453, 140, 57);
		monsterSelect.add(btnStartBattle);
		
		btnCancelSelect = new JButton("Back");
		btnCancelSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				monsterSelect.setVisible(false);
				main.setVisible(true);
			}
		});
		btnCancelSelect.setBounds(69, 453, 140, 57);
		monsterSelect.add(btnCancelSelect);
		
		lblSelectABeast = new JLabel("Select a Beast");
		lblSelectABeast.setFont(new Font("Felix Titling", Font.BOLD, 24));
		lblSelectABeast.setBounds(211, 11, 214, 47);
		monsterSelect.add(lblSelectABeast);
		
		panelSelectMonset = new JPanel();
		panelSelectMonset.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelSelectMonset.setBounds(113, 128, 416, 241);
		monsterSelect.add(panelSelectMonset);
		panelSelectMonset.setLayout(null);
		
		lblSelectMonsterImage = new JLabel("");
		lblSelectMonsterImage.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblSelectMonsterImage.setBounds(10, 11, 166, 221);
		panelSelectMonset.add(lblSelectMonsterImage);
		
		lblSelectName = new JLabel("name");
		lblSelectName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelectName.setBounds(184, 11, 107, 28);
		panelSelectMonset.add(lblSelectName);
		
		lblSelectAttack = new JLabel("Atack");
		lblSelectAttack.setBounds(184, 68, 92, 14);
		panelSelectMonset.add(lblSelectAttack);
		
		lblSelectDefence = new JLabel("Defence");
		lblSelectDefence.setBounds(184, 103, 92, 14);
		panelSelectMonset.add(lblSelectDefence);
		
		lblSelectSpeed = new JLabel("Speed");
		lblSelectSpeed.setBounds(184, 143, 92, 14);
		panelSelectMonset.add(lblSelectSpeed);
		
		lblSelectHp = new JLabel("HP");
		lblSelectHp.setBounds(286, 68, 107, 14);
		panelSelectMonset.add(lblSelectHp);
		
		lblSelectBooty = new JLabel("Booty");
		lblSelectBooty.setBounds(286, 103, 107, 14);
		panelSelectMonset.add(lblSelectBooty);
		
		btnSelectMonsterBack = new JButton("<");
		btnSelectMonsterBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (monsterClass > 1){
					monsterClass--;
					populateSelect(monsterClass);
				}
			}
		});
		btnSelectMonsterBack.setFont(new Font("Tahoma", Font.PLAIN, 58));
		btnSelectMonsterBack.setBounds(21, 200, 82, 68);
		monsterSelect.add(btnSelectMonsterBack);
		
		btnSelectMonsterForward = new JButton(">");
		btnSelectMonsterForward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (monsterClass < 4){
					monsterClass++;
					populateSelect(monsterClass);
				}
			}
		});
		btnSelectMonsterForward.setFont(new Font("Tahoma", Font.PLAIN, 58));
		btnSelectMonsterForward.setBounds(539, 200, 82, 68);
		monsterSelect.add(btnSelectMonsterForward);
		
		//----Battle page----
		battle = new JPanel();
		frame.getContentPane().add(battle, "name_65073845567996");
		battle.setLayout(null);
		
		btnBattleRunAway = new JButton("Run Away");
		btnBattleRunAway.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to run away?");
				if (resp == JOptionPane.YES_OPTION){
					battle.setVisible(false);
					main.setVisible(true);
					populateMain(playerShip);
					battleReport.setText("");
					if(timer.isRunning()){
						timer.stop();
					}
				}	
			}
		});
		btnBattleRunAway.setBounds(51, 461, 138, 45);
		battle.add(btnBattleRunAway);
		
		lblBattlePlayerImage = new JLabel("");
		lblBattlePlayerImage.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblBattlePlayerImage.setBounds(10, 99, 166, 221);
		battle.add(lblBattlePlayerImage);
		
		lblBattleMonsterImage = new JLabel("");
		lblBattleMonsterImage.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblBattleMonsterImage.setBounds(465, 99, 166, 221);
		battle.add(lblBattleMonsterImage);
		
		scrollPaneBattleReport = new JScrollPane();
		scrollPaneBattleReport.setBounds(186, 63, 269, 305);
		battle.add(scrollPaneBattleReport);
		
		battleReport = new JTextArea();
		scrollPaneBattleReport.setViewportView(battleReport);
		
		lblBattlePlayerName = new JLabel("PlayerName");
		lblBattlePlayerName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBattlePlayerName.setBounds(10, 63, 166, 25);
		battle.add(lblBattlePlayerName);
		
		lblBattleMonsterName = new JLabel("Monster Name");
		lblBattleMonsterName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBattleMonsterName.setBounds(465, 63, 166, 25);
		battle.add(lblBattleMonsterName);
		
		lblBattlePlayerHP = new JLabel("hp");
		lblBattlePlayerHP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBattlePlayerHP.setBounds(20, 331, 123, 25);
		battle.add(lblBattlePlayerHP);
		
		lblBattleMonsterHP = new JLabel("hp");
		lblBattleMonsterHP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBattleMonsterHP.setBounds(475, 331, 123, 25);
		battle.add(lblBattleMonsterHP);
		
		btnBattleVictory = new JButton("Victory");
		btnBattleVictory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnBattleVictory.setEnabled(false);
				battle.setVisible(false);
				main.setVisible(true);
				battleReport.setText("");
				populateMain(playerShip);
			}
		});
		btnBattleVictory.setEnabled(false);
		btnBattleVictory.setBounds(460, 461, 138, 45);
		battle.add(btnBattleVictory);
	}//end GUI
	
	//---- Class Methods ----
	//change call panels on the build page
	private void buildDisplay(int num) {
		if (num == 1){
			panelBuildSkiff.setVisible(true);
			panelBuildGally.setVisible(false);
			panelBuildFrigate.setVisible(false);
		}else if (num == 2){
			panelBuildSkiff.setVisible(false);
			panelBuildGally.setVisible(true);
			panelBuildFrigate.setVisible(false);
		}else if (num == 3){
			panelBuildSkiff.setVisible(false);
			panelBuildGally.setVisible(false);
			panelBuildFrigate.setVisible(true);
		}
		
	}//end buildDisplay
	
	//set initial stats base on chosen class
	private void buildShip(int type, String name, Ship ship){
		if (type == 1){
			ship.Skiff(ship, name);
		}else if (type == 2){
			ship.Gally(ship, name);
		}else{
			ship.Frigate(ship, name);
		}
	}//end buildShip
	
	//fill in labels on the main page
	private void populateMain(Ship ship){
		lblMainName.setText(ship.getName());
		lblMainClass.setText("Class: " + ship.getShipClass());
		lblMainMaxHP.setText("Max Hp: " + ship.getHpMax());
		lblMainAttack.setText("Attack: " + ship.getMinAtk() + "-" + ship.getMaxAtk());
		lblMainDefence.setText("Defence: " + ship.getDefence());
		lblMainSpeed.setText("Speed: " + ship.getSpeed());
		lblMainCannonName.setText("Cannon: " + ship.getCannon().getCannonName());
		lblMainCannonAtk.setText("Attack: +" + ship.getCannon().getAttackMod());
		lblMainSailName.setText("Sail: " + ship.getSail().getSailName());
		lblMainSailSpd.setText("Speed: +" + ship.getSail().getSpeedMod());
		lblMainHullName.setText("Hull: " + ship.getHull().getHullName());
		lblMainHullDef.setText("Defence: +" + ship.getHull().getDefenceMod());
		lblMainHP.setText("HP: " + ship.getHp() + "/" + ship.getHpMax());
		lblMainImage.setIcon(shipIcons[buildClass - 1]);
		lblMainBooty.setText("Total Booty: " + ship.getBooty());
	}//end populateMain
	
	//fill in item info in the store page
	private void populateShop(Ship shopShip) {
		lblShopCannonName.setText(shopShip.getCannon().getCannonName());
		lblShopCannonMod.setText("Attack: +" + shopShip.getCannon().getAttackMod());
		lblShopCannonCost.setText("Cost: " + shopShip.getCannon().getCost());
		lblShopSailName.setText(shopShip.getSail().getSailName());
		lblShopSailMod.setText("Speed: +" + shopShip.getSail().getSpeedMod());
		lblShopSailCost.setText("Cost: " + shopShip.getSail().getCost());
		lblShopHullName.setText(shopShip.getHull().getHullName());
		lblShopHullMod.setText("Defence: +" + shopShip.getHull().getDefenceMod());
		lblShopHullCost.setText("Cost: " + shopShip.getHull().getCost());	
		lblShopPlayerBooty.setText("Your Booty: " + playerShip.getBooty());
		int cost = calculateCost(shopShip, playerShip);
		lblShopCost.setText("Total Cost: " + cost);
		lblShopRemainingBooty.setText("Remaining Booty: " + (playerShip.getBooty() - cost) );
	}
	
	//populate the monster select page
	private void populateSelect(int monsterSelect){
		if (monsterSelect == 1){
			enemy.angryCrab(enemy);
		}else if (monsterSelect == 2){
			enemy.giantClam(enemy);
		}else if (monsterSelect == 3){
			enemy.giantSquid(enemy);
		}else{
			enemy.kracken(enemy);
		}
		
		lblSelectMonsterImage.setIcon(monsterIcons[monsterSelect - 1]);
		lblSelectName.setText(enemy.getName());
		lblSelectAttack.setText("Attack: " + enemy.getAttack());
		lblSelectDefence.setText("Defence: " + enemy.getDefence());
		lblSelectSpeed.setText("Speed: " + enemy.getSpeed());
		lblSelectHp.setText("HP: " + enemy.getHp());
		lblSelectBooty.setText("Booty: " + enemy.getDrop());
	}
	
	private void populateBattle(){
		lblBattleMonsterImage.setIcon(monsterIcons[monsterClass - 1]);
		lblBattlePlayerImage.setIcon(shipIcons[buildClass - 1]);
	};
	
	//Calculate cost of items to buy
	private int calculateCost(Ship shopShip, Ship ship){
		int a = 0;
		int b = 0;
		int c = 0;
		//check to see if a better item is selected then is currently equipped then change the price
		if (shopShip.getCannon().getCannonType() > ship.getCannon().getCannonType()){
			a = shopShip.getCannon().getCost();
		}
		if (shopShip.getSail().getSailType() > ship.getSail().getSailType()){
			b = shopShip.getSail().getCost();
		}
		if (shopShip.getHull().getHullType() > ship.getHull().getHullType()){
			c = shopShip.getHull().getCost();
		}
		
		int cost = a + b + c;
		totalCost = cost;
		return cost;
	}
	
	//change equipment on ship
	private void replaceCannon(int cannonClass, Ship ship) {
		if(cannonClass == 1){
			ship.getCannon().cardbordCannon(ship.getCannon());
		}else if (cannonClass == 2){
			ship.getCannon().copperCannon(ship.getCannon());
		}else if (cannonClass == 3){
			ship.getCannon().brassCannon(ship.getCannon());
		}else {
			ship.getCannon().ironCannon(ship.getCannon());
		}
	}//end replaceCannon
	
	private void replaceSail(int sailClass, Ship ship){
		if (sailClass == 1){
			ship.getSail().papperSail(ship.getSail());
		}else if (sailClass == 2){
			ship.getSail().clothSail(ship.getSail());
		}else {
			ship.getSail().syntheticSail(ship.getSail());
		}
	}//end replace sail
	
	private void replaceHull(int hullClass, Ship ship){
		if (hullClass == 1){
			ship.getHull().cardboardHull(ship.getHull());
		}else if (hullClass == 2){
			ship.getHull().woodenHull(ship.getHull());
		}else{
			ship.getHull().reinforcedHull(ship.getHull());
		}
	}//end replace hull
	
	public void actionTick(){
		int monsterSpeed = 10 - enemy.getSpeed();
		int playerSpeed = 10 - (playerShip.getSpeed() + playerShip.getSail().getSpeedMod());
		playerAtk++;
		monsterAtk++;
		if (playerAtk == playerSpeed){
			int dmg = playerAttack(playerShip, enemy);
			battleReport.append(playerShip.getName() + " attacks " + enemy.getName() + "\n   Dealing " + dmg + " "
					+ "damage.\n\n");
			if (enemy.getHp() < 0){
				enemy.setHp(0);
			}
			lblBattleMonsterHP.setText("HP: " + enemy.getHp() + "/" + enemy.getHpMax());
			checkDeath(playerShip, enemy);
			playerAtk = 0;
		}
		if (monsterAtk == monsterSpeed){
			int dmg = monsterAttack(enemy, playerShip);
			battleReport.append(enemy.getName() + " attacks " + playerShip.getName() + "\n   Dealing " + dmg + " "
					+ "damage.\n\n");
			if (playerShip.getHp() < 0){
				playerShip.setHp(0);
			}
			lblBattlePlayerHP.setText("HP: " + playerShip.getHp() + "/" + playerShip.getHpMax());
			checkDeath(playerShip, enemy);
			monsterAtk = 0;
		}
	}//end asctionTick
	
	//Perform attack of player on monster
	private int playerAttack(Ship ship, Monster mob){
		int atk = ship.attack(ship);
		int dmg = mob.defence(atk, mob);
		return dmg;
	}//end playerAttack
	
	//Perform attack of monster on player
	private int monsterAttack(Monster mob, Ship ship){
		int atk = mob.attack(mob);
		int dmg = ship.defend(atk, ship);
		return dmg;
	}//end monsterAttack
	
	//check to see if either the player or monster has died
	private void checkDeath(Ship ship, Monster mob){
		if (ship.getHp() < 1){
			timer.stop();
			ship.setHp(ship.getHpMax() / 2);
			ship.setBooty(ship.getBooty() / 2);
			battleReport.setText("The " + mob.getName() + " has defeated you.\nYour ship has been rescued by Poseidon\n"
					+ "but you are forced to run away.\nHe also takes half your booty");
		}
		if (mob.getHp() < 1){
			timer.stop();
			ship.setBooty(ship.getBooty() + mob.getDrop());
			btnBattleRunAway.setEnabled(false);
			btnBattleVictory.setEnabled(true);
			battleReport.setText("You have defeated the " + mob.getName() + "!\nYou plunder " + mob.getDrop() + " Booty!");
		}
	}//end checkDeaths
	
	public boolean nameValidate(String input){
		if (!input.isEmpty() && !input.trim().isEmpty())
			return false;
		else
			return true;
	}//end nameValidate
	
}//end class

