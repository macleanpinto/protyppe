package com.test;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;

public class App {

    public static void main(String[] args) {
        // Load the Drools rules from the classpath
        KieServices kieServices = KieServices.Factory.get();
      
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();

        kieFileSystem.write(ResourceFactory.newClassPathResource("vatRules.drl"));

        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem).buildAll();
        KieContainer kieContainer = kieServices.newKieContainer(kieBuilder.getKieModule().getReleaseId());

        // Create a KieSession
        KieSession kieSession = kieContainer.newKieSession();

        // Create a Transaction object
        Transaction transaction = new Transaction();
        transaction.setAsinCode("PTC_A");
        transaction.setCategoryCode(3);

        // Apply the rules to the Transaction
        kieSession.insert(transaction);
        System.out.print(kieSession.fireAllRules());

        // Print the results
        System.out.println("VAT Rate: " + transaction.getVatRate());
        System.out.println("Status: " + transaction.getStatus());

        // Dispose of the KieSession
        kieSession.dispose();
    }
}
