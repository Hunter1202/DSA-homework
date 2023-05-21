package Bai5;

import Bai2.DWGraph;
import Bai2.Vertex;

import java.util.HashMap;
import java.util.Map;

public class BIDV {
    private DWGraph atmGraph;
    private Map<Vertex, Integer> atmMoney;

    public BIDV() {
        atmGraph = new DWGraph(100); // Assuming a maximum of 100 ATMs
        atmMoney = new HashMap<>();
    }

    public Vertex addATM(int atmIndex, int initialMoney) {
        Vertex atm = atmGraph.insertVertex(atmIndex);
        atmMoney.put(atm, initialMoney);
        return atm;
    }


    public void addMoneyToATM(Vertex atm, int money) {
        if (atmMoney.containsKey(atm)) {
            int currentMoney = atmMoney.get(atm);
            atmMoney.put(atm, currentMoney + money);
        } else {
            throw new IllegalArgumentException("ATM không tồn tại.");
        }
    }

    public void removeATM(Vertex atm) {
        if (atmMoney.containsKey(atm)) {
            atmGraph.removeVertex(atm);
            atmMoney.remove(atm);
            System.out.println("ATM số " + atm.getIndex() + " đã bị xóa.");
        } else {
            throw new IllegalArgumentException("ATM không tồn tại.");
        }
    }

    public void updateATMBalance(Vertex atm, int newBalance) {
        if (atmMoney.containsKey(atm)) {
            atmMoney.put(atm, newBalance);
            System.out.println("ATM " + atm.getIndex() + " cập nhật số dư $" + newBalance);
        } else {
            throw new IllegalArgumentException("ATM ko tồn tại.");
        }
    }

    public void withdrawMoneyFromATM(Vertex atm, int amount) {
        if (atmMoney.containsKey(atm)) {
            int currentBalance = atmMoney.get(atm);
            if (currentBalance >= amount) {
                atmMoney.put(atm, currentBalance - amount);
                System.out.println("$" + amount + " rút tiền thành công từ ATM " + atm.getIndex());
            } else {
                throw new IllegalArgumentException("ATM hiện không đủ tiền.");
            }
        } else {
            throw new IllegalArgumentException("ATM ko tồn tại.");
        }
    }


    public void transferMoney(Vertex sourceATM, Vertex destinationATM, int amount) {
        if (atmMoney.containsKey(sourceATM) && atmMoney.containsKey(destinationATM)) {
            int sourceBalance = atmMoney.get(sourceATM);
            int destinationBalance = atmMoney.get(destinationATM);

            if (sourceBalance >= amount) {
                atmMoney.put(sourceATM, sourceBalance - amount);
                atmMoney.put(destinationATM, destinationBalance + amount);
                System.out.println("Chuyển thành công số tiền " + amount + "$ từ ATM " + sourceATM.getIndex() + " đến ATM " + destinationATM.getIndex());
            } else {
                throw new IllegalArgumentException("Số dư không đủ từ ATM nguồn.");
            }
        } else {
            throw new IllegalArgumentException("1 trong 2 ATM không tồn tại");
        }
    }

    public void printATMInformation() {
        for (Vertex atm : atmMoney.keySet()) {
            int atmIndex = atm.getIndex();
            int atmBalance = atmMoney.get(atm);
            System.out.println("ATM số: " + atmIndex + " - Số dư khả dụng: " + atmBalance +"$");
        }
    }


    public static void main(String[] args) {
        BIDV bidv = new BIDV();

        Vertex atm1 = bidv.addATM(1, 5000);
        Vertex atm2 = bidv.addATM(2, 10000);

        //add money
        bidv.addMoneyToATM(atm1, 1000);
        bidv.addMoneyToATM(atm2, 1000);

        bidv.printATMInformation();

        //withdraw money
        bidv.withdrawMoneyFromATM(atm1, 1000);

        //update balance
        bidv.updateATMBalance(atm2, 3000);

        //transfer money
        bidv.transferMoney(atm1, atm2, 1000 );
        bidv.printATMInformation();

        //remove atm
        bidv.removeATM(atm2);

        //exception
        bidv.transferMoney(atm1, atm2, 10000 );
    }
}
