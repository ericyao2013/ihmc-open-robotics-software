package us.ihmc.simulationconstructionset.gui;

import us.ihmc.simulationconstructionset.gui.yoVariableSearch.YoVariablePanelTransferable;

import javax.swing.*;
import java.awt.datatransfer.Transferable;

@SuppressWarnings("serial")
public class YoGraphTransferHandler extends TransferHandler {
    public YoGraphTransferHandler() {

    }

    @Override
    public boolean canImport(TransferSupport transferSupport) {
        return false;
    }

    @Override
    public boolean importData(TransferHandler.TransferSupport transferSupport) {
        return false;
    }

    @Override
    public int getSourceActions(JComponent c) {
        if (c instanceof YoGraph) {
            return TransferHandler.COPY_OR_MOVE;
        } else if (c instanceof AddYoFilterPanel) {
            return TransferHandler.MOVE;
        }

        return TransferHandler.NONE;
    }

    @Override
    public Transferable createTransferable(JComponent c) {
        Transferable tip = null;

        if (c instanceof YoGraph) {
            tip = new YoVariablePanelTransferable();
        } else if (c instanceof AddYoFilterPanel) {
            tip = new YoFilterPanelTransferable();
        }

        return tip;
    }

    @Override
    public void exportDone(JComponent c, Transferable t, int action) {

    }
}
