# Labb 2

## Mål
 Du ska träna på att implementera algoritmer med hjälp av de abstrakta datatyperna lista, mängd och map.
Du ska också träna på att använda interface och klasser från Java Collection Framework,
 som beskriver, respektive implementerar dessa abstrakta datatyper.
I samband med detta kommer du också att få träna på att skriva lambdauttryck.

## Frågor att fundera på

- Är det något speciellt i din kod du vill ha feedback på?
- Vad är det för skillnad på `Map` och `HashMap`?
- Vad är det för skillnad på `HashMap` och `TreeMap`? Vad beror skillnaderna på?
- På laborationen har du bl.a. använt de abstrakta datatyperna mängd och map.
    Vad har de för speciella egenskaper som gör dem lämpliga att använda på det sätts som har gjorts?
- Du har även använt Javas inbyggda sortering med hjälp av en sorteringsordning du själv angivit.
    Hur fungerar det? Och vilken funktion har interfacet `Comparator` i detta?
- Kunde du se domänen i koden i del 2?
  
## Uppgift 1
### Bakgrund
Historiker och litteraturvetare använder ibland datorbaserade metoder för att få översiktlig information om stora textmassor.
Genom att exempelvis räkna förekomster av ortnamn (och liknande) kan man skapa sig en uppfattning om den geografi som beskrivs i texten.
Denna typ av analysmetoder kallas ibland för "distant reading".
Med en sådan metod kan vi undersöka Selma Lagerlöfs bok *Nils Holgerssons underbara resa genom Sverige* och räkna förekomster av landskapens namn.
På så sätt kan vi förstå något om den bild av Sverige som tecknas i boken.
Lagerlöfs bok gavs ut 1906 — 1907, under den nationalromantiska perioden,
då många av 1900-talets föreställningar om den svenska nationen tog form.

När vi undersöker en text, som Lagerlöfs bok, räknar vi alltså förekomster av vissa ord,
som exempelvis platser.
I den här uppgiften kommer du att konstruera klasser för att räkna ord på olika sätt. 
Vi kommer särskilt att fokusera på vilka abstrakta datatyper man kan använda.


### 1.a Räkna antal "Nils"

#### Mål
Hitta felet i SingleWordCounter, så att vi kan räkna antalet Nils.
Förstå varför det inte fungerar nu.
#### Teknik
Använda testerna.
#### Filer som ska ändras
- SingleWordCounter.java

#### Instruktioner
Börja med att bekanta dig med interfacet `TextProcessor` i paketet `textproc`.
Det innehåller metoder för att behandla inläst text, ett ord i taget, samt presentera ett resultat.
Vi kommer att använda detta interface för att hantera olika slags textanalyser på ett enhetligt sätt.

```
public interface TextProcessor {
	/**
	 * Anropas när ett ord lästs in.
	 * Metoden ska uppdatera statistiken därefter.
	 */
	void process(String w);

	/**
	 * Anropas när samtliga ord i sekvensen lästs in.
	 * Metoden returnerar en sammanställning av statistiken.
	 */
	String report();
}
```

Vi använder ett interface istället för en abstrakt klass, eftersom det inte finns någon gemensam kod.

I projektet finns också en klass `SingleWordCounter`, som implementerar interfacet ovan.
Denna klass är till för att räkna hur många gånger ett givet ord förekommer.

Klassen har ett test som fallerar och ett som passerar, fast de ser ut att göra samma sak.

> Laga koden så att båda testen passerar (utan att ändra i testen) och förklara sedan varför de gav olika resultat.

Projektet innehåller därtill ett program `parser.Holgersson.java`. 
Programmet gör följande:
- Skapar ett `SingleWordCounter`-objekt, som ska räkna antalet förekomster av ordet "nils".

- Läser in boken, med hjälp av en Scanner. Bokens text finns i textfilen `input/nilsholg.txt`, och inleds med ett par dikter innan kapitel 1.
Öppna gärna filen och se hur den ser ut.
- `TextAnalyzer` går igenom texten och vårt `SingleWordCounter`-objekt uppdateras.
- Skriver ut resultatet.

