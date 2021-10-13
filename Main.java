package signupmanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GuestsList myList;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Bun venit! Introduceti numarul de locuri disponibile:");
        int n = sc.nextInt();
        
        myList = new GuestsList(n);
        
        boolean isQuit = false;
        
        while(isQuit == false) {
            System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
            
            String command = sc.next();
            
            if(command.equals("help")) {
                System.out.println( "help         - Afiseaza aceasta lista de comenzi\n" +
                                    "add          - Adauga o noua persoana (inscriere)\n" +
                                    "check        - Verifica daca o persoana este inscrisa la eveniment\n" +
                                    "remove       - Sterge o persoana existenta din lista\n" +
                                    "update       - Actualizeaza detaliile unei persoane\n" +
                                    "guests       - Lista de persoane care participa la eveniment\n" +
                                    "waitlist     - Persoanele din lista de asteptare\n" +
                                    "available    - Numarul de locuri libere\n" +
                                    "guests_no    - Numarul de persoane care participa la eveniment\n" +
                                    "waitlist_no  - Numarul de persoane din lista de asteptare\n" +
                                    "subscribe_no - Numarul total de persoane inscrise\n" +
                                    "search       - Cauta toti invitatii conform sirului de caractere introdus\n" +
                                    "quit         - Inchide aplicatia");
            } else if(command.equals("quit")) {
                isQuit = true;
                break;
            } else if(command.equals("add")) {
                System.out.println("Se adauga o noua persoana...");
                System.out.println("Introduceti numele de familie:");
                String lastName = sc.next();
                System.out.println("Introduceti prenumele:");
                String firstName = sc.next();
                System.out.println("Introduceti email:");
                String email = sc.next();
                System.out.println("Introduceti numar de telefon (format „+40733386463“):");
                String phoneNumber = sc.next();
                Guest toBeAdded = new Guest(lastName, firstName, email, phoneNumber);
                int ret = myList.addGuest(toBeAdded);
                if(ret == -2) {
                    System.out.println("[" + lastName + " " + firstName +
                                "] Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
                } else if(ret >= 0) {
                    System.out.println("[" + lastName + " " + firstName +
                                "] Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine " +
                                (ret + 1) + ". Te vom notifica daca un loc devine disponibil.");
                } else {
                    System.out.println("[" + lastName + " " + firstName +
                                "] Esti deja inscris la eveniment.");
                }
            } else if(command.equals("available")) {
                System.out.println("Numarul de locuri ramase: " + myList.availableTickets());
            } else if(command.equals("guests_no")) {
                System.out.println("Numarul de participanti: " + myList.guestsNumber());
            } else if(command.equals("waitlist_no")) {
                System.out.println("Dimensiunea listei de asteptare: " + myList.waitListNumber());
            } else if(command.equals("subscribe_no")) {
                System.out.println("Numarul total de persoane: " + myList.totalNumber());
            } else if(command.equals("check")) {
                System.out.println("Alege modul de autentificare, tastand:\n" +
                                    "\"1\" - Nume si prenume\n" +
                                    "\"2\" - Email\n" +
                                    "\"3\" - Numar de telefon (format \"+40733386463\")");
                int input = sc.nextInt();
                if(input == 1) { // cautarea se face dupa nume si prenume
                    System.out.println("Introduceti numele de familie: ");
                    String lastName = sc.next();
                    System.out.println("Introduceti prenumele: ");
                    String firstName = sc.next();
                    if(myList.checkName(lastName, firstName) != 0) {
                        System.out.println(lastName + " " + firstName + " este inscris(a) la eveniment.");
                    } else {
                        System.out.println(lastName + " " + firstName + " nu este inscris(a) la eveniment");
                    }
                } else if(input == 2) { // cautarea se face dupa adresa de email
                    System.out.println("Introduceti email: ");
                    String email = sc.next();
                    if(myList.checkEmail(email) != 0) {
                        System.out.println("Persoana cu adresa de email " + email + " este inscris(a) la eveniment.");
                    } else {
                        System.out.println("Persoana cu adresa de email " + email + " nu este inscris(a) la eveniment.");
                    }
                } else if(input == 3) { // cautarea se face dupa numarul de telefon
                    System.out.println("Introduceti numarul de telefon: ");
                    String phoneNumber = sc.next();
                    if(myList.checkPhoneNumber(phoneNumber) != 0) {
                        System.out.println("Persoana cu numarul de telefon " + phoneNumber + " este inscris(a) la eveniment.");
                    } else {
                        System.out.println("Persoana cu numarul de telefon " + phoneNumber + " nu este inscris(a) la eveniment.");
                    }
                }
            } else if(command.equals("remove")) {
                System.out.println("Alege modul de autentificare, tastand:\n" +
                                    "\"1\" - Nume si prenume\n" +
                                    "\"2\" - Email\n" +
                                    "\"3\" - Numar de telefon (format \"+40733386463\")");
                int input = sc.nextInt();
                if(input == 1) { // stegerea se face dupa nume si prenume
                    System.out.println("Introduceti numele de familie: ");
                    String lastName = sc.next();
                    System.out.println("Introduceti prenumele: ");
                    String firstName = sc.next();
                    boolean ret = myList.removeName(lastName, firstName);
                    if(ret == true) {
                        System.out.println("Stergerea persoanei s-a realizat cu succes.");
                    } else {
                        System.out.println("Eroare: Persoana nu este inscrisa la eveniment.");
                    }
                } else if(input == 2) { // stergerea se face dupa adresa de email
                    System.out.println("Introduceti email: ");
                    String email = sc.next();
                    boolean ret = myList.removeEmail(email);
                    if(ret == true) {
                        System.out.println("Stergerea persoanei s-a realizat cu succes.");
                    } else {
                        System.out.println("Eroare: Persoana nu este inscrisa la eveniment.");
                    }
                } else if(input == 3) { // stergerea se face dupa numarul de telefon
                    System.out.println("Introduceti numarul de telefon: ");
                    String phoneNumber = sc.next();
                    boolean ret = myList.removePhoneNumber(phoneNumber);
                    if(ret == true) {
                        System.out.println("Stergerea persoanei s-a realizat cu succes.");
                    } else {
                        System.out.println("Eroare: Persoana nu este inscrisa la eveniment.");
                    }
                }
            } else if(command.equals("guests")) {
                myList.showGuestsList();
            } else if(command.equals("waitlist")) {
                myList.showWaitList();
            } else if(command.equals("update")) {
                System.out.println("Alege modul de autentificare, tastand:\n" +
                                    "\"1\" - Nume si prenume\n" +
                                    "\"2\" - Email\n" +
                                    "\"3\" - Numar de telefon (format \"+40733386463\")");
                int input = sc.nextInt();
                if(input == 1) {
                    System.out.println("Introduceti numele de familie: ");
                    String lastName = sc.next();
                    System.out.println("Introduceti prenumele: ");
                    String firstName = sc.next();
                    if(myList.checkName(lastName, firstName) == 0) {
                        System.out.println("Eroare - Persoana nu a fost gasita");
                    } else {
                        System.out.println("Alege campul de actualizat, tastand:\n" +
                                            "\"1\" - Nume\n" +
                                            "\"2\" - Prenume\n" +
                                            "\"3\" - Email\n" +
                                            "\"4\" - Numar de telefon (format \"+40733386463\")");
                        int input2 = sc.nextInt();
                        if(input2 == 1) {
                            System.out.println("Introduceti noul numele de familie: ");
                            String newLastName = sc.next();
                            boolean ret = myList.updateLastNameKnowingName(lastName, firstName, newLastName);
                            if(ret == true) {
                                System.out.println("Numele a fost schimbat cu succes");
                            } else {
                                System.out.println("A aparut o eroare, incercati din nou mai tarziu."); // teoretic aici nu ar trebui sa se ajunga niciodata, e doar ca sa fim siguri
                            }
                        } else if(input2 == 2) {
                            System.out.println("Introduceti noul prenumele: ");
                            String newFirstName = sc.next();
                            boolean ret = myList.updateFirstNameKnowingName(lastName, firstName, newFirstName);
                            if(ret == true) {
                                System.out.println("Numele a fost schimbat cu succes");
                            } else {
                                System.out.println("A aparut o eroare, incercati din nou mai tarziu."); // teoretic aici nu ar trebui sa se ajunga niciodata, e doar ca sa fim siguri
                            }
                        } else if(input2 == 3) {
                            System.out.println("Introduceti noul email: ");
                            String newEmail = sc.next();
                            boolean ret = myList.updateEmailKnowingName(lastName, firstName, newEmail);
                            if(ret == true) {
                                System.out.println("Email-ul a fost schimbat cu succes");
                            } else {
                                System.out.println("A aparut o eroare, incercati din nou mai tarziu."); // teoretic aici nu ar trebui sa se ajunga niciodata, e doar ca sa fim siguri
                            }
                        } else if(input2 == 4) {
                            System.out.println("Introduceti noul numar de telefon: ");
                            String newPhoneNumber = sc.next();
                            boolean ret = myList.updatePhoneNumberKnowingName(lastName, firstName, newPhoneNumber);
                            if(ret == true) {
                                System.out.println("Numarul de telefon a fost schimbat cu succes");
                            } else {
                                System.out.println("A aparut o eroare, incercati din nou mai tarziu."); // teoretic aici nu ar trebui sa se ajunga niciodata, e doar ca sa fim siguri
                            }
                        }
                    }
                } else if(input == 2) {
                    System.out.println("Introduceti email: ");
                    String email = sc.next();
                    if(myList.checkEmail(email) == 0) {
                        System.out.println("Eroare - Persoana nu a fost gasita");
                    } else {
                        System.out.println("Alege campul de actualizat, tastand:\n" +
                                        "\"1\" - Nume\n" +
                                        "\"2\" - Prenume\n" +
                                        "\"3\" - Email\n" +
                                        "\"4\" - Numar de telefon (format \"+40733386463\")");
                        
                        int input2 = sc.nextInt();
                        if(input2 == 1) {
                            System.out.println("Introduceti noul numele de familie: ");
                            String newLastName = sc.next();
                            boolean ret = myList.updateLastNameKnowingEmail(email, newLastName);
                            if(ret == true) {
                                System.out.println("Numele a fost schimbat cu succes");
                            } else {
                                System.out.println("A aparut o eroare, incercati din nou mai tarziu."); // teoretic aici nu ar trebui sa se ajunga niciodata, e doar ca sa fim siguri
                            }
                        } else if(input2 == 2) {
                            System.out.println("Introduceti noul prenumele: ");
                            String newFirstName = sc.next();
                            boolean ret = myList.updateFirstNameKnowingEmail(email, newFirstName);
                            if(ret == true) {
                                System.out.println("Numele a fost schimbat cu succes");
                            } else {
                                System.out.println("A aparut o eroare, incercati din nou mai tarziu."); // teoretic aici nu ar trebui sa se ajunga niciodata, e doar ca sa fim siguri
                            }
                        } else if(input2 == 3) {
                            System.out.println("Introduceti noul email: ");
                            String newEmail = sc.next();
                            boolean ret = myList.updateEmailKnowingEmail(email, newEmail);
                            if(ret == true) {
                                System.out.println("Email-ul a fost schimbat cu succes");
                            } else {
                                System.out.println("A aparut o eroare, incercati din nou mai tarziu."); // teoretic aici nu ar trebui sa se ajunga niciodata, e doar ca sa fim siguri
                            }
                        } else if(input2 == 4) {
                            System.out.println("Introduceti noul numar de telefon: ");
                            String newPhoneNumber = sc.next();
                            boolean ret = myList.updatePhoneNumberKnowingEmail(email, newPhoneNumber);
                            if(ret == true) {
                                System.out.println("Numarul de telefon a fost schimbat cu succes");
                            } else {
                                System.out.println("A aparut o eroare, incercati din nou mai tarziu."); // teoretic aici nu ar trebui sa se ajunga niciodata, e doar ca sa fim siguri
                            }
                        }
                    }
                } else if(input == 3) {
                    System.out.println("Introduceti numarul de telefon: ");
                    String phoneNumber = sc.next(); 
                    if(myList.checkPhoneNumber(phoneNumber) == 0) {
                        System.out.println("Eroare - Persoana nu a fost gasita");
                    } else {
                        System.out.println("Alege campul de actualizat, tastand:\n" +
                                        "\"1\" - Nume\n" +
                                        "\"2\" - Prenume\n" +
                                        "\"3\" - Email\n" +
                                        "\"4\" - Numar de telefon (format \"+40733386463\")");
                        
                        int input2 = sc.nextInt();
                        if(input2 == 1) {
                            System.out.println("Introduceti noul numele de familie: ");
                            String newLastName = sc.next();
                            boolean ret = myList.updateLastNameKnowingPhoneNumber(phoneNumber, newLastName);
                            if(ret == true) {
                                System.out.println("Numele a fost schimbat cu succes");
                            } else {
                                System.out.println("A aparut o eroare, incercati din nou mai tarziu."); // teoretic aici nu ar trebui sa se ajunga niciodata, e doar ca sa fim siguri
                            }
                        } else if(input2 == 2) {
                            System.out.println("Introduceti noul prenumele: ");
                            String newFirstName = sc.next();
                            boolean ret = myList.updateFirstNameKnowingPhoneNumber(phoneNumber, newFirstName);
                            if(ret == true) {
                                System.out.println("Numele a fost schimbat cu succes");
                            } else {
                                System.out.println("A aparut o eroare, incercati din nou mai tarziu."); // teoretic aici nu ar trebui sa se ajunga niciodata, e doar ca sa fim siguri
                            }
                        } else if(input2 == 3) {
                            System.out.println("Introduceti noul email: ");
                            String newEmail = sc.next();
                            boolean ret = myList.updateEmailKnowingPhoneNumber(phoneNumber, newEmail);
                            if(ret == true) {
                                System.out.println("Email-ul a fost schimbat cu succes");
                            } else {
                                System.out.println("A aparut o eroare, incercati din nou mai tarziu."); // teoretic aici nu ar trebui sa se ajunga niciodata, e doar ca sa fim siguri
                            }
                        } else if(input2 == 4) {
                            System.out.println("Introduceti noul numar de telefon: ");
                            String newPhoneNumber = sc.next();
                            boolean ret = myList.updatePhoneNumberKnowingPhoneNumber(phoneNumber, newPhoneNumber);
                            if(ret == true) {
                                System.out.println("Numarul de telefon a fost schimbat cu succes");
                            } else {
                                System.out.println("A aparut o eroare, incercati din nou mai tarziu."); // teoretic aici nu ar trebui sa se ajunga niciodata, e doar ca sa fim siguri
                            }
                        }
                    }
                }
            } else if(command.equals("search")) {
                System.out.println("Introduceti subsirul cautat: ");
                String s = sc.next();
                myList.search(s);
            }
        }
    }
    
}
