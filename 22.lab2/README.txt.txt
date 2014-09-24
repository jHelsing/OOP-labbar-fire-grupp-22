Del 1:
-------------------------------
TestRseEH utkod:
1)  a=  correct (T) [ { 1 2 1 2 1 2 } { 4 0 0 2 2 1 } { 1 1 1 1 1 4 } ]
2)  b=  correct (F) [ { 1 2 3 4 } { 5 6 7 8 } { 1 1 1 1 } ]
3)  c=  correct (T) [ { 1 } { 2 -1 } { 3 -1 -1 } ]
4)  d=  correct (T) [ null ]
5)  e=  correct (T) [ null null null ]
6)  f=  correct (T) [ - ]
7)  g=  correct (T) [ { - } ]
8)  h=  correct (T) [ { 1 2 3 } ]
9)  i=  correct (F) [ { 1 } { 2 } { 3 } ]
10) j=  correct (T) [ { 0 } ]
11) k=  correct (F) [ { 1 2 3 } { 3 2 1 } { 4 4 4 } ]
12) l=  correct (F) [ { 1 2 3 } { 3 -2 -1 } { 4 4 4 } ]
13) m=  correct (T) [ { 0 0 0 0 } null { 5 5 -5 -5 } ]
14) n=  correct (T) [ { 0 0 0 0 } null { - } ]
15) o=  correct (F) [ { 0 0 3 0 } null { - } ]
16) p=  correct (F) [ { 1 2 3 } { 4 5 6 } { 7 8 9 } { 1 2 3 } ]
17) q=  correct (F) [ { 1 2 3 } { 4 5 6 } { 7 8 9 } { 7 8 9 } ]
Rse: All tests passed

Del 2:
----------------------------------
Testprogrammet RatNumTest3 är utformat för att använda de olika metoderna och konstruktörerna i RatNum klassen som vi har skrivit.
Detta gör programmet genom följande:

Programmet börjar med att köra metoden divTester från java-filen RatNumTest2, denna metod kollar ifall våra konstruktörer fungerar som de ska,
annars returneras ett fel. (Denna kollar ifall det exempelvis fungerar att lämna täljaren till 0, eller att inte ge några argument alls).

Efter detta kör programmet metoden divTester (som ligger i RatNumTest3) denna metod skapar ett antal olika rationella tal med olika parametrar.
Dessa tal jämförs med varandra via equals-metoden (dessa test var inte så viktiga att klara då vi inte hade gått igenom equals).
De jämför helt enkelt talens parametrar (exempelvis är RatNum(int 3, int 15) samma som RatNum(int 1, int 5) då täljaren och nämnaren förkortas via gcd).
Efter detta skrivs eventuell felkod för de olika equal-testen ut, det kvittar om man klarar dem eller inte, programmet fortsätter köra ändå.
Metoden avslutas med att testa vår toDouble funktion genom att konvertera två till synes samma rationella tal till double och sedan subtrahera dem,
är skillnaden mindre än 1.0e-10 så returneras false (double ger endast ett närmevärdet till det faktiska värdet, därför måste man ha ett litet "felrum").

Efter detta skapar programmet några strings och en boolean som sedan skall användas vid de olika kontrollerna som skall utföras. 
Vidare kollar programmet om det försetts med en fil (exempelvis indata.txt) och om den skall läsa informationen från den, om inte så skall inmatningen
skötas av en människa, och då skapas en scanner som läser nextLine, dvs. nästa uttryck som "Användaren" anger, och skickar sedan in detta i testExpr.
Skulle programmet istället förses med en fil så läses data där ur och "Användaren" får inte möjlighet att ange uttryck.
Programmet är sedan utformat för att skriva ut resultatet av operationen och eventuellt ange om det blir fel eller om en exception bildas.

I metoden testExpr konverteras den inskickade strängen först till sina respektive uttryck. Dvs. den delar upp strängen i rationella tal (i textform). 
den sorterar således bort operationerna +-*/ och beroende på vad denna är skickas uttrycken in i metoden för denna operatorn. 
Exempel: 1/3 + 3/5 skickas in som 1/3 och 3/5 i metoden add(). 
Detta görs i en try/catch statement, try skapar två rationella tal, ett via parse-metoden och ett via "String" konstruktorn.
Skulle något bli fel så fångar den ett NumberFormatException och skriver ut ett felmeddelande.
Svaren returneras sedan som en textsträng via att ett Rationellt tal (som bildas av respektive operation) omvandlas till en textsträng via toString
denna sträng blir sedan resultatet som skrivs ut för användaren att se.








