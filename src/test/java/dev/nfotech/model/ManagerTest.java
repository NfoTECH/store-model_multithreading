package dev.nfotech.model;

import dev.nfotech.enums.Qualification;
import dev.nfotech.enums.Role;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ManagerTest {

    @Test
    @DisplayName(
            "Should return Sorry, you are not qualified when the role is manager, age is less than 28 and qualification is accountancy")
    void
    hireACashierWhenRoleIsManagerAgeIsLessThan28AndQualificationIsAccountancyThenReturnSorryYouAreNotQualified() {
        Manager manager = new Manager();
        manager.role = Role.MANAGER;
        String result = manager.hireACashier(Qualification.ACCOUNTANCY, 27);
        assertEquals("Sorry, you are not qualified", result);
    }

    @Test
    @DisplayName(
            "Should return You are Employed when the role is manager, age is greater than 28 and qualification is accountancy")
    void
    hireACashierWhenRoleIsManagerAgeIsGreaterThan28AndQualificationIsAccountancyThenReturnYouAreEmployed() {
        Manager manager = new Manager();
        manager.role = Role.MANAGER;
        String result = manager.hireACashier(Qualification.ACCOUNTANCY, 28);
        assertEquals("You are Employed", result);
    }
}