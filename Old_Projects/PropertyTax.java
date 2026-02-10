import java.util.InputMismatchException;
import java.util.Scanner;

//prompts are on main
public class PropertyTax {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("----------------PROPERTY TAX PAYMENT SYSTEM--------------------");
        System.out.println("Before using the system make sure you have:");
        System.out.println("1. An Assessment Report given from your local City Assessor Office");
        System.out.println("2. The tax rate depending on your current province");
        System.out.println("3. Make sure you pay on time, as listed in these dates below");
        System.out.println("MARCH 31" + "\nJUNE 30" + "\nSEPTEMBER 30" + "\nDECEMBER 31");
        System.out.println("----------------------------------------------------------------\n");

        try {
            Thread.sleep(5000); // Delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.print("Full Legal Name: ");
        String name = scnr.nextLine();
        double asdVal = getAssessedValue(scnr);
        double rate = getTaxRate(scnr);
        DiscountedTaxCalc discountedTaxCalc = new DiscountedTaxCalc(0.0);
        discountedTaxCalc.taxCalc(asdVal, rate);
        double taxAmount = discountedTaxCalc.getTax();
        System.out.println("Calculated tax: " + taxAmount);
        boolean payInFull = getPayInFull(scnr);
        if (payInFull) {
            taxAmount *= (1 - discountedTaxCalc.getDiscount());
            System.out.println("Paid in full, applying 20% discount.");
        } else {
            System.out.println("Not paying in full, no discount applied.");
        }
        System.out.println("Updated tax: " + taxAmount);
        PaymentMethod paymentMethod = getPaymentMethod(scnr);
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.processPayment(taxAmount, paymentMethod);

    // Print receipt
        System.out.println("\nReceipt:");
        System.out.println("---------");
        System.out.println("Name: " + name);
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Payment Amount: " + taxAmount);
        System.out.println("Amount Paid: " + paymentProcessor.getAmountPaid());
        System.out.println("---------");
        System.out.println("Thank you for your payment!");

        scnr.close();
    }
//assessed value exception checker
    private static double getAssessedValue(Scanner scnr) {
        while (true) {
            try {
                System.out.print("Property Assessed Value (from your Assessment Report)): ");
                double asdVal = scnr.nextDouble();
                if (asdVal < 0) {
                    System.out.println("Assessed value cannot be negative. Please try again.");
                } else {
                    return asdVal;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scnr.next(); // Clear invalid input
            }
        }
    }
//tax rate exception checker
    private static double getTaxRate(Scanner scnr) {
    while (true) {
        try {
            System.out.print("Enter the tax rate without the percentage: ");
            double rate = scnr.nextDouble();
            if (rate < 0) {
                System.out.println("Tax rate cannot be negative. Please try again.");
            } else {
                return rate;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scnr.next(); // Clear invalid input
        }
    }
}
//pay in full condition yes or no
    private static boolean getPayInFull(Scanner scnr) {
        while (true) {
            System.out.print("Paying in full? (yes/no): ");
            String input = scnr.next().trim().toLowerCase();
            switch (input) {
                case "yes":
                    return true;
                case "no":
                    return false;
                default:
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                    break;
            }
        }
    }
//payment method choice in switch
    private static PaymentMethod getPaymentMethod(Scanner scnr) {
        while (true) {
            System.out.println("Select a payment method (1-3):");
            System.out.println("1. Credit Card");
            System.out.println("2. PayPal");
            System.out.println("3. Bank Transfer");
            System.out.print("->");
            try {
                int choice = scnr.nextInt();
                switch (choice) {
                    case 1:
                        return PaymentMethod.CREDIT_CARD;
                    case 2:
                        return PaymentMethod.PAYPAL;
                    case 3:
                        return PaymentMethod.BANK_TRANSFER;
                    default:
                        System.out.println("Invalid choice. Please choose again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scnr.next(); // Clear invalid input
            }
        }
    }
}
// tax calculation
    class TaxCalc {
        private double tax;

        public TaxCalc(double tax) {
            this.tax = tax;
    }

        public void taxCalc(double asdVal, double rate) {
            rate = rate / 100;
            tax = asdVal * rate;
    }

        public double getTax() {
            return tax;
    }
}
// discount if pay in full condition is met
    class DiscountedTaxCalc extends TaxCalc {
        private static final double DISCOUNT = 0.2;

        public DiscountedTaxCalc(double tax) {
            super(tax);
    }

    public void payTax(double asdVal, double rate, boolean payInFull, PaymentMethod paymentMethod) {
        taxCalc(asdVal, rate);
        double taxAmount = getTax();
        if (payInFull) {
            taxAmount *= (1 - DISCOUNT);
            System.out.println("Paid in full, applying 20% discount.");
        } else {
            System.out.println("Not paying in full, no discount applied.");
        }
        System.out.println("Calculated tax: " + taxAmount);
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.processPayment(taxAmount, paymentMethod);
    }

    public double getDiscount() {
        return DISCOUNT;
    }
}
// payment methods
    enum PaymentMethod {
    CREDIT_CARD, PAYPAL, BANK_TRANSFER
}

// payment processing logic
    class PaymentProcessor {
        private double amountPaid;

        public void processPayment(double payment, PaymentMethod paymentMethod) {
            Scanner scnr = new Scanner(System.in);
            double amountToPay = 0;

            switch (paymentMethod) {
            case CREDIT_CARD:
                System.out.println("Processing credit card payment of " + payment);
                System.out.print("Enter your credit card number: ");
                scnr.nextLine();
                System.out.print("Enter your credit card expiration date (MM/YY): ");
                scnr.nextLine();
                System.out.print("Enter your credit card security code: ");
                scnr.nextLine();
                System.out.print("Enter the amount to pay: ");
                amountToPay = scnr.nextDouble();
                break;

            case PAYPAL:
                System.out.println("Processing PayPal payment of " + payment);
                System.out.print("Enter your PayPal email address: ");
                scnr.nextLine();
                System.out.print("Enter your PayPal password: ");
                scnr.nextLine();
                System.out.print("Enter the amount to pay: ");
                amountToPay = scnr.nextDouble();
                break;

            case BANK_TRANSFER:
                System.out.println("Processing bank transfer payment of " + payment);
                System.out.print("Enter your bank account number: ");
                scnr.nextLine();
                System.out.print("Enter your bank routing number: ");
                scnr.nextLine();
                System.out.print("Enter the amount to pay: ");
                amountToPay = scnr.nextDouble();
                break;
        }

            System.out.print("Processing payment");
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(300); // Delay for 0.3 seconds
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.print(".");
            }
            System.out.println("\nPayment processed successfully.");
            amountPaid = amountToPay;
            scnr.close();
    }

        public double getAmountPaid() {
            return amountPaid;
    }
}