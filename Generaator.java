package shuffleMyWeb;

import java.util.Scanner;

public class Generaator { // Klass generaator


    void rakendus() { // Klassis on Meetod rakendus mille ülesanne on massiivist suvalisi veebilehti väljastada
        System.out.println("Siin kuvatakse sulle suvalises järjekorras veebilehti");
        System.out.println();

        for (int valikRakendus = 0; valikRakendus < 2  ; valikRakendus = valikRakendus ) {

            //siin meetodis arvutatakse suvaline number nullist neljani, mida kasutame viiekohalises massiivis
            Andmebaas A = new Andmebaas();

                String [] viisLehteUus = A.Nimekiri();

                double suvaline = Math.random() * 4;
                int uusNumber = (int) suvaline;

                // kutsub ühe elemendi massiivist viisLehte[]
                System.out.println();
                System.out.println(viisLehteUus[uusNumber]);

            /*
            public static void main(String[] args){

            String[] res = listPages();
            //now we want to print the element one: www.cnn.com

            System.out.println(res[0]);
}
             */



            // küsime valiku
            System.out.println("Valikud: 1-Paku järgmine 2-Mine Algusesse 3-Välju programmist");
            System.out.println();
            Scanner sc = new Scanner(System.in);
            valikRakendus = sc.nextInt();
            //valiku suunamine 3 stsenaariumiga
            switch (valikRakendus) {
                case 1:
                    valikRakendus=1;
                    break;
                case 2:
                    valikRakendus=2;
                    Algus();
                    break;
                case 3:
                    valikRakendus=3;
                    Valju();
                    break;
            }

        }
    }

    void Algus() {
        //1.	Valik, kas minna lehitsema, settingutesse või välja
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Oled alguses");
        System.out.println("palun kirjuta valik:");
        System.out.println("1-lehitsema; 2-settingutesse; 3-välja");
        int valitud = sc.nextInt();
        System.out.printf("Sinu valik on %d", valitud);
        System.out.println();
        switch (valitud){
            case 1:
                rakendus();
                break;
            case 2:
                Settingud();
                break;
            case 3:
                System.out.println("järgmisena väljun programmist");
                break;

        }

    }

    void Settingud() {
        /*  Valik kas kas lisada- või kustutada veebilehti, katkestada
        ja minna algusesse või salvestada ja minna algusesse */
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Oled settingutes");
        System.out.println("Palun kirjuta valik:");
        System.out.println("1-lisada veebilehti; 2-kustutada veebilehti; 3-salvestada ja minna algusesse");
        System.out.println("4-katkestada ja minna algusesse");
        int valitud = sc.nextInt();
        System.out.printf("Sinu valik on %d", valitud);
        System.out.println();
        switch (valitud) {
            case 1:
                System.out.println("järgmisena lisan veebilehti");
                break;
            case 2:
                System.out.println("järgmisena kustutan veebilehti");
                break;
            case 3:
                System.out.println("järgmisena salvestan ja lähen algusesse");
                break;
            case 4:
                Algus();
                break;

        }
    }

    void Valju(){
        System.out.println("väljutud");

    }


}
