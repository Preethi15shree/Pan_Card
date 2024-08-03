import java.util.Random;
import java.util.Scanner;

public class pancard {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first name:");
        String firstname = sc.nextLine();

        System.out.println("Enter the last name:");
        String lastname = sc.nextLine();

        System.out.println("Is this PAN card for a Personal or an Organization? (Enter 'P' for Personal or 'O' for Organization):");
        char type = sc.nextLine().toUpperCase().charAt(0);

        while (type != 'P' && type != 'O') {
            System.out.println("Invalid input. Please enter 'P' for Personal or 'O' for Organization:");
            type = sc.nextLine().toUpperCase().charAt(0);
        }

        String dateInfo;
        if (type == 'P') {
            System.out.println("Enter the date of birth (DD/MM/YYYY):");
            dateInfo = sc.nextLine();
        } else {
            System.out.println("Enter the date of incorporation (DD/MM/YYYY):");
            dateInfo = sc.nextLine();
        }

        String pancardNumber = generatePan(lastname, type);
        System.out.println("PAN NUMBER: " + pancardNumber);

        System.out.println("PAN CARD DETAILS");
        System.out.println("_________________");
        
        System.out.println("First Name: " + firstname);
        System.out.println("Last Name: " + lastname);
        System.out.println("Type: " + (type == 'P' ? "Personal" : "Organization"));
        System.out.println((type == 'P' ? "Date of Birth: " : "Date of Incorporation: ") + dateInfo);
        System.out.println("Generated PAN Number: " + pancardNumber);
    }

    public static String generatePan(String lastname, char type) {
        Random rand = new Random();
        StringBuilder pan = new StringBuilder();
        
        for (int i = 0; i < 3; i++) {
            char randLetter = (char) (rand.nextInt(26) + 'A');
            pan.append(randLetter);
        }
        
        pan.append(type);
        
        char lastInitial = Character.toUpperCase(lastname.charAt(0));
        pan.append(lastInitial);
        
        int num = rand.nextInt(10000);
        String randNum = String.format("%04d", num);
        pan.append(randNum);
        
        char lastLetter = (char) (rand.nextInt(26) + 'A');
        pan.append(lastLetter);
        
        return pan.toString();
    }
}
