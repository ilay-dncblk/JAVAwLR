package lrmaastahmini;

public class LineerRegresyon extends Data {
	public void lineerRegresyon (double[]maas, double[] ay) {
		
		double maasortalama = 0;
        double ayortalama = 0;
        for (int i = 0; i < maas.length; i++) {
            maasortalama += maas[i];
            ayortalama += ay[i];
        }
        maasortalama /= maas.length;
        ayortalama /= ay.length;

        // eğimi ve sabiti lineer fonk denklemine göre hesaplıyoruz
        double eğim = 0;
        double sabit = 0;
        for (int i = 0; i < maas.length; i++) {
            eğim += (maas[i] - maasortalama) * (ay[i] - ayortalama);
            sabit += (maas[i] - maasortalama) * (maas[i] - maasortalama);
        }
        // y=ax+b a eğim b sabit
        eğim /= sabit;
        //b=y-ax
        sabit = ayortalama - eğim * maasortalama;

        System.out.println("Eğim = " + eğim);
        System.out.println("Sabit = " + sabit);


        Grafik yenigrafik = new Grafik();
        islemMetni();
        yenigrafik.grafigiçiz(maas,ay,eğim,sabit);

        Tahmin yenitahmin = new Tahmin();
        islemMetni();
        yenitahmin.tahminet(eğim, sabit);
        islemMetni();
        yenitahmin.tahminet(eğim, sabit, maasortalama);
        islemMetni();
        yenitahmin.tahminet(eğim, sabit, maas);

        //içiçe sınıf kurucusu
        Tahmin.TahminDogrulugu tahminikontrolet = yenitahmin.new TahminDogrulugu();
        islemMetni();
        tahminikontrolet.dogruluk(maas, ay, eğim, sabit);

    }
    public LineerRegresyon() {
        System.out.println("Lineer regresyon hesabı yapılıyor.");
    }
    
    private void islemMetni()
    {
    	System.out.print("Lineer Regresyen Verileri İşlem Yapmaya Gönderiliyor...\n");
    }


	}

