public class ARunCodeHere {
    
    static MainPage a;
    static PageAdmin b;
    static PageAdmin_Register c;
    static PageAdmin_Edit d;
    static RegisterSuccess e;
    public static void main(String[] args) {
        a = new MainPage();
        b = new PageAdmin();
        c = new PageAdmin_Register();
        d = new PageAdmin_Edit();
        e = new RegisterSuccess();

        a.container.setVisible(true);
        PageAdmin.container.setVisible(false);
        PageAdmin_Register.container.setVisible(false);
        PageAdmin_Edit.container.setVisible(false);
        RegisterSuccess.container.setVisible(false);
    }    
}
