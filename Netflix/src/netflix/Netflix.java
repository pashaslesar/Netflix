package netflix;

public class Netflix {

    public static void main(String[] args) {
        Obsah swag = new Obsah();
        
        Cas x = new Cas(2, 44);
        Cas y = new Cas(3, 12);
        Cas z = new Cas(2, 56);
        Cas xx = new Cas(6, 41);
        Cas yy = new Cas(9, 53);
        Cas zz = new Cas(12, 12);
        
        VideoPolozka a = new VideoPolozka("SlovoPisuna", "Russia", Druh.SERIAL, "komedie", xx);
        VideoPolozka b = new VideoPolozka("StrangerThings", "USA", Druh.SERIAL, "triller", yy);
        VideoPolozka c = new VideoPolozka("Kuchnya", "Russia", Druh.SERIAL, "komedie", zz);
        VideoPolozka d = new VideoPolozka("MajorGrom", "Russia", Druh.FILM, "drama", x);
        VideoPolozka e = new VideoPolozka("After", "VelkaBritanie", Druh.FILM, "horor", y);
        VideoPolozka f = new VideoPolozka("RedWhiteAndRoyalBlue", "USA", Druh.FILM, "komedie", z);
        
        swag.pridejPolozku(a);
        swag.pridejPolozku(b);
        swag.pridejPolozku(c);
        swag.pridejPolozku(d);
        swag.pridejPolozku(e);
        swag.pridejPolozku(f);
        swag.vypisPolozky();
        swag.vypisPolozkyPodleDruhu(Druh.SERIAL);
        swag.vypisPolozkyPodleDruhuPlusZanru(Druh.SERIAL, "komedie");
        swag.spocitejPrumernouDelku(Druh.FILM);
        swag.najdiNejpodobnejsiPolozku(c);
        swag.ulozDoSouboru("netflix.csv");
    }
    
}
