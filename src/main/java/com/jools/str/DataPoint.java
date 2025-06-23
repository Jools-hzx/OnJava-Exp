package com.jools.str;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/8 17:55
 * @description: TODO
 */
public class DataPoint {

    private String location;
    private Double temperature;

    public DataPoint(String location, Double temperature) {
        this.location = location;
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return """
                Location: %s
                Temperature: %.2f
                """.formatted(location, temperature);
    }

    public static void main(String[] args) {
        var hill = new DataPoint("Hill Valley", 65.3);
        var brooklyn = new DataPoint("Brooklyn", 83.9);
        System.out.println(hill);
        System.out.println(brooklyn);

        /*
         输出:
            Location: Hill Valley
            Temperature: 65.30

            Location: Brooklyn
            Temperature: 83.90
        */
    }
}
