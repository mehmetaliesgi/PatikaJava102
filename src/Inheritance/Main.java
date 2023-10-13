package Inheritance;

public class Main {
    public static void main(String[] args) {
        Calisan calisan1 = new Calisan("Ali Cabbar", "05322211341", "info@alicabbar.net");
        Akademisyen akademisyen1 = new Akademisyen("Halis Aga", "5411244223", "info@halis.net", "CENG", "Profesor");
        //akademisyen1.derseGir();
        Memur memur1 = new Memur("Mahmut Mamut", "5421134214", "info@mahmutmamut.net", "Bilgi İşlem", "09:00 - 18:00");
        //memur1.calis();
        OgretimGorevlisi ogretimGorevlisi = new OgretimGorevlisi("Ahmet Hoca", "5123144213", "info@ahmet.net", "CENG", "YarDoc", "12");
        //ogretimGorevlisi.giris();
        //ogretimGorevlisi.derseGir();
        Asistan asistan = new Asistan("Zeki Çalışkan", "5421242351", "info@zeki.net", "CENG", "Asistan", "09:00 - 13:00");
        //asistan.quizYap();
        //asistan.giris();
        GuvenlikGorevlisi guvenlikGorevlisi = new GuvenlikGorevlisi("Tekin Sekin", "5421235161", "info@tekin.com", "CENG", "09:00 - 18:00", "Mesai Belgesi");
        //guvenlikGorevlisi.giris();
        //guvenlikGorevlisi.nobet();
        //guvenlikGorevlisi.calis();
        LabAsistani labAsistani = new LabAsistani("Limon Limoni", "5123224267", "info@limon.net", "CENG", "Lab Asistani", "09:00 - 13:00");
        //labAsistani.giris();
        //labAsistani.derseGir();
        //labAsistani.yemekhane();
        //labAsistani.cikis();
    }
}
