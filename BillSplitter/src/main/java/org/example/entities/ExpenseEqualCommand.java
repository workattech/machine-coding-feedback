package org.example.entities;

public class ExpenseEqualCommand implements CommandProcessor {
    String payer;
    Double amount;
    int splitNo;

    String []splitAmoong;

    @Override
    //EXPENSE u1 1000 4 u1 u2 u3 u4 EQUAL
    public void process(String command,UserBase userBase) {
        String [] commandArr= command.split(" ");
        intialize(commandArr);

        if(splitNo==1 && payer.equals(splitAmoong[0])) return;

        Double share= amount/splitNo;
        for(String p: splitAmoong){
            if(!p.equals(payer)){
                userBase.updateBalanceSheet(this.payer,p,share);
            }
        }

        reset();
    }

    private void reset() {
        this.payer= null;
        this.amount= null;
        this. splitNo= 0;
        this.splitAmoong=null;
    }

    private void intialize(String [] command) {
        this.payer= command[1];
        this.amount= Double.parseDouble(command[2]);
        this. splitNo= Integer.parseInt(command[3]);
        splitAmoong= new String[splitNo];
        for(int  i=0; i<splitNo; i++){
            splitAmoong[i]= command[4+i];
        }
    }
}
