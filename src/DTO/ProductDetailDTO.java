/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author NAME
 */
public class ProductDetailDTO {
    String MaSP,DuoiTuongSuDung,ChatLieuVo,ChatLieuDay,ChatLieuMatDH,ChongNuoc,DoDay,KichThuocMat,NgayNhap,NgayXuat,Gia,GiaXuat,NhaCungCap,STT;;

    public String getGiaXuat() {
        return GiaXuat;
    }

    public void setGiaXuat(String GiaXuat) {
        this.GiaXuat = GiaXuat;
    }
    
    public String getMaSP() {
        return MaSP;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String Gia) {
        this.Gia = Gia;
    }

    public String getSTT() {
        return STT;
    }

    public void setSTT(String STT) {
        this.STT = STT;
    }
    
    
 
    public String getDuoiTuongSuDung() {
        return DuoiTuongSuDung;
    }

    public String getChatLieuVo() {
        return ChatLieuVo;
    }

    public String getChatLieuDay() {
        return ChatLieuDay;
    }

    public String getChatLieuMatDH() {
        return ChatLieuMatDH;
    }

    public String getChongNuoc() {
        return ChongNuoc;
    }

    public String getDoDay() {
        return DoDay;
    }

    public String getKichThuocMat() {
        return KichThuocMat;
    }

    public String getNgayNhap() {
        return NgayNhap;
    }

    public String getNgayXuat() {
        return NgayXuat;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    
    public void setDuoiTuongSuDung(String DuoiTuongSuDung) {
        this.DuoiTuongSuDung = DuoiTuongSuDung;
    }

    public void setChatLieuVo(String ChatLieuVo) {
        this.ChatLieuVo = ChatLieuVo;
    }

    public void setChatLieuDay(String ChatLieuDay) {
        this.ChatLieuDay = ChatLieuDay;
    }

    public void setChatLieuMatDH(String ChatLieuMatDH) {
        this.ChatLieuMatDH = ChatLieuMatDH;
    }

    public void setChongNuoc(String ChongNuoc) {
        this.ChongNuoc = ChongNuoc;
    }

    public void setNgayNhap(String NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public void setNgayXuat(String NgayXuat) {
        this.NgayXuat = NgayXuat;
    }

    public void setDoDay(String DoDay) {
        this.DoDay = DoDay;
    }

    public void setKichThuocMat(String KichThuocMat) {
        this.KichThuocMat = KichThuocMat;
    }

    public String getNhaCungCap() {
        return NhaCungCap;
    }

    public void setNhaCungCap(String NhaCungCap) {
        this.NhaCungCap = NhaCungCap;
    }
    
    public ProductDetailDTO() {
    }

    public ProductDetailDTO(String MaSP,String stt, String DuoiTuongSuDung, String ChatLieuVo, String ChatLieuDay,String ChatLieuMatDH, String ChongNuoc, String DoDay, String KichThuocMat, String NgayNhap, String NgayXuat,String Gia, String nhacungcap,String giaxuat) {
        this.MaSP = MaSP;
        this.STT = stt;
        this.DuoiTuongSuDung = DuoiTuongSuDung;
        this.ChatLieuVo = ChatLieuVo;
        this.ChatLieuDay = ChatLieuDay;
        this.ChatLieuMatDH = ChatLieuMatDH;
        this.ChongNuoc = ChongNuoc;
        this.DoDay = DoDay;
        this.KichThuocMat = KichThuocMat;
        this.NgayNhap = NgayNhap;
        this.NgayXuat = NgayXuat;
        this.Gia = Gia;
        this.NhaCungCap = nhacungcap;
        this.GiaXuat = giaxuat;
    }
    
}
