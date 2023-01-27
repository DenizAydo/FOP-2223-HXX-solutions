package h05;

public abstract class MeansOfTransport {

    protected TransportType transportType;

    public TransportType getTransportType() {

        return transportType;
    }

    public abstract int letMeMove (int distance);

    public String toString() {

        String transportName = transportType.name();
        StringBuilder importString = new StringBuilder();

        if((int) transportName.charAt(0) == 65) {
            importString.append("an ");
        }
        else if ((int) transportName.charAt(0) == 69)  {
            importString.append("an ");
        }
        else if ((int) transportName.charAt(0) == 73) {
            importString.append("an ");
        }
        else if ((int) transportName.charAt(0) == 85) {
            importString.append("an ");
        }
        else if ((int) transportName.charAt(0) == 97) {
            importString.append("an ");
        }
        else if ((int) transportName.charAt(0) == 101) {
            importString.append("an ");
        }
        else if ((int) transportName.charAt(0) == 105) {
            importString.append("an ");
        }
        else if ((int) transportName.charAt(0) == 111) {
            importString.append("an ");
        }
        else if ((int) transportName.charAt(0) == 117) {
            importString.append("an ");
        }
        else {
            importString.append("a ");


        }
        for(int i = 0; i < transportName.length(); i++){

            if((int) transportName.charAt(i) < 123 && (int) transportName.charAt(i) > 96 && i == 0){
                importString.append((char) (transportName.charAt(i) - 32));
            }
            else if((int) transportName.charAt(i) < 91 && (int) transportName.charAt(i) > 64 && i != 0){
                importString.append((char) (transportName.charAt(i) + 32));
            }
            else importString.append(transportName.charAt(i));
        }

        if (transportType == null) {
            return "undefined";
        }

        return String.format("I am " + importString + ".");

    }

}

