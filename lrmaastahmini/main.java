package lrmaastahmini;
import java.io.IOException;
import java.util.Scanner;

public class main {
static String secim;
	public static void main(String[] args) throws Exception {
		System.out.println("Lütfen kullanmak istediğiniz datanın ismini yazınız.");
		System.out.println("1.Yazilimci");
		System.out.println("2.Hizmet");
		System.out.println("3.Yonetim");
	
		Scanner sec = new Scanner(System.in);
		secim = sec.nextLine();
		
		Data secilendata = new Data();
		
		LineerRegresyon lr = new LineerRegresyon();
		
		//secime göre dataya ulasma yolu olusturdu
		String yol ="C:\\Users\\ilay\\Desktop\\stid\\lineerregresyonmaastahmini\\src\\"+secim.toLowerCase()+"data.csv";
		
		try {
			//burda iki class iç ice önce parantez içi öncelikli cağrılıp içine alıcağı verileri belirliyoruz 
			lr.lineerRegresyon(secilendata.dosyaoku(yol)[1], secilendata.dosyaoku(yol)[0]);
			
		}
		//IOException dosyalama, girdi çıktı hatalarını belirtir.
		catch (IOException hata) {
			//Diğer kullanım alanlarında hatası varsa onları da belirtiyor 
			hata.printStackTrace();
		}
		//Ram de yer kaplamaması için okuyucuyu kapattık.
		sec.close();
		
	
	}
	

}
