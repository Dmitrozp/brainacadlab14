package com.brainacad.laba19;

public class GameConsole {

    private final Brand brand;
    private final Model model;
    private final String serial;
    private boolean isOn;
    private Gamepad firstGamepad;
    private Gamepad secondGamepad;

    class Gamepad{
        private final Brand brand;
        private String consoleSerial;
        private int connectedNumber;
        private Color color;
        private int chargeLevel = 100;
        private boolean isOn;

        public Gamepad(Brand brand, int connectedNumber) {
            this.brand = brand;
            this.connectedNumber = connectedNumber;
            consoleSerial = serial;
        }

        public Gamepad(Brand brand) {
            this.brand = brand;
        }

        public Gamepad(){}


        public Brand getBrand() {
            return brand;
        }

        public String getConsoleSerial() {
            return consoleSerial;
       }

        public void setConnectedNumber(int connectedNumber) {
            this.connectedNumber = connectedNumber;
        }

        public void setConsoleSerial(String consoleSerial) {
            this.consoleSerial = consoleSerial;
        }

        public int getConnectedNumber() {
            return connectedNumber;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public int getChargeLevel() {
            return chargeLevel;
        }

        public void setChargeLevel(int chargeLevel) {
            this.chargeLevel = chargeLevel;
        }

        public boolean isOn() {
            return isOn;
        }

        public void setOn(boolean on) {
            isOn = on;
        }

    }

    public GameConsole(Brand brand, Model model, String serial) {
        this.brand = brand;
        this.model = model;
        this.serial = serial;

        firstGamepad = new Gamepad(Brand.SONY);
        firstGamepad.setConnectedNumber(1);
        firstGamepad.setConsoleSerial(serial);

        secondGamepad = new Gamepad(Brand.MICROSOFT);
        secondGamepad.setConnectedNumber(2);
        secondGamepad.setConsoleSerial(serial);



    }


}
