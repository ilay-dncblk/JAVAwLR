package lrmaastahmini;
import java.util.Scanner;

public class Tahmin extends LineerRegresyon {

    
    protected void tahminet(double eğim, double sabit) 
    {
        Scanner oku = new Scanner(System.in);
        System.out.println("Lütfen maaş değeri giriniz");
       
        double girilenmaas = oku.nextDouble();
      
        double hesaplanancalısmasuresi = eğim * girilenmaas + sabit;
 
        System.out.println("Hesaplanan Çalışma Süresi " + hesaplanancalısmasuresi);

        oku.close();
    }

    protected void tahminet(double eğim, double sabit, double maasortalama) 
    {
        double hesapcalısmasüresi = eğim * maasortalama+ sabit;
        System.out.println("Hesaplanan Çalışma Süresi " + hesapcalısmasüresi);
    }

    protected void tahminet (double eğim, double sabit, double[] maas) 
    {
        double[] hesapcalısmasuresi = new double[maas.length];
        for (int i = 0; i <  maas.length; i++) {
            hesapcalısmasuresi[i] = eğim * maas[i] + sabit;
            //her bir çalışanın maasına  ve liner regresyona gore çalışması gereken sure
        }
        System.out.println("Her bir çalışan için hesaplanan çalışma süresi ");
        for (int i = 0; i < hesapcalısmasuresi.length; i++) {
            System.out.println();
            System.out.println(i + 1 + ". ID numarası verilen çalışanın tablodaki ücreti alması için asıl çalışma süresi: " + hesapcalısmasuresi[i]);
        }
    }

    public Tahmin() {
        System.out.println("Tahmin yapılıyor.");
    }

public class TahminDogrulugu extends LineerRegresyon {
	
		    public void dogruluk(double[] maas, double[] ay, double eğim, double sabit) {
		   
		        double ayortalama = 0;
		        for (int i = 0; i < ay.length; i++) {
		           ayortalama += ay[i];
		        }
		        ayortalama /= ay.length;

		        double r2 = 0;
		        double r2max = 0;
		        double r2min = 0;
		        
		        for (int i = 0; i < maas.length; i++) {
		        	//lineer fonk denklemine ve verilere bakılarak max min yarıcap belirledik.
		            r2max += (ay[i] - (eğim * maas[i] + sabit)) * (ay[i] - (eğim * maas[i] + sabit));
		            
		            r2min += (ay[i] - ayortalama) * (ay[i] - ayortalama);
		        }
		        r2 = 1 - (r2max / r2min); 
		    
		        
		        System.out.println("Tahminin doğruluk oranı %" + r2 * 100);
		    }
		    
		    public TahminDogrulugu() {
		        System.out.println("Tahmin Doğruluğu ölçülüyor.");
		    }

		}
	



}

