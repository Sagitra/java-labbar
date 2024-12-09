# Test Driven Development (TDD), test-driven utveckling



## Vad är testdriven utveckling?

TDD är när kod och test utvecklas tillsammans, så att all funktionalitet som läggs till har ett fallerande test som det får att passera. Testfel kan bero på att koden inte kompilerar, att den får fel när den kör eller att koden inte uppför sig som förväntat, genom att det finns ett antagande (assertion) i koden.

## Röd, grön, omstrukturera

TDD görs genom att ett test skapas som inte fungerar, lite kod skrivs så att det fungerar, kod och test uppdateras så att det ser bra ut, testet ändras (eller ett nytt test påbörjas) så att det finns ett test som inte fungerar igen, och så fortsätter det.

### Enhetstest
Det vanligaste testet som används i TDD är enhetstestet (unit test).
Ett enhetstest testar en isolerad bit kod och ska bara ha en anledning till att den kan gå sönder.
Det är viktigt att varje test ger så bra information som möjligt när det är rött.

## Riktlinjer

### Alla test måste börja som röda
Inga test får skrivas så att de är gröna från början. Om du är orolig att du har för få test, ändra något i koden så att den slutar fungera som den ska. Om inga test blir röda då får du skriva ett nytt rött test och ändra tillbaka koden så att det blir grönt.
Det finns två anledningar till att alla test måste börja som röda.
Det gör att du vet att testet kan bli rött, ingen blir glad över test som alltid är gröna, även om koden slutar fungera.
Hindrar dig från att skriva för många test. Vi vill bara ha test som gör skillnad.

### Bara ett test bör vara rött i taget
Skriv aldrig mer än ett nytt test åt gången. Om du vill göra en lista över saker att testa, gör det som en kommentar. Det här är för att ta små steg och låta koden och testet utvecklas ihop.

### Testa bara en sak i varje test
Ha bara ett antagande per test. Det är för att få så specifik information som möjligt när testet går sönder.

### Minsta möjliga ändring
Gör alltid bara minsta möjliga ändring för att få testet att passera. 
Ändra sedan testet, eller lägg till ett nytt, innan du lägger till något mer i din kod. 
Kollar testet att add(3, 3) ger 6, returnera alltid 6, tills ett annat test kollar add(1, 1). Det här hjälper dig att fokusera på problemet och inte på lösningen. Du kan alltid städa upp i efterhand.

### Refaktorisera testerna
Ändra i testerna efter hand så att de blir lättare att förstå.

TIPS! Många utvecklingsmiljöer låter dig skapa kod i din klass utifrån tester som använder ko  som inte finns än. På så sätt kan du slippa skriva extra mycket.


## Fördelar med TDD


- Verktyg för att tänka

- Gör koden lättare att använda

- Regression, du märker om du har sönder något.

- Ett sätt att lära sig ett språk eller nya bibliotek
