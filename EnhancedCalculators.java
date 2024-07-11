import java.util.Scanner;

public class EnhancedCalculators {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2;
        char operator;

        System.out.println("Enhanced Calculator");
        System.out.println("Available operations:");
        System.out.println("1. Basic Arithmetic (+, -, *, /)");
        System.out.println("2. Scientific Functions (sqrt, sin, cos, tan)");
        System.out.println("3. Unit Conversions (length, temperature)");
        System.out.println("4. Exponentiation (x^y)");
        System.out.println("5. Currency Conversion (Dollars to Rupees)");

        System.out.print("Enter your choice (1/2/3/4/5): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Basic arithmetic
                // ...
                System.out.println("Enter the first number:");
                num1 = scanner.nextDouble();
                System.out.println("Enter the operator (+, -, *, /):");
                operator = scanner.next().charAt(0);
                System.out.println("Enter the second number:");
                num2 = scanner.nextDouble();
                performBasicOperation(num1, num2, operator);
                break;

            case 2:
                // Scientific functions
                // ...
                System.out.println("Enter a number for scientific calculation:");
                num1 = scanner.nextDouble();
                performScientificCalculation(num1);
                break;

            case 3:
                // Unit conversions
                System.out.println("1. Length (meters to feet)");
                System.out.println("2. Temperature (Celsius to Fahrenheit)");
                System.out.print("Choose a unit conversion (1 or 2): ");
                int unitChoice = scanner.nextInt();
                performUnitConversion(unitChoice);
                break;

            case 4:
                // Exponentiations
                System.out.print("Enter base (x): ");
                double base = scanner.nextDouble();
                System.out.print("Enter exponent (y): ");
                double exponent = scanner.nextDouble();
                double result = Math.pow(base, exponent);
                System.out.println("Result: " + result);
                break;

            case 5:
                // Currency conversion (USD to Rupees)
                System.out.print("Enter amount in USD: ");
                double usdAmount = scanner.nextDouble();
                double rupees = usdAmount * 80.5; // Assuming 1 USD = 74.5 INR
                System.out.printf("%.2f USD = %.2f Rupees%n", usdAmount, rupees);
                break;

            default:
                System.out.println("Invalid choice. Please select 1, 2, 3, 4, or 5.");
        }
    }

    // Other methods (performBasicOperation, performScientificCalculation, etc.)...

    private static void performBasicOperation(double num1, double num2, char operator) {
        double result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Invalid operator!");
                return;
        }
        System.out.println("Result: " + result);
    }

    // Scientific calculations
    private static void performScientificCalculation(double num) {
        System.out.println("Square root: " + Math.sqrt(num));
        System.out.println("Sine: " + Math.sin(num));
        System.out.println("Cosine: " + Math.cos(num));
        System.out.println("Tangent: " + Math.tan(num));
        
    }

    private static void performUnitConversion(int choice) {
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case 1:
                System.out.print("Enter length in meters: ");
                double meters = scanner.nextDouble();
                double feet = meters * 3.28084;
                System.out.println("Feet: " + feet);
                break;
            case 2:
                System.out.print("Enter temperature in Celsius: ");
                double celsius = scanner.nextDouble();
                double fahrenheit = (celsius * 9 / 5) + 32;
                System.out.println("Fahrenheit: " + fahrenheit);
                break;
            default:
                System.out.println("Invalid unit conversion choice.");
        }
    }
}
