package pl.edu.agh.dronka.shop.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import pl.edu.agh.dronka.shop.controller.ShopController;
import pl.edu.agh.dronka.shop.model.filter.ItemFilter;

public class PropertiesPanel extends JPanel {

	private static final long serialVersionUID = -2804446079853846996L;
	private ShopController shopController;

	private ItemFilter filter = new ItemFilter();

	public PropertiesPanel(ShopController shopController) {
		this.shopController = shopController;
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}

	public void fillProperties() {
		removeAll();

		filter.getItemSpec().setCategory(shopController.getCurrentCategory());
		add(createPropertyCheckbox("Tanie bo polskie", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				filter.getItemSpec().setPolish(
						((JCheckBox) event.getSource()).isSelected());
				shopController.filterItems(filter);
			}
		}));

		add(createPropertyCheckbox("Używany", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				filter.getItemSpec().setSecondhand(
						((JCheckBox) event.getSource()).isSelected());
				shopController.filterItems(filter);
			}
		}));

		switch(shopController.getCurrentCategory()){
			case BOOKS:
				filter.getItemSpec().setCategory(shopController.getCurrentCategory());
				add(createPropertyCheckbox("Okładka twarda jak ultraliski", new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						filter.setPropertyValue("HardCover",
								((JCheckBox) event.getSource()).isSelected());
						shopController.filterItems(filter);
					}
				}));
				break;
			case MUSIC:
				filter.getItemSpec().setCategory(shopController.getCurrentCategory());
				add(createPropertyCheckbox("Dołączone wideo", new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						filter.setPropertyValue("VideoIncluded",
								((JCheckBox) event.getSource()).isSelected());
						shopController.filterItems(filter);
					}
				}));
				break;
			case ELECTRONICS:
				filter.getItemSpec().setCategory(shopController.getCurrentCategory());
				add(createPropertyCheckbox("Gwarancja", new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						filter.setPropertyValue("Warranty",
								((JCheckBox) event.getSource()).isSelected());
						shopController.filterItems(filter);
					}
				}));
				filter.getItemSpec().setCategory(shopController.getCurrentCategory());
				add(createPropertyCheckbox("Mobilny", new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						filter.setPropertyValue("Mobile",
								((JCheckBox) event.getSource()).isSelected());
						shopController.filterItems(filter);
					}
				}));
		}
	}

	private JCheckBox createPropertyCheckbox(String propertyName,
			ActionListener actionListener) {

		JCheckBox checkBox = new JCheckBox(propertyName);
		checkBox.setSelected(false);
		checkBox.addActionListener(actionListener);

		return checkBox;
	}

}
