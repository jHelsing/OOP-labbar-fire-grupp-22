Labgrupp 22
Jonathan Helsing och Tobias Alldén


Uppgifter

1. cd är kommandot som tar dig till din hemmapp.

3. Kommandot som används är ls -l. På datorn vi använder (OS X 10.9.4) får vi upp 9 kolumner. den första är rättigheterna till filen, läs skriv eller båda. Den andra är antalet länkar. Den tredje är namnet på filens/mappens ägare. Den fjärde är namnet på gruppen han tillhör. Den femte kolumnen är antalet bytes som finns i filen (så som det benämns i man ls). Den sjätte kolumen är datumet då filen senast modifierades. Den sjunde kolumnen är förkortningen på månaden då filen senast modifierades. Den åttonde kolumnen är tidpunkten då filen modifierades senast. Ibland står det ett årtal istället för klockslaget (misstänker att det är när det var minst 1 år sedan filen modifierades). Den sista kolumen, den nionde, är vad filen heter (path-name).
Alla har läs och skrivrättigheter. (Privat dator).

4. Bara ägaren har skriv-, läs- och exekveringsrättigheter. Kommandot chmod go-rwx fil/mappnamn ändra rättigheterna för mappen/filen till rwx, alltså bara ägaren har rätt att läsa, skriva och exekvera filen/mappen. Övriga användare har inte rättigheter att göra något med filen/mappen.

5. Filen inne i “f1pt” som precis skapades har ägaren läs-och skrivrättigheter. Övriga användare har rätt att läsa filen. 

8. a) Exception in thread "main" java.lang.Error: Unresolved compilation problem: 

	at HelloWorld.main(HelloWorld.java:8)

Eclipse visar här på ett kompileringsfel som börjar vid rad 8, programmet kunde alltså inte kompilera rad sju korrekt. Programmet ger inte något konkret svar på vad som egentligen gick fel, det bara specificerar vilken rad felet inträffade på.

b) Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
	Syntax error, insert "}" to complete ClassBody

		at HelloWorld.main(HelloWorld.java:10)

Här hittar Eclipse felet och kan även ge förslaget att man skall sätta in en slutparantes för att programmet skall kompileras korrekt. För tillfället saknas slutparanteser som säger åt kompilatorn att programkoden är slut. Detta gillar inte kompilatorn.


c) Tar man bara bort ”public” från klassen händer inget speciellt, då programmet bara innehåller en klass. Public eller Private delger endast klassens/variabelns tillgänglighet från utanför metoden. Och används för att isolera vissa variabler så man inte kan komma åt dem från andra ställen än tänkt. Man kan göra liknande med klasser, sätter man private kan man inte komma åt innehåll ifrån dem utanför klasserna själva.
”Fel: Huvudmetoden finns inte i klassen HelloWorld, definiera huvudmetoden som: public static void main(String[] args) eller så måste en JavaFX-applikationsklass utöka javafx.application.Application”

Tog man istället bort ”public” från main()-funktionen så fick man ut ett felmeddelande. Dock fick vi istället här felmeddelandet på Svenska. Varför vet vi inte. Felet är dock rätt lätt avvärjt då java ger en utförlig förklarning på hur man skall skriva för att få ett fungerande program (Man måste ha en huvudfunktion i programmet).

d) Fel: Huvudmetoden är inte static i klassen HelloWorld, definiera huvudmetoden som: public static void main(String[] args)
Här förklarar kompilatorn att huvudmetoden i programmet måste vara statisk. En statisk metod i en klass kan anropas utan att du först skapat en instans av klassen, detta är självklart vitalt då du använder metoden för att styra programmet.

e) Fel: Huvudmetoden är inte static i klassen HelloWorld, definiera huvudmetoden som: public static void main(String[] args)
Du får samma felmeddelande som föregående. Java har ganska bestämda riktlinjer hur allt ska se ut.
