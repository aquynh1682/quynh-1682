package GiaoDien;

import javax.swing.JFrame;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Menu extends JFrame implements ActionListener {
    private MaTran formMaTran;
    private Modulo formModulo;
    private JButton btnMaTran;
    private JButton btnDaoHam;
    private JButton btnPTB2;
    private JButton btnModulo;
    private JButton btnHinhHoc;
    private JButton btnClose;

    public Menu(){
        //đặt tên và chính kích thước cho từng button
        setTitle("Hướng dẫn học toán");
        btnHinhHoc = new JButton("Hình học");
        btnDaoHam = new JButton("Đạo Hàm");
        btnPTB2 = new JButton("PT Bậc 2");
        btnModulo = new JButton("Modulo");
        btnMaTran = new JButton("Ma trận");
        btnClose = new JButton("Thoát");

        btnMaTran.setBounds(40, 40, 100, 30);
        btnHinhHoc.setBounds(180, 40, 100, 30);
        btnPTB2.setBounds(110, 110, 100, 30);
        btnDaoHam.setBounds(40, 180, 100, 30);
        btnModulo.setBounds(180, 180, 100, 30);
        btnClose.setBounds(110,260,100,30);


        formModulo = new Modulo();
        formMaTran = new MaTran();
        //đặt sự kiến cho từng button
        btnModulo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent modulo) {
                formModulo.setVisible(true);
                ModuloController controller = new ModuloController(formModulo);
                // setVisible(false);
            }
        });
        btnMaTran.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent matran) {
                formMaTran.setVisible(true);
                // setVisible(false);
            }
        });

        btnClose.addActionListener(this);
        //add các botton vào form
        add(btnHinhHoc);
        add(btnDaoHam);
        add(btnPTB2);
        add(btnModulo);
        add(btnMaTran);
        add(btnClose);

        setLayout(null);
        // setLocationRelativeTo là để form hiển thị tự nhảy ra màn hình chính
        setLocationRelativeTo(null);
        // setSize là chỉnh 340 chiều ngang và 300 chiều cao của form
        setSize(340, 340);
        // setVisible nếu nhập là true thì form sẽ hiển thị
        // nếu nhập là false thì fomr sẽ không hiển thị
        // setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == btnClose) {
            System.exit(0);
        }
    }

    // //test
    // public static void main(String[] args) {
    //     new Menu();
    // }

    // public void actionPerformed(ActionEvent modulo){
    //     if(modulo.getSource() == btnModulo) {
    //         formModulo.setVisible(true);
    //         setVisible(false);
    //     }
    // }
}
