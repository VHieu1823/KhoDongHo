/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;


import BUS.PhieuBUS;
import BUS.PhieuDetailBUS;
import BUS.ProductDetailBUS;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import DTO.PhieuDTO;
import DTO.PhieuDetailDTO;
import DTO.ProductDetailDTO;
import DTO.ThongKeDTO;
import GUI.Component.Chart.BarChart.Chart;
import GUI.Component.Chart.BarChart.ModelChart;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;


/**
 *
 * @author NAME
 */
public class Lib_Form extends JPanel implements ItemListener,MouseListener{
    
    JPanel pnlcontent,pnltbl,pnlsort,pnlsortinfo;
    JTable tbl;
    DefaultTableModel model;
    JScrollPane sptbl;
    PhieuBUS phieubus = new PhieuBUS();
    ProductDetailBUS productdetailbus = new ProductDetailBUS();
    PhieuDetailBUS phieudetailbus = new PhieuDetailBUS();
    ArrayList<PhieuDTO> phieulist = new ArrayList<>();
    ArrayList<PhieuDetailDTO> chitietphieulist = new ArrayList<>();
    ThongKeDTO tk ;
    Chart chart = new Chart();
    JComboBox cboption,cbquy,cbnam;
    Label lblsorttype,lblfrom,lblto,lblshow,lblnam;
    Font font = new Font("Times New Roman",Font.CENTER_BASELINE,16);
    String[] thang = {"01","02","03","04","05","06","07","08","09","10","11","12"};
//    String[] thang30 = new String[30];
//    String[] thang31 = new String[31];
//    String[] thang2 = new String[29];

    String[] nam ;
    int a = 0;
    int b = 0;
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
    public void initcomponent(){
//        for(int i=1;i<=31;i++){
//            thang31[i] = Integer.toString(i);
//            if(i<31){
//                thang30[i] = Integer.toString(i);
//            }
//            if(i<30){
//                thang2[i] = Integer.toString(i);
//            }
//        }
        this.setOpaque(true);
        this.setBackground(null);
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(10,10,50,25));
        phieulist = phieubus.getListphieu();
        
        pnlsortinfo = new JPanel(null);
        pnlsortinfo.setBounds(400,0,400,40);
        pnlsortinfo.setOpaque(true);
        pnlsortinfo.setBackground(new Color(230,230,230));

        String date = java.time.LocalDate.now().toString();
            String[] splits = date.split("-");
            List<String> data = new ArrayList<String>();
            String redate ="";
            for(String item : splits){
                data.add( item); 
            }
            redate = data.get(0);
            String[] n = new String[Integer.parseInt(redate)-1999];
            for(int i=0;i<=Integer.parseInt(redate)-2000;i++){
                n[i] = Integer.toString(2000+i);
            }
            nam = n;
            lblfrom = new Label("Quý:",2);
            lblfrom.setBounds(20,5,50,30);
            lblfrom.setFont(font);

            cbquy = new JComboBox(new String[] {"1","2","3","4"});
            cbquy.setBounds(80,5,100,30);
            cbquy.addItemListener(this);

            lblnam = new Label("Năm:",2);
            lblnam.setFont(font);
            lblnam.setBounds(200, 5, 50,30);

            cbnam = new JComboBox(nam);
            cbnam.setBounds(260,5,100,30);
            cbnam.addItemListener(this);
            
//            pnlsortinfo.add(lblfrom);
//            pnlsortinfo.add(cbquy);
//            pnlsortinfo.add(lblnam);
//            pnlsortinfo.add(cbnam);
            
        
        pnlsort = new JPanel(null);
        pnlsort.setPreferredSize(new Dimension(0,50));
        
        lblsorttype = new Label("Theo:",2);
        lblsorttype.setFont(font);
        lblsorttype.setBounds(150,5,100,30);
        
        cboption = new JComboBox(new String[] {"Trong năm","Quý","Năm"});
        cboption.setBounds(260,5,100,30);
        cboption.addItemListener(this);
        
