/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.NhanVienBUS;
import BUS.PhieuBUS;
import BUS.PhieuDetailBUS;
import BUS.ProductDetailBUS;
import DTO.NhanVienDTO;
import DTO.PhieuDTO;
import DTO.PhieuDetailDTO;
import DTO.ProductDetailDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NAME
 */
public class Del_PhieuNhap extends JFrame implements MouseListener,KeyListener{
    
    JPanel pnlheading,pnlcontent;
    Label heading;
    JScrollPane sptbl;
    JTable tblphieunhap;
    DefaultTableModel model;
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
    PhieuBUS phieubus = new PhieuBUS();
    NhanVienBUS nhanvienbus = new NhanVienBUS();
    int index = -1;
    PhieuDetailBUS phieudetailbus = new PhieuDetailBUS();
    ProductDetailBUS productdetailbus = new ProductDetailBUS();
    DsPhieu phieunhap;
    public void initcomponent(){
        this.setSize(1200,600);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        pnlheading = new JPanel(new GridLayout(1,1));
        pnlheading.setPreferredSize(new Dimension(0,80));
        pnlheading.setOpaque(true);
        
        heading = new Label("Hủy phiếu",1);
        heading.setForeground(new Color(240,240,240));
        heading.setBackground(main_clr);
        heading.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,20));
        
        pnlheading.add(heading);
        
        pnlcontent = new JPanel(new GridLayout(1,1));
        pnlcontent.setBorder(new EmptyBorder(10,10,10,10));
        
        model = new DefaultTableModel();
        
        model.addColumn("Mã phiếu nhập");
        model.addColumn("Người tạo");
        model.addColumn("Ngày tạo");
        model.addColumn("Thành tiền");
        
        for(PhieuDTO pn : phieubus.getPhieunhaplist()){
            NhanVienDTO nv = nhanvienbus.selectnhanvien(pn.getNguoiTao());
            System.out.println(pn.getNguoiTao());
            model.addRow(new Object[] {pn.getMaPhieu(),nv.getTenNV(),pn.getNgayTao(),pn.getDonGia()});
        }
        
        tblphieunhap = new JTable(model);
        tblphieunhap.addMouseListener(this);
        tblphieunhap.addKeyListener(this);
        
        sptbl = new JScrollPane();
        sptbl.setViewportView(tblphieunhap);
        
        pnlcontent.add(sptbl);
        
        this.add(pnlcontent,BorderLayout.CENTER);
        this.add(pnlheading,BorderLayout.NORTH);
        
        this.setVisible(true);
    }

    public Del_PhieuNhap() throws HeadlessException {
        initcomponent();
    }

    public void setPhieunhap(DsPhieu phieunhap) {
        this.phieunhap = phieunhap;
    }
    
    public boolean checkoub(ArrayList<PhieuDetailDTO> list){
        boolean check = true;
        for(PhieuDetailDTO ctp : list){
            ProductDetailDTO sp = productdetailbus.selectbyID(ctp.getMaSP(),ctp.getTenSP());
            if(!sp.getNgayXuat().equals("null")){
                check = false;
                break;
            }
        }
        return check;
    }
    
    public void selectitem(ArrayList<PhieuDTO> list){
        if(JOptionPane.showConfirmDialog(pnlcontent, "Bạn muốn hủy phiếu này ?","Hủy phiếu",JOptionPane.YES_NO_OPTION) ==0){
                this.index = tblphieunhap.getSelectedRow();
                PhieuDTO del_phieu = list.get(index);
                ArrayList<PhieuDetailDTO> del_ctp = phieudetailbus.selectbyID(del_phieu.getMaPhieu());
                if(checkoub(del_ctp)){
                    for(PhieuDetailDTO ctp : del_ctp){
                        ProductDetailDTO del_ctsp = productdetailbus.selectbyID(ctp.getMaSP(),ctp.getTenSP());
                        phieudetailbus.delPhieuDetail(ctp);
                        productdetailbus.delProductDetail(del_ctsp);
                    }
                    phieubus.delPhieuNhap(del_phieu);
                }else
                    JOptionPane.showMessageDialog(null, "Không thể xóa phiếu này!");
            }
        phieunhap.showdata(phieubus.getPhieunhaplist());
        this.dispose();
    }
    
    
    public static void main(String[] args) {
        new Del_PhieuNhap();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==tblphieunhap){
            selectitem(phieubus.getPhieunhaplist());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
