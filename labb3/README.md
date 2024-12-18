# Laboration 3 Grafiska gränssnitt och mer lambda
Version 0.3

## Frågor att tänka på
- Vad har du lärt dig på att göra laborationen?
- Var det något speciellt som var svårt?
- Är det någon del av koden du är extra nöjd med?
- Finns det något du önskar du kunde lösa snyggare?

## Förkunskaper
- Ha löst laboration 2
- Läs på om grafiska gränssnitt i Moodle
- [Swings arkitektur](https://www.oracle.com/java/technologies/a-swing-architecture.html)


## Syfte
Skapa ett grafiskt gränssnitt till programmen i laboration 2. 

## Redovisning
Du behöver bara redovisa slutresultatet av laborationen, 
inte något av mellanstegen.
De är till för att det ska bli lättare för dig.

Eftersom vi nu börjar göra lite större program är det dags 
att tänka på strukturen. 
Vår domänmodell ligger kvar i `parser`-paketet, 
men vårt UI ska ligga i `view` och vy-modeller i paketet `view.model`.

## Uppgift 1 Förberedelser

### Syfte
Göra våra GeneralWordCounter objekt lämpliga att använda med ett grafiskt gränssnitt.

### Filer att ändra i 
- `parser/GeneralWordCounter.java`
- `parser/SortedGeneralWordCounter.java`

### Teknik
Extrahera logiken från `report()` som genererar resultatlistan.
Lägg den i en ny metod, som anropas av `report()`.

### Instruktioner
Alla tester ska vara gröna efter varje steg!

- Skapa en metod `getWordList()`i `GeneralWordCounter` som returnerar en lista över `Entry`-objekten. 
- Använd `getWordList()` i `report()` metoden.
- Överlagra `getWordList()` i `SortedGeneralWordCounter`. Flytta all specifik logik från `report()` till `getWordList()`.
- Ta bort överlagringen av `report()` i `SortedGeneralWordCounter`. 

## Uppgift 2 En vy-modell för listan
### Syfte
Skapa en klass som kapslar in en lista för att användas i en Listvy.
Den ska också kunna sortera den med olika sorters jämförelser.

### Filer att ändra i
- `view/model/SortedListModel.java` (Skapas)
- `test/view/model/SortedListModelTest.java` (Skapas)

### Teknik
Skriv en klass `SortedListModel` som ärver `AbstractListModel`.
Den ska ha en metod med signaturen `public void sort(Comparator<E> comp)`.
`SortedListModel.java` ska ligga i paketet `view.model` för att visa att det är modell som hör till vyn,
och inte till domänen.
Det signalerar också att vyn beror på modellen,
istället för tvärtom. 
(Modellen behöver inte veta något om hur vyn fungerar.)

### Instruktioner
- Skapa klassen `SortedListModel` i paketet `view.model` och implementera metoderna som krävs.
- Implementera metoden `public void sort(Comparator<E> comp)`.

## Uppgift 3 Design av GUI
### Syfte
Tänka kring layout av programmet.
Vyn ska innehålla:
 - En lista av ord, med förekomst, som en rullningslista.
 - En knapp för att sortera alfabetiskt.
 - En knapp för att sortera efter förekomst.
 - Ett sökfält med en sökknapp.

### Filer att ändra i
Inga, men du behöver penna och papper.
(Det behöver inte vara något speciellt papper,
till och med baksidan av ett gammalt kuvert fungerar bra).

### Teknik
Rita en skiss över hur gränssnittet kan se ut med penna och papper.
Skissen ska kunna användas med Swings `BorderLayout`.

### Instruktioner
- Läs på om hur `BorderLayout` fungerar.
- Rita ut de olika komponenterna. Gruppera dem i olika `JPanel`-sektioner.
- Skriv ut i skissen vilken "layout constraint" som varje del ska ha.


## Uppgift 4 Skapa något som går att köra
### Syfte
Ha ett program som går att starta.

### Filer att ändra i
- `BookReaderApplication.java` (Skapas)

### Teknik
`BookReaderApplication` ska ha en `main`-metod som kallar 
`SwingUtilities.invokeLater` med ett lambda.
Låt det lambdat skapa ett fönster med namnet "BookReader" och storleken 100 gånger 500, samt visa det.
Fönstret ska avsluta programmet när det stängs.

### Instruktioner
- Skapa klassen `BookReaderApplication` med en `main`-metod i projektets rot, alltså direkt i `src`-mappen.
- `SwingUtilities.invokeLater` kommer köra fönstret på en separat tråd.
- Fönstret ska vara ett `JFrame`-objekt. Läs på om hur det fungerar.
- Sätt titel och storlek på fönstret innan du säger åt det att visa sig.
- Kolla i `CLUES.md`om det är svårt att få fönstret att synas.

## Uppgift 5 Layout
### Syfte
Skapa layouten från ritningen, men med komponenter.
### Filer att ändra i
- `BookReaderApplication.java` (Ändras)

### Teknik
Använd BorderLayout, JButton, JTextField, JPanel, ScrollPane och JList.
De läggs i en `contentPane` som kommer från `frame.getContentPane();`
JList ska använda en SortedListModel, men på en lista av "one", "two", "three".

### Instruktioner
- Börja med att plocka ut din `contentPane`.
- Bygg sedan upp ditt gränssnitt från skissen, en JPanel i taget.
- Gränssnittet behöver inte göra något, det ska bara gå att se.
- Kör programmet med jämna mellanrum för att se hur det ser ut.

## Uppgift 6 Läs in rätt modell
### Syfte
Visa de riktiga orden 

### Filer att ändra i
- `BookReaderApplication.java` (ändras)

### Teknik
Skapa en GeneralWordCounter på samma sätt som i förra laborationen.
Ta ut listan genom getWordList och lägg in den i sortedListModel istället för en lista med ord.

### Instruktioner
- Kopiera relevant kod från `parser/Holgersson.java`
- Ändra den generiska typen på din `SortedListModel` och `JList` från `<String>` till `<Map.Entry<String, Integer>>`. 
- Skapa den med listan från `getWordList()`.
- Kör programmet och kolla att det funkar.

## Uppgift 7 Sortera listan
### Syfte
Koppla ihop knapparna för sortering med SortedListModels metod för sortering.

### Filer att ändra i
- `BookReaderApplication.java` (Ändras)

### Teknik
Använd lambdafunktioner kopplade till sorterings-knapparna för att kalla sortering av modellen.

### Instruktioner
- Skriv ett lambda direkt i `addActionListener` med koden du vill ska köras när någon trycker på knappen.
- Oroa dig inte för att koden kanske blir lite ful, det löser vi sen.
- Kolla att listan sorteras rätt, beroende på vilken knapp du trycker på. 

## Uppgift 8 Sök i listan
### Syfte
Textfältet ska kunna användas för att söka i listan.
Om ett ord skrivs in exakt som det finns i listan ska det markeras, 
och listan ska rulla så att det markerade ordet syns i vyn.

### Filer att ändra i
- `BookReaderApplication.java` (Ändras)
- `view/model/SortedListModel.java`
- `test/view/model/SortedListModelTest.java`

### Teknik
Skapa en ny metod i `SortedListModel` som kan ge oss första indexet för objektet som uppfyller ett inskickat predikat.
Använd den metoden för att få sökfunktionen att fungera med sök-knappen på samma sätt som sorteringsknapparna.


### Instruktioner
- Läs på om hur `Predicate<E>` fungerar.
- Skriv ett test i `SortedListModelTest` där du får `-1` som svar när `public int indexFor(Predicate<E> predicate)` kallas och listan är tom.
- Skriv kod nog för att få testet att passera. (Tänk på att du kan skapa en `SortedListModel` med vilken generisk typ du vill)
- Skriv ett test där du får `0` som svar från `indexFor` om predikatet letar efter det som ligger först i listan. 
- Skriv kod så att testet blir grönt.
- Skriv ett test där du får `1` som svar från `indexFor` om predikatet letar efter det som ligger näst först i listan.
- Skriv kod så att testet blir grönt.
- Använd `indexFor` i sök-knappens lambda, för att hitta om ordet finns eller inte.
- Använd metoder på `JList` (i knappens lambda) för att välja ett element i listan och se till att det syns i fönstret.

## Uppgift 9 Strukturera upp koden
### Syfte
Dela upp koden som ligger i BookReaderApplication efter ansvar, 
så att koden blir lättare att bygga på.
Få en känsla av varför kod i användargränssnitt delas upp.

### Filer att ändra i
- `BookReaderApplication.java` (Ändras)
- `parser/TextAnalyzer.java` (Ändras)
- `view/SortButton.java`(Skapas)
- `view/SearchPanel.java`(Skapas)
- `view/BookReader.java`(Skapas)


### Teknik
En tumregel är att ingen metod ska vara längre än 20 rader. 
Alla klasser som representerar en vy ska ha metoden 
`public JComponent getMainComponent()`
som returnerar en JComponent med alla nästlade vyer på plats.
Inga klasser ska ärva någon annan klass, de är en "has one"-vy-klass istället för "is one"-vy.

### Instruktioner
- Skapa en metod i `parser/TextAnalyzer.java` med signaturen `public static List<Map.Entry<String, Integer>> getWordList(String pathname, String stopWordPath)` och lägg koden för att generera listan där. 
- Lyft ut en del av gränssnittet i taget och skapa de nya klasserna.
- Låt `BookReaderApplication` skapa en `BookReader`, men låt `BookReader` ansvara för de andra vyerna.
- Kör applikationen regelbundet för att kolla att inget gått sönder.
- Du är färdig när koden är uppdelad på de olika klasserna på ett sätt som du är nöjd med.

## Uppgift 10 Jobba vidare med programmet.
### Syfte
Utforska mer på egen hand.
### Filer att ändra i
Det beror på. :-)
Men de ska ligga i rätt paket efter vilken typ av klass du skapar.
Gör du vyer ska de ligga i `view` är det vy-modeller ska de ligga i `view/model`.
### Teknik
Lös (minst) tre av uppgifterna nedan. 
Välj själv tre (eller fler) uppgifter som du tycker verkar intressanta. 
Uppgifterna är oberoende och kan göras i valfri ordning. 
Uppgifterna bygger (liksom tidigare deluppgifter) på att du själv söker i dokumentationen på nätet.

