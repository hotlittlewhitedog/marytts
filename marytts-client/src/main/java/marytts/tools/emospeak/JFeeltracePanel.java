/**
 * Copyright 2000-2006 DFKI GmbH.
 * All Rights Reserved.  Use is subject to license terms.
 *
 * This file is part of MARY TTS.
 *
 * MARY TTS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package marytts.tools.emospeak;

import java.awt.Graphics;

import javax.swing.BoundedRangeModel;
import javax.swing.JPanel;

/**
 * 
 * @author Marc Schr&ouml;der
 */
public class JFeeltracePanel extends JPanel {

	private boolean showPower = true;

	public boolean showPower() {
		return showPower;
	}

	public void setShowPower(boolean showPower) {
		this.showPower = showPower;
	}

	public TwoDimensionalModel feeltraceModel() {
		return jFeeltraceCircle1.getNormalizedModel();
	}

	private BoundedRangeModel powerModel = new javax.swing.DefaultBoundedRangeModel(0, 0, -100, 100);

	public BoundedRangeModel powerModel() {
		return powerModel;
	}

	/** Creates new form JFeeltracePanel */
	public JFeeltracePanel(boolean showPower) {
		this.showPower = showPower;
		initComponents();
		customInitComponents();
	}

	/** Creates new form JFeeltracePanel */
	public JFeeltracePanel() {
		initComponents();
		customInitComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of
	 * this method is always regenerated by the Form Editor.
	 */
	private void initComponents() {// GEN-BEGIN:initComponents
		java.awt.GridBagConstraints gridBagConstraints;

		slPower = new javax.swing.JSlider();
		lMaxPower = new javax.swing.JLabel();
		lMinPower = new javax.swing.JLabel();
		lMaxActivation = new javax.swing.JLabel();
		lMinEvaluation = new javax.swing.JLabel();
		lMaxEvaluation = new javax.swing.JLabel();
		lMinActivation = new javax.swing.JLabel();
		jFeeltraceCircle1 = new JFeeltraceCircle();

		setLayout(new java.awt.GridBagLayout());

		setPreferredSize(new java.awt.Dimension(500, 350));
		slPower.setMinimum(-100);
		slPower.setOrientation(javax.swing.JSlider.VERTICAL);
		slPower.setValue(0);
		slPower.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				slPowerStateChanged(evt);
			}
		});

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 5;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
		add(slPower, gridBagConstraints);

		lMaxPower.setText("very dominant");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 5;
		gridBagConstraints.gridy = 0;
		add(lMaxPower, gridBagConstraints);

		lMinPower.setText("very submissive");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 5;
		gridBagConstraints.gridy = 2;
		add(lMinPower, gridBagConstraints);

		lMaxActivation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lMaxActivation.setText("very active");
		lMaxActivation.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
		lMaxActivation.setAlignmentX(0.5F);
		lMaxActivation.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
		add(lMaxActivation, gridBagConstraints);

		lMinEvaluation.setText("<html>very<br>negative</html>");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		add(lMinEvaluation, gridBagConstraints);

		lMaxEvaluation.setText("<html>very<br>positive</html>");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 1;
		add(lMaxEvaluation, gridBagConstraints);

		lMinActivation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lMinActivation.setText("very passive");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 3;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
		add(lMinActivation, gridBagConstraints);

		jFeeltraceCircle1.setFont(new java.awt.Font("Dialog", 0, 11));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 0.1;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
		add(jFeeltraceCircle1, gridBagConstraints);

	}// GEN-END:initComponents

	private void slPowerStateChanged(javax.swing.event.ChangeEvent evt) {// GEN-FIRST:event_slPowerStateChanged
		powerModel.setValue(slPower.getValue());
	}// GEN-LAST:event_slPowerStateChanged

	private void customInitComponents() {
		verifyPowerVisible();
		feeltraceModel().addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent e) {
				updateFeeltraceDisplays();
			}
		});
		if (showPower) {
			powerModel.addChangeListener(new javax.swing.event.ChangeListener() {
				public void stateChanged(javax.swing.event.ChangeEvent e) {
					updatePowerDisplays();
				}
			});
		}
	}

	protected void paintComponent(Graphics graphics) {
		verifyPowerVisible();
		super.paintComponent(graphics);
	}

	public void verifyPowerVisible() {
		lMaxPower.setVisible(showPower);
		lMinPower.setVisible(showPower);
		slPower.setVisible(showPower);
	}

	private void updateFeeltraceDisplays() {
	}

	private void updatePowerDisplays() {
		slPower.setValue(powerModel.getValue());
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel lMinActivation;
	private javax.swing.JLabel lMaxEvaluation;
	private javax.swing.JSlider slPower;
	private javax.swing.JLabel lMinEvaluation;
	private javax.swing.JLabel lMinPower;
	private javax.swing.JLabel lMaxActivation;
	private javax.swing.JLabel lMaxPower;
	private JFeeltraceCircle jFeeltraceCircle1;
	// End of variables declaration//GEN-END:variables

}
