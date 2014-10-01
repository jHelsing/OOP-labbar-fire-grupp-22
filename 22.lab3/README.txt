-- CHANGELOG --
2014-09-29: Jonathan har gjort uppgift a i del 1.
2014-09-29: Jonathan har lagt in konstruktor och getNbrOfCounters i CounterModel.



Svar p� fr�gor:
---------------------------
b) 
F�rsta linjen (System.out.println("k="+k);) Kommer skriva ut v�rdet p� k, allts� 5. Man kan s�kert tro att k skulle vara 6, 
n i metoden(som har samma v�rde som k) inkrementeras, men s� �r det inte. Man jobbar med variabeln n separat, 
den har bara samma startv�rde som k. 

Andra linjen (! System.out.println("a="+a.getValue());) kommer returnera aktuella r�knares v�rde+1, d� metoden kallar p� klassmetoden increment i klassen 
counterModel, som �r en instansmetod. S�ledes �ndras v�rdet med ett i instansen a, och v�rdet som skrivs ut �r aktuellt v�rde +1.

Tredje linjen (System.out.println("b="+b.getValue());) kommer skriva ut aktuellt v�rde i b, d� c2 initieras till en ny instans av klassen CounterModel
i metoden, det andra v�rdet (b) "�verskuggas" s� att det inte �ndras. Det �r endast den tempor�ra instansen c2 som incrementeras till startv�rdet +1. 

c) 
Om man �ndrar instansvariabeln till static s� kommer denna vara "statisk" dvs. den kommer ha samma v�rde globalt och kommer inte f� n�gt speciellt v�rde per instans.
Man vill ju ha flera r�knare som kan r�kna oberoende av varandra, inte ett satt v�rde f�r samtliga r�knare. Det g�r inte heller att �ndra en statisk 
variabel via en "icke-statisk" metod. 
L�gger man till en variabel som heter NbrOfCounters b�r den vara statisk, dvs. en klassvariabel, f�r den skall endast h�lla reda p� antal r�knare som skapats
man kan exempelvis incrementera den vid konstruktorn, s� att s� fort en ny r�knare skapas s� inkrementeras denna variabeln. Det �r s�ledes inte l�mpligt
att ha den som en instansvariabel. metoden skall ocks� vara statisk, d� du inte skall beh�va skapa en ny instans av en r�knare f�r att kolla hur
m�nga r�knare som finns (sl�seri med minnesresurser).