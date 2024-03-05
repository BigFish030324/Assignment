public class ARunCodeHere {
    
    static MainPage a;
    static PageAdmin b;
    static PageAdmin_Register c;
    static PageAdmin_Edit d;
    // static PageAdmin_Appointment e;
    static RegisterSuccess f;
    static EditConfirmation g;
    static AboutUs h;

    public static void main(String[] args) {
        a = new MainPage();
        b = new PageAdmin();
        c = new PageAdmin_Register();
        d = new PageAdmin_Edit();
        // e = new PageAdmin_Appointment();
        f = new RegisterSuccess();
        g = new EditConfirmation();
        h = new AboutUs();

        MainPage.container.setVisible(true);
        PageAdmin.container.setVisible(false);
        PageAdmin_Register.container.setVisible(false);
        PageAdmin_Edit.container.setVisible(false);
        // PageAdmin_Appointment.container.setVisible(false);
        RegisterSuccess.container.setVisible(false);
        EditConfirmation.container.setVisible(false);
        AboutUs.container.setVisible(false);// dont know why i they AboutUs cant run, so put g as it works
    }    
}
