package org.example;

import org.example.entities.CommandProcessor;
import org.example.entities.UserBase;

public class ExpensePercCommand implements CommandProcessor {
    String payer;
    Double []amount;


    String []splitAmoong;

    @Override
    //EXPENSE u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20
    public void process(String command, UserBase userBase) {
        String [] commandArr= command.split(" ");
        if(!intialize(commandArr)){
            System.out.println("enter correct percentage which sums to 100%");
            reset();
            return;
        }

        if(amount.length==1 && splitAmoong[0].equals(payer)) return;


        for(int i=0; i<amount.length; i++){
            if(!splitAmoong[i].equals(payer)){
                userBase.updateBalanceSheet(this.payer,splitAmoong[i],amount[i]);
            }
        }

        reset();
    }

    private void reset() {
        this.payer= null;
        this.amount= null;
        this.splitAmoong=null;
    }

    //EXPENSE u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20
    private boolean intialize(String [] command) {
        this.payer= command[1];
        int splitNo= Integer.parseInt(command[3]);
        Double totalAmount=Double.parseDouble(command[2]);
        Double sum=0.0;
        amount= new Double[splitNo];
        splitAmoong= new String[splitNo];

        for(int i= 0; i< splitNo ; i++){
            Double currentPerc=(totalAmount*(Double.parseDouble(command[4+1+splitNo+i])))/100.00;
            splitAmoong[i]=command[4+i];
            amount[i]=currentPerc;
            sum+=(Double.parseDouble(command[4+1+splitNo+i]));
        }

        if(!sum.equals(100.0)){
            return false;
        }

        return true;
    }
}
