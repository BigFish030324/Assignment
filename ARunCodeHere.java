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

    static PageTechnician j;
    static PageTechnician_Appointment k;
    static PageTechnician_Feedback l;
    static PageTechnician_Payment m;

    static PageCustomer n;
    static PageCustomer_Appointment o;
    static PageCustomer_Feedback p;
    static PageCustomer_Payment q;

    static AboutUs z;

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

        j = new PageTechnician();
        k = new PageTechnician_Appointment();
        l = new PageTechnician_Feedback();
        m = new PageTechnician_Payment();

        n = new PageCustomer();
        o = new PageCustomer_Appointment();
        p = new PageCustomer_Feedback();
        q = new PageCustomer_Payment();

        z = new AboutUs();



        MainPage.container.setVisible(true);

        PageAdmin.container.setVisible(false);
        PageAdmin_Register.container.setVisible(false);
        PageAdmin_Edit.container.setVisible(false);
        PageAdmin_Appointment.container.setVisible(false);
        PageAdmin_Feedback.container.setVisible(false);
        PageAdmin_Payment.container.setVisible(false);
        RegisterSuccess.container.setVisible(false);
        EditConfirmation.container.setVisible(false);

        PageTechnician.container.setVisible(false);
        PageTechnician_Appointment.container.setVisible(false);
        PageTechnician_Feedback.container.setVisible(false);
        PageTechnician_Payment.container.setVisible(false);

        PageCustomer.container.setVisible(false);
        PageCustomer_Appointment.container.setVisible(false);
        PageCustomer_Feedback.container.setVisible(false);
        PageCustomer_Payment.container.setVisible(false);

        AboutUs.container.setVisible(false);
    }    
}
