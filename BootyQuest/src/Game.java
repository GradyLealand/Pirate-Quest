import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Panel;
import java.awt.GridLayout;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JProgressBar;


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
	private JButton btnRunAway;
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
	private JTextField textField;
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
	private JProgressBar progBarMainHP;
	private Panel panelBuildDis;
	private Panel panelBuildSkiff;
	private Panel panelBuildFrigate;
	private Panel panelBuildGally;
	
	//---- Create a blank ship ----
	private Ship playerShip = new Ship();
	
	//---- Create items to display in shop ----
	private Ship shopShip = new Ship();
	
	//---- Create enemy to fight ----
	private Monster enemy = new Monster();
	
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
				shipBuilder.setVisible(true);
				launch.setVisible(false);
			}
		});
		btnPlayGame.setBounds(251, 434, 144, 62);
		launch.add(btnPlayGame);
		
		//----Ship Builder page----
		shipBuilder = new JPanel();
		frame.getContentPane().add(shipBuilder, "name_65073795855932");
		shipBuilder.setLayout(null);
		
		btnCreateShip = new JButton("Build Ship");
		btnCreateShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				shipBuilder.setVisible(false);
				main.setVisible(true);
				buildShip(buildClass, textField.getText(), playerShip);
				buildShip(buildClass, textField.getText(), shopShip);
				populateMain(playerShip);
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
		
		textField = new JTextField();
		textField.setBounds(182, 94, 178, 20);
		shipBuilder.add(textField);
		textField.setColumns(10);
		
		lblBuildYourShip = new JLabel("Build Your Ship");
		lblBuildYourShip.setBounds(203, 11, 217, 47);
		shipBuilder.add(lblBuildYourShip);
		lblBuildYourShip.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		panelBuildDis = new Panel();
		panelBuildDis.setBounds(110, 182, 414, 230);
		shipBuilder.add(panelBuildDis);
		panelBuildDis.setBackground(Color.WHITE);
		panelBuildDis.setLayout(new CardLayout(0, 0));
		
		panelBuildSkiff = new Panel();
		panelBuildDis.add(panelBuildSkiff, "name_527228960782570");
		panelBuildSkiff.setBackground(Color.GRAY);
		panelBuildSkiff.setLayout(null);
		
		lblBuildSImage = new JLabel("");
		lblBuildSImage.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblBuildSImage.setBounds(10, 11, 141, 208);
		panelBuildSkiff.add(lblBuildSImage);
		
		lblBuildSClass = new JLabel("Class: Skiff");
		lblBuildSClass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildSClass.setBounds(161, 11, 120, 22);
		panelBuildSkiff.add(lblBuildSClass);
		
		lblBuildSHP = new JLabel(" HP Roll: 50 - 70");
		lblBuildSHP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildSHP.setBounds(159, 77, 122, 18);
		panelBuildSkiff.add(lblBuildSHP);
		
		lblBuildSAtk = new JLabel("Attack: 3 - 5");
		lblBuildSAtk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildSAtk.setBounds(161, 106, 94, 23);
		panelBuildSkiff.add(lblBuildSAtk);
		
		lblBuildSDef = new JLabel("Defence: 2");
		lblBuildSDef.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildSDef.setBounds(161, 140, 147, 24);
		panelBuildSkiff.add(lblBuildSDef);
		
		lblBuildSSpd = new JLabel("Speed: 7");
		lblBuildSSpd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildSSpd.setBounds(161, 175, 120, 24);
		panelBuildSkiff.add(lblBuildSSpd);
		
		panelBuildGally = new Panel();
		panelBuildDis.add(panelBuildGally, "name_527291210513969");
		panelBuildGally.setLayout(null);
		panelBuildGally.setBackground(Color.GRAY);
		
		lblBuildGImage = new JLabel("");
		lblBuildGImage.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblBuildGImage.setBounds(10, 11, 141, 208);
		panelBuildGally.add(lblBuildGImage);
		
		lblBuildGClass = new JLabel("Class: Gally");
		lblBuildGClass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildGClass.setBounds(161, 11, 120, 22);
		panelBuildGally.add(lblBuildGClass);
		
		lblBuildGHP = new JLabel(" HP Roll: 70 - 100");
		lblBuildGHP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildGHP.setBounds(159, 77, 122, 18);
		panelBuildGally.add(lblBuildGHP);
		
		lblBuildGAtk = new JLabel("Attack: 5 - 7");
		lblBuildGAtk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildGAtk.setBounds(161, 106, 94, 23);
		panelBuildGally.add(lblBuildGAtk);
		
		lblBuildGDef = new JLabel("Defence: 3");
		lblBuildGDef.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildGDef.setBounds(161, 140, 147, 24);
		panelBuildGally.add(lblBuildGDef);
		
		lblBuildGSpd = new JLabel("Speed: 6");
		lblBuildGSpd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildGSpd.setBounds(161, 175, 120, 24);
		panelBuildGally.add(lblBuildGSpd);
		
		panelBuildFrigate = new Panel();
		panelBuildFrigate.setLayout(null);
		panelBuildFrigate.setBackground(Color.GRAY);
		panelBuildDis.add(panelBuildFrigate, "name_527704337273040");
		
		lblBuildFImage = new JLabel("");
		lblBuildFImage.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblBuildFImage.setBounds(10, 11, 141, 208);
		panelBuildFrigate.add(lblBuildFImage);
		
		lblBuildFClass = new JLabel("Class: Frigate");
		lblBuildFClass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildFClass.setBounds(161, 11, 120, 22);
		panelBuildFrigate.add(lblBuildFClass);
		
		lblBuildFHP = new JLabel(" HP Roll: 90 - 120");
		lblBuildFHP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildFHP.setBounds(159, 77, 122, 18);
		panelBuildFrigate.add(lblBuildFHP);
		
		lblBuildFAtk = new JLabel("Attack: 3 - 10");
		lblBuildFAtk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildFAtk.setBounds(161, 106, 94, 23);
		panelBuildFrigate.add(lblBuildFAtk);
		
		lblBuildFDef = new JLabel("Defence: 5");
		lblBuildFDef.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildFDef.setBounds(161, 140, 147, 24);
		panelBuildFrigate.add(lblBuildFDef);
		
		lblBuildFSpd = new JLabel("Speed: 4");
		lblBuildFSpd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuildFSpd.setBounds(161, 175, 120, 24);
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
		lblMainImage.setBounds(51, 112, 180, 237);
		main.add(lblMainImage);
		
		progBarMainHP = new JProgressBar();
		progBarMainHP.setBounds(51, 360, 180, 14);
		main.add(progBarMainHP);
		
		lblMainHP = new JLabel("HP:");
		lblMainHP.setBounds(51, 374, 117, 14);
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
		lblMainTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMainTitle.setBounds(241, 11, 143, 28);
		main.add(lblMainTitle);
		
		btnMainRepair = new JButton("Repair (10 Booty)");
		btnMainRepair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (playerShip.getBooty() > 9){
					playerShip.setHp(playerShip.getMaxHp());
					playerShip.setBooty(playerShip.getBooty() - 10);
					populateMain(playerShip);
				}
			}
		});
		btnMainRepair.setBounds(262, 472, 134, 56);
		main.add(btnMainRepair);
		
		lblMainBooty = new JLabel("Total Booty: ");
		lblMainBooty.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMainBooty.setBounds(241, 305, 145, 17);
		main.add(lblMainBooty);
		
		//----Shop page----
		shop = new JPanel();
		frame.getContentPane().add(shop, "name_65073819825013");
		shop.setLayout(null);
		
		btnBuy = new JButton("Buy & Equip");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(totalCost <= playerShip.getBooty()){
					playerShip.setBooty(playerShip.getBooty() - totalCost);
					replaceCannon(cannonClass, playerShip);
					replaceSail(sailClass, playerShip);
					replaceHull(hullClass, playerShip);
					shop.setVisible(false);
					main.setVisible(true);
					populateMain(playerShip);
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
		lblShopTitle.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblShopTitle.setBounds(206, 30, 244, 53);
		shop.add(lblShopTitle);
		
		lblShopSubTitle = new JLabel("Buy sum thin yha scalywag");
		lblShopSubTitle.setBounds(257, 94, 129, 14);
		shop.add(lblShopSubTitle);
		
		//----Monster Select page----
		monsterSelect = new JPanel();
		monsterSelect.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		frame.getContentPane().add(monsterSelect, "name_65073832027300");
		monsterSelect.setLayout(null);
		
		btnStartBattle = new JButton("Fight");
		btnStartBattle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				monsterSelect.setVisible(false);
				battle.setVisible(true);
			}
		});
		btnStartBattle.setBounds(72, 458, 140, 57);
		monsterSelect.add(btnStartBattle);
		
		btnCancelSelect = new JButton("Back");
		btnCancelSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				monsterSelect.setVisible(false);
				main.setVisible(true);
			}
		});
		btnCancelSelect.setBounds(432, 458, 140, 57);
		monsterSelect.add(btnCancelSelect);
		
		lblSelectABeast = new JLabel("Select a Beast");
		lblSelectABeast.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblSelectABeast.setBounds(240, 11, 167, 47);
		monsterSelect.add(lblSelectABeast);
		
		panelSelectMonset = new JPanel();
		panelSelectMonset.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelSelectMonset.setBounds(113, 128, 416, 213);
		monsterSelect.add(panelSelectMonset);
		panelSelectMonset.setLayout(null);
		
		lblSelectMonsterImage = new JLabel("");
		lblSelectMonsterImage.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblSelectMonsterImage.setBounds(10, 11, 153, 191);
		panelSelectMonset.add(lblSelectMonsterImage);
		
		lblSelectName = new JLabel("name");
		lblSelectName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelectName.setBounds(173, 11, 107, 28);
		panelSelectMonset.add(lblSelectName);
		
		lblSelectAttack = new JLabel("Atack");
		lblSelectAttack.setBounds(173, 68, 92, 14);
		panelSelectMonset.add(lblSelectAttack);
		
		lblSelectDefence = new JLabel("Defence");
		lblSelectDefence.setBounds(173, 103, 92, 14);
		panelSelectMonset.add(lblSelectDefence);
		
		lblSelectSpeed = new JLabel("Speed");
		lblSelectSpeed.setBounds(173, 143, 92, 14);
		panelSelectMonset.add(lblSelectSpeed);
		
		lblSelectHp = new JLabel("HP");
		lblSelectHp.setBounds(275, 68, 107, 14);
		panelSelectMonset.add(lblSelectHp);
		
		lblSelectBooty = new JLabel("Booty");
		lblSelectBooty.setBounds(275, 103, 107, 14);
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
		
		btnRunAway = new JButton("Run Away");
		btnRunAway.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to run away?");
				if (resp == JOptionPane.YES_OPTION){
					battle.setVisible(false);
					main.setVisible(true);
				}	
			}
		});
		btnRunAway.setBounds(51, 461, 138, 45);
		battle.add(btnRunAway);
		
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
		lblMainMaxHP.setText("Max Hp: " + ship.getMaxHp());
		lblMainAttack.setText("Attack: " + ship.getMinAtk() + "-" + ship.getMaxAtk());
		lblMainDefence.setText("Defence: " + ship.getDeffence());
		lblMainCannonName.setText("Cannon: " + ship.getCannon().getCannonName());
		lblMainCannonAtk.setText("Attack: +" + ship.getCannon().getAttackMod());
		lblMainSailName.setText("Sail: " + ship.getSail().getSailName());
		lblMainSailSpd.setText("Speed: +" + ship.getSail().getSpeedMod());
		lblMainHullName.setText("Hull: " + ship.getHull().getHullName());
		lblMainHullDef.setText("Defence: +" + ship.getHull().getDefenceMod());
		lblMainHP.setText("HP: " + ship.getHp() + "/" + ship.getMaxHp());
		progBarMainHP.setValue((ship.getHp() / ship.getMaxHp()) * 100);
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
		
		lblSelectName.setText(enemy.getName());
		lblSelectAttack.setText("Attack: " + enemy.getAttack());
		lblSelectDefence.setText("Defence: " + enemy.getDeffence());
		lblSelectSpeed.setText("Speed: " + enemy.getSpeed());
		lblSelectHp.setText("HP: " + enemy.getHp());
		lblSelectBooty.setText("Booty: " + enemy.getDrop());
	}
	
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
	
}//end class

