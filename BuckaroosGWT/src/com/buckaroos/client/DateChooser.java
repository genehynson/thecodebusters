package com.buckaroos.client;

import java.util.Calendar;
import java.util.Date;

import com.buckaroos.shared.UserAccountController;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DatePicker;

public class DateChooser extends Composite {

	private static DateChooserUiBinder uiBinder = GWT
			.create(DateChooserUiBinder.class);

	interface DateChooserUiBinder extends UiBinder<Widget, DateChooser> {
	}

	private DatePicker datePicker;
	private Button bContinue;
    private Calendar cal;
    private Date today;
    private int currentYear;
    private int currentMonth;
    private int currentDay;

	public DateChooser() {
		initWidget(uiBinder.createAndBindUi(this));
		datePicker = new DatePicker();
		today = new Date();
        cal = Calendar.getInstance();
        cal.setTime(today);
        currentYear = cal.get(Calendar.YEAR);
        currentMonth = cal.get(Calendar.MONTH);
        currentDay = cal.get(Calendar.DAY_OF_MONTH);
        
        UserAccountController.setTheDate(today);
        
        bContinue.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				RootPanel.get("").add(new Reports());
			}
		});
		
		datePicker.addValueChangeHandler(new ValueChangeHandler<Date>() {
		      public void onValueChange(ValueChangeEvent<Date> event) {
		          Date date = event.getValue();
		          UserAccountController.setTheDate(date);
		        }
		      });
		}
}
