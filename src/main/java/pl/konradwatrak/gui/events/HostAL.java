package pl.konradwatrak.gui.events;

import pl.konradwatrak.Main;
import pl.konradwatrak.net.ServerHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HostAL implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Main.gui.btnDisconnect.setEnabled(true);
        ServerHandler.start();
        Main.isHost = true;
    }
}
