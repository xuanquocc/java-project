package Model;

public class MotoBike {
	private int id;
	private String hoten;
	private String ngaysinh;
	private String sodienthoai;
	private String phankhoi;
	private String hangxe;
	private String biensoxe;
	private String loaixe;
	private int thang;
	
	public MotoBike(String hoten, String ngaysinh, String sodienthoai, String loaixe, String phankhoi, String hangxe,
			String biensoxe,int thang) {
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.sodienthoai = sodienthoai;
		this.loaixe = loaixe;
		this.phankhoi = phankhoi;
		this.hangxe = hangxe;
		this.biensoxe = biensoxe;
		this.thang = thang;
		
	}

	public MotoBike( String hoten, String ngaysinh, String sodienthoai, String loaixe, String phankhoi, String hangxe,
			String biensoxe, int id, int thang) {

		this.id = id;
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.sodienthoai = sodienthoai;
		this.loaixe = loaixe;
		this.phankhoi = phankhoi;
		this.hangxe = hangxe;
		this.biensoxe = biensoxe;
		this.thang = thang; 
	}

	public int getThang() {
		return thang;
	}

	public void setThang(int thang) {
		this.thang = thang;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public String getPhankhoi() {
		return phankhoi;
	}

	public void setPhankhoi(String phankhoi) {
		this.phankhoi = phankhoi;
	}

	public String getHangxe() {
		return hangxe;
	}

	public void setHangxe(String hangxe) {
		this.hangxe = hangxe;
	}

	public String getBiensoxe() {
		return biensoxe;
	}

	public void setBiensoxe(String biensoxe) {
		this.biensoxe = biensoxe;
	}

	public String getLoaixe() {
		return loaixe;
	}

	public void setLoaixe(String loaixe) {
		this.loaixe = loaixe;
	}

	
	
}

