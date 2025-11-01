package facade;


class InstructionsFacade {
    public void showQuickStart() {
        System.out.println("\n START GUIDE");
        System.out.println("1. Choose a hero build type");
        System.out.println("2. Select your favorite character");
        System.out.println("3. Use numbers to choose actions in battle");
        System.out.println("4. Defeat your opponent to win!");
    }

    public void showBattleInstructions() {
        System.out.println("\n BATTLE CONTROLS");
        System.out.println("1. Normal Attack - Basic attack with current strategy");
        System.out.println("2. Change Strategy - Switch between Melee/Ranged/Magic");
        System.out.println("3. Special Ability - Use your hero type's special move");
        System.out.println("4. Unique Ability - Use your character's unique move");
    }

    public void showHeroTypesInfo() {
        System.out.println("\n HERO TYPES ");
        System.out.println("Warrior - High health, physical attacks");
        System.out.println("Mage - Low health, magical attacks");
        System.out.println("Archer - Balanced, precise attacks");
    }

    public void showBuildTypesInfo() {
        System.out.println("\n BUILD TYPES");
        System.out.println("Standard - Balanced stats for each type");
        System.out.println("Tank - Very high health, lower damage");
        System.out.println("Glass Cannon - Very low health, high damage");
        System.out.println("Custom - Set your own stats");
    }

    public void showCompleteInstructions() {
        showQuickStart();
        showBattleInstructions();
        showHeroTypesInfo();
        showBuildTypesInfo();
    }
}