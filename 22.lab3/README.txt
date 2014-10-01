-- CHANGELOG --
2014-09-29: Jonathan har gjort uppgift a i del 1.
2014-09-29: Jonathan har lagt in konstruktor och getNbrOfCounters i CounterModel.



Svar på frågor:
---------------------------
b) 
Första linjen (System.out.println("k="+k);) Kommer skriva ut värdet på k, alltså 5. Man kan säkert tro att k skulle vara 6, 
n i metoden(som har samma värde som k) inkrementeras, men så är det inte. Man jobbar med variabeln n separat, 
den har bara samma startvärde som k. 

Andra linjen (! System.out.println("a="+a.getValue());) kommer returnera aktuella räknares värde+1, då metoden kallar på klassmetoden increment i klassen 
counterModel, som är en instansmetod. Således ändras värdet med ett i instansen a, och värdet som skrivs ut är aktuellt värde +1.

Tredje linjen (System.out.println("b="+b.getValue());) kommer skriva ut aktuellt värde i b, då c2 initieras till en ny instans av klassen CounterModel
i metoden, det andra värdet (b) "överskuggas" så att det inte ändras. Det är endast den temporära instansen c2 som incrementeras till startvärdet +1. 

c) 
Om man ändrar instansvariabeln till static så kommer denna vara "statisk" dvs. den kommer ha samma värde globalt och kommer inte få någt speciellt värde per instans.
Man vill ju ha flera räknare som kan räkna oberoende av varandra, inte ett satt värde för samtliga räknare. Det går inte heller att ändra en statisk 
variabel via en "icke-statisk" metod. 
Lägger man till en variabel som heter NbrOfCounters bör den vara statisk, dvs. en klassvariabel, för den skall endast hålla reda på antal räknare som skapats
man kan exempelvis incrementera den vid konstruktorn, så att så fort en ny räknare skapas så inkrementeras denna variabeln. Det är således inte lämpligt
att ha den som en instansvariabel. metoden skall också vara statisk, då du inte skall behöva skapa en ny instans av en räknare för att kolla hur
många räknare som finns (slöseri med minnesresurser).