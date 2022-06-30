package Bank;

import java.util.ArrayList;

public class Bank {
    private ArrayList<bankClient> bankClients;
    private int lastCardNumber;

    public Bank() {
        bankClients = new ArrayList<>();
        lastCardNumber = 1111111;
    }

    private void addClientToList(bankClient insertedBankClient) {
        bankClients.add(insertedBankClient);
    }

    public void addClient(String fcs) {
        lastCardNumber++;
        addClientToList(new bankClient(lastCardNumber, fcs, 0));
    }

    public void printClientsToConsole() {
        for (int i = 0; i < bankClients.size(); i++) {
            System.out.println(bankClients.get(i).getAsString());
        }
    }

    private bankClient findClientByCardNumber(int cardNumber) throws Exception {
        for (int i = 0; i < bankClients.size(); i++) {
            if (bankClients.get(i).getCardNumber() == cardNumber) {
                return bankClients.get(i);
            }
        }
        throw new Exception("client with cardNumber " + cardNumber + " not found");
    }

    public void sendMoneyFromClientToClient(int cardNumberFrom, int cardNumberTo, int moneyTo) throws Exception {
        bankClient bankClientFrom = findClientByCardNumber(cardNumberFrom);
        bankClient bankClientTo = findClientByCardNumber(cardNumberTo);

        bankClientFrom.sendMoney(bankClientTo, moneyTo);
    }
}
