package com.av.mychess.chessModel.boardComponents;

import com.av.mychess.CommonStructs.PlayerColor;
import com.av.mychess.Interfaces.ModelInterfaces.ICellRule;

public class CapturingNotAllowedRule implements ICellRule {
    private final PlayerColor color;

    public PlayerColor getColor() {
        return color;
    }

    public CapturingNotAllowedRule(PlayerColor color){
        this.color = color;
    }

    @Override
    public boolean identical(ICellRule rule) {
        if(rule.getClass() == this.getClass()){
            if(((CapturingNotAllowedRule) rule).color == color){
                return true;
            }
        }
        return false;
    }
}
