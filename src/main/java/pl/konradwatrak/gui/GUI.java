package pl.konradwatrak.gui;

import pl.konradwatrak.gui.events.ClientAL;
import pl.konradwatrak.gui.events.DisconnectAL;
import pl.konradwatrak.gui.events.HostAL;
import pl.konradwatrak.gui.events.SendAL;

import javax.swing.*;
import java.awt.*;

public class GUI {

    JFrame frame;
    JPanel content;
    JScrollPane jsp;

    public Button btnHost, btnClient, btnSend, btnDisconnect;
    public JTextField tfInput, tfName, tfIP;
    public JTextArea taChat;

    int width = 435, height = 580;

    public void draw() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        frame = new JFrame("KyroChat");
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        content = new JPanel();
        content.setBounds(0,0,width, height);
        content.setLayout(null);

        btnHost = new Button("Host");
        btnHost.setBounds(10, 10, 100, 25);
        btnHost.setVisible(true);
        btnHost.addActionListener(new HostAL());
        content.add(btnHost);

        btnClient = new Button("Client");
        btnClient.setBounds(120, 10, 100, 25);
        btnClient.setVisible(true);
        btnClient.addActionListener(new ClientAL());
        content.add(btnClient);

        JLabel lblName = new JLabel("Nick:");
        lblName.setBounds(10, 485, 50, 25);
        content.add(lblName);

        tfName = new JTextField();
        tfName.setBounds(10, 510, 80, 25);
        tfName.setVisible(true);
        content.add(tfName);

        JLabel lblIP = new JLabel("Server IP:");
        lblIP.setBounds(100, 485, 200, 25);
        content.add(lblIP);

        tfIP = new JTextField();
        tfIP.setBounds(100, 510, 150, 25);
        tfIP.setVisible(true);
        content.add(tfIP);

        tfInput = new JTextField();
        tfInput.setBounds(10, 45, 400, 25);
        tfInput.setVisible(true);
        content.add(tfInput);

        btnSend = new Button("Send");
        btnSend.setBounds(310, 10, 100, 25);
        btnSend.setVisible(true);
        btnSend.addActionListener(new SendAL());
        content.add(btnSend);

        btnDisconnect = new Button("Disconnect");
        btnDisconnect.setBounds(310, 510, 100, 25);
        btnDisconnect.setVisible(true);
        btnDisconnect.setEnabled(false);
        btnDisconnect.addActionListener(new DisconnectAL());
        content.add(btnDisconnect);

        taChat = new JTextArea();
        taChat.setVisible(true);

        jsp = new JScrollPane(taChat);
        jsp.setBounds(10, 80, 400, 400);
        jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        content.add(jsp);

        frame.setContentPane(content);
        frame.setVisible(true);
    }
}
