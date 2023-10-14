package Interface;

public class BankA implements IBank {
    private String bankaAdi;
    private String terminalId;
    private String password;

    public BankA(String bankaAdi, String terminalId, String password) {
        this.bankaAdi = bankaAdi;
        this.terminalId = terminalId;
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
    public boolean payment(double tutar, String cardNumber, String expiryDate, String cvc) {
        System.out.println("Bankadan cevap bekleniyor.");
        System.out.println("İşlem başarılı oldu.");
        return true;
    }
    public String getBankaAdi() {
        return bankaAdi;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public String getPassword() {
        return password;
    }

    public void setBankaAdi(String bankaAdi) {
        this.bankaAdi = bankaAdi;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
