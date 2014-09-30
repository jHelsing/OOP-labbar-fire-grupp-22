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
Testprogrammet RatNumTest3 �r utformat f�r att anv�nda de olika metoderna och konstrukt�rerna i RatNum klassen som vi har skrivit.
Detta g�r programmet genom f�ljande:

Programmet b�rjar med att k�ra metoden divTester fr�n java-filen RatNumTest2, denna metod kollar ifall v�ra konstrukt�rer fungerar som de ska,
annars returneras ett fel. (Denna kollar ifall det exempelvis fungerar att l�mna t�ljaren till 0, eller att inte ge n�gra argument alls).

Efter detta k�r programmet metoden divTester (som ligger i RatNumTest3) denna metod skapar ett antal olika rationella tal med olika parametrar.
Dessa tal j�mf�rs med varandra via equals-metoden (dessa test var inte s� viktiga att klara d� vi inte hade g�tt igenom equals).
De j�mf�r helt enkelt talens parametrar (exempelvis �r RatNum(int 3, int 15) samma som RatNum(int 1, int 5) d� t�ljaren och n�mnaren f�rkortas via gcd).
Efter detta skrivs eventuell felkod f�r de olika equal-testen ut, det kvittar om man klarar dem eller inte, programmet forts�tter k�ra �nd�.
Metoden avslutas med att testa v�r toDouble funktion genom att konvertera tv� till synes samma rationella tal till double och sedan subtrahera dem,
�r skillnaden mindre �n 1.0e-10 s� returneras false (double ger endast ett n�rmev�rdet till det faktiska v�rdet, d�rf�r m�ste man ha ett litet "felrum").

Efter detta skapar programmet n�gra strings och en boolean som sedan skall anv�ndas vid de olika kontrollerna som skall utf�ras. 
Vidare kollar programmet om det f�rsetts med en fil (exempelvis indata.txt) och om den skall l�sa informationen fr�n den, om inte s� skall inmatningen
sk�tas av en m�nniska, och d� skapas en scanner som l�ser nextLine, dvs. n�sta uttryck som "Anv�ndaren" anger, och skickar sedan in detta i testExpr.
Skulle programmet ist�llet f�rses med en fil s� l�ses data d�r ur och "Anv�ndaren" f�r inte m�jlighet att ange uttryck.
Programmet �r sedan utformat f�r att skriva ut resultatet av operationen och eventuellt ange om det blir fel eller om en exception bildas.

I metoden testExpr konverteras den inskickade str�ngen f�rst till sina respektive uttryck. Dvs. den delar upp str�ngen i rationella tal (i textform). 
den sorterar s�ledes bort operationerna +-*/ och beroende p� vad denna �r skickas uttrycken in i metoden f�r denna operatorn. 
Exempel: 1/3 + 3/5 skickas in som 1/3 och 3/5 i metoden add(). 
Detta g�rs i en try/catch statement, try skapar tv� rationella tal, ett via parse-metoden och ett via "String" konstruktorn.
Skulle n�got bli fel s� f�ngar den ett NumberFormatException och skriver ut ett felmeddelande.
Svaren returneras sedan som en textstr�ng via att ett Rationellt tal (som bildas av respektive operation) omvandlas till en textstr�ng via toString
denna str�ng blir sedan resultatet som skrivs ut f�r anv�ndaren att se.








