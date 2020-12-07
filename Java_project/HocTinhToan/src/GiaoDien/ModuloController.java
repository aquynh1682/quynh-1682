package GiaoDien;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import javax.swing.JComponent;
import java.util.Vector;


public class ModuloController implements ActionListener {
    private Modulo view;
    private long expre;
    private long exp;
    private long mod;
    //a^b mod p

    public ModuloController(Modulo view) {
        this.view = view;
        view.getBtnTinh().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent modulo) {
                if(view.getRadioBtnExp().isSelected()){
                    if(validateExpre() && validateExp() && validateMod()) {
                        view.getAreaKQ().setText(tinhModule(expre, exp, mod));
                    }else{
                        view.getAreaKQ().setText("");
                    }
                }else if(view.getRadioBtnInvert().isSelected()){
                    if(validateExpre() && validateMod()) {
                        view.getAreaKQ().setText(moduloInver(expre, mod));
                    }else{
                        view.getAreaKQ().setText("");
                    }
                }else{
                    if(validateExpre() && validateMod()) {
                        view.getAreaKQ().setText(notTinhExpression(expre, mod));
                    }else{
                        view.getAreaKQ().setText("");
                    }
                }
            }
        });

        view.getRadioBtnExp().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent btnExp) {
                if(view.getRadioBtnExp().isSelected()){
                    view.getFieldExponent().setVisible(true);
                    view.getLabelExponent().setVisible(true);
                    view.getRadioBtnInvert().setVisible(false);
                }
                else{
                    view.getFieldExponent().setVisible(false);
                    view.getLabelExponent().setVisible(false);
                    view.getRadioBtnInvert().setVisible(true);
                }
            }
        });

        view.getBtnXoa().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent xoa) {
                view.getFieldExpression().setText("");
                view.getFieldExponent().setText("");
                view.getFieldModulus().setText("");
                view.getAreaKQ().setText("");
            }
        });
        view.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }

    // public int GCD(int expre, int mod) {
    //     expre = Math.abs(expre);
    //     mod = Math.abs(mod);
    //     if(expre == 0 && mod == 0) return expre + mod;
    //     while(expre != mod){
    //         if(expre > mod) expre -= mod;
    //         else mod -= mod;
    //     }
    //     return expre;
    // }

    public static String moduloInver(long expre, long mod) {
        String result = null;
        if(expre > 0){
            if(mod > 0){
                expre %= mod;
                for(long i = 1; i < mod; i++)
                    if((expre * i) % mod == 1)
                        result = "" + i;
            }else
                result = "Modulo phải lớn hơn 0";
        }else
            result = "Số expression phải lớn hơn 0";
        return result;
    }

    public static String notTinhExpression(long expre, long mod){
        String result = null;
        if(expre > 0){
            if(mod > 0)
                result = "" + expre % mod;
            else   
                result = "Modulo phải lớn hơn 0";
        }else
            result = "Số expression phải lớn hơn 0";
        return result;
    }

    public static String tinhModule(long expre ,long exp , long mod) {
        String ketQua = null;
        long ret = 1;
        if(expre > 0) {
            if(mod > 0){
                expre %= mod;
                exp %= mod - 1;
                while(exp > 0) {
                    if(exp % 2 >0)
                        ret = ret * expre % mod;
                    expre = expre * expre % mod;
                    exp /= 2;
                    // ketQua = "expre: " + expre + "\n" + "exp: " + exp + "\n" + "tổng số mod: " + "\n" + ret;
                }
                ketQua = "\t" + ret;
            }else
                ketQua = "Số Modulo phải lớn hơn 0";
        }else
            ketQua = "Số Expression phải lớn hơn 0";  
        return ketQua;
    }

    public boolean validateExpre(){
        boolean valid = false;
        try{
            if(!"".equals(view.getFieldExpression().getText())) {
                expre = Long.parseLong(view.getFieldExpression().getText());
                valid = true;
            }else {
                JOptionPane.showMessageDialog(view, "Expression không được để trống");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Expression không hợp lệ");
        }
        return valid;
    }

    public boolean validateExp(){
        boolean valid = false;
        try {
            if(!"".equals(view.getFieldExponent().getText())) {
                exp = Long.parseLong(view.getFieldExponent().getText());
                valid = true;
            }else {
                JOptionPane.showMessageDialog(view, "Exponent Không được để trống");
            }
        } catch(NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Exponent không hợp lệ");
        }
        return valid;
    }

    public boolean validateMod(){
        boolean valid = false;
        try{
            if(!"".equals(view.getFieldModulus().getText())){
                mod = Integer.parseInt(view.getFieldModulus().getText());
                valid = true;
            } else{
                JOptionPane.showMessageDialog(view, "Modulus không được để trống");
            }
        }catch(NumberFormatException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Moduluss không hợp lệ");
        }
        return valid;
    }

    public void actionPerformed(ActionEvent e) {
        // if(validateExpre() && validateExp() && validateMod()) {
        //     view.getAreaKQ().setText(tinhModule(expre, exp, mod));
        // }else{
        //     view.getAreaKQ().setText("");
        // }
    }

    public void setView(Modulo view){
        this.view = view;
    }

    public Modulo getView() {
        return view;
    }
}
