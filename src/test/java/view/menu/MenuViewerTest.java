package view.menu;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.view.menu.MenuView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class MenuViewerTest {
    @Test
    public void menuViewerTest() {
        GUI gui = Mockito.mock(GUI.class);
        Menu menu = new Menu();

        MenuView viewer = new MenuView(menu);
        viewer.drawElements(gui);

        verify(gui).drawText(new Position(5,5),"Menu", "#FFFFFF");
        verify(gui).drawText(new Position(3,15),"Press Enter", "#FFFFFF");
        verify(gui).drawText(new Position(4,16),"to Select", "#FFFFFF");

        int num = menu.getNumberEntries();
        for(int i = 0; i < num; i++) {
            verify(gui).drawText(new Position(5, 7 + i),
                    viewer.getModel().getEntry(i),
                    viewer.getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }

    }
}
