package org.example.projectpart1;

import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Collections;


public class Menu extends Items implements Comparable<Items> {
    protected static ArrayList<String> menuItems = new ArrayList<>();
    protected static ArrayList<Double> priceMenuItems = new ArrayList<>();
    protected static ArrayList<String> typeMenuItems = new ArrayList<>();

    public Menu() {
    }

    public Menu(ArrayList<String> typeMenuItems, ArrayList<String> menuItems, ArrayList<Double> priceMenuItems) {
        this.setmenuItems(menuItems);
        this.setprice_menuItems(priceMenuItems);
        this.setType_menuItems(typeMenuItems);
    }

    // setter and getter menuItems
    public ArrayList<String> getMenuitems() {
        return menuItems;
    }

    private void setmenuItems(ArrayList<String> menuItems) {
        this.menuItems = menuItems;
    }


    //    setter and getter priceMenuItems
    public ArrayList<Double> price_menuItems() {
        return priceMenuItems;
    }

    private void setprice_menuItems(ArrayList<Double> priceMenuItems) {
        this.priceMenuItems = priceMenuItems;
    }


    //    setter and getter type_menuItems
    public ArrayList<String> getType_menuItems() {
        return typeMenuItems;
    }

    public void setType_menuItems(ArrayList<String> typeMenuItems) {
        this.typeMenuItems = typeMenuItems;
    }


    @Override
    public void additem(String type, String item, double price) {
        int lastIndex = typeMenuItems.lastIndexOf(type);

        int m = 0;
        if (lastIndex != -1) {
            for (int i = typeMenuItems.indexOf(type); i <= lastIndex; i++) {
                if (type.equals(typeMenuItems.get(i)) && item.equals(menuItems.get(i))) {
                    if (priceMenuItems.get(i) == price) {
                        System.out.println("Item already exists in the menu.");
                        m = 1;
                        return;
                    }// Exit the method if item already exists
                    else {
                        this.changeprice(item, price);
                        m = 1;
                        return;
                    }
                }
            }
        }
        if (m == 0) {
            if (lastIndex == -1) {
                lastIndex = menuItems.size() - 1;
            }
            menuItems.add(lastIndex + 1, item);
            priceMenuItems.add(lastIndex + 1, price);
            typeMenuItems.add(lastIndex + 1, type);
        }
        Menu menu = new Menu();
        getHeighestPrice(menu);

    }

    @Override
    public void removeitem(String item) {
        int i = menuItems.indexOf(item);
        menuItems.remove(item);
        priceMenuItems.remove(i);
        typeMenuItems.remove(i);
        Menu menu = new Menu();
        getHeighestPrice(menu);


    }


    public void displayMenu() {
        System.out.println("Menu");
        System.out.println(typeMenuItems.get(0));
        System.out.println("\t" + menuItems.get(0) + "\t" + priceMenuItems.get(0));
        for (int i = 1; i < menuItems.size(); i++) {
            if (!((typeMenuItems.get(i)).equals(typeMenuItems.get(i - 1))))
                System.out.println(typeMenuItems.get(i));
            System.out.println("\t" + menuItems.get(i) + "\t" + priceMenuItems.get(i));


        }
    }

    public  void changeprice(String item, double new_price) {

        priceMenuItems.set(menuItems.indexOf(item), new_price);

    }


    public double getprice(String item) {
        int i = menuItems.indexOf(item);
        return priceMenuItems.get(i);

    }

    public void search(String item) {
        int flag = 0;
        for (int i = 0; i < menuItems.size(); i++) {
            if (item.equals(menuItems.get(i)))
                flag = 1;
        }
        if (flag == 0)
            System.out.println("The menu does not contain this element.");
        else
            System.out.println("The menu does contain " + item + " and this price " + this.getprice(item));


    }


    public Double getHeighestPrice(Items o) {

        ArrayList<Double>tempPrice= new ArrayList<>();
        tempPrice.addAll(((Menu)o).price_menuItems());
        Collections.sort(tempPrice);
         super.setprice(tempPrice.get(tempPrice.size()-1));
        return tempPrice.get(tempPrice.size()-1);

    }
}
