public class ARunCodeHere {
    
    static MainPage a;

    static PageAdmin b;
    static PageAdmin_Register c;
    static PageAdmin_Edit d;
    static PageAdmin_Appointment e;
    static PageAdmin_Feedback f;
    static PageAdmin_Payment g;
    static RegisterSuccess h;
    static EditConfirmation i;

    static AboutUs j;

    public static void main(String[] args) {
        a = new MainPage();

        b = new PageAdmin();
        c = new PageAdmin_Register();
        d = new PageAdmin_Edit();
        e = new PageAdmin_Appointment();
        f = new PageAdmin_Feedback();
        g = new PageAdmin_Payment();
        h = new RegisterSuccess();
        i = new EditConfirmation();

        j = new AboutUs();



        MainPage.container.setVisible(true);

        PageAdmin.container.setVisible(false);
        PageAdmin_Register.container.setVisible(false);
        PageAdmin_Edit.container.setVisible(false);
        PageAdmin_Appointment.container.setVisible(false);
        PageAdmin_Feedback.container.setVisible(false);
        PageAdmin_Payment.container.setVisible(false);
        RegisterSuccess.container.setVisible(false);
        EditConfirmation.container.setVisible(false);

        AboutUs.container.setVisible(false);
    }    
}
