# CinemaSystem Project
## Általános leírás

A szoftver egy mozi rendszer feladatait fogja ellátni. 
Feladati közé tartoznak a:

1. __Jegyfoglalás__ lehetőségének biztosítása
2. __Jegyvásárlás__ lehetőségének biztosítása
3. __Jelenleg vetített__ filmek megtekintése
4. __Összes__ vetített film megtekintése és szűrés színészre, évszámra stb.
5. __Mozitermek__ és kapacitásuk listázása
6. __Vetítések__ megtekintése és ezen keresztül foglalás az adott vetítésre
7. __Bejelentkezés__, __regisztrálás__ és a foglalások listázása.

## Nem funkcionális követelmények

Első és legfontosabb követelmény, hogy a program könnyen használható és átlátható legyen akár idősebbek számára is,
tekintve, hogy egy ehhez hasonló szoftvert _bármely_ korosztálynak tudnia kell használni.

Jegyfoglalás esetében a felhasználónak megadott időkeret áll rendelkezésére, hogy __lefoglalja__ a jegyet,
aztán újra elérhető kell legyen a többi foglaló számára is.

Helyfoglalásnál a felhasználó lássa, hogy mely székek __szabadok__ még az adott teremben (a __terem neve__ is látható legyen) és
legyen lehetősége kiválasztani, hogy melyik ülőhelyeket szeretné lefoglalni.

__Egyedülálló__ széket ne lehessen foglalni!

Foglalás után szükséges megerősíteni a foglalást *e-mail*, vagy *telefonszám* segítségével.

A vetítések listázásánál egy kattintással elérhető legyen a foglalás és itt lehetőség legyen a jegy *megvásárlására* is.

A foglaláshoz szükséges legyen megadni a *nevet, e-mail címet és telefonszámot.*
A foglalás után legyen lehetőség törlésre is, ha esetleg a felhasználó meggondolná magát.

A foglalásra legyen lehetőség regisztráció/bejelentkezés nélkül is, ebben az esetben a törléshez a nevet/telefonszámot kelljen megadni.

Foglalást ne lehessen törölni __4 órával__ a vetítés kezdete előtt!

Legyen lehetőség bejelentkezni közösségi oldalak segítségével is.

A vetítésekre lehessen szűrni *dátum/terem* szerint.

Filmekre lehessen szűrni *cím, év, műfaj, színész* szerint.

Regisztráció után szükséges legyen megerősíteni az e-mail címet.

Bejelentkezés után legyenek elérhetőek különböző nyereményjátékok stb., amelyek hetente változhatnak.

## Funkcionális követelmények
### Funciók működése helyes felhasználás mellett

1. __Jegyfoglalás:__ 
A felhasználó megadja az adatait, kiválasztja az ülőhelyet/helyeket a megadott időkereten belül. 
A rendszer e-mailt küld a felhasználónak a foglalásáról és megerősítés után a foglalás adatait elmenti az adatbázisban.

2. __Jegyvásárlás:__ 
A jegyfoglalásnál feltüntetett adatokon túl egy érvényes bankszámlaszám megadása is szükséges.
A rendszer emailben küld értesítést a vásárlásról, és megerősítés után történik meg ténylegesen a számla megterhelése, és az adatok adatbázisba mentése.

3. __Filmek/Vetítések keresése:__ A felhasználó megadja a keresési feltételeket(*színész, teremszám, évszám* stb.)
A rendszer kilistázza a keresés eredményeit.

4. __Regisztráció:__ A felhasználó a regisztrációhoz szükséges adatainak megadása után (*e-mail, név, telefonszám, jelszó, jelszó újból*) és az e-mailben kapott megerősítés elvégzése után bekerül az adatbázisba.

5. __Bejelentkezés:__ A felhasználó e-mailcím-jelszó kombinációval tud bejelentkezni. Sikeres bejelentkezés után a kezdőoldalra érve lehetősége van a fenti opciók használatára (bejelentkezés nélkül szintén). Bejelentkezett felhasználó esetén a Jegyfoglalás/Jegyvásárlás alkalmával nem kell megadni újból az adatokat, azokat az adatbázis már tárolja.

6. __Foglalás/Vásárlás visszavonása:__ A felhasználó a foglalást/vásárlást követő __4 órán belül__ meggondolhatja magát.
Ebben az esetben a foglalás adatai törlődnek az adatbázisból, és vásárlás esetén megtörténik a vásárlás értékével megegyező ellentétes irányú tranzakció.

### Funciók működése hibás felhasználás mellett

1. __Jegyfoglalás:__ 
A felhasználó megadja az adatait, kiválasztja az ülőhelyet/helyeket.  
A rendszer hibaüzenettel jelzi, ha lejárt a foglalásra szánt időkeret, hibás az e-mail formátum, vagy egyedülálló székre került a választás.

2. __Jegyvásárlás:__ 
A jegyfoglalásnál feltüntetett adatokon túl bankszámlaszám megadása is szükséges.
A rendszer hibaüzenettel jelzi, a jegyfoglalásnál feltüntetett hibalehetőségek valamelyike fellép, valamint ha a bakszámlaszám érvénytelen formátumú.

3. __Filmek/Vetítések keresése:__ A felhasználó megadja a keresési feltételeket(*színész, évszám, teremszám* stb.)
Hibajelzés amennyiben a színész helyére szám kerül.

4. __Regisztráció:__ A felhasználó a regisztrációhoz szükséges adatait megadja(*e-mail, név, telefonszám, jelszó, jelszó újból*)
Hibajelzés, ha nem egyezik a két jelszó, vagy ha az emailcím formátuma nem megfelelő.

5. __Bejelentkezés:__ A felhasználó e-mailcím-jelszó kombinációval tud bejelentkezni.
Hibás felhasználónév vagy jelszó esetén hibaüzenettel értesíti a felhasználót.

6. __Foglalás/Vásárlás visszavonása:__ A felhasználó a foglalást/vásárlást követő __4 órán túl__ meggondolja magát.
Ebben az esetben a rendszer hibaüzenettel jelzi, hogy sajnos már nincs lehetőség a foglalás/vásárlás lemondására.
