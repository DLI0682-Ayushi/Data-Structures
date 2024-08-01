package Assignment2;
import java.text.SimpleDateFormat;
import java.util.*;

class Policy {
    String policyNumber;
    String policyholderName;
    Date expiryDate;

    public Policy(String policyNumber, String policyholderName, Date expiryDate) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Policy Number: " + policyNumber + ", Policyholder Name: " + policyholderName + ", Expiry Date: " + expiryDate;
    }
}

public class PolicyManagementSystem {
    private static HashMap<String, Policy> policyMap = new HashMap<>();
    private static LinkedHashMap<String, Policy> insertionOrderMap = new LinkedHashMap<>();
    private static TreeMap<Date, Policy> expiryDateMap = new TreeMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Add Policy");
            System.out.println("2. Retrieve Policy by Number");
            System.out.println("3. List Policies Expiring in Next 30 Days");
            System.out.println("4. List Policies by Policyholder");
            System.out.println("5. Remove Expired Policies");
            System.out.println("6. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addPolicy(scanner);
                    break;
                case 2:
                    retrievePolicyByNumber(scanner);
                    break;
                case 3:
                    listPoliciesExpiringInNext30Days();
                    break;
                case 4:
                    listPoliciesByPolicyholder(scanner);
                    break;
                case 5:
                    removeExpiredPolicies();
                    break;
                case 6:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addPolicy(Scanner scanner) {
        System.out.println("Enter Policy Number:");
        String policyNumber = scanner.nextLine();
        System.out.println("Enter Policyholder Name:");
        String policyholderName = scanner.nextLine();
        System.out.println("Enter Expiry Date (yyyy-MM-dd):");
        String expiryDateString = scanner.nextLine();
        Date expiryDate = parseDate(expiryDateString);

        Policy policy = new Policy(policyNumber, policyholderName, expiryDate);
        policyMap.put(policyNumber, policy);
        insertionOrderMap.put(policyNumber, policy);
        expiryDateMap.put(expiryDate, policy);

        System.out.println("Policy added successfully.");
    }

    private static void retrievePolicyByNumber(Scanner scanner) {
        System.out.println("Enter Policy Number:");
        String policyNumber = scanner.nextLine();
        Policy policy = policyMap.get(policyNumber);
        if (policy != null) {
            System.out.println(policy);
        } else {
            System.out.println("Policy not found.");
        }
    }

    private static void listPoliciesExpiringInNext30Days() {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        Date next30Days = calendar.getTime();

        for (Map.Entry<Date, Policy> entry : expiryDateMap.headMap(next30Days, true).entrySet()) {
            if (entry.getKey().after(today)) {
                System.out.println(entry.getValue());
            }
        }
    }

    private static void listPoliciesByPolicyholder(Scanner scanner) {
        System.out.println("Enter Policyholder Name:");
        String policyholderName = scanner.nextLine();
        for (Policy policy : policyMap.values()) {
            if (policy.policyholderName.equals(policyholderName)) {
                System.out.println(policy);
            }
        }
    }

    private static void removeExpiredPolicies() {
        Date today = new Date();
        Iterator<Map.Entry<Date, Policy>> iterator = expiryDateMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Date, Policy> entry = iterator.next();
            if (entry.getKey().before(today)) {
                policyMap.remove(entry.getValue().policyNumber);
                insertionOrderMap.remove(entry.getValue().policyNumber);
                iterator.remove();
            }
        }
        System.out.println("Expired policies removed.");
    }

    private static Date parseDate(String dateString) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (Exception e) {
            throw new RuntimeException("Invalid date format. Please use yyyy-MM-dd.");
        }
    }
}
