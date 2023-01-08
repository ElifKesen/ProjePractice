package kasim_15_dateTime;

import java.util.Scanner;

public class Menu {
    static Registration registration = new Registration();
    static Listing listing=new Listing();

    static void giris() {
        System.out.println("Yapmak istediğiniz işlemi seçiniz\n" +
                "1. İsim girişi\n" +
                "2. Şanslı isimleri listeleme\n" +
                "3. Çıkış\n" +
                "Seçiminiz:");
        Scanner scan = new Scanner(System.in);
        while (true) { //dogru deger girinceye kadar surekli calisacak
            // burasi, eger dogru deger girmezsem bu ifin icine girme demek
            if (scan.hasNextInt()) { //eger numerik deger girmezse diye burayi kurguladik.
                int secim = scan.nextInt();
                switch (secim) {
                    case 1: {
                        registration.register(); //registration islemini yapinca, tekrar giris methoduna git.
                        giris();
                    }
                    case 2: {
                        listing.listele(registration.usersList);
                        giris();
                    }
                    case 3: {
                        System.out.println("Güle Güle");
                        System.exit(0);
                    }
                    default: {
                        System.out.println("Geçerli değer giriniz.");
                        giris();
                    }
                }
            } else {
                System.out.println("Geçerli değer giriniz");
                giris();
            }
        }

    }

}
