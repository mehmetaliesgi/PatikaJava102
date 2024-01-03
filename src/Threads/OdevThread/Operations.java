package Threads.OdevThread;

import java.util.ArrayList;
import java.util.List;

public class Operations implements Runnable{
    public ArrayList<Integer> evens = new ArrayList<>();
    public ArrayList<Integer> odds = new ArrayList<>();
    public ArrayList<Integer> arrayList = new ArrayList<>();
    public List<Integer> subArrayList1, subArrayList2, subArrayList3, subArrayList4;
    public void createLists() {
        for (int i = 1; i <= 10000; i++) {
            arrayList.add(i);
        }
        subArrayList1 = arrayList.subList(0,2500);
        subArrayList2 = arrayList.subList(2500,5000);
        subArrayList3 = arrayList.subList(5000,7500);
        subArrayList4 = arrayList.subList(7500,10000);
    }

    @Override
    public void run() {
        createLists();
        if (Thread.currentThread().getName().equals("Thread-0")) {
            for (Integer value : subArrayList1) {
                add(value);
            }
        } else if (Thread.currentThread().getName().equals("Thread-1")) {
            for (Integer value : subArrayList2) {
                add(value);
            }
        } else if (Thread.currentThread().getName().equals("Thread-2")) {
            for (Integer value : subArrayList3) {
                add(value);
            }
        } else {
            for (Integer value : subArrayList4) {
                add(value);
            }
        }
    }

    public void add(int value) {
        if (value % 2 == 0) {
            System.out.println(Thread.currentThread().getName() + " -> " + value);
            evens.add(value);
        }
        else {
            System.out.println(Thread.currentThread().getName() + " -> " + value);
            odds.add(value);
        }
    }
}