Kör main-metoden och se vad som händer.
Namnet "Nils" förekommer 75 gånger i Lagerlöfs roman.
Om båda testen i `SingleWordCounterTest` passerar borde även utskriften från main bli rätt.


### 1.b Räkna flera ord, med flera `TextProcessor`-objekt.

#### Mål
Kunna räkna mer än ett ord i taget.

#### Teknik
Applicera flera TextProcessor objekt på en text.

#### Filer att ändra i
- TextAnalyzerTest.java
- TextAnalyzer.java
- Holgersson.java

#### Instruktioner
Inför fortsättningen vill vi kunna räkna flera olika ord på en gång.
Vi gör det genom att ändra i klassen `TextAnalyzer`.
 - Börja med att ändra i det befintliga testet i `TextAnalyzerTest` så att det tar en lista med ett `TextProcessor`-objekt.
  Låt den nya konstruktorn kallas av den gamla konstruktorn.
- Implementera nästa test som finns listat i testklassen.

Varje gång ett ord lästs in ska alla `TextProcessor`-objekt i listan få sin `process`-metod anropad.
När all text har lästs in ska alla `TextProcessor`-objekt returnera sina respektive resultat.

- Skapa ett nytt `TextProcessor`-objekt i `parser.Holgersson`-programmet som räknar antalet "Norge".
- Lägg in det i listan som `TextAnalyzer` tar som argument till sin konstruktor.

Din lista ska alltså innehålla två `TextProcessor`-objekt, och du ska få följande resultat:

```
nils: 75
norge: 1
```

### 1.c Gör en `MultiWordCounter`
#### Mål
Kunna räkna flera ord i ett samlat objekt.

#### Teknik
Skriva en TextProcessor som har en Map för att räkna ord.

#### Filer att ändra i
- MultiWordCounterTest.java (Skapas)
- MultiWordCounter.java  (Skapas)
- Holgersson.java

#### Instruktioner
Hittills har vi behövt skapa ett nytt objekt för varje ord vi räknar.
Nu vill vi införa en ny typ av textbearbetning, där inte bara ett enda ord räknas, utan flera.
Vi ska räkna hur många gånger de olika svenska landskapen nämns i boken.

- Skapa en ny klass `MultiWordCounter`, som implementerar interfacet `TextProcessor`.
  Konstruktorn ska ta en vektor av strängar som parameter. Vektorn innehåller de ord vi vill räkna.
- Skapa testklassen `MultiWordCounterTest`.
- Börja med att skriva ett test som visar att en MultiWordCounter som inte processat någon text har hittat 0 av alla ord.
  Metoden `report` ska returnera alla nycklar och respektive värden i din `Map` som en `String`.

- Skriv sedan ett test som visar att metoden `process` ökar antalet om ett givet ord är ett av de sökta orden.
Din klass `MultiWordCounter` ska ha ett attribut av typen `Map`.
Använd `HashMap` som din konkreta datatyp här, vi ska nämligen jämföra den med andra implementationer senare.

- Glöm inte testa att den inte ökar om den får ett ord den inte ska räkna.


Använd `TextAnalyzer` igen med `MultiWordCounter`-klassen.
Anropa den för landskapen i main-metoden i programmet `Holgersson`.
Notera att det finns en användbar strängvektor given i programmet.

Kör programmet.

I resultatet ser vi att gränstrakterna (Skåne, Lappland) nämns relativt ofta. 
Kanske var det angeläget att visa att Sverige ännu var rätt stort, trots att Norge lämnat unionen året innan? 
(Norge nämns ju endast en gång.)


### Uppgift 1.d Räkna alla ord

#### Mål
Räkna alla ord i en text, utom vissa undantagsord, inte bara de angivna.
Rapportera de ord som förekommer fler än 200 gånger.

#### Teknik
Skriv en TextProcessor som har en Map för att räkna alla ord,
som inte är undantagna.

#### Filer att ändra i
- GeneralWordCounter.java (Skapas)
- GeneralWordCounterTest.java (Skapas)
- Holgersson.java

