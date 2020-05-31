package Bai2;

import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    static Scanner input = new Scanner(System.in);

    static Map<Integer, Integer> serviceMap = new TreeMap<>();

//    static {
//        serviceMap.put(10, 250);
//        serviceMap.put(20, 90);
//        serviceMap.put(30, 3150);
//    }

    public static void main(String[] args) {
        activeMenu();
    }

    public static void activeMenu() {
        while (true) {
            String choose = input.nextLine();
            switch (choose) {
                case "1":
                    add();
                    break;
                case "2":
                    serviceAndDeleteHighestP();
                    break;
                case "3":
                    serviceAndDeleteLowestP();
                    break;
                case "4":
                    System.out.println(serviceMap);
                    break;
                case "0":
                    System.out.println(" - Service is done !");
                    System.exit(-1);
                    break;
                default:
                    System.out.println("- Something wrong !");
                    System.exit(-1);
                    break;
            }
        }
    }

    public static void add() {
        Integer K = input.nextInt();
        Integer P = input.nextInt();

        input.nextLine();

        serviceMap.put(K, P);
        System.out.println(" - Your map:" + serviceMap);
    }

    public static void serviceAndDeleteHighestP() {
        serviceCustomer("highest");
    }

    public static void serviceAndDeleteLowestP() {
        serviceCustomer("lowest");
    }

    public static void serviceCustomer(String priority) {
        if (priority.equalsIgnoreCase("highest")) {
            checkEmpty(serviceMap);
            Integer hightgestP = Collections.max(serviceMap.values());
            for (Map.Entry<Integer, Integer> mapItem : serviceMap.entrySet()) {
                if (mapItem.getValue().equals(hightgestP)) {
                    System.out.println(mapItem.getKey());
                }
            }
            serviceMap.values().removeIf(value -> value.equals(hightgestP));

        } else if (priority.equalsIgnoreCase("lowest")) {
            checkEmpty(serviceMap);
            Integer lowestP = Collections.min(serviceMap.values());
            for (Map.Entry<Integer, Integer> mapItem : serviceMap.entrySet()) {
                if (mapItem.getValue().equals(lowestP)) {
                    System.out.println(mapItem.getKey());
                }
            }
            serviceMap.values().removeIf(value -> value.equals(lowestP));

        } else {
            System.exit(-1);
        }
    }

    public static void checkEmpty(Map<Integer, Integer> serviceMap) {
        if (serviceMap.isEmpty()) {
            System.out.println(0);
            activeMenu();
        }
    }
}
