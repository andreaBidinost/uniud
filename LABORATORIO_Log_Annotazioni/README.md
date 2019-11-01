# Esercitazione di Giovedì 31 Ottobre 2019
## Obiettivi: Annotations, logging, lombok, risoluzione tema d'esame

### 1. package uniud.annotations
Contiene la classe RankedPost con esempi di utilizzo delle annotazioni.

### 2. uniud.javalog
Contiene la classe LogInitializer che imposta il logger del progetto per poter scrivere sul file "tryLog.log" (invece che sulla console).
Il Formatter serve per impostare il tipo di scrittura (xml o semplice): provare a rimuoverlo per notare la differenza.
La classe Post utilizza scrive un messaggio nel log (e quindi nel file): per fare questo prima di tutto deve essere invocato LogInitializer.setup().

### 3. uniud.lombok
Esempi di utilizzo del framework lombok (il file jar, da includere tra i jar utilizzati dal progetto, è presente nella cartella lib).
per ulteriori informazioni [lombok in Eclipse](https://howtodoinjava.com/automation/lombok-eclipse-installation-examples) o simili.

### 4. uniud.esame.trasporti
Contiene una possibile risoluzione del tema d'esame (con le competenze discusse fino a questo momento).


```
Provare a completare la prova d'esame aggiungendo eccezioni, asserzioni e log di situazioni rilevanti, stilando il contratto di ogni metodo.
```
