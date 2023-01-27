package h05;

public interface ElectricallyDriven {

    public boolean standardVoltageChargeable();

    public boolean highVoltageChargeable();

    public void letsGo (byte additionalChargeVolume, int distance);
}
