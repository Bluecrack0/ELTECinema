# CinemaSystem Project
## Általános leírás

A szoftver egy mozi rendszer feladatait fogja ellátni. 
Feladati közé tartoznak a:

1. __Jegyfoglalás__ lehetoségének biztosítása
2. __Jegyvásárlás__ lehetoségének biztosítása
3. __Jelenleg vetített__ filmek megtekintése
4. __Összes__ vetített film megtekintése és szurés színészre, évszámra stb.
5. __Mozitermek__ és kapacitásuk listázása
6. __Vetítések__ megtekintése és ezen keresztül foglalás az adott vetítésre
7. __Bejelentkezés__, __regisztrálás__ és a foglalások listázása.

## Nem funkcionális követelmények

Elso és legfontosabb követelmény, hogy a program könnyen használható és átlátható legyen akár idosebbek számára is,
tekintve, hogy egy ehhez hasonló szoftvert _bármely_ korosztálynak tudnia kell használni.

Jegyfoglalás esetében a felhasználónak megadott idokeret áll rendelkezésére, hogy __lefoglalja__ a jegyet,
aztán újra elérheto kell legyen a többi foglaló számára is.

Helyfoglalásnál a felhasználó lássa, hogy mely székek __szabadok__ még az adott teremben (a __terem neve__ is látható legyen) és
legyen lehetosége kiválasztani, hogy melyik ülohelyeket szeretné lefoglalni.

__Egyedülálló__ széket ne lehessen foglalni!

Foglalás után szükséges megerosíteni a foglalást *e-mail*, vagy *telefonszám* segítségével.

A vetítések listázásánál egy kattintással elérheto legyen a foglalás és itt lehetoség legyen a jegy *megvásárlására* is.

A foglaláshoz szükséges legyen megadni a *nevet, e-mail címet és telefonszámot.*
A foglalás után legyen lehetoség törlésre is, ha esetleg a felhasználó meggondolná magát.

A foglalásra legyen lehetoség regisztráció/bejelentkezés nélkül is, ebben az esetben a törléshez a nevet/telefonszámot kelljen megadni.

Foglalást ne lehessen törölni __4 órával__ a vetítés kezdete elott!

Legyen lehetoség bejelentkezni közösségi oldalak segítségével is.

A vetítésekre lehessen szurni *dátum/terem* szerint.

Filmekre lehessen szurni *cím, év, mufaj, színész* szerint.

Regisztráció után szükséges legyen megerosíteni az e-mail címet.

Bejelentkezés után legyenek elérhetoek különbözo nyereményjátékok stb., amelyek hetente változhatnak.

## Funkcionális követelmények
### Funkciók muködése helyes felhasználás mellett

1. __Jegyfoglalás:__ 
A felhasználó megadja az adatait, kiválasztja az ülohelyet/helyeket a megadott idokereten belül. 
A rendszer e-mailt küld a felhasználónak a foglalásáról és megerosítés után a foglalás adatait elmenti az adatbázisban.

2. __Jegyvásárlás:__ 
A jegyfoglalásnál feltüntetett adatokon túl egy érvényes bankszámlaszám megadása is szükséges.
A rendszer emailben küld értesítést a vásárlásról, és megerosítés után történik meg ténylegesen a számla megterhelése, és az adatok adatbázisba mentése.

3. __Filmek/Vetítések keresése:__ A felhasználó megadja a keresési feltételeket(*színész, teremszám, évszám* stb.)
A rendszer kilistázza a keresés eredményeit.

4. __Regisztráció:__ A felhasználó a regisztrációhoz szükséges adatainak megadása után (*e-mail, név, telefonszám, jelszó, jelszó újból*) és az e-mailben kapott megerosítés elvégzése után bekerül az adatbázisba.

5. __Bejelentkezés:__ A felhasználó e-mailcím-jelszó kombinációval tud bejelentkezni. Sikeres bejelentkezés után a kezdooldalra érve lehetosége van a fenti opciók használatára (bejelentkezés nélkül szintén). Bejelentkezett felhasználó esetén a Jegyfoglalás/Jegyvásárlás alkalmával nem kell megadni újból az adatokat, azokat az adatbázis már tárolja.

6. __Foglalás/Vásárlás visszavonása:__ A felhasználó a foglalást/vásárlást követo __4 órán belül__ meggondolhatja magát.
Ebben az esetben a foglalás adatai törlodnek az adatbázisból, és vásárlás esetén megtörténik a vásárlás értékével megegyezo ellentétes irányú tranzakció.

### Funkciók muködése hibás felhasználás mellett

