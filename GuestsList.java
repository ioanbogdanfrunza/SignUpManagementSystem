package signupmanagementsystem;

import java.util.ArrayList;

public class GuestsList {
    int n; // numarul de locuri disponibile la eveniment
    ArrayList<Guest> guestsList;
    ArrayList<Guest> waitList;
    
    public GuestsList(int n) {
        this.n = n;
        guestsList = new ArrayList(n);
        waitList = new ArrayList();
    }
    
    int addGuest(Guest g) {
        if(checkEmail(g.email) != 0) {
            return -1;
        } else {
            if(guestsList.size() < n) {
                guestsList.add(g);
                return -2;
            } else {
                waitList.add(g);
                return waitList.indexOf(g);
            }
        }
    }
    
    int checkName(String lastName, String firstName) {
        for(int i = 0; i < guestsList.size(); i++) {
            if(guestsList.get(i).lastName.equals(lastName)) {
                if(guestsList.get(i).firstName.equals(firstName)) {
                    return 1; // am gasit in lista de participanti
                }
            }
        }
        
        for(int i = 0; i < waitList.size(); i++) {
            if(waitList.get(i).lastName.equals(lastName)) {
                if(waitList.get(i).firstName.equals(firstName)) {
                    return 2; // am gasit in lista de asteptare
                }
            }
        }
        
        return 0; // nu am gasit
    }
    
    int checkEmail(String email) {
        for(int i = 0; i < guestsList.size(); i++) {
            if(guestsList.get(i).email.equals(email)) {
                return 1; // am gasit in lista de participanti
            }
        }
        
        for(int i = 0; i < waitList.size(); i++) {
            if(waitList.get(i).email.equals(email)) {
                return 2; //am gasit in lista de asteptare
            }
        }
        
        return 0; //nu am gasit
    }
    
    int checkPhoneNumber(String phoneNumber) {
        for(int i = 0; i < guestsList.size(); i++) {
            if(guestsList.get(i).phoneNumber.equals(phoneNumber)) {
                return 1; // am gasit in lista de participanti
            }
        }
        
        for(int i = 0; i < waitList.size(); i++) {
            if(waitList.get(i).phoneNumber.equals(phoneNumber)) {
                return 2; // am gasit in lista de asteptare
            }
        }
        
        return 0; // nu am gasit
    }
    
