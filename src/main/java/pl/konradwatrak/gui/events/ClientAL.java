package pl.konradwatrak.gui.events;

import pl.konradwatrak.Main;
import pl.konradwatrak.net.ClientHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientAL implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!Main.gui.tfIP.getText().isEmpty()) {
            ClientHandler.ip = Main.gui.tfIP.getText();
        }
        ClientHandler.start();
        Main.isHost = false;
    }
}
