package controllers;

import entities.Bilety;
import controllers.util.JsfUtil;
import controllers.util.JsfUtil.PersistAction;
import entities.Klienci;
import facades.BiletyFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("biletyController")
@SessionScoped
public class BiletyController implements Serializable {
    
    
    @EJB
    private facades.BiletyFacade ejbFacade;
    private List<Bilety> items = null;
    private List<Bilety> items2 = null;
    private Bilety selected;

    public BiletyController() {
    }
    
    public List<Bilety> getItems2() {
        if (items2 == null) {
            items2 = getFacade().findByIdBiletu((Klienci)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id"));
        }
        System.out.println(items2.size());
        return items2;
    }
    
    public void onPageLoad(){
        items2 = getItems2();
    }

    public Bilety getSelected() {
        return selected;
    }

    public void setSelected(Bilety selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private BiletyFacade getFacade() {
        return ejbFacade;
    }

    public Bilety prepareCreate() {
        selected = new Bilety();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("BiletyCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("BiletyUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("BiletyDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Bilety> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Bilety getBilety(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Bilety> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Bilety> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }
    
    

    @FacesConverter(forClass = Bilety.class)
    public static class BiletyControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            BiletyController controller = (BiletyController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "biletyController");
            return controller.getBilety(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Bilety) {
                Bilety o = (Bilety) object;
                return getStringKey(o.getIdBiletu());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Bilety.class.getName()});
                return null;
            }
        }

    }

}
