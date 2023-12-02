
public class Main {
    public interface RPGCharacter {
        int getHP();
        int getSpeed();
        void performAttack();
        void useAbility();
    }

    public interface RPGCharacterWithAccessory extends RPGCharacter {
        void equipAccessory(Accessory accessory);
        void setHP(int hp);
        void setSpeed(int speed);
    }

    public static class Engineer implements RPGCharacterWithAccessory {
        private int hp;
        private int speed;

        @Override
        public int getHP() {
            return hp;
        }

        @Override
        public int getSpeed() {
            return speed;
        }

        @Override
        public void performAttack() {
            System.out.println("Engineer is performing an attack");
        }

        @Override
        public void useAbility() {
            System.out.println("Engineer is using the Building ability");

        }

        @Override
        public void equipAccessory(Accessory accessory) {
            accessory.applyEffect(this);
        }

        @Override
        public void setHP(int hp) {
            this.hp = hp;
        }

        @Override
        public void setSpeed(int speed) {
            this.speed = speed;
        }
    }

    public static class Blacksmith implements RPGCharacterWithAccessory {
        private int hp;
        private int speed;

        @Override
        public int getHP() {
            return hp;
        }

        @Override
        public int getSpeed() {
            return speed;
        }

        @Override
        public void performAttack() {
            System.out.println("Blacksmith is performing an attack");
        }
        @Override
        public void useAbility() {
            System.out.println("Blacksmith is using the Craft ability");
        }

        @Override
        public void equipAccessory(Accessory accessory) {
            accessory.applyEffect(this);
        }

        @Override
        public void setHP(int hp) {
            this.hp = hp;
        }

        @Override
        public void setSpeed(int speed) {
            this.speed = speed;
        }
    }

    public interface Accessory {
        void applyEffect(RPGCharacter character);
    }

    public static class Bracelet implements Accessory {
        @Override
        public void applyEffect(RPGCharacter character) {
            if (character instanceof RPGCharacterWithAccessory) {
                RPGCharacterWithAccessory characterWithAccessory = (RPGCharacterWithAccessory) character;
                characterWithAccessory.setHP(characterWithAccessory.getHP() + 10);
                System.out.println("Bracelet effect applied - HP +10");
            }
        }
    }

    public static class Anklet implements Accessory {
        @Override
        public void applyEffect(RPGCharacter character) {
            if (character instanceof RPGCharacterWithAccessory) {
                RPGCharacterWithAccessory characterWithAccessory = (RPGCharacterWithAccessory) character;
                characterWithAccessory.setSpeed(characterWithAccessory.getSpeed() + 5);
                System.out.println("Anklet effect applied - Speed +5");
            }
        }
    }


    public static void main(String[] args) {

        Engineer engineer = new Engineer();
        engineer.setSpeed(10);
        engineer.setHP(100);
        System.out.println("Engineer HP: " + engineer.getHP());
        System.out.println("Engineer Speed: " + engineer.getSpeed());

        Blacksmith blacksmith = new Blacksmith();
        blacksmith.setSpeed(5);
        blacksmith.setHP(150);
        System.out.println("Blacksmith HP: " + blacksmith.getHP());
        System.out.println("Blacksmith Speed: " + blacksmith.getSpeed());


        Bracelet bracelet = new Bracelet();
        Anklet anklet = new Anklet();


        engineer.equipAccessory(bracelet);
        System.out.println("Engineer HP after equipping Bracelet: " + engineer.getHP());


        blacksmith.equipAccessory(anklet);
        System.out.println("Blacksmith Speed after equipping Anklet: " + blacksmith.getSpeed());

        //engineer ใช้ Ability
        engineer.useAbility();
        //blacksmith ใช้ Ability
        blacksmith.useAbility();
        //engineer โจมตี
        engineer.performAttack();
        //blacksmith โจมตี
        blacksmith.performAttack();
    }
}


