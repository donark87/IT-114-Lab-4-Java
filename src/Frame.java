/*
Name: Donark Patel (DP663)
Class: IS114-451
Professor: Maura Deek
Date: 11/12/2019
Information: This program create's a GUI for users to enter a value and index number. Value is added to a linkedList. 
*/
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Frame {

	private JFrame frame;
	private JTextField textFieldIndex;
	private JTextField textFieldValue;
	private JTextArea textArea;
	public int indexNumber;
	public String value;
	LinkedList<String> list = new LinkedList<String>();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
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
	public Frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 452, 434);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIndexNumber = new JLabel("Index number:");
		lblIndexNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIndexNumber.setBounds(35, 53, 106, 20);
		frame.getContentPane().add(lblIndexNumber);
		
		JLabel lblValue = new JLabel("Value:");
		lblValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValue.setBounds(96, 84, 45, 20);
		frame.getContentPane().add(lblValue);
		
		textFieldIndex = new JTextField();
		textFieldIndex.setBounds(147, 55, 86, 20);
		frame.getContentPane().add(textFieldIndex);
		textFieldIndex.setColumns(10);
		
		textFieldValue = new JTextField();
		textFieldValue.setColumns(10);
		textFieldValue.setBounds(147, 86, 86, 20);
		frame.getContentPane().add(textFieldValue);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 211, 354, 173);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setText("Log: \n");
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//textArea.setText("");
				value = textFieldValue.getText();
				ListIterator it=  list.listIterator();
				boolean found = false;
				while(it.hasNext()) {
					
					String temp = (String) it.next();
					int tempindex = it.nextIndex();
					if(!value.equals(temp))
					{
						textArea.append("\nValue " + value + " is not found at index " + (tempindex - 1));
						found = false;
					}
					else if(value.equals(temp)) {
						JOptionPane.showMessageDialog(null,"Found " + value + " at index " + (tempindex - 1));
						textArea.append("\nFound " + value + " at index " + (tempindex - 1));
						found = true;
						return;
						
					}
					
				}
				if(found == false) 
				{
					JOptionPane.showMessageDialog(null,value + " not found in the list");
				}
					
				textFieldValue.setText("");
				textFieldIndex.setText("");
				
			}
		});
		btnSearch.setBounds(151, 136, 106, 64);
		frame.getContentPane().add(btnSearch);
		
		
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String temp = textFieldIndex.getText();
				try
				{
					indexNumber = Integer.parseInt(temp);
					
				}
				catch (Exception E)
				{
					JOptionPane.showMessageDialog(null,"Invalid input: Please, enter a number in the index field");
					return;
				}
				
				 
				value = textFieldValue.getText();
				int size = list.size();
				
				
				
				if (indexNumber > size) 
				{
					while (indexNumber > size)
					{	
						String temp1 = null;
						list.add(size, temp1);
						size++;
					}
					list.add(indexNumber, value);
					textArea.append("\nAdd value \nIndex: " + indexNumber + "\nValue: " + value + "\nLinkedList Size: " + list.size()+ "\n---------------------------\n");
					
				}
				else if (indexNumber == size) 
				{
					list.add(indexNumber, value);
					textArea.append("\nAdd value \nIndex: " + indexNumber + "\nValue: " + value + "\nLinkedList Size: " + list.size()+"\n---------------------------\n");
				}
				else 
				{
				list.set(indexNumber, value);
				textArea.append("\nAdd value \nIndex: " + indexNumber + "\nValue: " + value + "\nLinkedList Size: " + list.size()+"\n---------------------------\n");
				}
				
				textFieldValue.setText("");
				textFieldIndex.setText("");		
			}
		});
		btnInsert.setBounds(35, 136, 106, 64);
		frame.getContentPane().add(btnInsert);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean found = false;
				String temp = textFieldIndex.getText();
				try
				{
					indexNumber = Integer.parseInt(temp);
					
				}
				catch (Exception E)
				{
					JOptionPane.showMessageDialog(null,"Invalid input: Please, enter a number in the index field");
					return;
				}
				
				String temp1 = null;
				if(indexNumber < list.size()) 
				{
				list.set(indexNumber, temp1);
				JOptionPane.showMessageDialog(null,"Value at index " + indexNumber + " has been deleted");
				textArea.append("\nValue at index " + indexNumber + " has been deleted\n");
					
				}
				else 
				{
					JOptionPane.showMessageDialog(null,"Index number " + indexNumber + " is greater than size of the list. So, the value cannot be deleted.");
					
				}
				
				textFieldValue.setText("");
				textFieldIndex.setText("");
			}
		});
		btnDelete.setBounds(267, 136, 106, 64);
		frame.getContentPane().add(btnDelete);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldValue.setText("");
				textFieldIndex.setText("");
				textArea.setText("");
				list.clear();
				JOptionPane.showMessageDialog(null,"Note: LinkedList data has been erased");
				
			}
		});
		btnClear.setBounds(267, 31, 108, 35);
		frame.getContentPane().add(btnClear);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(267, 79, 108, 35);
		frame.getContentPane().add(btnExit);
	}
}
