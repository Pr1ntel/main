package Bank;

public class bankClient {
    private int cardNumber;
    private String fcs;
    private double money;

    public bankClient(int cardNumber, String fcs, double money) {
        this.cardNumber = cardNumber;
        this.fcs = fcs;
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) throws Exception {
        if (money >= 0) {
            this.money = money;
        } else {
            throw new Exception("incorrect money value");
        }
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public String getFcs() {
        return fcs;
    }

    public String getAsString() {
        return String.format("номер карты = %d; ФИО = %s; денег на счету = %.2f", cardNumber, fcs, money);
    }

    public void sendMoney(bankClient bankClientTo, int moneyTo) throws Exception {
        if (moneyTo > money) {
            throw new Exception("incorrect money value. value too much");
        }

        bankClientTo.money += moneyTo;
        money -= moneyTo;
    }

    public void addMoney(double money) throws Exception {
        if (money <= 0) {
            throw new Exception("incorrect money value. value too small or negative");
        }

        this.money += money;
    }
}
