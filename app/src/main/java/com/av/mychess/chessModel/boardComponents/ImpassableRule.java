package com.av.mychess.chessModel.boardComponents;

import com.av.mychess.CommonStructs.PlayerColor;
import com.av.mychess.Interfaces.ModelInterfaces.ICellRule;

/**
 * This rule mark a cell as impassable for specific player.
 */
public class ImpassableRule implements ICellRule {
    private final PlayerColor color;

    public PlayerColor getColor() {
        return color;
    }

    public ImpassableRule(PlayerColor color){
        this.color = color;
    }

    @Override
    public boolean identical(ICellRule rule) {
        if(rule.getClass() == this.getClass()){
            if(((ImpassableRule) rule).color == color){
                return true;
            }
        }
        return false;
    }
}
