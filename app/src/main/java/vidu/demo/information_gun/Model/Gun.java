package vidu.demo.information_gun.Model;

public class Gun {
    private int anhSung;
    private String tenSung;
    private String nhaSanXuat;
    private String quocGia;

    public Gun() {
    }

    public Gun(int anhSung, String tenSung, String nhaSanXuat, String quocGia) {
        this.anhSung = anhSung;
        this.tenSung = tenSung;
        this.nhaSanXuat = nhaSanXuat;
        this.quocGia = quocGia;
    }

    public int getAnhSung() {
        return anhSung;
    }

    public void setAnhSung(int anhSung) {
        this.anhSung = anhSung;
    }

    public String getTenSung() {
        return tenSung;
    }

    public void setTenSung(String tenSung) {
        this.tenSung = tenSung;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }
}
