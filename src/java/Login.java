
import entities.Klienci;
import entities.Pracownicy;
import entities.Przewoznicy;
import entities.Zwierzchnicy;
import facades.KlienciFacade;
import facades.PracownicyFacade;
import facades.PrzewoznicyFacade;
import facades.ZwierzchnicyFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("loginController")
@SessionScoped
public class Login implements Serializable{

    @EJB
    private KlienciFacade klienciFacade;

    @EJB
    private PrzewoznicyFacade przewoznicyFacade;

    @EJB
    private PracownicyFacade pracownicyFacade;

    @EJB
    private ZwierzchnicyFacade zwierzchnicyFacade;
    
    
    
    private String login;
    private String haslo;
    private int id;
    
    public String validate(){
        System.out.println("    wykonano !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! " + login + " " + haslo);
        List<Zwierzchnicy> list = zwierzchnicyFacade.findAll();
        for (Zwierzchnicy z : list) {
            if(login.equals(z.getLogin()) && haslo.equals(z.getHaslo())) {
                id = z.getIdZwierzchnika();
                return "/zwierzchnik/bilety/List.xhtml";
            }
        }
        List<Pracownicy> list2 = pracownicyFacade.findAll();
        for (Pracownicy p : list2) {
            if(login.equals(p.getLogin()) && haslo.equals(p.getHaslo())) {
                id = p.getIdPracownika();
                return "/pracownik/bilety/List.xhtml";
            }
        }
        List<Przewoznicy> list3 = przewoznicyFacade.findAll();
        for (Przewoznicy pr : list3) {
            if(login.equals(pr.getLogin()) && haslo.equals(pr.getHaslo())) {
                id = pr.getIdPrzewoznika();
                return "/przewoznik/loty/List.xhtml";
            }
        }
        List<Klienci> list4 = klienciFacade.findAll();
        for (Klienci k : list4) {
            if(login.equals(k.getLogin()) && haslo.equals(k.getHaslo())) {
                id = k.getIdKlienta();
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("id", k);
                return "/klient/bilety/List.xhtml";
            }
        }
        
        return "index";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
    
}