    boolean removeName(String lastName, String firstName) {
        if(checkName(lastName, firstName) == 0) { // nu exista numele
            return false;
        } else if(checkName(lastName, firstName) == 2) { // persoana este in lista de asteptare
            int i;
            for(i = 0; i < waitList.size(); i++) {
                if(waitList.get(i).lastName.equals(lastName)) {
                    if(waitList.get(i).firstName.equals(firstName)) {
                        break;
                    }
                }
            }
            waitList.remove(i);
            return true;
        } else if(checkName(lastName, firstName) == 1) { // persoana este in lista de participanti
            int i;
            for(i = 0; i < guestsList.size(); i++) {
                if(guestsList.get(i).lastName.equals(lastName)) {
                    if(guestsList.get(i).firstName.equals(firstName)) {
                        break;
                    }
                }
            }
            guestsList.remove(i);
            if(waitList.size() != 0) { // adaug la lista de participanti prima persoana inscrisa in lista de asteptare
                Guest aux = waitList.remove(0);
                guestsList.add(aux);
                System.out.println("[" + aux.lastName + " " + aux.firstName +
                        "] Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
            }
            return true;
        }
        return false;
    }
    
    boolean removeEmail(String email) {
        if (checkEmail(email) == 0) { // nu exista email
            return false;
        } else if(checkEmail(email) == 2) { // persoana se afla in lista de asteptare
            int i;
            for(i = 0; i < waitList.size(); i++) {
                if(waitList.get(i).email.equals(email)) {
                    break;
                }
            }
            waitList.remove(i);
            return true;
        } else if(checkEmail(email) == 1) { // persoana este in lista de participanti
            int i;
            for(i = 0; i < guestsList.size(); i++) {
                if(guestsList.get(i).email.equals(email)) {
                    break;
                }
            }
            guestsList.remove(i);
            if(waitList.size() != 0) { // adaug la lista de participanti prima persoana inscrisa in lista de asteptare
                Guest aux = waitList.remove(0);
                guestsList.add(aux);
                System.out.println("[" + aux.lastName + " " + aux.firstName +
                        "] Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
            }
            return true;
        }
        return false;
    }
    
    boolean removePhoneNumber(String phoneNumber) {
        if (checkPhoneNumber(phoneNumber) == 0) { // nu exista email
            return false;
        } else if(checkPhoneNumber(phoneNumber) == 2) { // persoana se afla in lista de asteptare
            int i;
            for(i = 0; i < waitList.size(); i++) {
                if(waitList.get(i).phoneNumber.equals(phoneNumber)) {
                    break;
                }
            }
            waitList.remove(i);
            return true;
        } else if(checkPhoneNumber(phoneNumber) == 1) { // persoana este in lista de participanti
            int i;
            for(i = 0; i < guestsList.size(); i++) {
                if(guestsList.get(i).phoneNumber.equals(phoneNumber)) {
                    break;
                }
            }
            guestsList.remove(i);
            if(waitList.size() != 0) { // adaug la lista de participanti prima persoana inscrisa in lista de asteptare
                Guest aux = waitList.remove(0);
                guestsList.add(aux);
                System.out.println("[" + aux.lastName + " " + aux.firstName +
                        "] Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
            }
            return true;
        }
        return false;
    }
    
    ArrayList<Guest> getGuestsList() {
        return this.guestsList;
    }
    
    ArrayList<Guest> getWaitList() {
        return this.waitList;
    }
    
    int availableTickets() {
        return n - guestsList.size();
    }
    
    int guestsNumber() {
        return guestsList.size();
    }
    
    int waitListNumber() {
        return waitList.size();
    }
    
    int totalNumber() {
        return guestsList.size() + waitList.size();
    }
    
    void showGuestsList() {
        for(int i = 0; i < guestsList.size(); i++) {
            System.out.println("\t" + (i + 1) + " Nume: " + guestsList.get(i).lastName + " " + guestsList.get(i).firstName +
                                    ", Email: " + guestsList.get(i).email + ", Telefon: " + guestsList.get(i).phoneNumber);
        }
    }
    
    void showWaitList() {
        for(int i = 0; i < waitList.size(); i++) {
            System.out.println("\t" + (i + 1) + " Nume: " + waitList.get(i).lastName + " " + waitList.get(i).firstName +
                                    ", Email: " + waitList.get(i).email + ", Telefon: " + waitList.get(i).phoneNumber);
        }
    }
    
    boolean updateLastNameKnowingName(String lastName, String firstName, String newLastName) {
        for(int i = 0; i < guestsList.size(); i++) {
            if(guestsList.get(i).lastName.equals(lastName) && guestsList.get(i).firstName.equals(firstName)) {
                guestsList.get(i).lastName = newLastName;
                return true;
            }
        }
        for(int i = 0; i < waitList.size(); i++) {
            if(waitList.get(i).lastName.equals(lastName) && waitList.get(i).firstName.equals(firstName)) {
                waitList.get(i).lastName = newLastName;
                return true;
            }
        }
        return false;
    }
    
    boolean updateFirstNameKnowingName(String lastName, String firstName, String newFirstName) {
        for(int i = 0; i < guestsList.size(); i++) {
            if(guestsList.get(i).lastName.equals(lastName) && guestsList.get(i).firstName.equals(firstName)) {
                guestsList.get(i).firstName = newFirstName;
                return true;
            }
        }
        for(int i = 0; i < waitList.size(); i++) {
            if(waitList.get(i).lastName.equals(lastName) && waitList.get(i).firstName.equals(firstName)) {
                waitList.get(i).firstName = newFirstName;
                return true;
            }
        }
        return false;
    }
    
    boolean updateEmailKnowingName(String lastName, String firstName, String newEmail) {
        for(int i = 0; i < guestsList.size(); i++) {
            if(guestsList.get(i).lastName.equals(lastName) && guestsList.get(i).firstName.equals(firstName)) {
                guestsList.get(i).email = newEmail;
                return true;
            }
        }
        for(int i = 0; i < waitList.size(); i++) {
            if(waitList.get(i).lastName.equals(lastName) && waitList.get(i).firstName.equals(firstName)) {
                waitList.get(i).email = newEmail;
                return true;
            }
        }
        return false;
    }
    
    boolean updatePhoneNumberKnowingName(String lastName, String firstName, String newPhoneNumber) {
        for(int i = 0; i < guestsList.size(); i++) {
            if(guestsList.get(i).lastName.equals(lastName) && guestsList.get(i).firstName.equals(firstName)) {
                guestsList.get(i).phoneNumber = newPhoneNumber;
                return true;
            }
        }
        for(int i = 0; i < waitList.size(); i++) {
            if(waitList.get(i).lastName.equals(lastName) && waitList.get(i).firstName.equals(firstName)) {
                waitList.get(i).phoneNumber = newPhoneNumber;
                return true;
            }
        }
        return false;
    }
    
    boolean updateLastNameKnowingEmail(String email, String newLastName) {
        for(int i = 0; i < guestsList.size(); i++) {
            if(guestsList.get(i).email.equals(email)) {
                guestsList.get(i).lastName = newLastName;
                return true;
            }
        }
        for(int i = 0; i < waitList.size(); i++) {
            if(waitList.get(i).email.equals(email)) {
                waitList.get(i).lastName = newLastName;
                return true;
            }
        }
        return false;
    }
    
    boolean updateFirstNameKnowingEmail(String email, String newFirstName) {
        for(int i = 0; i < guestsList.size(); i++) {
            if(guestsList.get(i).email.equals(email)) {
                guestsList.get(i).firstName = newFirstName;
                return true;
            }
        }
        for(int i = 0; i < waitList.size(); i++) {
            if(waitList.get(i).email.equals(email)) {
                waitList.get(i).firstName = newFirstName;
                return true;
            }
        }
        return false;
    }
    
    boolean updateEmailKnowingEmail(String email, String newEmail) {
        for(int i = 0; i < guestsList.size(); i++) {
            if(guestsList.get(i).email.equals(email)) {
                guestsList.get(i).email = newEmail;
                return true;
            }
        }
        for(int i = 0; i < waitList.size(); i++) {
            if(waitList.get(i).email.equals(email)) {
                waitList.get(i).email = newEmail;
                return true;
            }
        }
        return false;
    }
    
    boolean updatePhoneNumberKnowingEmail(String email, String newPhoneNumber) {
        for(int i = 0; i < guestsList.size(); i++) {
            if(guestsList.get(i).email.equals(email)) {
                guestsList.get(i).phoneNumber = newPhoneNumber;
                return true;
            }
        }
        for(int i = 0; i < waitList.size(); i++) {
            if(waitList.get(i).email.equals(email)) {
                waitList.get(i).phoneNumber = newPhoneNumber;
                return true;
            }
        }
        return false;
    }
    
    boolean updateLastNameKnowingPhoneNumber(String phoneNumber, String newLastName) {
        for(int i = 0; i < guestsList.size(); i++) {
            if(guestsList.get(i).phoneNumber.equals(phoneNumber)) {
                guestsList.get(i).lastName = newLastName;
                return true;
            }
        }
        for(int i = 0; i < waitList.size(); i++) {
            if(waitList.get(i).phoneNumber.equals(phoneNumber)) {
                waitList.get(i).lastName = newLastName;
                return true;
            }
        }
        return false;
    }
    
    boolean updateFirstNameKnowingPhoneNumber(String phoneNumber, String newFirstName) {
        for(int i = 0; i < guestsList.size(); i++) {
            if(guestsList.get(i).phoneNumber.equals(phoneNumber)) {
                guestsList.get(i).firstName = newFirstName;
                return true;
            }
        }
        for(int i = 0; i < waitList.size(); i++) {
            if(waitList.get(i).phoneNumber.equals(phoneNumber)) {
                waitList.get(i).firstName = newFirstName;
                return true;
            }
        }
        return false;
    }
    
    boolean updateEmailKnowingPhoneNumber(String phoneNumber, String newEmail) {
        for(int i = 0; i < guestsList.size(); i++) {
            if(guestsList.get(i).phoneNumber.equals(phoneNumber)) {
                guestsList.get(i).email = newEmail;
                return true;
            }
        }
        for(int i = 0; i < waitList.size(); i++) {
            if(waitList.get(i).phoneNumber.equals(phoneNumber)) {
                waitList.get(i).email = newEmail;
                return true;
            }
        }
        return false;
    }
    
    boolean updatePhoneNumberKnowingPhoneNumber(String phoneNumber, String newPhoneNumber) {
        for(int i = 0; i < guestsList.size(); i++) {
            if(guestsList.get(i).phoneNumber.equals(phoneNumber)) {
                guestsList.get(i).phoneNumber = newPhoneNumber;
                return true;
            }
        }
        for(int i = 0; i < waitList.size(); i++) {
            if(waitList.get(i).phoneNumber.equals(phoneNumber)) {
                waitList.get(i).phoneNumber = newPhoneNumber;
                return true;
            }
        }
        return false;
    }
    
    void search(String s) {
        ArrayList<Guest> found = new ArrayList();
        for(int i = 0; i < guestsList.size(); i++) {
            if((guestsList.get(i).lastName.indexOf(s) >= 0) ||
                    (guestsList.get(i).firstName.indexOf(s) >= 0) ||
                    (guestsList.get(i).email.indexOf(s) >= 0) ||
                    (guestsList.get(i).phoneNumber.indexOf(s) >= 0)) {
                found.add(guestsList.get(i));
            }
        }
        
        for(int i = 0; i < waitList.size(); i++) {
            if((waitList.get(i).lastName.indexOf(s) >= 0) ||
                    (waitList.get(i).firstName.indexOf(s) >= 0) ||
                    (waitList.get(i).email.indexOf(s) >= 0) ||
                    (waitList.get(i).phoneNumber.indexOf(s) >= 0)) {
                found.add(waitList.get(i));
            }
        }
        
        if(found.size() == 0) {
            System.out.println("Nu a fost gasita nici o persoana care sa contina subsirul introdus.");
            return;
        }
        
        System.out.println("Persoanele care contin subisrul introdus: ");
        for(int i = 0; i < found.size(); i++) {
            System.out.println("\tNume: " + found.get(i).lastName + " " + found.get(i).firstName + ", Email: " + found.get(i).email + ", Telefon: " + found.get(i).phoneNumber);
        }
    }
}
