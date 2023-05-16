/*
 * Click nbfs:nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs:nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.PhieuBUS;
import BUS.PhieuDetailBUS;
import BUS.ProductDetailBUS;
import DTO.PhieuDTO;
import DTO.PhieuDetailDTO;
import DTO.ProductDetailDTO;
import DTO.ThongKeDTO;
import GUI.Component.Chart.BarChart.Chart;
import GUI.Component.Chart.BarChart.ModelChart;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JFrame;


public class Test extends JFrame{
    
    PhieuBUS phieubus = new PhieuBUS();
    ProductDetailBUS productdetailbus = new ProductDetailBUS();
    PhieuDetailBUS phieudetailbus = new PhieuDetailBUS();
    ArrayList<PhieuDTO> phieulist = new ArrayList<>();
    ArrayList<ThongKeDTO> thongkelist = new ArrayList<>();
    ArrayList<PhieuDetailDTO> chitietphieulist = new ArrayList<>();
    ThongKeDTO tk ;
    String[] thang = {"01","02","03","04","05","06","07","08","09","10","11","12"};
    public Test() throws HeadlessException {
        phieulist = phieubus.getListphieu();
        getContentPane().setBackground(new Color(250,250,250));
        setSize(new Dimension(1400,720));
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1,1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Chart chart = new Chart();
        chart.addLegend("Vốn", new Color(245, 189, 135));
        chart.addLegend("Doanh thu", new Color(135, 189, 245));
        chart.addLegend("Lợi nhuận", new Color(189, 135, 245));
        
        for(int i=0;i<thang.length;i++){
            tk = new ThongKeDTO("Tháng "+Integer.toString(Integer.parseInt(thang[i])), 0,0,0);
            for(PhieuDTO phieu : phieulist){
                if(phieu.getLoaiPhieu().equals("phieunhap")&&phieu.getNgayTao().contains('/'+thang[i]+'/')){
                    tk.setVon(tk.getVon()+Integer.parseInt(phieu.getDonGia()));
                }else if(phieu.getLoaiPhieu().equals("phieuxuat")&&phieu.getNgayTao().contains('/'+thang[i]+'/')){
                    tk.setDoanhthu(tk.getDoanhthu()+Integer.parseInt(phieu.getDonGia()));
                }
                if(phieu.getLoaiPhieu().equals("phieuxuat")){
                    chitietphieulist = phieudetailbus.selectbyID(phieu.getMaPhieu(), "phieuxuat");
                    for(PhieuDetailDTO phieudetail : chitietphieulist){
                        ProductDetailDTO prd = productdetailbus.selectbyID(phieudetail.getMaSP(),phieudetail.getTenSP());
                            if(prd.getNgayXuat().contains('/'+thang[i]+'/')){
                                tk.setLoinhuan(tk.getLoinhuan()+(Integer.parseInt(prd.getGia())/10));
                                System.out.println(tk.getLoinhuan());
                            }
                    }
                }
            }
            chart.addData(new ModelChart(tk.getThoigian(), new double[]{tk.getVon(), tk.getDoanhthu(), tk.getLoinhuan()}));
        }
        
//        chart.addData(new ModelChart("Tháng 1", new double[]{100, 150, 200}));
//        chart.addData(new ModelChart("Tháng 2", new double[]{600, 750, 300}));
//        chart.addData(new ModelChart("Tháng 3", new double[]{200, 350, 1000}));
//        chart.addData(new ModelChart("Tháng 4", new double[]{480, 150, 750}));
//        chart.addData(new ModelChart("Tháng 5", new double[]{100, 150, 200}));
//        chart.addData(new ModelChart("Tháng 6", new double[]{600, 750, 300}));
//        chart.addData(new ModelChart("Tháng 7", new double[]{200, 350, 1050}));
//        chart.addData(new ModelChart("Tháng 8", new double[]{480, 150, 750}));
//        chart.addData(new ModelChart("Tháng 9", new double[]{100, 150, 200}));
//        chart.addData(new ModelChart("Tháng 10", new double[]{600, 750, 300}));
//        chart.addData(new ModelChart("Tháng 11", new double[]{200, 350, 1000}));
//        chart.addData(new ModelChart("Tháng 12", new double[]{480, 150, 750}));
//        chart.addData(new ModelChart("Tháng 1", new double[]{100, 150, 200}));
//        chart.addData(new ModelChart("Tháng 2", new double[]{600, 750, 300}));
//        chart.addData(new ModelChart("Tháng 3", new double[]{200, 350, 1000}));
//        chart.addData(new ModelChart("Tháng 4", new double[]{480, 150, 750}));
//        chart.addData(new ModelChart("Tháng 5", new double[]{100, 150, 200}));
//        chart.addData(new ModelChart("Tháng 6", new double[]{600, 750, 300}));
//        chart.addData(new ModelChart("Tháng 7", new double[]{200, 350, 1000}));
//        chart.addData(new ModelChart("Tháng 8", new double[]{480, 150, 750}));
//        chart.addData(new ModelChart("Tháng 9", new double[]{100, 150, 200}));
//        chart.addData(new ModelChart("Tháng 10", new double[]{600, 750, 300}));
//        chart.addData(new ModelChart("Tháng 11", new double[]{200, 350, 1000}));
//        chart.addData(new ModelChart("Tháng 12", new double[]{480, 150, 750}));
//        chart.addData(new ModelChart("Tháng 1", new double[]{100, 150, 200}));
//        chart.addData(new ModelChart("Tháng 2", new double[]{600, 750, 300}));
//        chart.addData(new ModelChart("Tháng 3", new double[]{200, 350, 1000}));
//        chart.addData(new ModelChart("Tháng 4", new double[]{480, 150, 750}));
//        chart.addData(new ModelChart("Tháng 5", new double[]{100, 150, 200}));
//        chart.addData(new ModelChart("Tháng 6", new double[]{600, 750, 300}));
//        chart.addData(new ModelChart("Tháng 7", new double[]{200, 350, 1000}));
//        chart.addData(new ModelChart("Tháng 8", new double[]{480, 150, 750}));
//        chart.addData(new ModelChart("Tháng 9", new double[]{100, 150, 200}));
//        chart.addData(new ModelChart("Tháng 10", new double[]{600, 750, 300}));
//        chart.addData(new ModelChart("Tháng 11", new double[]{200, 350, 1000}));
//        chart.addData(new ModelChart("Tháng 12", new double[]{480, 150, 750}));
        
        add(chart);
                setVisible(true);

    }

    
    public static void main(String[] args) {
        new Test();
    }
}



