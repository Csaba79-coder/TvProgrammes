package models;

public class Channel {

    private String name;
    private int channelNumber;
    private String type;
    private boolean isNonStop;

    public Channel(String name, int channelNumber, String type, boolean isNonStop) {
        this.name = name;
        this.channelNumber = channelNumber;
        this.type = type;
        this.isNonStop = isNonStop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChannelNumber() {
        return channelNumber;
    }

    public void setChannelNumber(int channelNumber) {
        this.channelNumber = channelNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isNonStop() {
        return isNonStop;
    }

    public void setNonStop(boolean nonStop) {
        isNonStop = nonStop;
    }
}
