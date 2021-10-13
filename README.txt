Signup Management System

RO:

Am creat 3 clase:
- una Main, in care este desfasurata toata logica programului, cu prelucrarile interactiunii cu utilizatorul;
- o clasa Guest, care contine atributele necesare pentru crearea obiectului
- o clasa GuestList cu atributele necesare crearii sistemului de gestiune, imporeuna cu metodele aferente.

Clasa GuestList are urmatoarele functionalitati:
- adaugarea unui guest - in aceasta metoda, verific daca emailul-ul persoane (care ar trebui sa fie unic) se regaseste in vreuna din liste. Daca nu, atunci verific daca mai este loc
in guestList si il adaug, iar daca nu mai este loc, il adaug in waitList.
- metodele check* verifica in functie de argumente daca persoana se regaseste in vreuna dintre liste;
- metodele remove* elimina o persoana din lista in modul urmator: daca persoana este in guestList, atunci adauga adauga prima persoana din waitList in guestList; daca persoana este in waitlist,
o sterge fara sa mai faca alte modificari.
- metoda getGuestList returneaza lista de participanti
- metoda getWaitList returneaza lista de persoana aflate pe lista de asteptare;
- metoda availableTickets intoarce numarul de locuri ramase in lista de participanti;
- metoda guestsNumber intoarce numarul de participanti cu locul confirmat;
- metoda waitListNumber intoarce numarul de persoane din lista de asteptare;
- metoda totalNumber intoarce numarul total de persoane care s-au inscris pe ambele liste;
- metoda showGuestsList afiseaza detalii despre fiecare obiect din lista de participanti;
- metoda showWaitList afiseaza detalii despre fiecare obicet din lista de asteptare;
- metodele de update actualizeaza ce se da in functie de ce se stie, in oricare dintre liste s-ar regasi obiectul;
- metoda search cauta in ambele liste persoanele in ale caror detalii se regaseste sirul cautat si se afiseaza o lista de rezultate;

Clasa Main citeste o comanda de la tastatura si, in functie de aceasta, apeleaza metode pe myList din clasa GuestList. 

EN:

I created 3 classes:
- a Main one, in which all the logic of the program is developed, with the processing of the interaction with the user;
- a Guest class, which contains the attributes needed to create the object
- a GuestList class with the attributes necessary to create the management system, together with the related methods.

The GuestList class has the following functionalities:
- adding a guest - in this method, I check if the person's email (which should be unique) is found in any of the lists. If not, then check if there is still room
in guestList and I add it, and if there is no more space, I add it in waitList.
- check * methods check according to arguments if the person is in any of the lists;
- remove * methods remove a person from the list as follows: if the person is in guestList, then add add the first person from waitList to guestList; if the person is on the waitlist,
delete it without making any other changes.
- the getGuestList method returns the list of participants
- the getWaitList method returns the list of people on the waiting list;
- the availableTickets method returns the number of seats left in the list of participants;
- the guestsNumber method returns the number of participants with the confirmed place;
- the waitListNumber method returns the number of people in the waiting list;
- the totalNumber method returns the total number of people who signed up on both lists;
- the showGuestsList method displays details about each object in the list of participants;
- the showWaitList method displays details about each object in the waiting list;
- the update methods update what is given depending on what is known, in any of the lists the object would be found;
- the search method searches in both lists the persons in whose details the searched string is found and a list of results is displayed;

The Main class reads a command from the keyboard and, depending on this, calls methods on myList from the GuestList class.

