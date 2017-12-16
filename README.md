# CinemaSystem Project
## �ltal�nos le�r�s

A szoftver egy mozi rendszer feladatait fogja ell�tni. 
Feladati k�z� tartoznak a:

1. __Jegyfoglal�s__ lehetos�g�nek biztos�t�sa
2. __Jegyv�s�rl�s__ lehetos�g�nek biztos�t�sa
3. __Jelenleg vet�tett__ filmek megtekint�se
4. __�sszes__ vet�tett film megtekint�se �s szur�s sz�n�szre, �vsz�mra stb.
5. __Mozitermek__ �s kapacit�suk list�z�sa
6. __Vet�t�sek__ megtekint�se �s ezen kereszt�l foglal�s az adott vet�t�sre
7. __Bejelentkez�s__, __regisztr�l�s__ �s a foglal�sok list�z�sa.

## Nem funkcion�lis k�vetelm�nyek

Elso �s legfontosabb k�vetelm�ny, hogy a program k�nnyen haszn�lhat� �s �tl�that� legyen ak�r idosebbek sz�m�ra is,
tekintve, hogy egy ehhez hasonl� szoftvert _b�rmely_ koroszt�lynak tudnia kell haszn�lni.

Jegyfoglal�s eset�ben a felhaszn�l�nak megadott idokeret �ll rendelkez�s�re, hogy __lefoglalja__ a jegyet,
azt�n �jra el�rheto kell legyen a t�bbi foglal� sz�m�ra is.

Helyfoglal�sn�l a felhaszn�l� l�ssa, hogy mely sz�kek __szabadok__ m�g az adott teremben (a __terem neve__ is l�that� legyen) �s
legyen lehetos�ge kiv�lasztani, hogy melyik �lohelyeket szeretn� lefoglalni.

__Egyed�l�ll�__ sz�ket ne lehessen foglalni!

Foglal�s ut�n sz�ks�ges megeros�teni a foglal�st *e-mail*, vagy *telefonsz�m* seg�ts�g�vel.

A vet�t�sek list�z�s�n�l egy kattint�ssal el�rheto legyen a foglal�s �s itt lehetos�g legyen a jegy *megv�s�rl�s�ra* is.

A foglal�shoz sz�ks�ges legyen megadni a *nevet, e-mail c�met �s telefonsz�mot.*
A foglal�s ut�n legyen lehetos�g t�rl�sre is, ha esetleg a felhaszn�l� meggondoln� mag�t.

A foglal�sra legyen lehetos�g regisztr�ci�/bejelentkez�s n�lk�l is, ebben az esetben a t�rl�shez a nevet/telefonsz�mot kelljen megadni.

Foglal�st ne lehessen t�r�lni __4 �r�val__ a vet�t�s kezdete elott!

Legyen lehetos�g bejelentkezni k�z�ss�gi oldalak seg�ts�g�vel is.

A vet�t�sekre lehessen szurni *d�tum/terem* szerint.

Filmekre lehessen szurni *c�m, �v, mufaj, sz�n�sz* szerint.

Regisztr�ci� ut�n sz�ks�ges legyen megeros�teni az e-mail c�met.

Bejelentkez�s ut�n legyenek el�rhetoek k�l�nb�zo nyerem�nyj�t�kok stb., amelyek hetente v�ltozhatnak.

## Funkcion�lis k�vetelm�nyek
### Funkci�k muk�d�se helyes felhaszn�l�s mellett

1. __Jegyfoglal�s:__ 
A felhaszn�l� megadja az adatait, kiv�lasztja az �lohelyet/helyeket a megadott idokereten bel�l. 
A rendszer e-mailt k�ld a felhaszn�l�nak a foglal�s�r�l �s megeros�t�s ut�n a foglal�s adatait elmenti az adatb�zisban.

