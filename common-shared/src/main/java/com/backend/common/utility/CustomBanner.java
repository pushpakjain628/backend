package com.backend.common.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class CustomBanner implements Banner {




    @Override
    public void printBanner(Environment environment, Class<?> sourceClass, java.io.PrintStream out) {
        // Generate dynamic banner text
        String bannerText = generateBannerText();
        // Print the banner text to the console
        out.println(bannerText);
    }

    private String generateBannerText() {
        // Implement logic to generate dynamic banner text
        // You can use ASCII art generators or other methods
        return "  Dynamic Banner Text";
    }
}