#### Instruktioner
Vi ska nu ta fram information om boken på ett annat sätt. 
Genom att räkna alla ord, inte bara landskap, kan vi skapa oss en uppfattning om bokens innehåll. 
Vi måste emellertid utesluta vissa vanliga ord, som "och", "ett" och "att", för att få ett meningsfullt resultat. 
Vi behöver alltså återigen en tabell av ord, men nu för att räkna alla ord, utom ett antal undantagsord.

- Skapa en klass `GeneralWordCounter`, som implementerar interfacet `TextProcessor` och fungerar enligt följande.
- Skapa en testklass `GeneralWordCounterTest`.
- Testa att `report()` returnerar en tom sträng när inga ord processats.
- Testa att den kan hitta "nils".
- Testa att den inte kan hitta "norge" om "norge" är ett undantagsord.
  Undantagsorden ska skickas med i konstruktorn som en mängd (`Set`). 
- Processa "nils" två gånger och "norge" en gång. 
Sätt gränsen för utskrift till 2 och testa att bara "nils" finns med i resultaten.

- Använd `GeneralWordCounter` i `Holgersson`.
    - Läs in undantagsord från filen `undantagsord.txt` i mappen `input`.
      (Öppna gärna den och se hur den ser ut.)
    - Sätt gränsen för vilka ord som ska skrivas ut till 200.
    - Använd `GeneralWordCounter`-objektet som parameter till `TextAnalyzer`-objekt.
    - Kör programmet. 
    
Vilka är de vanligaste orden i Lagerlöfs bok?

Intresset för gränstrakterna framgår indirekt även här.
Ledargåsen Akka är döpt efter ett lappländskt fjällmassiv, och pojken kommer från Skåne.
Kanske skymtar vi bland orden även nationalromantikens fascination för den vilda naturen?
Testa gärna andra trösklar för hur många gånger orden ska ha varit med för att skrivas ut.

### 1.e SortedGeneralWordCounter — Sortera orden
#### Mål
Lätt kunna hitta de vanligaste orden i en text.
Report ska returnera orden sorterade efter förekomst (flest först) och i bokstavsordning om två är lika vanliga.
#### Teknik
- En subklass till `GeneralWordCounter` — `SortedGeneralWordCounter`
- Inbyggda sort-metoden, men med ett egenskrivet lambda-uttryck.
#### Filer att ändra i
- SortedGeneralWordCounterTest.java (Skapas)
- SortedGeneralWordCounter.java (Skapas)
- GeneralWordCounter.java (ordet private kan behöva bytas mot protected på en eller två ställen.)
- Holgersson.java


När du implementerade metoden `report` ovan la vi till möjligheten att dra en gräns vid till exempel 200 förekomster. 
En sådan fix gräns är ju otillfredsställande. 
Då kommer vi behöva testa oss fram för att se hur många förekomster som är rimligt för varje text.
Istället vore det bättre att skriva ut orden sorterade.

För detta ska vi använda Javas inbyggda sorteringsalgoritm för listor. 
Det är en effektiv algoritm, som låter oss tillhandahålla en egen jämförelse för elementens ordning.
Läs på om hur du använder lambda-uttryck för att anpassa en generisk sortering.

- Skapa en subklass till `GeneralWordCounter`,`SortedGeneralWordCounter`.
- Skapa en testklass `SortedGeneralWordCounterTest`.
- Processa norge två gånger och nils en gång, testa att norge skrivs ut före nils.
- Processa norge och nils två gånger var, testa att nils kommer före norge.
- Sätt gränsen för utskrift till två, processa nils en gång och norge två gånger.
Kolla att bara norge skrivs ut.

Byt ut `new GeneralWordCounter` mot `new SortedGeneralWordCounter` i `Holgersson` och kör programmet. 
Kolla att det fungerar.

## Uppgift 2
### Mål
Undersöka vilka ord som finns i en kodbas.
### Teknik
Läsa in en textfil med java-kod och parsa den med en parser gjord för kod.
Sedan tillämpa samma analysmetoder som på Nils Holgersson-texten.
Undersök vad du kan göra för att få fram bra information om koden.

