package pl.konradwatrak.net;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import pl.konradwatrak.Main;
import pl.konradwatrak.net.helpers.Register;
import pl.konradwatrak.net.data.Message;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ServerHandler extends Listener {

    static Server server;
    static int udpPort = 54555, tcpPort = 54777;
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");

    public static void start() {
        try {
            server = new Server();
            Register.register(server.getKryo());
            server.bind(tcpPort, udpPort);
            server.start();
            server.addListener(new ServerHandler());
            Main.gui.taChat.append("[" + LocalTime.now().format(dtf) + " Connected as Host]\n");
            Main.isConnected = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void send(Object o) {
        if (o instanceof Message) {
            Message m = (Message) o;
            Main.gui.taChat.append(m.getMessage());
            server.sendToAllTCP(m);
        }
    }

    public void connected(Connection c) {
        Main.gui.taChat.append("[" + c.getRemoteAddressTCP().getHostString() + " Connected]\n");
    }

    public void received(Connection c, Object o) {
        if (o instanceof Message) {
            Message m = (Message) o;
            Main.gui.taChat.append(m.getMessage());
            server.sendToAllExceptTCP(c.getID(), m);
        }
    }

    public void disconnected(Connection c) {
        Main.gui.taChat.append("[Connection " + c.getID() + " Disconnected]\n");
    }

    public static void close() {
        Main.gui.taChat.append("[Disconnected]\n");
    }
}