1. __Jegyfoglalás:__ 
A felhasználó megadja az adatait, kiválasztja az ülohelyet/helyeket.  
A rendszer hibaüzenettel jelzi, ha lejárt a foglalásra szánt idokeret, hibás az e-mail formátum, vagy egyedülálló székre került a választás.

2. __Jegyvásárlás:__ 
A jegyfoglalásnál feltüntetett adatokon túl bankszámlaszám megadása is szükséges.
A rendszer hibaüzenettel jelzi, a jegyfoglalásnál feltüntetett hibalehetoségek valamelyike fellép, valamint ha a bakszámlaszám érvénytelen formátumú.

3. __Filmek/Vetítések keresése:__ A felhasználó megadja a keresési feltételeket(*színész, évszám, teremszám* stb.)
Hibajelzés amennyiben a színész helyére szám kerül.

4. __Regisztráció:__ A felhasználó a regisztrációhoz szükséges adatait megadja(*e-mail, név, telefonszám, jelszó, jelszó újból*)
Hibajelzés, ha nem egyezik a két jelszó, vagy ha az emailcím formátuma nem megfelelo.

5. __Bejelentkezés:__ A felhasználó e-mailcím-jelszó kombinációval tud bejelentkezni.
Hibás felhasználónév vagy jelszó esetén hibaüzenettel értesíti a felhasználót.

6. __Foglalás/Vásárlás visszavonása:__ A felhasználó a foglalást/vásárlást követo __4 órán túl__ meggondolja magát.
Ebben az esetben a rendszer hibaüzenettel jelzi, hogy sajnos már nincs lehetoség a foglalás/vásárlás lemondására.

## Tesztelés 

A projekt során minden dao/service/controller és model osztály is tesztelésre kerül.
Az átfogó teszt osztály az ApplicationTests és külön packagekben találhatóak meg a tesztek.

### DAO
dao package: DaoTest
1. actorDaoTest
2. newsDaoTest
3. movieDaoTest
4. screeningDaoTest
5. userDaoTest
6. actorDaoTest
7. reservationDaoTest

Ezek a tesztek az adatbáziskezelést próbálják tesztelni.
Legfobb céljuk, hogy az alapveto (insert, update etc.) muveletek hiba (Exception, vagy barmilyen adatmodositasi hiba) nélkül menjenek vegbe.

A fobb tesztek a null test, result set mérete, exception test (assert false).

Természetesen a kapcsolatok (OneToMany, ManyToOne etc.) is tesztelésre kerülnek. Legtöbbször itt ConstraintViolationException-t vár el a teszt, mikor megpróbáljuk törölni a kapcsolat egyik elemét például.

Bár a DAO-k megvalósítása egy közös GenericDaoImpl osztállyal történik, ettol függetlenül mindegyik modell dao-ja tesztelésre került részletesen.

### Service
service package: ServiceTest
1. actorServiceTest
2. newsServiceTest
3. movieServiceTest
4. screeningServiceTest
5. userServiceTest
6. actorServiceTest
7. reservationServiceTest

A service tesztek az üzleti logikát tesztelik.

Úgy mint a DAO-k esetében itt is egy közös ososztallyal történt a servicek megvalósítása. (AbstractService)
Ettol függetlenül természetesen minden modellhez tartozó service osztály külön tesztelésre került.

### Controller

controller package: ControllerTest
1. actorControllerTest
2. movieControllerTest
3. screeningControllerTest
4. reservationControllerTest
5. userControllerTest


A kontroller tesztek elkészítése során a legfontosabb, hogy a megfelelo végpontok lekérdezésekor 200-as responset kapjunk.
Fontos, hogy semmiképp se 404, vagy egyéb hibát az alatta lévo layerek miatt.
A tesztek hibátlanul lefutottak és legtöbb esetben az egyedi funkciók is tesztelésre kerültek.

A NewsController tesztelésére nem került sor, mivel egy az egyben a GenericService ososztalyt használja, 
amely tesztelésre került az összes többi teszteset során.

### Model
A modellek tesztelésére nem készült külön tesztosztály, mivel a modellek összes funkciója tesztelésre kerül a fenti tesztek során
egyfajta integrációs teszt formályában.

### Összegzés
A back-end tesztelése a Unit és integrációs tesztelések kombinációjából született meg.
Minden tesztosztály tranzakcionális, vagyis visszaállítja az adatbázist konzisztens állapotba a teszt végeztével.
Az integrációs teszt legfontosabb részét ezzel lefedtük.
A tesztek nagyrészt az import.sql dummy adatok betöltésére támaszkodnak és ezeket az adatokat próbálják vizsgálni.
Természetesen a tesztek során gyakran elofordul, hogy új adatok kerülnek betöltésre, de a tranzakció lejártával ezek törlodnek.
