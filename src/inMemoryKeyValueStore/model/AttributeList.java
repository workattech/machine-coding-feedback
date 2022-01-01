package inMemoryKeyValueStore.model;

import java.util.List;

public class AttributeList {
    List<Pair> keyValueList;
    public AttributeList(List<Pair> list){
        this.keyValueList=list;
    }
    void printAttributeList(){
        for (Pair pair : keyValueList) {
            System.out.print(pair.getKey() + " ");
            System.out.print(pair.getValue() + " ");
        }
        System.out.println();
    }
    boolean printMatching(Pair p){
        for (Pair pair : keyValueList) {
            if (p.getKey().equals(pair.getKey()) && p.getValue() == pair.getValue()) return true;
        }
        return false;
    }
}
