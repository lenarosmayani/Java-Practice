import java.util.Scanner;

public class ParkirMalamMinggu {
	public static void main(String[] args){
		// TODO Auto-generated method stub
	    Scanner input = new Scanner(System.in);
	    
	    int jenisKendaraan = input.nextInt();
	    int lamaParkir = input.nextInt();
	    
	    int biayaParkir = totalBiaya(jenisKendaraan,lamaParkir);
	    
	    if (lamaParkir>8) {
	    	System.out.println("disegel");
	    }else {
	    	System.out.println(biayaParkir);
	    }
	}
	public static int totalBiaya(int jenisKendaraan,int lamaParkir) {
		int biayaPerJam;
		if(jenisKendaraan == 1 ) {
			biayaPerJam = 1500;
		}else {
			biayaPerJam = 1000;
		}
		int biayaParkir = lamaParkir*biayaPerJam;
		
		if (lamaParkir>5) {
			biayaParkir +=(lamaParkir-5)*500;
		}
		
		return biayaParkir;
	}
}
