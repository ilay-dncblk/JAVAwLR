package lrmaastahmini;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Data{
	public double[][] dosyaoku(String yol) throws IOException {
		File dosya= new File(yol);
		FileInputStream aktifdosya = new FileInputStream(dosya);
		
		List<String> IDList = new ArrayList<String>();
		List<String> adList = new ArrayList<String>();
		List<String> mevkiList = new ArrayList<String>();
		List<String> calismaSuresiList = new ArrayList<String>();
		List<String> maasList = new ArrayList<String>();

		int sütun;
		String satır =""; 
		//Satırın içine boş veri tanımladık java sisteminden kaynaklı string veri boş kalamaz. 
		while((sütun = aktifdosya.read()) != -1) {
			//dosya okunabiliyorken çalıştır anlamında -1 okunamıyor 0 ve ustu okunur demek
			if (sütun == 10) {
				//Id ye gore sıralama yapmak için kontrol yap
				if(satır.charAt(0) == 'I') {
					//Id ye gore sıralam ayopmak için I ile başlayan sutunu bulduysan işlem yap
					satır ="";
					//yapılan her işem burda yapılıyor bu yuzden içerisindeki veriyi sürekli siliyoruz 
					continue;
				}
				String[] data = satır.split(";");
				IDList.add(data[0]);
				adList.add(data[1]);
				mevkiList.add(data[2]);
				calismaSuresiList.add(data[3]);
				maasList.add(data[4]);
				satır="";
			}else {
					satır += (char)sütun; // buluncaya kadar her satırı kontrol et 
				}
				
			}
		
		String[] IDArray = new String[IDList.size()];
        String[] adArray = new String[adList.size()];
        String[] mevkiArray = new String[mevkiList.size()];
        String[] calismaSuresiArray = new String[calismaSuresiList.size()];
        String[] maasArray = new String[maasList.size()];
        //uzunluga gore dizi olusturuldu
        
        IDArray = IDList.toArray(IDArray);
        adArray = adList.toArray(adArray);
        mevkiArray = mevkiList.toArray(mevkiArray);
        calismaSuresiArray = calismaSuresiList.toArray(calismaSuresiArray);
        maasArray = maasList.toArray(maasArray);
        //veriler olsuturulan dizilere eklendi
        
        double[] maasDoubleArray = new double[maasArray.length];
        for (int i = 0; i < maasArray.length; i++) {
            maasDoubleArray[i] = Double.parseDouble(maasArray[i]);
            //parsedouble double veriye cevirmeye zorlar
        }


        double[] calismaSuresiDoubleArray = new double[calismaSuresiArray.length];
        for (int i = 0; i < calismaSuresiArray.length; i++) {
            calismaSuresiDoubleArray[i] = Double.parseDouble(calismaSuresiArray[i]);
        }

        double[][] data = new double[2][maasDoubleArray.length];
        for (int i = 0; i < maasDoubleArray.length; i++) {
            data[0][i] = calismaSuresiDoubleArray[i];
            data[1][i] = maasDoubleArray[i];
            //2 boyutlu matris 
        }

        aktifdosya.close();

        return data;
    }

    public Data() {
        System.out.println("Veri işleniyor...");
    }
	}
