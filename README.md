# shuffleMyWeb

ANdres Kostiv ja Kaia Ernits (kuni Nov 2015)

1 Projekti kokkuvõtte ja koodi komentaar

1. Projekti skoop: Luua personaalne rakendus, mis pakub suvalises järjekorras veebilehe URLe. Rakendusse saab lisada ning kustutada veebilehti.
2. 


2.Taustamaterjal

2.1 Väga varajane UI prototüüp, vajuta slidhow play nuppu: https://docs.google.com/presentation/d/1s2zZeWre-DWCFE9bCOsMEi8besGLz21FatPfxao716Q/edit?usp=sharing<br>

2.2 UI prototüübist UML PROTOTÜÜBI FLOW :https://docs.google.com/presentation/d/1Wt5yPYKkdu7Ni_VkmDYtRmFmBmq3_DCf96rx_61Yd9c/edit?usp=sharing<br>
<br>



ALGORITM:<br>
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
2.1.1 Lisad tekstikasti sisse brauseri aadress teksti ja vajuta “Lisa veebileht nuppu”. Lisaks kontrollib kas sa ikka sisestasid “www” sisse. Tekstikastist lisab ise “http://” ette andmebaasi salvestamist.<br>
2.1.1.1 kui 2.1.1 on ok siis lisab eel-andmebaasi aadressi ja kuvab seda nimekirjas ning kuvab teate „lisamine õnnestus“<br>
2.1.1.2 kui 2.1.1 on vigane siis kirjutab teate, et „vale aadress ☹“.<br>
2.1.1.3 Kui on üle saja lehe siis ei salvesta vaid annab teate, et „rohkem ei mahu lehti (max100)“. Hoiab text boxis aadressi alles niikaua kui ruumi teed.<br>
2.2 Kustutamine<br>
2.2.1 Kui nimekirjas on üks või rohkem lehti siis vajutad lehe juures „kustuta nuppu“ ja leht kaob nimekirjast.<br>
2.3 Salvesta ja algusesse<br>
2.3.1 Teeb olemasolevas vaates veebilehtede nimekirjast koopia andmebaasi<br>
2.3.2 Liigub algusesse vaatesse 1.<br>
2.4 Tühista ja algusesse. Ei salvesta andmebaasi muudatusi ja liigub vaatesse 1.<br>
<br>
CHECKLIST:<br>
Kood <br>
Kood on gitis, õppejõud saab ligi.<br>
Projekti kirjeldus failis README.md (.md on [markdown](http://eherrera.net/markdowntutorial/))<br>
Nimi<br>
Projekti kirjeldus<br>
Kasutusjuhend<br>
Muud märkmed<br>
Võõras kood on allikale viidatud<br>
<br>
Lihtne lugeda<br>
treppimine on paigas<br>
muutuja nimetused kirjeldavad protsessi olemust<br>
meetodide nimetused kirjeldavad selgelt meetodi toimingut<br>
selguse tagamiseks on koodi kommenteeritud<br>
Loogiline ja taaskasutatav ülesehitus<br>
kasutab meetode kus vaja<br>
kasutab klasse kus vaja<br>
kasutab objekt-orienteeritust<br>
kasutatakse otstarbekalt tsükleid<br>
kasutatakse andmestruktuure ja käideldakse neid otstarbekalt<br>
Kood on kompaktne (lisapunktid, kui on näha erilist läbimõeldust)<br>
keerulised tsüklid<br>
rekursioon????<br>
eriti hea klasside/meetodide taaskasutatavus<br>
<br>
Tulemus<br>
funktsionaalsus<br>
programm täidab oma eesmärki, ehk suudab ettenähtud protsessi lõpuni viia<br>
kasutatavus<br>
GUI olemasolu (v.a. juhul kui sellest pole üldse kasu)<br>
bugid ei takista protsessi<br>
kasutajaliides on läbi mõeldud<br>
kasutaja ei pea üleliigseid klikke tegema<br>
kasutajal on lihtne mõista, kuidas programmi kasutada.<br>
Programm on vastupidav<br>
Tavakasutajale<br>
Dumbuserile<br>
Algaja-häkkerile<br>
<br>
Lisapunkte<br>
Tudeng on läinud aine raamistikust edasi, ehk oskab rohkem kui on aines õpetatud.<br>
Tudeng on reaalselt gitti kasutanud (committide periood on loogiline)!!!!!!!!!!!<br>
Kasutatud on lisa raamistikke, näiteks SQL andmebaas.<br>
Kui tudeng tööga päris valmis ei saanud, kas ta vähemalt teab mida järgmiseks peaks tegema?<br>
<br>
Plagiaadikontroll<br>
(Rakendada ainult kui väga vaja, eksam on lõplik filter)<br>
Oskab selgitada suvalist kohta koodis.<br>
Oskab programmi käiku muuta, kui õppejõud seda palub.<br>
Oskab käigu pealt tsükleid valmistada.<br>
