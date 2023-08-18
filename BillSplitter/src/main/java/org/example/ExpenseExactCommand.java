package org.example;

import org.example.entities.CommandProcessor;
import org.example.entities.UserBase;

public class ExpenseExactCommand implements CommandProcessor {
    String payer;
    Double []amount;


    String []splitAmoong;

    @Override
    //EXPENSE u1 1250 2 u2 u3 EXACT 370 880
    public void process(String command,UserBase userBase) {
        String [] commandArr= command.split(" ");
        if(!intialize(commandArr)){
            System.out.println("enter correct amounts");
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

    ////EXPENSE u1 1250 2 u2 u3 EXACT 370 880
    private boolean intialize(String [] command) {
        this.payer= command[1];
        int splitNo= Integer.parseInt(command[3]);
        Double totalAmount=Double.parseDouble(command[2]);
        Double sum=0.0;
        amount= new Double[splitNo];
        splitAmoong= new String[splitNo];

        for(int i= 0; i< splitNo ; i++){
            Double currenAmount=Double.parseDouble(command[4+1+splitNo+i]);
            splitAmoong[i]=command[4+i];
            amount[i]=currenAmount;
            sum+=currenAmount;
        }

        if(!totalAmount.equals(sum)){
            return false;
        }

        return true;
    }
}
