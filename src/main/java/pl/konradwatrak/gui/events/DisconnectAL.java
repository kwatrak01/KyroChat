package pl.konradwatrak.gui.events;

import pl.konradwatrak.Main;
import pl.konradwatrak.net.ClientHandler;
import pl.konradwatrak.net.ServerHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisconnectAL implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Main.isHost) {
            ServerHandler.close();
        } else {
            ClientHandler.close();
        }
        Main.gui.btnDisconnect.setEnabled(false);
        Main.gui.btnHost.setEnabled(true);
        Main.gui.btnClient.setEnabled(true);
    }
}
