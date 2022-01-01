package inMemoryKeyValueStore;

import inMemoryKeyValueStore.model.AttributeList;
import inMemoryKeyValueStore.model.KeyValueMap;
import inMemoryKeyValueStore.model.Pair;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        Pair p1=new Pair("price", 30000.00F);
        Pair p2=new Pair("enrolled",false);
        Pair p3=new Pair("estimated_time",30);
        List<Pair> attributeList= new ArrayList<>();
        attributeList.add(p1);
        attributeList.add(p2);
        attributeList.add(p3);
        AttributeList a=new AttributeList(attributeList);
        KeyValueMap kvm=new KeyValueMap();
        kvm.put("sde_bootcamp",a);
        kvm.get("sde_bootcamp");
        p1=new Pair("price", 4000);
        p2=new Pair("enrolled",true);
        p3=new Pair("estimated_time",8);
        attributeList= new ArrayList<>();
        attributeList.add(p1);
        attributeList.add(p2);
        attributeList.add(p3);
        a=new AttributeList(attributeList);
        kvm.put("sde_kickstart",a);
        kvm.get("sde_kickstart");
        kvm.keys();
        kvm.search(p2);
    }
}
