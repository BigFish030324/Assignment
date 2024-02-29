public class ARunCodeHere {
    
    static MainPage a;
    static PageAdmin b;
    static PageAdmin_Register c;
    static PageAdmin_Edit d;
    public static void main(String[] args) {
        a = new MainPage();
        b = new PageAdmin();
        c = new PageAdmin_Register();
        d = new PageAdmin_Edit();

        a.container.setVisible(true);
        b.container.setVisible(false);
        c.container.setVisible(false);
        d.container.setVisible(false);
    }    
}