1. I ditt användargränssnitt kan man skriva in ett ord att söka efter. Om användaren råkar inleda eller avsluta ordet med ett eller fler mellanslag fungerar inte sökningen. Om användaren på samma sätt råkar skriva in versaler fungerar inte heller sökningen. 
Ändra programmet så att sökningen fungerar, även om det inmatade ordet börjar/ slutar på mellanslag eller innehåller versaler. Du har nytta av ett par lämpliga metoder i klassen `String`.

//löst
2. När man söker efter ett ord som inte finns i boken vore det bra med en ruta som meddelar användaren detta. Använd klassen `JOptionPane` för att visa en sådan ruta.


3. Gör så att knappen "Find" aktiveras (trycks) automatiskt när man trycker Return.

LÖST!!
4. För de två sorteringsknapparna passar det bra att använda s.k. radioknappar. En sådan markeras när den är intryckt, och bara en knapp i samma grupp kan vara intryckt i taget.
Läs om klassen `JRadioButton` och använd den för sorteringsknapparna.

5. Programmet vore mer användbart om man kunde välja vilken textfil som ska analyseras. Låt användaren välja en fil att analysera.
Använd klassen `JFileChooser`.

6. Lägg till en ny vy, som visar orden från mindustry, sida vid sida av nils holgersson.

7. Skapa en `public class WordListCellRenderer extends JLabel implements ListCellRenderer` klass för att ändra hur cellerna i listan ser ut.
8. Lek med färger, fonter, effekter och annat för att bygga ett roligare gränssnitt. 

### Instruktioner
- Läs dokumentationen.
- Ha kul.
- Notera vilka filer du ändrar i för att lösa de olika uppgifterna. 
Optimalt är om du aldrig behöver ändra i mer än en eller två. 
