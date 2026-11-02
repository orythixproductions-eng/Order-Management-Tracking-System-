package com.mycompany.ordermanagementandtrackingsystem;
import javax.swing.*;
public class OrderManagementAndTrackingSystem {

    public static void main(String[] args) {
        
        
        String productNames[] = {"T-Shirt", "Shoes", "Bag", "Watch"};
        int productQty[] = {5, 3, 2, 6};
        double productPrice[] = {250.0, 800.0, 500.0, 450.0};

        String orderNames[] = new String[100];
        String orderAddress[] = new String[100];
        String orderNumber[] = new String[100];
        String orderTracking[] = new String[100];
        String orderItem[] = new String[100];
        int orderAmount[] = new int[100];
        String orderStatus[] = new String[100];
        String paymentMethod[] = new String[100];
        String paymentInfo[] = new String[100];
        
        int orderCount = 0;
        
        String Custuser[] = new String[100];
        String Custpass[] = new String[100];
        int Customercount = 0;
        
        String Selleruser[] = new String[100];
        String Sellerpass[] = new String[100];
        Selleruser[0] = "Seller1";
        Sellerpass[0] = "1234";
        
        int Sellercount = 1;

        
        String Manageruser[] = new String[50];
        String Managerpass[] = new String[50];
        Manageruser[0] = "1";
        Managerpass[0] = "1";
        int Managercount = 1;
        
        String reportL[] = new String[100];

        int reportCount = 0;
        
        boolean running = true;
        
        while (running) {
            String options[] = {"Customer", "Seller", "Manager", "Exit"};
            int role = JOptionPane.showOptionDialog(null, "Welcome to Order Management and Tracking System!", 
                    "Main Menu", 0, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            boolean customerActive = true;
            switch (role) {
                case 0:
                    String Logz[] = {"Login", "Create Account", "Back"};
                                    int Custchoose = JOptionPane.showOptionDialog(null, "Choose an option:", "Customer Account", 
                                            0, JOptionPane.INFORMATION_MESSAGE, null, Logz, Logz[0]);
                                    if (Custchoose == 1) {
                                        String newCustname = JOptionPane.showInputDialog("Enter new Username");
                                        if (newCustname == null) {
                                            continue;
                                        } else if (newCustname.equals("") || newCustname.trim().isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Invalid Username");
                                            continue;
                                        }
                                        
                                        String newCustpass = JOptionPane.showInputDialog("Enter new Password");
                                        if (newCustpass == null) {
                                            continue;
                                        } else if (newCustpass.equals("") || newCustpass.trim().isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Invalid Password");
                                            continue;
                                        }
                                        
                                        
                                        Custuser[Customercount] = newCustname;
                                        Custpass[Customercount] = newCustpass;
                                        Customercount++;
                                        JOptionPane.showMessageDialog(null, "Customer Account created successfully!\n" + "Username: " 
                                                + newCustname + "\n" + "Password: " + newCustpass);
                                    }
                                    if (Custchoose == 0) {
                                        String Custnamelog = JOptionPane.showInputDialog("Enter Username");
                                        if (Custnamelog == null) {
                                            continue;
                                        } else if (Custnamelog.equals("") || Custnamelog.trim().isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Invalid Username");
                                            continue;
                                        }
                                        String Custpasslog = JOptionPane.showInputDialog("Enter Password");
                                        if (Custpasslog == null) {
                                            continue;
                                        } else if (Custpasslog.equals("") || Custpasslog.trim().isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Invalid Password");
                                            continue;
                                        }
                                        boolean found = false;
                                        
                                        for (int i = 0; i < Customercount; i++) {
                                            if (Custnamelog.equals(Custuser[i])&& Custpasslog.equals(Custpass[i])) {
                                                found = true;
                                                
                                            }
                                        }
                                        if (found) {
                                            JOptionPane.showMessageDialog(null, "Login Successfull!");
                                           
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Invalid Username/Password");
                                            continue;
                                        }
                                    }
                                    if (Custchoose == 2) {
                                        break;
                                    } 
                    customerActive = true;
                    while (customerActive) {
                        
                        
                                    
                        String[] customerMenu = {"Buy Item", "Track Order", "File Report", "View Report(s)", "Back"};
                        int customerChoice = JOptionPane.showOptionDialog(null, "Select an Option:", "Customer Menu",
                                0, JOptionPane.INFORMATION_MESSAGE, null, customerMenu, customerMenu[0]);

                        switch (customerChoice) {

                            case 0: {
                                while (true) {
                                    
                                    String productList = "Available Products:\n";
                                    for (int i = 0; i < productNames.length; i++) {
                                        if (productNames[i] == null) {
                                        JOptionPane.showMessageDialog(null, "No Products Available", "Sorry", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    } 
                                        if (productNames[i] != null) {
                                        productList += (i + 1) + ". " + productNames[i] + " - ₱" + productPrice[i] + " (" + productQty[i] + " left)\n";
                                    } 
                                    }
                                    
                                    String prodChoiceStr = JOptionPane.showInputDialog(productList + "\nEnter Product Number:");
                                    if (prodChoiceStr == null) break; 
                                    if (prodChoiceStr.trim().isEmpty()) {
                                        JOptionPane.showMessageDialog(null, "Please enter a product number.");
                                        break;
                                    }

                                    int prodChoice;
                                    try {
                                        prodChoice = Integer.parseInt(prodChoiceStr) - 1;
                                    } catch (NumberFormatException e) { 
                                        JOptionPane.showMessageDialog(null, "Invalid number.");
                                        continue;
                                    }

                                    if (prodChoice < 0 || prodChoice >= productNames.length) {
                                        JOptionPane.showMessageDialog(null, "Invalid product number.");
                                        continue;
                                    }

                                    if (productQty[prodChoice] == 0) {
                                        JOptionPane.showMessageDialog(null, "Sorry, " + productNames[prodChoice] + " is out of stock.");
                                        continue;
                                    }

                                    String qtyStr = JOptionPane.showInputDialog("How many to buy:");
                                    if (qtyStr == null) continue; 
                                    if (qtyStr.trim().isEmpty()) {
                                        JOptionPane.showMessageDialog(null, "Please enter how many to buy.");
                                        continue;
                                    }

                                    int qtyBuy;
                                    try {
                                        qtyBuy = Integer.parseInt(qtyStr);
                                    } catch (NumberFormatException e) {
                                        JOptionPane.showMessageDialog(null, "Invalid quantity.");
                                        continue;
                                    }

                                    if (qtyBuy > productQty[prodChoice]) {
                                        JOptionPane.showMessageDialog(null, "Only " + productQty[prodChoice] + " left in stock.");
                                        continue;
                                    }

                                    double total = qtyBuy * productPrice[prodChoice];

                                    String[] payOptions = {"Card", "E-Money", "COD", "Cancel"};
                                    int payChoice = JOptionPane.showOptionDialog(
                                        null,
                                        "Total: ₱" + total + "\nSelect your payment method:",
                                        "Payment Method",
                                        0,
                                        JOptionPane.INFORMATION_MESSAGE,
                                        null,
                                        payOptions,
                                        payOptions[0]
                                    );

                                    if (payChoice == 3 || payChoice == JOptionPane.CLOSED_OPTION) {
                                        JOptionPane.showMessageDialog(null, "Payment canceled. Returning to product list.");
                                        break;
                                    }

                                    String payMethod = payOptions[payChoice];

                                    String receipt = "";
                                    if (!payMethod.equals("COD")) { 
                                        while (true) {
                                            receipt = JOptionPane.showInputDialog("Enter receipt number:");
                                            if (receipt == null || receipt.trim().isEmpty()) {
                                                JOptionPane.showMessageDialog(null, "Receipt required.");
                                                continue;
                                            }
                                            break;
                                        }
                                    } else {
                                        receipt = "N/A"; 
                                    }


                                    String name = "";
                                    while (true) {
                                        name = JOptionPane.showInputDialog("Enter your Name:");
                                        if (name == null || name.trim().isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Name required.");
                                            continue;
                                        }
                                        break;
                                    }

                                    String address = "";
                                    while (true) {
                                        address = JOptionPane.showInputDialog("Enter your Address:");
                                        if (address == null || address.trim().isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Address required.");
                                            continue;
                                        }
                                        break;
                                    }

                                    String number = "";
                                    while (true) {
                                        number = JOptionPane.showInputDialog("Enter your Cellphone Number:");
                                        
                                        if (number == null || number.isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Cellphone number required.");
                                            continue;
                                        }
                                        
                                        number = number.trim();

                                        if (!number.matches("^09\\d{9}$")) { 
                                            JOptionPane.showMessageDialog(null, "Invalid number. It must start with '09' and be 11 digits long.");
                                            continue;
                                        }

                                        break; 
                                    }


                                    String tracking = "TR" + (int) (Math.random() * 9000 + 1000);

                                    orderNames[orderCount] = name;
                                    orderAddress[orderCount] = address;
                                    orderNumber[orderCount] = number;
                                    orderItem[orderCount] = productNames[prodChoice];
                                    orderAmount[orderCount] = qtyBuy;
                                    orderTracking[orderCount] = tracking;
                                    orderStatus[orderCount] = "Pending";
                                    paymentMethod[orderCount] = payMethod;
                                    paymentInfo[orderCount] = receipt;
                                    orderCount++;

                                    productQty[prodChoice] -= qtyBuy;

                                    if (productQty[prodChoice] <= 0) {
                                        JOptionPane.showMessageDialog(null, productNames[prodChoice] + " is now out of stock and will be removed.");

                                        for (int i = prodChoice; i < productNames.length - 1; i++) {
                                            productNames[i] = productNames[i + 1];
                                            productPrice[i] = productPrice[i + 1];
                                            productQty[i] = productQty[i + 1];
                                        }

                                        productNames[productNames.length - 1] = null;
                                        productPrice[productPrice.length - 1] = 0;
                                        productQty[productQty.length - 1] = 0;
                                    }

                                    
                                    

                                    JOptionPane.showMessageDialog(null, "Order placed successfully!\nTracking Code: " + tracking);
                                     break;
                                }
                                break;
                            }


                            
                            case 1: {
                                if (orderCount == 0) {
                                        JOptionPane.showMessageDialog(null, "No orders yet.");
                                    } else {
                                        String orders = "";
                                        for (int o = 0; o < orderCount; o++) {
                                            orders += (o + 1) + 
                                                      
                                                ".\nName: " + orderNames[o] + "\n" +
                                                "Address: " + orderAddress[o] + "\n" +
                                                "Cellphone: " + orderNumber[o] + "\n" +
                                                "Item: " + orderItem[o] + "\n" +
                                                "Quantity: " + orderAmount[o] + "\n" +
                                                "Status: " + orderStatus[o] + "\n" +
                                                "Payment Method: " + paymentMethod[o] + "\n" +
                                                "Receipt Number: " + paymentInfo[o] + "\n\n";
                                        }
                                        JOptionPane.showMessageDialog(null, orders);
                                    }
                                    break;
                            }

                            case 2: {
                                String report = JOptionPane.showInputDialog("Describe your issue or feedback:");
                                if (report != null && !report.trim().isEmpty()) {
                                    reportL[reportCount] = report.trim();
                                    reportCount++;
                                    JOptionPane.showMessageDialog(null, "Thank you for your report!");
                                } else {
                                    JOptionPane.showMessageDialog(null, "No report filed.");
                                }
                                break;
                            }

                            case 3: 
                                
                                if (reportCount == 0) {
                                    JOptionPane.showMessageDialog(null, "No reviews or reports");
                                    break;
                                }
                                String Custopt[] = {"Delete", "Back"};
                                

                                String allReports = "Reports/Reviews:\n";
                                for (int i = 0; i < reportCount; i++) {
                                    allReports += (i + 1) + ". " + reportL[i] + "\n";
                                } 
                                int showCustopt = JOptionPane.showOptionDialog(null, allReports, "Review Report",
                                        0, JOptionPane.INFORMATION_MESSAGE, null, Custopt, Custopt[0]);
                                
                                switch (showCustopt) {
                                    case 0:
                                String delStr = JOptionPane.showInputDialog(allReports + "\nEnter report number to delete:");
                                if (delStr == null || delStr.trim().isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "No report deleted.");
                                    continue;
                                }

                                int delIndex;
                                try {
                                    delIndex = Integer.parseInt(delStr) - 1;
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "Invalid number.");
                                    continue;
                                }

                                if (delIndex < 0 || delIndex >= reportCount) {
                                    JOptionPane.showMessageDialog(null, "Invalid report number.");
                                    continue;
                                }

                                for (int i = delIndex; i < reportCount - 1; i++) {
                                    reportL[i] = reportL[i + 1];
                                }
                                reportL[reportCount - 1] = null;
                                reportCount--;
                                JOptionPane.showMessageDialog(null, "Report deleted successfully!");
                                continue;
                                
                                    case 1:
                                        
                                        continue;
                                        
                                        
                                }  
                            
                        
                        

                            case 4:
                            default:
                                customerActive = false;
                                break;
                        } 
                    } 
                    break;

                case 1:
                    
                    String LogzCust[] = {"Login", "Back"};
                                    int sellerchoose = JOptionPane.showOptionDialog(null, "Choose an option:", "Seller Login", 
                                            0, JOptionPane.INFORMATION_MESSAGE, null, LogzCust, LogzCust[0]);
                                    String Sellernamelog = null;
                                    if (sellerchoose == 0) {
                                        Sellernamelog = JOptionPane.showInputDialog("Enter Username");
                                        if (Sellernamelog == null) {
                                            continue;
                                        } else if (Sellernamelog.equals("") || Sellernamelog.trim().isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Invalid Username");
                                            continue;
                                        }
                                        String Sellerpasslog = JOptionPane.showInputDialog("Enter Password");
                                        if (Sellerpasslog == null) {
                                            continue;
                                        } else if (Sellerpasslog.equals("") || Sellerpasslog.trim().isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Invalid Username");
                                            continue;
                                        }
                                        boolean found = false;
                                        
                                        for (int i = 0; i < Sellercount; i++) {
                                            if (Sellernamelog.equals(Selleruser[i])&& Sellerpasslog.equals(Sellerpass[i])) {
                                                found = true;
                                                
                                            }
                                        }
                                        if (found) {
                                            JOptionPane.showMessageDialog(null, "Login Successfull!");
                                           
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Invalid Username/Password");
                                            continue;
                                        }
                                    }
                                    if (sellerchoose == 1) {
                                        break;
                                    }
                                    
                    
                        boolean sellerActive = true;
                        while (sellerActive) {
                            String[] sellerMenu = {"Sell Item", "Add Stock", "View Orders/Track by Code", "Logout"};
                            int sChoice = JOptionPane.showOptionDialog(null, "Seller Menu:", "Seller", 0, JOptionPane.INFORMATION_MESSAGE, null, sellerMenu, sellerMenu[0]);

                            switch (sChoice) {

                                case 0:
                                    String sellList = "Available Products:\n";
                                    for (int i = 0; i < productNames.length; i++) {
                                        if (productNames[i] != null) {
                                        sellList += (i + 1) + ". " + productNames[i] 
                                                + " (" + productQty[i] + " left) - ₱" + productPrice[i] + "\n";
                                    }
                                    }
                                            
                                    String sellChoiceStr = JOptionPane.showInputDialog(sellList + "Enter product number to sell:");
                                    if (sellChoiceStr == null) break;
                                    if (sellChoiceStr.trim().isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Please Enter product number to sell:");
                                            continue;
                                    }
                                     int sellChoice;
                                     try {
                                      sellChoice = Integer.parseInt(sellChoiceStr) - 1;
                                     } catch  (NumberFormatException e) {
                                        JOptionPane.showMessageDialog(null, "Invalid product number.");
                                        continue;
                                    }
                                       if (sellChoice < 0 || sellChoice >= productNames.length) {
                                        JOptionPane.showMessageDialog(null, "Invalid product number");
                                        continue; 
                                       }

                                    String sellQtyStr = JOptionPane.showInputDialog("Enter quantity to sell:");
                                    if (sellQtyStr == null) break;
                                    if (sellQtyStr.trim().isEmpty()) {
                                        JOptionPane.showMessageDialog(null, "Please Enter quantity to sell:");
                                        continue;
                                    }
                                     int sellQty;
                                     try {
                                         sellQty = Integer.parseInt(sellQtyStr);
                                     } catch (NumberFormatException e) {
                                        
                                    JOptionPane.showMessageDialog(null, "Only " + productQty[sellChoice] + " left in stock."); 
     
                                        break;
                                        
                                      }    if (sellQty > productQty[sellChoice]) {
                                        JOptionPane.showMessageDialog(null, "Only " + productQty[sellChoice] + " left in stock.");
                                        break;
                                      }
                                     
                                    double totalPrice = sellQty * productPrice[sellChoice];
                                    String cashStr = JOptionPane.showInputDialog("Total: ₱" + totalPrice + "\nEnter cash amount:");
                                    if (cashStr == null) break;
                                    if (cashStr.trim().isEmpty()) {
                                        JOptionPane.showMessageDialog(null, "Please Enter cash amount.");
                                        
                                        continue;
                                    } double cashPaid;
                                    try {
                                        cashPaid = Double.parseDouble(cashStr);
                                    } catch (NumberFormatException e) {
                                        JOptionPane.showMessageDialog(null, "Invalid cash amount.");
                                        continue;
                                    }
                                    double change = cashPaid - totalPrice;
                                    if (cashPaid < totalPrice) {
                                        
                                        JOptionPane.showMessageDialog(null, "Insufficient cash.");
                                        break;
                                        
                                        
                                    } else if (cashPaid >= totalPrice) {
                                        JOptionPane.showMessageDialog(null, "Payment successful! Change: ₱" + change);
                                        productQty[sellChoice] -= sellQty;
                                        
                                    if (productQty[sellChoice] <= 0) {
                                        JOptionPane.showMessageDialog(null, productNames[sellChoice] + " is now out of stock and will be removed.");

                                        for (int i = sellChoice; i < productNames.length - 1; i++) {
                                            productNames[i] = productNames[i + 1];
                                            productPrice[i] = productPrice[i + 1];
                                            productQty[i] = productQty[i + 1];
                                        }

                                        productNames[productNames.length - 1] = null;
                                        productPrice[productPrice.length - 1] = 0;
                                        productQty[productQty.length - 1] = 0;
                                    }

                                    
                                    String ctracking = "TR" + (int) (Math.random() * 9000 + 1000);

                                    orderNames[orderCount] = Sellernamelog; 
                                    orderItem[orderCount] = productNames[sellChoice]; 
                                    orderAmount[orderCount] = sellQty; 
                                    orderTracking[orderCount] = ctracking; 
                                    orderStatus[orderCount] = "Purchased"; 
                                    paymentMethod[orderCount] = "Cash"; 
                                    paymentInfo[orderCount] = "Cash Paid: ₱" + cashPaid + " | Change: ₱" + change; 
                                    orderCount++;  
                                    
                                    
 

                                    JOptionPane.showMessageDialog(null, "Order placed successfully!\nTracking Code: " + ctracking);
                                        break;
                            
                                
                                    }
                        
                                
                                    

                                case 1:
                                    String stockList = "";
                                    for (int i = 0; i < productNames.length; i++) {
                                        if (productNames[i] != null) {
                                        stockList += (i + 1) + ". " + productNames[i] + " (" + productQty[i] + " left)\n";
                                    }
                                    }
                                    String stockIndexStr = JOptionPane.showInputDialog(stockList + "Enter product number to add stock:");
                                    if (stockIndexStr == null) break;
                                    if (stockIndexStr.trim().isEmpty()) {
                                        JOptionPane.showMessageDialog(null, "Please input valid Product Number");
                                        continue;
                                    } 
                                    int stockIndex;
                                    try {
                                    stockIndex = Integer.parseInt(stockIndexStr) - 1;
                                    } catch (NumberFormatException e) {
                                        JOptionPane.showMessageDialog(null, "Invalid Product Number.");
                                        continue;
                                    }
                                    if (stockIndex < 0 || stockIndex > productNames.length) {
                                        JOptionPane.showMessageDialog(null, "There are only " + productNames.length + " on the list.");
                                    }
                                    if (stockIndex >= 0 && stockIndex < productNames.length) {
                                        String stockQtyStr = JOptionPane.showInputDialog("Enter quantity to add:");
                                        
                                        int stockQty = 0;
                                        try {
                                            stockQty = Integer.parseInt(stockQtyStr);
                                        } catch (NumberFormatException e) {
                                            JOptionPane.showMessageDialog(null, "Invalid quantity");
                                            continue;
                                        }
                                        
                                        productQty[stockIndex] += stockQty;
                                        JOptionPane.showMessageDialog(null, "Stock updated!");
                                    }
                                        break;

                                case 2:
                                    if (orderCount == 0) {
                                    JOptionPane.showMessageDialog(null, "No orders yet.");
                                        break;
                                    }
                                    
                                    String orderView = "";
                                    for (int o = 0; o < orderCount; o++) {
                                        orderView += 
                                                   (o + 1) +
                                                ". Name: " + orderNames[o] + "\n" +
                                                " Item: " + orderItem[o] + "\n" +
                                                " Quantity: " + orderAmount[o] + "\n" +
                                                " Status: " + "Purchased" + "\n" +
                                                " Payment Method: " + paymentMethod[o] + "\n" ;
                                            
                                        }
                                    JOptionPane.showMessageDialog(null, orderView);
                                        break;

                                case 3:
                                    sellerActive = false;
                                    break;
                                }
                                }
                                
                                break;


                case 2:
                    String ManagerLogz[] = {"Login", "Back"};
                    int Managerchoose = JOptionPane.showOptionDialog(null, "Choose an option:", "Manager Login", 
                                            0, JOptionPane.INFORMATION_MESSAGE, null, ManagerLogz, ManagerLogz[0]);
                                    
                                    if (Managerchoose == 0) {
                                        String Managernamelog = JOptionPane.showInputDialog("Enter Username");
                                        if (Managernamelog == null) {
                                            continue;
                                        } else if (Managernamelog.equals("") || Managernamelog.trim().isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Invalid Username");
                                            continue;
                                        }
                                        String Managerpasslog = JOptionPane.showInputDialog("Enter Password");
                                        if (Managerpasslog == null) {
                                            continue;
                                        } else if (Managerpasslog.equals("") || Managerpasslog.trim().isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Invalid Username");
                                            continue;
                                        }
                                        boolean found = false;
                                        
                                        for (int i = 0; i < Managercount; i++) {
                                            if (Managernamelog.equals(Manageruser[i])&& Managerpasslog.equals(Managerpass[i])) {
                                                found = true;
                                                
                                            }
                                        }
                                        if (found) {
                                            JOptionPane.showMessageDialog(null, "Login Successfull!");
                                           
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Invalid Username/Password");
                                            continue;
                                        }
                                    }
                                    if (Managerchoose == 1) {
                                        break;
                                    }
                        boolean managerActive = true;
                        while (managerActive) {
                            String[] managerMenu = {"View Orders", "Add Product", "Update Quantity/Price", "Update Status", "Customer Report", "Add Account", "Logout"};
                            int mChoice = JOptionPane.showOptionDialog(null, "Manager Menu:", "Manager", 0,
                                JOptionPane.INFORMATION_MESSAGE, null, managerMenu, managerMenu[0]);

                            switch (mChoice) {
                                case 0:
                                    if (orderCount == 0) {
                                        JOptionPane.showMessageDialog(null, "No orders yet.");
                                    } else {
                                        String orders = "";
                                        for (int o = 0; o < orderCount; o++) {
                                            orders += (o + 1) + 
                                                      
                                                ".\nName: " + orderNames[o] + "\n" +
                                                "Address: " + orderAddress[o] + "\n" +
                                                "Cellphone: " + orderNumber[o] + "\n" +
                                                "Item: " + orderItem[o] + "\n" +
                                                "Quantity: " + orderAmount[o] + "\n" +
                                                "Status: " + orderStatus[o] + "\n" +
                                                "Payment Method: " + paymentMethod[o] + "\n" +
                                                "Receipt Number: " + paymentInfo[o] + "\n\n";
                                        }
                                        JOptionPane.showMessageDialog(null, orders);
                                    }
                                    break;

                                case 1:
                                    String newName = JOptionPane.showInputDialog("Enter new product name:");
                                    if (newName.trim().isBlank()) {
                                        JOptionPane.showMessageDialog(null, "Please input the product name");
                                        continue;
                                    } 
                                    String newPriceStr = JOptionPane.showInputDialog("Enter price:");
                                    if (newPriceStr.trim().isBlank()) {
                                        JOptionPane.showMessageDialog(null, "Please input the price.");
                                        continue;
                                    }
                                    String newQtyStr = JOptionPane.showInputDialog("Enter quantity.");
                                    if (newQtyStr.trim().isBlank()) {
                                        JOptionPane.showMessageDialog(null, "Please input the how many.");
                                        continue;
                                    }
                                    try {
                                        double newPrice = Double.parseDouble(newPriceStr);
                                        int newQty = Integer.parseInt(newQtyStr);
                                        String tempNames[] = new String[productNames.length + 1];
                                        int tempQty[] = new int[productQty.length + 1];
                                        double tempPrice[] = new double[productPrice.length + 1];
                                        for (int x = 0; x < productNames.length; x++) {
                                            tempNames[x] = productNames[x];
                                            tempQty[x] = productQty[x];
                                            tempPrice[x] = productPrice[x];
                                        }
                                        tempNames[productNames.length] = newName;
                                        tempQty[productQty.length] = Integer.parseInt(newQtyStr);
                                        tempPrice[productPrice.length] = Double.parseDouble(newPriceStr);
                                        productNames = tempNames;
                                        productQty = tempQty;
                                        productPrice = tempPrice;
                                        JOptionPane.showMessageDialog(null, "Product added successfully!");
                                    } catch (NumberFormatException e) {
                                        JOptionPane.showMessageDialog(null, "Please enter valid numeric values for price and quantity.");
                                    }
                                    break;

                                case 2:
                                    String list = "";
                                    String listchoice[] = {"Price", "Quantity", "Back"};
                                    int choiceopt = JOptionPane.showOptionDialog(null, "Enter what to change", "Change Price/Quantity", 0, 
                                            JOptionPane.INFORMATION_MESSAGE, null, listchoice, listchoice[0]);
                                    
                                    for (int p = 0; p < productNames.length; p++) {
                                        list += (p + 1) + ". " + productNames[p] + " - ₱" + productPrice[p] + " (" + productQty[p] + " left)\n";
                                    } 
                                    
                                    if (choiceopt == 0) {
                                        String Prodnum = JOptionPane.showInputDialog(list + "Enter product number to change price");
                                        if (Prodnum == null) break;
                                        if (Prodnum.trim().isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Please Enter valid product number.");
                                            continue;
                                        }
                                    
                                    int Prodnumstr;
                                    try {
                                        Prodnumstr = Integer.parseInt(Prodnum) - 1;
                                    } catch (NumberFormatException e) {
                                        JOptionPane.showMessageDialog(null, "Invalid product number");
                                        continue;
                                    } 
                                    if (Prodnumstr >= 0 && Prodnumstr < productNames.length) {
                                    String newPrice =  JOptionPane.showInputDialog("Enter the new price: ");
                                    if (newPrice == null || newPrice.trim().isBlank()) {
                                    JOptionPane.showMessageDialog(null, "Please input the new price.");
                                    continue;
                                    } try {
                                        double newPriceS = Double.parseDouble(newPrice);
                                        if (newPriceS < 0) {
                                            JOptionPane.showMessageDialog(null, "Price cannot be less than 0 or negative.");
                                            continue;
                                        }
                                    
                                        productPrice[Prodnumstr] = newPriceS;
                                        JOptionPane.showMessageDialog(null, "Price for " + productNames[Prodnumstr] + " updated successfully!");
                                        
                                    } catch (NumberFormatException e) {
                                        JOptionPane.showMessageDialog(null, "Invalid number format! Please enter a valid price.");
                                    }
                                    }
                                    break;
                                    }
                                    
                                    
                                    if (choiceopt == 1) {
                                    String addIndexStr = JOptionPane.showInputDialog(list + "Enter product number to add quantity:");
                                    if (addIndexStr == null) break;
                                    if (addIndexStr.trim().isEmpty()) {
                                        JOptionPane.showMessageDialog(null, "Please Enter valid product number.");
                                        continue;
                                    } 
                                    int addIndex;
                                    try {
                                        addIndex = Integer.parseInt(addIndexStr) - 1;
                                    } catch (NumberFormatException e) {
                                        JOptionPane.showMessageDialog(null, "Invalid product number.");
                                        continue;
                                    }
                                     
                                    if (addIndex >= 0 && addIndex < productNames.length) {
                                        String addQtyStr = JOptionPane.showInputDialog("Enter quantity to change:");
                                        if (addQtyStr == null) break;
                                        if (addQtyStr.trim().isEmpty()){
                                            JOptionPane.showMessageDialog(null, "Please put quantity");
                                            continue;
                                        }
                                        int addQty;
                                        try {
                                        addQty = Integer.parseInt(addQtyStr);
                                        } catch (NumberFormatException e) {
                                            JOptionPane.showMessageDialog(null, "Invalid quantity");
                                            continue;
                                        }
                                        productQty[addIndex] = addQty;
                                        JOptionPane.showMessageDialog(null, "Quantity updated!");
                                        break;
                                    } 
                                    
                                    } if (choiceopt == 2) {
                                        break;
                                    }
                                    
                                    

                                case 3:
                                    if (orderCount == 0) {
                                        JOptionPane.showMessageDialog(null, "No orders to update.");
                                        break;
                                    }
                                    String orderlist = "";
                                    for (int o = 0; o < orderCount; o++) {
                                        orderlist += (o + 1) +     
                                                ". Name: " + orderNames[o] + "\n" +
                                                " Address: " + orderAddress[o] + "\n" +
                                                " Cellphone: " + orderNumber[o] + "\n" +
                                                " Item: " + orderItem[o] + "\n" +
                                                " Quantity: " + orderAmount[o] + "\n" +
                                                " Status: " + orderStatus[o] + "\n" +
                                                " Payment Method: " + paymentMethod[o] + "\n" +
                                                " Receipt Number: " + paymentInfo[o] + "\n\n";
                                    }
                                    String uStr = JOptionPane.showInputDialog(orderlist + "\nEnter order number to update (or leave blank to cancel):");
                                    if (uStr == null || uStr.trim().isEmpty()) break;
                                    int orderupdt;
                                    try {
                                    orderupdt = Integer.parseInt(uStr) - 1;
                                    } catch (NumberFormatException e) {
                                        JOptionPane.showMessageDialog(null, "Invalid order number.");
                                        continue;
                                    }
                                    if (orderupdt >= 0 && orderupdt < orderCount) {
                                        String[] statusChoices = {"Shipping", "Delivered", "Canceled"};
                                        int st = JOptionPane.showOptionDialog(null, "Select new status for Tracking: " + orderTracking[orderupdt],
                                            "Update Order", 0, JOptionPane.INFORMATION_MESSAGE, null, statusChoices, statusChoices[0]);
                                        if (st >= 0 && st < statusChoices.length) {
                                            orderStatus[orderupdt] = statusChoices[st];
                                            JOptionPane.showMessageDialog(null, "Order status updated!");
                                        } else {
                                            JOptionPane.showMessageDialog(null, "No status selected.");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Invalid order number.");
                                    }
                                    break;

                                case 4:
                                    if (reportCount == 0) {
                                        JOptionPane.showMessageDialog(null, "No Report(s)/Letter(s) yet");
                                    } else {
                                        String reportes = ""; // build a string listing all orders
                                        for (int o = 0; o < reportCount; o++) { // loop orders
                                            reportes += (o + 1) + ". " + reportL[o] + "\n"; // append name, item, qty, status, tracking, payment
                                               }
                                        String optionsReport[] = { "Response", "Delete Report", "Back" };
                                        int reportopt = JOptionPane.showOptionDialog(null, "Report(s)\n" + reportes, "Report(s)/Letter(s)", 
                                                0, JOptionPane.INFORMATION_MESSAGE, null, optionsReport, optionsReport[0]);
                                        
                                        switch (reportopt) {
                                            case 0:
                                                String respond = JOptionPane.showInputDialog(reportes + "\nEnter report number to respond:");
                                                if (respond == null || respond.trim().isEmpty()) break;
                                                
                                                int respondIndex;
                                                try{
                                                
                                                respondIndex = Integer.parseInt(respond) - 1;
                                                } catch (NumberFormatException e) {
                                                    JOptionPane.showMessageDialog(null, "Invalid report number");
                                                    continue;
                                                }
                                                if (respondIndex >= 0 && respondIndex < reportCount) {
                                                        
                                                    String newReport = JOptionPane.showInputDialog("Enter your respond to this report:");
                                                    if (newReport == null || newReport.trim().isEmpty()) {
                                                        JOptionPane.showMessageDialog(null, "Please enter your respond");
                                                        continue;
                                                    }
                                                    reportL[respondIndex] = "Customer Report: " + reportL[respondIndex] + 
                                                                     "\nRespond: " + newReport.trim();

                                                    JOptionPane.showMessageDialog(null, "Report has been updated successfully!");
                                                    break;
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Invalid.");
                                                
                                                }break;

                                            case 1:
                                                String delete = JOptionPane.showInputDialog(reportes + "\nEnter report number to delete:");
                                                if (delete != null && !delete.trim().isEmpty()) {
                                                    int deleteIndex = Integer.parseInt(delete) - 1;
                                                    if (deleteIndex >= 0 && deleteIndex < reportCount) {
                                                        for (int i = deleteIndex; i < reportCount - 1; i++) {
                                                            reportL[i] = reportL[i + 1];
                                                        }
                                                        reportCount--;
                                                        JOptionPane.showMessageDialog(null, "Report deleted successfully!");
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Invalid report number.");
                                                    }
                                                }
                                                break;
                                                
                                            case 2:
                                                break;
                                        }
                                    }
                                    break;
                                case 5: 
                                    String addopt[] = {"Seller", "Manager", "Back"};
                                            int addoptchos = JOptionPane.showOptionDialog(null, "Choose an Option:", "Add Account", 0, 
                                                    JOptionPane.INFORMATION_MESSAGE, null, addopt, addopt[0]);
                                          if (addoptchos == 0) {
                                        String newSellername = JOptionPane.showInputDialog("Enter new Username");
                                        if (newSellername == null) {
                                            continue;
                                        } else if (newSellername.equals("") || newSellername.trim().isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Invalid Username");
                                            continue;
                                        }
                                        
                                        String newSellerpass = JOptionPane.showInputDialog("Enter new Password");
                                        if (newSellerpass == null) {
                                            continue;
                                        } else if (newSellerpass.equals("") || newSellerpass.trim().isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Invalid Password");
                                            continue;
                                        }
                                        
                                        
                                        Selleruser[Sellercount] = newSellername;
                                        Sellerpass[Sellercount] = newSellerpass;
                                        Sellercount++;
                                        JOptionPane.showMessageDialog(null, "Seller Account created successfully!\n" + "Username: " 
                                                + newSellername + "\n" + "Password: " + newSellerpass);
                                        continue;
                                    }
                                          
                                          
                                            if (addoptchos == 1) {
                                        String newManagername = JOptionPane.showInputDialog("Enter new Username");
                                        if (newManagername == null) {
                                            continue;
                                        } else if (newManagername.equals("") || newManagername.trim().isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Invalid Username");
                                            continue;
                                        }
                                        
                                        String newManagerpass = JOptionPane.showInputDialog("Enter new Password");
                                        if (newManagerpass == null) {
                                            continue;
                                        } else if (newManagerpass.equals("") || newManagerpass.trim().isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Invalid Password");
                                            continue;
                                        }
                                        
                                        
                                        Manageruser[Managercount] = newManagername;
                                        Managerpass[Managercount] = newManagerpass;
                                        Managercount++;
                                        JOptionPane.showMessageDialog(null, "Manager Account created successfully!\n" + "Username: " 
                                                + newManagername + "\n" + "Password: " + newManagerpass);
                                        continue;
                                    }
                                            if (addoptchos == 2) {
                                                break;
                                            }
                                            
                                case 6:
                                    managerActive = false;
                                    break;
                            }
                        }
                    
                    
                    break;

                case 3:
                    int exit = JOptionPane.showConfirmDialog(null, "Are you sure you want to Exit?", 
                            "Order Management and Tracking System", JOptionPane.YES_NO_OPTION);
                    if (exit == JOptionPane.NO_OPTION){
                        
                        continue;
                    } else if (exit == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Thank you for using\nOrder Management and Tracking System");
                        running = false;
                    break;
                    }
                    
                    
            }
        }
    }
}
