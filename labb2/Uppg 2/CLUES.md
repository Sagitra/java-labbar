# Ledtrådar om du kör fast

## Ledtrådar Uppgift 1

### Ledtrådar 1.a Räkna antal "Nils"

- Vi stavar "Nils" med små bokstäver (gemener), eftersom programmet `parser.TextAnalyzer` omvandlar alla ord till gemener vid inläsning
(med hjälp av `String`-metoden `toLowerCase`).

De två testerna, där ett passerar och det andra fallerar.
  - Hur fungerar jämförelsen `==` för objekt? 
  - Hur skapar Javas kompilator objekt av identiska strängar? 

### Ledtrådar 1.b Räkna flera ord, med flera `TextProcessor`-objekt.

- En konstruktor kallar en annan konstruktor i samma klass såhär:
``` 
this( *some parameters* );

```
- Använd t.ex. klassen `ArrayList` för att lagra dina `TextProcessor`s.

- Första testet i `TextAnalyzerTest` kan se ut såhär med den nya konstruktorn.
```
@Test
    @DisplayName("Can find Nils in nils.txt ")
    void analyzeText() throws FileNotFoundException {
        Scanner scanner = ScannerFactory.scannerForNaturalLanguage("test_data/nils.txt");
        TextProcessor textProcessor = new SingleWordCounter("nils");
        TextAnalyzer analyzer = new TextAnalyzer(new TextProcessor[] {textProcessor});
        assertEquals("nils: 2", analyzer.analyzeText(scanner));
    }
```
- Det finns en fil `nils_norway.txt` i mappen `test_data`.
- Uppgiften blir lättare att lösa om `report()` alltid har en ny rad i slutet.
- Ny rad skrivs `\n`.

### Ledtrådar 1.c Gör en `MultiWordCounter`

Hur konstruktorn på MultiWordCounter kan fungera.
```
String[] landskap = { "blekinge", "bohuslän" /* , ... */ `;
TextProcessor r = new MultiWordCounter(landskap);
```

- Den map som håller ordning på räkningen ska vara av typen `Map<String, Integer>`.
Där ska landskapen användas som nycklar. 
Den är det enda attribut (medlemsvariabel) som klassen behöver. 

- Man kan gå igenom alla nycklar i en `Map` med hjälp av `Map.Entry`.
  Titta gärna i [specifikationen](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Map.Entry.html)

`StringBuilder` är praktiskt om du vill sätta ihop flera strängar.

### Ledtrådar 1.d Räkna alla ord

- Det finns en klass `StopWordParser` som returnerar en array av ord i en fil.
- Orden ska lagras i en Map, på samma sätt som innan, men de läggs till dynamiskt. 
Första gången du hittar ett nytt ord, som inte är ett undantagsord, ska det läggas till i din `Map` med antal 1.
Finns det redan ska du öka antalet med ett.
- Det kan hända att ditt IDE klagar över att du har duplicerad kod. 
Bry dig inte om det innan du är klar med den här uppgiften. 
- Ett `Set` med bara ett ord skapas såhär: `Set.of("norge")`.
En tom mängd `Set.of()`.
- "Early return" är när en metod kollar ett villkor, och sedan returnerar utan att göra resten av metoden.
```
  if(check something){
    return;
  }
  ... rest of method is only run if "check something" is false.
```

### Ledtrådar 1.e SortedGeneralWordCounter — Sortera orden
- Det är bara metoden `report()` som behöver överlagras.
- För att kunna sortera något behövs en lista. Om du inte redan använt `Map.Entry` är det läge nu.
  `Set<Map.Entry<K,V>> entrySet();` Sedan vill du hitta ätt sätt att göra ett set till en lista.
  Det kan vara frestande att göra allt i ett svep, men det är lättare här att först skapa listan och sedan sortera den. 
- Metoden som ska användas är `sort` i [interfacet `List`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/List.html).
  Metoden `sort` har en parameter av typen `Comparator`, vilket är ett funktionellt interface.
  Det innebär att du kan skicka med ett lambdauttryck som argument.
  I lambdauttrycket bestämmer du hur listans element ska jämföras.
- Metoden `sort` ska bara anropas en gång, även när den sorterar i bokstavsordning när något förekommer lika många gånger.
- Metoden `compare` finns på alla objekt. 
- När du ärver ett objekt kan det hända att en del som är satt som `private` behöver ändras till `protected`.

## Ledtrådar Uppgift 2
Den här uppgiften är i princip samma som uppgift 1, men du kan återanvända alla klasser du skapat.
Ditt nya main-program härmar `Holgersson` och du är fri att använda dina nyskapade verktyg lite som du vill.
Vill du ändra i `SortedGeneralWordCounter` är det ok.
Du kan också ärva den igen, eller skriva en ny `TextProcessor`.
Experimentera tills du fått en känsla för orden i kodbasen, eller tröttnat.
Det är också ok att lösa den här uppgiften så fort du kan, 
gå vidare till uppgift tre och sedan komma tillbaka hit om du vill.

## Ledtrådar Uppgift 3
Enklaste sättet att skapa ett enhetstest är från `TextAnalyzer.java`.
Det spelar ingen roll att klassen redan har en testfil.
Innehållet i testerna är misstänkt likt `Holgersson` och `WordsInCode`.
Det är ett tecken på att vi troligtvis saknar ett objekt som kapslar in allt det där.
Du får skapa ett sådant om du vill, men du kan också kopiera och ändra.
Se till att du ändrar överallt som krävs dock.

Det är inte så viktigt vad din assert testar här, räcker med att den visar att koden gjort det du tror.
`assertFalse(analyzer.analyzeText(scanner).isEmpty());` fungerar t ex. 