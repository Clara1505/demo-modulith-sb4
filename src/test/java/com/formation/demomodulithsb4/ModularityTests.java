package com.formation.demomodulithsb4;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

class ModularityTests {

    @Test
    void verifiesModuleStructure() {
        ApplicationModules.of(DemoModulithSb4Application.class).verify();
    }
}