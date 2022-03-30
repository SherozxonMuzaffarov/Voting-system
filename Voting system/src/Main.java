import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SingleSelectionModel;

public class Main extends JFrame {

	int count1;
	int count2;
	int count3;
	int count4;

	JButton vote;

	JTextField field1;
	JTextField field2;
	JTextField field3;
	JTextField field4;

	public Main() throws HeadlessException {
		this.setSize(600, 600);
		this.setLayout(new GridLayout(3, 1, 10, 22));

		count1 = 0;
		count2 = 0;
		count3 = 0;

		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(4, 2, 3, 2));

		JRadioButton adolat = new JRadioButton("O'zbekiston Adolat Sotsial-Demokratik Partiyasi");
		JRadioButton milliy = new JRadioButton("O'zbekiston Milliy Tiklanish Demokratik Partiyasi");
		JRadioButton lib = new JRadioButton("O'zbekiston Liberal-Demokratik Partiyasi");
		JRadioButton xalq = new JRadioButton("O'zbekiston Xalq Demokratik Partiyasi");

		ButtonGroup bg = new ButtonGroup();
		bg.add(adolat);
		bg.add(milliy);
		bg.add(lib);
		bg.add(xalq);

		field1 = new JTextField("Adolat - " + String.valueOf(count1));
		field2 = new JTextField("Milliy Tiklanish - " + String.valueOf(count2));
		field3 = new JTextField("Liberal - " + String.valueOf(count3));
		field4 = new JTextField("Xalq - " + String.valueOf(count4));

		field1.setEditable(false);
		field2.setEditable(false);
		field3.setEditable(false);
		field4.setEditable(false);
		
		p1.add(adolat);
		p1.add(milliy);
		p1.add(lib);
		p1.add(xalq);

		p1.add(field1);
		p1.add(field2);
		p1.add(field3);
		p1.add(field4);

		hand1 h1 = new hand1();
		hand2 h2 = new hand2();
		hand3 h3 = new hand3();
		hand4 h4 = new hand4();

		adolat.addItemListener(h1);
		milliy.addItemListener(h2);
		lib.addItemListener(h3);
		xalq.addItemListener(h4);

		JLabel l = new JLabel(" <<< Click to choose the party >>>");
		Font f = new Font("Helvetika", Font.BOLD, 32);
		l.setFont(f);

		SingleAction sa = new SingleAction();
		vote = new JButton("VOTE");
		vote.setSize(50, 60);
		vote.setBackground(Color.red);
		vote.setOpaque(false);
		vote.addActionListener(sa);

		this.add(l);
		this.add(p1);
		this.add(vote);

		this.setVisible(true);
	}

	class hand1 implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				count1++;
			}

		}

	}

	class hand2 implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				++count2;
			}

		}

	}

	class hand3 implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				++count3;
			}

		}

	}

	class hand4 implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				++count4;
			}

		}

	}

	class SingleAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			field1.setText("ad:" + String.valueOf(count1));
			field2.setText("milliy:" + String.valueOf(count2));
			field3.setText("liberal:" + String.valueOf(count3));
			field4.setText("xalq:" + String.valueOf(count4));
		}
	}

	public static void main(String[] args) {
		new Main();
	}
}
