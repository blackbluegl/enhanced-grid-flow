package com.vaadin.componentfactory.enhancedgrid;

import java.util.List;

import com.vaadin.componentfactory.enhancedgrid.bean.Person;
import com.vaadin.componentfactory.enhancedgrid.filtering.TextFilterField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

/**
 * Basic single selection grid example with setItems, editing, filtering, sorting and a custom filter icon.
 */
@Route(value = "dialog-example", layout = MainLayout.class)
public class DialogExampleView extends Div {

    public DialogExampleView() {

        add(new Paragraph("Opens the grid in a dialog"));

        Dialog dialog = new Dialog();
        EnhancedGrid<String> credits = new EnhancedGrid<>();
        credits.addColumn(o -> o).setHeader("col1", new TextFilterField());
        credits.setItems(List.of("data1", "data2"));
        credits.setFilterIcon(VaadinIcon.FILTER.create());
        dialog.add(credits);
        dialog.setWidth("800px");
        dialog.setWidth("600px");
        Button button = new Button("Open dialog", e -> dialog.open());
        add(button);
   
    }

}
