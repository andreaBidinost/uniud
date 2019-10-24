# Laboratorio di Giovedì 24 Ottobre 2019
## Obiettivi: miglioramento codice Operatore Telefonico, errors, checked/unckecked exceptions

### 0. Contenuto della cartella
- **src**: sorgenti caricati prima dell'esercitazione
- **src_after**: sorgenti modificati al termine dell'esercitazione
- **Effective Java - Exceptions**: contenuto del libro interessante per l'esercitazione

### 1. package errors
Contiene un'implementazione corretta della [funzione di Ackermann](https://it.wikipedia.org/wiki/Funzione_di_Ackermann) (ricorsiva, cresce molto rapidamente) come esempio di codice che può generare un **Errore** (con m=5, n=5).

### 2. package exceptions.unchecked
- **DontDoThis**: utilizzo inappropriato di un'Eccezione
- **UncheckedExamples.java**: esempi di metodi che lanciano Eccezioni di tipo Unchecked (esplicitati nelle clausole throws)

### 3. package exceptions.trycatchfinally
FileLineTransposer è una classe il cui metodo * *transposeFirstLine* * copia la prima riga di fileName2 in fileName1. 
Le classi BufferedWriter e BufferedReader permettono la lettura e la scrittura nei file. 
L'apertura dei file e le operazioni su di essi possono dar luogo a eccezioni di tipo * *IOException* *.
Poiché ogni risorsa aperta deve venire chiusa, è necessario accertarsi che il metodo * *close* * venga invocato sempre: sia al termine  corretto delle operazioni, sia se qualcosa va storto.
Il blocco **finally** esegue le istruzioni al suo interno sia al termine del blocco try, sia dopo aver intercettato un'eccezione.
Per questo nel **finally** viene scritto il codice per chiudere le risorse potenzialmente aperte.
La classe FileCloser mette a disposizione il metodo statico * *close* * che si occupa della chiusura di un oggetto * *Closeable* * (come i BufferedReader ed i BufferedWriter).

### 4. package exeptions.phoneAdmin
Contiene l'aggiornamento delle classi del progetto Operatore Telefonico.
- sono state introdotte due eccezioni: InvalidCallDataParameter (Unckecked) e NotEnoughCreditException(checked).
- è stato migliorato il tipo enumerativo * *Promotions* * aggiungendo dei valori allegati agli elementi dell'insieme
- sono stati aggiunti i metodi CallData.isValidPhoneNumber, Sim.toString, Sim.getNumberOfCalls, Sim.activatePromo, PhoneAdministration.saveSimDataToFile, PhoneAdministration.call


