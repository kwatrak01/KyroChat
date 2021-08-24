package pl.konradwatrak.net;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import pl.konradwatrak.Main;
import pl.konradwatrak.net.helpers.Register;
import pl.konradwatrak.net.data.Message;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ClientHandler extends Listener {

    static Client client;
    static int udpPort = 54555, tcpPort = 54777;

    public static String ip = "127.0.0.1";
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");

    public static void start() {
        try {
            client = new Client();
            Register.register(client.getKryo());
            client.start();
            client.connect(5000, ip, tcpPort, udpPort);
            client.addListener(new ClientHandler());
            Main.gui.taChat.append("[" + LocalTime.now().format(dtf) + " Connected as Client]\n");
            Main.isConnected = true;
            Main.gui.btnHost.setEnabled(false);
            Main.gui.btnClient.setEnabled(false);
            Main.gui.btnDisconnect.setEnabled(true);
        } catch (IOException ioException) {
            Main.gui.taChat.append("[" + LocalTime.now().format(dtf) + " No Host found]\n");
            Main.gui.btnHost.setEnabled(true);
            Main.gui.btnClient.setEnabled(true);
            Main.gui.btnDisconnect.setEnabled(false);
            ioException.printStackTrace();
        }
    }

    public static void send(Object o) {
        if (o instanceof Message) {
            Message m = (Message) o;
            Main.gui.taChat.append(m.getMessage());
            client.sendTCP(m);
        }
    }

    public void received(Connection c, Object o) {
        if (o instanceof Message) {
            Message m = (Message) o;
            Main.gui.taChat.append(m.getMessage());
        }
    }

    public static void close() {
        Main.gui.taChat.append("[Disconnected]\n");
        client.close();
    }
}
