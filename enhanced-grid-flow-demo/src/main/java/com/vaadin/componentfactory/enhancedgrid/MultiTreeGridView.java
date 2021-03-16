package com.vaadin.componentfactory.enhancedgrid;

import com.vaadin.componentfactory.enhancedgrid.bean.Department;
import com.vaadin.componentfactory.enhancedgrid.bean.DepartmentData;
import com.vaadin.componentfactory.enhancedtreegrid.EnhancedTreeGrid;
import com.vaadin.flow.component.grid.Grid.Column;
import com.vaadin.flow.component.grid.Grid.SelectionMode;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route(value = "multi-tree", layout = MainLayout.class)
public class MultiTreeGridView extends Div {

	 public MultiTreeGridView() {
		Div messageDiv = new Div(); 
		 
		DepartmentData departmentData = new DepartmentData();
    	EnhancedTreeGrid<Department> grid = new EnhancedTreeGrid<>();
    	grid.setSelectionFilter(d -> d.getName().startsWith("T"));
    	
    	grid.setSelectionMode(SelectionMode.MULTI);
    	
    	grid.asMultiSelect().addValueChangeListener(event -> {
            String message = String.format("Selection changed from %s to %s",
                event.getOldValue(), event.getValue());
            messageDiv.setText(message);
        });
    	
		grid.setItems(departmentData.getRootDepartments(),
		        departmentData::getChildDepartments);
		grid.addHierarchyColumn(Department::getName)
		        .setHeader("Department Name");
		Column<Department> managerColumn = grid.addColumn(Department::getManager).setHeader("Manager");				
		managerColumn.setSortable(true);		
		
		add(grid, messageDiv);
	 }
	
}
