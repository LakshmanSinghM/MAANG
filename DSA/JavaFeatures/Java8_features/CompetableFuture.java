package JavaFeatures.Java8_features;

import java.util.concurrent.CompletableFuture;

class AsychDemo {
    public String getFirstName() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "Lakshman";
    }

    public String getLastName() {
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "Singh";
    }
}

public class CompetableFuture {

    public static void main(String[] args) {
        
        AsychDemo demo = new AsychDemo();
    
        Long curLong = System.currentTimeMillis();
    
        CompletableFuture<String> firstNCompletableFuture = CompletableFuture.supplyAsync(()->demo.getFirstName());
        CompletableFuture<String> lastNameCompletableFuture = CompletableFuture.supplyAsync(()->demo.getLastName());
    
        String fullName = firstNCompletableFuture.thenCombine(lastNameCompletableFuture, (f, l)-> f+l).join();
    
        long lastCurTime = System.currentTimeMillis();
    
        System.out.println("Total time taken  "+(lastCurTime-curLong) + " fullName : "+fullName);
        // System.out.println("")
    }

}