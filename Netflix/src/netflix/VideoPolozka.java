package netflix;

public class VideoPolozka {
    private String nazev;
    private String zemePuvodu;
    private Druh druh;
    private String zanr;
    private Cas delka;

    public VideoPolozka(String nazev, String zemePuvodu, Druh druh, String zanr, Cas delka) {
        this.nazev = nazev;
        this.zemePuvodu = zemePuvodu;
        this.druh = druh;
        this.zanr = zanr;
        this.delka = delka;
    }

    public String getNazev() {
        return nazev;
    }

    public String getZemePuvodu() {
        return zemePuvodu;
    }

    public Druh getDruh() {
        return druh;
    }

    public String getZanr() {
        return zanr;
    }

    public Cas getDelka() {
        return delka;
    }

    @Override
    public String toString() {
        return "VideoPolozka{" + "nazev=" + nazev + ", zemePuvodu=" + zemePuvodu + ", druh=" + druh + ", zanr=" + zanr + ", delka=" + delka + '}';
    }
    
    public int podobnostS(VideoPolozka druhaPolozka) {
        int skore = 0;
        
        if (druhaPolozka.getDruh() == druh) {
            skore += 100;
        }
        if (druhaPolozka.getZanr() == zanr) {
            skore += 100;
        }
        if (druhaPolozka.getZemePuvodu() == zemePuvodu) {
            skore += 100;
        }
        if ((delka.prevedNaMinuty() - druhaPolozka.getDelka().prevedNaMinuty()) <= 20 
                || (druhaPolozka.getDelka().prevedNaMinuty() - delka.prevedNaMinuty()) <= 20) {
            skore += 100;
        }
        
        return skore;
    }
}
