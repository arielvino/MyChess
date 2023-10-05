package com.av.mychess.editor;

import androidx.lifecycle.ViewModel;

import com.av.mychess.CommonStructs.PlayerColor;
import com.av.mychess.CommonStructs.Vector2D;
import com.av.mychess.XmlFactory;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class EditorChessBoardViewModel extends ViewModel {
    private Vector2D dimensions;
    private EditorChessBoardFragment fragment;
    private ArrayList<ArrayList<EditorChessCellViewModel>> cells;

    @Nullable
    public EditorChessCellViewModel getCell(@NotNull Vector2D location) {
        return cells.get(location.getX()).get(location.getY());
    }

    @Nullable
    public Vector2D getDimensions() {
        return dimensions;
    }

    /**
     * This method is used for building entirely new table of cells in the viewModel, and as a sequences, in the view itself.
     * If you want to add or remove a specific row or column, or if you are looking for forcing the table into another size (which may include lose of cut off cells, and creation of whole empty ones) do not use this method.
     *
     * @param dimensions The size you want your board to be in.
     */
    public void initializeTable(@NotNull Vector2D dimensions) {
        this.dimensions = dimensions;
        cells = new ArrayList<>();
        for (int x = 0; x < dimensions.getX(); x++) {
            cells.add(new ArrayList<>());
            for (int y = 0; y < dimensions.getY(); y++) {
                cells.get(x).add(new EditorChessCellViewModel(this, new Vector2D(x, y)));
            }
        }

        //call the view's method:
        fragment.drawTable(dimensions);
    }

    public void connectToView(@NotNull EditorChessBoardFragment fragment) {
        this.fragment = fragment;
    }

    public Document exportAsXml() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            //board:
            Element board = document.createElement(XmlFactory.BOARD);
            board.setAttribute(XmlFactory.X, Integer.toString(dimensions.getX()));
            board.setAttribute(XmlFactory.Y, Integer.toString(dimensions.getY()));
            board.setAttribute(XmlFactory.VERSION, "1.0.0");
            document.appendChild(board);

            //pieces section:
            Element pieces = document.createElement(XmlFactory.PIECES);
            board.appendChild(pieces);

            //individual piece:
            for (int x = 0; x < dimensions.getX(); x++) {
                for (int y = 0; y < dimensions.getY(); y++) {
                    EditorChessCellViewModel cell = getCell(new Vector2D(x, y));
                    assert cell != null;
                    if (cell.getPiece() != null) {
                        Element piece = document.createElement(XmlFactory.PIECE);
                        piece.setAttribute(XmlFactory.NAME, cell.getPiece().getName());
                        piece.setAttribute(XmlFactory.COLOR, cell.getPiece().getColor() == PlayerColor.White ? XmlFactory.WHITE : XmlFactory.BLACK);
                        piece.setAttribute(XmlFactory.X, Integer.toString(cell.getLocation().getX()));
                        piece.setAttribute(XmlFactory.Y, Integer.toString(cell.getLocation().getY()));

                        //todo: set the rest of the attributes.

                        pieces.appendChild(piece);
                    }
                }
            }

            return document;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

}