Del 1: Fr�gor:


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


----------------------------------------------------------
Del 2: Sekant
TestSecantEH, utskrift:
### Version: 2014.0 #################################
eps= 1.0E-6
status should be "OK" for all rows below
Sorry for the long lines
Printout look like this:
status : function :      ~right answer = obtained root # (intervall) # nbr of recursive calls <<<<ev. Error reason>>>> <<ev. comment>>
--------------------------------------------------
OK: "3x-6"              :         2.0 = 2.0 #(0.0..5.0)# 0 <<.>>
OK: "3x-6"              :         2.0 : ---- #(3.0..5.0)#
                        <<<<caught EXC:No roots found in interval>>>>
                        <<IntervalErr: !!!! root outside interval>>
OK: "x*x-0.6"           : +/-0.774596 = 0.7745957778981336 #(0.0..5.0)# 0 <<long rightinterval>>
OK: "x*x-0.6"           : +/-0.774596 = 0.7745965642894326 #(0.0..0.8)# 0 <<short rightinterval>>
OK: "x*x-0.6"           : +/-0.774596 = 0.774596094324981 #(0.77..2.0)# 0 <<short leftinterval>>
OK: "x*x-0.6"           : +/-0.774596 = 0.774596193028087 #(-0.7..2.0)# 0 <<long leftinterval>>
OK: "x*x-0.6"           : +/-0.774596 = 0.7745966639321847 #(0.7..0.775)# 0 <<short interval>>
OK: "x*x-0.6"           : +/-0.774596 = 0.7745957778981336 #(5.0..0.0)# 0 <<IntervalErr: interval in wrong order, should report that i.e. raise exc.>>    ***** root correct anyway
OK: "x*x-0.6"           : +/-0.774596 : ---- #(1.0..1.0)#
                        <<<<caught EXC:No roots found in interval>>>>
                        <<IntervalErr: no interval, , should report that i.e. raise exc.>>
OK: "x*x-0.6"           : +/-0.774596 : ---- #(-2.0..2.0)#
                        <<<<caught EXC:No roots found in interval>>>>
                        <<ErrOK: two equal roots in interval, does not converge, should raise exc.>>
OK: "x*x-0.6"           : +/-0.774596 = -0.77459584295612 #(-1.0..0.0)# 0 <<decreasing>>
OK: "x*x-0.6"           : +/-0.774596 = -0.77459584295612 #(-1.0..-0.6)# 0 <<decreasing>>
OK: "-(x*x-0.6)"        : +/-0.774 596 = 0.7745957778981336 #(0.0..5.0)# 0 <<decreasing, =last function but mirrored in x-axis>>
OK: "x^2-4"             :      +/-2.0 = 1.9999991636995424 #(0.0..4.0)# 0 <<.>>
OK: "x^2-4"             :      +/-2.0 = 2.0 #(2.0..4.0)# 0 <<!!!! root=intervals left limit>>
OK: "x^2-4"             :      +/-2.0 = 2.0 #(0.0..2.0)# 0 <<!!!! root=intervals right limit>>
OK: "x-2E-16"           :         0.0 = 2.0E-16 #(0.0..1.0)# 0 <<root very close to intervals left limit>>
OK: "cos(x)-x*x*x"      :    0.865 474 = 0.8654735452268012 #(0.1..1.0)# 0 <<.>>
OK: "cos(x)-x*x*x"      :    0.865 474 = 0.865473888879579 #(-1.0..1.0)# 0 <<.>>
OK: "sin(x)-(x/2)^2"    :    0 och 1.9337 5376 = 1.9337529291371662 #(1.5..2.0)# 0 <<.>>
OK: "sin(x)-(x/2)^2"    :    0 och 1.9337 5376 = 1.956036318984545E-7 #(-0.5..0.5)# 0 <<.>>
OK: "1E-16*x*x-1E-17"   : ca 0.316 227 = 0.3162268182686503 #(0.1..2.0)# 0 <<extremly shallow>>
OK: "1E-16*x*x-1E-17"   : ca 0.316 227 = 0.3162270927019573 #(0.0..1.0)# 0 <<extremly shallow>>
OK: "1E-16*x*x-1E-17"   : ca 0.316 227 = 0.31622682576081457 #(0.0..0.5)# 0 <<extremly shallow>>
OK: "1E-16*x*x-1E-17"   : ca 0.316 227 = 0.31622680192879127 #(0.0..2.0)# 0 <<extremly shallow>>
OK: "1E-16*x*x-1E-17"   : ca 0.316 227 = 0.3162267661585785 #(0.0..100.0)# 0 <<extremly shallow>>
OK: "x*x*x-x*x+2*x"     :         0.0 = -0.0 #(-1.0..2.0)# 0 <<.>>
OK: "x*x*x-x*x+2*x"     :         0.0 : ---- #(0.1..5.0)#
                        <<<<caught EXC:No roots found in interval>>>>
                        <<IntervalErr: Root outside interval after a couple of recursions>>
OK: "x*x*x-x*x+2*x"     :         0.0 = -0.0 #(0.0..5.0)# 0 <<.>>
OK: "(x+10)*(x+10)-0.6" : -10.774 596 och -9.225 403  : ---- #(-16.0..-8.0)#
                        <<<<caught EXC:No roots found in interval>>>>
                        <<IntervalErr: !!!! 2 roots in interval, can give exc. after a couple of recursions>>
OK: "(x+10)*(x+10)-0.6" : -10.774 596 och -9.225 403  = -10.774595842956119 #(-11.0..-10.0)# 0 <<left root>>
OK: "(x+10)*(x+10)-0.6" : -10.774 596 och -9.225 403  = -9.225404222101867 #(-10.0..-5.0)# 0 <<right root>>
OK: "log(x)"            :        1.0 = 1.0000007519792211 #(0.1..2.0)# 0 <<.>>
OK: "log(x)"            :        1.0 = 1.0000006976417046 #(0.1..50.0)# 0 <<.>>
OK: "arctan(x)"         :        0.0 = -0.0 #(0.0..5.0)# 0 <<arctan is a horizontal x^3 curve, root on one of the intervals>>
OK: "arctan(x)"         :        0.0 = -9.935503635592622E-11 #(-50.0..5.0)# 0 <<long interval>>
OK: "arctan(x)"         :        0.0 = 9.935503635592622E-11 #(-5.0..50.0)# 0 <<long interval>>
OK: "arctan(x)"         :        0.0 = -0.0 #(-1.0..1.0)# 0 <<.>>
Number of errors= 0
Test completed
