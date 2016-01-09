# shuffleMyWeb

ANdres Kostiv ja Kaia Ernits (kuni Nov 2015)<br>
<br>
1 Projekti kokkuvõtte<br>
<br>
1.1 Projekti skoop: Luua personaalne rakendus, mis pakub suvalises järjekorras veebilehe URLe. Rakendusse saab lisada ning kustutada lemmik veebilehti.<br>
<br>
1.2 Failid ja selgitsued:<br>
1.2.1 Github repo: https://github.com/andreskostiv/shuffleMyWeb?files=1<br>
<br>
1.2.2 Projekti käigus programmeeriti kaks projekti progemmeerimistööd. Üks progamm töötab käsurealt ja teine töötab JavaFX Graafilise kasutajaliidese peal. Mõlemad on sama skoobiga ja suhtlevad Shuffle2.db andmebaasiga.<br>
Failid:<br>
<br>
1.2.1 Andmebaasiga seonduv (sama andmebaasi kasutatakse paralleelselt mõlemas programmis) <br>
https://github.com/andreskostiv/shuffleMyWeb/blob/master/DbCreateTable.java -  Ühekordne main meetod andmebaasi loomiseks <br>
https://github.com/andreskostiv/shuffleMyWeb/blob/master/shuffle2copy.db%20 - SQLite andmebaasi sisunäide (ps. erilise kataloogisüsteemi tõttu Apple OSX'is programm käivitub ainult tudengi arvutis)<br>
<br>
1.2.2 Käsurealt kasutajaliidesega programmifalid (programmeeritud Nov 2015):<br>
https://github.com/andreskostiv/shuffleMyWeb/blob/master/Kaivitaja.java	-  main meetod objekt-orienteeritusega<br>
https://github.com/andreskostiv/shuffleMyWeb/blob/master/Generaator.java - programmi loogikakood ning Shuffle2.db andmebaasiga suhtlemise kood.<br>
<br>
1.2.3 Graafilise kasutajaliise programmifalid (programmeeritud Dets 2015) - Jan 2016:<br>
https://github.com/andreskostiv/shuffleMyWeb/blob/master/Kasutajaliides.java - Main meetod ning programmi loogika kood ja Shuffle2.db andmebaasiga suhtlemise ning graafilise kasutajaliidese kood.<br>
<br>
1.2.4 Olulisi välislinke mille koodi osaliselt lokaliseeriti:<br>
Andmebaasi loomise, ridade lisamise ning kustutamise tutorialid:<br>
http://www.tutorialspoint.com/sqlite/sqlite_java.html<br>
<br>
Andmebaasi kuvmine tabelina Javafx'is:<br>
http://blog.ngopal.com.np/2011/10/19/dyanmic-tableview-data-from-database/comment-page-2/<br>
<br>
<br>
2.Taustamaterjal (Koostajad Andres Kostiv ja Kaia Ernits)

2.1 Väga varajane Graafilise kasutajaliidese  prototüüp Oktoobris, vajuta slidhow "play" nuppu: https://docs.google.com/presentation/d/1s2zZeWre-DWCFE9bCOsMEi8besGLz21FatPfxao716Q/edit?usp=sharing<br>

2.2 UI prototüübist UML Prototüübi flow: :https://docs.google.com/presentation/d/1Wt5yPYKkdu7Ni_VkmDYtRmFmBmq3_DCf96rx_61Yd9c/edit?usp=sharing<br>
<br>

2.2 Esimene versioon Algoritmist UML põhjal:<br>
OBJEKT 1<br>
        1.	Valik, kas minna lehitsema, settingutesse või välja<br>
        1.1 Kui lehitsema “GO”, siis liigud edasi lehitsejasse<br>
        1.1.1 Lehitseja pakub lehekülge,<br>
        1.1.1 Valik, kas browserisse, uus otsing, algusesse või välja<br>
        1.1.1.1 Läheb browserisse peale hüperlingile vajutamist<br>
        1.1.1.2 Nupp “paku veel” pakub uue lehe andmebaasist<br>
        1.1.1.2.1 Läheb andmebaasi ja randomiga võtab uue lingi andmebaasist ja sisestab selle väljale 1.1.1<br>
        1.1.1.3 Nupp “algusesse” saadab tagasi avalehele (1.)<br>
        1.1.1.4 Nupp “välja” viskab ette teate “väljutud” ja lõpetab programmi töötamise<br>
        1.2 Nupp “välja” viskab ette teate “väljutud” ja lõpetab programmi töötamise<br>
        1.3 Nupp “seaded” viib OJEKT 2 juurde, väljund tuleb valikusse 1.<br>
        <br>
OBJEKT 2<br>
        2 Valik kas kas lisada- või kustutada veebilehti, katkestada ja minna algusesse või salvestada ja minna algusesse<br>
        2.1 Lisamine<br>
        uus nupp<br>
        uus väli<br>
        2.1.1 Lisad tekstikasti sisse brauseri aadress teksti ja vajuta “Lisa veebileht nuppu”. Lisaks kontrollib kas sa ikka sisestasid         “www” sisse. Tekstikastist lisab ise “http://” ette andmebaasi salvestamist.<br>
        2.1.1.1 kui 2.1.1 on ok siis lisab eel-andmebaasi aadressi ja kuvab seda nimekirjas ning kuvab teate „lisamine õnnestus“<br>
        2.1.1.2 kui 2.1.1 on vigane siis kirjutab teate, et „vale aadress ☹“.<br>
        2.1.1.3 Kui on üle saja lehe siis ei salvesta vaid annab teate, et „rohkem ei mahu lehti (max100)“. Hoiab text boxis aadressi            alles niikaua kui ruumi teed.<br>
        2.2 Kustutamine<br>
        2.2.1 Kui nimekirjas on üks või rohkem lehti siis vajutad lehe juures „kustuta nuppu“ ja leht kaob nimekirjast.<br>
        2.3 Salvesta ja algusesse<br>
        2.3.1 Teeb olemasolevas vaates veebilehtede nimekirjast koopia andmebaasi<br>
        2.3.2 Liigub algusesse vaatesse 1.<br>
        2.4 Tühista ja algusesse. Ei salvesta andmebaasi muudatusi ja liigub vaatesse 1.<br>
        <br>
        ReadME lõpp<br>
