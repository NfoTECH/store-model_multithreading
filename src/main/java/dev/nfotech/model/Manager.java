package dev.nfotech.model;

import dev.nfotech.enums.Qualification;
import dev.nfotech.enums.Role;

public class Manager {
    Role role;

    private static Manager manager = new Manager();


    Manager(){
        super();

    }

    public Role getRole() {
        return role;
    }

    public static Manager getInstance(){
        if(manager == null){
            manager = new Manager();
        }
        return manager;
    }

    public String hireACashier (Qualification qualification, int age) {
        if ((role == Role.MANAGER)) {
            if (age >= 28 && qualification.equals(Qualification.ACCOUNTANCY))
                return "You are Employed";
            else return "Sorry, you are not qualified";
        } else {
            return "Only Manager can hire";
        }
    }
}

