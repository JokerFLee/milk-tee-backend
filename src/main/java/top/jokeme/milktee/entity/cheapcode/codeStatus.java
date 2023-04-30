package top.jokeme.milktee.entity.cheapcode;

public class codeStatus {
    private char available;
    private String msg;
    private byte type;
    private double content;

    public void notOkay(){
        this.available = 'N';
        this.msg = "优惠码不可用!";
    }
    public void okay(){
        this.available = 'Y';
        this.msg = "200 ok!";
    }
    public char getAvailable() {
        return available;
    }

    public void setAvailable(char available) {
        this.available = available;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public double getContent() {
        return content;
    }

    public void setContent(double content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "codeStatus{" +
                "available=" + available +
                ", msg='" + msg + '\'' +
                ", type=" + type +
                ", content=" + content +
                '}';
    }
}
