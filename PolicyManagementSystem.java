package collections_and_sets;

import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Policy {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate,
                  String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    // Getters for attributes (add setters if needed)
    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }
}

class PolicyManager {
    private Set<Policy> policySet = new HashSet<>();

    public void addPolicy(Policy policy) {
        policySet.add(policy);
    }

    public Set<Policy> getAllUniquePolicies() {
        return policySet;
    }

    public Set<Policy> getPoliciesExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysLater = today.plusDays(30);

        Set<Policy> expiringSoon = new HashSet<>();
        for (Policy policy : policySet) {
            if (policy.getExpiryDate().isBefore(thirtyDaysLater)) {
                expiringSoon.add(policy);
            }
        }
        return expiringSoon;
    }

    public Set<Policy> getPoliciesByCoverage(String coverageType) {
        Set<Policy> policiesByCoverage = new HashSet<>();
        for (Policy policy : policySet) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                policiesByCoverage.add(policy);
            }
        }
        return policiesByCoverage;
    }

    public Set<Policy> findDuplicatePolicies() {
        Set<String> policyNumbers = new HashSet<>();
        Set<Policy> duplicates = new HashSet<>();

        for (Policy policy : policySet) {
            if (!policyNumbers.add(policy.getPolicyNumber())) {
                duplicates.add(policy);
            }
        }
        return duplicates;
    }
}

public class PolicyManagementSystem {
    public static void main(String[] args) {
        PolicyManager policyManager = new PolicyManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nInsurance Policy Management System");
            System.out.println("1. Add Policy");
            System.out.println("2. Get All Unique Policies");
            System.out.println("3. Get Policies Expiring Soon");
            System.out.println("4. Get Policies by Coverage Type");
            System.out.println("5. Find Duplicate Policies");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Policy Number: ");
                    String policyNumber = scanner.nextLine();
                    System.out.print("Enter Policyholder Name: ");
                    String policyholderName = scanner.nextLine();
                    System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
                    LocalDate expiryDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_DATE);
                    System.out.print("Enter Coverage Type: ");
                    String coverageType = scanner.nextLine();
                    System.out.print("Enter Premium Amount: ");
                    double premiumAmount = scanner.nextDouble();
                    Policy policy = new Policy(policyNumber, policyholderName, expiryDate, coverageType, premiumAmount);
                    policyManager.addPolicy(policy);
                    System.out.println("Policy added successfully!");
                    break;

                case 2:
                    System.out.println("All Unique Policies:");
                    for (Policy p : policyManager.getAllUniquePolicies()) {
                        System.out.println(p.getPolicyNumber() + ": " + p.getPolicyholderName());
                    }
                    break;

                case 3:
                    System.out.println("Policies Expiring Soon:");
                    for (Policy p : policyManager.getPoliciesExpiringSoon()) {
                        System.out.println(p.getPolicyNumber() + ": " + p.getExpiryDate());
                    }
                    break;

                case 4:
                    System.out.print("Enter Coverage Type: ");
                    String covType = scanner.next();
                    System.out.println("Policies with Coverage Type '" + covType + "':");
                    for (Policy p : policyManager.getPoliciesByCoverage(covType)) {
                        System.out.println(p.getPolicyNumber() + ": " + p.getPolicyholderName());
                    }
                    break;
            }
        }
    }
}