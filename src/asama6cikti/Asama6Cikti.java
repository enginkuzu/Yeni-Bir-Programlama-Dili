package asama6cikti;

import siniflar.KomutCiktisi;
import yardimci.Fonksiyonlar;

public class Asama6Cikti {

	public static String işle(String dosyaAdı) {

		dosyaAdı = dosyaAdı.substring(0, dosyaAdı.length() - 4);

		KomutCiktisi çıktı1 = Fonksiyonlar.komutÇalıştır(false,
				new String[] { "as", dosyaAdı + ".kod.5.s", "-o", dosyaAdı + ".o" });
		if (!çıktı1.hataÇıktısı.isEmpty()) {
			System.out.println(çıktı1.hataÇıktısı);
			return çıktı1.hataÇıktısı;
		} else if (!çıktı1.normalÇıktı.isEmpty()) {
			System.out.println(çıktı1.normalÇıktı);
			return çıktı1.normalÇıktı;
		}

		KomutCiktisi çıktı2 = Fonksiyonlar.komutÇalıştır(false,
				new String[] { "ld", "-nostartfiles", "-s", dosyaAdı + ".o", "-o", dosyaAdı + ".bin" });
		if (!çıktı2.hataÇıktısı.isEmpty()) {
			System.out.println(çıktı2.hataÇıktısı);
			return çıktı2.hataÇıktısı;
		} else if (!çıktı2.normalÇıktı.isEmpty()) {
			System.out.println(çıktı2.normalÇıktı);
			return çıktı2.normalÇıktı;
		}

		return null;
	}

}