2. __Jegyv�s�rl�s:__ 
A jegyfoglal�sn�l felt�ntetett adatokon t�l egy �rv�nyes banksz�mlasz�m megad�sa is sz�ks�ges.
A rendszer emailben k�ld �rtes�t�st a v�s�rl�sr�l, �s megeros�t�s ut�n t�rt�nik meg t�nylegesen a sz�mla megterhel�se, �s az adatok adatb�zisba ment�se.

3. __Filmek/Vet�t�sek keres�se:__ A felhaszn�l� megadja a keres�si felt�teleket(*sz�n�sz, teremsz�m, �vsz�m* stb.)
A rendszer kilist�zza a keres�s eredm�nyeit.

4. __Regisztr�ci�:__ A felhaszn�l� a regisztr�ci�hoz sz�ks�ges adatainak megad�sa ut�n (*e-mail, n�v, telefonsz�m, jelsz�, jelsz� �jb�l*) �s az e-mailben kapott megeros�t�s elv�gz�se ut�n beker�l az adatb�zisba.

5. __Bejelentkez�s:__ A felhaszn�l� e-mailc�m-jelsz� kombin�ci�val tud bejelentkezni. Sikeres bejelentkez�s ut�n a kezdooldalra �rve lehetos�ge van a fenti opci�k haszn�lat�ra (bejelentkez�s n�lk�l szint�n). Bejelentkezett felhaszn�l� eset�n a Jegyfoglal�s/Jegyv�s�rl�s alkalm�val nem kell megadni �jb�l az adatokat, azokat az adatb�zis m�r t�rolja.

6. __Foglal�s/V�s�rl�s visszavon�sa:__ A felhaszn�l� a foglal�st/v�s�rl�st k�veto __4 �r�n bel�l__ meggondolhatja mag�t.
Ebben az esetben a foglal�s adatai t�rlodnek az adatb�zisb�l, �s v�s�rl�s eset�n megt�rt�nik a v�s�rl�s �rt�k�vel megegyezo ellent�tes ir�ny� tranzakci�.

### Funkci�k muk�d�se hib�s felhaszn�l�s mellett

1. __Jegyfoglal�s:__ 
A felhaszn�l� megadja az adatait, kiv�lasztja az �lohelyet/helyeket.  
A rendszer hiba�zenettel jelzi, ha lej�rt a foglal�sra sz�nt idokeret, hib�s az e-mail form�tum, vagy egyed�l�ll� sz�kre ker�lt a v�laszt�s.

2. __Jegyv�s�rl�s:__ 
A jegyfoglal�sn�l felt�ntetett adatokon t�l banksz�mlasz�m megad�sa is sz�ks�ges.
A rendszer hiba�zenettel jelzi, a jegyfoglal�sn�l felt�ntetett hibalehetos�gek valamelyike fell�p, valamint ha a baksz�mlasz�m �rv�nytelen form�tum�.

3. __Filmek/Vet�t�sek keres�se:__ A felhaszn�l� megadja a keres�si felt�teleket(*sz�n�sz, �vsz�m, teremsz�m* stb.)
Hibajelz�s amennyiben a sz�n�sz hely�re sz�m ker�l.

4. __Regisztr�ci�:__ A felhaszn�l� a regisztr�ci�hoz sz�ks�ges adatait megadja(*e-mail, n�v, telefonsz�m, jelsz�, jelsz� �jb�l*)
Hibajelz�s, ha nem egyezik a k�t jelsz�, vagy ha az emailc�m form�tuma nem megfelelo.

5. __Bejelentkez�s:__ A felhaszn�l� e-mailc�m-jelsz� kombin�ci�val tud bejelentkezni.
Hib�s felhaszn�l�n�v vagy jelsz� eset�n hiba�zenettel �rtes�ti a felhaszn�l�t.

6. __Foglal�s/V�s�rl�s visszavon�sa:__ A felhaszn�l� a foglal�st/v�s�rl�st k�veto __4 �r�n t�l__ meggondolja mag�t.
Ebben az esetben a rendszer hiba�zenettel jelzi, hogy sajnos m�r nincs lehetos�g a foglal�s/v�s�rl�s lemond�s�ra.

