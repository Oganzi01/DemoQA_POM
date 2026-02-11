package com.demoqa.core;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import java.util.Optional;

public class MyListener implements TestWatcher {
    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("Тест пройден: " + context.getDisplayName());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("[FAILED] Тест упал: " + context.getDisplayName());
        System.out.println("Причина: " + cause.getMessage());
    }
}
