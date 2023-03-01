package lrmaastahmini;

public interface GrafikArayuzu {
	//arayüz kullanılacak metotlara ön ayar verme 

	    public void grafigiçiz(double[] maas, double[] ay, double eğim, double sabit);

	    public void baslıkAyarla(String baslık);

	    public void koordinatEtiketiAyarla(String xEtiketi, String yEtiketi);

	    public void grafikBoyutu(double xMin, double xMax, double yMin, double yMax);

	    public void regresyonÇizgisi(double eğim, double sabit);

	    public void noktalarıÇiz(double[] maas, double[] ay);

	    public void ızgaraÇiz();

	    public void koordinatÇiz();

	    public void koordinatDegeriÇiz();

	    public void koordinatOkuÇiz();
	    
	    public void egimiYaz(double eğim);
	    	
	    public void sabitDegeriniYaz(double sabit);
		
	    public void tabloAdı(String secim);	
	    
	    public void ortalamaMaas(double [] maas);
	    
	    public void ortalamaCalısmaSuresi(double [] ay);
	}

