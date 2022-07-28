package dev.nfotech.model;

import dev.nfotech.thread.ThreadColor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Store {
    public static void readFile() {
        StringBuilder read = new StringBuilder();
        String filePath = "/Users/decagon/Desktop/Personal_Repo/week-4-task-mutithreading/src/main/resources/sampledatafoodsales.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line = reader.readLine()) != null){
                read.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // To categorize my Products
        String[] output = read.toString().split("\n");
        if (output.length > 1) {
            for (int i = 0; i < output.length; i++){
                String[] temp  = output[i].split(",");
                Product newProd = new Product(temp[1], temp[0], Integer.parseInt(temp[2]), Double.parseDouble(temp[3]));
                //Sum and Update the qty of each product
                String key= newProd.getName();
                if (Product.stock.containsKey(key)) {
                    int newQty = newProd.getQuantity();
                    int oldQty = Product.stock.get(key).getQuantity();
                    int finalQty = newQty + oldQty;
                    Product.stock.get(key).setQuantity(finalQty);
                }
                else{
                    Product.stock.put(key, newProd);
                }
                //Printing out the CSV content
            }
        }
        for (Product prod : Product.stock.values()){
            System.out.println(ThreadColor.ANSI_PURPLE +prod.toString());
        }
        System.out.println("---------------------------------");
    }

}