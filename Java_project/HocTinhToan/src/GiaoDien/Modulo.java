package GiaoDien;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Modulo extends JFrame implements ActionListener{
    private JButton btnClose;
    private JRadioButton radioBtnExp;
    private JRadioButton radioBtnInvert;
    private JRadioButton radioBtnDefault;
    private JButton btnTinh;
    private JButton btnXoa;
    private JTextField fieldExpression;
    private JTextField fieldExponent;
    private JTextField fieldModulus;
    private JTextArea areaKQ;
    private JLabel labelExpression;
    private JLabel labelExponent;
    private JLabel labelModulus;

    
    public Modulo() {
        setTitle("Tính Modulo");
        btnClose = new JButton("Close");
        labelExpression = new JLabel("Expression");
        labelExponent = new JLabel("Exponent");
        labelModulus = new JLabel("Modulus");
        btnTinh = new JButton("Tính");
        btnXoa = new JButton("Xóa");
        radioBtnExp = new JRadioButton("Exponent");
        radioBtnInvert = new JRadioButton("Invert");
        radioBtnDefault = new JRadioButton("Default", true);
        fieldExpression = new JTextField();
        fieldExponent = new JTextField();
        fieldModulus = new JTextField();
        areaKQ = new JTextArea();
        // chỉnh kích thước
        //expression
        labelExpression.setBounds(30,10,70,30);
        fieldExpression.setBounds(30,40,100,20);

        labelExponent.setBounds(145,10,70,30);
        fieldExponent.setBounds(145,40,100,20);

        //modulo
        labelModulus.setBounds(260,10,70,30);
        fieldModulus.setBounds(260,40,100,20);

        areaKQ.setBounds(30,100,330,120);

        btnTinh.setBounds(30,270, 90, 30);
        btnXoa.setBounds(150,270, 90, 30);
        //exit
        btnClose.setBounds(270, 270, 90, 30);
        btnClose.addActionListener(this);

        radioBtnDefault.setBounds(60, 70, 100, 30);

        radioBtnExp.setBounds(160, 70, 100, 30);

        radioBtnInvert.setBounds(280, 70, 100, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioBtnDefault);
        bg.add(radioBtnInvert);

        add(radioBtnDefault);
        add(radioBtnInvert);
        add(radioBtnExp);
        add(labelExpression);
        add(labelModulus);
        add(labelExponent);
        add(fieldExpression);
        add(fieldExponent);
        add(fieldModulus);
        add(areaKQ);
        add(btnTinh);
        add(btnXoa);
        add(btnClose);
        labelExponent.setVisible(false);
        fieldExponent.setVisible(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setSize(400,400);
        setVisible(false);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnClose) {
            setVisible(false);
        }
    }

    public JButton getBtnTinh() {
        return btnTinh;
    }

    public void setBtnTinh(JButton btnTinh) {
        this.btnTinh = btnTinh;
    }

    public JButton getBtnXoa() {
        return btnXoa;
    }

    public void setBtnXoa(JButton btnXoa) {
        this.btnXoa = btnXoa;
    }

    public void setFieldExpression(JTextField fieldExpression){
        this.fieldExpression = fieldExpression;
    }

    public JTextField getFieldExpression() {
        return fieldExpression;
    }

    public void setFieldModulus(JTextField fieldModulus){
        this.fieldModulus = fieldModulus;
    }

    public JTextField getFieldModulus() {
        return fieldModulus;
    }

    public void setAreaKQ(JTextArea areaKQ){
        this.areaKQ = areaKQ;
    }

    public JTextArea getAreaKQ() {
        return areaKQ;
    }

    public void setFieldExponent(JTextField fieldExponent){
        this.fieldExponent = fieldExponent;
    }

    public JTextField getFieldExponent() {
        return fieldExponent;
    }

    public void setRadioBtnExp(JRadioButton radioBtnExp){
        this.radioBtnExp = radioBtnExp;
    }

    public JRadioButton getRadioBtnExp() {
        return radioBtnExp;
    }

    public void setRadioBtnInvert(JRadioButton radioBtnInvert){
        this.radioBtnInvert = radioBtnInvert;
    }

    public JRadioButton getRadioBtnInvert() {
        return radioBtnInvert;
    }

    public void setRadioBtnDefault(JRadioButton radioBtnDefault){
        this.radioBtnDefault = radioBtnDefault;
    }

    public JRadioButton getRadioBtnDefault(){
        return radioBtnDefault;
    }

    public void setLabelExponent(JLabel labelExponent) {
        this.labelExponent = labelExponent;
    }

    public JLabel getLabelExponent() {
        return labelExponent;
    }
}