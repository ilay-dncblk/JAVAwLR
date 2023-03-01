package lrmaastahmini;
import edu.princeton.cs.introcs.StdDraw;
import java.text.DecimalFormat;
	public class Grafik implements GrafikArayuzu {

	    public void grafigiçiz(double[] maas, double[] ay, double eğim, double sabit) {
	    	grafikBoyutu(0, 100, 0, 100);
	    	baslıkAyarla("Linear Regresyon Tablosu");
	        koordinatEtiketiAyarla("Çalışma Süresi", "Maaş");
	        ızgaraÇiz();
	        koordinatÇiz();
	        koordinatDegeriÇiz();
	        koordinatOkuÇiz();
	        regresyonÇizgisi(eğim, sabit);
	        noktalarıÇiz(maas, ay);
	        egimiYaz(eğim);
	        sabitDegeriniYaz(sabit);
	        tabloAdı(main.secim);	
		    ortalamaMaas(maas);
		    ortalamaCalısmaSuresi(ay);
	    }

	    public void baslıkAyarla(String baslık) {
	        StdDraw.setPenRadius(0.005);
	        StdDraw.setPenColor(StdDraw.BLACK);
	        StdDraw.text(50, 90, baslık);
	    }

	    public void koordinatEtiketiAyarla(String xEtiket, String yEtiket) {
	        StdDraw.text(90, 5, xEtiket);
	        StdDraw.text(5, 100, yEtiket);
	    }

	    public void grafikBoyutu(double xMin, double xMax, double yMin, double yMax) {
	        StdDraw.setXscale(xMin, xMax);
	        StdDraw.setYscale(yMin, yMax);
	    }

	    public void regresyonÇizgisi(double eğim, double sabit) {
	        StdDraw.setPenColor(StdDraw.RED);
	        StdDraw.setPenRadius(0.005);
	        StdDraw.line(0, sabit, 100, eğim * 100 + sabit);
	    }

	    public void noktalarıÇiz(double[] maas, double[] ay) {
	        StdDraw.setPenColor(StdDraw.DARK_GRAY);
	        StdDraw.setPenRadius(0.01);
	        for (int i = 0; i < maas.length; i++) {
	            StdDraw.point(maas[i], ay[i]);
	        }
	    }

	    public void ızgaraÇiz() {
	        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
	        StdDraw.setPenRadius(0.001);
	        for (int i = 0; i < 10; i++) {
	            StdDraw.line(0, i * 10, 100, i * 10);
	            StdDraw.line(i * 10, 0, i * 10, 100);
	        }
	    }

	    public void koordinatÇiz() {
	        StdDraw.setPenColor(StdDraw.BLACK);
	        StdDraw.setPenRadius(0.005);
	        StdDraw.line(0, 0, 100, 0);
	        StdDraw.line(0, 0, 0, 100);
	    }

	    public void koordinatDegeriÇiz() {
	        StdDraw.setPenColor(StdDraw.BLACK);
	        StdDraw.setPenRadius(0.005);
	        for (int i = 0; i < 10; i++) {
	            StdDraw.text(0, i * 10, Integer.toString(i * 10));
	            StdDraw.text(i * 10, 0, Integer.toString(i * 10));
	        }
	    }

	    public void koordinatOkuÇiz() {
	        StdDraw.setPenColor(StdDraw.BLACK);
	        StdDraw.setPenRadius(0.005);
	        StdDraw.line(100, 0, 95, 5);
	        StdDraw.line(100, 0, 95, -5);
	        StdDraw.line(0, 100, 5, 95);
	        StdDraw.line(0, 100, -5, 95);
	    }
	    public void egimiYaz(double eğim) {
	        StdDraw.setPenRadius(0.005);
	        StdDraw.setPenColor(StdDraw.MAGENTA);
	        DecimalFormat format = new DecimalFormat("##.##");
	        StdDraw.text(80, 85, "Eğim: "+ format.format(eğim).toString());
	    }
	    public void sabitDegeriniYaz(double sabit) {
	    	StdDraw.setPenRadius(0.005);
	        StdDraw.setPenColor(StdDraw.MAGENTA);
	        DecimalFormat format = new DecimalFormat("##.##");	        
	        StdDraw.text(80, 80, "Sabit: "+ format.format(sabit).toString());
	    }
	    public void tabloAdı(String secim) {
	    	 StdDraw.setPenRadius(0.005);
	    	 StdDraw.setPenColor(StdDraw.BLACK);
		     StdDraw.text(50, 95, secim );
		 
	    }
	    
	    public void ortalamaMaas(double[] maas) {
	    	StdDraw.setPenRadius(0.005);
	        StdDraw.setPenColor(StdDraw.BLUE);
	        float maasortalama = 0;
	        for (int i = 0; i < maas.length; i++) {
	            maasortalama += maas[i];}
	        	maasortalama /= maas.length;
	        StdDraw.text(10, 95, "Ort. Maaş: "+ maasortalama);
	    }
	    
	    public void ortalamaCalısmaSuresi(double[] ay) {
	    	StdDraw.setPenRadius(0.005);
	        StdDraw.setPenColor(StdDraw.BLUE);
	        float ayortalama = 0;
	        for (int i = 0; i < ay.length; i++) {
	            ayortalama += ay[i];}
	        	ayortalama /= ay.length;
	        StdDraw.text(85, 10, "Ort. Deneyim Süresi: "+ ayortalama);
	    }
	   
	    public Grafik() {
	        System.out.println("Grafik oluşturuluyor.");
	    }
	}