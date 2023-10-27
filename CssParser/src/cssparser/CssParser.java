package cssparser;


import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CssParser {

    public static void main(String[] args) {
        String cssFilePath = "C:\\Users\\Vijaylakshmi.Kalasa\\eclipse-workspace\\javaTraining\\CssParser\\src\\cssparser\\test.css";
        Map<String, String> cssMap = readCSSFile(cssFilePath);

        // Print the class and attribute mappings
        for (String cssClass : cssMap.keySet()) {
            System.out.println("Class: " + cssClass);
            String attributes = cssMap.get(cssClass);
            System.out.println("Attributes:");
            String[] attributeArray = attributes.split(";");
            for (String attribute : attributeArray) {
                if (!attribute.trim().isEmpty()) {
                    String convertedAttribute = convertHexToRGB(attribute);
                    System.out.println("  " + convertedAttribute.trim());
                }
            }
            System.out.println("------------------------");
        }
    }

    public static Map<String, String> readCSSFile(String filePath) {
        Map<String, String> cssMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            String cssClass = null;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                // Check if the line contains a CSS class
                if (line.startsWith(".")) {
                    if (cssClass != null) {
                        // Save the previous class and its attributes
                        cssMap.put(cssClass,cssMap.get(cssClass).trim());
                    }
                    cssClass = line.substring(1); // Get the class name
                } else if (cssClass != null) {
                    // Append the line as an attribute for the current class
                    cssMap.put(cssClass, cssMap.get(cssClass) + " "+line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cssMap;
    }

    public static String convertHexToRGB(String attribute) {
        Pattern pattern = Pattern.compile("#[0-9A-Fa-f]{6}");
        Matcher matcher = pattern.matcher(attribute);

        while (matcher.find()) {
            String hexColor = matcher.group();
            String rgbColor = hexToRgb(hexColor);
            attribute = attribute.replace(hexColor, rgbColor);
        }

        return attribute;
    }

    public static String hexToRgb(String hex) {
        int r = Integer.parseInt(hex.substring(1, 3), 16);
        int g = Integer.parseInt(hex.substring(3, 5), 16);
        int b = Integer.parseInt(hex.substring(5, 7), 16);
        return "rgb(" + r + ", " + g + ", " + b + ")";
    }
}
