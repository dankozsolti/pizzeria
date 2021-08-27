package hu.ulyssys.pizzeria.mbean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class SelectManyView {

    private List<String> selectedOptions;

    public List<String> getSelectedOptions() {
        return selectedOptions;    }

    public void setSelectedOptions(List<String> selectedOptions) {
        this.selectedOptions = selectedOptions;
    }
}
