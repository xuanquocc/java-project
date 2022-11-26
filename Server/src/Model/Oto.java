package Model;

public class Oto extends MotoBike {
	private int chongoi;

	

	public Oto(String hoten, String ngaysinh, String sodienthoai, String loaixe, String phankhoi, int chongoi,
			String hangxe, String biensoxe, int id, int thang) {
		super(hoten, ngaysinh, sodienthoai, loaixe, phankhoi, hangxe, biensoxe, id, thang);
		this.chongoi = chongoi;
	}

	public Oto(String hoten, String ngaysinh, String sodienthoai, String loaixe, String phankhoi, int chongoi,
			String hangxe, String biensoxe, int thang) {
		super(hoten, ngaysinh, sodienthoai, loaixe, phankhoi, hangxe, biensoxe, thang);
		this.chongoi = chongoi;
	}

	public int getChongoi() {
		return chongoi;
	}

	public void setChongoi(int chongoi) {
		this.chongoi = chongoi;
	}
}

