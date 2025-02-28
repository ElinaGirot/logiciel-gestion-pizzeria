package view;

import java.awt.*;
import javax.swing.*;
import controller.*;

public class UIBienvenue extends JFrame {
	private JLabel bonjour;
	private JButton commander = new JButton("Commander");
	private int etat;

	public UIBienvenue() {
		bonjour = new JLabel(" Bonjour, avez-vous envie d'une pizza ?");

		JPanel op = new JPanel();
		op.setLayout(new GridLayout(2, 1));
		op.add(commander);

		bonjour.setHorizontalAlignment(JLabel.CENTER);

		this.getContentPane().setLayout(new GridLayout(2, 1));
		this.getContentPane().add(bonjour);
		this.getContentPane().add(op);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(400, 400);

		etat = 0;

		Bienvenue bvn = new Bienvenue(commander, this);
		commander.addActionListener(bvn);
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int b) {
		etat = b;
	}
}
