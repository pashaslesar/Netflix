package netflix;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Obsah {
    private ArrayList<VideoPolozka> videoPolozka;

    public Obsah() {
        this.videoPolozka = new ArrayList<>();
    }
    
    public void pridejPolozku(VideoPolozka videoPolozky) {
        videoPolozka.add(videoPolozky);
    }
    
    public void vypisPolozky() {
        for (VideoPolozka vp : videoPolozka) {
            System.out.println(vp);
        }
        System.out.println();
    }
    
    public void vypisPolozkyPodleDruhu(Druh vybranyDruh) {
        for (VideoPolozka vp : videoPolozka) {
            if (vp.getDruh() == vybranyDruh) {
                System.out.println(vp);
            }
        }
        System.out.println();
    }
    
    public void vypisPolozkyPodleDruhuPlusZanru(Druh vybranyDruh, String vybranyZanr) {
        for (VideoPolozka vp : videoPolozka) {
            if (vp.getDruh() == vybranyDruh && vp.getZanr() == vybranyZanr) {
                System.out.println(vp);
            }
        }
        System.out.println();
    }
    
    public void najdiNejpodobnejsiPolozku(VideoPolozka polozka) {
        polozka = videoPolozka.get(0);
        for (VideoPolozka vp : videoPolozka) {
            if (vp.podobnostS(polozka) > polozka.podobnostS(polozka)) {
                polozka = vp;
            }
        }
        System.out.println("Nejpodobnejsi polozkou je " + polozka);
        System.out.println();
    }
    
    public void spocitejPrumernouDelku(Druh vybranyDruh) {
        int celkovaDelka = 0;
        int pocet = 0;
        for (VideoPolozka vp : videoPolozka) {
            if (vp.getDruh() == vybranyDruh) {
                celkovaDelka += vp.getDelka().prevedNaMinuty(); // 1056 minut
                pocet++;
            }
        }
        if (pocet == 0) {
            System.out.println("Chyba!");
        } else {
            int prDelka = celkovaDelka / pocet; // 312 minut
            Cas prumernyCas = new Cas((prDelka / 60), (prDelka % 60)); // 4.111 hodin
            System.out.println("Prumerna delka vsech " + vybranyDruh + " se rovna " + prumernyCas + " hodin.");
        }
        System.out.println();
    }
    
    public void ulozDoSouboru(String soubor) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(soubor))) {
            String line;
            for (VideoPolozka vp : videoPolozka) {
                writer.write(vp.toString());
                writer.newLine();
            }
            System.out.println("Seznam polozek byl uspesne ulozen do souboru.");
        } catch (IOException e) {
            // e.printStackTrace();
            System.err.println("Seznam polozek nebyl pridan do souboru." + e.getMessage());
        }
    }
}
