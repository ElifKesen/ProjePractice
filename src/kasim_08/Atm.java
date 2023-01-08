package kasim_08;

import java.util.Scanner;

public class Atm {
    /*ATM
    Kullanicidan giriş için kart numarasi ve şifresini isteyin, eger herhangi birini yanlis girerse tekrar isteyin.
    Kart numarasi aralarda boşluk ile girerse de eger doğruysa kabul edin.
    Kart numarasi ve sifre dogrulanirsa kullanicinin yapabileceği işlemleri ekrana yazdirin,

    Menu listesinde Bakiye sorgula, para yatirma, para çekme, para gönderme, sifre değiştirme ve cikis islemleri olacaktır.

    Para çekme ve para gonderme işleminde mevcut bakiyeden buyuk para çekilemez,
    Para gönderme işleminde istenen iban TR ile baslamali ve toplam 26 karakterli olmali, eger değilse menü ekranina
    geri donsun.
    Sifre değiştirme işleminde mevcut şifreyi teyit ettikten sonra, sifre değişiklik işlemini yapmali,

     */
    final static String kartno = "1234567890123456";
    static Scanner scan = new Scanner(System.in);

    static String sifre = "1234";
    static double bakiye= 20000; //diyelim 10000 ekledik, bakiye 30000 gelir diger asamalarda
                                 // ama programi kapatinca, tekrar actigimizda 20000 gelir
                                 // her run ediste 20000 olarak sifirlanir


    public static void main(String[] args) {
        giris(); //giris methodu ile baslattik
    }

    private static void giris() {
        System.out.println("Kart numarasi giriniz : ");
        String kKartno = scan.nextLine();
        System.out.println("Sifre giriniz : ");
        String kSifre = scan.next();
        kKartno = kKartno.replaceAll("\\s", ""); //bosluklari hiclikle degistirdik
        if (kSifre.equals(sifre) && kKartno.equals(kartno)) { //static variabl olusturduk bunlari mainde
            menu();

        }else {

        }
    }

    private static void menu() { // !!!!!!!ODEV == menude sadece sayisal deger almayi sagla
        System.out.println("*******JAVABANKA HOSGELDINIZ*******\n" +
                "1. BAKIYE SORGULAMA\n+" +
                "2. PARA YATIRMA\n" +
                "3. PARA CEKME\n" +
                "4. PARA GÖNDERME\n" +
                "5. SIFRE DEGISTIRME\n" +
                "6. CIKIS");

        int secim = scan.nextInt();
        switch (secim) { //swich in icinde bir key olusturmamiz gerekiyordu, secim keyi olusturduk
            case 1: {
                System.out.println("S");
                double miktar= scan.nextDouble();
                bakiyeSorgula();
            }
            case 2: {
                System.out.println("YATIRILACAK MIKTARI GIRINIZ:");
                double miktar = scan.nextDouble();
                paraYatirma(miktar);
            }


            case 3: {
                System.out.println("CEKILECEK MIKTARI GIRINIZ");
                double miktar= scan.nextDouble();
                paraCekme(miktar);
            }
            case 4: {
                System.out.println("IBAN GIRINIZ. ");
                String iban= scan.nextLine();
                scan.nextLine();
                System.out.println("GÖNDERILECEK MIKTARI GIRINIZ");
               
                double miktar= scan.nextDouble();
                paraGonderme(ibanKontrol(iban),miktar);
            }
            case 5: {
                sifreDegistir();
              
            }
            case 6: {
                System.out.println("*******HOSCAKALIN********");
                System.exit(0);
                
            }

        }


    }

    private static void sifreDegistir() {
        System.out.println("SIFRE GIRINIZ");
        String kSifre= scan.next();
        if (kSifre.equals(sifre)){
            System.out.println("YENI SIFRE GIRINIZ");
            sifre=scan.next();
            giris();
        }else {
            System.out.println("DOGRU SIFRE GIRINIZ");

        }
    }

    private static void paraGonderme(String ibanKontrol, double miktar) {
        if (miktar<=bakiye){
            bakiye-=miktar;
            bakiyeSorgula();
            menu();
        }
    }

    private static String ibanKontrol(String iban) {
        iban = iban.replaceAll("\\s", "");
        if (iban.startsWith("TR") && iban.length() == 26) {
        } else {
            System.out.println("GECERLI IBAN GIRINIZ: ");
            ibanKontrol(scan.nextLine());
        }
        return iban;
    }
        

    private static void paraCekme(double miktar) {
        if (miktar<=bakiye){
            bakiye-=miktar;
            bakiyeSorgula();
            menu();
        }else {
            System.out.println("GECERLI MIKTAR GIRINIZ");
            paraCekme(scan.nextDouble());
        }
    }


    private static void paraYatirma(double miktar) {
        bakiye+=miktar;
        paraYatirma(miktar);
    }

    

    private static void bakiyeSorgula() {
        System.out.println("BAKIYENIZ"+bakiye);
        menu(); // bakiyeyi göruntuledikten sonra menu methodunu tekrar cagirdik

    }
}
