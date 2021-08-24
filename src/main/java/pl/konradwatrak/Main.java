package pl.konradwatrak;

import pl.konradwatrak.gui.GUI;

public class Main {

    public static boolean isHost, isConnected = false;
    public static GUI gui;

    public static void main(String[] args) {
        gui = new GUI();
        gui.draw();
    }
}
