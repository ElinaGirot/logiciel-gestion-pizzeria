package view;
import java.awt.*;
import javax.swing.*;
import controller.*;

public class UINewClient extends JFrame{
    private JLabel label;
    private JTextField num;
    private JComboBox<String> pizzeria;
    private JButton btn;
    public UINewClient(){
        JPanel panel = new JPanel();
        label = new JLabel("Rentrez votre numéro de téléphone et choisissez votre Pizzeria");
        label.setHorizontalAlignment(JLabel.CENTER);
        num = new JTextField("Votre numéro");
        pizzeria = new JComboBox<String>();

        for (int i=0;i<MainProg.listPizzerias.capacity();i++){
            pizzeria.addItem(MainProg.listPizzerias.get(i).getNom());
        }
        btn = new JButton("Validez");
        CreateClient create = new CreateClient(num,btn,pizzeria,this);
        btn.addActionListener(create);

        panel.add(label);
        panel.add(num);
        panel.add(pizzeria);
        panel.add(btn);

        panel.setLayout(new GridLayout(4,1));
        this.add(panel);

        this.pack();
        this.setVisible(true);
    }
    public void update(){}
}