## Tesztel�s 

A projekt sor�n minden dao/service/controller �s model oszt�ly is tesztel�sre ker�l.
Az �tfog� teszt oszt�ly az ApplicationTests �s k�l�n packagekben tal�lhat�ak meg a tesztek.

### DAO
dao package: DaoTest
1. actorDaoTest
2. newsDaoTest
3. movieDaoTest
4. screeningDaoTest
5. userDaoTest
6. actorDaoTest
7. reservationDaoTest

Ezek a tesztek az adatb�ziskezel�st pr�b�lj�k tesztelni.
Legfobb c�ljuk, hogy az alapveto (insert, update etc.) muveletek hiba (Exception, vagy barmilyen adatmodositasi hiba) n�lk�l menjenek vegbe.

A fobb tesztek a null test, result set m�rete, exception test (assert false).

Term�szetesen a kapcsolatok (OneToMany, ManyToOne etc.) is tesztel�sre ker�lnek. Legt�bbsz�r itt ConstraintViolationException-t v�r el a teszt, mikor megpr�b�ljuk t�r�lni a kapcsolat egyik elem�t p�ld�ul.

B�r a DAO-k megval�s�t�sa egy k�z�s GenericDaoImpl oszt�llyal t�rt�nik, ettol f�ggetlen�l mindegyik modell dao-ja tesztel�sre ker�lt r�szletesen.

### Service
service package: ServiceTest
1. actorServiceTest
2. newsServiceTest
3. movieServiceTest
4. screeningServiceTest
5. userServiceTest
6. actorServiceTest
7. reservationServiceTest

A service tesztek az �zleti logik�t tesztelik.

�gy mint a DAO-k eset�ben itt is egy k�z�s ososztallyal t�rt�nt a servicek megval�s�t�sa. (AbstractService)
Ettol f�ggetlen�l term�szetesen minden modellhez tartoz� service oszt�ly k�l�n tesztel�sre ker�lt.

### Controller

controller package: ControllerTest
1. actorControllerTest
2. movieControllerTest
3. screeningControllerTest
4. reservationControllerTest
5. userControllerTest


A kontroller tesztek elk�sz�t�se sor�n a legfontosabb, hogy a megfelelo v�gpontok lek�rdez�sekor 200-as responset kapjunk.
Fontos, hogy semmik�pp se 404, vagy egy�b hib�t az alatta l�vo layerek miatt.
A tesztek hib�tlanul lefutottak �s legt�bb esetben az egyedi funkci�k is tesztel�sre ker�ltek.

A NewsController tesztel�s�re nem ker�lt sor, mivel egy az egyben a GenericService ososztalyt haszn�lja, 
amely tesztel�sre ker�lt az �sszes t�bbi teszteset sor�n.

### Model
A modellek tesztel�s�re nem k�sz�lt k�l�n tesztoszt�ly, mivel a modellek �sszes funkci�ja tesztel�sre ker�l a fenti tesztek sor�n
egyfajta integr�ci�s teszt form�ly�ban.

### �sszegz�s
A back-end tesztel�se a Unit �s integr�ci�s tesztel�sek kombin�ci�j�b�l sz�letett meg.
Minden tesztoszt�ly tranzakcion�lis, vagyis vissza�ll�tja az adatb�zist konzisztens �llapotba a teszt v�gezt�vel.
Az integr�ci�s teszt legfontosabb r�sz�t ezzel lefedt�k.
A tesztek nagyr�szt az import.sql dummy adatok bet�lt�s�re t�maszkodnak �s ezeket az adatokat pr�b�lj�k vizsg�lni.
Term�szetesen a tesztek sor�n gyakran elofordul, hogy �j adatok ker�lnek bet�lt�sre, de a tranzakci� lej�rt�val ezek t�rlodnek.
