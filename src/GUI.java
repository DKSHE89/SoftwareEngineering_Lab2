import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GUI extends JFrame {

	controller ctrl = new controller();
	private final static String newline = "\n";// switch to a next row in a
												// textarea

	FlowLayout fLayout;
	JPanel mypanel, mypanelLeft, mypanelRight, mypanelBottom;

	JTextField inpCardNumber, outpTotalMoney, outpChange;
	JTextArea outpTotalPrice, outpInfoMessage;
	JButton btnColaPlus, btnColaMinus, btnSpritePlus, btnSpriteMinus,
			btnLightBeerPlus, btnLightBeerMinus, btnMineralWaterPlus,
			btnMineralWaterMinus, btnAppleJuicePlus, btnAppleJuiceMinus,
			btnFunBeerPlus, btnFunBeerMinus, btnOrangeJuicePlus,
			btnOrangeJuiceMinus, btnTomatoJuicePlus, btnTomatoJuiceMinus,
			btnWinePlus, btnWineMinus, btnBeerPlus, btnBeerMinus, btnPayCash,
			btnPayCard, btnReset,btn10cent, btn20cent, btn50cent, btn1euro, btn2euro,
			btn5euro, btn10euro, btn20euro;
	JLabel labelCardReader, labelChange, labelInsertMoney, labelInfoMessage,
			labelTotalOrder;
	ImageIcon beer, funBeer, lightBeer, sprite, cola, wine, mineralWater,
			orangeJuice, tomatoJuice, appleJuice;

	public boolean btnColaPlusPushed = false, btnColaMinusPushed = false,
			btnSpritePlusPushed = false, btnSpriteMinusPushed = false,
			btnLightBeerPlusPushed = false, btnLightBeerMinusPushed = false,
			btnMineralWaterPlusPushed = false,
			btnMineralWaterMinusPushed = false,
			btnAppleJuicePlusPushed = false, btnAppleJuiceMinusPushed = false,
			btnFunBeerPlusPushed = false, btnFunBeerMinusPushed = false,
			btnOrangeJuicePlusPushed = false,
			btnOrangeJuiceMinusPushed = false,
			btnTomatoJuicePlusPushed = false,
			btnTomatoJuiceMinusPushed = false, btnWineMinusPushed = false,
			btnWinePlusPushed = false, btnBeerPlusPushed = false,
			btnBeerMinusPushed = false;

	public GUI() {
		// Window settings
		/*
		 * Toolkit tk = Toolkit.getDefaultToolkit(); int xSize = ((int)
		 * tk.getScreenSize().getWidth()); int ySize = ((int)
		 * tk.getScreenSize().getHeight()); this.setSize(xSize,ySize);
		 */
		// User
		mypanel = new JPanel();
		mypanelLeft = new JPanel();
		mypanelRight = new JPanel();
		mypanelBottom = new JPanel();
		labelCardReader = new JLabel("Enter your card's number"); // mylabel1
		labelCardReader.setFont(new Font("Courier New", Font.BOLD, 16));
		labelChange = new JLabel("Get your change"); // mylabel3
		labelChange.setFont(new Font("Courier New", Font.BOLD, 18));
		labelInsertMoney = new JLabel("Insert money"); // mylabel4
		labelInsertMoney.setFont(new Font("Courier New", Font.BOLD, 16));
		labelInfoMessage = new JLabel("Info Message"); // mylabel4
		labelInfoMessage.setFont(new Font("Courier New", Font.BOLD, 16));
		labelTotalOrder = new JLabel("Your Total Order Is"); // mylabel4
		labelTotalOrder.setFont(new Font("Courier New", Font.BOLD, 16));

		btnColaPlus = new JButton("+");
		btnColaMinus = new JButton("-");
		btnSpritePlus = new JButton("+");
		btnSpriteMinus = new JButton("-");
		btnLightBeerPlus = new JButton("+");
		btnLightBeerMinus = new JButton("-");
		btnMineralWaterPlus = new JButton("+");
		btnMineralWaterMinus = new JButton("-");
		btnBeerPlus = new JButton("+");
		btnBeerMinus = new JButton("-");
		btnFunBeerPlus = new JButton("+");
		btnFunBeerMinus = new JButton("-");
		btnWinePlus = new JButton("+");
		btnWineMinus = new JButton("-");
		btnOrangeJuicePlus = new JButton("+");
		btnOrangeJuiceMinus = new JButton("-");
		btnTomatoJuicePlus = new JButton("+");
		btnTomatoJuiceMinus = new JButton("-");
		btnAppleJuicePlus = new JButton("+");
		btnAppleJuiceMinus = new JButton("-");

		btnPayCash = new JButton("Pay in cash");
		btnPayCard = new JButton("Pay by card");
		btnReset=new JButton("Reset");

		btn10cent = new JButton("10 cents");
		btn20cent = new JButton("20 cents");
		btn50cent = new JButton("50 cents");
		btn1euro = new JButton("1 euro");
		btn2euro = new JButton("2 euro");
		btn5euro = new JButton("5 euro");
		btn10euro = new JButton("10 euro");
		btn20euro = new JButton("20 euro");

		outpTotalPrice = new JTextArea("Total price: 00.00 Ђ");
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		outpTotalPrice.setBorder(border);
		outpTotalPrice.setPreferredSize(new Dimension(50, 50));
		outpTotalMoney = new JTextField();
		outpChange = new JTextField();
		outpChange.setPreferredSize(new Dimension(100, 20));
		outpInfoMessage = new JTextArea();
		outpInfoMessage.setBorder(border);
		outpInfoMessage.setPreferredSize(new Dimension(320, 40));
		inpCardNumber = new JTextField();
		

		beer = new ImageIcon("beer.jpg");
		JLabel lbeer = new JLabel(beer);
		lightBeer = new ImageIcon("lightBeer.jpg");
		JLabel llightBeer = new JLabel(lightBeer);
		funBeer = new ImageIcon("funBeer.jpg");
		JLabel lfunBeer = new JLabel(funBeer);
		cola = new ImageIcon("cola.jpg");
		JLabel lcola = new JLabel(cola);
		sprite = new ImageIcon("sprite.jpg");
		JLabel lsprite = new JLabel(sprite);
		mineralWater = new ImageIcon("mineralWater.jpg");
		JLabel lmineralWater = new JLabel(mineralWater);
		wine = new ImageIcon("wine.jpg");
		JLabel lwine = new JLabel(wine);
		tomatoJuice = new ImageIcon("tomatoJuice.jpg");
		JLabel ltomatoJuice = new JLabel(tomatoJuice);
		orangeJuice = new ImageIcon("orangeJuice.jpg");
		JLabel lorangeJuice = new JLabel(orangeJuice);
		appleJuice = new ImageIcon("appleJuice.jpg");
		JLabel lappleJuice = new JLabel(appleJuice);

		mypanelLeft.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets.right = 0;
		c.insets.bottom = 0;
		c.weightx = 1;
		c.weighty = 0.5;

		// 1st line
		c.gridx = 0;
		c.gridy = 0;
		mypanelLeft.add(lcola, c);
		c.gridx = 1;
		c.gridy = 0;
		mypanelLeft.add(lsprite, c);
		c.gridx = 2;
		c.gridy = 0;
		mypanelLeft.add(lmineralWater, c);
		c.gridx = 3;
		c.gridy = 0;
		mypanelLeft.add(lorangeJuice, c);
		c.gridx = 4;
		c.gridy = 0;
		mypanelLeft.add(lappleJuice, c);
		// 2nd line
		JPanel colaPanel = new JPanel();
		colaPanel.add(btnColaPlus);
		colaPanel.add(btnColaMinus);
		JPanel spritePanel = new JPanel();
		spritePanel.add(btnSpritePlus);
		spritePanel.add(btnSpriteMinus);
		JPanel orangeJuicePanel = new JPanel();
		orangeJuicePanel.add(btnOrangeJuicePlus);
		orangeJuicePanel.add(btnOrangeJuiceMinus);
		JPanel tomatoJuicePanel = new JPanel();
		tomatoJuicePanel.add(btnTomatoJuicePlus);
		tomatoJuicePanel.add(btnTomatoJuiceMinus);
		JPanel appleJuicePanel = new JPanel();
		appleJuicePanel.add(btnAppleJuicePlus);
		appleJuicePanel.add(btnAppleJuiceMinus);
		JPanel mineralWaterPanel = new JPanel();
		mineralWaterPanel.add(btnMineralWaterPlus);
		mineralWaterPanel.add(btnMineralWaterMinus);
		JPanel winePanel = new JPanel();
		winePanel.add(btnWinePlus);
		winePanel.add(btnWineMinus);
		JPanel beerPanel = new JPanel();
		beerPanel.add(btnBeerPlus);
		beerPanel.add(btnBeerMinus);
		JPanel lightBeerPanel = new JPanel();
		lightBeerPanel.add(btnLightBeerPlus);
		lightBeerPanel.add(btnLightBeerMinus);
		JPanel funBeerPanel = new JPanel();
		funBeerPanel.add(btnFunBeerPlus);
		funBeerPanel.add(btnFunBeerMinus);

		c.gridx = 0;
		c.gridy = 1;
		mypanelLeft.add(colaPanel, c);
		c.gridx = 1;
		c.gridy = 1;
		mypanelLeft.add(spritePanel, c);
		c.gridx = 2;
		c.gridy = 1;
		mypanelLeft.add(mineralWaterPanel, c);
		c.gridx = 3;
		c.gridy = 1;
		mypanelLeft.add(orangeJuicePanel, c);
		c.gridx = 4;
		c.gridy = 1;
		mypanelLeft.add(appleJuicePanel, c);
		// 3rd line
		c.gridx = 0;
		c.gridy = 2;
		mypanelLeft.add(ltomatoJuice, c);
		c.gridx = 1;
		c.gridy = 2;
		mypanelLeft.add(lbeer, c);
		c.gridx = 2;
		c.gridy = 2;
		mypanelLeft.add(lfunBeer, c);
		c.gridx = 3;
		c.gridy = 2;
		mypanelLeft.add(llightBeer, c);
		c.gridx = 4;
		c.gridy = 2;
		mypanelLeft.add(lwine, c);
		// 4th line
		c.gridx = 0;
		c.gridy = 3;
		mypanelLeft.add(tomatoJuicePanel, c);
		c.gridx = 1;
		c.gridy = 3;
		mypanelLeft.add(beerPanel, c);
		c.gridx = 2;
		c.gridy = 3;
		mypanelLeft.add(funBeerPanel, c);
		c.gridx = 3;
		c.gridy = 3;
		mypanelLeft.add(lightBeerPanel, c);
		c.gridx = 4;
		c.gridy = 3;
		mypanelLeft.add(winePanel, c);
		// 5th line
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 4;
		mypanelLeft.add(labelTotalOrder, c);
		c.gridwidth = 2;
		c.gridx = 2;
		c.gridy = 4;
		mypanelLeft.add(outpTotalPrice, c);

		GroupLayout bottomLayout = new GroupLayout(mypanelBottom);
		;
		bottomLayout.setHorizontalGroup(bottomLayout.createSequentialGroup()
				.addComponent(labelInfoMessage).addComponent(outpInfoMessage));
		bottomLayout.setVerticalGroup(bottomLayout.createSequentialGroup()
				.addGroup(
						bottomLayout.createParallelGroup()
								.addComponent(labelInfoMessage)
								.addComponent(outpInfoMessage)));

		mypanelRight.setLayout(new GridBagLayout());
		GridBagConstraints c1 = new GridBagConstraints();
		c1.fill = GridBagConstraints.HORIZONTAL;
		c1.weightx = 1;
		c1.weighty = 5;
		c1.insets.right = 1;
		c1.insets.left = 1;
		JPanel moneyPanel = new JPanel();
		GroupLayout layout = new GroupLayout(moneyPanel);
		moneyPanel.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createSequentialGroup()
				.addGroup(
						layout.createParallelGroup()
								.addComponent(labelCardReader))
				.addGroup(
						layout.createParallelGroup()
								.addComponent(inpCardNumber)
								.addGroup(
										layout.createSequentialGroup()
												.addGroup(
														layout.createParallelGroup(
																GroupLayout.Alignment.LEADING)
																.addComponent(
																		btn10cent)
																.addComponent(
																		btn50cent)
																.addComponent(
																		btn2euro)
																.addComponent(
																		btn10euro))
												.addGroup(
														layout.createParallelGroup(
																GroupLayout.Alignment.LEADING)
																.addComponent(
																		btn20cent)
																.addComponent(
																		btn1euro)
																.addComponent(
																		btn5euro)
																.addComponent(
																		btn20euro))))
				.addGroup(
						layout.createParallelGroup()
								.addComponent(btnPayCard)
								.addGap(10)
								.addComponent(btnReset)));
		layout.linkSize(SwingConstants.HORIZONTAL, btn10cent, btn20cent,
				btn50cent, btn1euro, btn2euro, btn5euro, btn10euro, btn20euro);

		layout.setVerticalGroup(layout
				.createSequentialGroup()
				.addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.BASELINE)
								.addComponent(labelCardReader)
								.addComponent(inpCardNumber)
								.addComponent(btnPayCard))

				.addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.BASELINE)
							
						.addGroup(
								layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(btn10cent)
												.addComponent(btn20cent))
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(btn50cent)
												.addComponent(btn1euro))
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(btn2euro)
												.addComponent(btn5euro))
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(btn10euro)
												.addComponent(btn20euro)))
						)
					.addGap(10)
					.addComponent(btnReset)
			);
		c1.gridy = 0;
		mypanelRight.add(moneyPanel, c1);
		// 2nd line
		JPanel changePanel = new JPanel();
		GroupLayout changeLayout = new GroupLayout(changePanel);
		;
		changeLayout.setHorizontalGroup(changeLayout.createSequentialGroup()
				.addComponent(labelChange).addComponent(outpChange));
		changeLayout.setVerticalGroup(changeLayout.createParallelGroup()
				.addComponent(labelChange).addComponent(outpChange));
		// c1.gridwidth=3;
		c1.gridy = 1;
		mypanelRight.add(changePanel, c1);

		// creating listeners
		ResetButtonListener reset=new ResetButtonListener();
		BeerPlusButtonListener beerpL = new BeerPlusButtonListener();
		BeerMinusButtonListener beermL = new BeerMinusButtonListener();
		LightBeerPlusButtonListener lbeerpL = new LightBeerPlusButtonListener();
		LightBeerMinusButtonListener lbeermL = new LightBeerMinusButtonListener();
		FunBeerPlusButtonListener fbeerpL = new FunBeerPlusButtonListener();
		FunBeerMinusButtonListener fbeermL = new FunBeerMinusButtonListener();
		WinePlusButtonListener winepL = new WinePlusButtonListener();
		WineMinusButtonListener winemL = new WineMinusButtonListener();
		ColaPlusButtonListener colapL = new ColaPlusButtonListener();
		ColaMinusButtonListener colamL = new ColaMinusButtonListener();
		SpritePlusButtonListener spritepL = new SpritePlusButtonListener();
		SpriteMinusButtonListener spritemL = new SpriteMinusButtonListener();
		MineralWaterPlusButtonListener waterpL = new MineralWaterPlusButtonListener();
		MineralWaterMinusButtonListener watermL = new MineralWaterMinusButtonListener();
		OrangeJuicePlusButtonListener orange_juicepL = new OrangeJuicePlusButtonListener();
		OrangeJuiceMinusButtonListener orange_juicemL = new OrangeJuiceMinusButtonListener();
		TomatoJuicePlusButtonListener tomato_juicepL = new TomatoJuicePlusButtonListener();
		TomatoJuiceMinusButtonListener tomato_juicemL = new TomatoJuiceMinusButtonListener();
		AppleJuicePlusButtonListener apple_juicepL = new AppleJuicePlusButtonListener();
		AppleJuiceMinusButtonListener apple_juicemL = new AppleJuiceMinusButtonListener();

		PayCashButtonListener cashL = new PayCashButtonListener();
		PayCardButtonListener cardL = new PayCardButtonListener();

		tenCentButtonListener tenCentL = new tenCentButtonListener();
		twentyCentButtonListener twentyCentL = new twentyCentButtonListener();
		fiftyCentButtonListener fiftyCentL = new fiftyCentButtonListener();
		oneEuroButtonListener oneEuroL = new oneEuroButtonListener();
		twoEuroButtonListener twoEuroL = new twoEuroButtonListener();
		fiveEuroButtonListener fiveEuroL = new fiveEuroButtonListener();
		tenEuroButtonListener tenEuroL = new tenEuroButtonListener();
		twentyEuroButtonListener twentyEuroL = new twentyEuroButtonListener();

		mypanel.setLayout(new BorderLayout());
		mypanel.add(mypanelBottom, BorderLayout.PAGE_END);
		mypanel.add(mypanelLeft, BorderLayout.WEST);
		mypanel.add(mypanelRight, BorderLayout.CENTER);
		this.add(mypanel);

		// add ActionListeners
		btnReset.addActionListener(reset);
		btnBeerPlus.addActionListener(beerpL);
		btnBeerMinus.addActionListener(beermL);
		btnLightBeerPlus.addActionListener(lbeerpL);
		btnLightBeerMinus.addActionListener(lbeermL);
		btnFunBeerPlus.addActionListener(fbeerpL);
		btnFunBeerMinus.addActionListener(fbeermL);
		btnWinePlus.addActionListener(winepL);
		btnWineMinus.addActionListener(winemL);
		btnColaPlus.addActionListener(colapL);
		btnColaMinus.addActionListener(colamL);
		btnSpritePlus.addActionListener(spritepL);
		btnSpriteMinus.addActionListener(spritemL);
		btnMineralWaterPlus.addActionListener(waterpL);
		btnMineralWaterMinus.addActionListener(watermL);
		btnOrangeJuicePlus.addActionListener(orange_juicepL);
		btnOrangeJuiceMinus.addActionListener(orange_juicemL);
		btnAppleJuicePlus.addActionListener(apple_juicepL);
		btnAppleJuiceMinus.addActionListener(apple_juicemL);
		btnTomatoJuicePlus.addActionListener(tomato_juicepL);
		btnTomatoJuiceMinus.addActionListener(tomato_juicemL);
		btnPayCash.addActionListener(cashL);
		btnPayCard.addActionListener(cardL);
		btn10cent.addActionListener(tenCentL);
		btn20cent.addActionListener(twentyCentL);
		btn50cent.addActionListener(fiftyCentL);
		btn1euro.addActionListener(oneEuroL);
		btn2euro.addActionListener(twoEuroL);
		btn5euro.addActionListener(fiveEuroL);
		btn10euro.addActionListener(tenEuroL);
		btn20euro.addActionListener(twentyEuroL);

	}
	private class ResetButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			/////ZDESYA PISAT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			}
	}
	private class BeerPlusButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			ctrl.chooseDrink("Beer");
			outpTotalPrice.setText("Total price: "+Integer.toString(ctrl.getTotal()));
		}
	}

	private class BeerMinusButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			ctrl.removeDrink("Beer");
			outpTotalPrice.setText("Total price: "+Integer.toString(ctrl.getTotal()));
		}
	}

	private class FunBeerPlusButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			ctrl.chooseDrink("FunBeer");
			outpTotalPrice.setText("Total price: "+Integer.toString(ctrl.getTotal()));
		}
	}

	private class FunBeerMinusButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			ctrl.removeDrink("FunBeer");
			outpTotalPrice.setText("Total price: "+Integer.toString(ctrl.getTotal()));
			
		}
	}

	private class LightBeerPlusButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			ctrl.chooseDrink("LightBeer");
			outpTotalPrice.setText("Total price: "+Integer.toString(ctrl.getTotal()));
		}
	}

	private class LightBeerMinusButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			ctrl.removeDrink("LightBeer");
			outpTotalPrice.setText("Total price: "+Integer.toString(ctrl.getTotal()));
			
		}
	}

	private class ColaPlusButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			ctrl.chooseDrink("Coke");
			outpTotalPrice.setText("Total price: "+Integer.toString(ctrl.getTotal()));
		}
	}

	private class ColaMinusButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			ctrl.removeDrink("Coke");
			outpTotalPrice.setText("Total price: "+Integer.toString(ctrl.getTotal()));
		}
	}

	private class SpritePlusButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			ctrl.chooseDrink("Sprite");
			outpTotalPrice.setText("Total price: "+Integer.toString(ctrl.getTotal()));
			
		}
	}

	private class SpriteMinusButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			ctrl.removeDrink("Sprite");
			outpTotalPrice.setText("Total price: "+Integer.toString(ctrl.getTotal()));
			
		}
	}

	private class WinePlusButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			ctrl.chooseDrink("Wine");
			outpTotalPrice.setText("Total price: "+Integer.toString(ctrl.getTotal()));
			
		}
	}

	private class WineMinusButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			ctrl.removeDrink("Wine");
			outpTotalPrice.setText("Total price: "+Integer.toString(ctrl.getTotal()));
			
		}
	}

	private class MineralWaterPlusButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			ctrl.chooseDrink("MineralWater");
			outpTotalPrice.setText("Total price: "+Integer.toString(ctrl.getTotal()));
			
		}
	}

	private class MineralWaterMinusButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			ctrl.removeDrink("MineralWater");
			outpTotalPrice.setText("Total price: "+Integer.toString(ctrl.getTotal()));
			
		}
	}

	private class AppleJuicePlusButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			ctrl.chooseDrink("AppleJuice");
			outpTotalPrice.setText("Total price: "+Integer.toString(ctrl.getTotal()));
			
		}
	}

	private class AppleJuiceMinusButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			ctrl.removeDrink("AppleJuice");
			outpTotalPrice.setText("Total price: "+Integer.toString(ctrl.getTotal()));
			
		}
	}

	private class OrangeJuicePlusButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			ctrl.chooseDrink("OrangeJuice");
			outpTotalPrice.setText("Total price: "+Integer.toString(ctrl.getTotal()));
			
		}
	}

	private class OrangeJuiceMinusButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			ctrl.removeDrink("OrangeJuice");
			outpTotalPrice.setText("Total price: "+Integer.toString(ctrl.getTotal()));
		}
	}

	private class TomatoJuicePlusButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			ctrl.chooseDrink("TomatoJuice");
			outpTotalPrice.setText("Total price: "+Integer.toString(ctrl.getTotal()));
		}
	}

	private class TomatoJuiceMinusButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			ctrl.removeDrink("TomatoJuice");
			outpTotalPrice.setText("Total price: "+Integer.toString(ctrl.getTotal()));
		}
	}

	private class PayCashButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			/*if (ctrl.giveChange() > 0)
				outpChange.setText(Double.toString(ctrl.giveChange()) + " cents");
			if (ctrl.giveChange() < 0)
				outpInfoMessage.setText("Not enough money!");*/
		}
	}

	private class PayCardButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			String file = inpCardNumber.getText();
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(new File("src/"+file+".txt")));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ctrl.discardFromCard(br);
			
			
			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(new File("src/"+file+".txt")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ctrl.putOnCard(bw);
			
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			outpInfoMessage.setText(ctrl.getcardMessage());
			outpChange.setText(" ");

		}
	}

	private class tenCentButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			ctrl.addCash(10);
			outpInfoMessage.setText(ctrl.getDifference());
			outpChange.setText(ctrl.getChangeMessage());
		}
	}

	private class twentyCentButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			ctrl.addCash(20);
			outpInfoMessage.setText(ctrl.getDifference());
			outpChange.setText(ctrl.getChangeMessage());
		}
	}

	private class fiftyCentButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			ctrl.addCash(50);
			outpInfoMessage.setText(ctrl.getDifference());
			outpChange.setText(ctrl.getChangeMessage());
		}
	}

	private class oneEuroButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			ctrl.addCash(100);
			outpInfoMessage.setText(ctrl.getDifference());
			outpChange.setText(ctrl.getChangeMessage());
		}
	}

	private class twoEuroButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			ctrl.addCash(200);
			outpInfoMessage.setText(ctrl.getDifference());
			outpChange.setText(ctrl.getChangeMessage());
		}
	}

	private class fiveEuroButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			ctrl.addCash(500);
			outpInfoMessage.setText(ctrl.getDifference());
			outpChange.setText(ctrl.getChangeMessage());
		}
	}

	private class tenEuroButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			ctrl.addCash(1000);
			outpInfoMessage.setText(ctrl.getDifference());
			outpChange.setText(ctrl.getChangeMessage());
		}
	}

	private class twentyEuroButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			ctrl.addCash(2000);
			outpInfoMessage.setText(ctrl.getDifference());
			outpChange.setText(ctrl.getChangeMessage());
		}
	}

	public static void main(String[] args) {
		GUI obj = new GUI();
		obj.setTitle("Drink despencer");
		obj.setSize(1000, 700);
		obj.setDefaultCloseOperation(EXIT_ON_CLOSE);
		obj.setVisible(true);
	}
}