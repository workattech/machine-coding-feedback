package inMemoryKeyValueStore.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyValueMap {
    private int key;
    Map<String, AttributeList> mp;
    public KeyValueMap(){
        mp= new HashMap<>();
    }
    public void get(String key){
        if(this.mp.get(key)==null){
            System.out.println("No entry found for "+key);
        }else{
            System.out.print("title:"+key+" ");
            this.mp.get(key).printAttributeList();
        }
    }
    public void put(String key, AttributeList value){
        mp.put(key,value);
    }
    void delete(String key){
        mp.remove(key);
    }
    public void keys(){
        List<String> listOfKeys= new ArrayList<>();
        for(Map.Entry<String,AttributeList>entry:mp.entrySet()){
            System.out.print(entry.getKey()+" ");
        }
        System.out.println();
    }
    public void search(Pair p){
        List<String> listOfMatchedValues= new ArrayList<>();
        for(Map.Entry<String,AttributeList>entry:mp.entrySet()){
            AttributeList a=entry.getValue();
            boolean res=a.printMatching(p);
            if(res){
                System.out.println(entry.getKey());
            }
        }
        System.out.println();
    }
}