### Filer att ändra i
- WordsInCode.java (Skapas)
- reserved_and_more.txt (Skapas i slutet av uppgiften)

### Bakgrund
Att använda ett bra språk i sin kod är viktigt. 
Koden ska visa vilken domän som beskrivs, och att ge saker tydliga namn är svårt.
Ett sätt att undersöka en kodbas är genom att räkna antalet "vanliga" ord som förekommer.
Målet är att de ska beskriva problemet som koden försöker lösa.
`input/mindustry.txt` innehåller en sammanslagen del av ett open source projekt 
hämtat från Github.
Programmet för att skapa en fil från en folder med kod finns i paketet `source_merger`.
(Om du blir sugen på att testa med annan kod du hittar.)

### Instruktioner
Skapa klassen `WordsInCode` och låt den utforska `input/mindustry.txt`
på liknande sätt som `Holgersson` utforskar `input/nilsholg.txt`

`ScannerFactory` har en `scannerForCode` att använda i stället för den som `Holgersson`använder.


Filen `input/reserved.txt` innehåller en lista över ord som är reserverade för Java.
Den kan användas för att sortera bort ord som inte kan säga något om domänen.


Du kan också skapa en ny lista över ord att sortera bort,
som även tar med ord som inte är reserverade,
men som inte säger något om domänen.

Testa också att filtrera ut ord som bara är en bokstav. 

- Vilka ord är vanligast om du inte filtrerar bort några ord? F, public, if, import
- Vilka ord är vanligast förutom de reserverade orden? F, x, y, mindustry
- Vilka vanliga ord är bara en bokstav?
x,y,i,e
- Vilka ord hittar du som du tror beskriver domänen? 
  - Hur långt ner på listan kommer de?
- Vad tror du att Mindustry är för program?

## 3 Effektivitet hos HashMap jämfört med TreeMap
### Mål
Undersöka hur valet av implementation av Collections påverkar effektiviteten.

### Teknik
Skriva tester vars främsta syfte är att se hur lång tid koden tar att köra.

### Filer att ändra i
- `GeneralWordCounter`
- `TextAnalyzerPerformanceTest`

När du kör ett enhetstest så visas hur lång tid testet tar. 
Vi ska använda det för att göra ett simpelt test av hur effektiv koden är.
(Det finns specifika ramverk för att testa sådant, men det här räcker för oss just nu.)

`TextAnalyzerPerformanceTest` ska innehålla fyra tester totalt,
som använder `GeneralWordCounter` och `SortedGeneralWordCounter` på hela `nilsholg.txt`,
och på hela `mindustry.txt`.

Kör alla tester ett par gånger.
Notera hur lång tid varje test tar i genomsnitt och mediantiden.

Justera `GeneralWordCounter`, så att den använder `TreeMap` istället för `HashMap`.
Om du har gjort rätt så räcker det ändra på ett ställe. 
(Du ska inte behöva ändra alls i `SortedGeneralWordCounter`)

Kör testerna igen och se hur lång tid de tar nu. 

- Fungerar de andra testerna fortfarande?
- Hur påverkas ordningen i det utskrivna resultatet?
- Hur påverkas tiden för testerna? 
- Går det att se vilken overhead som själva testet har?
- Hur stor skillnad gör storleken på texten, jämfört med om orden sorteras eller inte?
- Testa olika tröskelvärden för hur vanliga ord som ska skrivas ut, påverkar det tiden för testerna?

Extra uppgift:
Hitta en ännu större text för att se om skillnaden blir större. 



## Reflektioner och referenser
Ett intressant exempel på en sådan historisk undersökning av text, större än vad vi har möjlighet att göra här, är: Cameron Blevins, ''Space, Nation, and the Triumph of Region: A View of the World from Houston'': Journal of American History, vol.~101, no.~1, 2014.)

Laborationen är en omarbetning av tidigare laborationer för den här kursen.
Delen där vi tittar på ord i kod är inspirerad av den här 
presentationen av [Cyrille Martraire (@cyriux)](https://youtu.be/icGhEOWPqB4?si=B-PGdNB8v0GOubTq)

