package Interface;

public class BankB implements IBank {
    private String bankaAdi;
    private String terminalId;
    private String password;

    public BankB(String bankaAdi, String terminalId, String password) {
        this.bankaAdi = bankaAdi;
        this.terminalId = terminalId;
        this.password = password;
    }


    public String getBankaAdi() {
        return bankaAdi;
    }

    public void setBankaAdi(String bankaAdi) {
        this.bankaAdi = bankaAdi;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean connect(String ipAddress) {
        System.out.println("Kullanıcı IP: " + ipAddress);
        System.out.println("Makina IP: " + this.hostIpAddress);
        System.out.println(this.bankaAdi + " bağlanıldı.");
        return true;
    }

    @Override
    public boolean payment(double price, String cardNumber, String date, String cvc) {
        System.out.println("Bankadan cevap bekleniyor.");
        System.out.println("İşlem başarılı oldu.");
        return true;
    }
}