        lblshow = new Label("Áp dụng",1);
        lblshow.setFont(font);
        lblshow.setForeground(new Color(240,240,240));
        lblshow.setBounds(820,5,100,30);
        lblshow.setBackground(main_clr);
        lblshow.addMouseListener(this);
        
        pnlsort.add(lblshow);
        pnlsort.add(lblsorttype);
        pnlsort.add(cboption);
        pnlsort.add(pnlsortinfo);
        
        
        pnlcontent = new JPanel(new GridLayout(1,1));
        pnlcontent.add(chart);
        
        pnltbl = new JPanel(new GridLayout(1,1));
        pnltbl.setPreferredSize(new Dimension(0,300));
        pnltbl.setBorder(new LineBorder(new Color(230,230,230),1,true));
        
        model = new DefaultTableModel();
        model.addColumn("Thời gian");
        model.addColumn("Vốn");
        model.addColumn("Doanh thu");
        model.addColumn("Lợi nhuận");

        showdata(thang); 
        
        tbl = new JTable(model);
        
        sptbl = new JScrollPane(tbl);
        pnltbl.add(sptbl);
        
        this.add(pnlsort,BorderLayout.NORTH);
        this.add(pnlcontent,BorderLayout.CENTER);
        this.add(pnltbl,BorderLayout.SOUTH);
        
        
//        this.repaint();
//        this.validate();
    }
   
    public Lib_Form(){
        initcomponent();
    }
    
    public void sortoption(){
        if(cboption.getSelectedItem().toString().equals("Trong năm")){
            pnlsortinfo.removeAll();       
            pnlsortinfo.repaint();
            pnlsortinfo.validate();
        }
        else if(cboption.getSelectedItem().toString().equals("Quý")){
            String date = java.time.LocalDate.now().toString();
            String[] splits = date.split("-");
            List<String> data = new ArrayList<String>();
            String redate ="";
            for(String item : splits){
                data.add( item); 
            }
            redate = data.get(0);
            String[] nam = new String[Integer.parseInt(redate)-1999];
            for(int i=0;i<=Integer.parseInt(redate)-2000;i++){
                nam[i] = Integer.toString(2000+i);
            }
           
            lblfrom.setText("Quý:");
            lblfrom.setFont(font);

            cbquy = new JComboBox(new String[] {"1","2","3","4"});
            cbquy.setBounds(80,5,100,30);
            cbquy.addItemListener(this);

            lblnam = new Label("Năm:",2);
            lblnam.setFont(font);
            lblnam.setBounds(200, 5, 50,30);

            cbnam = new JComboBox(nam);
            cbnam.setBounds(260,5,100,30);
            cbnam.addItemListener(this);
            
            pnlsortinfo.removeAll();
            pnlsortinfo.add(lblfrom);
            pnlsortinfo.add(cbquy);
            pnlsortinfo.add(lblnam);
            pnlsortinfo.add(cbnam);
            pnlsortinfo.repaint();
            pnlsortinfo.validate();
            

        }
        else{
            String date = java.time.LocalDate.now().toString();
            String[] splits = date.split("-");
            List<String> data = new ArrayList<String>();
            String redate ="";
            for(String item : splits){
                data.add( item); 
            }
            redate = data.get(0);
            String[] nam = new String[Integer.parseInt(redate)-1999];
            for(int i=0;i<=Integer.parseInt(redate)-2000;i++){
                nam[i] = Integer.toString(2000+i);
            }
           
            lblfrom = new Label("Từ:",2);
            lblfrom.setBounds(20,5,50,30);
            lblfrom.setFont(font);

            cbquy = new JComboBox(nam);
            cbquy.setBounds(80,5,100,30);
            cbquy.addItemListener(this);

            lblnam = new Label("Đến:",2);
            lblnam.setFont(font);
            lblnam.setBounds(200, 5, 50,30);

            cbnam = new JComboBox(nam);
            cbnam.setBounds(260,5,100,30);
            cbnam.addItemListener(this);
            
            pnlsortinfo.removeAll();
            pnlsortinfo.add(lblfrom);
            pnlsortinfo.add(cbquy);
            pnlsortinfo.add(lblnam);
            pnlsortinfo.add(cbnam);
            pnlsortinfo.repaint();
            pnlsortinfo.validate();
        }
    }
    
    public void showdata(String[] thang){
        pnlcontent.remove(chart);
        this.chart = new Chart();
        
        this.chart.addLegend("Vốn", new Color(245, 189, 135));
        this.chart.addLegend("Doanh thu", new Color(135, 189, 245));
        this.chart.addLegend("Lợi nhuận", new Color(189, 135, 245));
        pnlcontent.add(chart);
        pnlcontent.repaint();
        pnlcontent.validate();
        model.setRowCount(0);
        ArrayList<ThongKeDTO> thongkelist = new ArrayList<>();
        for(int i=0;i<thang.length;i++){
            tk = new ThongKeDTO("Tháng "+Integer.toString(Integer.parseInt(thang[i])), 0,0,0);
            for(PhieuDTO phieu : phieulist){
                if(phieu.getLoaiPhieu().equals("phieunhap")&&phieu.getNgayTao().contains('/'+thang[i]+'/')){
                    tk.setVon(tk.getVon()+Integer.parseInt(phieu.getDonGia()));
                }else if(phieu.getLoaiPhieu().equals("phieuxuat")&&phieu.getNgayTao().contains('/'+thang[i]+'/')){
                    tk.setDoanhthu(tk.getDoanhthu()+Integer.parseInt(phieu.getDonGia()));
                    chitietphieulist = phieudetailbus.selectbyID(phieu.getMaPhieu(), "phieuxuat");
                    for(PhieuDetailDTO phieudetail : chitietphieulist){
                        ProductDetailDTO prd = productdetailbus.selectbyID(phieudetail.getMaSP(),phieudetail.getTenSP());
                            if(prd.getNgayXuat().contains('/'+thang[i]+'/')){
                                tk.setLoinhuan(tk.getLoinhuan()+(Integer.parseInt(prd.getGia())/10));
                            }
                    }
                }
                    
            }
            this.chart.addData(new ModelChart(tk.getThoigian(), new double[]{tk.getVon(), tk.getDoanhthu(), tk.getLoinhuan()}));   
            if (tk.getLoinhuan()!=0||tk.getDoanhthu()!=0||tk.getVon()!=0) {
                thongkelist.add(tk);
            }
        }
        for(ThongKeDTO thongke : thongkelist){
            model.addRow(new Object[] {thongke.getThoigian(),thongke.getVon(),thongke.getDoanhthu(),thongke.getLoinhuan()});
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource()==cboption) {
            sortoption();
        }
       
    }

    public void getData(int a,int b,String option){
        
        pnlcontent.remove(chart);
            this.chart = new Chart();

            this.chart.addLegend("Vốn", new Color(245, 189, 135));
            this.chart.addLegend("Doanh thu", new Color(135, 189, 245));
            this.chart.addLegend("Lợi nhuận", new Color(189, 135, 245));
            pnlcontent.add(chart);
            pnlcontent.repaint();
            pnlcontent.validate();
            model.setRowCount(0);
        if(option.equals("Năm")){
            ArrayList<ThongKeDTO> thongkelist = new ArrayList<>();
            for(int i=a;i<=b;i++){
                tk = new ThongKeDTO("Năm "+Integer.toString(i), 0,0,0);
                for(PhieuDTO phieu : phieulist){
                    if(phieu.getLoaiPhieu().equals("phieunhap")&&phieu.getNgayTao().contains('/'+Integer.toString(i))){
                        tk.setVon(tk.getVon()+Integer.parseInt(phieu.getDonGia()));
                    }else if(phieu.getLoaiPhieu().equals("phieuxuat")&&phieu.getNgayTao().contains('/'+Integer.toString(i))){
                        tk.setDoanhthu(tk.getDoanhthu()+Integer.parseInt(phieu.getDonGia()));
                        chitietphieulist = phieudetailbus.selectbyID(phieu.getMaPhieu(), "phieuxuat");
                        for(PhieuDetailDTO phieudetail : chitietphieulist){
                            ProductDetailDTO prd = productdetailbus.selectbyID(phieudetail.getMaSP(),phieudetail.getTenSP());
                            if(prd.getNgayXuat().contains('/'+Integer.toString(i))){
                                tk.setLoinhuan(tk.getLoinhuan()+(Integer.parseInt(prd.getGia())/10));
                            }
                        }
                    }
                }
                this.chart.addData(new ModelChart(tk.getThoigian(), new double[]{tk.getVon(), tk.getDoanhthu(), tk.getLoinhuan()}));   
                if (tk.getLoinhuan()!=0||tk.getDoanhthu()!=0||tk.getVon()!=0) {
                    thongkelist.add(tk);
                }
            }
            for(ThongKeDTO thongke : thongkelist){
                model.addRow(new Object[] {thongke.getThoigian(),thongke.getVon(),thongke.getDoanhthu(),thongke.getLoinhuan()});
            }
        }
        if(option.equals("Trong năm")){
            showdata(thang);
        }
        if(option.equals("Quý")){
            String thg = "";
            ArrayList<ThongKeDTO> thongkelist = new ArrayList<>();
                for(int i=(a*3)-2;i<=a*3;i++){
                if(i<10){
                    thg = "0"+Integer.toString(i);
                }
                else
                    thg = Integer.toString(i);
                tk = new ThongKeDTO("Tháng "+thg, 0,0,0);
                for(PhieuDTO phieu : phieulist){
                    if(phieu.getLoaiPhieu().equals("phieunhap")){
                        if(phieu.getNgayTao().contains('/'+thg+'/'+Integer.toString(b))){
                            tk.setVon(tk.getVon()+Integer.parseInt(phieu.getDonGia()));
                        }
                    }else if(phieu.getLoaiPhieu().equals("phieuxuat")){
                        if(phieu.getNgayTao().contains('/'+thg+'/'+Integer.toString(b))){
                            tk.setDoanhthu(tk.getDoanhthu()+Integer.parseInt(phieu.getDonGia()));
                            chitietphieulist = phieudetailbus.selectbyID(phieu.getMaPhieu(), "phieuxuat");
                            for(PhieuDetailDTO phieudetail : chitietphieulist){
                            ProductDetailDTO prd = productdetailbus.selectbyID(phieudetail.getMaSP(),phieudetail.getTenSP());
                            if(prd.getNgayXuat().contains('/'+thg+'/'+Integer.toString(b))){
                                tk.setLoinhuan(tk.getLoinhuan()+(Integer.parseInt(prd.getGia())/10));
                            }
                        }
                        }
                    }
                }
                this.chart.addData(new ModelChart(tk.getThoigian(), new double[]{tk.getVon(), tk.getDoanhthu(), tk.getLoinhuan()}));   
                if (tk.getLoinhuan()!=0||tk.getDoanhthu()!=0||tk.getVon()!=0) {
                    thongkelist.add(tk);
                }
            
            }
        for(ThongKeDTO thongke : thongkelist){
            model.addRow(new Object[] {thongke.getThoigian(),thongke.getVon(),thongke.getDoanhthu(),thongke.getLoinhuan()});
        }
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==lblshow){
            a = Integer.parseInt(cbquy.getSelectedItem().toString());
            b = Integer.parseInt(cbnam.getSelectedItem().toString());
            if(a>b){
                int i=a;
                a=b;
                b=i;
            }
            getData(a,b,cboption.getSelectedItem().toString());
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
        if(e.getSource()==lblshow){
            lblshow.setBackground(hover_clr);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==lblshow){
            lblshow.setBackground(main_clr);
        }
    }
    
}
