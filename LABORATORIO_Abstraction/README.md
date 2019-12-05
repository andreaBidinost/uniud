# Esercitazione di Giovedì 5 Dicembre 2019

## Obiettivi: Interfaces, abstract classes, dipendency inversion

### 1. package abstraction.liskov
Contiene un'esempio pratico di applicazione del principio di Liskov, ovvero una sotto-classe (**MessageWithImage**) ereditata ed utilizzata al posto della super-classe (**PhoneMessage**) senza cambiamenti nel codice (**Storage**) che la utilizza.

### 2. package abstraction.liskov.violation
Contiene un esempio di violazione del principio di Liskov: **SMS** non eredita logicamente da **Document**.
La soluzione è utilizzare una classe astratta (**Writing**) che sia padre di entrambe.

### 3. abstraction.pdf
Nella prima pagina contiene un confronto tra le interfacce e le classi astratte.
Nella seconda parte contiene un esercizio non affrontato a lezione, utile da svolgere personalmente.

### 4. package abstraction.rectsquare
Contiene la risoluzione dell'esercizio **rect-e-square.pdf**

### 5. package abstraction.dependencyinversion.exercise
Contiene le classi descritte nell'esercizio **dependency-inversion.pdf** su cui sono state fatte alcune considerazioni.

### 6. package abstraction.warehouse
Contiene una classe che simula una richiesta POST ad un server web, utile per risolvere l'esercizio in **abstraction.pdf**.

### 7. cartella lib
Contiene le librerie **gson, lombok, apache** utilizzate nei vari esercizi.

```
Provare a completare l'esercizio **abstraction.pdf** con attenzione ad un corretto utilizzo di interfacce, classi astratte e dependency inversion.
```
