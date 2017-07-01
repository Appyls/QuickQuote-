package insurance;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.*;


public class GUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel cards; //container class of jlabels house1 and client
	private CardLayout cl;
	
	private JLabel house1;
	private JLabel client;
	
	private JTextField h_yearBuilt;
	private JCheckBox h_standard;
	private JCheckBox h_semi_custom;
	private JCheckBox h_custom;
	private JTextField h_numFloors;
	private JTextField h_squareFootage;
	private JTextField h_basementSize;
	private JCheckBox h_updated;
	private JTextField h_hasAlarm;
	
	private JTextField c_birthYear;
	private JTextField c_postalCode;
	private JTextField c_yearsClaimsFree;
	
	private JButton next;
	private JButton previous;
	private JButton allDone;
	
	private int yearBuilt;
	private String custom;
	private int numFloors;
	private int squareFootage;
	private int basementSize;
	private boolean updated;
	private String hasAlarm;
	private House house;
	
	private int birthYear;
	private String postalCode;
	private int yearsClaimsFree;
	
	private List<Company> list = new ArrayList<Company>(); 
	
	public GUI(){
		super("Insurance Helper Thing");
		cl = new CardLayout();
		
		JPanel firstPage = new JPanel();
		JPanel secondPage = new JPanel();
		firstPage.setLayout(new BoxLayout(firstPage, BoxLayout.Y_AXIS));
		secondPage.setLayout(new BoxLayout(secondPage, BoxLayout.Y_AXIS));
		
		house1 = new JLabel("Dwelling Information");
		client = new JLabel("Client Information");
		firstPage.add(house1);
		secondPage.add(client);
		
		h_yearBuilt = new JTextField("Enter the year dwelling was built");
		firstPage.add(h_yearBuilt);
		firstPage.add(Box.createRigidArea(new Dimension(0,50)));
		
		h_standard = new JCheckBox("Standard");
		h_semi_custom = new JCheckBox("Semi-Custom");
		h_custom = new JCheckBox("Custom");
		ButtonGroup bg = new ButtonGroup(); // adding checkbuttons to button group will ensure that only one can be selected at once.
		bg.add(h_standard);
		bg.add(h_semi_custom);
		bg.add(h_custom);
		firstPage.add(h_standard);
		firstPage.add(h_semi_custom);
		firstPage.add(h_custom);
			firstPage.add(Box.createRigidArea(new Dimension(0,50)));
		
		itemListener checkListener = new itemListener();
		h_standard.addItemListener(checkListener);
		h_semi_custom.addItemListener(checkListener);
		h_custom.addItemListener(checkListener);
		
		h_numFloors = new JTextField("Enter the number of floors, excluding basement");
		h_squareFootage = new JTextField("Enter the sqft, excluding basement");
		h_basementSize = new JTextField("Enter the basement sqft");
		h_updated = new JCheckBox("Updated in last 25 years?");
		h_updated.addItemListener(checkListener);
		h_hasAlarm = new JTextField("Enter alarm type: none, local, or monitored");
		
		firstPage.add(h_numFloors);
			firstPage.add(Box.createRigidArea(new Dimension(0,50)));
		firstPage.add(h_squareFootage);
			firstPage.add(Box.createRigidArea(new Dimension(0,50)));
		firstPage.add(h_basementSize);
			firstPage.add(Box.createRigidArea(new Dimension(0,50)));
		firstPage.add(h_updated);
			firstPage.add(Box.createRigidArea(new Dimension(0,50)));
		firstPage.add(h_hasAlarm);
			firstPage.add(Box.createRigidArea(new Dimension(0,50)));
		c_birthYear = new JTextField("Enter client's birthyear");
		c_postalCode = new JTextField("Enter the house's postal code (Format: XXX XXX)");
		c_yearsClaimsFree = new JTextField("Enter years client was claims free");
		secondPage.add(c_birthYear);
			secondPage.add(Box.createRigidArea(new Dimension(0,100)));
		secondPage.add(c_postalCode);
			secondPage.add(Box.createRigidArea(new Dimension(0,100)));
		secondPage.add(c_yearsClaimsFree);
			secondPage.add(Box.createRigidArea(new Dimension(0,200)));

		next = new JButton("Next");
		previous = new JButton("Previous");
		allDone = new JButton("Finished");
		
		JPanel buttons = new JPanel(); //container class for buttons previous, allDone
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
		buttons.add(previous);
			buttons.add(Box.createRigidArea(new Dimension(25,0)));
		buttons.add(allDone);
			buttons.add(Box.createRigidArea(new Dimension(960,0)));
		firstPage.add(next);
		secondPage.add(Box.createRigidArea(new Dimension(0,100)));
		secondPage.add(buttons);
		cards = new JPanel(); //container class of both tabs
		cards.setLayout(cl);
		cards.add(firstPage, "Dwelling Information");
		cards.add(secondPage, "Client Information");
		cl.show(cards, "Dwelling Information");
		
		changeFont(firstPage, new Font("Times New Roman", Font.BOLD, 25));
		changeFont(secondPage, new Font("Times New Roman", Font.BOLD, 25));
		
		
		next.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				cl.show(cards, "Client Information");
			}
		});
		
		previous.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				cl.show(cards, "Dwelling Information");
			}
		});
		
		allDone.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				yearBuilt = Integer.parseInt(h_yearBuilt.getText());
				numFloors = Integer.parseInt(h_numFloors.getText());
				squareFootage = Integer.parseInt(h_squareFootage.getText());
				basementSize = Integer.parseInt(h_basementSize.getText());
				hasAlarm = h_hasAlarm.getText();
				house = new House(yearBuilt, custom, numFloors, squareFootage, basementSize, hasAlarm, updated);
				
				birthYear = Integer.parseInt(c_birthYear.getText());
				postalCode = c_postalCode.getText();
				yearsClaimsFree = Integer.parseInt(c_yearsClaimsFree.getText());
				
				Company intact = new Intact(birthYear, postalCode, yearsClaimsFree, house);
				Company wawanesa = new Wawanesa(birthYear, postalCode, yearsClaimsFree, house);
				Company gore = new Gore(birthYear, postalCode, yearsClaimsFree, house);
				Company family = new Family(birthYear, postalCode, yearsClaimsFree, house);
				
				list.add(intact); 
				list.add(wawanesa);
				list.add(gore);
				list.add(family);
				
				Collections.sort(list);
				Collections.reverse(list);
				
				resultsWindow window = new resultsWindow();
				window.setSize(1280, 720);
			}
		});
		
		add(cards);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public static void changeFont ( Component component, Font font ) //method that changes the font of each container class or JPanel
	{
	    component.setFont ( font );
	    if ( component instanceof Container )
	    {
	        for ( Component child : ( ( Container ) component ).getComponents () )
	        {
	            changeFont ( child, font );
	        }
	    }
	}
	// the itemListener class describes the ItemListener behaviour of the check boxes custom, semi-custom, standard & updated
	private class itemListener implements ItemListener{

		public void itemStateChanged(ItemEvent event) {
			if (h_custom.isSelected())
				custom = "custom";
			
			else if (h_semi_custom.isSelected())
				custom = "semi-custom";
			
			else if (h_standard.isSelected())
				custom = "standard";
			
			if (h_updated.isSelected()){
				updated = true;
			}
			else if (!h_updated.isSelected())
				updated= false;
		}
	}
	
	//the resultsWindow class is a separate component of the GUI, will open upon call from the allDone button
	private class resultsWindow extends JFrame{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		JPanel first;
		JPanel second;
		JPanel third;
		JPanel fourth;
		
		public resultsWindow(){
			super("The Results!");
			setLayout(new FlowLayout());
			
			first = new JPanel();
			first.setLayout(new BoxLayout(first, BoxLayout.Y_AXIS));
			second = new JPanel();
			second.setLayout(new BoxLayout(second, BoxLayout.Y_AXIS));
			third = new JPanel();
			third.setLayout(new BoxLayout(third, BoxLayout.Y_AXIS));
			fourth = new JPanel();
			fourth.setLayout(new BoxLayout(fourth, BoxLayout.Y_AXIS));
			
			Company company = list.get(0);
			JLabel jl1 = new JLabel(company.getName());
			first.add(jl1);
			for (String x: company.discountList){
				jl1 = new JLabel(x);
				first.add(jl1);
			}
			
			company = list.get(1);
			JLabel jl2 = new JLabel(company.getName());
			second.add(jl2);
			for (String x: company.discountList){
				jl2 = new JLabel(x);
				second.add(jl2);
			}
			
			company = list.get(2);
			JLabel jl3 = new JLabel(company.getName());
			third.add(jl3);
			for (String x: company.discountList){
				jl3 = new JLabel(x);
				third.add(jl3);
			}
			
			company = list.get(3);
			JLabel jl4 = new JLabel(company.getName());
			fourth.add(jl4);
			for (String x: company.discountList){
				jl4 = new JLabel(x);
				fourth.add(jl4);
			}
			
			add(first);
			add(second);
			add(third);
			add(fourth);
			changeFont(first, new Font("Times New Roman", Font.BOLD, 20));
			changeFont(second, new Font("Times New Roman", Font.BOLD, 20));
			changeFont(third, new Font("Times New Roman", Font.BOLD, 20));
			changeFont(fourth, new Font("Times New Roman", Font.BOLD, 20));
			
			setVisible(true);
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	
	public static void main(String[] args){
		GUI gui = new GUI();
		gui.setVisible(true);
		gui.setSize(1280, 850);
	}
}
