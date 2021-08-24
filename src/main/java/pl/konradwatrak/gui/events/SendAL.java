package pl.konradwatrak.gui.events;

import pl.konradwatrak.Main;
import pl.konradwatrak.net.ClientHandler;
import pl.konradwatrak.net.data.Message;
import pl.konradwatrak.net.ServerHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

public class SendAL implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Main.isConnected) {
            Message m = new Message(Main.gui.tfName.getText(), Main.gui.tfInput.getText());
            m.setTimeStamp(LocalTime.now());
            if (Main.isHost) {
                ServerHandler.send(m);
            } else {
                ClientHandler.send(m);
            }
            Main.gui.tfIP.setText("");
        }
    }
}
