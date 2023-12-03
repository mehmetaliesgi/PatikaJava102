package PatikaStore;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Operations {
    public void brandsLists() {
        TreeSet<Brands> brandsTreeSet = new TreeSet<>(new Comparator<Brands>() {
            @Override
            public int compare(Brands o1, Brands o2) {
                return o1.getBrandsName().compareTo(o2.getBrandsName());
            }
        });
        //Samsung, Lenovo, Apple, Huawei, Casper, Asus, HP, Xiaomi, Monster
        brandsTreeSet.add(new Brands(1, "Samsung"));
        brandsTreeSet.add(new Brands(2, "Lenovo"));
        brandsTreeSet.add(new Brands(3, "Apple"));
        brandsTreeSet.add(new Brands(4, "Huawei"));
        brandsTreeSet.add(new Brands(5, "Casper"));
        brandsTreeSet.add(new Brands(6, "Asus"));
        brandsTreeSet.add(new Brands(7, "HP"));
        brandsTreeSet.add(new Brands(8, "Xiamoi"));
        brandsTreeSet.add(new Brands(9, "Monster"));

        Iterator<Brands> itr = brandsTreeSet.iterator();
        while (itr.hasNext()) {
            System.out.println(" - " + itr.next().getBrandsName());
        }
    }
}
