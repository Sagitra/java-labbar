# Laboration 1 EDAA30

## Syfte
Öva på testdriven utveckling, arv och polymorphism.

## Kod om papegojor
I den här laborationen finns test och kod som anger hur fort 
tre olika sorters papegojor flyger.
Uppgiften är att först lägga till funktionalitet genom att 
koda testdrivet.
Sedan är det dags att omstrukturera koden så att varje papegojsort 
har en egen klass som ärver Parrot.
I uppgift tre skrivs koden om så att Parrot istället är ett interface,
och de specifika papegojorna är av typen Record.

## Frågor att fundera på
- Hur väljs var logik hamnar i koden?
- Vilka poänger finns med arv?
- Vad är största skillnaden mellan gränssnitt och arv?
- Vad har gränssnitt och arv gemensamt?
- Vad avgör om arv eller gränssnitt är rätt val?
- Vilken lösning tycker du bäst om?

## Material som kan hjälpa
- [En film om att få in kod i Eclipse](https://lu.instructuremedia.com/embed/3210fbfe-42e5-4840-9505-572270292da3)
- [En film om testdriven utveckling](https://lu.instructuremedia.com/embed/d7dbc7e8-7ff2-4f47-b71d-03cdb471c7c0 )

## Redovisa de olika stegen
Mellan varje steg behöver du spara undan förra lösningen, så att den går att redovisa.

Den mest professionella lösningen är att använda Git,
men det ingår egentligen inte i den här kursen.
För den som vill göra det ändå finns det en [instruktionsfilm här](https://lu.instructuremedia.com/embed/bc0b37c5-77fa-4eeb-8ccc-590e129ea917)
Du behöver inte ha ett konto på github (eller gitlab, bitbucket etc) 
för att använda branches, men det ger en visualisering, backup och gör att det går att samarbeta
kring koden. 
Det finns också en beskrivning av git i Moodle under "kursinformation".
Skriv tydligt i meddelandet till den commit som är sista i en deluppgift, 
eller skapa en ny branch för varje deluppgift. 

Om Git känns för krångligt just nu, testa något av följande:
- Ta en bild av skärmen
- Spara undan filerna på en annan plats
- Byt namn på de gamla filerna.


## Uppgift 1, TDD
Lägg till var papegojorna bor.
Skriv en metod på Parrot-klassen som returnerar var papegojan bor.
Öva på att testdriva utvecklingen.

### Specifikation

- Afrikanska papegojor bor i hål i träd.
- Europeiska papegojor bor i ett bo byggt av pinnar.
- Norwegian blue bor i en bur, om den är fastspikad.
Är den inte fastspikad bor den ingenstans.


## Uppgift 2, arv

Skriv om lösningen så att den använder arv. 
Använd testerna för att se till att koden fortfarande fungerar.
Testerna ska inte ändras, förutom `getParrot`.
Ändra så att den returnerar olika sorters papegojor beroende på vilken enum som skickas in.
`getParrot` ska dock ha kvar sin signatur.
Jobba i så små steg som möjligt.

TIPS: Målet är att den enda switch-case på `ParrotTypeEnum` är i `getParrot`,
när du är klar med uppgift 2.

## Uppgift 3, gränssnitt
Skriv om lösningen så att varje papegoja är ett Record.
Parrot är ett interface.
Record-klassen kan du läsa om [här](https://blogs.oracle.com/javamagazine/post/records-come-to-java).


## Referenser
Den här övningen bygger på en kata från Emily Bache.
Hon inspirerades av Martin Fowlers bok "Refactoring". 
Innehållet kan också härledas till Monty Pythons sketch "Dead parrot".
